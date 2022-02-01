package com.tencent.open.agent;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class QuickLoginAuthorityActivity$3
  extends WtloginObserver
{
  QuickLoginAuthorityActivity$3(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("wtloginObserver.OnCloseCode userAccount=");
    paramArrayOfByte1.append(paramString);
    paramArrayOfByte1.append(" ret=");
    paramArrayOfByte1.append(paramInt);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramArrayOfByte1.toString());
    if (paramInt != 0)
    {
      paramString = MobileQQ.sMobileQQ;
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append(HardCodeUtil.a(2131908845));
      paramArrayOfByte1.append(paramInt);
      paramArrayOfByte1.append(")");
      QQToast.makeText(paramString, 1, paramArrayOfByte1.toString(), 2000).show();
    }
    paramString = this.a;
    paramString.a(QuickLoginAuthorityActivity.a(paramString, null));
  }
  
  public void onException(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wtloginObserver.OnException e=");
    localStringBuilder.append(paramString);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
    paramString = this.a;
    paramString.a(QuickLoginAuthorityActivity.a(paramString, null));
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("wtloginObserver.OnVerifyCode userAccount=");
    paramArrayOfByte1.append(paramString);
    paramArrayOfByte1.append(" ret=");
    paramArrayOfByte1.append(paramInt);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramArrayOfByte1.toString());
    if (paramInt == 0)
    {
      paramArrayOfByte1 = new ArrayList();
      this.a.k.closeCode(paramString, 16L, QuickLoginAuthorityActivity.b(this.a), 1, paramArrayOfByte1, QuickLoginAuthorityActivity.c(this.a));
      return;
    }
    paramString = MobileQQ.sMobileQQ;
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append(HardCodeUtil.a(2131908844));
    paramArrayOfByte1.append(paramInt);
    paramArrayOfByte1.append(")");
    QQToast.makeText(paramString, 1, paramArrayOfByte1.toString(), 2000).show();
    paramString = this.a;
    paramString.a(QuickLoginAuthorityActivity.a(paramString, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.3
 * JD-Core Version:    0.7.0.1
 */