package com.tencent.mobileqq.webview;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebViewTitleStyleHelper
{
  private static WebViewTitleStyleHelper c;
  public Map<String, WebViewTitleStyle> a = new HashMap();
  public boolean b;
  
  private int a(String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("0x")) {
        str = paramString.substring(2);
      }
      paramString = str;
    }
    try
    {
      if (!str.startsWith("#"))
      {
        paramString = new StringBuilder();
        paramString.append("#");
        paramString.append(str);
        paramString = paramString.toString();
      }
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      label68:
      break label68;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("WebViewTitleStyleHelper", 4, "Illegal param _wvNb");
    }
    return -1;
  }
  
  public static WebViewTitleStyleHelper a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new WebViewTitleStyleHelper();
        }
      }
      finally {}
    }
    return c;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    try
    {
      this.a.clear();
      int j = MobileQQ.sProcessId;
      int i = 0;
      boolean bool;
      if (j == 1) {
        bool = true;
      } else {
        bool = false;
      }
      try
      {
        Object localObject = VasUpdateUtil.a(paramAppRuntime, "vipData_app_webviewNavStyle.json", bool, null);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebViewTitleStyleHelper", 2, "parseJson file not exists");
          }
          return;
        }
        this.b = true;
        localObject = ((JSONObject)localObject).optJSONArray("webViewStyleList");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          j = ((JSONArray)localObject).length();
          while (i < j)
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            if (a(paramAppRuntime, localJSONObject))
            {
              String str = localJSONObject.optString("domain", "");
              if (!TextUtils.isEmpty(str))
              {
                WebViewTitleStyle localWebViewTitleStyle = new WebViewTitleStyle();
                localWebViewTitleStyle.b = a(localJSONObject.optString("statusColor", ""));
                localWebViewTitleStyle.c = a(localJSONObject.optString("bgColor", ""));
                localWebViewTitleStyle.d = a(localJSONObject.optString("titleColor", ""));
                localWebViewTitleStyle.e = a(localJSONObject.optString("iconColor", ""));
                this.a.put(str, localWebViewTitleStyle);
              }
            }
            i += 1;
          }
        }
        paramAppRuntime = finally;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("WebViewTitleStyleHelper", 1, "parseJson exception e = ", paramAppRuntime);
        return;
      }
      throw paramAppRuntime;
    }
    finally {}
    for (;;) {}
  }
  
  public boolean a(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    Object localObject;
    if ((paramAppRuntime != null) && (paramJSONObject != null)) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isConfigValid config = ");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QLog.d("WebViewTitleStyleHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        i = paramJSONObject.optInt("platformId");
        if (i != 0)
        {
          bool1 = bool2;
          if (i != 2) {}
        }
        else
        {
          bool1 = paramJSONObject.has("minVersion");
          if (!bool1) {
            break label454;
          }
          localObject = paramJSONObject.getString("minVersion");
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (SwiftWebViewUtils.b((String)localObject, "8.8.17.5770"))) {
            break label454;
          }
          i = 0;
          int j = i;
          if (i != 0)
          {
            j = i;
            if (paramJSONObject.has("maxVersion"))
            {
              localObject = paramJSONObject.getString("maxVersion");
              j = i;
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                j = i;
                if (!SwiftWebViewUtils.b("8.8.17.5770", (String)localObject)) {
                  j = 0;
                }
              }
            }
          }
          bool1 = bool2;
          if (j != 0)
          {
            paramAppRuntime = paramAppRuntime.getAccount();
            i = paramJSONObject.optInt("startIndex");
            j = paramJSONObject.optInt("endIndex");
            if (i >= j)
            {
              int k = paramAppRuntime.length();
              if ((k >= i) && (k >= j))
              {
                long l1 = Long.parseLong(paramAppRuntime.substring(k - i, k - j + 1));
                long l2 = paramJSONObject.optLong("min");
                long l3 = paramJSONObject.optLong("max");
                bool1 = bool2;
                if (l1 >= l2)
                {
                  bool1 = bool2;
                  if (l1 <= l3) {
                    bool1 = true;
                  }
                }
              }
              else
              {
                paramAppRuntime = new StringBuilder();
                paramAppRuntime.append("parseJson, index config error, uin length=");
                paramAppRuntime.append(k);
                paramAppRuntime.append(", config=");
                paramAppRuntime.append(paramJSONObject.toString());
                QLog.e("WebViewTitleStyleHelper", 1, paramAppRuntime.toString());
                bool1 = bool2;
              }
            }
            else
            {
              paramAppRuntime = new StringBuilder();
              paramAppRuntime.append("parseJson, startIndex < endIndex, element=");
              paramAppRuntime.append(paramJSONObject);
              QLog.e("WebViewTitleStyleHelper", 1, paramAppRuntime.toString());
              bool1 = bool2;
            }
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("WebViewTitleStyleHelper", 1, "isConfigValid exception", paramAppRuntime);
        bool1 = bool2;
      }
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("isConfigValid valid = ");
        paramAppRuntime.append(bool1);
        QLog.d("WebViewTitleStyleHelper", 2, paramAppRuntime.toString());
      }
      return bool1;
      QLog.e("WebViewTitleStyleHelper", 1, "isConfigValid app = null || config = null");
      return false;
      label454:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewTitleStyleHelper
 * JD-Core Version:    0.7.0.1
 */