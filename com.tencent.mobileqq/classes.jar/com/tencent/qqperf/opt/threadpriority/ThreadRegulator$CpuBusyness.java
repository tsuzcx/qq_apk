package com.tencent.qqperf.opt.threadpriority;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadRegulator$CpuBusyness
  extends RecyclablePool.Recyclable
{
  int a;
  long b;
  long c;
  ConcurrentHashMap<String, Long> d = new ConcurrentHashMap(4);
  
  public void recycle()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0L;
    this.d.clear();
    super.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadRegulator.CpuBusyness
 * JD-Core Version:    0.7.0.1
 */