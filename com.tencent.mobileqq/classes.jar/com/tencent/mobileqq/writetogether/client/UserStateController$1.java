package com.tencent.mobileqq.writetogether.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class UserStateController$1
  extends BroadcastReceiver
{
  UserStateController$1(UserStateController paramUserStateController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.TIME_TICK".equals(paramContext))
    {
      this.a.b();
      return;
    }
    if ("android.intent.action.TIME_SET".equals(paramContext))
    {
      this.a.b();
      return;
    }
    if ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.UserStateController.1
 * JD-Core Version:    0.7.0.1
 */