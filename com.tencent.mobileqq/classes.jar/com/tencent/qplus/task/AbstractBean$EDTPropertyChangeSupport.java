package com.tencent.qplus.task;

import com.tencent.qplus.swingworker.WorkerUtilities;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

class AbstractBean$EDTPropertyChangeSupport
  extends PropertyChangeSupport
{
  AbstractBean$EDTPropertyChangeSupport(Object paramObject)
  {
    super(paramObject);
  }
  
  public void firePropertyChange(PropertyChangeEvent paramPropertyChangeEvent)
  {
    if (WorkerUtilities.isUIThread())
    {
      super.firePropertyChange(paramPropertyChangeEvent);
      return;
    }
    WorkerUtilities.invokeInLooper(new AbstractBean.EDTPropertyChangeSupport.1(this, paramPropertyChangeEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.task.AbstractBean.EDTPropertyChangeSupport
 * JD-Core Version:    0.7.0.1
 */