package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class WVStatisticsConfBean
{
  public boolean a = false;
  public boolean b = false;
  public boolean c = true;
  public String d = "0";
  public String e = "0";
  public String f = "0";
  public String g = "";
  
  public static WVStatisticsConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        WVStatisticsConfBean localWVStatisticsConfBean = new WVStatisticsConfBean();
        paramString = new JSONObject(paramString);
        if (paramString.has("wvShouldReportPerf"))
        {
          if (paramString.optInt("wvShouldReportPerf") == 1)
          {
            bool = true;
            localWVStatisticsConfBean.a = bool;
          }
        }
        else
        {
          if (paramString.has("wvShouldReportJsapiCall"))
          {
            if (paramString.optInt("wvShouldReportJsapiCall") != 1) {
              break label258;
            }
            bool = true;
            localWVStatisticsConfBean.b = bool;
          }
          if (paramString.has("wvShouldReportOpenapiCall"))
          {
            if (paramString.optInt("wvShouldReportOpenapiCall") != 1) {
              break label263;
            }
            bool = true;
            localWVStatisticsConfBean.c = bool;
          }
          if (paramString.has("wvPerformanceRate")) {
            localWVStatisticsConfBean.d = paramString.optString("wvPerformanceRate");
          }
          if (paramString.has("wvJsapiCallRate")) {
            localWVStatisticsConfBean.e = paramString.optString("wvJsapiCallRate");
          }
          if (paramString.has("wvSchemeRate")) {
            localWVStatisticsConfBean.f = paramString.optString("wvSchemeRate");
          }
          if (paramString.has("recogniseText")) {
            localWVStatisticsConfBean.g = paramString.optString("recogniseText");
          }
          paramString = new StringBuilder();
          paramString.append("confBean = ");
          paramString.append(localWVStatisticsConfBean.toString());
          QLog.d("ConfBean", 2, paramString.toString());
          return localWVStatisticsConfBean;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
      continue;
      label258:
      bool = false;
      continue;
      label263:
      bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("reportPerformance:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" reportJsapi:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" reportOpenapi:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" performanceRate:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" jsapiRate:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" schemeRate:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" recogniseText:");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVStatisticsConfBean
 * JD-Core Version:    0.7.0.1
 */