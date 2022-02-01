package com.tencent.qqperf.monitor.base;

import com.tencent.qapmsdk.base.meta.DumpResult;

public abstract interface IAPMModuleLeak
  extends IAPMBase
{
  public abstract DumpResult a(String paramString, IDumpMemoryCallback paramIDumpMemoryCallback);
  
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(Object paramObject, String paramString);
  
  public abstract void a(String paramString1, String paramString2, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.base.IAPMModuleLeak
 * JD-Core Version:    0.7.0.1
 */