package com.tencent.tbs.one.impl.policy.auto;

import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import com.tencent.tbs.one.impl.common.Statistics;

class AutoDEPSInstallationJob$2
  extends ProgressiveCallback<Integer>
{
  AutoDEPSInstallationJob$2(AutoDEPSInstallationJob paramAutoDEPSInstallationJob) {}
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.this$0.fail(paramInt, paramString, paramThrowable);
    Statistics.reportAction(1002);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoDEPSInstallationJob.2
 * JD-Core Version:    0.7.0.1
 */