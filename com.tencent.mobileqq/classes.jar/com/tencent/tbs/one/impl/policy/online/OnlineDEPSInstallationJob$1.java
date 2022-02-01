package com.tencent.tbs.one.impl.policy.online;

import com.tencent.tbs.one.impl.base.ProgressiveCallback;

class OnlineDEPSInstallationJob$1
  extends ProgressiveCallback<Integer>
{
  OnlineDEPSInstallationJob$1(OnlineDEPSInstallationJob paramOnlineDEPSInstallationJob) {}
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    OnlineDEPSInstallationJob.access$002(this.this$0, null);
    this.this$0.fail(paramInt, paramString, paramThrowable);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.online.OnlineDEPSInstallationJob.1
 * JD-Core Version:    0.7.0.1
 */