package com.tencent.timi.game.float_window.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.timi.game.float_window.IFloatWindowStatusListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class FloatingStatusReceiver
  extends BroadcastReceiver
{
  private static int c = MobileQQ.sProcessId;
  private Context a;
  private boolean b = false;
  private List<IFloatWindowStatusListener> d = new ArrayList();
  
  public FloatingStatusReceiver(Context paramContext)
  {
    this.a = paramContext;
    paramContext = new IntentFilter();
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
  
  public void a()
  {
    this.a.getApplicationContext().unregisterReceiver(this);
  }
  
  public void a(IFloatWindowStatusListener paramIFloatWindowStatusListener)
  {
    if (!this.d.contains(paramIFloatWindowStatusListener)) {
      this.d.add(paramIFloatWindowStatusListener);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      paramContext = paramIntent.getStringExtra("process_name");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action: ");
      localStringBuilder.append(paramIntent.getAction());
      localStringBuilder.append(" processName:");
      localStringBuilder.append(paramContext);
      Logger.b("FloatingStatusReceiver", localStringBuilder.toString());
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
      {
        paramContext = this.d.iterator();
        while (paramContext.hasNext()) {
          ((IFloatWindowStatusListener)paramContext.next()).a();
        }
      }
      if ("mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()))
      {
        if ((paramContext != null) && (paramContext.equals("com.tencent.mobileqq")))
        {
          paramContext = this.d.iterator();
          while (paramContext.hasNext()) {
            ((IFloatWindowStatusListener)paramContext.next()).b();
          }
        }
      }
      else
      {
        int i;
        if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
        {
          if ((paramContext != null) && (paramContext.contains("openSdk"))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            paramContext = this.d.iterator();
            while (paramContext.hasNext()) {
              ((IFloatWindowStatusListener)paramContext.next()).c();
            }
          }
        }
        else if (("mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) || ("mqq.intent.action.ACCOUNT_KICKED".equals(paramIntent.getAction())) || ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramIntent.getAction())) || ("mqq.intent.action.FORCE_LOGOUT".equals(paramIntent.getAction())) || ("mqq.intent.action.LOGOUT".equals(paramIntent.getAction())))
        {
          i = paramIntent.getIntExtra("type", -1);
          paramContext = new StringBuilder();
          paramContext.append("cnrType=");
          paramContext.append(i);
          paramContext.append(" action=");
          paramContext.append(paramIntent.getAction());
          Logger.b("FloatingStatusReceiver", paramContext.toString());
          paramContext = this.d.iterator();
          while (paramContext.hasNext()) {
            ((IFloatWindowStatusListener)paramContext.next()).d();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.FloatingStatusReceiver
 * JD-Core Version:    0.7.0.1
 */