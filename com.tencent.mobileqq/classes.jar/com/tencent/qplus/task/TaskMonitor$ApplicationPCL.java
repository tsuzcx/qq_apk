package com.tencent.qplus.task;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;

class TaskMonitor$ApplicationPCL
  implements PropertyChangeListener
{
  private TaskMonitor$ApplicationPCL(TaskMonitor paramTaskMonitor) {}
  
  public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent)
  {
    Object localObject;
    if ("taskServices".equals(paramPropertyChangeEvent.getPropertyName()))
    {
      localObject = (List)paramPropertyChangeEvent.getOldValue();
      paramPropertyChangeEvent = (List)paramPropertyChangeEvent.getNewValue();
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        break label61;
      }
      paramPropertyChangeEvent = paramPropertyChangeEvent.iterator();
    }
    for (;;)
    {
      if (!paramPropertyChangeEvent.hasNext())
      {
        return;
        label61:
        ((TaskService)((Iterator)localObject).next()).removePropertyChangeListener(TaskMonitor.access$0(this.this$0));
        break;
      }
      ((TaskService)paramPropertyChangeEvent.next()).addPropertyChangeListener(TaskMonitor.access$0(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.task.TaskMonitor.ApplicationPCL
 * JD-Core Version:    0.7.0.1
 */