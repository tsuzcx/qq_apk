package com.tencent.mobileqq.troop.troopCard;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class VisitorTroopCardFragment$23
  implements Runnable
{
  VisitorTroopCardFragment$23(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
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
      this.this$0.a = DialogUtil.a(this.this$0.getActivity(), 230);
      this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131720180));
      VisitorTroopCardFragment.23.1 local1 = new VisitorTroopCardFragment.23.1(this);
      this.this$0.a.setPositiveButton(2131691144, local1);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.23
 * JD-Core Version:    0.7.0.1
 */