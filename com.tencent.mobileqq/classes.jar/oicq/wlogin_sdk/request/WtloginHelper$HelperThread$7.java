package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$7
  implements Runnable
{
  WtloginHelper$HelperThread$7(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    Object localObject = t.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = ((async_context)localObject)._last_err_msg;
    t.c(this.this$1.mUserSigInfo._seqence);
    WtloginHelper.HelperThread.access$700(this.this$1, (async_context)localObject);
    WtloginHelper.HelperThread.access$800(this.this$1, (async_context)localObject, this.val$ret);
    if (this.this$1.mDwDstAppid == WtloginHelper.access$1500(this.this$1.this$0))
    {
      localObject = this.this$1;
      ((WtloginHelper.HelperThread)localObject).mDwDstAppid = ((WtloginHelper.HelperThread)localObject).mDwSubDstAppid;
      this.this$1.mDwSubDstAppid = 0L;
    }
    if (this.this$1.mPromise != null)
    {
      localErrMsg.setType(this.val$ret);
      int i = this.val$ret;
      if (i == 0)
      {
        this.this$1.mPromise.Done(null);
        return;
      }
      if (i == -1000)
      {
        this.this$1.mPromise.Timeout(localErrMsg);
        return;
      }
      this.this$1.mPromise.Failed(localErrMsg);
      return;
    }
    if (WtloginHelper.access$200(this.this$1.mHelper) == null) {
      return;
    }
    if ((this.this$1.mDwDstSubAppidList == null) && (!WtloginHelper.access$300(this.this$1.this$0).e()))
    {
      WtloginHelper.access$200(this.this$1.mHelper).OnGetStWithoutPasswd(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mDwDstAppid, this.this$1.mDwMainSigMap, this.this$1.mDwSubDstAppid, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
      return;
    }
    WtloginHelper.access$200(this.this$1.mHelper).OnGetStWithoutPasswd(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mDwDstAppid, this.this$1.mDwMainSigMap, this.this$1.mDwSubDstAppid, this.this$1.mDwDstSubAppidList, this.this$1.mUserSigInfo, this.this$1.mST, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.7
 * JD-Core Version:    0.7.0.1
 */