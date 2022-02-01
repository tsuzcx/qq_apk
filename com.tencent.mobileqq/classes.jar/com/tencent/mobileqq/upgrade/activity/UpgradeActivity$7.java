package com.tencent.mobileqq.upgrade.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeConstants;
import com.tencent.mobileqq.upgrade.UpgradeController;

class UpgradeActivity$7
  implements DialogInterface.OnClickListener
{
  UpgradeActivity$7(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800417F", "0X800417F", 0, 0, "", "", "", "");
    if (UpgradeActivity.a(this.a)) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800714D", "0X800714D", 0, 0, "", "", "", "");
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, UpgradeConstants.b(), String.valueOf(2), UpgradeController.a(), "0");
    UpgradeController.a().a(this.a.app);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeActivity.7
 * JD-Core Version:    0.7.0.1
 */