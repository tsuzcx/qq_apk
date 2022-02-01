package com.tencent.mobileqq.troop.troopCard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class VisitorTroopCardFragment$23$1
  implements DialogInterface.OnClickListener
{
  VisitorTroopCardFragment$23$1(VisitorTroopCardFragment.23 param23) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.a.cancel();
      this.a.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.23.1
 * JD-Core Version:    0.7.0.1
 */