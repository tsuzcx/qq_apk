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
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    Process.killProcess(Process.myPid());
    ax.b("myPid", Integer.valueOf(Process.myPid()));
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.bb
 * JD-Core Version:    0.7.0.1
 */