package com.tencent.mqp.app.sec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class MQPSensitiveMsgUtil$4
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if ((paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (paramIntent.getIntExtra("type", 0) != 0))
    {
      MQPSensitiveMsgUtil.c(paramIntent.getStringExtra("account"));
      MQPSensitiveMsgUtil.d(MQPSensitiveMsgUtil.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.4
 * JD-Core Version:    0.7.0.1
 */