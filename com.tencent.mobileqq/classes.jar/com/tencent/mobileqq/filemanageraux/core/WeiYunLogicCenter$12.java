package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdQueryMsgRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class WeiYunLogicCenter$12
  implements IWeiyunCallback<WeiyunPB.PwdQueryMsgRsp>
{
  WeiYunLogicCenter$12(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.PwdQueryMsgRsp paramPwdQueryMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramPwdQueryMsgRsp = new StringBuilder();
      paramPwdQueryMsgRsp.append("queryNeedVerifyPwd, onFailed. errorCode[");
      paramPwdQueryMsgRsp.append(paramInt);
      paramPwdQueryMsgRsp.append("],errorMsg[");
      paramPwdQueryMsgRsp.append(paramString);
      paramPwdQueryMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramPwdQueryMsgRsp.toString());
    }
    WeiYunLogicCenter.c(this.a).getFileManagerNotifyCenter().a(false, 44, new Object[] { Integer.valueOf(paramInt), paramString, null });
  }
  
  public void a(WeiyunPB.PwdQueryMsgRsp paramPwdQueryMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryNeedVerifyPwd, onSucceed  need pwd[");
      localStringBuilder.append(paramPwdQueryMsgRsp.pwd_open.get());
      localStringBuilder.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, localStringBuilder.toString());
    }
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).setPwdQueried(WeiYunLogicCenter.c(this.a).getApplication().getApplicationContext(), true);
    if (paramPwdQueryMsgRsp.pwd_open.get()) {
      ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).setPwdOpened(WeiYunLogicCenter.c(this.a).getApplication().getApplicationContext(), true);
    }
    WeiYunLogicCenter.c(this.a).getFileManagerNotifyCenter().a(true, 44, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(paramPwdQueryMsgRsp.pwd_open.get()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.12
 * JD-Core Version:    0.7.0.1
 */