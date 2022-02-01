package com.tencent.mobileqq.utils.kapalaiadapter;

import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ServiceManager
{
  private static Class<?> a;
  private static Method b;
  private static Method c;
  private static Method d;
  private static Method e;
  
  static
  {
    try
    {
      a = Class.forName("android.os.ServiceManager");
      b = a.getDeclaredMethod("getService", new Class[] { String.class });
      c = a.getDeclaredMethod("addService", new Class[] { String.class, IBinder.class });
      d = a.getDeclaredMethod("checkService", new Class[] { String.class });
      e = a.getDeclaredMethod("listServices", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
  
  public static IBinder a(String paramString)
  {
    return (IBinder)a(b, new Object[] { paramString });
  }
  
  private static Object a(Method paramMethod, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(null, paramVarArgs);
      return paramMethod;
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramMethod)
    {
      paramMethod.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramMethod)
    {
      paramMethod.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.ServiceManager
 * JD-Core Version:    0.7.0.1
 */