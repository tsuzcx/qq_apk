package com.tencent.qqlive.module.videoreport.task;

public abstract interface IThreadTaskInterceptor
{
  public abstract boolean removePendingTask(Runnable paramRunnable);
  
  public abstract boolean shouldInterceptTask(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.task.IThreadTaskInterceptor
 * JD-Core Version:    0.7.0.1
 */