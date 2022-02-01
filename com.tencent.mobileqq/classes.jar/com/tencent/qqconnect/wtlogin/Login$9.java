package com.tencent.qqconnect.wtlogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class Login$9
  extends BroadcastReceiver
{
  Login$9(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("Login", 1, "AutoLoginReceiver onReceive");
    Login.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.9
 * JD-Core Version:    0.7.0.1
 */