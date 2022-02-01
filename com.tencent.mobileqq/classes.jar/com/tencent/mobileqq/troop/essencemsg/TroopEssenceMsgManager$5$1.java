package com.tencent.mobileqq.troop.essencemsg;

import bflb;
import bflc;
import bflf;
import bflj;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class TroopEssenceMsgManager$5$1
  implements Runnable
{
  public TroopEssenceMsgManager$5$1(bflf parambflf) {}
  
  public void run()
  {
    long l = this.a.jdField_a_of_type_Bflb.a.troopUin;
    this.a.jdField_a_of_type_Bflb.b = bflj.a(bflc.a(this.a.jdField_a_of_type_Bflc), String.valueOf(l), String.valueOf(this.a.jdField_a_of_type_Bflb.a.msgSenderUin), this.a.jdField_a_of_type_Bflb.b);
    ThreadManager.getUIHandler().post(new TroopEssenceMsgManager.5.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.5.1
 * JD-Core Version:    0.7.0.1
 */