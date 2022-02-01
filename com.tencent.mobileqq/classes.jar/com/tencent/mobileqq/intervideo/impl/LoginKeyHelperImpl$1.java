package com.tencent.mobileqq.intervideo.impl;

import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class LoginKeyHelperImpl$1
  extends WtloginListener
{
  LoginKeyHelperImpl$1(LoginKeyHelperImpl paramLoginKeyHelperImpl, String paramString) {}
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    super.OnException(paramErrMsg, paramInt, paramWUserSigInfo);
    if (QLog.isColorLevel())
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("获取Now结合版A1票据返回异常，cmd = ");
      paramWUserSigInfo.append(paramInt);
      paramWUserSigInfo.append(" errmsg = ");
      paramWUserSigInfo.append(paramErrMsg.getMessage());
      QLog.i("XProxy", 2, paramWUserSigInfo.toString());
    }
    LoginKeyHelperImpl.access$000(this.b, this.a, false, paramInt);
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      this.b.mAccountInfo.d = this.b.wtloginHelper.PrepareQloginResult(paramString, paramLong4, paramLong5, paramInt2, paramWFastLoginInfo);
      this.b.mLastUpdatedTime = System.currentTimeMillis();
      LoginKeyHelperImpl.access$000(this.b, this.a, true, 0);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("获取Now结合版A1票据返回失败，retCode = ");
      paramString.append(paramInt2);
      QLog.i("XProxy", 2, paramString.toString());
    }
    LoginKeyHelperImpl.access$000(this.b, this.a, false, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.impl.LoginKeyHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */