package com.tencent.mobileqq.troop.troopCard;

import bfmq;
import bglp;
import bgpa;

public class VisitorTroopCardFragment$17
  implements Runnable
{
  VisitorTroopCardFragment$17(VisitorTroopCardFragment paramVisitorTroopCardFragment, String paramString) {}
  
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
      this.this$0.a = bglp.a(this.this$0.getActivity(), 230);
      this.this$0.a.setMessage(this.a);
      bfmq localbfmq = new bfmq(this);
      this.this$0.a.setPositiveButton(2131690912, localbfmq);
      this.this$0.a.setNegativeButton(2131690582, localbfmq);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.17
 * JD-Core Version:    0.7.0.1
 */