package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import java.io.File;

class ExclusiveComponentInstallationJob$1
  extends ProgressiveCallback<InstallationResult<File>>
{
  ExclusiveComponentInstallationJob$1(ExclusiveComponentInstallationJob paramExclusiveComponentInstallationJob) {}
  
  public void onCompleted(InstallationResult<File> paramInstallationResult)
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
 * Qualified Name:     com.tencent.tbs.one.impl.policy.ExclusiveComponentInstallationJob.1
 * JD-Core Version:    0.7.0.1
 */