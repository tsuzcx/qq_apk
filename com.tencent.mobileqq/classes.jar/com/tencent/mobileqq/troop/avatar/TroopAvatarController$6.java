package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;

class TroopAvatarController$6
  implements Runnable
{
  TroopAvatarController$6(TroopAvatarController paramTroopAvatarController, ITroopInfoService paramITroopInfoService, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    this.a.saveTroopInfo(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarController.6
 * JD-Core Version:    0.7.0.1
 */