package com.tencent.mobileqq.troop.troopCard;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import bceu;
import bdcd;
import bdfq;

public class VisitorTroopCardFragment$17
  implements Runnable
{
  VisitorTroopCardFragment$17(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
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
      this.this$0.a = bdcd.a(this.this$0.getActivity(), 230);
      this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131721024));
      bceu localbceu = new bceu(this);
      this.this$0.a.setPositiveButton(2131691088, localbceu);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.17
 * JD-Core Version:    0.7.0.1
 */