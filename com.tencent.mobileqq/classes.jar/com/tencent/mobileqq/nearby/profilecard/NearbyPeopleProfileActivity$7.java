package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class NearbyPeopleProfileActivity$7
  implements View.OnClickListener
{
  NearbyPeopleProfileActivity$7(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mPromptDialog != null) && (!this.a.isFinishing()))
    {
      this.a.mPromptDialog.dismiss();
      this.a.mPromptDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.7
 * JD-Core Version:    0.7.0.1
 */