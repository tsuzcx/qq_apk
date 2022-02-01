package com.tencent.mobileqq.datareportviewer;

import org.json.JSONException;
import org.json.JSONObject;

public class ReportDataConfig
  extends BaseReportDataConfig
{
  public ReportDataConfigGroup a;
  public String b;
  public boolean b;
  
  public static ReportDataConfig a(JSONObject paramJSONObject)
  {
    ReportDataConfig localReportDataConfig = new ReportDataConfig();
    localReportDataConfig.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
    localReportDataConfig.jdField_b_of_type_JavaLangString = paramJSONObject.optString("action");
    localReportDataConfig.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isChecked", true);
    localReportDataConfig.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("isAddByUser");
    return localReportDataConfig;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("action", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("isChecked", this.jdField_a_of_type_Boolean);
      localJSONObject.put("isAddByUser", this.jdField_b_of_type_Boolean);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean b()
  {
    ReportDataConfigGroup localReportDataConfigGroup = this.jdField_a_of_type_ComTencentMobileqqDatareportviewerReportDataConfigGroup;
    if (localReportDataConfigGroup == null) {
      return this.jdField_a_of_type_Boolean;
    }
    return localReportDataConfigGroup.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.ReportDataConfig
 * JD-Core Version:    0.7.0.1
 */