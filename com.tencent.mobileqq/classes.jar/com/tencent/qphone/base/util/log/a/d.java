package com.tencent.qphone.base.util.log.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.net.a.f;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class d
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b.f, 2, "onReceive broadcastreceiver.action null");
      }
      return;
    }
    paramIntent = b.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive broadcastreceiver.action = ");
    localStringBuilder.append(paramContext);
    QLog.d(paramIntent, 1, localStringBuilder.toString());
    boolean bool;
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      b.g = false;
      ac.V = -1;
      ac.W.set(false);
      if (com.tencent.mobileqq.msf.core.a.a.r())
      {
        b.f().removeMessages(10000);
        b.f().sendEmptyMessageDelayed(10000, com.tencent.mobileqq.msf.core.a.a.p());
      }
      else
      {
        b.h += 1;
        if (b.h == BaseConstants.checkExpiresLogScreenOffCount) {
          b.g();
        }
      }
      try
      {
        bool = com.tencent.mobileqq.msf.core.a.a.aQ();
        if (!bool) {
          return;
        }
        try
        {
          MsfService.core.sender.I.c().c();
          return;
        }
        catch (Exception paramContext)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.d(b.f, 2, "failed to call adaptorcontroller screenoff ", paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        paramIntent = b.f;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive ScreenOff to controller failed ");
        localStringBuilder.append(paramContext.toString());
        QLog.d(paramIntent, 1, localStringBuilder.toString(), paramContext);
        return;
      }
    }
    else if (paramContext.equals("android.intent.action.SCREEN_ON"))
    {
      b.g = true;
      b.f().removeMessages(10000);
      try
      {
        bool = com.tencent.mobileqq.msf.core.a.a.aQ();
        if (bool)
        {
          try
          {
            MsfService.core.sender.I.c().d();
            return;
          }
          catch (Exception paramContext)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.d(b.f, 2, "failed to call adaptorcontroller screenon ", paramContext);
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramIntent = b.f;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive ScreenOn to controller failed ");
        localStringBuilder.append(paramContext.toString());
        QLog.d(paramIntent, 1, localStringBuilder.toString(), paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.d
 * JD-Core Version:    0.7.0.1
 */