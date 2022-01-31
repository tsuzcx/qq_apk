package com.tencent.mobileqq.olympic.activity;

import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ShopScanToolBaseActivity
  extends AbsBaseWebViewActivity
{
  public OlympicToolAppInterface a;
  
  public String getModuleId()
  {
    return "module_olympic";
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof OlympicToolAppInterface)) {
      this.a = ((OlympicToolAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 4, "OlympicToolBaseActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ShopScanToolBaseActivity
 * JD-Core Version:    0.7.0.1
 */