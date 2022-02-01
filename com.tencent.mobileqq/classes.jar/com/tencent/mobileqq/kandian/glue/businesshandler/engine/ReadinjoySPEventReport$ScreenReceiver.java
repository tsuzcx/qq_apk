package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ReadinjoySPEventReport$ScreenReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      QLog.d("ReadinjoySPEventReport", 2, "receive screen off broadcast");
      ReadinjoySPEventReport.g(false);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
    {
      QLog.d("ReadinjoySPEventReport", 2, "receive screen on broadcast");
      ReadinjoySPEventReport.g(true);
      return;
    }
    if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
    {
      ReadinjoySPEventReport.c(false);
      ReadinjoySPEventReport.B();
      return;
    }
    if ("mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()))
    {
      ReadinjoySPEventReport.d(false);
      ReadinjoySPEventReport.B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScreenReceiver
 * JD-Core Version:    0.7.0.1
 */