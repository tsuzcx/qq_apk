package com.tencent.qplus.task;

import java.beans.PropertyChangeEvent;

class AbstractBean$EDTPropertyChangeSupport$1
  implements Runnable
{
  AbstractBean$EDTPropertyChangeSupport$1(AbstractBean.EDTPropertyChangeSupport paramEDTPropertyChangeSupport, PropertyChangeEvent paramPropertyChangeEvent) {}
  
  public void run()
  {
    this.this$1.firePropertyChange(this.val$e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.AbstractBean.EDTPropertyChangeSupport.1
 * JD-Core Version:    0.7.0.1
 */