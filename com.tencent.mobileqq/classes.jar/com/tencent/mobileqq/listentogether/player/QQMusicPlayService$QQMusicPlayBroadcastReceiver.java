package com.tencent.mobileqq.listentogether.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class QQMusicPlayService$QQMusicPlayBroadcastReceiver
  extends BroadcastReceiver
{
  private QQMusicPlayService$QQMusicPlayBroadcastReceiver(QQMusicPlayService paramQQMusicPlayService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = new StringBuilder();
      paramContext.append("QQMusicPlayBroadcastReceiver onReceive,action:");
      paramContext.append(paramIntent.getAction());
      QLog.d("QQMusicPlay.QQMusicPlayService", 1, paramContext.toString());
      paramContext = paramIntent.getAction();
      if (paramContext != null) {
        if ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")))
        {
          paramIntent = new StringBuilder();
          paramIntent.append("mqq.intent.action.EXIT_");
          paramIntent.append(BaseApplicationImpl.getApplication().getPackageName());
          if ((!paramContext.equals(paramIntent.toString())) && (!paramContext.equals("mqq.intent.action.LOGOUT")) && (!paramContext.equals("QQMusicPlay_exit_action"))) {}
        }
        else
        {
          if (QQMusicPlayService.a(this.a) != null)
          {
            QQMusicPlayService.a(this.a).sendEmptyMessage(11);
            return;
          }
          this.a.stopSelf();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService.QQMusicPlayBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */