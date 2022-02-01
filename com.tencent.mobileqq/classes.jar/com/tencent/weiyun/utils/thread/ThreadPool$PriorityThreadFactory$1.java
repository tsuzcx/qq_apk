package com.tencent.weiyun.utils.thread;

import android.os.Process;

class ThreadPool$PriorityThreadFactory$1
  extends Thread
{
  ThreadPool$PriorityThreadFactory$1(ThreadPool.PriorityThreadFactory paramPriorityThreadFactory, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(ThreadPool.PriorityThreadFactory.access$100(this.this$0));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.ThreadPool.PriorityThreadFactory.1
 * JD-Core Version:    0.7.0.1
 */