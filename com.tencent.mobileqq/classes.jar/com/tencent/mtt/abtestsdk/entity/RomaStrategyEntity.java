package com.tencent.mtt.abtestsdk.entity;

import org.json.JSONException;
import org.json.JSONObject;

public class RomaStrategyEntity
{
  public static final int INVALID_REFRESH_DURA_VALUE = -1;
  public static final String KEY_EXPERIMENTS_ENABLE_REPORT = "enableReport";
  public static final String KEY_EXPERIMENTS_REFRESH_DURA = "refreshDuration";
  private static final String KEY_EXPERIMENTS_REPORT_CONFIG = "reportConfig";
  public static final String KEY_EXPERIMENTS_REPORT_ID = "id";
  public static final String KEY_EXPERIMENTS_REPORT_TOKEN = "token";
  public static final String KEY_EXPERIMENTS_REPORT_TYPE = "reportType";
  public static final String KEY_EXPERIMENTS_REPORT_UPDATE_TIME = "updateTime";
  private boolean enableReport = false;
  private int refreshDuration = -1;
  private String reportId;
  private String reportToken;
  private String reportType = "atta";
  private long updateTime;
  
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
  
  public long getUpdateTime()
  {
    return this.updateTime;
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
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public void setEnableReport(boolean paramBoolean)
  {
    this.enableReport = paramBoolean;
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
  
  public void setUpdateTime(long paramLong)
  {
    this.updateTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.RomaStrategyEntity
 * JD-Core Version:    0.7.0.1
 */