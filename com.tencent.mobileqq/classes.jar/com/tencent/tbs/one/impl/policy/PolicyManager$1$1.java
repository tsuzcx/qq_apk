package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.impl.common.CoreThreadCallback;
import com.tencent.tbs.one.impl.common.DEPSConfig;

class PolicyManager$1$1
  extends CoreThreadCallback<InstallationResult<DEPSConfig>>
{
  PolicyManager$1$1(PolicyManager.1 param1) {}
  
  public void onCompleted(InstallationResult<DEPSConfig> paramInstallationResult)
  {
    PolicyManager.access$002(this.this$1.this$0, null);
    this.this$1.this$0.onDEPSLoaded(paramInstallationResult);
    this.this$1.finish(paramInstallationResult.result);
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    PolicyManager.access$002(this.this$1.this$0, null);
    this.this$1.fail(paramInt, paramString, paramThrowable);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.this$1.setProgress(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.PolicyManager.1.1
 * JD-Core Version:    0.7.0.1
 */