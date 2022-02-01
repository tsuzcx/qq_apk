package com.tencent.mobileqq.troop.troopCard;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import bewe;
import bfur;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class VisitorTroopCardFragment$18
  implements Runnable
{
  VisitorTroopCardFragment$18(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
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
      this.this$0.a = bfur.a(this.this$0.getActivity(), 230);
      this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131719182));
      bewe localbewe = new bewe(this);
      this.this$0.a.setPositiveButton(2131690952, localbewe);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.18
 * JD-Core Version:    0.7.0.1
 */