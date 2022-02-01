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
  private static final long MILLS_SECOND = 1000L;
  private static final long SPAN_DEBUG = 1000L;
  private static final long SPAN_PUBLIC = 5000L;
  private static final String TAG = "QAPM_resource_collect";
  @Nullable
  private static volatile MonitorRunnable instance = null;
  private Handler handler = new Handler(ThreadManager.getMonitorThreadLooper());
  boolean isRunning = false;
  
  @Nullable
  public static MonitorRunnable getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MonitorRunnable();
      }
      return instance;
    }
    finally {}
  }
  
  public void collectPerfItemRightNow()
  {
    Object localObject = ResourceMonitor.getInstance().samplePerfValue(new PerfItem());
    ((PerfItem)localObject).eventTime = (System.currentTimeMillis() / 1000L);
    ResourceMonitor.immediatePerfItems.add(localObject);
    if (ResourceMonitor.immediatePerfItems.size() > 900)
    {
      localObject = DumpSampleFileRunnable.getInstance();
      this.handler.post((Runnable)localObject);
    }
  }
  
  public long getDelayTime()
  {
    long l = 1000L;
    if (ResourceMonitor.getInstance().isPublicMode()) {
      l = 5000L;
    }
    return l;
  }
  
  public void run()
  {
    collectPerfItemRightNow();
    if (this.isRunning) {
      this.handler.postDelayed(this, getDelayTime());
    }
  }
  
  public void start()
  {
    this.isRunning = true;
    this.handler.post(this);
  }
  
  public void stop()
  {
    this.isRunning = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.runnable.MonitorRunnable
 * JD-Core Version:    0.7.0.1
 */