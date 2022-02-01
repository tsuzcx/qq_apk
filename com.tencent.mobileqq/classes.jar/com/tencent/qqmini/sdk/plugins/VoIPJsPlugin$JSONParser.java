package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.annotation.JsonORM;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VoIPJsPlugin$JSONParser<T>
{
  public T parse(String paramString, Class<T> paramClass)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new JSONObject(paramString);
        try
        {
          paramString = JsonORM.parseFrom((JSONObject)localObject, paramClass);
          return paramString;
        }
        catch (Exception paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("JSONParser error! failed parse to ");
          ((StringBuilder)localObject).append(paramClass);
          QMLog.e("[mini] VoIPJsPlugin", ((StringBuilder)localObject).toString(), paramString);
          return null;
        }
        QMLog.e("[mini] VoIPJsPlugin", "JSON is empty");
      }
      catch (JSONException paramClass)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("JSONParser error! not a valid JSON ");
        ((StringBuilder)localObject).append(paramString);
        QMLog.e("[mini] VoIPJsPlugin", ((StringBuilder)localObject).toString(), paramClass);
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("JsonORM error! failed parse to ");
        localStringBuilder.append(paramClass);
        QMLog.e("[mini] VoIPJsPlugin", localStringBuilder.toString(), paramJSONObject);
      }
    } else {
      QMLog.e("[mini] VoIPJsPlugin", "JSON obj is empty");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.JSONParser
 * JD-Core Version:    0.7.0.1
 */