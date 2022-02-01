package com.tencent.qplus.task;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AbstractBean
{
  private final PropertyChangeSupport pcs = new AbstractBean.EDTPropertyChangeSupport(this);
  
  public void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    this.pcs.addPropertyChangeListener(paramPropertyChangeListener);
  }
  
  public void addPropertyChangeListener(String paramString, PropertyChangeListener paramPropertyChangeListener)
  {
    this.pcs.addPropertyChangeListener(paramString, paramPropertyChangeListener);
  }
  
  protected void firePropertyChange(PropertyChangeEvent paramPropertyChangeEvent)
  {
    this.pcs.firePropertyChange(paramPropertyChangeEvent);
  }
  
  protected void firePropertyChange(String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramObject1.equals(paramObject2))) {
      return;
    }
    this.pcs.firePropertyChange(paramString, paramObject1, paramObject2);
  }
  
  public PropertyChangeListener[] getPropertyChangeListeners()
  {
    return this.pcs.getPropertyChangeListeners();
  }
  
  public void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
  {
    this.pcs.removePropertyChangeListener(paramPropertyChangeListener);
  }
  
  public void removePropertyChangeListener(String paramString, PropertyChangeListener paramPropertyChangeListener)
  {
    try
    {
      this.pcs.removePropertyChangeListener(paramString, paramPropertyChangeListener);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.task.AbstractBean
 * JD-Core Version:    0.7.0.1
 */