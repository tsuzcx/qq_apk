package com.tencent.qqconnect.wtlogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.agent.util.SSOLog;

class OpenSDKAppInterface$1
  extends BroadcastReceiver
{
  OpenSDKAppInterface$1(OpenSDKAppInterface paramOpenSDKAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = new StringBuilder();
    paramIntent.append("onReceive action : ");
    paramIntent.append(paramContext);
    SSOLog.a("OpenSDKAppInterface", new Object[] { paramIntent.toString() });
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramContext)) {
      OpenSDKAppInterface.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.OpenSDKAppInterface.1
 * JD-Core Version:    0.7.0.1
 */