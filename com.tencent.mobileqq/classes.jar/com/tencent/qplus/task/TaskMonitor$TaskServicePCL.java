package com.tencent.qplus.task;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

class TaskMonitor$TaskServicePCL
  implements PropertyChangeListener
{
  private TaskMonitor$TaskServicePCL(TaskMonitor paramTaskMonitor) {}
  
  public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent)
  {
    if ("tasks".equals(paramPropertyChangeEvent.getPropertyName()))
    {
      List localList = (List)paramPropertyChangeEvent.getOldValue();
      paramPropertyChangeEvent = (List)paramPropertyChangeEvent.getNewValue();
      TaskMonitor.access$1(this.this$0, localList, paramPropertyChangeEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.TaskMonitor.TaskServicePCL
 * JD-Core Version:    0.7.0.1
 */