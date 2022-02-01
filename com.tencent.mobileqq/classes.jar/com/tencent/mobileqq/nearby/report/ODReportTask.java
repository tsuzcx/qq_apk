package com.tencent.mobileqq.nearby.report;

import android.app.Application;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class ODReportTask
{
  private Application jdField_a_of_type_AndroidAppApplication;
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public ODReportTask()
  {
    this(BaseApplication.getContext());
  }
  
  public ODReportTask(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
    this.jdField_a_of_type_JavaLangString = DeviceInfoUtil.c();
    this.b = DeviceInfoUtil.a();
    this.jdField_a_of_type_AndroidOsBundle = a(this.jdField_a_of_type_AndroidAppApplication);
    this.jdField_a_of_type_AndroidOsBundle.putString("tid", "personal_live_base");
    this.jdField_a_of_type_AndroidOsBundle.putString("bid", "b_sng_im_personal_live");
  }
  
  private Bundle a(Application paramApplication)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("platform", "Android");
    localBundle.putString("uin_type", "0");
    localBundle.putString("manufacturer", Build.MANUFACTURER);
    localBundle.putString("deviceID", String.valueOf(DeviceInfoUtil.a()));
    localBundle.putString("osversion", Build.VERSION.RELEASE);
    localBundle.putString("qqversion", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("clientVersion", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("actiontime", String.valueOf(System.currentTimeMillis() / 1000L));
    localBundle.putString("network", String.valueOf(TurtleReportHelper.a(paramApplication)));
    localBundle.putString("imei", this.b);
    return localBundle;
  }
  
  public ODReportTask a(double paramDouble)
  {
    return a("res1", paramDouble);
  }
  
  public ODReportTask a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramString);
    return this;
  }
  
  public ODReportTask a(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public ODReportTask a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public ODReportTask a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public ODReportTask a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "null";
    }
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, str.replace("&", "_"));
    return this;
  }
  
  public void a()
  {
    TurtleReportCenter.a.a(this.jdField_a_of_type_AndroidOsBundle);
  }
  
  public ODReportTask b(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("module", paramString);
    return this;
  }
  
  public ODReportTask c(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("action", paramString);
    return this;
  }
  
  public ODReportTask d(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("source", paramString);
    return this;
  }
  
  public ODReportTask e(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("opername", paramString);
    return this;
  }
  
  public ODReportTask f(String paramString)
  {
    return a("extcol1", paramString);
  }
  
  public ODReportTask g(String paramString)
  {
    return a("extcol2", paramString);
  }
  
  public ODReportTask h(String paramString)
  {
    return a("extcol3", paramString);
  }
  
  public ODReportTask i(String paramString)
  {
    return a("res1", paramString);
  }
  
  public ODReportTask j(String paramString)
  {
    return a("res2", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.report.ODReportTask
 * JD-Core Version:    0.7.0.1
 */