package com.tencent.proxyinner.plugin.loader;

import com.tencent.proxyinner.log.XLog;
import java.util.Timer;
import java.util.TimerTask;

public class PluginLoaderMonitor
{
  private static String TAG = "ODSDK|PluginLoaderMonitor";
  public static final int TYPE_MONITOR_LOADING = 1;
  public static final int TYPE_MONITOR_NONE = 0;
  public static final int TYPE_MONITOR_STARTING = 2;
  private IMonitorListener mListener;
  private int monitorType = 0;
  Timer timeoutTimer = new Timer("timeout_monitor");
  
  private void onTimeoutHappen()
  {
    notifyTimeout(this.monitorType);
    stopTimeoutMonitor();
  }
  
  public void notifyTimeout(int paramInt)
  {
    if (this.mListener != null)
    {
      if (paramInt != 1) {
        break label22;
      }
      this.mListener.onLoadTimeout();
    }
    label22:
    while (paramInt != 2) {
      return;
    }
    this.mListener.onStartTimeout();
  }
  
  public void startTimeoutMonitor(int paramInt1, IMonitorListener paramIMonitorListener, int paramInt2)
  {
    XLog.i(TAG, "过了" + paramInt2 + "msho上报超时");
    if (this.timeoutTimer == null) {
      this.timeoutTimer = new Timer("timeout_monitor");
    }
    this.monitorType = paramInt1;
    this.mListener = paramIMonitorListener;
    this.timeoutTimer.schedule(new TimerTask()
    {
      public void run()
      {
        PluginLoaderMonitor.this.onTimeoutHappen();
      }
    }, paramInt2);
  }
  
  public void stopTimeoutMonitor()
  {
    if (this.monitorType == 0) {
      return;
    }
    this.monitorType = 0;
    this.mListener = null;
    if (this.timeoutTimer != null) {
      this.timeoutTimer.cancel();
    }
    this.timeoutTimer = null;
  }
  
  static abstract interface IMonitorListener
  {
    public abstract void onLoadTimeout();
    
    public abstract void onStartTimeout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.loader.PluginLoaderMonitor
 * JD-Core Version:    0.7.0.1
 */