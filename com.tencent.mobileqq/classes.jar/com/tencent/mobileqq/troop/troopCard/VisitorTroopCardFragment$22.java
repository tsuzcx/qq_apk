package com.tencent.mobileqq.troop.troopCard;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class VisitorTroopCardFragment$22
  implements Runnable
{
  VisitorTroopCardFragment$22(VisitorTroopCardFragment paramVisitorTroopCardFragment, String paramString) {}
  
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
      this.this$0.a.setMessage(this.a);
      VisitorTroopCardFragment.22.1 local1 = new VisitorTroopCardFragment.22.1(this);
      this.this$0.a.setPositiveButton(2131691144, local1);
      this.this$0.a.setNegativeButton(2131690800, local1);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.22
 * JD-Core Version:    0.7.0.1
 */