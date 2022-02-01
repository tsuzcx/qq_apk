package com.tencent.tbs.one.impl.policy.auto;

import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import com.tencent.tbs.one.impl.common.Statistics;
import com.tencent.tbs.one.impl.policy.InstallationUtils;

class AutoComponentInstallationJob$4
  extends ProgressiveCallback<Integer>
{
  AutoComponentInstallationJob$4(AutoComponentInstallationJob paramAutoComponentInstallationJob) {}
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.this$0.fail(paramInt, paramString, paramThrowable);
    if (AutoComponentInstallationJob.access$800(this.this$0))
    {
      Statistics.reportAction(1016, AutoComponentInstallationJob.access$900(this.this$0));
      return;
    }
    Statistics.reportAction(1006, AutoComponentInstallationJob.access$900(this.this$0));
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$0.setProgress(InstallationUtils.computeProgress(paramInt2, 0, 40));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoComponentInstallationJob.4
 * JD-Core Version:    0.7.0.1
 */