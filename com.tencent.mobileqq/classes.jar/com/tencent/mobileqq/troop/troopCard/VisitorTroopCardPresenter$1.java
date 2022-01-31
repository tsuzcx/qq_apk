package com.tencent.mobileqq.troop.troopCard;

import android.support.v4.app.FragmentActivity;
import bciu;
import bcjl;

public class VisitorTroopCardPresenter$1
  implements Runnable
{
  public VisitorTroopCardPresenter$1(bcjl parambcjl) {}
  
  public void run()
  {
    if ((bcjl.a(this.this$0) == null) || (bcjl.a(this.this$0).isFinishing())) {
      return;
    }
    bcjl.a(this.this$0, true);
    bcjl.a(this.this$0).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.1
 * JD-Core Version:    0.7.0.1
 */