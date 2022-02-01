package com.tencent.mtt.abtestsdk.entity;

import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import org.json.JSONObject;

public class FeatureStrategyEntity
{
  public static final String KEY_FEATURES_ENABLE_REPORT = "enableReport";
  public static final String KEY_FEATURES_REPORT_FETCH_DURATION = "refreshDuration";
  public static final String KEY_FEATURES_REPORT_ID = "reportId";
  public static final String KEY_FEATURES_REPORT_INTER = "sdkReportRate";
  public static final String KEY_FEATURES_REPORT_LAST_FETCH_TIME = "reportLastFetchTime";
  public static final String KEY_FEATURES_REPORT_TOKEN = "reportToken";
  public static final String KEY_FEATURES_REPORT_TYPE = "reportType";
  private boolean enableReport = false;
  private long lastFetchTime;
  private int reportFetchTimeInSecs = 30;
  private String reportId;
  private int reportInter = 0;
  private String reportToken;
  private String reportType = "atta";
  
  public long getLastFetchTime()
  {
    return this.lastFetchTime;
  }
  
  public int getReportFetchTimeInSecs()
  {
    return this.reportFetchTimeInSecs;
  }
  
  public String getReportId()
  {
    return this.reportId;
  }
  
  public int getReportInter()
  {
    return this.reportInter;
  }
  
  public String getReportToken()
  {
    return this.reportToken;
  }
  
  public String getReportType()
  {
    return this.reportType;
  }
  
  public boolean isEnableReport()
  {
    return this.enableReport;
  }
  
  public void readFromJson(JSONObject paramJSONObject)
  {
    try
    {
      this.enableReport = paramJSONObject.getBoolean("enableReport");
      this.reportInter = paramJSONObject.getInt("sdkReportRate");
      this.reportType = paramJSONObject.getString("reportType");
      this.reportId = paramJSONObject.getString("reportId");
      this.reportToken = paramJSONObject.getString("reportToken");
      this.reportFetchTimeInSecs = paramJSONObject.getInt("refreshDuration");
      setLastFetchTime(System.currentTimeMillis() / 1000L);
      return;
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("feature report object data invalid json format ");
      localStringBuilder.append(paramJSONObject.getMessage());
      ABTestLog.warn(localStringBuilder.toString(), new Object[0]);
    }
  }
  
  public void setEnableReport(boolean paramBoolean)
  {
    this.enableReport = paramBoolean;
  }
  
  public void setLastFetchTime(long paramLong)
  {
    this.lastFetchTime = paramLong;
  }
  
  public void setReportFetchTimeInSecs(int paramInt)
  {
    this.reportFetchTimeInSecs = paramInt;
  }
  
  public void setReportId(String paramString)
  {
    this.reportId = paramString;
  }
  
  public void setReportInter(int paramInt)
  {
    this.reportInter = paramInt;
  }
  
  public void setReportToken(String paramString)
  {
    this.reportToken = paramString;
  }
  
  public void setReportType(String paramString)
  {
    this.reportType = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeatureStrategyEntity{enableReport=");
    localStringBuilder.append(this.enableReport);
    localStringBuilder.append(", reportType='");
    localStringBuilder.append(this.reportType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reportId='");
    localStringBuilder.append(this.reportId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reportToken='");
    localStringBuilder.append(this.reportToken);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reportInter=");
    localStringBuilder.append(this.reportInter);
    localStringBuilder.append(", reportFetchTimeInSecs=");
    localStringBuilder.append(this.reportFetchTimeInSecs);
    localStringBuilder.append(", lastFetchTime=");
    localStringBuilder.append(this.lastFetchTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.FeatureStrategyEntity
 * JD-Core Version:    0.7.0.1
 */