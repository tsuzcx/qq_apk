package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

class MonitorTimeExecutor$WatchDogRunnable
  implements Runnable
{
  private final MonitorTimeExecutor a;
  
  private MonitorTimeExecutor$WatchDogRunnable(@NonNull MonitorTimeExecutor paramMonitorTimeExecutor)
  {
    this.a = paramMonitorTimeExecutor;
  }
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (MonitorTimeExecutor.c())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[run] checking ");
      localStringBuilder.append(this.a);
      QLog.d("WatchDog", 2, localStringBuilder.toString());
    }
    if ((!this.a.isTerminating()) && (!this.a.isTerminated()) && (!this.a.isShutdown()))
    {
      MonitorTimeExecutor.a(this.a);
      if (MonitorTimeExecutor.d() != null) {
        MonitorTimeExecutor.d().postDelayed(this, MonitorTimeExecutor.e());
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[run] skip since executor terminated: ");
      localStringBuilder.append(this.a);
      QLog.d("WatchDog", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.MonitorTimeExecutor.WatchDogRunnable
 * JD-Core Version:    0.7.0.1
 */