package com.tencent.rmonitor.memory.ceil;

import android.support.annotation.NonNull;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.plugin.listener.IMemoryCeilingListener;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.lifecycle.ActivityInfo;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.memory.MemoryConfigHelper;
import com.tencent.rmonitor.memory.MemoryDumpHelper;
import java.util.ArrayList;

public class MemoryCeilingTrigger
{
  @NonNull
  private final ArrayList<String> a = new ArrayList(20);
  private final MemoryCeilingReporter b;
  
  public MemoryCeilingTrigger(MemoryCeilingReporter paramMemoryCeilingReporter)
  {
    this.b = paramMemoryCeilingReporter;
  }
  
  public void a(long paramLong)
  {
    IMemoryCeilingListener localIMemoryCeilingListener = (IMemoryCeilingListener)ListenerManager.b.b();
    if (localIMemoryCeilingListener != null) {
      localIMemoryCeilingListener.onLowMemory(paramLong);
    }
    Object localObject = ActivityInfo.a(BaseInfo.app);
    String str = ActivityInfo.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("@");
    if (localObject != null) {
      localObject = Integer.valueOf(localObject.hashCode());
    } else {
      localObject = "";
    }
    localStringBuilder.append(localObject);
    localObject = localStringBuilder.toString();
    if ((!this.a.contains(localObject)) || (MemoryCeilingMonitor.a))
    {
      Logger.b.d(new String[] { "MemoryCeilTrigger", "activityandhash report:", localObject });
      long l = (MemoryConfigHelper.b() * (float)Runtime.getRuntime().maxMemory());
      this.b.a(paramLong, l, str);
      this.a.add(localObject);
      if ((localIMemoryCeilingListener == null) || (localIMemoryCeilingListener.onCanDump(paramLong)))
      {
        if (!PluginController.b.b(108))
        {
          Logger.b.d(new String[] { "MemoryCeilTrigger", "startDumpingMemory abort canCollect=false" });
          return;
        }
        if (!MemoryDumpHelper.a()) {
          return;
        }
        localObject = MemoryDumpHelper.a("LowMemory", "LowMemory", true, false, localIMemoryCeilingListener);
        this.b.a((DumpResult)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.ceil.MemoryCeilingTrigger
 * JD-Core Version:    0.7.0.1
 */