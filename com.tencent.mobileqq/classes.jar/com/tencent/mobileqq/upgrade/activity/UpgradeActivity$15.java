package com.tencent.mobileqq.upgrade.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.NewUpgradeDialog;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appcircle.st.STUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.downloadnew.MyAppApi;
import mqq.os.MqqHandler;

class UpgradeActivity$15
  implements DialogInterface.OnClickListener
{
  UpgradeActivity$15(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.b("qqBaseActivity", STUtils.a(10010, 1, 3, 200));
    AppCircleReportManager.a().a(17, STUtils.a(10010, 1, 3, 200));
    if (!MyAppApi.a().b()) {
      ToastUtil.a().a(HardCodeUtil.a(2131715755));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      NewUpgradeDialog.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.activity.UpgradeActivity.15
 * JD-Core Version:    0.7.0.1
 */