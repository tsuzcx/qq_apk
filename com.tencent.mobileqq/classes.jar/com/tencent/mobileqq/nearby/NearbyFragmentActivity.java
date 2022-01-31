package com.tencent.mobileqq.nearby;

import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class NearbyFragmentActivity
  extends FragmentActivity
{
  NearbyAppInterface a;
  
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
      QLog.i("NearbyFragmentActivity", 4, "NearbyFragmentActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFragmentActivity
 * JD-Core Version:    0.7.0.1
 */