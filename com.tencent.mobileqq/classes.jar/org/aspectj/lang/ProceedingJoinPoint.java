package org.aspectj.lang;

import org.aspectj.runtime.internal.AroundClosure;

public abstract interface ProceedingJoinPoint
  extends JoinPoint
{
  public abstract Object proceed();
  
  public abstract Object proceed(Object[] paramArrayOfObject);
  
  public abstract void set$AroundClosure(AroundClosure paramAroundClosure);
  
  public abstract void stack$AroundClosure(AroundClosure paramAroundClosure);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.ProceedingJoinPoint
 * JD-Core Version:    0.7.0.1
 */