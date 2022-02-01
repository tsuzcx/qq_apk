package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class GameMsgUtil$2
  implements Runnable
{
  GameMsgUtil$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    label201:
    label207:
    for (;;)
    {
      try
      {
        Object localObject1 = ((TempMsgBoxManager)this.a.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(this.a);
        if (((List)localObject1).isEmpty())
        {
          QLog.e(GameMsgUtil.a, 1, "reportClickMsgBox: msgBoxRecentUsers.isEmpty()");
          return;
        }
        localObject1 = (RecentUser)((List)localObject1).get(0);
        if ((localObject1 == null) || (((RecentUser)localObject1).getType() != 10007)) {
          break;
        }
        localObject2 = GameMsgUtil.a(this.a, ((RecentUser)localObject1).uin);
        Object localObject3 = new TinyInfo();
        ((TinyInfo)localObject3).parseFromMessageRecord((MessageRecord)localObject2);
        localObject2 = (GameMsgManager)this.a.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
        int i = ((GameMsgManager)localObject2).a();
        if (GameMsgUtil.a(this.a, ((RecentUser)localObject1).uin)) {
          break label207;
        }
        i = 0;
        localObject3 = Long.toString(((TinyInfo)localObject3).gameAppId);
        if (i > 0)
        {
          localObject1 = "1";
          if (!((GameMsgManager)localObject2).c()) {
            break label201;
          }
          localObject2 = "2";
          GameMsgUtil.a((String)localObject3, "1", "145", "920", "92044", "207949", (String)localObject1, "", "", "20", "", (String)localObject2, "");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(GameMsgUtil.a, 1, localThrowable.getMessage());
        return;
      }
      String str = "0";
      continue;
      Object localObject2 = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgUtil.2
 * JD-Core Version:    0.7.0.1
 */