package com.tencent.rmonitor.memory.common;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.SimpleActivityStateCallback;

public class DelayIntervalDetector
  extends SimpleActivityStateCallback
{
  private final long a;
  private final long b;
  private long c;
  
  public DelayIntervalDetector(long paramLong1, long paramLong2, long paramLong3)
  {
    this.c = paramLong1;
    this.a = paramLong2;
    this.b = paramLong3;
  }
  
  public void a()
  {
    LifecycleCallback.a(this);
  }
  
  public void b()
  {
    LifecycleCallback.b(this);
  }
  
  public long c()
  {
    return this.c;
  }
  
  public void c(@NonNull Activity paramActivity)
  {
    this.c = this.a;
  }
  
  public void d(@NonNull Activity paramActivity)
  {
    this.c = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.common.DelayIntervalDetector
 * JD-Core Version:    0.7.0.1
 */