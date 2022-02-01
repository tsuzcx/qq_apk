package com.tencent.mobileqq.profile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class VipProfileCardBaseActivity$5
  implements DialogInterface.OnClickListener
{
  VipProfileCardBaseActivity$5(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.e();
    this.a.g();
    ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_VIPOPENSERVICE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity.5
 * JD-Core Version:    0.7.0.1
 */