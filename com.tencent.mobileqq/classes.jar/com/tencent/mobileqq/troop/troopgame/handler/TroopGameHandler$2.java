package com.tencent.mobileqq.troop.troopgame.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;

class TroopGameHandler$2
  extends TroopModifyObserver
{
  TroopGameHandler$2(TroopGameHandler paramTroopGameHandler, long paramLong, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramLong == this.jdField_a_of_type_Long) && (paramString1.equals("SUBCMD_MODIFY_TROOP_GAME_CARD_SWITCH")))
    {
      if (paramBoolean)
      {
        paramString1 = (ITroopInfoService)TroopGameHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameHandlerTroopGameHandler).getRuntimeService(ITroopInfoService.class, "");
        TroopInfo localTroopInfo = paramString1.getTroopInfo(String.valueOf(paramLong));
        if (localTroopInfo != null)
        {
          localTroopInfo.setGroupFlagExt4(this.jdField_a_of_type_Boolean, 4096);
          paramString1.saveTroopInfo(localTroopInfo);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameHandlerTroopGameHandler.notifyUI(TroopGameObserver.TYPE_NOTIFY_MODIFY_TROOP_GAME_CARD_SWITCH, paramBoolean, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString2 });
      TroopGameHandler.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameHandlerTroopGameHandler).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.handler.TroopGameHandler.2
 * JD-Core Version:    0.7.0.1
 */