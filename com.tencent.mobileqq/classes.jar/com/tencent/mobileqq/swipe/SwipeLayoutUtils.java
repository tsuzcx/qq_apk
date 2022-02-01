package com.tencent.mobileqq.swipe;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SwipeLayoutUtils
{
  private static boolean a;
  private static boolean b;
  private static Method c;
  private static Class<?> d;
  private static Method e;
  
  public static void a(Activity paramActivity)
  {
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramActivity, new Object[0]);
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  public static void a(Activity paramActivity, InvocationHandler paramInvocationHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b(paramActivity, paramInvocationHandler);
      return;
    }
    b(paramActivity);
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    b();
    return b;
  }
  
  @RequiresApi(api=16)
  private static void b()
  {
    if (a) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        c = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
        c.setAccessible(true);
        Class[] arrayOfClass = Activity.class.getDeclaredClasses();
        d = null;
        int j = arrayOfClass.length;
        i = 0;
        if (i < j)
        {
          Class localClass = arrayOfClass[i];
          if (!localClass.getSimpleName().contains("TranslucentConversionListener")) {
            break label133;
          }
          d = localClass;
          break label133;
        }
        e = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { d, ActivityOptions.class });
        e.setAccessible(true);
        b = true;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwipeLayoutUtils", 2, localThrowable, new Object[0]);
        }
      }
      a = true;
      return;
      label133:
      i += 1;
    }
  }
  
  public static void b(Activity paramActivity)
  {
    for (;;)
    {
      int i;
      try
      {
        Class[] arrayOfClass = Activity.class.getDeclaredClasses();
        int j = arrayOfClass.length;
        Object localObject = null;
        i = 0;
        if (i < j)
        {
          Class localClass = arrayOfClass[i];
          if (localClass.getSimpleName().contains("TranslucentConversionListener")) {
            localObject = localClass;
          }
        }
        else
        {
          localObject = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject });
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramActivity, new Object[] { null });
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        return;
      }
      i += 1;
    }
  }
  
  @RequiresApi(api=16)
  private static void b(Activity paramActivity, InvocationHandler paramInvocationHandler)
  {
    
    try
    {
      Object localObject = c.invoke(paramActivity, new Object[0]);
      Class localClass = d;
      paramInvocationHandler = Proxy.newProxyInstance(d.getClassLoader(), new Class[] { localClass }, paramInvocationHandler);
      e.invoke(paramActivity, new Object[] { paramInvocationHandler, localObject });
      return;
    }
    catch (Throwable paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.swipe.SwipeLayoutUtils
 * JD-Core Version:    0.7.0.1
 */