package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$11
  implements Runnable
{
  WtloginHelper$HelperThread$11(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    async_context localasync_context = t.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localasync_context._last_err_msg;
    if (this.this$1.mExtraFlag == 1)
    {
      WtloginHelper.access$200(this.this$1.mHelper).OnCheckSMSVerifyLoginAccount(this.this$1.mAppid1, this.this$1.mSubAppid1, this.this$1.mUserAccount, localasync_context._smslogin_msg, localasync_context._smslogin_msgcnt, localasync_context._smslogin_timelimit, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
      return;
    }
    WtloginHelper.access$200(this.this$1.mHelper).OnCheckSMSVerifyLoginAccountForReview(this.this$1.mAppid1, this.this$1.mSubAppid1, localasync_context._smslogin_zone, localasync_context._smslogin_hint_mobile, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.11
 * JD-Core Version:    0.7.0.1
 */