package com.tencent.mobileqq.minigame.api;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class ApiUtil
{
  private static final String TAG = "[minigame] ApiUtil";
  
  public static JSONObject getSystemInfo(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("brand", Build.BRAND);
    localJSONObject.put("model", Build.MODEL);
    if (paramContext != null)
    {
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      int i = (int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density);
      int j = (int)(localDisplayMetrics.heightPixels / localDisplayMetrics.density);
      localJSONObject.put("pixelRatio", localDisplayMetrics.density);
      localJSONObject.put("devicePixelRatio", localDisplayMetrics.density);
      localJSONObject.put("screenWidth", i);
      localJSONObject.put("screenHeight", j);
      localJSONObject.put("windowWidth", i);
      localJSONObject.put("windowHeight", j);
    }
    localJSONObject.put("statusBarHeight", DisplayUtil.getStatusBarHeight(paramContext));
    localJSONObject.put("language", "zh_CN");
    localJSONObject.put("version", "7.9.7");
    localJSONObject.put("system", "Android " + Build.VERSION.RELEASE);
    localJSONObject.put("platform", "android");
    localJSONObject.put("fontSizeSetting", 16);
    localJSONObject.put("SDKVersion", paramString);
    localJSONObject.put("AppPlatform", "qq");
    localJSONObject.put("benchmarkLevel", 1);
    return localJSONObject;
  }
  
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
    if (paramJSONObject == null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        label63:
        for (;;) {}
      }
      catch (Exception paramString)
      {
        try
        {
          paramJSONObject.put("errMsg", paramString + ":fail cancel");
          for (;;)
          {
            return paramJSONObject;
            paramString = paramString;
          }
        }
        catch (Exception paramString)
        {
          break label63;
        }
      }
    }
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
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append(":fail");
        paramJSONObject = localJSONObject;
        if (!TextUtils.isEmpty(paramString2)) {
          continue;
        }
        paramString1 = "";
        paramJSONObject = localJSONObject;
        localJSONObject.put("errMsg", paramString1);
        paramJSONObject = localJSONObject;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      paramString1 = paramJSONObject;
      if (paramJSONObject == null) {
        break;
      }
      QLog.e("[minigame] ApiUtil", 1, "[wrapCallbackFail] " + paramJSONObject.toString());
      return paramJSONObject;
      paramJSONObject = localJSONObject;
      paramString1 = " " + paramString2;
    }
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
    if (paramJSONObject == null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        label63:
        for (;;) {}
      }
      catch (Exception paramString)
      {
        try
        {
          paramJSONObject.put("errMsg", paramString + ":ok");
          for (;;)
          {
            return paramJSONObject;
            paramString = paramString;
          }
        }
        catch (Exception paramString)
        {
          break label63;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.ApiUtil
 * JD-Core Version:    0.7.0.1
 */