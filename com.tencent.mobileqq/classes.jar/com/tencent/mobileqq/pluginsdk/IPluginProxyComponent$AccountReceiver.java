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
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          str = paramIntent.getAction();
          if (DebugHelper.sDebug) {
            DebugHelper.log("PluginRuntime.AccountReceiver.onReceive: " + str);
          }
        } while (paramContext.getPackageName().equals(MobileQQ.processName));
        if (!"mqq.intent.action.ACCOUNT_CHANGED".equals(str)) {
          break;
        }
      } while (paramIntent.getStringExtra("account") == null);
      return;
    } while ((!"mqq.intent.action.LOGOUT".equals(str)) && (!("mqq.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName()).equals(str)));
    IPluginProxyComponent.exitProcess(paramIntent.getStringExtra("K_EXCEP"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IPluginProxyComponent.AccountReceiver
 * JD-Core Version:    0.7.0.1
 */