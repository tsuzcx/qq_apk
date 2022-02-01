package com.tencent.mobileqq.datareportviewer;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportDataConfigGroup
  extends BaseReportDataConfig
{
  public ArrayList<ReportDataConfig> c;
  
  public static ReportDataConfigGroup a(JSONObject paramJSONObject)
  {
    ReportDataConfigGroup localReportDataConfigGroup = new ReportDataConfigGroup();
    localReportDataConfigGroup.a = paramJSONObject.optString("group");
    paramJSONObject = paramJSONObject.optJSONArray("configs");
    localReportDataConfigGroup.c = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      ReportDataConfig localReportDataConfig = ReportDataConfig.a(paramJSONObject.optJSONObject(i));
      localReportDataConfig.d = localReportDataConfigGroup;
      localReportDataConfigGroup.c.add(localReportDataConfig);
      i += 1;
    }
    return localReportDataConfigGroup;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("group", this.a);
      localJSONObject.put("isChecked", this.b);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((ReportDataConfig)localIterator.next()).a());
      }
      localJSONObject.put("configs", localJSONArray);
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.ReportDataConfigGroup
 * JD-Core Version:    0.7.0.1
 */