package com.tencent.qapmsdk.memory;

import android.app.Activity;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.activty.ActivityInfo;
import com.tencent.qapmsdk.common.activty.IForeBackInterface;
import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.util.AppInfo;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class MemoryCeilingMonitor
  extends QAPMMonitorPlugin
  implements Handler.Callback, IForeBackInterface
{
  private static final int ACTIVITY_LIST_SIZE = 20;
  private static final int BUILDER_SIZE = 128;
  private static final int BYTE_UNIT = 1024;
  private static final int DELAY_TIME_BACKGROUND = 30000;
  private static final int DELAY_TIME_FORGROUND = 5000;
  private static final int MAX_THRESHOLD = 100;
  private static final int MSG_MEMORY_CALCULATE = 1;
  private static final String TAG = "QAPM_memory_MemoryMonitor";
  @Nullable
  private static volatile MemoryCeilingMonitor instance = null;
  public static boolean sDebug = false;
  @NonNull
  private ArrayList<String> activityList = new ArrayList(20);
  private long heapSize;
  private long mDelayTime = 5000L;
  IMemoryCellingListener memoryCellingListener;
  @Nullable
  private Handler memoryMonitorHandler = new Handler(ThreadManager.getMonitorThreadLooper(), this);
  private long pssSize;
  @NonNull
  private StringBuilder sb = new StringBuilder(128);
  
  private MemoryCeilingMonitor(IMemoryCellingListener paramIMemoryCellingListener)
  {
    this.memoryCellingListener = paramIMemoryCellingListener;
    LifecycleCallback.INSTANCE.register(this);
  }
  
  /* Error */
  @Nullable
  public static MemoryCeilingMonitor getInstance()
  {
    // Byte code:
    //   0: getstatic 52	com/tencent/qapmsdk/memory/MemoryCeilingMonitor:instance	Lcom/tencent/qapmsdk/memory/MemoryCeilingMonitor;
    //   3: ifnonnull +47 -> 50
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 52	com/tencent/qapmsdk/memory/MemoryCeilingMonitor:instance	Lcom/tencent/qapmsdk/memory/MemoryCeilingMonitor;
    //   12: ifnonnull +35 -> 47
    //   15: getstatic 103	com/tencent/qapmsdk/base/listener/ListenerManager:memoryCellingListener	Lcom/tencent/qapmsdk/base/listener/IMemoryCellingListener;
    //   18: ifnull +36 -> 54
    //   21: getstatic 108	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   24: iconst_2
    //   25: anewarray 110	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc 27
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: ldc 112
    //   37: aastore
    //   38: invokevirtual 116	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   41: getstatic 103	com/tencent/qapmsdk/base/listener/ListenerManager:memoryCellingListener	Lcom/tencent/qapmsdk/base/listener/IMemoryCellingListener;
    //   44: invokestatic 119	com/tencent/qapmsdk/memory/MemoryCeilingMonitor:initCelling	(Lcom/tencent/qapmsdk/base/listener/IMemoryCellingListener;)V
    //   47: ldc 2
    //   49: monitorexit
    //   50: getstatic 52	com/tencent/qapmsdk/memory/MemoryCeilingMonitor:instance	Lcom/tencent/qapmsdk/memory/MemoryCeilingMonitor;
    //   53: areturn
    //   54: new 121	com/tencent/qapmsdk/memory/MemoryCeilingMonitor$1
    //   57: dup
    //   58: invokespecial 122	com/tencent/qapmsdk/memory/MemoryCeilingMonitor$1:<init>	()V
    //   61: invokestatic 119	com/tencent/qapmsdk/memory/MemoryCeilingMonitor:initCelling	(Lcom/tencent/qapmsdk/base/listener/IMemoryCellingListener;)V
    //   64: goto -17 -> 47
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	47	67	finally
    //   47	50	67	finally
    //   54	64	67	finally
    //   68	71	67	finally
  }
  
  public static void initCelling(IMemoryCellingListener paramIMemoryCellingListener)
  {
    if (instance != null) {
      return;
    }
    instance = new MemoryCeilingMonitor(paramIMemoryCellingListener);
  }
  
  private boolean isOverMemoryThreshold()
  {
    this.pssSize = AppInfo.getPssMemory(BaseInfo.app, Process.myPid());
    this.heapSize = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    this.sb.setLength(0);
    this.sb.append("PSS=");
    this.sb.append(this.pssSize / 1024L);
    this.sb.append(" KB HeapMax=");
    this.sb.append(Runtime.getRuntime().maxMemory() / 1024L);
    this.sb.append(" KB HeapAlloc=");
    this.sb.append(Runtime.getRuntime().totalMemory() / 1024L);
    this.sb.append(" KB HeapFree=");
    this.sb.append(Runtime.getRuntime().freeMemory() / 1024L);
    this.sb.append(" KB");
    Logger.INSTANCE.v(new String[] { "QAPM_memory_MemoryMonitor", this.sb.toString() });
    return this.heapSize > PluginCombination.ceilingValuePlugin.threshold * Runtime.getRuntime().maxMemory() / 100L;
  }
  
  private void onLowMemory(long paramLong)
  {
    if (this.memoryCellingListener == null) {
      throw new RuntimeException("Please init a memory celling listener first!");
    }
    this.memoryCellingListener.onLowMemory(paramLong);
    Object localObject = ActivityInfo.getCurrentActivity(BaseInfo.app);
    String str = ActivityInfo.getCurrentActivityName();
    StringBuilder localStringBuilder = new StringBuilder().append(str).append("@");
    if (localObject != null) {}
    for (localObject = Integer.valueOf(localObject.hashCode());; localObject = "")
    {
      localObject = localObject;
      if ((!this.activityList.contains(localObject)) || (sDebug))
      {
        Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryMonitor", "activityandhash report:", localObject });
        long l = PluginCombination.ceilingValuePlugin.threshold * Runtime.getRuntime().maxMemory() / 100L;
        this.memoryCellingListener.onBeforeUploadJson();
        MemoryDumpHelper.getInstance().onReport(paramLong, l, str);
        this.activityList.add(localObject);
        if (this.memoryCellingListener.onCanDump(paramLong)) {
          MemoryDumpHelper.getInstance().startDumpingMemory("LowMemory");
        }
      }
      return;
    }
  }
  
  public void detect()
  {
    this.memoryMonitorHandler.removeMessages(1);
    this.memoryMonitorHandler.sendEmptyMessageDelayed(1, this.mDelayTime);
  }
  
  public boolean handleMessage(@NonNull Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    if (isOverMemoryThreshold()) {
      onLowMemory(this.heapSize);
    }
    if (!PluginController.INSTANCE.canCollect(PluginCombination.ceilingValuePlugin.plugin))
    {
      int i = PluginCombination.ceilingValuePlugin.maxReportNum;
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryMonitor", "memory celling report count above, remove MSG_MEMORY_CALCULATE msg,", " max report num: ", String.valueOf(i) });
      this.memoryMonitorHandler.removeMessages(1);
      return true;
    }
    this.memoryMonitorHandler.sendEmptyMessageDelayed(1, this.mDelayTime);
    return true;
  }
  
  public void onBackground(@NotNull Activity paramActivity)
  {
    this.mDelayTime = 30000L;
  }
  
  public void onCreate(@NotNull Activity paramActivity) {}
  
  public void onDestroy(@NotNull Activity paramActivity) {}
  
  public void onForeground(@NotNull Activity paramActivity)
  {
    this.mDelayTime = 5000L;
  }
  
  public void start()
  {
    if (!PluginController.INSTANCE.canCollect(PluginCombination.ceilingHprofPlugin.plugin))
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryMonitor", "Cannot collect memory celling." });
      return;
    }
    if (PluginCombination.ceilingValuePlugin.curReportNum < 1) {
      MemoryDumpHelper.getInstance().onReport(-1L, -1L, "-1");
    }
    getInstance().detect();
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryCeilingMonitor
 * JD-Core Version:    0.7.0.1
 */