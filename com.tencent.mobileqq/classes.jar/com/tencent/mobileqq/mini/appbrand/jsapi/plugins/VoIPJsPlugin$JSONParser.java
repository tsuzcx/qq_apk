package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.sdk.JsonORM;
import com.tencent.qphone.base.util.QLog;
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
        QLog.e("[mini] VoIPJsPlugin", 1, "JSON is empty");
      }
      catch (JSONException paramClass)
      {
        try
        {
          paramString = JsonORM.parseFrom(localJSONObject, paramClass);
          return paramString;
        }
        catch (Exception paramString)
        {
          QLog.e("[mini] VoIPJsPlugin", 1, "JSONParser error! failed parse to " + paramClass, paramString);
          return null;
        }
        paramClass = paramClass;
        QLog.e("[mini] VoIPJsPlugin", 1, "JSONParser error! not a valid JSON " + paramString, paramClass);
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
        paramJSONObject = JsonORM.parseFrom(paramJSONObject, paramClass);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("[mini] VoIPJsPlugin", 1, "JsonORM error! failed parse to " + paramClass, paramJSONObject);
      }
    }
    for (;;)
    {
      return null;
      QLog.e("[mini] VoIPJsPlugin", 1, "JSON obj is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPJsPlugin.JSONParser
 * JD-Core Version:    0.7.0.1
 */