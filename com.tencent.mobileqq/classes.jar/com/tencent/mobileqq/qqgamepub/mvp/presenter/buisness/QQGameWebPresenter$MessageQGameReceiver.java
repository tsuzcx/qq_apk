package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.qphone.base.util.QLog;

class QQGameWebPresenter$MessageQGameReceiver
  extends BroadcastReceiver
{
  private QQGameWebPresenter$MessageQGameReceiver(QQGameWebPresenter paramQQGameWebPresenter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder();
    paramContext.append("MessageQGameReceiver onReceive action = ");
    paramContext.append(paramIntent.getAction());
    QLog.d("QQGamePub_GamePAWebPresenter", 1, paramContext.toString());
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    switch (paramContext.hashCode())
    {
    default: 
      break;
    case 1590398986: 
      if (paramContext.equals("action_qgame_jaspi_webloaded")) {
        i = 1;
      }
      break;
    case 1105368530: 
      if (paramContext.equals("action_qgame_delete_ad")) {
        i = 4;
      }
      break;
    case 1082475589: 
      if (paramContext.equals("action_qgame_h5_video_play")) {
        i = 2;
      }
      break;
    case -803303675: 
      if (paramContext.equals("action_qgame_h5_video_pause")) {
        i = 3;
      }
      break;
    case -2101758543: 
      if (paramContext.equals("action_qgame_tool_messgae")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            QQGameWebPresenter.b(this.a, paramIntent);
            return;
          }
          GameVideoManager.b(1);
          return;
        }
        GameVideoManager.b(2);
        return;
      }
      QQGameWebPresenter.a(this.a);
      return;
    }
    QQGameWebPresenter.a(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter.MessageQGameReceiver
 * JD-Core Version:    0.7.0.1
 */