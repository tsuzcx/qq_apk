package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.qphone.base.util.QLog;

final class GameMsgUtil$4
  implements Runnable
{
  GameMsgUtil$4(AppInterface paramAppInterface, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = (IGameMsgBoxManager)this.a.getRuntimeService(IGameMsgBoxManager.class, "");
      GameDetailInfo localGameDetailInfo = ((IGameMsgBoxManager)localObject).findGameDetailInfoByConvertUin(this.b);
      int i = ((IGameMsgBoxManager)localObject).getUnreadCount(this.b);
      localObject = "1";
      if (i > 0) {
        localObject = "0";
      }
      GameMsgUtil.a(localGameDetailInfo.c, "1", "145", "920", "92004", "206349", "", "3", "20", (String)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(GameMsgUtil.a, 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgUtil.4
 * JD-Core Version:    0.7.0.1
 */