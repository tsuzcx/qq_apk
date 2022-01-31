package com.tencent.tvkbeacon.core.c;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class e
{
  public static int a(String paramString1, Object paramObject, String paramString2)
  {
    try
    {
      Field localField = Class.forName(paramString1).getDeclaredField(paramString2);
      localField.setAccessible(true);
      int i = localField.getInt(paramObject);
      return i;
    }
    catch (Exception paramObject)
    {
      c.d("[core] ref get %s.%s failed.", new Object[] { paramString1, paramString2 });
    }
    return -1;
  }
  
  public static Object a(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.invoke(null, paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      c.d("[core] ref call %s#%s failed.", new Object[] { paramString1, paramString2 });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.c.e
 * JD-Core Version:    0.7.0.1
 */