package com.tencent.upload.utils.pool;

import android.os.Process;

class PriorityThreadFactory$1
  extends Thread
{
  PriorityThreadFactory$1(PriorityThreadFactory paramPriorityThreadFactory, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(PriorityThreadFactory.access$000(this.this$0));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.utils.pool.PriorityThreadFactory.1
 * JD-Core Version:    0.7.0.1
 */