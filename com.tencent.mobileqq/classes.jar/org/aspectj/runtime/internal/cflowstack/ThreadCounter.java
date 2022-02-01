package org.aspectj.runtime.internal.cflowstack;

public abstract interface ThreadCounter
{
  public abstract void dec();
  
  public abstract void inc();
  
  public abstract boolean isNotZero();
  
  public abstract void removeThreadCounter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.cflowstack.ThreadCounter
 * JD-Core Version:    0.7.0.1
 */