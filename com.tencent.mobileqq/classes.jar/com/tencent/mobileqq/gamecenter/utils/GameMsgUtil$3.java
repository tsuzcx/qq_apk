package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.QLog;

final class GameMsgUtil$3
  implements Runnable
{
  GameMsgUtil$3(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
          return;
        }
        Object localObject = new TinyInfo();
        ((TinyInfo)localObject).parseFromMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
        if (localIGameMsgManagerService == null) {
          return;
        }
        int i = localIGameMsgManagerService.getUnreadCnt();
        if (!GameMsgUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString)) {
          i = 0;
        }
        String str2 = Long.toString(((TinyInfo)localObject).gameAppId);
        String str1 = "1";
        if (i > 0) {
          localObject = "1";
        } else {
          localObject = "0";
        }
        if (localIGameMsgManagerService.isShowInMsgBox()) {
          str1 = "2";
        }
        GameMsgUtil.b(str2, "1", "145", "920", "92044", "207951", (String)localObject, "", "", "20", "", str1, "", localIGameMsgManagerService.getBoxMsgSwitchId());
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(GameMsgUtil.jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgUtil.3
 * JD-Core Version:    0.7.0.1
 */