package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowStatusListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class FloatingScreenStatusReceiver
  extends BroadcastReceiver
{
  private static int c = MobileQQ.sProcessId;
  private Context a;
  private boolean b = false;
  private IWindowStatusListener d;
  private int e;
  
  public FloatingScreenStatusReceiver(Context paramContext)
  {
    this.a = paramContext;
    paramContext = new IntentFilter();
    paramContext.addAction("tencent.mobileqq.floatingscreen.statuschange");
    paramContext.addAction("mqq.intent.action.QQ_BACKGROUND");
    paramContext.addAction("mqq.intent.action.QQ_FOREGROUND");
    paramContext.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.addAction("mqq.intent.action.ACCOUNT_KICKED");
    paramContext.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    paramContext.addAction("mqq.intent.action.FORCE_LOGOUT");
    paramContext.addAction("mqq.intent.action.LOGOUT");
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    this.a.getApplicationContext().registerReceiver(this, paramContext);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == -1) || (paramInt == this.e);
  }
  
  public void a()
  {
    this.a.getApplicationContext().unregisterReceiver(this);
  }
  
  public void a(int paramInt, IWindowStatusListener paramIWindowStatusListener)
  {
    this.e = paramInt;
    this.d = paramIWindowStatusListener;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      boolean bool = QLog.isColorLevel();
      int i = 1;
      if (bool) {
        QLog.d("FSReceiver", 4, new Object[] { "action: ", paramIntent.getAction() });
      }
      if ("tencent.mobileqq.floatingscreen.statuschange".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("param_concern_floating_type", -1);
        if (!a(i))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FSReceiver", 2, new Object[] { "type not available, concern:", Integer.valueOf(i), " ,curr:", Integer.valueOf(this.e) });
          }
          return;
        }
        i = paramIntent.getIntExtra("param_curr_window_status", 0);
        int j = paramIntent.getIntExtra("param_busitype", -1);
        if (QLog.isColorLevel()) {
          QLog.d("FSReceiver", 2, new Object[] { "busiType:", Integer.valueOf(j), " ,status:", Integer.valueOf(i), " ,hide:", Boolean.valueOf(this.b) });
        }
        if (paramIntent.hasExtra("param_ignored_processid"))
        {
          j = paramIntent.getIntExtra("param_ignored_processid", -1);
          if (c == j) {
            return;
          }
        }
        switch (i)
        {
        default: 
          return;
        case 104: 
          this.d.c();
          return;
        case 103: 
          this.d.a(true);
          this.b = false;
          return;
        }
        this.d.b();
        this.b = true;
        return;
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
      {
        this.d.a();
        return;
      }
      if ("mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()))
      {
        this.d.b();
        return;
      }
      if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
      {
        paramContext = paramIntent.getStringExtra("process_name");
        if ((paramContext == null) || (!paramContext.contains("openSdk"))) {
          i = 0;
        }
        if ((i == 0) && (!this.b)) {
          this.d.a(false);
        }
      }
      else if (("mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) || ("mqq.intent.action.ACCOUNT_KICKED".equals(paramIntent.getAction())) || ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramIntent.getAction())) || ("mqq.intent.action.FORCE_LOGOUT".equals(paramIntent.getAction())) || ("mqq.intent.action.LOGOUT".equals(paramIntent.getAction())))
      {
        i = paramIntent.getIntExtra("type", -1);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("cnrType=");
          paramContext.append(i);
          paramContext.append(" action=");
          paramContext.append(paramIntent.getAction());
          QLog.d("FSReceiver", 2, paramContext.toString());
        }
        this.d.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenStatusReceiver
 * JD-Core Version:    0.7.0.1
 */