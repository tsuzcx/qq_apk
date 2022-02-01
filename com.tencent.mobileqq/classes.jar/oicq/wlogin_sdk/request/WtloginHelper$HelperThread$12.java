package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$12
  implements Runnable
{
  WtloginHelper$HelperThread$12(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    async_context localasync_context = t.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localasync_context._last_err_msg;
    WtloginHelper.HelperThread.access$700(this.this$1, localasync_context);
    WtloginHelper.HelperThread.access$2300(this.this$1, localasync_context);
    WtloginHelper.HelperThread.access$800(this.this$1, localasync_context, this.val$ret);
    WtloginHelper.access$200(this.this$1.mHelper).OnVerifySMSVerifyLoginCode(this.this$1.mUserAccount, this.this$1.mMsgCode, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.12
 * JD-Core Version:    0.7.0.1
 */