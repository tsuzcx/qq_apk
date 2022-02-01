package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import com.tencent.tbs.one.impl.common.DEPSConfig;

class PolicyManagerImpl$3
  extends ProgressiveCallback<InstallationResult<DEPSConfig>>
{
  PolicyManagerImpl$3(PolicyManagerImpl paramPolicyManagerImpl) {}
  
  public void onCompleted(InstallationResult<DEPSConfig> paramInstallationResult)
  {
    this.this$0.populateDEPSExtra(paramInstallationResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.PolicyManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */