package com.tencent.rmonitor.base.plugin.listener;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/listener/IMemoryCeilingListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryDumpListener;", "onCanDump", "", "memory", "", "onLowMemory", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface IMemoryCeilingListener
  extends IMemoryDumpListener
{
  public abstract boolean onCanDump(long paramLong);
  
  public abstract void onLowMemory(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.listener.IMemoryCeilingListener
 * JD-Core Version:    0.7.0.1
 */