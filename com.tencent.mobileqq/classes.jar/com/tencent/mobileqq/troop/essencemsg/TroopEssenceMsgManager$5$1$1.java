package com.tencent.mobileqq.troop.essencemsg;

import avia;
import bflb;
import bflc;
import bflf;
import bflj;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;

class TroopEssenceMsgManager$5$1$1
  implements Runnable
{
  TroopEssenceMsgManager$5$1$1(TroopEssenceMsgManager.5.1 param1) {}
  
  public void run()
  {
    if (bflc.a(this.a.a.jdField_a_of_type_Bflc, this.a.a.jdField_a_of_type_Bflb))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopEssenceMsgManager", 2, "AddEssenceMsgGrayTip");
      }
      bflc.b(this.a.a.jdField_a_of_type_Bflc, this.a.a.jdField_a_of_type_Bflb);
      MessageForUniteGrayTip localMessageForUniteGrayTip = bflj.a(bflc.a(this.a.a.jdField_a_of_type_Bflc), this.a.a.jdField_a_of_type_Bflb);
      if (localMessageForUniteGrayTip != null)
      {
        avia.a(bflc.a(this.a.a.jdField_a_of_type_Bflc), localMessageForUniteGrayTip);
        this.a.a.jdField_a_of_type_Bflb.a.graytipuniseq = localMessageForUniteGrayTip.uniseq;
      }
    }
    bflc.a(this.a.a.jdField_a_of_type_Bflc, this.a.a.jdField_a_of_type_Bflb.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.5.1.1
 * JD-Core Version:    0.7.0.1
 */