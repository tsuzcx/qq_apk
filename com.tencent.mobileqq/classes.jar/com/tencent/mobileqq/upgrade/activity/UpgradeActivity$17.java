package com.tencent.mobileqq.upgrade.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.utils.SPSettings;

class UpgradeActivity$17
  implements DialogInterface.OnClickListener
{
  UpgradeActivity$17(UpgradeActivity paramUpgradeActivity, NewUpgradeDialog paramNewUpgradeDialog, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.d();
    SPSettings.c(true);
    SPSettings.c(this.b);
    UpgradeDetailActivity.a(this.c, UpgradeController.a().d(), false, true, true);
    this.c.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeActivity.17
 * JD-Core Version:    0.7.0.1
 */