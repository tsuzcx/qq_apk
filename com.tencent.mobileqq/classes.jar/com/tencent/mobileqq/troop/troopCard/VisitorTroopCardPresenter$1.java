package com.tencent.mobileqq.troop.troopCard;

import android.support.v4.app.FragmentActivity;

class VisitorTroopCardPresenter$1
  implements Runnable
{
  VisitorTroopCardPresenter$1(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void run()
  {
    if ((VisitorTroopCardPresenter.a(this.this$0) == null) || (VisitorTroopCardPresenter.a(this.this$0).isFinishing())) {
      return;
    }
    VisitorTroopCardPresenter.a(this.this$0, true);
    VisitorTroopCardPresenter.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.1
 * JD-Core Version:    0.7.0.1
 */