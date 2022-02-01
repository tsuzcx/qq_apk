package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class VisitorTroopCardFragment$22
  implements Runnable
{
  VisitorTroopCardFragment$22(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
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
    this.this$0.S.setMessage(this.this$0.getActivity().getResources().getString(2131917518));
    localObject = new VisitorTroopCardFragment.22.1(this);
    this.this$0.S.setPositiveButton(2131888010, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.S.isShowing()) {
      this.this$0.S.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.22
 * JD-Core Version:    0.7.0.1
 */