package com.tencent.mobileqq.qqgift.utils;

import android.util.Log;

public class ThreadManager$TaskProxy
  implements Comparable<TaskProxy>, Runnable
{
  int a;
  Runnable b;
  StackTraceElement[] c;
  
  ThreadManager$TaskProxy(int paramInt, Runnable paramRunnable)
  {
    this.a = paramInt;
    this.b = paramRunnable;
    if (ThreadManager.b) {
      this.c = new Throwable().getStackTrace();
    }
  }
  
  public int a(TaskProxy paramTaskProxy)
  {
    return this.a - paramTaskProxy.a;
  }
  
  void a()
  {
    if (this.c != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c[3].getClassName());
      ((StringBuilder)localObject).append("(line ");
      ((StringBuilder)localObject).append(this.c[3].getLineNumber());
      ((StringBuilder)localObject).append("):");
      ((StringBuilder)localObject).append(this.c[3].getMethodName());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("one task has consumed too long time:\n");
      localStringBuilder.append((String)localObject);
      Log.e("taskproxy_log", localStringBuilder.toString());
    }
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    this.b.run();
    if (System.currentTimeMillis() - l > 5000L) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.ThreadManager.TaskProxy
 * JD-Core Version:    0.7.0.1
 */