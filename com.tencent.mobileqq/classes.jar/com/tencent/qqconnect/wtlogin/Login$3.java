package com.tencent.qqconnect.wtlogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class Login$3
  extends BroadcastReceiver
{
  Login$3(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("Login", 1, "onReceive action = " + paramIntent.getAction());
    if ("mqq.intent.action.QRCODE_LOGIN_FINISH".equals(paramIntent.getAction()))
    {
      paramContext = new Intent();
      paramContext.putExtra("param_qr_code_url", paramIntent.getStringExtra("param_qr_code_url"));
      paramContext.putExtra("param_is_qr_code_login", true);
      this.a.setResult(-1, paramContext);
      this.a.finish();
      Login.a(this.a, 2, "0X800BA19");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.3
 * JD-Core Version:    0.7.0.1
 */