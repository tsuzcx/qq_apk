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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("manager parse, showEntrance: ");
        localStringBuilder.append(paramString);
        QLog.e("LocaleConfProcessor", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.LocaleConfProcessor.LocaleConfBean
 * JD-Core Version:    0.7.0.1
 */