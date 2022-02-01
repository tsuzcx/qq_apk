package com.tencent.thumbplayer.tplayer.plugins.report;

import java.util.Map;

public abstract interface ITPReportProperties
{
  public abstract void propertiesToMap(Map<String, String> paramMap);
  
  public abstract void put(String paramString, float paramFloat);
  
  public abstract void put(String paramString, int paramInt);
  
  public abstract void put(String paramString, long paramLong);
  
  public abstract void put(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.ITPReportProperties
 * JD-Core Version:    0.7.0.1
 */