package com.tencent.mobileqq.qqgamepub.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.qphone.base.util.QLog;

class GameSessionView$GameMessageReceiver
  extends BroadcastReceiver
{
  private GameSessionView$GameMessageReceiver(GameSessionView paramGameSessionView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      String str = GameSessionView.a;
      paramContext = new StringBuilder();
      paramContext.append("[onRecevier] action:");
      paramContext.append((String)localObject);
      paramContext.append(",data:");
      paramContext.append(paramIntent.getExtras());
      if (paramContext.toString() != null) {
        paramContext = paramIntent.getExtras().toString();
      } else {
        paramContext = null;
      }
      QLog.d(str, 2, paramContext);
    }
    if (localObject == null) {
      return;
    }
    int i;
    if ("action_qgame_messgae_change".equals(localObject))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        paramContext = (GameCenterSessionInfo)paramIntent.getParcelable("key_game_msg");
        i = paramIntent.getInt("key_msg_change_type");
        if (QLog.isColorLevel())
        {
          paramIntent = GameSessionView.a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[onReceive] type:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",info:");
          ((StringBuilder)localObject).append(paramContext);
          QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
        }
        this.a.getData();
      }
    }
    else if ("action_qgame_unread_change".equals(localObject))
    {
      paramContext = paramIntent.getExtras();
      if (paramContext != null)
      {
        i = paramContext.getInt("key_msg_unread_cnt");
        if (QLog.isColorLevel())
        {
          paramContext = GameSessionView.a;
          paramIntent = new StringBuilder();
          paramIntent.append("[onReceive] cnt:");
          paramIntent.append(i);
          QLog.d(paramContext, 2, paramIntent.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.GameMessageReceiver
 * JD-Core Version:    0.7.0.1
 */