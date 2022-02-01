package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.app.QBaseActivity;

class VisitorTroopCardPresenter$1
  implements Runnable
{
  VisitorTroopCardPresenter$1(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void run()
  {
    if (VisitorTroopCardPresenter.a(this.this$0) != null)
    {
      if (VisitorTroopCardPresenter.a(this.this$0).isFinishing()) {
        return;
      }
      VisitorTroopCardPresenter.a(this.this$0, true);
      VisitorTroopCardPresenter.b(this.this$0).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter.1
 * JD-Core Version:    0.7.0.1
 */