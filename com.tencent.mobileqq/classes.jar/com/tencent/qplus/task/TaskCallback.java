package com.tencent.qplus.task;

public abstract interface TaskCallback<T>
{
  public abstract void cancelled();
  
  public abstract void failed(Throwable paramThrowable);
  
  public abstract void interrupted(InterruptedException paramInterruptedException);
  
  public abstract void succeeded(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.TaskCallback
 * JD-Core Version:    0.7.0.1
 */