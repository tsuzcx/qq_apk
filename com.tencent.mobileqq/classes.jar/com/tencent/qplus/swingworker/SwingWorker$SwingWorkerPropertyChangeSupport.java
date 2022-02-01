package com.tencent.qplus.swingworker;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

class SwingWorker$SwingWorkerPropertyChangeSupport
  extends PropertyChangeSupport
{
  private Object source;
  
  SwingWorker$SwingWorkerPropertyChangeSupport(SwingWorker paramSwingWorker, Object paramObject)
  {
    super(paramObject);
    this.source = paramObject;
  }
  
  public void firePropertyChange(PropertyChangeEvent paramPropertyChangeEvent)
  {
    if (WorkerUtilities.isUIThread())
    {
      super.firePropertyChange(paramPropertyChangeEvent);
      return;
    }
    SwingWorker.access$0(this.this$0).add(new Runnable[] { new SwingWorker.SwingWorkerPropertyChangeSupport.1(this, paramPropertyChangeEvent) });
  }
  
  public void firePropertyChange(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    firePropertyChange(paramString, new Integer(paramInt1), new Integer(paramInt2));
  }
  
  public void firePropertyChange(String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) {
      return;
    }
    firePropertyChange(new PropertyChangeEvent(this.source, paramString, paramObject1, paramObject2));
  }
  
  public void firePropertyChange(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      return;
    }
    firePropertyChange(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SwingWorker.SwingWorkerPropertyChangeSupport
 * JD-Core Version:    0.7.0.1
 */