package com.tencent.timi.game.initer.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.utils.Logger;

public class TGQQAppLifecycleReceiver
  extends BroadcastReceiver
{
  private void a()
  {
    Logger.a("TGQQAppLifecycleReceiver", "postEvent - AppBecomeForegroundEvent");
    SimpleEventBus.getInstance().dispatchEvent(new AppBecomeForegroundEvent());
  }
  
  private void b()
  {
    Logger.a("TGQQAppLifecycleReceiver", "postEvent - AppBecomeBackgroundEvent");
    SimpleEventBus.getInstance().dispatchEvent(new AppBecomeBackgroundEvent());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      String str = paramIntent.getStringExtra("process_name");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive processName=");
      localStringBuilder.append(str);
      localStringBuilder.append(", action: ");
      localStringBuilder.append(paramIntent.getAction());
      Logger.a("TGQQAppLifecycleReceiver", localStringBuilder.toString());
      if ("mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()))
      {
        if ((str != null) && (str.equals("com.tencent.mobileqq")))
        {
          if (!BaseGesturePWDUtil.isAppOnForeground(paramContext))
          {
            b();
            return;
          }
          paramContext = new StringBuilder();
          paramContext.append("onReceive ACTION_QQ_BACKGROUND but AppOnForeground - ");
          paramContext.append(TimiGameActivityManager.a());
          Logger.c("TGQQAppLifecycleReceiver", paramContext.toString());
        }
      }
      else if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
      {
        int i;
        if ((str != null) && (str.contains("openSdk"))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          if (BaseGesturePWDUtil.isAppOnForeground(paramContext))
          {
            a();
            return;
          }
          paramContext = new StringBuilder();
          paramContext.append("onReceive ACTION_QQ_FOREGROUND but !isAppOnForeground - ");
          paramContext.append(TimiGameActivityManager.a());
          Logger.c("TGQQAppLifecycleReceiver", paramContext.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.TGQQAppLifecycleReceiver
 * JD-Core Version:    0.7.0.1
 */