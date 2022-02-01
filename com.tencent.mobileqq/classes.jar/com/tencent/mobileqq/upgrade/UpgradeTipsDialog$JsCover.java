package com.tencent.mobileqq.upgrade;

import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class UpgradeTipsDialog$JsCover
  extends JsBridge.JsHandler
{
  protected UpgradeTipsDialog$JsCover(UpgradeTipsDialog paramUpgradeTipsDialog) {}
  
  public int tipsLoadComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "loadTipsComplete");
    }
    UpgradeTipsDialog.a(this.a, true);
    ReportController.b(UpgradeTipsDialog.b(this.a), "CliOper", "", "", "0X8004DA0", "0X8004DA0", 0, 0, UpgradeConstants.b(), String.valueOf(1), UpgradeController.k(), "");
    if (UpgradeTipsDialog.c(this.a) != null) {
      UpgradeTipsDialog.c(this.a).a(this.a);
    }
    try
    {
      this.a.show();
      label93:
      return 0;
    }
    catch (Exception localException)
    {
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTipsDialog.JsCover
 * JD-Core Version:    0.7.0.1
 */