package com.tencent.qapmsdk.looper;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GetStackRunnable
  implements Runnable
{
  private static final int BUILDER_SIZE = 1024;
  private static final int MAX_STACK_DEPTH = 100;
  private static final int MAX_STACK_LENGTH = 30000;
  private static final int MAX_STACK_TIME_SPAN = 500;
  private static final int MAX_TIME_SPAN = 100000;
  private static final String TAG = "QAPM_looper_GetStackRunnable";
  private static final int TIME_TOLERANCE = 10;
  private static final int WAIT_MORE_BEFORE_STACK = 200;
  private static final String WHITE_LIST = "android.support.v4.";
  @Nullable
  private static Handler handler;
  @NonNull
  private StringBuilder builder = new StringBuilder(1024);
  private int checkInterval = PluginCombination.loopStackPlugin.threshold;
  private Object dropFrameInstance = null;
  private Field dropFrameSceneField = null;
  private int randomRange;
  private ArrayList<String> stackStorage;
  private final String[] systemStackElementPrefix = { "java.", "android.", "com.android.", "dalvik.", "com.google", "libcore.", "sun.", "com.qihoo360.", "com.lbe." };
  private Thread watchingThread;
  
  GetStackRunnable(Thread paramThread)
  {
    int j = this.checkInterval;
    this.randomRange = (500 - j);
    int i = this.randomRange;
    if (i <= 0) {
      i = j * 4;
    }
    this.randomRange = i;
    this.stackStorage = new ArrayList(100);
    this.watchingThread = paramThread;
    handler = new Handler(ThreadManager.getStackThreadLooper());
  }
  
  private String getDropFrameScene()
  {
    try
    {
      if ((this.dropFrameInstance == null) && (this.dropFrameSceneField == null))
      {
        Object localObject2 = Class.forName("com.tencent.qapmsdk.dropframe.DropFrameMonitor");
        localObject1 = ((Class)localObject2).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        localObject2 = ((Class)localObject2).getDeclaredField("currentScene");
        ((Field)localObject2).setAccessible(true);
        this.dropFrameInstance = localObject1;
        this.dropFrameSceneField = ((Field)localObject2);
      }
      Object localObject1 = String.valueOf(this.dropFrameSceneField.get(this.dropFrameInstance));
      return localObject1;
    }
    catch (Exception localException)
    {
      label78:
      break label78;
    }
    Logger.INSTANCE.w(new String[] { "QAPM_looper_GetStackRunnable", "get dropFrame scene may be error" });
    return "";
  }
  
  private String getStack(boolean paramBoolean)
  {
    for (;;)
    {
      int k;
      try
      {
        this.stackStorage.clear();
        localObject = this.watchingThread.getStackTrace();
        if (localObject == null) {
          return null;
        }
        if (!paramBoolean) {
          break label245;
        }
        return Arrays.toString((Object[])localObject);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        String str;
        String[] arrayOfString;
        int m;
        Logger.INSTANCE.exception("QAPM_looper_GetStackRunnable", localThrowable);
      }
      if (k < localObject.length)
      {
        str = localObject[k].toString();
        arrayOfString = this.systemStackElementPrefix;
        m = arrayOfString.length;
        j = 0;
        if (j >= m) {
          break label265;
        }
        if (!str.startsWith(arrayOfString[j])) {
          break label258;
        }
        if (str.startsWith("android.support.v4."))
        {
          break label265;
          this.stackStorage.add(str);
          break label291;
        }
      }
      else
      {
        if (this.stackStorage.size() > 0)
        {
          this.builder.setLength(0);
          i = this.stackStorage.size() - 1;
          if ((i >= 0) && (i > this.stackStorage.size() - 1 - 100) && (this.builder.length() < 30000))
          {
            localObject = this.builder;
            ((StringBuilder)localObject).append((String)this.stackStorage.get(i));
            ((StringBuilder)localObject).append(",");
            i -= 1;
            continue;
          }
          if (this.builder.length() > 0)
          {
            localObject = this.builder.toString();
            return localObject;
          }
          return null;
        }
        return null;
        label245:
        k = 0;
        i = 0;
        continue;
      }
      int j = 1;
      break label267;
      label258:
      j += 1;
      continue;
      label265:
      j = 0;
      label267:
      if (j != 0)
      {
        j = i;
        if (i == 0) {}
      }
      else
      {
        j = i;
        if (i != 0) {
          continue;
        }
        j = 1;
        continue;
      }
      label291:
      k += 1;
      int i = j;
    }
  }
  
  private void onThreadMonitorEnd(MonitorInfo paramMonitorInfo)
  {
    try
    {
      paramMonitorInfo.stackGetter = null;
      paramMonitorInfo.stackGetterInited = false;
      paramMonitorInfo.callback.onMonitorEnd();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    Object localObject = (MonitorInfo)LooperMonitor.monitorMap.get(this.watchingThread.getName());
    if (localObject == null) {
      return;
    }
    if (!PluginController.INSTANCE.canCollect(PluginCombination.loopStackPlugin.plugin))
    {
      onThreadMonitorEnd((MonitorInfo)localObject);
      return;
    }
    if ((((MonitorInfo)localObject).callback != null) && (((MonitorInfo)localObject).lastForceTime != 0L) && (((MonitorInfo)localObject).callback.onAfterStack(((MonitorInfo)localObject).lastForceTime))) {
      ((MonitorInfo)localObject).lastForceTime = 0L;
    }
    localObject = new GetStackRunnable.Step1Runnable(this, handler, (MonitorInfo)localObject);
    handler.postDelayed((Runnable)localObject, this.checkInterval);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.GetStackRunnable
 * JD-Core Version:    0.7.0.1
 */