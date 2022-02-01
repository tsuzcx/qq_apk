package com.tencent.mobileqq.javahook;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@TargetApi(11)
public class ThreadPoolExecutorMonitor
{
  private static Map<Runnable, ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult> jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private static Set<Class> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  private static String b(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof FutureTask)) {}
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 17)
      {
        localObject1 = FutureTask.class.getDeclaredField("callable");
        ((Field)localObject1).setAccessible(true);
        localObject2 = (Callable)((Field)localObject1).get(paramRunnable);
      }
      else
      {
        if (Build.VERSION.SDK_INT < 15) {
          break label185;
        }
        localObject1 = FutureTask.class.getDeclaredField("sync");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(paramRunnable);
        localObject2 = Class.forName("java.util.concurrent.FutureTask$Sync").getDeclaredField("callable");
        ((Field)localObject2).setAccessible(true);
        localObject2 = (Callable)((Field)localObject2).get(localObject1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Class localClass;
        continue;
        Object localObject2 = null;
      }
    }
    if (localObject2 != null)
    {
      localClass = Class.forName("java.util.concurrent.Executors$RunnableAdapter");
      localObject1 = localObject2;
      if (!localClass.isInstance(localObject2)) {
        break label164;
      }
      localObject1 = localClass.getDeclaredField("task");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (Runnable)((Field)localObject1).get(localObject2);
      break label164;
      if ((paramRunnable instanceof Job))
      {
        localObject1 = ((Job)paramRunnable).mJob;
        break label164;
      }
    }
    localObject1 = null;
    label164:
    if (localObject1 != null) {
      paramRunnable = (Runnable)localObject1;
    }
    return paramRunnable.getClass().getName();
  }
  
  private static void b(Class paramClass)
  {
    c(paramClass);
    d(paramClass);
    e(paramClass);
  }
  
  private static void b(Runnable paramRunnable, ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult paramThreadPoolExecutorMonitorResult)
  {
    if (QLog.isColorLevel())
    {
      paramRunnable = new StringBuilder();
      paramRunnable.append("ThreadPoolExecutor Log : ");
      paramRunnable.append("runnable class = ");
      paramRunnable.append(paramThreadPoolExecutorMonitorResult.jdField_a_of_type_JavaLangString);
      paramRunnable.append(" ; ");
      paramRunnable.append("thread name = ");
      paramRunnable.append(paramThreadPoolExecutorMonitorResult.jdField_b_of_type_JavaLangString);
      paramRunnable.append(" ; ");
      paramRunnable.append("wait time = ");
      paramRunnable.append(paramThreadPoolExecutorMonitorResult.jdField_b_of_type_Long - paramThreadPoolExecutorMonitorResult.jdField_a_of_type_Long);
      paramRunnable.append(" ; ");
      paramRunnable.append("run() cost time = ");
      paramRunnable.append(paramThreadPoolExecutorMonitorResult.c - paramThreadPoolExecutorMonitorResult.jdField_b_of_type_Long);
      paramRunnable.append(" ; ");
      QLog.d("ThreadPoolExecutorMonitor", 2, paramRunnable.toString());
    }
  }
  
  private static void c(Class paramClass)
  {
    try
    {
      JavaHookBridge.findAndHookMethod(paramClass, "execute", new Object[] { Runnable.class, new ThreadPoolExecutorMonitor.2() });
      return;
    }
    catch (NoSuchMethodException paramClass) {}
  }
  
  private static void d(Class paramClass)
  {
    try
    {
      JavaHookBridge.findAndHookMethod(paramClass, "beforeExecute", new Object[] { Thread.class, Runnable.class, new ThreadPoolExecutorMonitor.3() });
      return;
    }
    catch (NoSuchMethodException paramClass) {}
  }
  
  private static void e(Class paramClass)
  {
    try
    {
      JavaHookBridge.findAndHookMethod(paramClass, "afterExecute", new Object[] { Runnable.class, Throwable.class, new ThreadPoolExecutorMonitor.4() });
      return;
    }
    catch (NoSuchMethodException paramClass) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor
 * JD-Core Version:    0.7.0.1
 */