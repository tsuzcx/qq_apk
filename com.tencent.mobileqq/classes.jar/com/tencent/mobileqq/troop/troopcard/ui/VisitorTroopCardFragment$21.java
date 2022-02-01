package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class VisitorTroopCardFragment$21
  implements Runnable
{
  VisitorTroopCardFragment$21(VisitorTroopCardFragment paramVisitorTroopCardFragment, String paramString) {}
  
  public void run()
  {
    if (this.this$0.S != null)
    {
      if (!this.this$0.S.isShowing()) {
        this.this$0.S.show();
      }
      return;
    }
    Object localObject = this.this$0;
    ((VisitorTroopCardFragment)localObject).S = DialogUtil.a(((VisitorTroopCardFragment)localObject).getActivity(), 230);
    this.this$0.S.setMessage(this.a);
    localObject = new VisitorTroopCardFragment.21.1(this);
    this.this$0.S.setPositiveButton(2131888010, (DialogInterface.OnClickListener)localObject);
    this.this$0.S.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.S.isShowing()) {
      this.this$0.S.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.21
 * JD-Core Version:    0.7.0.1
 */