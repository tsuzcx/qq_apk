package com.tencent.tbs.one.impl.policy;

import android.os.Bundle;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.common.DEPSConfig;

class PolicyManager$1
  extends CancellableJob<DEPSConfig>
{
  PolicyManager$1(PolicyManager paramPolicyManager, Bundle paramBundle) {}
  
  public void run()
  {
    this.this$0.installDEPS(this.val$options, new PolicyManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.PolicyManager.1
 * JD-Core Version:    0.7.0.1
 */