package com.tencent.mobileqq.troop.troopCard;

import bgdy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;

public class VisitorTroopCardPresenter$8
  implements Runnable
{
  public VisitorTroopCardPresenter$8(bgdy parambgdy) {}
  
  public void run()
  {
    if (bgdy.a(this.this$0) != null) {
      ((TroopManager)bgdy.a(this.this$0).getManager(QQManagerFactory.TROOP_MANAGER)).b(bgdy.a(this.this$0).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.8
 * JD-Core Version:    0.7.0.1
 */