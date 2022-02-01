package external.org.apache.commons.lang3.reflect;

import external.org.apache.commons.lang3.ArrayUtils;
import external.org.apache.commons.lang3.ClassUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodUtils
{
  public static Method getAccessibleMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass = getAccessibleMethod(paramClass.getMethod(paramString, paramVarArgs));
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  public static Method getAccessibleMethod(Method paramMethod)
  {
    if (!MemberUtils.isAccessible(paramMethod)) {
      localMethod = null;
    }
    Class localClass;
    do
    {
      return localMethod;
      localClass = paramMethod.getDeclaringClass();
      localMethod = paramMethod;
    } while (Modifier.isPublic(localClass.getModifiers()));
    String str = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Method localMethod = getAccessibleMethodFromInterfaceNest(localClass, str, arrayOfClass);
    paramMethod = localMethod;
    if (localMethod == null) {
      paramMethod = getAccessibleMethodFromSuperclass(localClass, str, arrayOfClass);
    }
    return paramMethod;
  }
  
  private static Method getAccessibleMethodFromInterfaceNest(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    Object localObject1 = null;
    Object localObject2 = paramClass;
    paramClass = (Class<?>)localObject1;
    Class[] arrayOfClass;
    int i;
    if (localObject2 != null)
    {
      arrayOfClass = ((Class)localObject2).getInterfaces();
      i = 0;
      for (;;)
      {
        localObject1 = paramClass;
        if (i >= arrayOfClass.length) {
          break label74;
        }
        if (Modifier.isPublic(arrayOfClass[i].getModifiers())) {
          break;
        }
        label46:
        i += 1;
      }
    }
    try
    {
      localObject1 = arrayOfClass[i].getDeclaredMethod(paramString, paramVarArgs);
      paramClass = (Class<?>)localObject1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label67:
      break label67;
    }
    if (paramClass != null) {
      localObject1 = paramClass;
    }
    for (;;)
    {
      label74:
      localObject2 = ((Class)localObject2).getSuperclass();
      paramClass = (Class<?>)localObject1;
      break;
      localObject1 = getAccessibleMethodFromInterfaceNest(arrayOfClass[i], paramString, paramVarArgs);
      paramClass = (Class<?>)localObject1;
      if (localObject1 == null) {
        break label46;
      }
    }
    return paramClass;
  }
  
  private static Method getAccessibleMethodFromSuperclass(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    Object localObject2 = null;
    for (paramClass = paramClass.getSuperclass();; paramClass = paramClass.getSuperclass())
    {
      Object localObject1 = localObject2;
      if ((paramClass == null) || (Modifier.isPublic(paramClass.getModifiers()))) {}
      try
      {
        localObject1 = paramClass.getMethod(paramString, paramVarArgs);
        return localObject1;
      }
      catch (NoSuchMethodException paramClass) {}
    }
    return null;
  }
  
  public static Method getMatchingAccessibleMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      Method localMethod1 = paramClass.getMethod(paramString, paramVarArgs);
      MemberUtils.setAccessibleWorkaround(localMethod1);
      paramString = localMethod1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      do
      {
        Method[] arrayOfMethod = paramClass.getMethods();
        int j = arrayOfMethod.length;
        int i = 0;
        Object localObject;
        for (paramClass = null; i < j; paramClass = (Class<?>)localObject)
        {
          Method localMethod2 = arrayOfMethod[i];
          localObject = paramClass;
          if (localMethod2.getName().equals(paramString))
          {
            localObject = paramClass;
            if (ClassUtils.isAssignable(paramVarArgs, localMethod2.getParameterTypes(), true))
            {
              localMethod2 = getAccessibleMethod(localMethod2);
              localObject = paramClass;
              if (localMethod2 != null) {
                if (paramClass != null)
                {
                  localObject = paramClass;
                  if (MemberUtils.compareParameterTypes(localMethod2.getParameterTypes(), paramClass.getParameterTypes(), paramVarArgs) >= 0) {}
                }
                else
                {
                  localObject = localMethod2;
                }
              }
            }
          }
          i += 1;
        }
        paramString = paramClass;
      } while (paramClass == null);
      MemberUtils.setAccessibleWorkaround(paramClass);
    }
    return paramString;
    return paramClass;
  }
  
  public static Object invokeExactMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    Object[] arrayOfObject = paramVarArgs;
    if (paramVarArgs == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    int j = arrayOfObject.length;
    paramVarArgs = new Class[j];
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i] = arrayOfObject[i].getClass();
      i += 1;
    }
    return invokeExactMethod(paramObject, paramString, arrayOfObject, paramVarArgs);
  }
  
  public static Object invokeExactMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    paramArrayOfObject = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      paramArrayOfObject = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfObject = getAccessibleMethod(paramObject.getClass(), paramString, paramArrayOfObject);
    if (paramArrayOfObject == null) {
      throw new NoSuchMethodException("No such accessible method: " + paramString + "() on object: " + paramObject.getClass().getName());
    }
    return paramArrayOfObject.invoke(paramObject, arrayOfObject);
  }
  
  public static Object invokeExactStaticMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    Object[] arrayOfObject = paramVarArgs;
    if (paramVarArgs == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    int j = arrayOfObject.length;
    paramVarArgs = new Class[j];
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i] = arrayOfObject[i].getClass();
      i += 1;
    }
    return invokeExactStaticMethod(paramClass, paramString, arrayOfObject, paramVarArgs);
  }
  
  public static Object invokeExactStaticMethod(Class<?> paramClass, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    paramArrayOfObject = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      paramArrayOfObject = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfObject = getAccessibleMethod(paramClass, paramString, paramArrayOfObject);
    if (paramArrayOfObject == null) {
      throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass.getName());
    }
    return paramArrayOfObject.invoke(null, arrayOfObject);
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    Object[] arrayOfObject = paramVarArgs;
    if (paramVarArgs == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    int j = arrayOfObject.length;
    paramVarArgs = new Class[j];
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i] = arrayOfObject[i].getClass();
      i += 1;
    }
    return invokeMethod(paramObject, paramString, arrayOfObject, paramVarArgs);
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    Object localObject = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      localObject = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfClass = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramArrayOfClass = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    paramArrayOfObject = getMatchingAccessibleMethod(paramObject.getClass(), paramString, (Class[])localObject);
    if (paramArrayOfObject == null) {
      throw new NoSuchMethodException("No such accessible method: " + paramString + "() on object: " + paramObject.getClass().getName());
    }
    return paramArrayOfObject.invoke(paramObject, paramArrayOfClass);
  }
  
  public static Object invokeStaticMethod(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    Object[] arrayOfObject = paramVarArgs;
    if (paramVarArgs == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    int j = arrayOfObject.length;
    paramVarArgs = new Class[j];
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i] = arrayOfObject[i].getClass();
      i += 1;
    }
    return invokeStaticMethod(paramClass, paramString, arrayOfObject, paramVarArgs);
  }
  
  public static Object invokeStaticMethod(Class<?> paramClass, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    Object localObject = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      localObject = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfClass = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramArrayOfClass = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    paramArrayOfObject = getMatchingAccessibleMethod(paramClass, paramString, (Class[])localObject);
    if (paramArrayOfObject == null) {
      throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass.getName());
    }
    return paramArrayOfObject.invoke(null, paramArrayOfClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.reflect.MethodUtils
 * JD-Core Version:    0.7.0.1
 */