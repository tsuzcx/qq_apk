package com.tencent.tbs.one.impl.policy.auto;

import com.tencent.tbs.one.impl.base.ProgressInputStream.Client;

class AutoComponentInstallationJob$8
  implements ProgressInputStream.Client
{
  AutoComponentInstallationJob$8(AutoComponentInstallationJob paramAutoComponentInstallationJob) {}
  
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
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoComponentInstallationJob.8
 * JD-Core Version:    0.7.0.1
 */