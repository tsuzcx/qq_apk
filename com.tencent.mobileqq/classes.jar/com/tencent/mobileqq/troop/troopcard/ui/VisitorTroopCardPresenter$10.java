package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;

class VisitorTroopCardPresenter$10
  implements Runnable
{
  VisitorTroopCardPresenter$10(VisitorTroopCardPresenter paramVisitorTroopCardPresenter, ITroopInfoService paramITroopInfoService, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    this.a.saveTroopInfo(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter.10
 * JD-Core Version:    0.7.0.1
 */