package com.tencent.qapmsdk.resource.runnable;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.resource.ResourceMonitor;
import com.tencent.qapmsdk.resource.meta.PerfItem;
import java.util.Vector;

public class MonitorRunnable
  implements Runnable
{
  @Nullable
  private static volatile MonitorRunnable instance = null;
  private long delayTime = 1000L;
  Handler handler = new Handler(ThreadManager.getMonitorThreadLooper());
  private boolean isRun;
  
  private MonitorRunnable(boolean paramBoolean)
  {
    this.isRun = paramBoolean;
  }
  
  @Nullable
  public static MonitorRunnable getInstance(boolean paramBoolean)
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MonitorRunnable(paramBoolean);
      }
      instance.setState(paramBoolean);
      return instance;
    }
    finally {}
  }
  
  private void setState(boolean paramBoolean)
  {
    this.isRun = paramBoolean;
    if (ResourceMonitor.getInstance().isPublicMode()) {
      this.delayTime = 5000L;
    }
  }
  
  public PerfItem forceSampleOnce()
  {
    PerfItem localPerfItem = ResourceMonitor.getInstance().samplePerfValue(new PerfItem());
    localPerfItem.eventTime = (System.currentTimeMillis() / 1000.0D);
    return localPerfItem;
  }
  
  public void run()
  {
    if (this.isRun)
    {
      Object localObject = forceSampleOnce();
      ResourceMonitor.immediatePerfItems.add(localObject);
      localObject = getInstance(true);
      this.handler.postDelayed((Runnable)localObject, this.delayTime);
      if (ResourceMonitor.immediatePerfItems.size() > 900)
      {
        localObject = DumpSampleFileRunnable.getInstance();
        this.handler.post((Runnable)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.runnable.MonitorRunnable
 * JD-Core Version:    0.7.0.1
 */