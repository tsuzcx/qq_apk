package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.SystemClock;
import android.support.annotation.NonNull;

class MonitorTimeExecutor$TimeTrackedRunnable
  implements Runnable
{
  private final long a;
  private long b;
  private final Runnable c;
  private long d;
  private Thread e;
  
  private MonitorTimeExecutor$TimeTrackedRunnable(@NonNull Runnable paramRunnable)
  {
    this.c = paramRunnable;
    this.a = SystemClock.uptimeMillis();
  }
  
  public Thread a()
  {
    return this.e;
  }
  
  public Runnable b()
  {
    return this.c;
  }
  
  public void run()
  {
    this.b = SystemClock.uptimeMillis();
    this.d = (this.b - this.a);
    this.e = Thread.currentThread();
    this.c.run();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TimeTrackedRunnable{timestampAdded=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", timestampStarted=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", task=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", timeWaited=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", currentThread=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.MonitorTimeExecutor.TimeTrackedRunnable
 * JD-Core Version:    0.7.0.1
 */