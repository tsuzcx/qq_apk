package com.tencent.qplus.task;

public class SingleTaskContainer
{
  private Task task;
  
  public void executeTask(Task paramTask)
  {
    if (paramTask != null) {
      paramTask.cancel(false);
    }
    this.task = paramTask;
    paramTask.execute();
  }
  
  public void executeTask(Task paramTask, int paramInt)
  {
    if (paramTask != null) {
      paramTask.cancel(false);
    }
    this.task = paramTask;
    paramTask.execute(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.SingleTaskContainer
 * JD-Core Version:    0.7.0.1
 */