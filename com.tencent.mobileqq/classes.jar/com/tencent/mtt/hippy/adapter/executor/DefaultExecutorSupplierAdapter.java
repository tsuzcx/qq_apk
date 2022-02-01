package com.tencent.mtt.hippy.adapter.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultExecutorSupplierAdapter
  implements HippyExecutorSupplierAdapter
{
  private volatile ExecutorService mBackgroundTaskExecutor;
  private volatile ExecutorService mDBExecutor;
  
  public void destroyIfNeed()
  {
    try
    {
      if ((this.mDBExecutor != null) && (!this.mDBExecutor.isShutdown()))
      {
        this.mDBExecutor.shutdown();
        this.mDBExecutor = null;
      }
      if ((this.mBackgroundTaskExecutor != null) && (!this.mBackgroundTaskExecutor.isShutdown()))
      {
        this.mBackgroundTaskExecutor.shutdown();
        this.mBackgroundTaskExecutor = null;
      }
      return;
    }
    finally {}
  }
  
  public Executor getBackgroundTaskExecutor()
  {
    if (this.mBackgroundTaskExecutor == null) {}
    try
    {
      if (this.mBackgroundTaskExecutor == null) {
        this.mBackgroundTaskExecutor = Executors.newSingleThreadExecutor();
      }
      return this.mBackgroundTaskExecutor;
    }
    finally {}
  }
  
  public Executor getDBExecutor()
  {
    if (this.mDBExecutor == null) {}
    try
    {
      if (this.mDBExecutor == null) {
        this.mDBExecutor = Executors.newSingleThreadExecutor();
      }
      return this.mDBExecutor;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.executor.DefaultExecutorSupplierAdapter
 * JD-Core Version:    0.7.0.1
 */