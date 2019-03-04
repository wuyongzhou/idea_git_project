package Test;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test<T extends Serializable, PK extends Serializable>implements TestInterface<T,PK> {
    private Class<T> entityClass;

    public Test(){
        this.entityClass = null;
        Class c = getClass();
        System.out.println(c);
        System.out.println(c.getSuperclass());
        Type t = c.getGenericSuperclass();
        System.out.println(t);
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<T>) p[0];
        }
    }

}
