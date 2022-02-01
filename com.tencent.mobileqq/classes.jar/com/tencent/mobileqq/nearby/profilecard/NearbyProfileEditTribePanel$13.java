package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class NearbyProfileEditTribePanel$13
  implements View.OnClickListener
{
  NearbyProfileEditTribePanel$13(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.A.mEnterProfileIntent.getIntExtra("param_mode", 0) == 1)
    {
      if (this.a.B != null)
      {
        this.a.A.showCancelAlertDialog(2131897037);
        return;
      }
      this.a.A.finish();
      return;
    }
    this.a.k();
    if (this.a.A.mIsProfileOk == 0)
    {
      this.a.A.showCancelAlertDialog(2131897037);
      return;
    }
    if (this.a.d())
    {
      this.a.A.showCancelAlertDialog(2131897033);
      return;
    }
    this.a.A.quitEditWithoutSaving();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.13
 * JD-Core Version:    0.7.0.1
 */