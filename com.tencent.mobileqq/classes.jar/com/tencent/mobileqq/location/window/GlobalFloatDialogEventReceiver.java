package com.tencent.mobileqq.location.window;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GlobalFloatDialogEventReceiver
  extends BroadcastReceiver
{
  private GlobalFloatDialog a;
  
  private void b()
  {
    GlobalFloatDialog localGlobalFloatDialog = this.a;
    if (localGlobalFloatDialog != null) {
      localGlobalFloatDialog.b();
    }
  }
  
  private void c()
  {
    GlobalFloatDialog localGlobalFloatDialog = this.a;
    if (localGlobalFloatDialog != null) {
      localGlobalFloatDialog.d();
    }
  }
  
  private void d()
  {
    GlobalFloatDialog localGlobalFloatDialog = this.a;
    if (localGlobalFloatDialog != null) {
      localGlobalFloatDialog.c();
    }
  }
  
  public void a()
  {
    BaseApplication.getContext().unregisterReceiver(this);
  }
  
  public void a(GlobalFloatDialog paramGlobalFloatDialog)
  {
    this.a = paramGlobalFloatDialog;
    paramGlobalFloatDialog = new IntentFilter();
    paramGlobalFloatDialog.addAction("tencent.mobileqq.floatingscreen.statuschange");
    paramGlobalFloatDialog.addAction("mqq.intent.action.QQ_BACKGROUND");
    paramGlobalFloatDialog.addAction("mqq.intent.action.QQ_FOREGROUND");
    paramGlobalFloatDialog.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    paramGlobalFloatDialog.addAction("mqq.intent.action.ACCOUNT_KICKED");
    paramGlobalFloatDialog.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    paramGlobalFloatDialog.addAction("mqq.intent.action.FORCE_LOGOUT");
    paramGlobalFloatDialog.addAction("mqq.intent.action.LOGOUT");
    paramGlobalFloatDialog.addAction("android.intent.action.SCREEN_OFF");
    BaseApplication.getContext().registerReceiver(this, paramGlobalFloatDialog);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
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
      if (("mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) || ("mqq.intent.action.ACCOUNT_KICKED".equals(paramIntent.getAction())) || ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramIntent.getAction())) || ("mqq.intent.action.FORCE_LOGOUT".equals(paramIntent.getAction())) || ("mqq.intent.action.LOGOUT".equals(paramIntent.getAction()))) {
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.GlobalFloatDialogEventReceiver
 * JD-Core Version:    0.7.0.1
 */