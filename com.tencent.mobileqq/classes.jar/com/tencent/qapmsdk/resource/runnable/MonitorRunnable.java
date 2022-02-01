package com.tencent.qapmsdk.resource.runnable;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.resource.ResourceMonitor;
import com.tencent.qapmsdk.resource.RunTimeEnv;
import com.tencent.qapmsdk.resource.meta.PerfItem;
import java.util.Vector;

public class MonitorRunnable
  implements Runnable
{
  private static final long MILLS_SECOND = 1000L;
  private static final long SPAN_DEBUG = 1000L;
  private static final long SPAN_PUBLIC = 5000L;
  @Nullable
  private static volatile MonitorRunnable instance = null;
  private Handler handler = new Handler(ThreadManager.getMonitorThreadLooper());
  private boolean isRunning = false;
  
  private long getDelayTime()
  {
    long l = 1000L;
    if (RunTimeEnv.isPublishMode()) {
      l = 5000L;
    }
    return l;
  }
  
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
    if (RunTimeEnv.isResourceMode())
    {
      ResourceMonitor.immediatePerfItems.add(localObject);
      if (ResourceMonitor.immediatePerfItems.size() > 900)
      {
        localObject = DumpSampleFileRunnable.getInstance();
        this.handler.post((Runnable)localObject);
      }
    }
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
    if (!this.isRunning)
    {
      this.isRunning = true;
      this.handler.post(this);
    }
  }
  
  public void stop()
  {
    this.isRunning = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.runnable.MonitorRunnable
 * JD-Core Version:    0.7.0.1
 */