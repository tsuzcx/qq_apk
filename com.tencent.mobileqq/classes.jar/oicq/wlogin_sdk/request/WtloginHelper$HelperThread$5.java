package oicq.wlogin_sdk.request;

import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t17b;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class WtloginHelper$HelperThread$5
  implements Runnable
{
  WtloginHelper$HelperThread$5(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    async_context localasync_context = t.b(this.this$1.mUserSigInfo._seqence);
    if (localasync_context._t543 != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("context from seq ");
      ((StringBuilder)localObject).append(this.this$1.mUserSigInfo._seqence);
      ((StringBuilder)localObject).append(" tlv length ");
      ((StringBuilder)localObject).append(localasync_context._t543.get_data_len());
      util.LOGI(((StringBuilder)localObject).toString(), this.this$1.mUserAccount);
      this.this$1.mUserSigInfo.loginResultTLVMap.put(new Integer(1347), localasync_context._t543);
    }
    Object localObject = localasync_context._last_err_msg;
    int i = localasync_context._t17b.get_available_msg_cnt();
    int j = localasync_context._t17b.get_time_limit();
    WtloginHelper.access$200(this.this$1.mHelper).OnRefreshSMSData(this.this$1.mUserAccount, this.this$1.mSmsAppid, this.this$1.mUserSigInfo, i, j, this.val$ret, (ErrMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.5
 * JD-Core Version:    0.7.0.1
 */