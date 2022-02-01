package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class SendHbActivity$1
  extends BroadcastReceiver
{
  SendHbActivity$1(SendHbActivity paramSendHbActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.qwallet.report".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("type", 0);
      paramContext = new StringBuilder();
      paramContext.append("onReceive type = ");
      paramContext.append(i);
      QLog.i("SendHbActivity", 2, paramContext.toString());
      if (999 != i) {
        return;
      }
      paramContext = paramIntent.getBundleExtra("params");
      if (paramContext == null) {
        return;
      }
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive bundle = ");
      paramIntent.append(paramContext.toString());
      QLog.i("SendHbActivity", 2, paramIntent.toString());
      paramContext = paramContext.getString("from");
      if ((!this.a.isFinishing()) && ("video".equals(paramContext))) {
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity.1
 * JD-Core Version:    0.7.0.1
 */