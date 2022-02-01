package com.tencent.mobileqq.qqgift.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadManager$ThreadImpl$1
  implements Runnable
{
  ThreadManager$ThreadImpl$1(ThreadManager.ThreadImpl paramThreadImpl, Runnable paramRunnable, ThreadManager.TaskProxy paramTaskProxy) {}
  
  public void run()
  {
    ThreadManager.ThreadImpl.a(this.this$0).remove(this.a);
    ThreadManager.ThreadImpl.b(this.this$0).execute(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.ThreadManager.ThreadImpl.1
 * JD-Core Version:    0.7.0.1
 */