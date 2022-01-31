package com.tencent.qapmsdk.looper;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
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
  private int randomRange = 500 - this.checkInterval;
  private ArrayList<String> stackStorage;
  private final String[] systemStackElementPrefix = { "java.", "android.", "com.android.", "dalvik.", "com.google", "libcore.", "sun.", "com.qihoo360.", "com.lbe." };
  private Thread watchingThread;
  
  GetStackRunnable(Thread paramThread)
  {
    if (this.randomRange > 0) {}
    for (int i = this.randomRange;; i = this.checkInterval * 4)
    {
      this.randomRange = i;
      this.stackStorage = new ArrayList(100);
      this.watchingThread = paramThread;
      handler = new Handler(ThreadManager.getStackThreadLooper());
      return;
    }
  }
  
  private String getStack(boolean paramBoolean)
  {
    for (;;)
    {
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
        if (j < m)
        {
          if (!str.startsWith(arrayOfString[j])) {
            break label271;
          }
          if (!str.startsWith("android.support.v4.")) {
            break label266;
          }
          j = 0;
          break label253;
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
            this.builder.append((String)this.stackStorage.get(i)).append(",");
            i -= 1;
            continue;
            this.stackStorage.add(str);
            break label289;
          }
          if (this.builder.length() > 0)
          {
            localObject = this.builder.toString();
            return localObject;
          }
          return null;
        }
        return null;
      }
      int j = 0;
      break label253;
      label245:
      int k = 0;
      int i = 0;
      continue;
      for (;;)
      {
        label253:
        if (j == 0) {
          break label278;
        }
        j = i;
        if (i == 0) {
          break label289;
        }
        break;
        label266:
        j = 1;
      }
      label271:
      j += 1;
      continue;
      label278:
      j = i;
      if (i == 0)
      {
        j = 1;
        continue;
        label289:
        k += 1;
        i = j;
      }
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
    localObject = new GetStackRunnable.Step1Runnable(this, handler, (MonitorInfo)localObject);
    handler.postDelayed((Runnable)localObject, this.checkInterval);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.GetStackRunnable
 * JD-Core Version:    0.7.0.1
 */