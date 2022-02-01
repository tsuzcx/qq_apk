package com.tencent.mobileqq.troop.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;

class TroopModifyHandler$1
  extends TroopModifyObserver
{
  TroopModifyHandler$1(TroopModifyHandler paramTroopModifyHandler, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramLong == this.jdField_a_of_type_Long) && (paramString1.equals("SUBCMD_EDIT_TROOP_INFO")))
    {
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHandlerTroopModifyHandler.notifyUI(e, false, new Object[] { Long.valueOf(paramInt), paramString2 });
      } else {
        this.jdField_a_of_type_ComTencentMobileqqTroopHandlerTroopModifyHandler.notifyUI(e, true, new Object[] { Long.valueOf(paramLong), "" });
      }
      TroopModifyHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopHandlerTroopModifyHandler).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopModifyHandler.1
 * JD-Core Version:    0.7.0.1
 */