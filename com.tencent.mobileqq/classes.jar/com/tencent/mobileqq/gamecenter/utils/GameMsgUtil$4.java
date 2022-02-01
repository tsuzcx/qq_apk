package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.QLog;

final class GameMsgUtil$4
  implements Runnable
{
  GameMsgUtil$4(AppInterface paramAppInterface, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = GameMsgUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
      Object localObject1 = new TinyInfo();
      ((TinyInfo)localObject1).parseFromMessageRecord((MessageRecord)localObject2);
      IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
      if (localIGameMsgManagerService == null) {
        return;
      }
      int i = localIGameMsgManagerService.getUnreadCnt();
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
      GameMsgUtil.b(str, "1", "145", "920", "92044", "207950", (String)localObject1, "", "", "8", "", (String)localObject2, "", localIGameMsgManagerService.getBoxMsgSwitchId());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(GameMsgUtil.jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgUtil.4
 * JD-Core Version:    0.7.0.1
 */