package com.tencent.qplus.task;

import com.tencent.qplus.swingworker.SwingWorker.StateValue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class TaskMonitor$TaskPCL
  implements PropertyChangeListener
{
  private TaskMonitor$TaskPCL(TaskMonitor paramTaskMonitor) {}
  
  private void fireStateChange(Task paramTask, String paramString)
  {
    this.this$0.firePropertyChange(new PropertyChangeEvent(paramTask, paramString, Boolean.valueOf(false), Boolean.valueOf(true)));
  }
  
  public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent)
  {
    String str = paramPropertyChangeEvent.getPropertyName();
    Task localTask = (Task)paramPropertyChangeEvent.getSource();
    paramPropertyChangeEvent.getNewValue();
    if ((localTask != null) && (localTask == this.this$0.getForegroundTask()))
    {
      this.this$0.firePropertyChange(paramPropertyChangeEvent);
      if ("state".equals(str)) {
        paramPropertyChangeEvent = (SwingWorker.StateValue)paramPropertyChangeEvent.getNewValue();
      }
    }
    switch (paramPropertyChangeEvent)
    {
    default: 
      return;
    case DONE: 
      fireStateChange(localTask, "pending");
      return;
    case PENDING: 
      fireStateChange(localTask, "started");
      return;
    }
    fireStateChange(localTask, "done");
    this.this$0.setForegroundTask(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.TaskMonitor.TaskPCL
 * JD-Core Version:    0.7.0.1
 */