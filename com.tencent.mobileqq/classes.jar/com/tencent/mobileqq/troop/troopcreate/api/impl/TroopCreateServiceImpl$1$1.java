package com.tencent.mobileqq.troop.troopcreate.api.impl;

import com.tencent.mobileqq.troop.troopcreate.NewTroopSearchResultDialog;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import java.util.ArrayList;

class TroopCreateServiceImpl$1$1
  implements Runnable
{
  TroopCreateServiceImpl$1$1(TroopCreateServiceImpl.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    TroopCreateUtils.a();
    NewTroopSearchResultDialog localNewTroopSearchResultDialog = new NewTroopSearchResultDialog(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl$1.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiImplTroopCreateServiceImpl$1.jdField_a_of_type_ComTencentMobileqqTroopApiITroopCreateInfoService$TroopCreateCallback);
    localNewTroopSearchResultDialog.a(this.jdField_a_of_type_JavaUtilArrayList);
    localNewTroopSearchResultDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */