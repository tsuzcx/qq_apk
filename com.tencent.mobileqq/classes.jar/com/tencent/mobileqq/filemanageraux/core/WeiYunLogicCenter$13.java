package com.tencent.mobileqq.filemanageraux.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdVerifyMsgRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class WeiYunLogicCenter$13
  implements IWeiyunCallback<WeiyunPB.PwdVerifyMsgRsp>
{
  WeiYunLogicCenter$13(WeiYunLogicCenter paramWeiYunLogicCenter, String paramString) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramPwdVerifyMsgRsp = new StringBuilder();
      paramPwdVerifyMsgRsp.append("verifyPwd, onFailed. errorCode[");
      paramPwdVerifyMsgRsp.append(paramInt);
      paramPwdVerifyMsgRsp.append("],errorMsg[");
      paramPwdVerifyMsgRsp.append(paramString);
      paramPwdVerifyMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramPwdVerifyMsgRsp.toString());
    }
    WeiYunLogicCenter.c(this.b).getFileManagerNotifyCenter().a(false, 45, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdVerifyMsgRsp paramPwdVerifyMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
    }
    if (!TextUtils.isEmpty(this.a)) {
      ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).savePwdMd5(WeiYunLogicCenter.c(this.b).getApplication().getApplicationContext(), this.a);
    }
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).setPwdVerified(WeiYunLogicCenter.c(this.b).getApplication().getApplicationContext(), true);
    WeiYunLogicCenter.c(this.b).getFileManagerNotifyCenter().a(true, 45, new Object[] { Integer.valueOf(0), null, paramPwdVerifyMsgRsp.cs_sig.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.13
 * JD-Core Version:    0.7.0.1
 */