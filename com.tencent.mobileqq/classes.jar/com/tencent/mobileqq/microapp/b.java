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
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.w("MiniAppInterface", 2, "accountReceiver.onReceive broacast action=" + paramContext);
      }
    } while ((!"com.tencent.process.exit".equals(paramContext)) && (!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramContext)) && (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext)) && (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(paramContext)) && (!"mqq.intent.action.LOGOUT".equals(paramContext)) && (!("mqq.intent.action.EXIT_" + MiniAppInterface.access$100(this.a).getPackageName()).equals(paramContext)));
    this.a.exitProcess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.b
 * JD-Core Version:    0.7.0.1
 */