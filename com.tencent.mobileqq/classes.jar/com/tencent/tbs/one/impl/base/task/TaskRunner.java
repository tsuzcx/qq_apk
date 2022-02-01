package com.tencent.tbs.one.impl.base.task;

public abstract class TaskRunner
{
  private TaskRunner.Listener mListener;
  
  void finish()
  {
    if (this.mListener != null) {
      this.mListener.onFinished();
    }
  }
  
  void onTaskError(Task paramTask, int paramInt, String paramString, Throwable paramThrowable)
  {
    if (this.mListener != null) {
      this.mListener.onError(paramInt, paramString, paramThrowable);
    }
  }
  
  public abstract void onTaskEvaluated(Task paramTask);
  
  public abstract void onTaskFinished(Task paramTask);
  
  public abstract void onTaskPrepared(Task paramTask);
  
  public abstract void run(Task paramTask);
  
  public void setListener(TaskRunner.Listener paramListener)
  {
    this.mListener = paramListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.task.TaskRunner
 * JD-Core Version:    0.7.0.1
 */