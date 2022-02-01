package com.tencent.qqmini.sdk.task;

import java.util.Iterator;
import java.util.List;

public class TaskFlowEngine$DependFlow
{
  List<BaseTask> mDependTasks;
  BaseTask mTask;
  
  TaskFlowEngine$DependFlow(BaseTask paramBaseTask, List<BaseTask> paramList)
  {
    this.mTask = paramList;
    Object localObject;
    this.mDependTasks = localObject;
  }
  
  public boolean isDepend(BaseTask paramBaseTask)
  {
    return (this.mDependTasks != null) && (this.mDependTasks.contains(paramBaseTask));
  }
  
  public void onDependCompleted()
  {
    if (this.mDependTasks != null)
    {
      Iterator localIterator = this.mDependTasks.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((BaseTask)localIterator.next()).isSucceed());
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if ((this.mTask.isDone()) && (this.mTask.isSucceed())) {
          this.this$0.updateFlow(this.mTask);
        }
      }
      else {
        return;
      }
      this.mTask.run();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskFlowEngine.DependFlow
 * JD-Core Version:    0.7.0.1
 */