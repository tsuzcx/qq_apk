package com.tencent.qplus.task;

class TaskService$1
  implements Runnable
{
  TaskService$1(TaskService paramTaskService, AbstractTask.InputBlocker paramInputBlocker) {}
  
  public void run()
  {
    this.val$inputBlocker.block();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.TaskService.1
 * JD-Core Version:    0.7.0.1
 */