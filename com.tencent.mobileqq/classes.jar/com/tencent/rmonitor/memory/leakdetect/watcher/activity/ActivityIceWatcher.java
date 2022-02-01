package com.tencent.rmonitor.memory.leakdetect.watcher.activity;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.os.Build.VERSION;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ActivityIceWatcher
  extends BaseActivityWatcher
{
  private static Instrumentation c;
  private static Object d;
  private static Field e;
  private boolean b = false;
  
  public ActivityIceWatcher(MemoryLeakInspector paramMemoryLeakInspector)
  {
    super(paramMemoryLeakInspector);
  }
  
  private boolean a(Instrumentation paramInstrumentation)
  {
    try
    {
      if ((e != null) && (d != null))
      {
        e.set(d, paramInstrumentation);
        return true;
      }
    }
    catch (IllegalAccessException paramInstrumentation)
    {
      Logger.b.a("RMonitor_memory_ActivityIceWatcher", paramInstrumentation);
    }
    return false;
  }
  
  private boolean e()
  {
    boolean bool2 = this.b;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((e == null) || (d == null)) {
      f();
    }
    if (a(new ActivityIceWatcher.MonitorInstrumentation(this, null)))
    {
      this.b = true;
      bool1 = true;
    }
    return bool1;
  }
  
  @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
  private void f()
  {
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
      ((Method)localObject).setAccessible(true);
      d = ((Method)localObject).invoke(null, new Object[0]);
      if (d != null)
      {
        localObject = d.getClass().getDeclaredField("mInstrumentation");
        ((Field)localObject).setAccessible(true);
        localObject = (Instrumentation)((Field)localObject).get(d);
        if (localObject != null)
        {
          if (localObject.getClass().equals(Instrumentation.class))
          {
            if (!localObject.getClass().equals(ActivityIceWatcher.MonitorInstrumentation.class))
            {
              c = (Instrumentation)localObject;
              e = d.getClass().getDeclaredField("mInstrumentation");
              e.setAccessible(true);
              return;
            }
            throw new RuntimeException("Buddy you already hacked the system.");
          }
          throw new IllegalStateException("Not an Instrumentation instance. Maybe something is modified in this system.");
        }
        throw new IllegalStateException("Failed to get mInstrumentation.");
      }
      throw new IllegalStateException("Failed to invoke currentActivityThread");
    }
    catch (Exception localException)
    {
      Logger.b.a("RMonitor_memory_ActivityIceWatcher", localException);
    }
  }
  
  public boolean a()
  {
    return e();
  }
  
  public void b()
  {
    if ((c != null) && (c()))
    {
      a(c);
      this.b = false;
    }
  }
  
  public boolean c()
  {
    return Build.VERSION.SDK_INT < 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.activity.ActivityIceWatcher
 * JD-Core Version:    0.7.0.1
 */