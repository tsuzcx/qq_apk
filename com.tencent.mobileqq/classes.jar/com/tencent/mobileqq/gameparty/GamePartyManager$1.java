package com.tencent.mobileqq.gameparty;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class GamePartyManager$1
  extends Handler
{
  GamePartyManager$1(GamePartyManager paramGamePartyManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)GamePartyManager.a(this.a).get();
    if (localQQAppInterface == null) {
      return;
    }
    if (paramMessage.what != 1) {
      return;
    }
    paramMessage = new StringBuilder();
    paramMessage.append("https://openmobile.qq.com/gameteam/get_team_context?uin=");
    paramMessage.append(localQQAppInterface.getCurrentAccountUin());
    paramMessage = paramMessage.toString();
    this.a.a(paramMessage, null);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gameparty.GamePartyManager.1
 * JD-Core Version:    0.7.0.1
 */