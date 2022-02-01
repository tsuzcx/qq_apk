package com.tencent.mobileqq.qqgamepub.view;

import android.os.Handler;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class GameSessionView$2
  implements Runnable
{
  GameSessionView$2(GameSessionView paramGameSessionView) {}
  
  public void run()
  {
    if (GameSessionView.a(this.this$0) == null) {
      return;
    }
    IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)GameSessionView.a(this.this$0).getRuntimeService(IGameMsgManagerService.class, "");
    if (!localIGameMsgManagerService.isGrayOpen())
    {
      if (QLog.isColorLevel()) {
        QLog.d(GameSessionView.a, 2, "[setData] gray is not open. return.");
      }
      return;
    }
    List localList = localIGameMsgManagerService.getSessionInfoList();
    if (localList != null)
    {
      try
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)localIterator.next();
          if (localGameCenterSessionInfo != null) {
            localGameCenterSessionInfo.a((BaseQQAppInterface)GameSessionView.a(this.this$0));
          }
        }
        if (GameSessionView.a(this.this$0)) {
          break label170;
        }
      }
      catch (Exception localException)
      {
        QLog.e(GameSessionView.a, 1, localException, new Object[0]);
      }
    }
    else
    {
      GameSessionView.a(this.this$0, 1);
      GameSessionView.a(this.this$0, localIGameMsgManagerService.getNeedPopMsgView());
      GameSessionView.b(this.this$0, true);
    }
    label170:
    GameSessionView.a(this.this$0).post(new GameSessionView.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.2
 * JD-Core Version:    0.7.0.1
 */