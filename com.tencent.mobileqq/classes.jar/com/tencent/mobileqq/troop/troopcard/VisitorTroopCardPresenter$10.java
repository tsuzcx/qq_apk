package com.tencent.mobileqq.troop.troopcard;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;

class VisitorTroopCardPresenter$10
  implements Runnable
{
  VisitorTroopCardPresenter$10(VisitorTroopCardPresenter paramVisitorTroopCardPresenter, ITroopInfoService paramITroopInfoService, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService.saveTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardPresenter.10
 * JD-Core Version:    0.7.0.1
 */