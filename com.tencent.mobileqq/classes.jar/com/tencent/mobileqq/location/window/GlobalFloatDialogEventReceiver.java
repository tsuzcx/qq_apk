package com.tencent.mobileqq.location.window;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import atuh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GlobalFloatDialogEventReceiver
  extends BroadcastReceiver
{
  private atuh a;
  
  private void b()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  private void c()
  {
    if (this.a != null) {
      this.a.d();
    }
  }
  
  private void d()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void a()
  {
    BaseApplicationImpl.context.unregisterReceiver(this);
  }
  
  public void a(atuh paramatuh)
  {
    this.a = paramatuh;
    paramatuh = new IntentFilter();
    paramatuh.addAction("tencent.mobileqq.floatingscreen.statuschange");
    paramatuh.addAction("mqq.intent.action.QQ_BACKGROUND");
    paramatuh.addAction("mqq.intent.action.QQ_FOREGROUND");
    paramatuh.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    paramatuh.addAction("mqq.intent.action.ACCOUNT_KICKED");
    paramatuh.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    paramatuh.addAction("mqq.intent.action.FORCE_LOGOUT");
    paramatuh.addAction("mqq.intent.action.LOGOUT");
    paramatuh.addAction("android.intent.action.SCREEN_OFF");
    BaseApplicationImpl.context.registerReceiver(this, paramatuh);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("GlobalFloatDialogEventReceiver", 4, new Object[] { "action: ", paramIntent.getAction() });
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
      {
        d();
        return;
      }
      if ("mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()))
      {
        d();
        return;
      }
      if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
      {
        c();
        return;
      }
    } while ((!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramIntent.getAction())) && (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(paramIntent.getAction())) && (!"mqq.intent.action.FORCE_LOGOUT".equals(paramIntent.getAction())) && (!"mqq.intent.action.LOGOUT".equals(paramIntent.getAction())));
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.GlobalFloatDialogEventReceiver
 * JD-Core Version:    0.7.0.1
 */