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
    List localList = this.mDependTasks;
    return (localList != null) && (localList.contains(paramBaseTask));
  }
  
  public void onDependCompleted()
  {
    Object localObject = this.mDependTasks;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((BaseTask)((Iterator)localObject).next()).isSucceed())
        {
          i = 1;
          break label47;
        }
      }
    }
    int i = 0;
    label47:
    if (i == 0)
    {
      if ((this.mTask.isDone()) && (this.mTask.isSucceed()))
      {
        this.this$0.updateFlow(this.mTask);
        return;
      }
      this.mTask.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskFlowEngine.DependFlow
 * JD-Core Version:    0.7.0.1
 */