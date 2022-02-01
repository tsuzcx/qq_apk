package com.tencent.open.agent;

import android.os.Process;

class QuickLoginAuthorityActivity$9
  extends Thread
{
  QuickLoginAuthorityActivity$9(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      Process.killProcess(Process.myPid());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.9
 * JD-Core Version:    0.7.0.1
 */