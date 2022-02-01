package org.aspectj.runtime.internal;

import org.aspectj.runtime.CFlow;

public class CFlowPlusState
  extends CFlow
{
  private Object[] state;
  
  public CFlowPlusState(Object[] paramArrayOfObject)
  {
    this.state = paramArrayOfObject;
  }
  
  public CFlowPlusState(Object[] paramArrayOfObject, Object paramObject)
  {
    super(paramObject);
    this.state = paramArrayOfObject;
  }
  
  public Object get(int paramInt)
  {
    return this.state[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.CFlowPlusState
 * JD-Core Version:    0.7.0.1
 */