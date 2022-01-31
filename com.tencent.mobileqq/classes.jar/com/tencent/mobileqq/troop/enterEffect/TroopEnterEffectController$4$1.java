package com.tencent.mobileqq.troop.enterEffect;

import bbpw;
import bbqe;
import bbqf;
import com.tencent.qphone.base.util.QLog;

public class TroopEnterEffectController$4$1
  implements Runnable
{
  public TroopEnterEffectController$4$1(bbqe parambbqe, int paramInt, bbqf parambbqf) {}
  
  public void run()
  {
    QLog.d("TroopEnterEffect.Controller", 2, "download Res isAIO = " + this.jdField_a_of_type_Bbqe.a.a);
    if (this.jdField_a_of_type_Bbqe.a.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "download Res callback success id = " + this.jdField_a_of_type_Int + " showAnimation");
      }
      this.jdField_a_of_type_Bbqe.a.a(this.jdField_a_of_type_Bbqf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.4.1
 * JD-Core Version:    0.7.0.1
 */