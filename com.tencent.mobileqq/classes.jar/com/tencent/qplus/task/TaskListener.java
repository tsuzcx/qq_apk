package com.tencent.qplus.task;

import java.util.List;

public abstract interface TaskListener<T, V>
{
  public abstract void cancelled(TaskEvent<Void> paramTaskEvent);
  
  public abstract void doInBackground(TaskEvent<Void> paramTaskEvent);
  
  public abstract void failed(TaskEvent<Throwable> paramTaskEvent);
  
  public abstract void finished(TaskEvent<Void> paramTaskEvent);
  
  public abstract void interrupted(TaskEvent<InterruptedException> paramTaskEvent);
  
  public abstract void process(TaskEvent<List<V>> paramTaskEvent);
  
  public abstract void succeeded(TaskEvent<T> paramTaskEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.TaskListener
 * JD-Core Version:    0.7.0.1
 */