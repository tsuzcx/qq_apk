package com.tencent.mobileqq.datareportviewer;

import org.json.JSONException;
import org.json.JSONObject;

public class ReportDataConfig
  extends BaseReportDataConfig
{
  public String c;
  public ReportDataConfigGroup d;
  public boolean e;
  
  public static ReportDataConfig a(JSONObject paramJSONObject)
  {
    ReportDataConfig localReportDataConfig = new ReportDataConfig();
    localReportDataConfig.a = paramJSONObject.optString("name");
    localReportDataConfig.c = paramJSONObject.optString("action");
    localReportDataConfig.b = paramJSONObject.optBoolean("isChecked", true);
    localReportDataConfig.e = paramJSONObject.optBoolean("isAddByUser");
    return localReportDataConfig;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.a);
      localJSONObject.put("action", this.c);
      localJSONObject.put("isChecked", this.b);
      localJSONObject.put("isAddByUser", this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public boolean c()
  {
    ReportDataConfigGroup localReportDataConfigGroup = this.d;
    if (localReportDataConfigGroup == null) {
      return this.b;
    }
    return localReportDataConfigGroup.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.ReportDataConfig
 * JD-Core Version:    0.7.0.1
 */