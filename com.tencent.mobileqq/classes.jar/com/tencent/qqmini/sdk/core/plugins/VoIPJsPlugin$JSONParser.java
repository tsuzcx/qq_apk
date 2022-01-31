package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdnw;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM;
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
        bdnw.d("[mini] VoIPJsPlugin", "JSON is empty");
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
          bdnw.d("[mini] VoIPJsPlugin", "JSONParser error! failed parse to " + paramClass, paramString);
          return null;
        }
        paramClass = paramClass;
        bdnw.d("[mini] VoIPJsPlugin", "JSONParser error! not a valid JSON " + paramString, paramClass);
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
        bdnw.d("[mini] VoIPJsPlugin", "JsonORM error! failed parse to " + paramClass, paramJSONObject);
      }
    }
    for (;;)
    {
      return null;
      bdnw.d("[mini] VoIPJsPlugin", "JSON obj is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.JSONParser
 * JD-Core Version:    0.7.0.1
 */