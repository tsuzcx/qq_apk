package com.tencent.qqmini.sdk.core.utils.thread;

import android.os.Process;
import bgmb;

public class PriorityThreadFactory$1
  extends Thread
{
  public PriorityThreadFactory$1(bgmb parambgmb, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(bgmb.a(this.this$0));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.thread.PriorityThreadFactory.1
 * JD-Core Version:    0.7.0.1
 */