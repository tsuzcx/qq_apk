package com.tencent.mobileqq.troop.enterEffect;

import bbuf;
import bbun;
import bbuo;
import com.tencent.qphone.base.util.QLog;

public class TroopEnterEffectController$4$1
  implements Runnable
{
  public TroopEnterEffectController$4$1(bbun parambbun, int paramInt, bbuo parambbuo) {}
  
  public void run()
  {
    QLog.d("TroopEnterEffect.Controller", 2, "download Res isAIO = " + this.jdField_a_of_type_Bbun.a.a);
    if (this.jdField_a_of_type_Bbun.a.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "download Res callback success id = " + this.jdField_a_of_type_Int + " showAnimation");
      }
      this.jdField_a_of_type_Bbun.a.a(this.jdField_a_of_type_Bbuo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.4.1
 * JD-Core Version:    0.7.0.1
 */