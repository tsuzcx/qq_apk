package org.aspectj.runtime.internal.cflowstack;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class ThreadCounterImpl11
  implements ThreadCounter
{
  private static final int COLLECT_AT = 20000;
  private static final int MIN_COLLECT_AT = 100;
  private ThreadCounterImpl11.Counter cached_counter;
  private Thread cached_thread;
  private int change_count = 0;
  private Hashtable counters = new Hashtable();
  
  private ThreadCounterImpl11.Counter getThreadCounter()
  {
    try
    {
      if (Thread.currentThread() != this.cached_thread)
      {
        this.cached_thread = Thread.currentThread();
        this.cached_counter = ((ThreadCounterImpl11.Counter)this.counters.get(this.cached_thread));
        if (this.cached_counter == null)
        {
          this.cached_counter = new ThreadCounterImpl11.Counter();
          this.counters.put(this.cached_thread, this.cached_counter);
        }
        this.change_count += 1;
        int i = Math.max(1, this.counters.size());
        if (this.change_count > Math.max(100, 20000 / i))
        {
          localObject1 = new ArrayList();
          Object localObject3 = this.counters.keys();
          while (((Enumeration)localObject3).hasMoreElements())
          {
            Thread localThread = (Thread)((Enumeration)localObject3).nextElement();
            if (!localThread.isAlive()) {
              ((List)localObject1).add(localThread);
            }
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Thread)((Iterator)localObject1).next();
            this.counters.remove(localObject3);
          }
          this.change_count = 0;
        }
      }
      Object localObject1 = this.cached_counter;
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void dec()
  {
    ThreadCounterImpl11.Counter localCounter = getThreadCounter();
    localCounter.value -= 1;
  }
  
  public void inc()
  {
    ThreadCounterImpl11.Counter localCounter = getThreadCounter();
    localCounter.value += 1;
  }
  
  public boolean isNotZero()
  {
    return getThreadCounter().value != 0;
  }
  
  public void removeThreadCounter() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.cflowstack.ThreadCounterImpl11
 * JD-Core Version:    0.7.0.1
 */