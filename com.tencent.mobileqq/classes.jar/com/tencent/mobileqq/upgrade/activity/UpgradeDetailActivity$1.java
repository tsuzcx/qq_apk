package com.tencent.mobileqq.upgrade.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.upgrade.UpgradeController;

class UpgradeDetailActivity$1
  implements DialogInterface.OnClickListener
{
  UpgradeDetailActivity$1(UpgradeDetailActivity paramUpgradeDetailActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      UpgradeDetailActivity localUpgradeDetailActivity = this.b;
      UpgradeDetailActivity.a(localUpgradeDetailActivity, localUpgradeDetailActivity, this.a);
      paramDialogInterface.dismiss();
      UpgradeDetailActivity.a(this.b, this.a, 2);
      return;
    }
    UpgradeController.a().b(false);
    paramDialogInterface.dismiss();
    UpgradeDetailActivity.a(this.b, this.a, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity.1
 * JD-Core Version:    0.7.0.1
 */