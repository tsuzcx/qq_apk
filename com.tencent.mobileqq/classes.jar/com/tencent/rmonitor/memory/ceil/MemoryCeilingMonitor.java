package com.tencent.rmonitor.memory.ceil;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.memory.MemoryConfigHelper;
import com.tencent.rmonitor.memory.MemoryDumpHelper;
import com.tencent.rmonitor.memory.MemoryUtils;
import com.tencent.rmonitor.memory.common.DelayIntervalDetector;

public class MemoryCeilingMonitor
  extends QAPMMonitorPlugin
  implements Handler.Callback
{
  public static boolean a = false;
  private static final MemoryCeilingReporter e = new MemoryCeilingReporter();
  private static volatile MemoryCeilingMonitor h = null;
  private final DelayIntervalDetector b = new DelayIntervalDetector(5000L, 5000L, 30000L);
  @NonNull
  private final Handler c = new Handler(ThreadManager.e(), this);
  @NonNull
  private final StringBuilder d = new StringBuilder(128);
  private final MemoryCeilingTrigger f = new MemoryCeilingTrigger(e);
  private long g;
  
  private void b()
  {
    Logger.b.d(new String[] { "RMonitor_memory_MemoryMonitor", "start detect memory ceiling" });
    this.c.removeMessages(1);
    this.c.sendEmptyMessageDelayed(1, this.b.c());
  }
  
  private boolean c()
  {
    this.g = MemoryUtils.b();
    long l = Runtime.getRuntime().maxMemory();
    return (float)this.g > MemoryConfigHelper.b() * (float)l;
  }
  
  private void d()
  {
    long l = AppInfo.e();
    this.d.setLength(0);
    StringBuilder localStringBuilder = this.d;
    localStringBuilder.append("PSS=");
    localStringBuilder.append(l / 1024L);
    localStringBuilder.append(" KB HeapMax=");
    localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L);
    localStringBuilder.append(" KB HeapAlloc=");
    localStringBuilder.append(Runtime.getRuntime().totalMemory() / 1024L);
    localStringBuilder.append(" KB HeapFree=");
    localStringBuilder.append(Runtime.getRuntime().freeMemory() / 1024L);
    localStringBuilder.append(" KB");
    Logger.b.v(new String[] { "RMonitor_memory_MemoryMonitor", this.d.toString() });
  }
  
  public static DumpResult dumpHprof(String paramString, IMemoryDumpListener paramIMemoryDumpListener)
  {
    return MemoryDumpHelper.a(paramString, paramString, true, false, paramIMemoryDumpListener);
  }
  
  public static MemoryCeilingMonitor getInstance()
  {
    if (h == null) {
      try
      {
        if (h == null) {
          h = new MemoryCeilingMonitor();
        }
      }
      finally {}
    }
    return h;
  }
  
  public static void reportHprofFile(DumpResult paramDumpResult)
  {
    e.a(paramDumpResult);
  }
  
  public boolean handleMessage(@NonNull Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      Logger.b.d(new String[] { "RMonitor_memory_MemoryMonitor", "handle memory detect ceiling message." });
      d();
      if (c()) {
        this.f.a(this.g);
      }
      if (!PluginController.b.b(109))
      {
        int i = MemoryConfigHelper.a().f.g;
        Logger.b.d(new String[] { "RMonitor_memory_MemoryMonitor", "memory celling report count above, remove MSG_MEMORY_CALCULATE msg,", " max report num: ", String.valueOf(i) });
        this.c.removeMessages(1);
        return true;
      }
      this.c.sendEmptyMessageDelayed(1, this.b.c());
    }
    return true;
  }
  
  public void start()
  {
    if (!MemoryUtils.a(108))
    {
      Logger.b.d(new String[] { "RMonitor_memory_MemoryMonitor", "Cannot collect memory celling." });
      return;
    }
    this.b.a();
    if (MemoryConfigHelper.a().e < 1) {
      e.a();
    }
    b();
  }
  
  public void stop()
  {
    this.b.b();
    this.c.removeMessages(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.ceil.MemoryCeilingMonitor
 * JD-Core Version:    0.7.0.1
 */