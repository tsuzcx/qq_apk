package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;

class TroopPhotoController$4
  implements Runnable
{
  TroopPhotoController$4(TroopPhotoController paramTroopPhotoController, ITroopInfoService paramITroopInfoService, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    this.a.saveTroopInfo(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.4
 * JD-Core Version:    0.7.0.1
 */