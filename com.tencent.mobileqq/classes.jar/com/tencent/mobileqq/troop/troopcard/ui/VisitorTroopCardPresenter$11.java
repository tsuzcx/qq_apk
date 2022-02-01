package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.ITroopInfoService;

class VisitorTroopCardPresenter$11
  implements Runnable
{
  VisitorTroopCardPresenter$11(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void run()
  {
    if (VisitorTroopCardPresenter.c(this.this$0) != null) {
      ((ITroopInfoService)VisitorTroopCardPresenter.c(this.this$0).getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(VisitorTroopCardPresenter.j(this.this$0).X);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter.11
 * JD-Core Version:    0.7.0.1
 */