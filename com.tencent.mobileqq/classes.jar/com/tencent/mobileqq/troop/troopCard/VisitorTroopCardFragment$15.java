package com.tencent.mobileqq.troop.troopCard;

import azep;
import babr;
import bafb;

public class VisitorTroopCardFragment$15
  implements Runnable
{
  VisitorTroopCardFragment$15(VisitorTroopCardFragment paramVisitorTroopCardFragment, String paramString) {}
  
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
      this.this$0.a = babr.a(this.this$0.getActivity(), 230);
      this.this$0.a.setMessage(this.a);
      azep localazep = new azep(this);
      this.this$0.a.setPositiveButton(2131625463, localazep);
      this.this$0.a.setNegativeButton(2131625035, localazep);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.15
 * JD-Core Version:    0.7.0.1
 */