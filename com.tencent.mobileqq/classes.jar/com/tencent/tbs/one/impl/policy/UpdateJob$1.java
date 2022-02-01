package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.CoreThreadCallback;
import com.tencent.tbs.one.impl.common.DEPSConfig;

class UpdateJob$1
  extends CoreThreadCallback<InstallationResult<DEPSConfig>>
{
  UpdateJob$1(UpdateJob paramUpdateJob, String paramString, PolicyManagerImpl paramPolicyManagerImpl) {}
  
  public void onCompleted(InstallationResult<DEPSConfig> paramInstallationResult)
  {
    Logging.i("[%s] Finished Requesting the latest DEPS#%d from %s", new Object[] { this.val$category, Integer.valueOf(((DEPSConfig)paramInstallationResult.result).getVersionCode()), paramInstallationResult.source });
    this.val$policyManager.populateDEPSExtra(paramInstallationResult);
    UpdateJob.access$100(this.this$0, UpdateJob.access$000(this.this$0), (DEPSConfig)paramInstallationResult.result);
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    Logging.e("[%s] Failed to request the latest DEPS, error: [%d] %s", new Object[] { this.val$category, Integer.valueOf(paramInt), paramString, paramThrowable });
    this.this$0.fail(paramInt, paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.UpdateJob.1
 * JD-Core Version:    0.7.0.1
 */