package com.tencent.mobileqq.guild.live.livemanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QQGuildLiveEventHelper$1
  extends BroadcastReceiver
{
  QQGuildLiveEventHelper$1(QQGuildLiveEventHelper paramQQGuildLiveEventHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("mQqAccountReceiver onReceive=");
    paramIntent.append(paramContext);
    QLog.i("QGL.QQGuildLiveEventHelper", 1, paramIntent.toString());
    QQGuildLiveEventHelper.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper.1
 * JD-Core Version:    0.7.0.1
 */