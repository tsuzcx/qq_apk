package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.impl.base.ProcessLock;

final class InstallationUtils$2
  implements Runnable
{
  InstallationUtils$2(ProcessLock paramProcessLock1, ProcessLock paramProcessLock2) {}
  
  public void run()
  {
    this.val$currentDEPSLock.releaseQuietly();
    if (this.val$latestDEPSLock != null) {
      this.val$latestDEPSLock.releaseQuietly();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.InstallationUtils.2
 * JD-Core Version:    0.7.0.1
 */