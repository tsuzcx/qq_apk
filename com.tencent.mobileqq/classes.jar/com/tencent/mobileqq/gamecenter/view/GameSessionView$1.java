package com.tencent.mobileqq.gamecenter.view;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class GameSessionView$1
  implements Runnable
{
  GameSessionView$1(GameSessionView paramGameSessionView) {}
  
  public void run()
  {
    if (GameSessionView.a(this.this$0) == null) {}
    GameMsgManager localGameMsgManager;
    do
    {
      return;
      localGameMsgManager = (GameMsgManager)GameSessionView.a(this.this$0).getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
      if (localGameMsgManager.d()) {
        break;
      }
    } while (!com.tencent.TMG.utils.QLog.isColorLevel());
    com.tencent.TMG.utils.QLog.d(GameSessionView.a, 0, "[setData] gray is not open. return.");
    return;
    List localList = localGameMsgManager.a();
    if (localList != null)
    {
      try
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)localIterator.next();
          if (localGameCenterSessionInfo != null) {
            localGameCenterSessionInfo.a((QQAppInterface)GameSessionView.a(this.this$0));
          }
        }
        if (GameSessionView.a(this.this$0)) {
          break label163;
        }
      }
      catch (Exception localException)
      {
        com.tencent.qphone.base.util.QLog.e(GameSessionView.a, 1, localException, new Object[0]);
      }
    }
    else
    {
      GameSessionView.a(this.this$0, 1);
      GameSessionView.a(this.this$0, localGameMsgManager.c);
      GameSessionView.b(this.this$0, true);
    }
    label163:
    GameSessionView.a(this.this$0).post(new GameSessionView.1.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.1
 * JD-Core Version:    0.7.0.1
 */