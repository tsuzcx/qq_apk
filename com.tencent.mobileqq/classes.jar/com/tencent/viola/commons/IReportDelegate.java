package com.tencent.viola.commons;

import java.util.HashMap;

public abstract interface IReportDelegate
{
  public abstract void addReportData(String paramString1, String paramString2);
  
  public abstract void dropFrameMonitor(int paramInt, String paramString);
  
  public abstract HashMap<String, String> getBaseReportData(String paramString);
  
  public abstract void reportData(String paramString);
  
  public abstract void reportHttpData(HashMap<String, String> paramHashMap, String paramString);
  
  public abstract void reportJsError(boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void reportNVProcess(String paramString1, String paramString2, String paramString3);
  
  public abstract void reportNativeVueError(String paramString1, String paramString2);
  
  public abstract void reportPageProcess(String paramString1, String paramString2, String paramString3);
  
  public abstract void reportRunningData(HashMap<String, String> paramHashMap, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.commons.IReportDelegate
 * JD-Core Version:    0.7.0.1
 */