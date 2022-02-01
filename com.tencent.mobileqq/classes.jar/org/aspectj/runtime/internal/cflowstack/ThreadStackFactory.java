package org.aspectj.runtime.internal.cflowstack;

public abstract interface ThreadStackFactory
{
  public abstract ThreadCounter getNewThreadCounter();
  
  public abstract ThreadStack getNewThreadStack();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.cflowstack.ThreadStackFactory
 * JD-Core Version:    0.7.0.1
 */