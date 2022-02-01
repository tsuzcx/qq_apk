package com.tencent.mtt.abtestsdk.entity;

public class BeaconExpEntity
{
  public static final String APPID_KEY = "A71";
  public static final String EXP_EVENT_CODE = "rqd_expimpression";
  public static final String EXP_NAME_KEY = "A149";
  public static final String GRAYID_KEY = "A148";
  public static final String REPORT_INITIATIVE_FLAG = "1";
  public static final String REPORT_PASSIVE_FLAG = "0";
  public static final String REPORT_TYPE_KEY = "reportFlag";
  public static final String USERID_KEY = "A70";
  private String appId;
  private String expName;
  private String grayId;
  private String reportFlag = "-1";
  private String userId;
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getExpName()
  {
    return this.expName;
  }
  
  public String getGrayId()
  {
    return this.grayId;
  }
  
  public String getReportFlag()
  {
    return this.reportFlag;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setExpName(String paramString)
  {
    this.expName = paramString;
  }
  
  public void setGrayId(String paramString)
  {
    this.grayId = paramString;
  }
  
  public void setReportFlag(String paramString)
  {
    this.reportFlag = paramString;
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.BeaconExpEntity
 * JD-Core Version:    0.7.0.1
 */