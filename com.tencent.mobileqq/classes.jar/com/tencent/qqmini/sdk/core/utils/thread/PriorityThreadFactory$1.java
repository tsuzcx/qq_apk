package com.tencent.qqmini.sdk.core.utils.thread;

import android.os.Process;
import bgqi;

public class PriorityThreadFactory$1
  extends Thread
{
  public PriorityThreadFactory$1(bgqi parambgqi, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(bgqi.a(this.this$0));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.thread.PriorityThreadFactory.1
 * JD-Core Version:    0.7.0.1
 */