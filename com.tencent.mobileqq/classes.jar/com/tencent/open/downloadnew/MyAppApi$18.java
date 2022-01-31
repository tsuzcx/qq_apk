package com.tencent.open.downloadnew;

import akbu;
import akuz;
import akve;
import android.app.Activity;
import aney;
import bbjm;
import bdid;
import bdii;
import bdkw;
import bdlr;
import bdmc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class MyAppApi$18
  implements Runnable
{
  public MyAppApi$18(bdlr parambdlr, Activity paramActivity) {}
  
  public void run()
  {
    bdii.c("MyAppApi", "---isAutoInstall:" + bdkw.c() + " url:" + bdkw.a() + " interval:" + bdkw.a());
    boolean bool4;
    boolean bool5;
    UpgradeDetailWrapper localUpgradeDetailWrapper;
    if ((bdid.b(this.a)) && (bdid.c(this.a)))
    {
      bool4 = aney.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity);
      bool5 = bdkw.b();
      localUpgradeDetailWrapper = akuz.a().a();
      if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {
        break label387;
      }
    }
    label387:
    for (boolean bool1 = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Boolean;; bool1 = false)
    {
      boolean bool3 = bbjm.a();
      boolean bool2 = bool3;
      int j;
      if (bool3)
      {
        j = bbjm.a();
        if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_Akve == null)) {
          break label382;
        }
      }
      label382:
      for (int i = localUpgradeDetailWrapper.jdField_a_of_type_Akve.jdField_a_of_type_Int;; i = 0)
      {
        bool2 = bool3;
        if (i != j)
        {
          bbjm.a(false);
          bbjm.a(i);
          bool2 = false;
        }
        bdii.c("NewUpgradeDialog", "predownload flags:isInstalled=" + bool4 + " needDownloadYYB = " + bool5 + " allowPreDownload=" + bool1 + " hasPreDownloadSucc=" + bool2);
        if ((!bool4) && (!this.this$0.b()) && (bool5) && (bool1) && (!bool2))
        {
          bdii.c("NewUpgradeDialog", "---start pre Download YYB---");
          this.this$0.a = new bdmc(this.this$0);
          this.this$0.a.jdField_a_of_type_Boolean = true;
          this.this$0.a.b = false;
          this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
          this.this$0.a.jdField_a_of_type_Int = -1;
          bdlr.b(this.this$0, true);
          this.this$0.a(this.a, "ANDROIDQQ.NEWYYB.QQUPDATE", 1);
          return;
        }
        bdii.c("NewUpgradeDialog", "don't need preDownload return");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.18
 * JD-Core Version:    0.7.0.1
 */