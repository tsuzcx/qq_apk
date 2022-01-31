package com.tencent.qplus.task;

import java.util.List;

public class TaskListener$Adapter<T, V>
  implements TaskListener<T, V>
{
  public void cancelled(TaskEvent<Void> paramTaskEvent) {}
  
  public void doInBackground(TaskEvent<Void> paramTaskEvent) {}
  
  public void failed(TaskEvent<Throwable> paramTaskEvent) {}
  
  public void finished(TaskEvent<Void> paramTaskEvent) {}
  
  public void interrupted(TaskEvent<InterruptedException> paramTaskEvent) {}
  
  public void process(TaskEvent<List<V>> paramTaskEvent) {}
  
  public void succeeded(TaskEvent<T> paramTaskEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.task.TaskListener.Adapter
 * JD-Core Version:    0.7.0.1
 */