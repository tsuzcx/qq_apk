package com.tencent.mobileqq.troop.essencemsg;

import aucg;
import bedy;
import bedz;
import beec;
import beeg;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;

class TroopEssenceMsgManager$5$1$1
  implements Runnable
{
  TroopEssenceMsgManager$5$1$1(TroopEssenceMsgManager.5.1 param1) {}
  
  public void run()
  {
    if (bedz.a(this.a.a.jdField_a_of_type_Bedz, this.a.a.jdField_a_of_type_Bedy))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopEssenceMsgManager", 2, "AddEssenceMsgGrayTip");
      }
      bedz.b(this.a.a.jdField_a_of_type_Bedz, this.a.a.jdField_a_of_type_Bedy);
      MessageForUniteGrayTip localMessageForUniteGrayTip = beeg.a(bedz.a(this.a.a.jdField_a_of_type_Bedz), this.a.a.jdField_a_of_type_Bedy);
      if (localMessageForUniteGrayTip != null)
      {
        aucg.a(bedz.a(this.a.a.jdField_a_of_type_Bedz), localMessageForUniteGrayTip);
        this.a.a.jdField_a_of_type_Bedy.a.graytipuniseq = localMessageForUniteGrayTip.uniseq;
      }
    }
    bedz.a(this.a.a.jdField_a_of_type_Bedz, this.a.a.jdField_a_of_type_Bedy.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.5.1.1
 * JD-Core Version:    0.7.0.1
 */