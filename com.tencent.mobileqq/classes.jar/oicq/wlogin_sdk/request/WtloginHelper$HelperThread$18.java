package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.util;

class WtloginHelper$HelperThread$18
  implements Runnable
{
  WtloginHelper$HelperThread$18(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    if (WtloginHelper.access$100(this.this$1.mHelper) == null)
    {
      util.LOGW("quickLoginByGateway helper listener is null", this.this$1.mUserAccount);
      return;
    }
    async_context localasync_context = t.b(this.this$1.mUserSigInfo._seqence);
    WtloginHelper.HelperThread.access$600(this.this$1, localasync_context);
    WtloginHelper.HelperThread.access$700(this.this$1, localasync_context, this.val$ret);
    WtloginHelper.HelperThread.access$2200(this.this$1, localasync_context);
    util.LOGW("quickLoginByGateway helper listener uin" + this.this$1.mUserSigInfo.uin, this.this$1.mUserAccount);
    WtloginHelper.access$100(this.this$1.mHelper).onLoginByGateway(this.val$ret, this.this$1.mUserSigInfo, this.this$1.mUserSigInfo.uin, localasync_context._last_err_msg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.18
 * JD-Core Version:    0.7.0.1
 */