package com.tencent.tbs.one.impl.policy.online;

import com.tencent.tbs.one.impl.base.ProgressInputStream.Client;

class OnlineComponentInstallationJob$3
  implements ProgressInputStream.Client
{
  OnlineComponentInstallationJob$3(OnlineComponentInstallationJob paramOnlineComponentInstallationJob) {}
  
  public boolean canContinue()
  {
    return !this.this$0.isCancelled();
  }
  
  public void onProgressChanged(int paramInt)
  {
    this.this$0.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.online.OnlineComponentInstallationJob.3
 * JD-Core Version:    0.7.0.1
 */