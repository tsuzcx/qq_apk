package com.tencent.qqmini.sdk.task;

class TaskFlowEngine$1
  implements Runnable
{
  TaskFlowEngine$1(TaskFlowEngine paramTaskFlowEngine) {}
  
  public void run()
  {
    BaseTask[] arrayOfBaseTask = this.this$0.mTasks;
    int j = arrayOfBaseTask.length;
    int i = 0;
    while (i < j)
    {
      BaseTask localBaseTask = arrayOfBaseTask[i];
      this.this$0.executeTask(localBaseTask);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskFlowEngine.1
 * JD-Core Version:    0.7.0.1
 */