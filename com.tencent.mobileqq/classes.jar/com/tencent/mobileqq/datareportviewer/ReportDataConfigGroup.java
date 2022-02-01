package com.tencent.mobileqq.datareportviewer;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportDataConfigGroup
  extends BaseReportDataConfig
{
  public ArrayList<ReportDataConfig> a;
  
  public static ReportDataConfigGroup a(JSONObject paramJSONObject)
  {
    ReportDataConfigGroup localReportDataConfigGroup = new ReportDataConfigGroup();
    localReportDataConfigGroup.jdField_a_of_type_JavaLangString = paramJSONObject.optString("group");
    paramJSONObject = paramJSONObject.optJSONArray("configs");
    localReportDataConfigGroup.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramJSONObject.length());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      ReportDataConfig localReportDataConfig = ReportDataConfig.a(paramJSONObject.optJSONObject(i));
      localReportDataConfig.a = localReportDataConfigGroup;
      localReportDataConfigGroup.jdField_a_of_type_JavaUtilArrayList.add(localReportDataConfig);
      i += 1;
    }
    return localReportDataConfigGroup;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("group", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("isChecked", this.jdField_a_of_type_Boolean);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((ReportDataConfig)localIterator.next()).a());
      }
      localJSONObject.put("configs", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return localJSONObject;
    }
    return localJSONObject;
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.ReportDataConfigGroup
 * JD-Core Version:    0.7.0.1
 */