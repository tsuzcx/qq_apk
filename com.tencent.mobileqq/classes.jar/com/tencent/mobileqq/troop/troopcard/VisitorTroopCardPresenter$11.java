package com.tencent.mobileqq.troop.troopcard;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.ITroopInfoService;

class VisitorTroopCardPresenter$11
  implements Runnable
{
  VisitorTroopCardPresenter$11(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void run()
  {
    if (VisitorTroopCardPresenter.a(this.this$0) != null) {
      ((ITroopInfoService)VisitorTroopCardPresenter.a(this.this$0).getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(VisitorTroopCardPresenter.a(this.this$0).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardPresenter.11
 * JD-Core Version:    0.7.0.1
 */