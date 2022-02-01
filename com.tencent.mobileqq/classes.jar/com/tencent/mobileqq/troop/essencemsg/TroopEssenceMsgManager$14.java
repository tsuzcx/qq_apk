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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity costTime");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.i("TroopEssenceMsgManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.14
 * JD-Core Version:    0.7.0.1
 */