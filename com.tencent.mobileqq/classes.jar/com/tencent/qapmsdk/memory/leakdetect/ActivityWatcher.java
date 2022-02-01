package com.tencent.qapmsdk.memory.leakdetect;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Instrumentation;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActivityWatcher
{
  private static final String TAG = "QAPM_memory_ActivityWatcher";
  @Nullable
  private static Object sCurrentActivityThread;
  private static boolean sMonitoring = false;
  @Nullable
  private static Instrumentation sOldInstr;
  
  private static void afterOnDestroy(@NonNull Activity paramActivity)
  {
    ActivityLeakSolution.fixInputMethodManagerLeak(paramActivity);
    ActivityLeakSolution.fixAudioManagerLeak(paramActivity);
    try
    {
      if (!PluginController.INSTANCE.canCollect(PluginCombination.leakPlugin.plugin)) {
        return;
      }
      LeakInspector.startInspect(paramActivity, "");
      return;
    }
    catch (Exception paramActivity)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", paramActivity);
    }
  }
  
  private static boolean replaceInstrumentation()
  {
    if (sMonitoring) {
      return false;
    }
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
      ((Method)localObject).setAccessible(true);
      sCurrentActivityThread = ((Method)localObject).invoke(null, new Object[] { null });
      if (sCurrentActivityThread != null)
      {
        localObject = sCurrentActivityThread.getClass().getDeclaredField("mInstrumentation");
        ((Field)localObject).setAccessible(true);
        localObject = (Instrumentation)((Field)localObject).get(sCurrentActivityThread);
        if (localObject != null)
        {
          if (localObject.getClass().equals(Instrumentation.class))
          {
            if (!localObject.getClass().equals(ActivityWatcher.MonitorInstrumentation.class))
            {
              sOldInstr = (Instrumentation)localObject;
              localObject = sCurrentActivityThread.getClass().getDeclaredField("mInstrumentation");
              ((Field)localObject).setAccessible(true);
              ((Field)localObject).set(sCurrentActivityThread, new ActivityWatcher.MonitorInstrumentation(null));
              sMonitoring = true;
              return true;
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
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localException);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localNoSuchFieldException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localInvocationTargetException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localIllegalAccessException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localIllegalArgumentException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localNoSuchMethodException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Logger.INSTANCE.exception("QAPM_memory_ActivityWatcher", localClassNotFoundException);
    }
    return false;
  }
  
  @TargetApi(14)
  public static boolean startActivityInspect()
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      LifecycleCallback.INSTANCE.register(new ActivityWatcher.1());
      return true;
    }
    return replaceInstrumentation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.ActivityWatcher
 * JD-Core Version:    0.7.0.1
 */