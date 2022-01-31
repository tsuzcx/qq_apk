package com.tencent.open.downloadnew;

import ajnl;
import akgo;
import akgt;
import amom;
import android.app.Activity;
import bahs;
import bcdn;
import bcds;
import bcgg;
import bchb;
import bchm;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class MyAppApi$18
  implements Runnable
{
  public MyAppApi$18(bchb parambchb, Activity paramActivity) {}
  
  public void run()
  {
    bcds.c("MyAppApi", "---isAutoInstall:" + bcgg.c() + " url:" + bcgg.a() + " interval:" + bcgg.a());
    boolean bool4;
    boolean bool5;
    UpgradeDetailWrapper localUpgradeDetailWrapper;
    if ((bcdn.b(this.a)) && (bcdn.c(this.a)))
    {
      bool4 = amom.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity);
      bool5 = bcgg.b();
      localUpgradeDetailWrapper = akgo.a().a();
      if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {
        break label387;
      }
    }
    label387:
    for (boolean bool1 = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Boolean;; bool1 = false)
    {
      boolean bool3 = bahs.a();
      boolean bool2 = bool3;
      int j;
      if (bool3)
      {
        j = bahs.a();
        if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_Akgt == null)) {
          break label382;
        }
      }
      label382:
      for (int i = localUpgradeDetailWrapper.jdField_a_of_type_Akgt.jdField_a_of_type_Int;; i = 0)
      {
        bool2 = bool3;
        if (i != j)
        {
          bahs.a(false);
          bahs.a(i);
          bool2 = false;
        }
        bcds.c("NewUpgradeDialog", "predownload flags:isInstalled=" + bool4 + " needDownloadYYB = " + bool5 + " allowPreDownload=" + bool1 + " hasPreDownloadSucc=" + bool2);
        if ((!bool4) && (!this.this$0.b()) && (bool5) && (bool1) && (!bool2))
        {
          bcds.c("NewUpgradeDialog", "---start pre Download YYB---");
          this.this$0.a = new bchm(this.this$0);
          this.this$0.a.jdField_a_of_type_Boolean = true;
          this.this$0.a.b = false;
          this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
          this.this$0.a.jdField_a_of_type_Int = -1;
          bchb.b(this.this$0, true);
          this.this$0.a(this.a, "ANDROIDQQ.NEWYYB.QQUPDATE", 1);
          return;
        }
        bcds.c("NewUpgradeDialog", "don't need preDownload return");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.18
 * JD-Core Version:    0.7.0.1
 */