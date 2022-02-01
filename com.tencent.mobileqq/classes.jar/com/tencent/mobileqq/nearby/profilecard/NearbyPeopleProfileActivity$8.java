package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyPeopleProfileActivity$8
  implements View.OnClickListener
{
  NearbyPeopleProfileActivity$8(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mPromptDialog != null) && (!this.a.isFinishing()))
    {
      this.a.mPromptDialog.dismiss();
      this.a.mPromptDialog = null;
    }
    this.a.switchToEditPanel(300L);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004BB0", "0X8004BB0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.8
 * JD-Core Version:    0.7.0.1
 */