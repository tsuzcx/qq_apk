package com.tencent.mobileqq.mini;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class MiniAppInterface$2
  extends BroadcastReceiver
{
  MiniAppInterface$2(MiniAppInterface paramMiniAppInterface) {}
  
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
      if ("com.tencent.process.exit".equals(paramContext))
      {
        QLog.w("MiniAppInterface", 2, "accountReceiver.onReceive no exit!");
        return;
      }
      if ((!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramContext)) && (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext)) && (!"mqq.intent.action.LOGOUT".equals(paramContext)))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("mqq.intent.action.EXIT_");
        paramIntent.append(MiniAppInterface.access$100(this.this$0).getPackageName());
        if (!paramIntent.toString().equals(paramContext))
        {
          if ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramContext))
          {
            if (this.this$0.isLogin())
            {
              QLog.w("MiniAppInterface", 2, "user was logined in, not exit.");
              this.this$0.exitProcess();
              return;
            }
            QLog.w("MiniAppInterface", 2, "user was not logined in, not exit.");
            return;
          }
          if (!"com.tencent.mobile.mini.process.exit".equals(paramContext)) {
            return;
          }
          QLog.w("MiniAppInterface", 2, "ACTION_MINI_PROCESS_EXIT.onReceive exit!");
          this.this$0.exitProcess();
          return;
        }
      }
      this.this$0.exitProcess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.MiniAppInterface.2
 * JD-Core Version:    0.7.0.1
 */