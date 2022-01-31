import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class slh
{
  public static Set<Class<?>> a = Collections.synchronizedSet(new HashSet());
  
  public static <T> Class<T> a(Class<?> paramClass)
  {
    return paramClass;
  }
  
  public static <I> I a(Class<I> paramClass)
  {
    if (paramClass.isInterface())
    {
      ClassLoader localClassLoader = slh.class.getClassLoader();
      sli localsli = new sli();
      return Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, localsli);
    }
    throw new IllegalArgumentException(paramClass.getName() + " should be an interface!", new Throwable());
  }
  
  public static <T> T a(Class<T> paramClass, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass1 = a(paramArrayOfObject);
    if (arrayOfClass1 == null) {}
    Constructor localConstructor;
    for (int j = 0;; j = arrayOfClass1.length)
    {
      Constructor[] arrayOfConstructor;
      try
      {
        localConstructor = paramClass.getConstructor(arrayOfClass1);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        arrayOfConstructor = paramClass.getConstructors();
        if (arrayOfConstructor != null) {
          break;
        }
      }
      try
      {
        paramArrayOfObject = paramClass.cast(localConstructor.newInstance(paramArrayOfObject));
        return paramArrayOfObject;
      }
      catch (InstantiationException paramArrayOfObject)
      {
        int k;
        Class[] arrayOfClass2;
        throw new IllegalStateException(paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ajjy.a(2131641891), paramArrayOfObject);
      }
      catch (IllegalAccessException paramArrayOfObject)
      {
        throw new IllegalStateException(paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ajjy.a(2131641892), paramArrayOfObject);
      }
      catch (InvocationTargetException paramArrayOfObject)
      {
        throw new IllegalArgumentException(paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ") InvocationTargetException", paramArrayOfObject);
      }
    }
    for (k = 0;; k = arrayOfConstructor.length)
    {
      int m = 0;
      for (;;)
      {
        if (m >= k) {
          break label494;
        }
        localConstructor = arrayOfConstructor[m];
        arrayOfClass2 = localConstructor.getParameterTypes();
        if (j == arrayOfClass2.length) {
          break;
        }
        label88:
        m += 1;
      }
    }
    int i = 0;
    label107:
    if (i < j) {
      if (arrayOfClass1[i] == null)
      {
        if (!arrayOfClass2[i].isPrimitive()) {
          break label293;
        }
        i = 0;
        if (i == 0) {
          break label492;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        label131:
        if (localConstructor != null) {
          break label300;
        }
        throw new IllegalStateException(ajjy.a(2131641890) + paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ajjy.a(2131641893), localNoSuchMethodException);
        if (arrayOfClass2[i].isPrimitive()) {
          if (arrayOfClass1[i] == null)
          {
            i = 0;
            break;
          }
        }
        try
        {
          Class localClass = (Class)arrayOfClass1[i].getField("TYPE").get(null);
          boolean bool = arrayOfClass2[i].equals(localClass);
          if (!bool) {
            i = 0;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          if (!arrayOfClass2[i].isAssignableFrom(arrayOfClass1[i])) {
            i = 0;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          for (;;)
          {
            localNoSuchFieldException.printStackTrace();
          }
        }
      }
      label293:
      i += 1;
      break label107;
      label300:
      urk.e("NullableObjectFactoryImplement", "虽然不是直接匹配, 但是还是找到了" + paramClass.getName() + "(" + Arrays.toString(arrayOfClass1) + ")的构造函数");
      break;
      i = 1;
      break label131;
      label492:
      break label88;
      label494:
      localConstructor = null;
    }
  }
  
  public static Class<?>[] a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return null;
    }
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      if (paramArrayOfObject[i] == null) {}
      for (Class localClass = null;; localClass = paramArrayOfObject[i].getClass())
      {
        arrayOfClass[i] = localClass;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     slh
 * JD-Core Version:    0.7.0.1
 */