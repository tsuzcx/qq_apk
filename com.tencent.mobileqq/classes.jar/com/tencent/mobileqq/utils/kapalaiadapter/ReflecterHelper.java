package com.tencent.mobileqq.utils.kapalaiadapter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ReflecterHelper
{
  public static Object a(Object paramObject, String paramString)
  {
    return a(paramObject, paramString, null);
  }
  
  public static Object a(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    paramString = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
    paramString.setAccessible(true);
    return paramString.invoke(paramObject, paramArrayOfObject);
  }
  
  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    return a(paramObject, paramString, a(paramArrayOfObject), paramArrayOfObject);
  }
  
  public static Object a(String paramString1, Object paramObject, String paramString2)
  {
    paramString1 = Class.forName(paramString1).getDeclaredField(paramString2);
    paramString1.setAccessible(true);
    return paramString1.get(paramObject);
  }
  
  public static Object a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, (Object[])null);
  }
  
  public static Object a(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    return a(paramString1, paramString2, paramArrayOfObject, a(paramArrayOfObject));
  }
  
  public static Object a(String paramString1, String paramString2, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    paramString1 = Class.forName(paramString1);
    return paramString1.getDeclaredMethod(paramString2, paramArrayOfClass).invoke(paramString1, paramArrayOfObject);
  }
  
  private static Class<?>[] a(Object[] paramArrayOfObject)
  {
    Object localObject = (Class[])null;
    if (paramArrayOfObject != null)
    {
      Class[] arrayOfClass = new Class[paramArrayOfObject.length];
      int i = 0;
      int j = paramArrayOfObject.length;
      for (;;)
      {
        localObject = arrayOfClass;
        if (i >= j) {
          break;
        }
        if (paramArrayOfObject[i] != null) {
          arrayOfClass[i] = paramArrayOfObject[i].getClass();
        } else {
          arrayOfClass[i] = String.class;
        }
        if (arrayOfClass[i] == Integer.class) {
          arrayOfClass[i] = Integer.TYPE;
        } else if (arrayOfClass[i] == Boolean.class) {
          arrayOfClass[i] = Boolean.TYPE;
        }
        i += 1;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper
 * JD-Core Version:    0.7.0.1
 */