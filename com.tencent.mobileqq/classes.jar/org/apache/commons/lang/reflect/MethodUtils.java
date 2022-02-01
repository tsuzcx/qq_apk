package org.apache.commons.lang.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;

public class MethodUtils
{
  public static Method getAccessibleMethod(Class paramClass1, String paramString, Class paramClass2)
  {
    return getAccessibleMethod(paramClass1, paramString, new Class[] { paramClass2 });
  }
  
  public static Method getAccessibleMethod(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      paramClass = getAccessibleMethod(paramClass.getMethod(paramString, paramArrayOfClass));
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  public static Method getAccessibleMethod(Method paramMethod)
  {
    if (!MemberUtils.isAccessible(paramMethod)) {
      return null;
    }
    Class localClass = paramMethod.getDeclaringClass();
    if (Modifier.isPublic(localClass.getModifiers())) {
      return paramMethod;
    }
    String str = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Method localMethod = getAccessibleMethodFromInterfaceNest(localClass, str, arrayOfClass);
    paramMethod = localMethod;
    if (localMethod == null) {
      paramMethod = getAccessibleMethodFromSuperclass(localClass, str, arrayOfClass);
    }
    return paramMethod;
  }
  
  private static Method getAccessibleMethodFromInterfaceNest(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    Class localClass = paramClass;
    for (paramClass = (Class)localObject; localClass != null; paramClass = (Class)localObject)
    {
      Class[] arrayOfClass = localClass.getInterfaces();
      int i = 0;
      for (;;)
      {
        localObject = paramClass;
        if ((i >= arrayOfClass.length) || (Modifier.isPublic(arrayOfClass[i].getModifiers()))) {}
        try
        {
          localObject = arrayOfClass[i].getDeclaredMethod(paramString, paramArrayOfClass);
          paramClass = (Class)localObject;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          label63:
          break label63;
        }
        if (paramClass != null)
        {
          localObject = paramClass;
          break;
        }
        localObject = getAccessibleMethodFromInterfaceNest(arrayOfClass[i], paramString, paramArrayOfClass);
        paramClass = (Class)localObject;
        if (localObject != null) {
          break;
        }
        i += 1;
      }
      localClass = localClass.getSuperclass();
    }
    return paramClass;
  }
  
  private static Method getAccessibleMethodFromSuperclass(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    for (paramClass = paramClass.getSuperclass();; paramClass = paramClass.getSuperclass())
    {
      if ((paramClass == null) || (Modifier.isPublic(paramClass.getModifiers()))) {}
      try
      {
        paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
        return paramClass;
      }
      catch (NoSuchMethodException paramClass) {}
    }
    return null;
    return null;
  }
  
  public static Method getMatchingAccessibleMethod(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      localObject = paramClass.getMethod(paramString, paramArrayOfClass);
      MemberUtils.setAccessibleWorkaround((AccessibleObject)localObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Object localObject;
      label16:
      Method[] arrayOfMethod;
      int i;
      int j;
      break label16;
    }
    localObject = null;
    arrayOfMethod = paramClass.getMethods();
    i = 0;
    j = arrayOfMethod.length;
    for (paramClass = (Class)localObject; i < j; paramClass = (Class)localObject)
    {
      localObject = paramClass;
      if (arrayOfMethod[i].getName().equals(paramString))
      {
        localObject = paramClass;
        if (ClassUtils.isAssignable(paramArrayOfClass, arrayOfMethod[i].getParameterTypes(), true))
        {
          Method localMethod = getAccessibleMethod(arrayOfMethod[i]);
          localObject = paramClass;
          if (localMethod != null) {
            if (paramClass != null)
            {
              localObject = paramClass;
              if (MemberUtils.compareParameterTypes(localMethod.getParameterTypes(), paramClass.getParameterTypes(), paramArrayOfClass) >= 0) {}
            }
            else
            {
              localObject = localMethod;
            }
          }
        }
      }
      i += 1;
    }
    if (paramClass != null) {
      MemberUtils.setAccessibleWorkaround(paramClass);
    }
    return paramClass;
  }
  
  public static Object invokeExactMethod(Object paramObject1, String paramString, Object paramObject2)
  {
    return invokeExactMethod(paramObject1, paramString, new Object[] { paramObject2 });
  }
  
  public static Object invokeExactMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    int j = arrayOfObject.length;
    paramArrayOfObject = new Class[j];
    int i = 0;
    while (i < j)
    {
      paramArrayOfObject[i] = arrayOfObject[i].getClass();
      i += 1;
    }
    return invokeExactMethod(paramObject, paramString, arrayOfObject, paramArrayOfObject);
  }
  
  public static Object invokeExactMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
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
    if (paramArrayOfObject != null) {
      return paramArrayOfObject.invoke(paramObject, arrayOfObject);
    }
    paramArrayOfObject = new StringBuffer();
    paramArrayOfObject.append("No such accessible method: ");
    paramArrayOfObject.append(paramString);
    paramArrayOfObject.append("() on object: ");
    paramArrayOfObject.append(paramObject.getClass().getName());
    throw new NoSuchMethodException(paramArrayOfObject.toString());
  }
  
  public static Object invokeExactStaticMethod(Class paramClass, String paramString, Object paramObject)
  {
    return invokeExactStaticMethod(paramClass, paramString, new Object[] { paramObject });
  }
  
  public static Object invokeExactStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    int j = arrayOfObject.length;
    paramArrayOfObject = new Class[j];
    int i = 0;
    while (i < j)
    {
      paramArrayOfObject[i] = arrayOfObject[i].getClass();
      i += 1;
    }
    return invokeExactStaticMethod(paramClass, paramString, arrayOfObject, paramArrayOfObject);
  }
  
  public static Object invokeExactStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
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
    if (paramArrayOfObject != null) {
      return paramArrayOfObject.invoke(null, arrayOfObject);
    }
    paramArrayOfObject = new StringBuffer();
    paramArrayOfObject.append("No such accessible method: ");
    paramArrayOfObject.append(paramString);
    paramArrayOfObject.append("() on class: ");
    paramArrayOfObject.append(paramClass.getName());
    throw new NoSuchMethodException(paramArrayOfObject.toString());
  }
  
  public static Object invokeMethod(Object paramObject1, String paramString, Object paramObject2)
  {
    return invokeMethod(paramObject1, paramString, new Object[] { paramObject2 });
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    int j = arrayOfObject.length;
    paramArrayOfObject = new Class[j];
    int i = 0;
    while (i < j)
    {
      paramArrayOfObject[i] = arrayOfObject[i].getClass();
      i += 1;
    }
    return invokeMethod(paramObject, paramString, arrayOfObject, paramArrayOfObject);
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Class[] arrayOfClass = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      arrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfClass = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramArrayOfClass = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    paramArrayOfObject = getMatchingAccessibleMethod(paramObject.getClass(), paramString, arrayOfClass);
    if (paramArrayOfObject != null) {
      return paramArrayOfObject.invoke(paramObject, paramArrayOfClass);
    }
    paramArrayOfObject = new StringBuffer();
    paramArrayOfObject.append("No such accessible method: ");
    paramArrayOfObject.append(paramString);
    paramArrayOfObject.append("() on object: ");
    paramArrayOfObject.append(paramObject.getClass().getName());
    throw new NoSuchMethodException(paramArrayOfObject.toString());
  }
  
  public static Object invokeStaticMethod(Class paramClass, String paramString, Object paramObject)
  {
    return invokeStaticMethod(paramClass, paramString, new Object[] { paramObject });
  }
  
  public static Object invokeStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    int j = arrayOfObject.length;
    paramArrayOfObject = new Class[j];
    int i = 0;
    while (i < j)
    {
      paramArrayOfObject[i] = arrayOfObject[i].getClass();
      i += 1;
    }
    return invokeStaticMethod(paramClass, paramString, arrayOfObject, paramArrayOfObject);
  }
  
  public static Object invokeStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Class[] arrayOfClass = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      arrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfClass = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramArrayOfClass = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    paramArrayOfObject = getMatchingAccessibleMethod(paramClass, paramString, arrayOfClass);
    if (paramArrayOfObject != null) {
      return paramArrayOfObject.invoke(null, paramArrayOfClass);
    }
    paramArrayOfObject = new StringBuffer();
    paramArrayOfObject.append("No such accessible method: ");
    paramArrayOfObject.append(paramString);
    paramArrayOfObject.append("() on class: ");
    paramArrayOfObject.append(paramClass.getName());
    throw new NoSuchMethodException(paramArrayOfObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.reflect.MethodUtils
 * JD-Core Version:    0.7.0.1
 */