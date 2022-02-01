package com.tencent.mobileqq.troop.enterEffect;

import com.tencent.qphone.base.util.QLog;

class TroopEnterEffectController$4$1
  implements Runnable
{
  TroopEnterEffectController$4$1(TroopEnterEffectController.4 param4, int paramInt, TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void run()
  {
    QLog.d("TroopEnterEffect.Controller", 2, "download Res isAIO = " + this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$4.a.a);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$4.a.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "download Res callback success id = " + this.jdField_a_of_type_Int + " showAnimation");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$4.a.a(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$TroopEnterEffectData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.4.1
 * JD-Core Version:    0.7.0.1
 */