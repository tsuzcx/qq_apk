package com.tencent.mobileqq.troop.troopCard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;

class VisitorTroopCardPresenter$8
  implements Runnable
{
  VisitorTroopCardPresenter$8(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void run()
  {
    if (VisitorTroopCardPresenter.a(this.this$0) != null) {
      ((TroopManager)VisitorTroopCardPresenter.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER)).b(VisitorTroopCardPresenter.a(this.this$0).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.8
 * JD-Core Version:    0.7.0.1
 */