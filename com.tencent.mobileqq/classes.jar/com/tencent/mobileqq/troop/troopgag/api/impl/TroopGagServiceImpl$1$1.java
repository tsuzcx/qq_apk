package com.tencent.mobileqq.troop.troopgag.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagHandler;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import java.util.ArrayList;

class TroopGagServiceImpl$1$1
  implements Runnable
{
  TroopGagServiceImpl$1$1(TroopGagServiceImpl.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagServiceImpl$1.this$0.mApp instanceof AppInterface)) {
      ((ITroopGagHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagServiceImpl$1.this$0.mApp).getBusinessHandler(TroopGagHandler.class.getName())).a(new GagStatus(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagServiceImpl$1.a, this.jdField_a_of_type_JavaUtilArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagServiceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */