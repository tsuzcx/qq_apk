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

class MyAppApi$18
  implements Runnable
{
  MyAppApi$18(MyAppApi paramMyAppApi, Activity paramActivity) {}
  
  public void run()
  {
    LogUtility.c("MyAppApi", "---isAutoInstall:" + ControlPolicyUtil.c() + " url:" + ControlPolicyUtil.a() + " interval:" + ControlPolicyUtil.a());
    boolean bool4;
    boolean bool5;
    UpgradeDetailWrapper localUpgradeDetailWrapper;
    if ((APNUtil.b(this.a)) && (APNUtil.c(this.a)))
    {
      bool4 = ApkUtils.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity);
      bool5 = ControlPolicyUtil.b();
      localUpgradeDetailWrapper = UpgradeController.a().a();
      if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {
        break label387;
      }
    }
    label387:
    for (boolean bool1 = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Boolean;; bool1 = false)
    {
      boolean bool3 = SPSettings.a();
      boolean bool2 = bool3;
      int j;
      if (bool3)
      {
        j = SPSettings.a();
        if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo == null)) {
          break label382;
        }
      }
      label382:
      for (int i = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;; i = 0)
      {
        bool2 = bool3;
        if (i != j)
        {
          SPSettings.a(false);
          SPSettings.a(i);
          bool2 = false;
        }
        LogUtility.c("NewUpgradeDialog", "predownload flags:isInstalled=" + bool4 + " needDownloadYYB = " + bool5 + " allowPreDownload=" + bool1 + " hasPreDownloadSucc=" + bool2);
        if ((!bool4) && (!this.this$0.b()) && (bool5) && (bool1) && (!bool2))
        {
          LogUtility.c("NewUpgradeDialog", "---start pre Download YYB---");
          this.this$0.a = new MyAppApi.InstallParams(this.this$0);
          this.this$0.a.jdField_a_of_type_Boolean = true;
          this.this$0.a.b = false;
          this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
          this.this$0.a.jdField_a_of_type_Int = -1;
          MyAppApi.b(this.this$0, true);
          this.this$0.a(this.a, "ANDROIDQQ.NEWYYB.QQUPDATE", 1);
          return;
        }
        LogUtility.c("NewUpgradeDialog", "don't need preDownload return");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.18
 * JD-Core Version:    0.7.0.1
 */