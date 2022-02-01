package com.tencent.mobileqq.music;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QQPlayerService$QQPlayerBroadcastReceiverReceiver
  extends BroadcastReceiver
{
  QQPlayerService$QQPlayerBroadcastReceiverReceiver(QQPlayerService paramQQPlayerService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QQPlayerService.b(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQPlayerService", 2, "received broadcast after service destroy");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("QQPlayerBroadcastReceiverReceiver onReceive,action:");
      paramContext.append(paramIntent.getAction());
      QLog.d("QQPlayerService", 2, paramContext.toString());
    }
    if (("com.tencent.mobileqq.intent.logout".equals(paramIntent.getAction())) || ("qqplayer_exit_action".equals(paramIntent.getAction())))
    {
      if ((paramIntent.getBooleanExtra("musicplayer.isDelFileOnDonwloadThreadOver", false)) && (this.a.a != null)) {
        this.a.a.b = true;
      }
      QQPlayerService.c(this.a.getApplicationContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.QQPlayerBroadcastReceiverReceiver
 * JD-Core Version:    0.7.0.1
 */