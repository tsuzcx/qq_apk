package com.tencent.tbs.one.impl.policy;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.common.CoreThreadCallback;

class OnlineServiceImpl$4
  extends CoreThreadCallback<Void>
{
  OnlineServiceImpl$4(OnlineServiceImpl paramOnlineServiceImpl, TBSOneCallback paramTBSOneCallback) {}
  
  public void onCompleted(Void paramVoid)
  {
    this.val$callback.onCompleted(paramVoid);
  }
  
  public void onError(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.val$callback.onError(paramInt, paramString);
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    this.val$callback.onProgressChanged(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.OnlineServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */