package org.aspectj.runtime.internal.cflowstack;

public class ThreadStackFactoryImpl
  implements ThreadStackFactory
{
  public ThreadCounter getNewThreadCounter()
  {
    return new ThreadStackFactoryImpl.ThreadCounterImpl(null);
  }
  
  public ThreadStack getNewThreadStack()
  {
    return new ThreadStackFactoryImpl.ThreadStackImpl(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl
 * JD-Core Version:    0.7.0.1
 */