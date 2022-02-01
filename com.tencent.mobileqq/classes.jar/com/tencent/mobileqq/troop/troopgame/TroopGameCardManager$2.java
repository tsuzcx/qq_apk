package com.tencent.mobileqq.troop.troopgame;

import bgfx;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;

public class TroopGameCardManager$2
  implements Runnable
{
  public TroopGameCardManager$2(bgfx parambgfx, Entity paramEntity) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    bgfx.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardManager", 2, "updateEntity costTime" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardManager.2
 * JD-Core Version:    0.7.0.1
 */