package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.base.ProcessLock;
import com.tencent.tbs.one.impl.common.CoreThreadCallback;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.Statistics;

class OnlineServiceImpl$3
  extends CoreThreadCallback<Void>
{
  OnlineServiceImpl$3(OnlineServiceImpl paramOnlineServiceImpl, TBSOneCallback paramTBSOneCallback, PolicyManagerImpl paramPolicyManagerImpl, ProcessLock paramProcessLock) {}
  
  public void onCompleted(Void paramVoid)
  {
    this.val$policyManager.deleteIncompleteUpdateFlag();
    OnlineServiceImpl.access$200(this.this$0, this.val$processLock);
    this.val$callback.onCompleted(paramVoid);
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    DEPSConfig localDEPSConfig = this.val$policyManager.getDEPSConfig();
    if (localDEPSConfig != null) {}
    for (int i = localDEPSConfig.getVersionCode();; i = -1)
    {
      Statistics.reportError(i, "", -1, paramInt, paramString, paramThrowable);
      OnlineServiceImpl.access$200(this.this$0, this.val$processLock);
      this.val$callback.onError(paramInt, paramString);
      return;
    }
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.val$callback.onProgressChanged(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.OnlineServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */