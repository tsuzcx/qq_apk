package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

final class GameMsgUtil$3
  implements Runnable
{
  GameMsgUtil$3(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString) {}
  
  public void run()
  {
    label139:
    label145:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
          return;
        }
        Object localObject1 = new TinyInfo();
        ((TinyInfo)localObject1).parseFromMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        localObject2 = (GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
        int i = ((GameMsgManager)localObject2).a();
        if (GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString)) {
          break label145;
        }
        i = 0;
        String str2 = Long.toString(((TinyInfo)localObject1).gameAppId);
        if (i > 0)
        {
          localObject1 = "1";
          if (!((GameMsgManager)localObject2).c()) {
            break label139;
          }
          localObject2 = "2";
          GameMsgUtil.a(str2, "1", "145", "920", "92044", "207951", (String)localObject1, "", "", "20", "", (String)localObject2, "");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(GameMsgUtil.jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
        return;
      }
      String str1 = "0";
      continue;
      Object localObject2 = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgUtil.3
 * JD-Core Version:    0.7.0.1
 */