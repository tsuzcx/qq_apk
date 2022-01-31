package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VoIPJsPlugin$JSONParser<T>
{
  public T parse(String paramString, Class<T> paramClass)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        QMLog.e("[mini] VoIPJsPlugin", "JSON is empty");
      }
      catch (JSONException paramClass)
      {
        try
        {
          paramString = JsonORM.a(localJSONObject, paramClass);
          return paramString;
        }
        catch (Exception paramString)
        {
          QMLog.e("[mini] VoIPJsPlugin", "JSONParser error! failed parse to " + paramClass, paramString);
          return null;
        }
        paramClass = paramClass;
        QMLog.e("[mini] VoIPJsPlugin", "JSONParser error! not a valid JSON " + paramString, paramClass);
        return null;
      }
    }
    return null;
  }
  
  public T parse(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if (paramJSONObject != null) {
      try
      {
        paramJSONObject = JsonORM.a(paramJSONObject, paramClass);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JsonORM error! failed parse to " + paramClass, paramJSONObject);
      }
    }
    for (;;)
    {
      return null;
      QMLog.e("[mini] VoIPJsPlugin", "JSON obj is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.JSONParser
 * JD-Core Version:    0.7.0.1
 */