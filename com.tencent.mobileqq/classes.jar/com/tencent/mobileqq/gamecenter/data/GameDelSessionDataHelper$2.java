package com.tencent.mobileqq.gamecenter.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDelSessionRecord;
import com.tencent.mobileqq.gamecenter.utils.GameMsgUtil;
import com.tencent.qphone.base.util.QLog;

final class GameDelSessionDataHelper$2
  implements Runnable
{
  GameDelSessionDataHelper$2(String paramString) {}
  
  public void run()
  {
    IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)GameMsgUtil.a().getRuntimeService(IGameMsgManagerService.class, "");
    IDataVisitor localIDataVisitor = localIGameMsgManagerService.getSessionDelDataHelper();
    if (localIDataVisitor == null)
    {
      QLog.w(GameDelSessionDataHelper.b, 1, "dataVisitor is null.");
      return;
    }
    GameCenterSessionInfo localGameCenterSessionInfo = localIGameMsgManagerService.getSessionInfoByUin(this.a);
    if (localGameCenterSessionInfo == null)
    {
      QLog.w(GameDelSessionDataHelper.b, 1, "sessionInfo is null.");
      return;
    }
    GameDelSessionRecord localGameDelSessionRecord = new GameDelSessionRecord();
    localGameDelSessionRecord.mUin = this.a;
    localIGameMsgManagerService.setReaded(localGameCenterSessionInfo);
    localIDataVisitor.b(localGameDelSessionRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper.2
 * JD-Core Version:    0.7.0.1
 */