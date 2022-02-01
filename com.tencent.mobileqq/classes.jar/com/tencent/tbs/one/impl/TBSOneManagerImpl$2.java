package com.tencent.tbs.one.impl;

import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.policy.PolicyManager;

class TBSOneManagerImpl$2
  implements Runnable
{
  TBSOneManagerImpl$2(TBSOneManagerImpl paramTBSOneManagerImpl, String paramString, Bundle paramBundle, TBSOneCallback paramTBSOneCallback) {}
  
  public void run()
  {
    TBSOneManagerImpl.access$000(this.this$0).installComponent(this.val$name, this.val$options, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.TBSOneManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */