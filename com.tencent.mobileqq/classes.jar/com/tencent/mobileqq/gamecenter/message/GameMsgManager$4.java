package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GameMsgManager$4
  implements Runnable
{
  GameMsgManager$4(GameMsgManager paramGameMsgManager, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 1;
    if (GameMsgManager.a(this.this$0) == null) {
      QLog.w(GameMsgManager.g(), 1, "app is null");
    }
    for (;;)
    {
      return;
      GameCenterUnissoHandler localGameCenterUnissoHandler = (GameCenterUnissoHandler)GameMsgManager.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER);
      if (this.jdField_a_of_type_Boolean)
      {
        localGameCenterUnissoHandler.a(this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      ArrayList localArrayList = GameMsgManager.a(this.this$0, this.jdField_a_of_type_JavaUtilArrayList);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {}
      while (i != 0)
      {
        localGameCenterUnissoHandler.a(localArrayList);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.4
 * JD-Core Version:    0.7.0.1
 */