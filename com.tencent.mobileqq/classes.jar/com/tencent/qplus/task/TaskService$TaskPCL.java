package com.tencent.qplus.task;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

class TaskService$TaskPCL
  implements PropertyChangeListener
{
  private TaskService$TaskPCL(TaskService paramTaskService) {}
  
  public void propertyChange(PropertyChangeEvent arg1)
  {
    AbstractTask localAbstractTask;
    if ("done".equals(???.getPropertyName()))
    {
      localAbstractTask = (AbstractTask)???.getSource();
      if (!localAbstractTask.isDone()) {}
    }
    synchronized (TaskService.access$0(this.this$0))
    {
      List localList1 = TaskService.access$1(this.this$0);
      TaskService.access$0(this.this$0).remove(localAbstractTask);
      localAbstractTask.removePropertyChangeListener(TaskService.access$2(this.this$0));
      List localList2 = TaskService.access$1(this.this$0);
      this.this$0.firePropertyChange("tasks", localList1, localList2);
      ??? = localAbstractTask.getInputBlocker();
      if (??? != null) {
        ???.unblock();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.TaskService.TaskPCL
 * JD-Core Version:    0.7.0.1
 */