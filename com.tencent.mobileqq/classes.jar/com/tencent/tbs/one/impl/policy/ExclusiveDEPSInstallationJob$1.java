package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import com.tencent.tbs.one.impl.common.DEPSConfig;

class ExclusiveDEPSInstallationJob$1
  extends ProgressiveCallback<InstallationResult<DEPSConfig>>
{
  ExclusiveDEPSInstallationJob$1(ExclusiveDEPSInstallationJob paramExclusiveDEPSInstallationJob) {}
  
  public void onCompleted(InstallationResult<DEPSConfig> paramInstallationResult)
  {
    this.this$0.finish(paramInstallationResult);
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.this$0.fail(paramInt, paramString, paramThrowable);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.ExclusiveDEPSInstallationJob.1
 * JD-Core Version:    0.7.0.1
 */