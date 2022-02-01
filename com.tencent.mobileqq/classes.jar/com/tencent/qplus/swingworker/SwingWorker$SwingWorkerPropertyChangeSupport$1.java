package com.tencent.qplus.swingworker;

import java.beans.PropertyChangeEvent;

class SwingWorker$SwingWorkerPropertyChangeSupport$1
  implements Runnable
{
  SwingWorker$SwingWorkerPropertyChangeSupport$1(SwingWorker.SwingWorkerPropertyChangeSupport paramSwingWorkerPropertyChangeSupport, PropertyChangeEvent paramPropertyChangeEvent) {}
  
  public void run()
  {
    this.this$1.firePropertyChange(this.val$evt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SwingWorker.SwingWorkerPropertyChangeSupport.1
 * JD-Core Version:    0.7.0.1
 */