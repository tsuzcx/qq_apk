package com.tencent.mobileqq.statistics.crash;

import android.util.Log;

final class CopyOnWriteArrayListMonitor$1
  extends Thread
{
  CopyOnWriteArrayListMonitor$1(Throwable paramThrowable) {}
  
  public void run()
  {
    throw new CopyOnWriteArrayListMonitor.CopyOnWriteArrayListException(Log.getStackTraceString(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.crash.CopyOnWriteArrayListMonitor.1
 * JD-Core Version:    0.7.0.1
 */