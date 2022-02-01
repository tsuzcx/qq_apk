package org.aspectj.runtime.internal;

import org.aspectj.lang.ProceedingJoinPoint;

public abstract class AroundClosure
{
  protected int bitflags = 1048576;
  protected Object[] preInitializationState;
  protected Object[] state;
  
  public AroundClosure() {}
  
  public AroundClosure(Object[] paramArrayOfObject)
  {
    this.state = paramArrayOfObject;
  }
  
  public int getFlags()
  {
    return this.bitflags;
  }
  
  public Object[] getPreInitializationState()
  {
    return this.preInitializationState;
  }
  
  public Object[] getState()
  {
    return this.state;
  }
  
  public ProceedingJoinPoint linkClosureAndJoinPoint()
  {
    Object localObject = this.state;
    localObject = (ProceedingJoinPoint)localObject[(localObject.length - 1)];
    ((ProceedingJoinPoint)localObject).set$AroundClosure(this);
    return localObject;
  }
  
  public ProceedingJoinPoint linkClosureAndJoinPoint(int paramInt)
  {
    Object localObject = this.state;
    localObject = (ProceedingJoinPoint)localObject[(localObject.length - 1)];
    ((ProceedingJoinPoint)localObject).set$AroundClosure(this);
    this.bitflags = paramInt;
    return localObject;
  }
  
  public ProceedingJoinPoint linkStackClosureAndJoinPoint(int paramInt)
  {
    Object localObject = this.state;
    localObject = (ProceedingJoinPoint)localObject[(localObject.length - 1)];
    ((ProceedingJoinPoint)localObject).stack$AroundClosure(this);
    this.bitflags = paramInt;
    return localObject;
  }
  
  public abstract Object run(Object[] paramArrayOfObject);
  
  public void unlink()
  {
    Object[] arrayOfObject = this.state;
    ((ProceedingJoinPoint)arrayOfObject[(arrayOfObject.length - 1)]).stack$AroundClosure(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.AroundClosure
 * JD-Core Version:    0.7.0.1
 */