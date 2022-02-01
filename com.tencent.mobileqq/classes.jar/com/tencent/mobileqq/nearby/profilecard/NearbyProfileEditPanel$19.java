package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class NearbyProfileEditPanel$19
  implements View.OnClickListener
{
  NearbyProfileEditPanel$19(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.F.mEnterProfileIntent.getIntExtra("param_mode", 0) == 1)
    {
      if (this.a.G != null)
      {
        this.a.F.showCancelAlertDialog(2131897037);
        return;
      }
      this.a.F.finish();
      return;
    }
    this.a.t();
    if (this.a.F.mIsProfileOk == 0)
    {
      this.a.F.showCancelAlertDialog(2131897037);
      return;
    }
    if (this.a.d())
    {
      this.a.F.showCancelAlertDialog(2131897033);
      return;
    }
    this.a.F.quitEditWithoutSaving();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.19
 * JD-Core Version:    0.7.0.1
 */