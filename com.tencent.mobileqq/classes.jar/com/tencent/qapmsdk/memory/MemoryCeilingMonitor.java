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
import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qapmsdk.base.listener.ListenerManager;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.DumpResult;
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
  private static final int DELAY_TIME_FOREGROUND = 5000;
  private static final int MAX_THRESHOLD = 100;
  private static final int MSG_MEMORY_CALCULATE = 1;
  private static final String TAG = "QAPM_memory_MemoryMonitor";
  public static boolean debug = false;
  @Nullable
  private static volatile MemoryCeilingMonitor instance = null;
  @NonNull
  private ArrayList<String> activityList = new ArrayList(20);
  private long delayTime = 5000L;
  private long heapSize;
  @Nullable
  private Handler memoryMonitorHandler = new Handler(ThreadManager.getMonitorThreadLooper(), this);
  private long pssSize;
  @NonNull
  private StringBuilder sb = new StringBuilder(128);
  
  private MemoryCeilingMonitor()
  {
    LifecycleCallback.INSTANCE.register(this);
  }
  
  public static DumpResult dumpHprof(String paramString, IMemoryDumpListener paramIMemoryDumpListener)
  {
    return MemoryDumpHelper.dump(paramString, paramIMemoryDumpListener);
  }
  
  @Nullable
  public static MemoryCeilingMonitor getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MemoryCeilingMonitor();
      }
      return instance;
    }
    finally {}
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
    IMemoryCellingListener localIMemoryCellingListener = ListenerManager.memoryCellingListener;
    if (localIMemoryCellingListener != null) {
      localIMemoryCellingListener.onLowMemory(paramLong);
    }
    Object localObject = ActivityInfo.getCurrentActivity(BaseInfo.app);
    String str = ActivityInfo.getCurrentActivityName();
    StringBuilder localStringBuilder = new StringBuilder().append(str).append("@");
    if (localObject != null) {}
    for (localObject = Integer.valueOf(localObject.hashCode());; localObject = "")
    {
      localObject = localObject;
      if ((!this.activityList.contains(localObject)) || (debug))
      {
        Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryMonitor", "activityandhash report:", localObject });
        long l = PluginCombination.ceilingValuePlugin.threshold * Runtime.getRuntime().maxMemory() / 100L;
        if (localIMemoryCellingListener != null) {
          localIMemoryCellingListener.onBeforeUploadJson();
        }
        MemoryDumpHelper.getInstance().onReport(paramLong, l, str);
        this.activityList.add(localObject);
        if ((localIMemoryCellingListener == null) || (localIMemoryCellingListener.onCanDump(paramLong))) {
          MemoryDumpHelper.getInstance().startDumpingMemory("LowMemory", localIMemoryCellingListener);
        }
      }
      return;
    }
  }
  
  public static void reportHprofFile(DumpResult paramDumpResult)
  {
    MemoryDumpHelper.reportHprofFile(paramDumpResult);
  }
  
  public void detect()
  {
    this.memoryMonitorHandler.removeMessages(1);
    this.memoryMonitorHandler.sendEmptyMessageDelayed(1, this.delayTime);
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
    this.memoryMonitorHandler.sendEmptyMessageDelayed(1, this.delayTime);
    return true;
  }
  
  public void onBackground(@NotNull Activity paramActivity)
  {
    this.delayTime = 30000L;
  }
  
  public void onCreate(@NotNull Activity paramActivity) {}
  
  public void onDestroy(@NotNull Activity paramActivity) {}
  
  public void onForeground(@NotNull Activity paramActivity)
  {
    this.delayTime = 5000L;
  }
  
  public void onResume(@NotNull Activity paramActivity) {}
  
  public void onStop(@NotNull Activity paramActivity) {}
  
  public void start()
  {
    if (!canEventReport(PluginCombination.ceilingHprofPlugin.plugin))
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_MemoryMonitor", "Cannot collect memory celling." });
      return;
    }
    if (PluginCombination.ceilingValuePlugin.curReportNum < 1) {
      MemoryDumpHelper.getInstance().onReport(-1L, -1L, "-1");
    }
    detect();
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryCeilingMonitor
 * JD-Core Version:    0.7.0.1
 */