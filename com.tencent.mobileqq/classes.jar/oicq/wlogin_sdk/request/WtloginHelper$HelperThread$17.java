package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class WtloginHelper$HelperThread$17
  implements Runnable
{
  WtloginHelper$HelperThread$17(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    if (WtloginHelper.access$100(this.this$1.mHelper) == null)
    {
      util.LOGW("login helper listener is null", this.this$1.mUserAccount);
      return;
    }
    async_context localasync_context = t.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localasync_context._last_err_msg;
    WtloginHelper.HelperThread.access$600(this.this$1, localasync_context, this.val$ret);
    byte[] arrayOfByte = null;
    if (localasync_context.tlv540 != null) {
      arrayOfByte = localasync_context.tlv540.get_data();
    }
    WtloginHelper.access$100(this.this$1.mHelper).onLoginByWeChat(localasync_context._uin, arrayOfByte, this.this$1.quickLoginParam, localasync_context._weixinUserFlags, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.17
 * JD-Core Version:    0.7.0.1
 */