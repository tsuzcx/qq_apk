package com.tencent.open.downloadnew;

import altj;
import amlp;
import amlu;
import android.app.Activity;
import aowf;
import bdii;
import bfhb;
import bfhg;
import bfjt;
import bfko;
import bfkz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class MyAppApi$18
  implements Runnable
{
  public MyAppApi$18(bfko parambfko, Activity paramActivity) {}
  
  public void run()
  {
    bfhg.c("MyAppApi", "---isAutoInstall:" + bfjt.c() + " url:" + bfjt.a() + " interval:" + bfjt.a());
    boolean bool4;
    boolean bool5;
    UpgradeDetailWrapper localUpgradeDetailWrapper;
    if ((bfhb.b(this.a)) && (bfhb.c(this.a)))
    {
      bool4 = aowf.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity);
      bool5 = bfjt.b();
      localUpgradeDetailWrapper = amlp.a().a();
      if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {
        break label387;
      }
    }
    label387:
    for (boolean bool1 = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_a_of_type_Boolean;; bool1 = false)
    {
      boolean bool3 = bdii.a();
      boolean bool2 = bool3;
      int j;
      if (bool3)
      {
        j = bdii.a();
        if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_Amlu == null)) {
          break label382;
        }
      }
      label382:
      for (int i = localUpgradeDetailWrapper.jdField_a_of_type_Amlu.jdField_a_of_type_Int;; i = 0)
      {
        bool2 = bool3;
        if (i != j)
        {
          bdii.a(false);
          bdii.a(i);
          bool2 = false;
        }
        bfhg.c("NewUpgradeDialog", "predownload flags:isInstalled=" + bool4 + " needDownloadYYB = " + bool5 + " allowPreDownload=" + bool1 + " hasPreDownloadSucc=" + bool2);
        if ((!bool4) && (!this.this$0.b()) && (bool5) && (bool1) && (!bool2))
        {
          bfhg.c("NewUpgradeDialog", "---start pre Download YYB---");
          this.this$0.a = new bfkz(this.this$0);
          this.this$0.a.jdField_a_of_type_Boolean = true;
          this.this$0.a.b = false;
          this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
          this.this$0.a.jdField_a_of_type_Int = -1;
          bfko.b(this.this$0, true);
          this.this$0.a(this.a, "ANDROIDQQ.NEWYYB.QQUPDATE", 1);
          return;
        }
        bfhg.c("NewUpgradeDialog", "don't need preDownload return");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.18
 * JD-Core Version:    0.7.0.1
 */