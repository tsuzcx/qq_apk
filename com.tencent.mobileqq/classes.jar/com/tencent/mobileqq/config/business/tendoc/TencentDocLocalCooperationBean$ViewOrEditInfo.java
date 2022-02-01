package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocLocalCooperationBean$ViewOrEditInfo
{
  public String a;
  public boolean a;
  public String[] a;
  public String b;
  public boolean b;
  public String c;
  
  public TencentDocLocalCooperationBean$ViewOrEditInfo(JSONObject paramJSONObject)
  {
    try
    {
      String str = paramJSONObject.getString("extension");
      if (str != null) {
        this.jdField_a_of_type_ArrayOfJavaLangString = str.split("\\|");
      }
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("text");
      this.b = paramJSONObject.getString("tShow");
      this.c = paramJSONObject.getString("tPress");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
    }
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramString != null))
    {
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        if (i >= arrayOfString.length) {
          break;
        }
        if (paramString.equals(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationBean.ViewOrEditInfo
 * JD-Core Version:    0.7.0.1
 */