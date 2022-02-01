package com.tencent.qqperf.monitor.base;

import com.tencent.qapmsdk.base.meta.DumpResult;

public abstract interface IAPMModuleCelling
  extends IAPMBase
{
  public abstract DumpResult a(String paramString, IDumpMemoryCallback paramIDumpMemoryCallback);
  
  public abstract void a(DumpResult paramDumpResult);
  
  public abstract void a(IAPMMemoryClearListener paramIAPMMemoryClearListener);
  
  public abstract String b();
  
  public abstract void b(IAPMMemoryClearListener paramIAPMMemoryClearListener);
  
  public abstract boolean b();
  
  public abstract String c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.base.IAPMModuleCelling
 * JD-Core Version:    0.7.0.1
 */