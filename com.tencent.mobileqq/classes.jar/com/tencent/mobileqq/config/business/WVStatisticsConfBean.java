package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class WVStatisticsConfBean
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d = "";
  
  public WVStatisticsConfBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "0";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_c_of_type_JavaLangString = "0";
  }
  
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
            localWVStatisticsConfBean.jdField_a_of_type_Boolean = bool;
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
            localWVStatisticsConfBean.jdField_b_of_type_Boolean = bool;
          }
          if (paramString.has("wvShouldReportOpenapiCall"))
          {
            if (paramString.optInt("wvShouldReportOpenapiCall") != 1) {
              break label263;
            }
            bool = true;
            localWVStatisticsConfBean.jdField_c_of_type_Boolean = bool;
          }
          if (paramString.has("wvPerformanceRate")) {
            localWVStatisticsConfBean.jdField_a_of_type_JavaLangString = paramString.optString("wvPerformanceRate");
          }
          if (paramString.has("wvJsapiCallRate")) {
            localWVStatisticsConfBean.jdField_b_of_type_JavaLangString = paramString.optString("wvJsapiCallRate");
          }
          if (paramString.has("wvSchemeRate")) {
            localWVStatisticsConfBean.jdField_c_of_type_JavaLangString = paramString.optString("wvSchemeRate");
          }
          if (paramString.has("recogniseText")) {
            localWVStatisticsConfBean.d = paramString.optString("recogniseText");
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
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" reportJsapi:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" reportOpenapi:");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(" performanceRate:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" jsapiRate:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" schemeRate:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" recogniseText:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVStatisticsConfBean
 * JD-Core Version:    0.7.0.1
 */