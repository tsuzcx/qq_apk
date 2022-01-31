package com.tencent.securemodule;

import android.os.Process;

final class az
  implements Runnable
{
  public void run()
  {
    try
    {
      Thread.sleep(2000L);
      Process.killProcess(Process.myPid());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.securemodule.az
 * JD-Core Version:    0.7.0.1
 */