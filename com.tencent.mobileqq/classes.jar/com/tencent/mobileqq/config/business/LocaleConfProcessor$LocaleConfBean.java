package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class LocaleConfProcessor$LocaleConfBean
{
  public String a = "";
  
  public LocaleConfProcessor$LocaleConfBean() {}
  
  public LocaleConfProcessor$LocaleConfBean(String paramString)
  {
    this.a = paramString;
  }
  
  public static LocaleConfBean a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("ShowLocaleEntrance");
      if (QLog.isColorLevel()) {
        QLog.e("LocaleConfProcessor", 2, "manager parse, showEntrance: " + paramString);
      }
      paramString = new LocaleConfBean(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.LocaleConfProcessor.LocaleConfBean
 * JD-Core Version:    0.7.0.1
 */