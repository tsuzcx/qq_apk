package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;

class TroopEssenceMsgManager$14
  implements Runnable
{
  TroopEssenceMsgManager$14(TroopEssenceMsgManager paramTroopEssenceMsgManager, Entity paramEntity) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    TroopEssenceMsgManager.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("TroopEssenceMsgManager", 2, "updateEntity costTime" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.14
 * JD-Core Version:    0.7.0.1
 */