package com.tencent.mobileqq.triton.internal.utils;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

public final class ApiUtil
{
  private static final String TAG = "ApiUtil";
  
  public static JSONObject wrapCallbackCancel(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return paramString;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = new JSONObject();
      paramJSONObject = localJSONObject;
      StringBuilder localStringBuilder = new StringBuilder();
      paramJSONObject = localJSONObject;
      localStringBuilder.append(paramString);
      paramJSONObject = localJSONObject;
      localStringBuilder.append(":fail cancel");
      paramJSONObject = localJSONObject;
      localJSONObject.put("errMsg", localStringBuilder.toString());
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      Log.e("ApiUtil", "wrapCallbackCancel: ", paramString);
    }
    return paramJSONObject;
  }
  
  public static JSONObject wrapCallbackFail(String paramString, JSONObject paramJSONObject)
  {
    return wrapCallbackFail(paramString, paramJSONObject, null);
  }
  
  public static JSONObject wrapCallbackFail(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramJSONObject;
      if (paramJSONObject == null) {
        paramString1 = new JSONObject();
      }
      return paramString1;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = new JSONObject();
      paramJSONObject = localJSONObject;
      StringBuilder localStringBuilder = new StringBuilder();
      paramJSONObject = localJSONObject;
      localStringBuilder.append(paramString1);
      paramJSONObject = localJSONObject;
      localStringBuilder.append(":fail");
      paramJSONObject = localJSONObject;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = "";
      }
      else
      {
        paramJSONObject = localJSONObject;
        paramString1 = new StringBuilder();
        paramJSONObject = localJSONObject;
        paramString1.append(" ");
        paramJSONObject = localJSONObject;
        paramString1.append(paramString2);
        paramJSONObject = localJSONObject;
        paramString1 = paramString1.toString();
      }
      paramJSONObject = localJSONObject;
      localStringBuilder.append(paramString1);
      paramJSONObject = localJSONObject;
      localJSONObject.put("errMsg", localStringBuilder.toString());
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      Log.e("ApiUtil", "wrapCallbackFail: ", paramString1);
    }
    return paramJSONObject;
  }
  
  public static JSONObject wrapCallbackOk(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return paramString;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = new JSONObject();
      paramJSONObject = localJSONObject;
      StringBuilder localStringBuilder = new StringBuilder();
      paramJSONObject = localJSONObject;
      localStringBuilder.append(paramString);
      paramJSONObject = localJSONObject;
      localStringBuilder.append(":ok");
      paramJSONObject = localJSONObject;
      localJSONObject.put("errMsg", localStringBuilder.toString());
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      Log.e("ApiUtil", "wrapCallbackOk: ", paramString);
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.utils.ApiUtil
 * JD-Core Version:    0.7.0.1
 */