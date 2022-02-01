package com.tencent.open.downloadnew;

import android.app.Activity;
import arta;
import bhdl;
import bhdu;
import bhdz;
import bhrv;
import bjts;
import bjtx;
import bjwj;
import bjxd;
import bjxo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;

public class MyAppApi$18
  implements Runnable
{
  public MyAppApi$18(bjxd parambjxd, Activity paramActivity) {}
  
  public void run()
  {
    bjtx.c("MyAppApi", "---isAutoInstall:" + bjwj.c() + " url:" + bjwj.a() + " interval:" + bjwj.a());
    boolean bool4;
    boolean bool5;
    UpgradeDetailWrapper localUpgradeDetailWrapper;
    if ((bjts.b(this.a)) && (bjts.c(this.a)))
    {
      bool4 = arta.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity);
      bool5 = bjwj.b();
      localUpgradeDetailWrapper = bhdu.a().a();
      if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig == null) || (localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog == null)) {
        break label387;
      }
    }
    label387:
    for (boolean bool1 = localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeNewUpgradeConfig.dialog.jdField_a_of_type_Boolean;; bool1 = false)
    {
      boolean bool3 = bhrv.a();
      boolean bool2 = bool3;
      int j;
      if (bool3)
      {
        j = bhrv.a();
        if ((localUpgradeDetailWrapper == null) || (localUpgradeDetailWrapper.jdField_a_of_type_Bhdz == null)) {
          break label382;
        }
      }
      label382:
      for (int i = localUpgradeDetailWrapper.jdField_a_of_type_Bhdz.jdField_a_of_type_Int;; i = 0)
      {
        bool2 = bool3;
        if (i != j)
        {
          bhrv.a(false);
          bhrv.a(i);
          bool2 = false;
        }
        bjtx.c("NewUpgradeDialog", "predownload flags:isInstalled=" + bool4 + " needDownloadYYB = " + bool5 + " allowPreDownload=" + bool1 + " hasPreDownloadSucc=" + bool2);
        if ((!bool4) && (!this.this$0.b()) && (bool5) && (bool1) && (!bool2))
        {
          bjtx.c("NewUpgradeDialog", "---start pre Download YYB---");
          this.this$0.a = new bjxo(this.this$0);
          this.this$0.a.jdField_a_of_type_Boolean = true;
          this.this$0.a.b = false;
          this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
          this.this$0.a.jdField_a_of_type_Int = -1;
          bjxd.b(this.this$0, true);
          this.this$0.a(this.a, "ANDROIDQQ.NEWYYB.QQUPDATE", 1);
          return;
        }
        bjtx.c("NewUpgradeDialog", "don't need preDownload return");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.18
 * JD-Core Version:    0.7.0.1
 */