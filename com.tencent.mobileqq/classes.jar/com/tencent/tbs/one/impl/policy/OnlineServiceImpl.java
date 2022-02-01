package com.tencent.tbs.one.impl.policy;

import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ProcessLock;
import com.tencent.tbs.one.impl.base.ThreadUtils;

public class OnlineServiceImpl
  implements TBSOneOnlineService
{
  private PolicyManagerImpl mPolicyManager;
  private UpdateJob mUpdateJob;
  
  public OnlineServiceImpl(PolicyManagerImpl paramPolicyManagerImpl)
  {
    this.mPolicyManager = paramPolicyManagerImpl;
  }
  
  private void cancelUpdateOnCoreThread()
  {
    if (this.mUpdateJob != null) {
      this.mUpdateJob.cancel();
    }
  }
  
  private void releaseUpdateLock(ProcessLock paramProcessLock)
  {
    this.mUpdateJob = null;
    paramProcessLock.releaseQuietly();
  }
  
  private void updateOnCoreThread(Bundle paramBundle, TBSOneCallback<Void> paramTBSOneCallback)
  {
    if (this.mUpdateJob == null)
    {
      PolicyManagerImpl localPolicyManagerImpl = this.mPolicyManager;
      String str = localPolicyManagerImpl.getCategory();
      ProcessLock localProcessLock = localPolicyManagerImpl.tryAcquireUpdateLock();
      if (localProcessLock == null)
      {
        if (paramTBSOneCallback != null) {
          paramTBSOneCallback.onError(502, "Failed to acquire update lock");
        }
        return;
      }
      if (localPolicyManagerImpl.isUpdateAvailable())
      {
        Logging.i("[%s] No need to update because another process has updated", new Object[] { str });
        if (paramTBSOneCallback != null) {
          paramTBSOneCallback.onCompleted(null);
        }
        releaseUpdateLock(localProcessLock);
        return;
      }
      localPolicyManagerImpl.createIncompleteUpdateFlag();
      this.mUpdateJob = new UpdateJob(localPolicyManagerImpl, paramBundle);
      this.mUpdateJob.start(new OnlineServiceImpl.3(this, paramTBSOneCallback, localPolicyManagerImpl, localProcessLock));
      return;
    }
    this.mUpdateJob.start(new OnlineServiceImpl.4(this, paramTBSOneCallback));
  }
  
  public void cancelUpdate()
  {
    Logging.i("[%s] Canceling update", new Object[] { this.mPolicyManager.getCategory() });
    ThreadUtils.runOnCoreThread(new OnlineServiceImpl.2(this));
  }
  
  public boolean isUpdating()
  {
    return this.mUpdateJob != null;
  }
  
  public void update(Bundle paramBundle, TBSOneCallback<Void> paramTBSOneCallback)
  {
    String str = this.mPolicyManager.getCategory();
    Logging.i("[%s] Updating", new Object[] { str });
    if (this.mPolicyManager.isUpdateAvailable())
    {
      Logging.i("[%s] No need to update because the last update has not applied", new Object[] { str });
      if (paramTBSOneCallback != null) {
        paramTBSOneCallback.onCompleted(null);
      }
      return;
    }
    ThreadUtils.runOnCoreThread(new OnlineServiceImpl.1(this, paramBundle, paramTBSOneCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.OnlineServiceImpl
 * JD-Core Version:    0.7.0.1
 */