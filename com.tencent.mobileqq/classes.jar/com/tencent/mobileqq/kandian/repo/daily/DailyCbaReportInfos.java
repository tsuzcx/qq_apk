package com.tencent.mobileqq.kandian.repo.daily;

import java.util.Comparator;
import org.json.JSONObject;

public class DailyCbaReportInfos
  implements Comparator<JSONObject>
{
  String a;
  
  public DailyCbaReportInfos(String paramString)
  {
    this.a = paramString;
  }
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    long l = paramJSONObject1.optLong(this.a);
    return (int)(paramJSONObject2.optLong(this.a) - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.daily.DailyCbaReportInfos
 * JD-Core Version:    0.7.0.1
 */