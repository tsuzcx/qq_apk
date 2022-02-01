package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.QLog;

final class GameMsgUtil$1
  implements Runnable
{
  GameMsgUtil$1(AppInterface paramAppInterface, RecentUser paramRecentUser) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = GameMsgUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      Object localObject1 = new TinyInfo();
      ((TinyInfo)localObject1).parseFromMessageRecord((MessageRecord)localObject2);
      IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
      if (localIGameMsgManagerService == null) {
        return;
      }
      int i = localIGameMsgManagerService.getUnreadCnt();
      if (!GameMsgUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
        i = 0;
      }
      String str = Long.toString(((TinyInfo)localObject1).gameAppId);
      localObject2 = "1";
      if (i > 0) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      if (localIGameMsgManagerService.isShowInMsgBox()) {
        localObject2 = "2";
      }
      GameMsgUtil.b(str, "1", "145", "920", "92044", "207948", (String)localObject1, "", "", "8", "", (String)localObject2, "", localIGameMsgManagerService.getBoxMsgSwitchId());
      GameMsgUtil.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(GameMsgUtil.jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */