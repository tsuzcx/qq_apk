package com.tencent.mobileqq.troop.troopcard;

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
    if (this.this$0.a != null)
    {
      if (!this.this$0.a.isShowing()) {
        this.this$0.a.show();
      }
      return;
    }
    Object localObject = this.this$0;
    ((VisitorTroopCardFragment)localObject).a = DialogUtil.a(((VisitorTroopCardFragment)localObject).getActivity(), 230);
    this.this$0.a.setMessage(this.this$0.getActivity().getResources().getString(2131719913));
    localObject = new VisitorTroopCardFragment.22.1(this);
    this.this$0.a.setPositiveButton(2131691064, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.22
 * JD-Core Version:    0.7.0.1
 */