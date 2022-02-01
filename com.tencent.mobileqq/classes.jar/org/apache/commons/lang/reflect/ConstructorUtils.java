package org.apache.commons.lang.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;

public class ConstructorUtils
{
  public static Constructor getAccessibleConstructor(Class paramClass1, Class paramClass2)
  {
    return getAccessibleConstructor(paramClass1, new Class[] { paramClass2 });
  }
  
  public static Constructor getAccessibleConstructor(Class paramClass, Class[] paramArrayOfClass)
  {
    try
    {
      paramClass = getAccessibleConstructor(paramClass.getConstructor(paramArrayOfClass));
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  public static Constructor getAccessibleConstructor(Constructor paramConstructor)
  {
    if ((MemberUtils.isAccessible(paramConstructor)) && (Modifier.isPublic(paramConstructor.getDeclaringClass().getModifiers()))) {
      return paramConstructor;
    }
    return null;
  }
  
  public static Constructor getMatchingAccessibleConstructor(Class paramClass, Class[] paramArrayOfClass)
  {
    try
    {
      localObject = paramClass.getConstructor(paramArrayOfClass);
      MemberUtils.setAccessibleWorkaround((AccessibleObject)localObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Object localObject;
      label12:
      Constructor[] arrayOfConstructor;
      int i;
      break label12;
    }
    localObject = null;
    arrayOfConstructor = paramClass.getConstructors();
    i = 0;
    for (paramClass = (Class)localObject; i < arrayOfConstructor.length; paramClass = (Class)localObject)
    {
      localObject = paramClass;
      if (ClassUtils.isAssignable(paramArrayOfClass, arrayOfConstructor[i].getParameterTypes(), true))
      {
        Constructor localConstructor = getAccessibleConstructor(arrayOfConstructor[i]);
        localObject = paramClass;
        if (localConstructor != null)
        {
          MemberUtils.setAccessibleWorkaround(localConstructor);
          if (paramClass != null)
          {
            localObject = paramClass;
            if (MemberUtils.compareParameterTypes(localConstructor.getParameterTypes(), paramClass.getParameterTypes(), paramArrayOfClass) >= 0) {}
          }
          else
          {
            localObject = localConstructor;
          }
        }
      }
      i += 1;
    }
    return paramClass;
  }
  
  public static Object invokeConstructor(Class paramClass, Object paramObject)
  {
    return invokeConstructor(paramClass, new Object[] { paramObject });
  }
  
  public static Object invokeConstructor(Class paramClass, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    paramArrayOfObject = new Class[arrayOfObject.length];
    int i = 0;
    while (i < arrayOfObject.length)
    {
      paramArrayOfObject[i] = arrayOfObject[i].getClass();
      i += 1;
    }
    return invokeConstructor(paramClass, arrayOfObject, paramArrayOfObject);
  }
  
  public static Object invokeConstructor(Class paramClass, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Class[] arrayOfClass = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      arrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfClass = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramArrayOfClass = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    paramArrayOfObject = getMatchingAccessibleConstructor(paramClass, arrayOfClass);
    if (paramArrayOfObject != null) {
      return paramArrayOfObject.newInstance(paramArrayOfClass);
    }
    paramArrayOfObject = new StringBuffer();
    paramArrayOfObject.append("No such accessible constructor on object: ");
    paramArrayOfObject.append(paramClass.getName());
    throw new NoSuchMethodException(paramArrayOfObject.toString());
  }
  
  public static Object invokeExactConstructor(Class paramClass, Object paramObject)
  {
    return invokeExactConstructor(paramClass, new Object[] { paramObject });
  }
  
  public static Object invokeExactConstructor(Class paramClass, Object[] paramArrayOfObject)
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
    return invokeExactConstructor(paramClass, arrayOfObject, paramArrayOfObject);
  }
  
  public static Object invokeExactConstructor(Class paramClass, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      arrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
    }
    paramArrayOfObject = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      paramArrayOfObject = ArrayUtils.EMPTY_CLASS_ARRAY;
    }
    paramArrayOfObject = getAccessibleConstructor(paramClass, paramArrayOfObject);
    if (paramArrayOfObject != null) {
      return paramArrayOfObject.newInstance(arrayOfObject);
    }
    paramArrayOfObject = new StringBuffer();
    paramArrayOfObject.append("No such accessible constructor on object: ");
    paramArrayOfObject.append(paramClass.getName());
    throw new NoSuchMethodException(paramArrayOfObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.reflect.ConstructorUtils
 * JD-Core Version:    0.7.0.1
 */