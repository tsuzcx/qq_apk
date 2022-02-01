package org.aspectj.runtime.internal.cflowstack;

class ThreadStackFactoryImpl$ThreadCounterImpl
  extends ThreadLocal
  implements ThreadCounter
{
  public void dec()
  {
    ThreadStackFactoryImpl.ThreadCounterImpl.Counter localCounter = getThreadCounter();
    localCounter.value -= 1;
  }
  
  public ThreadStackFactoryImpl.ThreadCounterImpl.Counter getThreadCounter()
  {
    return (ThreadStackFactoryImpl.ThreadCounterImpl.Counter)get();
  }
  
  public void inc()
  {
    ThreadStackFactoryImpl.ThreadCounterImpl.Counter localCounter = getThreadCounter();
    localCounter.value += 1;
  }
  
  public Object initialValue()
  {
    return new ThreadStackFactoryImpl.ThreadCounterImpl.Counter();
  }
  
  public boolean isNotZero()
  {
    return getThreadCounter().value != 0;
  }
  
  public void removeThreadCounter()
  {
    remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl.ThreadCounterImpl
 * JD-Core Version:    0.7.0.1
 */