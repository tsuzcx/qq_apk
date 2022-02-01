package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import com.tencent.mobileqq.loginregister.LoginErrorInfo;
import com.tencent.mobileqq.loginregister.LoginProxy;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.loginwelcome.GatewayUtil;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager.AccountInfo;
import com.tencent.mobileqq.util.QuickLoginReporter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class LoginAccountFragment$3
  extends AccountObserver
{
  LoginAccountFragment$3(LoginAccountFragment paramLoginAccountFragment) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    QLog.d("LoginAccountFragment", 1, new Object[] { "onLoginFailed ret=", Integer.valueOf(paramInt1), " errorMsg", paramString2 });
    QuickLoginReporter.c(paramInt1, paramString2);
    if (LoginAccountFragment.a(this.a)) {
      return;
    }
    LoginAccountFragment.a(this.a);
    LoginUtils.b(LoginAccountFragment.a(this.a));
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      paramString1 = new LoginErrorInfo(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte1, paramInt2, paramArrayOfByte2, paramString4, LoginAccountFragment.a(this.a).getMaskUin(), LoginAccountFragment.a(this.a).getText().toString(), true);
      LoginAccountFragment.a(this.a).a(LoginAccountFragment.a(this.a), LoginAccountFragment.a(this.a), paramString1);
      LoginAccountFragment.b(this.a, paramString2);
      return;
    }
    QQToast.a(LoginAccountFragment.a(this.a), 2131694422, 0).a();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("LoginAccountFragment", 1, "onLoginSuccess");
    QuickLoginReporter.c(0, "SUCCESS");
    if (LoginAccountFragment.a(this.a)) {
      return;
    }
    LoginAccountFragment.a(this.a, paramArrayOfByte);
    LoginAccountFragment.a(this.a);
    GatewayUtil.a(LoginAccountFragment.a(this.a), LoginAccountFragment.a(this.a));
    LoginAccountFragment.a(this.a, paramString1);
    paramString2 = this.a.getQBaseActivity();
    if ((LoginAccountFragment.a(this.a) == 2) && (paramString2 != null))
    {
      paramArrayOfByte = new Intent();
      paramArrayOfByte.putExtra("last_account", paramString1);
      paramString2.setResult(-1, paramArrayOfByte);
      paramString2.finish();
    }
  }
  
  protected void onLoginTimeout(String paramString)
  {
    QLog.d("LoginAccountFragment", 1, new Object[] { "onLoginTimeout, ", paramString });
    QuickLoginReporter.c(1002, "login timeout");
    if (LoginAccountFragment.a(this.a)) {
      return;
    }
    QQToast.a(LoginAccountFragment.a(this.a), 2131694422, 0).a();
    LoginAccountFragment.a(this.a);
    paramString = this.a;
    LoginAccountFragment.b(paramString, paramString.getString(2131694422));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LoginAccountFragment.3
 * JD-Core Version:    0.7.0.1
 */