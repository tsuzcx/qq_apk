package com.tencent.mobileqq.troop.luckycharacter;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.handler.TroopListHandler;

class TroopLuckyCharacterManager$2
  implements Runnable
{
  TroopLuckyCharacterManager$2(TroopLuckyCharacterManager paramTroopLuckyCharacterManager) {}
  
  public void run()
  {
    TroopLuckyCharacterManager.a(this.this$0, (TroopLuckyCharacterConfig)QConfigManager.a().a(696));
    ((TroopListHandler)TroopLuckyCharacterManager.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).notifyUI(TroopNotificationConstants.aC, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterManager.2
 * JD-Core Version:    0.7.0.1
 */