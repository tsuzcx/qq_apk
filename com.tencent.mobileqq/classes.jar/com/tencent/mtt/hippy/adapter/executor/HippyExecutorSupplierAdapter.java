package com.tencent.mtt.hippy.adapter.executor;

import java.util.concurrent.Executor;

public abstract interface HippyExecutorSupplierAdapter
{
  public abstract void destroyIfNeed();
  
  public abstract Executor getBackgroundTaskExecutor();
  
  public abstract Executor getDBExecutor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter
 * JD-Core Version:    0.7.0.1
 */