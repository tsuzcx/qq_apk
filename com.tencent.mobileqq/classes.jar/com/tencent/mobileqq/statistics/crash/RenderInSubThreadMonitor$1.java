package com.tencent.mobileqq.statistics.crash;

import android.util.Log;

final class RenderInSubThreadMonitor$1
  extends Thread
{
  RenderInSubThreadMonitor$1(Throwable paramThrowable) {}
  
  public void run()
  {
    throw new RenderInSubThreadMonitor.RenderInSubThreadException(Log.getStackTraceString(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.crash.RenderInSubThreadMonitor.1
 * JD-Core Version:    0.7.0.1
 */