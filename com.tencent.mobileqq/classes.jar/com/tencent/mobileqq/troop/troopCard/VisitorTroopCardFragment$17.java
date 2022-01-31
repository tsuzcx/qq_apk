package com.tencent.mobileqq.troop.troopCard;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import bagi;
import bbdj;
import bbgu;

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
      this.this$0.a = bbdj.a(this.this$0.getActivity(), 230);
      this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131720485));
      bagi localbagi = new bagi(this);
      this.this$0.a.setPositiveButton(2131691035, localbagi);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.17
 * JD-Core Version:    0.7.0.1
 */