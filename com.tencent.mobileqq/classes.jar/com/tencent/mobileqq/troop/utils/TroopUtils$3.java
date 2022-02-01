package com.tencent.mobileqq.troop.utils;

import bgua;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

final class TroopUtils$3
  implements Runnable
{
  TroopUtils$3(bgua parambgua, TroopInfoData paramTroopInfoData) {}
  
  public void run()
  {
    if (this.val$mTroopShareUtility != null) {
      this.val$mTroopShareUtility.a(this.val$troopInfoData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.3
 * JD-Core Version:    0.7.0.1
 */