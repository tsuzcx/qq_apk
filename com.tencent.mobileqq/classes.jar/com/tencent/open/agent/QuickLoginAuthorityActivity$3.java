package com.tencent.open.agent;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
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
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "wtloginObserver.OnCloseCode userAccount=" + paramString + " ret=" + paramInt);
    if (paramInt != 0) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131711211) + paramInt + ")", 2000).a();
    }
    this.a.a(QuickLoginAuthorityActivity.a(this.a, null));
  }
  
  public void onException(String paramString, int paramInt)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "wtloginObserver.OnException e=" + paramString);
    this.a.a(QuickLoginAuthorityActivity.a(this.a, null));
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "wtloginObserver.OnVerifyCode userAccount=" + paramString + " ret=" + paramInt);
    if (paramInt == 0)
    {
      paramArrayOfByte1 = new ArrayList();
      this.a.a.closeCode(paramString, 16L, QuickLoginAuthorityActivity.a(this.a), 1, paramArrayOfByte1, QuickLoginAuthorityActivity.a(this.a));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131711210) + paramInt + ")", 2000).a();
    this.a.a(QuickLoginAuthorityActivity.a(this.a, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.3
 * JD-Core Version:    0.7.0.1
 */