package com.tencent.mobileqq.troop.troopCard;

import bcjc;
import bdgm;
import bdjz;

public class VisitorTroopCardFragment$16
  implements Runnable
{
  VisitorTroopCardFragment$16(VisitorTroopCardFragment paramVisitorTroopCardFragment, String paramString) {}
  
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
      this.this$0.a = bdgm.a(this.this$0.getActivity(), 230);
      this.this$0.a.setMessage(this.a);
      bcjc localbcjc = new bcjc(this);
      this.this$0.a.setPositiveButton(2131691089, localbcjc);
      this.this$0.a.setNegativeButton(2131690648, localbcjc);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.16
 * JD-Core Version:    0.7.0.1
 */