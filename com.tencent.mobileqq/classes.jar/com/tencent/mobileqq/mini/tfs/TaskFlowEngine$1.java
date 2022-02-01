package com.tencent.mobileqq.mini.tfs;

class TaskFlowEngine$1
  implements Runnable
{
  TaskFlowEngine$1(TaskFlowEngine paramTaskFlowEngine) {}
  
  public void run()
  {
    BaseTask[] arrayOfBaseTask = TaskFlowEngine.access$000(this.this$0);
    int j = arrayOfBaseTask.length;
    int i = 0;
    while (i < j)
    {
      BaseTask localBaseTask = arrayOfBaseTask[i];
      TaskFlowEngine.access$100(this.this$0, localBaseTask);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.TaskFlowEngine.1
 * JD-Core Version:    0.7.0.1
 */