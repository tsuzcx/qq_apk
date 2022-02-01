package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

final class GameMsgUtil$4
  implements Runnable
{
  GameMsgUtil$4(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject2 = GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        Object localObject1 = new TinyInfo();
        ((TinyInfo)localObject1).parseFromMessageRecord((MessageRecord)localObject2);
        localObject2 = (GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
        int i = ((GameMsgManager)localObject2).a();
        String str2 = Long.toString(((TinyInfo)localObject1).gameAppId);
        if (i > 0)
        {
          localObject1 = "1";
          if (((GameMsgManager)localObject2).c())
          {
            localObject2 = "2";
            GameMsgUtil.a(str2, "1", "145", "920", "92044", "207950", (String)localObject1, "", "", "8", "", (String)localObject2, "");
            return;
          }
          localObject2 = "1";
          continue;
        }
        String str1 = "0";
      }
      catch (Throwable localThrowable)
      {
        QLog.e(GameMsgUtil.jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgUtil.4
 * JD-Core Version:    0.7.0.1
 */