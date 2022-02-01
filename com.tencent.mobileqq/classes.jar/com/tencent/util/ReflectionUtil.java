package com.tencent.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil
{
  private static Method a;
  private static Method b;
  private static Method c;
  
  static
  {
    try
    {
      a = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
      b = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
      c = Class.class.getDeclaredMethod("getDeclaredField", new Class[] { String.class });
      return;
    }
    catch (Throwable localThrowable)
    {
      label63:
      break label63;
    }
    QLog.e("ReflectionUtil", 1, "init throw t");
  }
  
  @NonNull
  public static Object a(@NonNull Object paramObject1, @NonNull String paramString1, @NonNull String paramString2, @NonNull Object paramObject2)
  {
    if (a()) {
      try
      {
        paramString1 = (Class)a.invoke(null, new Object[] { paramString1 });
        paramString1 = (Field)c.invoke(paramString1, new Object[] { paramString2 });
        paramString1.setAccessible(true);
        paramObject1 = paramString1.get(paramObject1);
        return paramObject1;
      }
      catch (Throwable paramObject1)
      {
        Log.e("ReflectionUtil", "getFiled throw t", paramObject1);
      }
    }
    return paramObject2;
  }
  
  public static Object a(@NonNull Object paramObject, @NonNull String paramString1, @NonNull String paramString2, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (a()) {
      try
      {
        paramString1 = (Class)a.invoke(null, new Object[] { paramString1 });
        paramString1 = (Method)b.invoke(paramString1, new Object[] { paramString2, paramArrayOfClass });
        paramString1.setAccessible(true);
        paramObject = paramString1.invoke(paramObject, paramVarArgs);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        Log.e("ReflectionUtil", "invokeMethod throw t", paramObject);
      }
    }
    return null;
  }
  
  @Nullable
  public static Field a(@NonNull String paramString1, @NonNull String paramString2)
  {
    boolean bool = a();
    String str = null;
    Object localObject = null;
    if (bool)
    {
      try
      {
        paramString1 = (Class)a.invoke(null, new Object[] { paramString1 });
        paramString1 = (Field)c.invoke(paramString1, new Object[] { paramString2 });
        try
        {
          paramString1.setAccessible(true);
          return paramString1;
        }
        catch (Throwable paramString2) {}
        Log.e("ReflectionUtil", "getFiled throw t", paramString2);
      }
      catch (Throwable paramString2)
      {
        paramString1 = localObject;
      }
      str = paramString1;
    }
    return str;
  }
  
  @Nullable
  public static Method a(@NonNull String paramString1, @NonNull String paramString2, Class[] paramArrayOfClass)
  {
    boolean bool = a();
    String str = null;
    Object localObject = null;
    if (bool)
    {
      try
      {
        paramString1 = (Class)a.invoke(null, new Object[] { paramString1 });
        paramString1 = (Method)b.invoke(paramString1, new Object[] { paramString2, paramArrayOfClass });
        try
        {
          paramString1.setAccessible(true);
          return paramString1;
        }
        catch (Throwable paramString2) {}
        Log.e("ReflectionUtil", "getMethod throw t", paramString2);
      }
      catch (Throwable paramString2)
      {
        paramString1 = localObject;
      }
      str = paramString1;
    }
    return str;
  }
  
  public static void a(@NonNull Object paramObject1, @NonNull String paramString1, @NonNull String paramString2, Object paramObject2)
  {
    if (a()) {
      try
      {
        paramString1 = (Class)a.invoke(null, new Object[] { paramString1 });
        paramString1 = (Field)c.invoke(paramString1, new Object[] { paramString2 });
        paramString1.setAccessible(true);
        paramString1.set(paramObject1, paramObject2);
        return;
      }
      catch (Throwable paramObject1)
      {
        Log.e("ReflectionUtil", "setFiled throw t", paramObject1);
      }
    }
  }
  
  private static boolean a()
  {
    return (a != null) && (b != null) && (c != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.ReflectionUtil
 * JD-Core Version:    0.7.0.1
 */