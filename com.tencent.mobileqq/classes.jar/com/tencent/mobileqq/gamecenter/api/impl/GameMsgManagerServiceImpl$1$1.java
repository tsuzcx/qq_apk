package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GameMsgManagerServiceImpl$1$1
  implements Runnable
{
  GameMsgManagerServiceImpl$1$1(GameMsgManagerServiceImpl.1 param1, Object paramObject) {}
  
  public void run()
  {
    if (!(this.a instanceof ArrayList)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onGameUserInfoChangedNotify] detail:");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("GameCenterMsg.GameCenterUnissoObserver", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (ArrayList)this.a;
    int j = ((ArrayList)localObject1).size();
    int i = 0;
    while (i < j)
    {
      if ((((ArrayList)localObject1).get(i) instanceof GameDetailInfo))
      {
        GameDetailInfo localGameDetailInfo = (GameDetailInfo)((ArrayList)localObject1).get(i);
        Object localObject2;
        if ((localGameDetailInfo != null) && (this.b.a.isGameMsgBlocked(localGameDetailInfo.c)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[onGameUserInfoChangedNotify], blocked! gameId:");
          ((StringBuilder)localObject2).append(localGameDetailInfo.c);
          QLog.i("GameCenterMsg.GameCenterUnissoObserver", 2, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = this.b.a.getSessionInfoByRoleId(localGameDetailInfo.a);
          if (localObject2 != null)
          {
            GameMsgManagerServiceImpl.access$100(this.b.a, (GameCenterSessionInfo)localObject2, localGameDetailInfo);
            GameMsgManagerServiceImpl.access$200(this.b.a, i, j, (GameCenterSessionInfo)localObject2);
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */