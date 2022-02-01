package com.tencent.mobileqq.teamwork.bean;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ImportFormData
{
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public int f;
  public boolean g;
  
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
            localImportFormData.a = paramJSONObject.optString("url");
            localImportFormData.b = paramJSONObject.optString("title");
            localImportFormData.c = paramJSONObject.optInt("localPadId");
            localImportFormData.d = paramJSONObject.optString("localPadId");
            localImportFormData.e = paramJSONObject.optString("doc_id");
            localImportFormData.f = paramJSONObject.optInt("doc_type");
            localImportFormData.g = paramJSONObject.optBoolean("isCache");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.bean.ImportFormData
 * JD-Core Version:    0.7.0.1
 */