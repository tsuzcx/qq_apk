package com.tencent.mobileqq.troop.troopcard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class VisitorTroopCardFragment$22$1
  implements DialogInterface.OnClickListener
{
  VisitorTroopCardFragment$22$1(VisitorTroopCardFragment.22 param22) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.a.cancel();
      this.a.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.22.1
 * JD-Core Version:    0.7.0.1
 */