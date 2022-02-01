package com.tencent.qapmsdk.base.listener;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IMemoryCellingListener;", "Lcom/tencent/qapmsdk/base/listener/IMemoryDumpListener;", "onBeforeUploadJson", "", "onCanDump", "", "memory", "", "onLowMemory", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IMemoryCellingListener
  extends IMemoryDumpListener
{
  public abstract void onBeforeUploadJson();
  
  public abstract boolean onCanDump(long paramLong);
  
  public abstract void onLowMemory(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IMemoryCellingListener
 * JD-Core Version:    0.7.0.1
 */