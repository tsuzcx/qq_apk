package com.tencent.mobileqq.troop.enterEffect;

import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.qphone.base.util.QLog;

class TroopEnterEffectController$4$1
  implements Runnable
{
  TroopEnterEffectController$4$1(TroopEnterEffectController.4 param4, int paramInt, TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download Res isAIO = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$4.a.a);
    QLog.d("TroopEnterEffect.Controller", 2, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$4.a.a)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("download Res callback success id = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" showAnimation");
        QLog.d("TroopEnterEffect.Controller", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController$4.a.a(this.jdField_a_of_type_ComTencentMobileqqTroopEntereffectTroopEnterEffectData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.4.1
 * JD-Core Version:    0.7.0.1
 */