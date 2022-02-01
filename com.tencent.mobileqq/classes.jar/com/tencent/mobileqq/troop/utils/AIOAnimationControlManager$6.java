package com.tencent.mobileqq.troop.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

class AIOAnimationControlManager$6
  implements Function1<File[], Unit>
{
  AIOAnimationControlManager$6(AIOAnimationControlManager paramAIOAnimationControlManager, TroopGiftData paramTroopGiftData, boolean paramBoolean) {}
  
  public Unit a(File[] paramArrayOfFile)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_Int == 3) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(new AIOAnimationControlManager.6.1(this));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.6
 * JD-Core Version:    0.7.0.1
 */