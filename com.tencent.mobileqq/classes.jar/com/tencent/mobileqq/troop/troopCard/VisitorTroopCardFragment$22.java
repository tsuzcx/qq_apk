package com.tencent.mobileqq.troop.troopCard;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import bgdr;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class VisitorTroopCardFragment$22
  implements Runnable
{
  VisitorTroopCardFragment$22(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
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
      this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131719602));
      bgdr localbgdr = new bgdr(this);
      this.this$0.a.setPositiveButton(2131691037, localbgdr);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.22
 * JD-Core Version:    0.7.0.1
 */