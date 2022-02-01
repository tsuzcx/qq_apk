package org.aspectj.runtime.internal.cflowstack;

import java.util.Stack;

class ThreadStackFactoryImpl$ThreadStackImpl
  extends ThreadLocal
  implements ThreadStack
{
  public Stack getThreadStack()
  {
    return (Stack)get();
  }
  
  public Object initialValue()
  {
    return new Stack();
  }
  
  public void removeThreadStack()
  {
    remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl.ThreadStackImpl
 * JD-Core Version:    0.7.0.1
 */