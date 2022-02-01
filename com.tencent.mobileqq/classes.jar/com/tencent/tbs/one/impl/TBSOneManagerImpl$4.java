package com.tencent.tbs.one.impl;

import android.os.Bundle;
import com.tencent.tbs.one.impl.policy.PolicyManager;

class TBSOneManagerImpl$4
  implements Runnable
{
  TBSOneManagerImpl$4(TBSOneManagerImpl paramTBSOneManagerImpl, String paramString, Bundle paramBundle, SyncCallback paramSyncCallback) {}
  
  public void run()
  {
    TBSOneManagerImpl.access$000(this.this$0).loadComponent(this.val$name, this.val$options, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.TBSOneManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */