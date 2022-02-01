package com.tencent.mobileqq.mini.monitor.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

class MonitorHandlerThread$HT
{
  private Handler handler;
  public HandlerThread handlerThread;
  private Looper looper;
  
  public MonitorHandlerThread$HT(String paramString, HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {
      this.handlerThread = paramHandlerThread;
    }
    for (;;)
    {
      this.looper = this.handlerThread.getLooper();
      this.handler = new Handler(this.looper);
      return;
      this.handlerThread = new HandlerThread("Tencent_PerformanceMonitorThread_" + paramString);
      this.handlerThread.start();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.service.MonitorHandlerThread.HT
 * JD-Core Version:    0.7.0.1
 */