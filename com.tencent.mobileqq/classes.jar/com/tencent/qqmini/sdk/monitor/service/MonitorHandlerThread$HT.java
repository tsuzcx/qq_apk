package com.tencent.qqmini.sdk.monitor.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

class MonitorHandlerThread$HT
{
  private Handler handler = null;
  public HandlerThread handlerThread = null;
  private Looper looper = null;
  
  public MonitorHandlerThread$HT(String paramString, HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null)
    {
      this.handlerThread = paramHandlerThread;
    }
    else
    {
      paramHandlerThread = new StringBuilder();
      paramHandlerThread.append("Tencent_PerformanceMonitorThread_");
      paramHandlerThread.append(paramString);
      this.handlerThread = new HandlerThread(paramHandlerThread.toString());
      this.handlerThread.start();
    }
    this.looper = this.handlerThread.getLooper();
    this.handler = new Handler(this.looper);
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public Looper getLooper()
  {
    return this.looper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.MonitorHandlerThread.HT
 * JD-Core Version:    0.7.0.1
 */