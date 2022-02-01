package com.tencent.qqconnect.wtlogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;

class Login$8
  extends BroadcastReceiver
{
  Login$8(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      SSOLog.a("Login", new Object[] { "mPuzzleVerifyCodeReceiver onReceive null == oldIntent" });
      return;
    }
    SSOLog.a("Login", new Object[] { "mPuzzleVerifyCodeReceiver onReceive" });
    AuthorityUtil.a(paramIntent, paramContext);
    this.a.hideLoginTip();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.8
 * JD-Core Version:    0.7.0.1
 */