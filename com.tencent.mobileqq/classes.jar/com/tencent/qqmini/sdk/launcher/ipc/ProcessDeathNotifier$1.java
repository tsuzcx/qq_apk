package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.IBinder.DeathRecipient;

class ProcessDeathNotifier$1
  implements IBinder.DeathRecipient
{
  ProcessDeathNotifier$1(ProcessDeathNotifier paramProcessDeathNotifier, Runnable paramRunnable) {}
  
  public void binderDied()
  {
    this.val$deathCallback.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.ProcessDeathNotifier.1
 * JD-Core Version:    0.7.0.1
 */