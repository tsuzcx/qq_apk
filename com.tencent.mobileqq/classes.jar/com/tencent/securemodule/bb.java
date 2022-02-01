package com.tencent.securemodule;

import android.os.Process;

final class bb
  implements Runnable
{
  public void run()
  {
    try
    {
      Thread.sleep(2000L);
      Process.killProcess(Process.myPid());
      ax.b("myPid", Integer.valueOf(Process.myPid()));
      System.exit(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.bb
 * JD-Core Version:    0.7.0.1
 */