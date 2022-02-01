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
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.9
 * JD-Core Version:    0.7.0.1
 */