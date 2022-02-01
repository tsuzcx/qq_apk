package org.aspectj.runtime.internal.cflowstack;

import java.util.Stack;

public abstract interface ThreadStack
{
  public abstract Stack getThreadStack();
  
  public abstract void removeThreadStack();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.cflowstack.ThreadStack
 * JD-Core Version:    0.7.0.1
 */