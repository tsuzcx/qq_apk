package com.tencent.tbs.one.impl.base.task;

public abstract interface TaskRunner$Listener
{
  public abstract void onError(int paramInt, String paramString, Throwable paramThrowable);
  
  public abstract void onFinished();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.task.TaskRunner.Listener
 * JD-Core Version:    0.7.0.1
 */