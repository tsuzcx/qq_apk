package com.tencent.qqconnect.wtlogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

class Login$10
  extends BroadcastReceiver
{
  Login$10(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.d("Login", 1, "mPuzzleVerifyCodeReceiver onReceive null == oldIntent");
      return;
    }
    QLog.d("Login", 1, "mPuzzleVerifyCodeReceiver onReceive");
    AuthorityUtil.a(paramIntent, paramContext);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.10
 * JD-Core Version:    0.7.0.1
 */