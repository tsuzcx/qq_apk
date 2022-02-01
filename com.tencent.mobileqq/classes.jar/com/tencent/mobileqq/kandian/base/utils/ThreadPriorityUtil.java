package com.tencent.mobileqq.kandian.base.utils;

import android.os.Looper;

public class ThreadPriorityUtil
{
  private Thread a = Looper.getMainLooper().getThread();
  private Thread b;
  private int c = this.a.getPriority();
  private int d;
  
  public ThreadPriorityUtil()
  {
    for (ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup(); localThreadGroup.getParent() != null; localThreadGroup = localThreadGroup.getParent()) {}
    Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
    localThreadGroup.enumerate(arrayOfThread);
    int i = 0;
    while (i < arrayOfThread.length)
    {
      if ((arrayOfThread[i] != null) && (arrayOfThread[i].isAlive()) && (arrayOfThread[i].getName().equalsIgnoreCase("RenderThread")))
      {
        this.b = arrayOfThread[i];
        this.d = this.b.getPriority();
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    this.a.setPriority(10);
    Thread localThread = this.b;
    if (localThread != null) {
      localThread.setPriority(10);
    }
  }
  
  public void b()
  {
    this.a.setPriority(this.c);
    Thread localThread = this.b;
    if (localThread != null) {
      localThread.setPriority(this.d);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("main:");
    localStringBuilder2.append(this.a.getPriority());
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.b != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" render:");
      localStringBuilder2.append(this.b.getPriority());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ThreadPriorityUtil
 * JD-Core Version:    0.7.0.1
 */