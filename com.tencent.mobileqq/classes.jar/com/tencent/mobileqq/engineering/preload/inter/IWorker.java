package com.tencent.mobileqq.engineering.preload.inter;

import java.util.concurrent.ExecutorService;

public abstract interface IWorker<T>
{
  public abstract void doPreLoad();
  
  public abstract void onRemove();
  
  public abstract void removeListener(OnTaskListener<T> paramOnTaskListener);
  
  public abstract void setListener(OnTaskListener<T> paramOnTaskListener);
  
  public abstract void setThreadPoolExecutor(ExecutorService paramExecutorService);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.engineering.preload.inter.IWorker
 * JD-Core Version:    0.7.0.1
 */