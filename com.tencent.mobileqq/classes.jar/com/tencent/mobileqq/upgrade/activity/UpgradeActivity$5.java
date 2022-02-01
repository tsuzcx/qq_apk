package com.tencent.mobileqq.upgrade.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeConstants;
import com.tencent.mobileqq.upgrade.UpgradeController;

class UpgradeActivity$5
  implements DialogInterface.OnClickListener
{
  UpgradeActivity$5(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.k(), "0");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeActivity.5
 * JD-Core Version:    0.7.0.1
 */