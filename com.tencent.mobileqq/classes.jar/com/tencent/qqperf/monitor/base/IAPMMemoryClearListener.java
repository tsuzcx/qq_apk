package com.tencent.qqperf.monitor.base;

import com.tencent.qqperf.opt.clearmemory.ClearMemoryConfig.MemoryLevelInfo;

public abstract interface IAPMMemoryClearListener
{
  public abstract void a(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo);
  
  public abstract void a(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.base.IAPMMemoryClearListener
 * JD-Core Version:    0.7.0.1
 */