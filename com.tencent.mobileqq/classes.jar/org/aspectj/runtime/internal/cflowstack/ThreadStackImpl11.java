package org.aspectj.runtime.internal.cflowstack;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

public class ThreadStackImpl11
  implements ThreadStack
{
  private static final int COLLECT_AT = 20000;
  private static final int MIN_COLLECT_AT = 100;
  private Stack cached_stack;
  private Thread cached_thread;
  private int change_count = 0;
  private Hashtable stacks = new Hashtable();
  
  public Stack getThreadStack()
  {
    try
    {
      if (Thread.currentThread() != this.cached_thread)
      {
        this.cached_thread = Thread.currentThread();
        this.cached_stack = ((Stack)this.stacks.get(this.cached_thread));
        if (this.cached_stack == null)
        {
          this.cached_stack = new Stack();
          this.stacks.put(this.cached_thread, this.cached_stack);
        }
        this.change_count += 1;
        int i = Math.max(1, this.stacks.size());
        if (this.change_count > Math.max(100, 20000 / i))
        {
          localObject1 = new Stack();
          Object localObject3 = this.stacks.keys();
          while (((Enumeration)localObject3).hasMoreElements())
          {
            Thread localThread = (Thread)((Enumeration)localObject3).nextElement();
            if (!localThread.isAlive()) {
              ((Stack)localObject1).push(localThread);
            }
          }
          localObject1 = ((Stack)localObject1).elements();
          while (((Enumeration)localObject1).hasMoreElements())
          {
            localObject3 = (Thread)((Enumeration)localObject1).nextElement();
            this.stacks.remove(localObject3);
          }
          this.change_count = 0;
        }
      }
      Object localObject1 = this.cached_stack;
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void removeThreadStack() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.cflowstack.ThreadStackImpl11
 * JD-Core Version:    0.7.0.1
 */