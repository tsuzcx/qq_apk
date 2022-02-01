package com.tencent.qplus.task;

import com.tencent.qplus.swingworker.SwingWorker.StateValue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class AbstractTask$StatePCL
  implements PropertyChangeListener
{
  private AbstractTask$StatePCL(AbstractTask paramAbstractTask) {}
  
  private void taskDone(AbstractTask paramAbstractTask)
  {
    synchronized (this.this$0)
    {
      AbstractTask.access$3(this.this$0, System.currentTimeMillis());
    }
  }
  
  private void taskStarted(AbstractTask arg1)
  {
    synchronized (this.this$0)
    {
      AbstractTask.access$1(this.this$0, System.currentTimeMillis());
      this.this$0.firePropertyChange("started", Boolean.valueOf(false), Boolean.valueOf(true));
      AbstractTask.access$2(this.this$0);
      return;
    }
  }
  
  public void propertyChange(PropertyChangeEvent arg1)
  {
    Object localObject1 = ???.getPropertyName();
    if ("state".equals(localObject1))
    {
      localObject1 = (SwingWorker.StateValue)???.getNewValue();
      ??? = (AbstractTask)???.getSource();
      switch (localObject1)
      {
      }
    }
    while (!"progress".equals(localObject1))
    {
      return;
      taskStarted(???);
      return;
      taskDone(???);
      return;
    }
    synchronized (this.this$0)
    {
      AbstractTask.access$0(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.AbstractTask.StatePCL
 * JD-Core Version:    0.7.0.1
 */