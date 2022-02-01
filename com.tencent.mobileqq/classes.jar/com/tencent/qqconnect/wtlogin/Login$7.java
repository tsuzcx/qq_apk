package com.tencent.qqconnect.wtlogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.agent.util.SSOLog;

class Login$7
  extends BroadcastReceiver
{
  Login$7(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    SSOLog.a("Login", new Object[] { "AutoLoginReceiver onReceive" });
    Login.access$402(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.7
 * JD-Core Version:    0.7.0.1
 */