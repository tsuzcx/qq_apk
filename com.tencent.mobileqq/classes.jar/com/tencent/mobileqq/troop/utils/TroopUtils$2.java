package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

final class TroopUtils$2
  implements Runnable
{
  TroopUtils$2(TroopShareUtility paramTroopShareUtility, TroopInfoData paramTroopInfoData) {}
  
  public void run()
  {
    TroopShareUtility localTroopShareUtility = this.a;
    if (localTroopShareUtility != null) {
      localTroopShareUtility.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.2
 * JD-Core Version:    0.7.0.1
 */