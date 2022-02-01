package com.tencent.mobileqq.troop.troopgame;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;

class TroopGameCardManager$2
  implements Runnable
{
  TroopGameCardManager$2(TroopGameCardManager paramTroopGameCardManager, Entity paramEntity) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    TroopGameCardManager.a(this.this$0, this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity costTime");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.i("TroopGameCardManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardManager.2
 * JD-Core Version:    0.7.0.1
 */