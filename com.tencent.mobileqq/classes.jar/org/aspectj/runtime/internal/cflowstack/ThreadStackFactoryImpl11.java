package org.aspectj.runtime.internal.cflowstack;

public class ThreadStackFactoryImpl11
  implements ThreadStackFactory
{
  public ThreadCounter getNewThreadCounter()
  {
    return new ThreadCounterImpl11();
  }
  
  public ThreadStack getNewThreadStack()
  {
    return new ThreadStackImpl11();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11
 * JD-Core Version:    0.7.0.1
 */