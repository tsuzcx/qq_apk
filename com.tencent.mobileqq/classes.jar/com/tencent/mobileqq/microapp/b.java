package com.tencent.mobileqq.microapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class b
  extends BroadcastReceiver
{
  b(MiniAppInterface paramMiniAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("accountReceiver.onReceive broacast action=");
        paramIntent.append(paramContext);
        QLog.w("MiniAppInterface", 2, paramIntent.toString());
      }
      if ((!"com.tencent.process.exit".equals(paramContext)) && (!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramContext)) && (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext)) && (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(paramContext)) && (!"mqq.intent.action.LOGOUT".equals(paramContext)))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("mqq.intent.action.EXIT_");
        paramIntent.append(MiniAppInterface.access$100(this.a).getPackageName());
        if (!paramIntent.toString().equals(paramContext)) {}
      }
      else
      {
        this.a.exitProcess();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.b
 * JD-Core Version:    0.7.0.1
 */