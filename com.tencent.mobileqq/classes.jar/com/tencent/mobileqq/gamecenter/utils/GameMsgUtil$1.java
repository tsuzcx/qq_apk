package com.tencent.mobileqq.gamecenter.utils;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.ILoadGameListener;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class GameMsgUtil$1
  implements ILoadGameListener<GameBoxRecentUser>
{
  GameMsgUtil$1(AppInterface paramAppInterface, Context paramContext, int paramInt) {}
  
  public void a(GameBoxRecentUser paramGameBoxRecentUser)
  {
    if (paramGameBoxRecentUser != null) {
      try
      {
        long l = Long.parseLong(paramGameBoxRecentUser.mGameAppId);
        ((IGameQQPlayerUtilApi)QRoute.api(IGameQQPlayerUtilApi.class)).openGameMsgAIO(this.a, this.b, paramGameBoxRecentUser.mFromRoleId, paramGameBoxRecentUser.mFromOpenId, paramGameBoxRecentUser.mToRoleId, paramGameBoxRecentUser.mToOpenId, null, paramGameBoxRecentUser.mSig, l, paramGameBoxRecentUser.mFromTinyId, paramGameBoxRecentUser.mToTinyId, 0, this.c);
        return;
      }
      catch (Exception paramGameBoxRecentUser)
      {
        QLog.e(GameMsgUtil.a, 2, paramGameBoxRecentUser, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */