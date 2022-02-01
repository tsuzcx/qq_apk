package com.tencent.mobileqq.troop.troopcard;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;

class TroopInfoActivity$23$1
  implements Runnable
{
  TroopInfoActivity$23$1(TroopInfoActivity.23 param23, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity$23.a.a.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.23.1
 * JD-Core Version:    0.7.0.1
 */