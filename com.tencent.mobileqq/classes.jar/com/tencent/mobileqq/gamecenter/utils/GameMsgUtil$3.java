package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class GameMsgUtil$3
  implements Runnable
{
  GameMsgUtil$3(AppInterface paramAppInterface) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = ((IGameMsgBoxManager)this.a.getRuntimeService(IGameMsgBoxManager.class, "")).getGameMsgBoxRecentUsers();
        if (((List)localObject).isEmpty())
        {
          QLog.e(GameMsgUtil.a, 1, "reportClickMsgBoxEntry883: msgBoxRecentUsers.isEmpty()");
          return;
        }
        localObject = (RecentUser)((List)localObject).get(0);
        if (localObject != null)
        {
          if (((RecentUser)localObject).getType() != 10007) {
            return;
          }
          MessageRecord localMessageRecord = GameMsgUtil.a(this.a, ((RecentUser)localObject).uin);
          if (localMessageRecord == null) {
            return;
          }
          if (((IGameMsgBoxRuntimeService)this.a.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).getBoxUnReadCnt() > 0)
          {
            localObject = "0";
            TinyInfo localTinyInfo = new TinyInfo();
            localTinyInfo.parseFromMessageRecord(localMessageRecord);
            GameMsgUtil.a(String.valueOf(localTinyInfo.gameAppId), "1", "145", "920", "92003", "209056", "", "", "20", (String)localObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(GameMsgUtil.a, 1, localThrowable, new Object[0]);
        return;
      }
      String str = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgUtil.3
 * JD-Core Version:    0.7.0.1
 */