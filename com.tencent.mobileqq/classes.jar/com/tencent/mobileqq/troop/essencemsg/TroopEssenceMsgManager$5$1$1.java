package com.tencent.mobileqq.troop.essencemsg;

import avpe;
import bfun;
import bfuo;
import bfur;
import bfuv;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;

class TroopEssenceMsgManager$5$1$1
  implements Runnable
{
  TroopEssenceMsgManager$5$1$1(TroopEssenceMsgManager.5.1 param1) {}
  
  public void run()
  {
    if (bfuo.a(this.a.a.jdField_a_of_type_Bfuo, this.a.a.jdField_a_of_type_Bfun))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopEssenceMsgManager", 2, "AddEssenceMsgGrayTip");
      }
      bfuo.b(this.a.a.jdField_a_of_type_Bfuo, this.a.a.jdField_a_of_type_Bfun);
      MessageForUniteGrayTip localMessageForUniteGrayTip = bfuv.a(bfuo.a(this.a.a.jdField_a_of_type_Bfuo), this.a.a.jdField_a_of_type_Bfun);
      if (localMessageForUniteGrayTip != null)
      {
        avpe.a(bfuo.a(this.a.a.jdField_a_of_type_Bfuo), localMessageForUniteGrayTip);
        this.a.a.jdField_a_of_type_Bfun.a.graytipuniseq = localMessageForUniteGrayTip.uniseq;
      }
    }
    bfuo.a(this.a.a.jdField_a_of_type_Bfuo, this.a.a.jdField_a_of_type_Bfun.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.5.1.1
 * JD-Core Version:    0.7.0.1
 */