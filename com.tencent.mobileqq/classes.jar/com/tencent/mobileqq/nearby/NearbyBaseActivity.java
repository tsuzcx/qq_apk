package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class NearbyBaseActivity
  extends BaseActivity
{
  protected NearbyAppInterface a;
  
  protected String getModuleId()
  {
    return "module_nearby";
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof NearbyAppInterface)) {
      this.a = ((NearbyAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 4, "NearbyIphoneTitileBarActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyBaseActivity
 * JD-Core Version:    0.7.0.1
 */