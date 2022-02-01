package com.tencent.thumbplayer.api.report;

import java.util.Map;

public abstract interface ITPBusinessReportManager
{
  public static final int EVENT_ID_302_REDIRECT = 1001;
  public static final int EVENT_ID_EARLY_ERROR = 1100;
  public static final int EVENT_ID_GET_CDN_URL = 1000;
  
  @Deprecated
  public abstract void reportEvent(int paramInt, Map<String, Object> paramMap);
  
  public abstract void setReportInfoGetter(TPDefaultReportInfo paramTPDefaultReportInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.report.ITPBusinessReportManager
 * JD-Core Version:    0.7.0.1
 */