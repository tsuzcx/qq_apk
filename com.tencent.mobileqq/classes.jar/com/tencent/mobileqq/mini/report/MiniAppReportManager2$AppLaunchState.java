package com.tencent.mobileqq.mini.report;

import org.json.JSONObject;

public class MiniAppReportManager2$AppLaunchState
{
  public static final int LAUNCHING = 0;
  public static final int LAUNCH_FAIL = 2;
  public static final int LAUNCH_SUCESS = 1;
  public static boolean hasX5;
  public long activeTime;
  public String appId;
  public long clickTime;
  public int engineType;
  public boolean flutterMode;
  public boolean hasPkg;
  public long hideTime;
  public String jsError;
  public String launchId;
  public int launchResult = 0;
  public long launchTime;
  public long loadEndTime;
  public long loadTime;
  public boolean needReportLaunchResult;
  public int reportType;
  public long showTime;
  public int verType;
  
  public void fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.appId = paramString.getString("appid");
      this.engineType = paramString.getInt("engineType");
      this.reportType = paramString.getInt("reportType");
      this.verType = paramString.getInt("verType");
      this.launchId = paramString.getString("launchId");
      this.clickTime = paramString.getLong("clickTime");
      this.loadTime = paramString.getLong("loadTime");
      this.launchTime = paramString.getLong("launchTime");
      this.launchResult = paramString.getInt("launchResult");
      this.activeTime = paramString.getLong("activeTime");
      this.showTime = paramString.getLong("showTime");
      this.hideTime = paramString.getLong("hideTime");
      this.jsError = paramString.getString("jsError");
      this.needReportLaunchResult = paramString.getBoolean("needReportLaunchResult");
      this.hasPkg = paramString.getBoolean("hasPkg");
      this.flutterMode = paramString.optBoolean("flutterMode");
      this.loadEndTime = paramString.optLong("loadEndTime");
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public String hasPkgAndX5()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.flutterMode)
    {
      str = "flutterMode_";
      localStringBuilder = localStringBuilder.append(str);
      if (!hasX5) {
        break label64;
      }
      str = "hasX5";
      label33:
      localStringBuilder = localStringBuilder.append(str);
      if (!this.hasPkg) {
        break label70;
      }
    }
    label64:
    label70:
    for (String str = "_hasPkg";; str = "")
    {
      return str;
      str = "";
      break;
      str = "";
      break label33;
    }
  }
  
  public void reset()
  {
    this.loadTime = 0L;
    this.launchTime = 0L;
    this.launchResult = 0;
    this.showTime = 0L;
    this.hideTime = 0L;
    this.needReportLaunchResult = true;
    this.jsError = null;
    this.hasPkg = false;
    this.loadEndTime = 0L;
  }
  
  public String toJson()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("appid", this.appId);
      ((JSONObject)localObject).put("engineType", this.engineType);
      ((JSONObject)localObject).put("reportType", this.reportType);
      ((JSONObject)localObject).put("verType", this.verType);
      ((JSONObject)localObject).put("launchId", this.launchId);
      ((JSONObject)localObject).put("clickTime", this.clickTime);
      ((JSONObject)localObject).put("loadTime", this.loadTime);
      ((JSONObject)localObject).put("launchTime", this.launchTime);
      ((JSONObject)localObject).put("launchResult", this.launchResult);
      ((JSONObject)localObject).put("activeTime", this.activeTime);
      ((JSONObject)localObject).put("showTime", this.showTime);
      ((JSONObject)localObject).put("hideTime", this.hideTime);
      ((JSONObject)localObject).put("jsError", this.jsError);
      ((JSONObject)localObject).put("needReportLaunchResult", this.needReportLaunchResult);
      ((JSONObject)localObject).put("hasPkg", this.hasPkg);
      ((JSONObject)localObject).put("flutterMode", this.flutterMode);
      ((JSONObject)localObject).put("loadEndTime", this.loadEndTime);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchId: ").append(this.launchId).append(", appId: ").append(0);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager2.AppLaunchState
 * JD-Core Version:    0.7.0.1
 */