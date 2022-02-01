package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class BootOptimizeConfigureBean
{
  public boolean a = true;
  public long b = -1L;
  public boolean c = false;
  public boolean d;
  public boolean e = true;
  public int f;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public boolean j = true;
  public boolean k = false;
  public boolean l = true;
  public boolean m = false;
  public boolean n = false;
  public boolean o = true;
  public String p = "";
  public String q = "";
  
  public static BootOptimizeConfigureBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      BootOptimizeConfigureBean localBootOptimizeConfigureBean = new BootOptimizeConfigureBean();
      paramString = new JSONObject(paramString);
      localBootOptimizeConfigureBean.a = paramString.optBoolean("useParcelForBoot", true);
      localBootOptimizeConfigureBean.b = paramString.optLong("delayPluginManageTimeInMills", -1L);
      localBootOptimizeConfigureBean.c = paramString.optBoolean("enableKernelServiceInVivo", false);
      localBootOptimizeConfigureBean.d = paramString.optBoolean("disableSimpleBreakStrategy", false);
      localBootOptimizeConfigureBean.e = paramString.optBoolean("isInitDTSDKAtStart", true);
      localBootOptimizeConfigureBean.f = paramString.optInt("enableSyslogPrintInt", 0);
      localBootOptimizeConfigureBean.g = paramString.optBoolean("delayLoadUnimportantProxy", false);
      localBootOptimizeConfigureBean.h = paramString.optBoolean("enableMemoryLeak", false);
      localBootOptimizeConfigureBean.i = paramString.optBoolean("disableNavigationBar", false);
      localBootOptimizeConfigureBean.j = paramString.optBoolean("tryUseNewCount", true);
      localBootOptimizeConfigureBean.k = paramString.optBoolean("disableSavePluginDownloadedInfo", false);
      localBootOptimizeConfigureBean.l = paramString.optBoolean("tryClearInvalidUnreadMark", true);
      localBootOptimizeConfigureBean.m = paramString.optBoolean("enableNativeMemMonitor", false);
      localBootOptimizeConfigureBean.p = paramString.optString("natMemMonitorIgnoreList", "");
      localBootOptimizeConfigureBean.q = paramString.optString("logcatHookIgnoreList", "");
      localBootOptimizeConfigureBean.n = paramString.optBoolean("disableDFPluginStart", false);
      localBootOptimizeConfigureBean.o = paramString.optBoolean("enableCalendar", true);
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(", delayPluginManageTimeInMills=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", enableKernelServiceInVivo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", disableSimpleBreakStrategy=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isInitDTSDKAtStart = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", enableSyslogPrint = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", delayLoadUnimportantProxy = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", tryUseNewCount = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", disableSavePluginDownloadedInfo = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", tryClearInvalidUnreadMark = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", enableNativeMemMonitor = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", natMemMonitorIgnoreList = ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", logcatHookIgnoreList = ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", disableDFPluginStart = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", enableReminderCalendar = ");
    localStringBuilder.append(this.o);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BootOptimizeConfigureBean
 * JD-Core Version:    0.7.0.1
 */