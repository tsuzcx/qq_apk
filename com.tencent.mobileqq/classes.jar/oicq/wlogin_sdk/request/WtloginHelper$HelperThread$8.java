package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$8
  implements Runnable
{
  WtloginHelper$HelperThread$8(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    ErrMsg localErrMsg = t.b(this.this$1.mUserSigInfo._seqence)._last_err_msg;
    t.c(this.this$1.mUserSigInfo._seqence);
    WtloginHelper.access$200(this.this$1.mHelper).onGetA1WithA1(this.this$1.mUserAccount, this.this$1.mAppid1, this.this$1.mDwMainSigMap, this.this$1.mSubAppid1, this.this$1.mAppName2, this.this$1.mSsoVer2, this.this$1.mAppid2, this.this$1.mSubAppid2, this.this$1.mAppVer2, this.this$1.mAppSign2, this.this$1.mUserSigInfo, this.this$1.mFastLoginInfo, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.8
 * JD-Core Version:    0.7.0.1
 */