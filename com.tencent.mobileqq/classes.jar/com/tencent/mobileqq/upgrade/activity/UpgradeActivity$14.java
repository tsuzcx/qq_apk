package com.tencent.mobileqq.upgrade.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;

class UpgradeActivity$14
  implements DialogInterface.OnClickListener
{
  UpgradeActivity$14(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 2, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, 1, 2, 200));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeActivity.14
 * JD-Core Version:    0.7.0.1
 */