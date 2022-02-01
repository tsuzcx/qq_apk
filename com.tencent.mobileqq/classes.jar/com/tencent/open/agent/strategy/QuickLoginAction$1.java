package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.agent.util.SSOLog;

class QuickLoginAction$1
  extends BroadcastReceiver
{
  QuickLoginAction$1(QuickLoginAction paramQuickLoginAction) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    SSOLog.a("QuickLoginAction", new Object[] { "onReceive action=", paramIntent.getAction() });
    QuickLoginAction.a(this.a).unregisterReceiver(this);
    if (!"action_login_sucess".equals(paramIntent.getAction())) {
      return;
    }
    QuickLoginAction.a(this.a, paramIntent);
    QuickLoginAction.b(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.QuickLoginAction.1
 * JD-Core Version:    0.7.0.1
 */