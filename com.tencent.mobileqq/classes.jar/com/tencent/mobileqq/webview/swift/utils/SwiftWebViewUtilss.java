package com.tencent.mobileqq.webview.swift.utils;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class SwiftWebViewUtilss
{
  public static WebResourceResponse a()
  {
    WebResourceResponse localWebResourceResponse = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
    Map localMap = localWebResourceResponse.getResponseHeaders();
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("cache-control", "must-revalidate，no-store");
    localWebResourceResponse.setResponseHeaders((Map)localObject);
    return localWebResourceResponse;
  }
  
  public static String a(Intent paramIntent)
  {
    Object localObject = "";
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("url");
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        paramIntent = paramIntent.getStringExtra("key_params_qq");
        localObject = paramIntent;
        if (paramIntent == null) {
          localObject = "";
        }
      }
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(":");
      if (i > 0) {
        return paramString.substring(0, i).toLowerCase();
      }
    }
    return "";
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int m = Math.min(paramString1.length, paramString2.length);
    int k = 0;
    label42:
    if (k < m) {
      if (k >= paramString1.length) {
        break label142;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString1[k]);
        if (k >= paramString2.length) {
          break label137;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          j = Integer.parseInt(paramString2[k]);
          if (k == m - 1) {
            break label123;
          }
          if (j > i)
          {
            return true;
            localException1 = localException1;
            i = 0;
          }
        }
        catch (Exception localException2)
        {
          j = 0;
          continue;
        }
      }
      if (j < i) {
        break;
      }
      label123:
      do
      {
        k += 1;
        break label42;
        break;
        if (j >= i) {
          return true;
        }
      } while (j >= i);
      return false;
      label137:
      int j = 0;
      continue;
      label142:
      int i = 0;
    }
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    boolean bool1 = false;
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool2 = bool1;
    if (localObject != null)
    {
      if (!((AppRuntime)localObject).isLogin()) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    String str = paramJSONObject.optString("platformId", "");
    if ((!"0".equals(str)) && (!"2".equals(str)))
    {
      QLog.e("SwiftWebViewUtils", 1, "not support Android! " + paramJSONObject.toString());
      return false;
    }
    label123:
    int j;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(paramJSONObject.optString("business", ""))))
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (paramJSONObject.has("minVersion"))
        {
          paramString = paramJSONObject.optString("minVersion");
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString))
          {
            bool1 = bool2;
            if (!a(paramString, "8.5.5.5105")) {
              bool1 = false;
            }
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramJSONObject.has("maxVersion"))
        {
          paramString = paramJSONObject.optString("maxVersion");
          bool2 = bool1;
          if (!TextUtils.isEmpty(paramString))
          {
            bool2 = bool1;
            if (!a("8.5.5.5105", paramString)) {
              bool2 = false;
            }
          }
        }
      }
      bool1 = bool2;
      if (!bool2) {
        break label486;
      }
      paramString = ((AppRuntime)localObject).getAccount();
      int m = paramJSONObject.optInt("startIndex");
      int k = paramJSONObject.optInt("endIndex");
      if (m < k) {
        break label489;
      }
      j = paramString.length();
      if ((j < m) || (j < k)) {
        break label489;
      }
      m = j - m;
      k = j - k;
      if ((m >= j) || (k >= j) || (m > k)) {
        break label489;
      }
      long l1 = Long.parseLong(paramString.substring(m, k + 1));
      long l2 = paramJSONObject.optLong("min");
      long l3 = paramJSONObject.optLong("max");
      if ((l1 < l2) || (l1 > l3)) {
        break label489;
      }
    }
    label413:
    label486:
    label489:
    for (bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2)
      {
        localObject = paramJSONObject.optString("uinWhiteList");
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(";");
          j = localObject.length;
          bool1 = bool2;
          if (i < j) {
            if (paramString.equals(localObject[i])) {
              bool1 = true;
            }
          }
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        QLog.e("SwiftWebViewUtils", 1, "Config is not valid: " + paramJSONObject);
        return bool1;
        bool2 = false;
        break label123;
        i += 1;
        break label413;
      }
    }
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("url:");
    if ((paramString != null) && (paramString.length() > 512)) {
      localStringBuilder.append(paramString.substring(0, 512));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtilss
 * JD-Core Version:    0.7.0.1
 */