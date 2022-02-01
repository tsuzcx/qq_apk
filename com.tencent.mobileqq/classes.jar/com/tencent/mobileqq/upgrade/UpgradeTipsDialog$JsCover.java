package com.tencent.mobileqq.upgrade;

import awfw;
import bdll;
import bhdt;
import bhdu;
import bhed;
import com.tencent.qphone.base.util.QLog;

public class UpgradeTipsDialog$JsCover
  extends awfw
{
  protected UpgradeTipsDialog$JsCover(UpgradeTipsDialog paramUpgradeTipsDialog) {}
  
  public int tipsLoadComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "loadTipsComplete");
    }
    UpgradeTipsDialog.a(this.a, true);
    bdll.b(UpgradeTipsDialog.a(this.a), "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, bhdt.b(), String.valueOf(1), bhdu.a(), "");
    if (UpgradeTipsDialog.a(this.a) != null)
    {
      UpgradeTipsDialog.a(this.a).a(this.a);
      return 0;
    }
    try
    {
      this.a.show();
      return 0;
    }
    catch (Exception localException) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTipsDialog.JsCover
 * JD-Core Version:    0.7.0.1
 */