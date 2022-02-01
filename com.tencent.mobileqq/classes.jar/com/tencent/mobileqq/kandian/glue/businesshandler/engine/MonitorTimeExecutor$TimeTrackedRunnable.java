package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.SystemClock;
import android.support.annotation.NonNull;

class MonitorTimeExecutor$TimeTrackedRunnable
  implements Runnable
{
  private final long jdField_a_of_type_Long;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private long b;
  private long c;
  
  private MonitorTimeExecutor$TimeTrackedRunnable(@NonNull Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public Runnable a()
  {
    return this.jdField_a_of_type_JavaLangRunnable;
  }
  
  public Thread a()
  {
    return this.jdField_a_of_type_JavaLangThread;
  }
  
  public void run()
  {
    this.b = SystemClock.uptimeMillis();
    this.c = (this.b - this.jdField_a_of_type_Long);
    this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TimeTrackedRunnable{timestampAdded=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", timestampStarted=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", task=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangRunnable);
    localStringBuilder.append(", timeWaited=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", currentThread=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangThread);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.MonitorTimeExecutor.TimeTrackedRunnable
 * JD-Core Version:    0.7.0.1
 */