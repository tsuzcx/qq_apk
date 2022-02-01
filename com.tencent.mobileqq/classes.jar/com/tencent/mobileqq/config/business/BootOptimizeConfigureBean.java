package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class BootOptimizeConfigureBean
{
  public int a;
  public long a;
  public boolean a;
  public boolean b = false;
  public boolean c;
  public boolean d = true;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public boolean k = false;
  
  public BootOptimizeConfigureBean()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static BootOptimizeConfigureBean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        BootOptimizeConfigureBean localBootOptimizeConfigureBean = new BootOptimizeConfigureBean();
        paramString = new JSONObject(paramString);
        localBootOptimizeConfigureBean.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
        localBootOptimizeConfigureBean.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", -1L);
        localBootOptimizeConfigureBean.b = paramString.optBoolean("enableKernelServiceInVivo", false);
        localBootOptimizeConfigureBean.c = paramString.optBoolean("disableSimpleBreakStrategy", false);
        localBootOptimizeConfigureBean.d = paramString.optBoolean("isInitDTSDKAtStart", true);
        localBootOptimizeConfigureBean.jdField_a_of_type_Int = paramString.optInt("enableSyslogPrintInt", 0);
        localBootOptimizeConfigureBean.e = paramString.optBoolean("delayLoadUnimportantProxy", false);
        localBootOptimizeConfigureBean.f = paramString.optBoolean("enableMemoryLeak", false);
        localBootOptimizeConfigureBean.g = paramString.optBoolean("disableNavigationBar", false);
        localBootOptimizeConfigureBean.h = paramString.optBoolean("tryUseNewCount", false);
        localBootOptimizeConfigureBean.i = paramString.optBoolean("disableSavePluginDownloadedInfo", false);
        localBootOptimizeConfigureBean.j = paramString.optBoolean("tryClearInvalidUnreadMark", false);
        localBootOptimizeConfigureBean.k = paramString.optBoolean("enableNativeMemMonitor", false);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localBootOptimizeConfigureBean.toString());
        return localBootOptimizeConfigureBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BootOptimizeConfProcessor", 2, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    return "BootOptimizeConfigureBean{useParcelForBoot=" + this.jdField_a_of_type_Boolean + ", delayPluginManageTimeInMills=" + this.jdField_a_of_type_Long + ", enableKernelServiceInVivo=" + this.b + ", disableSimpleBreakStrategy=" + this.c + ", isInitDTSDKAtStart = " + this.d + ", enableSyslogPrint = " + this.jdField_a_of_type_Int + ", delayLoadUnimportantProxy = " + this.e + ", tryUseNewCount = " + this.h + ", disableSavePluginDownloadedInfo = " + this.i + ", tryClearInvalidUnreadMark = " + this.j + ", enableNativeMemMonitor = " + this.k + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BootOptimizeConfigureBean
 * JD-Core Version:    0.7.0.1
 */