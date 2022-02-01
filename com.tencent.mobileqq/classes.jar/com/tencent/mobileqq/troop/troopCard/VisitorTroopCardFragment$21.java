package com.tencent.mobileqq.troop.troopCard;

import bgdq;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class VisitorTroopCardFragment$21
  implements Runnable
{
  VisitorTroopCardFragment$21(VisitorTroopCardFragment paramVisitorTroopCardFragment, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      if (!this.this$0.a.isShowing()) {
        this.this$0.a.show();
      }
    }
    do
    {
      return;
      this.this$0.a = bhdj.a(this.this$0.getActivity(), 230);
      this.this$0.a.setMessage(this.a);
      bgdq localbgdq = new bgdq(this);
      this.this$0.a.setPositiveButton(2131691037, localbgdq);
      this.this$0.a.setNegativeButton(2131690697, localbgdq);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.21
 * JD-Core Version:    0.7.0.1
 */