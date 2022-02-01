package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class BootOptimizeConfigureBean
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public boolean c;
  public boolean d = true;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = true;
  public boolean i = false;
  public boolean j = true;
  public boolean k = false;
  public boolean l = false;
  public boolean m = true;
  
  public BootOptimizeConfigureBean()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static BootOptimizeConfigureBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      BootOptimizeConfigureBean localBootOptimizeConfigureBean = new BootOptimizeConfigureBean();
      paramString = new JSONObject(paramString);
      localBootOptimizeConfigureBean.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
      localBootOptimizeConfigureBean.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", -1L);
      localBootOptimizeConfigureBean.jdField_b_of_type_Boolean = paramString.optBoolean("enableKernelServiceInVivo", false);
      localBootOptimizeConfigureBean.c = paramString.optBoolean("disableSimpleBreakStrategy", false);
      localBootOptimizeConfigureBean.d = paramString.optBoolean("isInitDTSDKAtStart", true);
      localBootOptimizeConfigureBean.jdField_a_of_type_Int = paramString.optInt("enableSyslogPrintInt", 0);
      localBootOptimizeConfigureBean.e = paramString.optBoolean("delayLoadUnimportantProxy", false);
      localBootOptimizeConfigureBean.f = paramString.optBoolean("enableMemoryLeak", false);
      localBootOptimizeConfigureBean.g = paramString.optBoolean("disableNavigationBar", false);
      localBootOptimizeConfigureBean.h = paramString.optBoolean("tryUseNewCount", true);
      localBootOptimizeConfigureBean.i = paramString.optBoolean("disableSavePluginDownloadedInfo", false);
      localBootOptimizeConfigureBean.j = paramString.optBoolean("tryClearInvalidUnreadMark", true);
      localBootOptimizeConfigureBean.k = paramString.optBoolean("enableNativeMemMonitor", false);
      localBootOptimizeConfigureBean.jdField_a_of_type_JavaLangString = paramString.optString("natMemMonitorIgnoreList", "");
      localBootOptimizeConfigureBean.jdField_b_of_type_JavaLangString = paramString.optString("logcatHookIgnoreList", "");
      localBootOptimizeConfigureBean.l = paramString.optBoolean("disableDFPluginStart", false);
      localBootOptimizeConfigureBean.m = paramString.optBoolean("enableCalendar", true);
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localBootOptimizeConfigureBean.toString());
      QLog.d("BootOptimizeConfProcessor", 2, paramString.toString());
      return localBootOptimizeConfigureBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BootOptimizeConfProcessor", 2, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BootOptimizeConfigureBean{useParcelForBoot=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", delayPluginManageTimeInMills=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", enableKernelServiceInVivo=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", disableSimpleBreakStrategy=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isInitDTSDKAtStart = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", enableSyslogPrint = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", delayLoadUnimportantProxy = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", tryUseNewCount = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", disableSavePluginDownloadedInfo = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", tryClearInvalidUnreadMark = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", enableNativeMemMonitor = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", natMemMonitorIgnoreList = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", logcatHookIgnoreList = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", disableDFPluginStart = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", enableReminderCalendar = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BootOptimizeConfigureBean
 * JD-Core Version:    0.7.0.1
 */