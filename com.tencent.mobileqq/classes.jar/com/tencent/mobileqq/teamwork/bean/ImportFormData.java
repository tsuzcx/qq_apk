package com.tencent.mobileqq.teamwork.bean;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ImportFormData
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static ImportFormData a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          ImportFormData localImportFormData = new ImportFormData();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject != null)
          {
            localImportFormData.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
            localImportFormData.jdField_b_of_type_JavaLangString = paramJSONObject.optString("title");
            localImportFormData.jdField_a_of_type_Int = paramJSONObject.optInt("localPadId");
            localImportFormData.c = paramJSONObject.optString("localPadId");
            localImportFormData.d = paramJSONObject.optString("doc_id");
            localImportFormData.jdField_b_of_type_Int = paramJSONObject.optInt("doc_type");
            localImportFormData.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isCache");
          }
          return localImportFormData;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("ImportFormData", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.bean.ImportFormData
 * JD-Core Version:    0.7.0.1
 */