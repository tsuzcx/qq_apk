package com.tencent.mtt.abtestsdk.entity;

import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpStrategyEntity
{
  public static final String KEY_EXPERIMENTS_ENABLE_REPORT = "enableReport";
  public static final String KEY_EXPERIMENTS_REFRESH_DURA = "refreshDuration";
  public static final String KEY_EXPERIMENTS_REPORT_ATTA_TYPE = "atta";
  private static final String KEY_EXPERIMENTS_REPORT_CONFIG = "reportConfig";
  public static final String KEY_EXPERIMENTS_REPORT_ID = "id";
  public static final String KEY_EXPERIMENTS_REPORT_TOKEN = "token";
  public static final String KEY_EXPERIMENTS_REPORT_TYPE = "reportType";
  public static final String KEY_EXPERIMENTS_REPORT_UPDATE_TIME = "updateTime";
  private boolean enableReport = false;
  private long lastFetchDataTime;
  private int refreshDuration = 30;
  private String reportId;
  private String reportToken;
  private String reportType = "atta";
  
  public long getLastFetchDataTime()
  {
    return this.lastFetchDataTime;
  }
  
  public int getRefreshDuration()
  {
    return this.refreshDuration;
  }
  
  public String getReportId()
  {
    return this.reportId;
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
      this.refreshDuration = paramJSONObject.getInt("refreshDuration");
      this.reportType = paramJSONObject.getString("reportType");
      paramJSONObject = paramJSONObject.getJSONObject("reportConfig");
      if (paramJSONObject != null)
      {
        this.reportId = paramJSONObject.getString("id");
        this.reportToken = paramJSONObject.getString("token");
      }
      setLastFetchDataTime(System.currentTimeMillis() / 1000L);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid exp strategy format ");
      localStringBuilder.append(paramJSONObject.getMessage());
      ABTestLog.error(localStringBuilder.toString(), new Object[0]);
    }
  }
  
  public void setEnableReport(boolean paramBoolean)
  {
    this.enableReport = paramBoolean;
  }
  
  public void setLastFetchDataTime(long paramLong)
  {
    this.lastFetchDataTime = paramLong;
  }
  
  public void setRefreshDuration(int paramInt)
  {
    this.refreshDuration = paramInt;
  }
  
  public void setReportId(String paramString)
  {
    this.reportId = paramString;
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
    localStringBuilder.append("ExpStrategyEntity{enableReport=");
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
    localStringBuilder.append(", refreshDuration=");
    localStringBuilder.append(this.refreshDuration);
    localStringBuilder.append(", lastFetchDataTime=");
    localStringBuilder.append(this.lastFetchDataTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.ExpStrategyEntity
 * JD-Core Version:    0.7.0.1
 */