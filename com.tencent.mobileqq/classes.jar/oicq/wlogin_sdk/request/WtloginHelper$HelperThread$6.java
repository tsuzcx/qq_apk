package oicq.wlogin_sdk.request;

import java.util.HashMap;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class WtloginHelper$HelperThread$6
  implements Runnable
{
  WtloginHelper$HelperThread$6(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    Object localObject = t.b(this.this$1.mUserSigInfo._seqence);
    WtloginHelper.HelperThread.access$600(this.this$1, (async_context)localObject, this.val$ret);
    if (((async_context)localObject)._t543 != null)
    {
      util.LOGI("context from seq " + this.this$1.mUserSigInfo._seqence + " tlv length " + ((async_context)localObject)._t543.get_data_len(), this.this$1.mUserAccount);
      this.this$1.mUserSigInfo.loginResultTLVMap.put(new Integer(1347), ((async_context)localObject)._t543);
    }
    localObject = ((async_context)localObject)._last_err_msg;
    if (this.this$1.mST == null)
    {
      WtloginHelper.access$100(this.this$1.mHelper).OnCheckSMSAndGetSt(this.this$1.mUserAccount, this.this$1.mUserInput, this.this$1.mUserSigInfo, this.val$ret, (ErrMsg)localObject);
      return;
    }
    WtloginHelper.access$100(this.this$1.mHelper).OnCheckSMSAndGetSt(this.this$1.mUserAccount, this.this$1.mUserInput, this.this$1.mUserSigInfo, this.this$1.mST, this.val$ret, (ErrMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.6
 * JD-Core Version:    0.7.0.1
 */