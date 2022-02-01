package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mqq.app.MobileQQ;

class IPluginProxyComponent$AccountReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      String str = paramIntent.getAction();
      if (DebugHelper.sDebug)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PluginRuntime.AccountReceiver.onReceive: ");
        localStringBuilder.append(str);
        DebugHelper.log(localStringBuilder.toString());
      }
      if (paramContext.getPackageName().equals(MobileQQ.processName)) {
        return;
      }
      if ("mqq.intent.action.ACCOUNT_CHANGED".equals(str))
      {
        paramIntent.getStringExtra("account");
        return;
      }
      if (!"mqq.intent.action.LOGOUT".equals(str))
      {
        paramContext = new StringBuilder();
        paramContext.append("mqq.intent.action.EXIT_");
        paramContext.append(MobileQQ.getMobileQQ().getPackageName());
        if (!paramContext.toString().equals(str)) {}
      }
      else
      {
        IPluginProxyComponent.exitProcess(paramIntent.getStringExtra("K_EXCEP"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IPluginProxyComponent.AccountReceiver
 * JD-Core Version:    0.7.0.1
 */