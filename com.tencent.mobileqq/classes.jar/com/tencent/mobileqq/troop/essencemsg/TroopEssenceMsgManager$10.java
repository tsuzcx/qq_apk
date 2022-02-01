package com.tencent.mobileqq.troop.essencemsg;

import bedz;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;

public class TroopEssenceMsgManager$10
  implements Runnable
{
  public TroopEssenceMsgManager$10(bedz parambedz, Entity paramEntity) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    bedz.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("TroopEssenceMsgManager", 2, "updateEntity costTime" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.10
 * JD-Core Version:    0.7.0.1
 */