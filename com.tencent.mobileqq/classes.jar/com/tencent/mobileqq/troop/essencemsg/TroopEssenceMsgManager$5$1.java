package com.tencent.mobileqq.troop.essencemsg;

import bedy;
import bedz;
import beec;
import beeg;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class TroopEssenceMsgManager$5$1
  implements Runnable
{
  public TroopEssenceMsgManager$5$1(beec parambeec) {}
  
  public void run()
  {
    long l = this.a.jdField_a_of_type_Bedy.a.troopUin;
    this.a.jdField_a_of_type_Bedy.b = beeg.a(bedz.a(this.a.jdField_a_of_type_Bedz), String.valueOf(l), String.valueOf(this.a.jdField_a_of_type_Bedy.a.msgSenderUin), this.a.jdField_a_of_type_Bedy.b);
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.5.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.5.1
 * JD-Core Version:    0.7.0.1
 */