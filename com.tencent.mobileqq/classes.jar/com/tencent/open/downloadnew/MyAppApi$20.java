package com.tencent.open.downloadnew;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig.Dialog;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.utils.SPSettings;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;

class MyAppApi$20
  implements Runnable
{
  MyAppApi$20(MyAppApi paramMyAppApi, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---isAutoInstall:");
    ((StringBuilder)localObject).append(ControlPolicyUtil.c());
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(ControlPolicyUtil.a());
    ((StringBuilder)localObject).append(" interval:");
    ((StringBuilder)localObject).append(ControlPolicyUtil.a());
    LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
    if ((APNUtil.b(this.a)) && (APNUtil.c(this.a)))
    {
      boolean bool4 = ApkUtils.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity);
      boolean bool5 = ControlPolicyUtil.b();
      localObject = UpgradeController.a().a();
      boolean bool1;
      if ((localObject != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog != null)) {
        bool1 = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Boolean;
      } else {
        bool1 = false;
      }
      boolean bool3 = SPSettings.a();
      boolean bool2 = bool3;
      if (bool3)
      {
        int j = SPSettings.a();
        int i;
        if ((localObject != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo != null)) {
          i = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
        } else {
          i = 0;
        }
        bool2 = bool3;
        if (i != j)
        {
          SPSettings.a(false);
          SPSettings.a(i);
          bool2 = false;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("predownload flags:isInstalled=");
      ((StringBuilder)localObject).append(bool4);
      ((StringBuilder)localObject).append(" needDownloadYYB = ");
      ((StringBuilder)localObject).append(bool5);
      ((StringBuilder)localObject).append(" allowPreDownload=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" hasPreDownloadSucc=");
      ((StringBuilder)localObject).append(bool2);
      LogUtility.c("NewUpgradeDialog", ((StringBuilder)localObject).toString());
      if ((!bool4) && (!MyAppApi.b()) && (bool5) && (bool1) && (!bool2))
      {
        LogUtility.c("NewUpgradeDialog", "---start pre Download YYB---");
        localObject = this.this$0;
        ((MyAppApi)localObject).a = new MyAppApi.InstallParams((MyAppApi)localObject);
        this.this$0.a.jdField_a_of_type_Boolean = true;
        this.this$0.a.b = false;
        this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
        this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
        this.this$0.a.jdField_a_of_type_Int = -1;
        MyAppApi.b(this.this$0, true);
        this.this$0.a(this.a, "ANDROIDQQ.NEWYYB.QQUPDATE", 1, "", "");
        return;
      }
      LogUtility.c("NewUpgradeDialog", "don't need preDownload return");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.20
 * JD-Core Version:    0.7.0.1
 */