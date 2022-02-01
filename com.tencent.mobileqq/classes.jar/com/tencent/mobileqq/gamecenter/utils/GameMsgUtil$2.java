package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class GameMsgUtil$2
  implements Runnable
{
  GameMsgUtil$2(AppInterface paramAppInterface) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      try
      {
        Object localObject1 = (ITempMsgBoxManager)this.a.getRuntimeService(ITempMsgBoxManager.class, "");
        if (localObject1 == null) {
          return;
        }
        localObject1 = ((ITempMsgBoxManager)localObject1).getMsgBoxRecentUsers();
        if (((List)localObject1).isEmpty())
        {
          QLog.e(GameMsgUtil.a, 1, "reportClickMsgBox: msgBoxRecentUsers.isEmpty()");
          return;
        }
        i = 0;
        localObject1 = (RecentUser)((List)localObject1).get(0);
        if (localObject1 != null)
        {
          if (((RecentUser)localObject1).getType() != 10007) {
            return;
          }
          Object localObject3 = GameMsgUtil.a(this.a, ((RecentUser)localObject1).uin);
          Object localObject2 = new TinyInfo();
          ((TinyInfo)localObject2).parseFromMessageRecord((MessageRecord)localObject3);
          localObject3 = (IGameMsgManagerService)this.a.getRuntimeService(IGameMsgManagerService.class, "");
          if (localObject3 == null) {
            return;
          }
          j = ((IGameMsgManagerService)localObject3).getUnreadCnt();
          if (!GameMsgUtil.a(this.a, ((RecentUser)localObject1).uin))
          {
            String str = Long.toString(((TinyInfo)localObject2).gameAppId);
            localObject2 = "1";
            if (i > 0) {
              localObject1 = "1";
            } else {
              localObject1 = "0";
            }
            if (((IGameMsgManagerService)localObject3).isShowInMsgBox()) {
              localObject2 = "2";
            }
            GameMsgUtil.b(str, "1", "145", "920", "92044", "207949", (String)localObject1, "", "", "20", "", (String)localObject2, "", ((IGameMsgManagerService)localObject3).getBoxMsgSwitchId());
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(GameMsgUtil.a, 1, localThrowable.getMessage());
        return;
      }
      int i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgUtil.2
 * JD-Core Version:    0.7.0.1
 */