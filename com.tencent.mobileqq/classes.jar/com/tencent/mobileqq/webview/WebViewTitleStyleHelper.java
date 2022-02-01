package com.tencent.mobileqq.webview;

import android.graphics.Color;
import android.text.TextUtils;
import bges;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebViewTitleStyleHelper
{
  public static final String TAG = "WebViewTitleStyleHelper";
  private static WebViewTitleStyleHelper sInstance;
  public boolean hasParseJson;
  public Map<String, WebViewTitleStyle> styleMap = new HashMap();
  
  private int getColorFromStr(String paramString)
  {
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("0x")) {
        break label86;
      }
      paramString = paramString.substring(2);
    }
    label86:
    for (;;)
    {
      String str = paramString;
      try
      {
        if (!paramString.startsWith("#")) {
          str = "#" + paramString;
        }
        i = Color.parseColor(str);
      }
      catch (NumberFormatException paramString)
      {
        do
        {
          i = j;
        } while (!QLog.isDevelopLevel());
        QLog.d("WebViewTitleStyleHelper", 4, "Illegal param _wvNb");
        return -1;
      }
      return i;
    }
  }
  
  public static WebViewTitleStyleHelper getsInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new WebViewTitleStyleHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  public boolean isConfigValid(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    bool3 = false;
    bool1 = false;
    boolean bool2 = true;
    if ((paramAppRuntime == null) || (paramJSONObject == null))
    {
      QLog.e("WebViewTitleStyleHelper", 1, "isConfigValid app = null || config = null");
      bool2 = bool1;
      return bool2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTitleStyleHelper", 2, "isConfigValid config = " + paramJSONObject.toString());
    }
    try
    {
      i = paramJSONObject.optInt("platformId");
      if (i != 0)
      {
        bool1 = bool3;
        if (i != 2) {
          break label287;
        }
      }
      if (!paramJSONObject.has("minVersion")) {
        break label416;
      }
      str = paramJSONObject.getString("minVersion");
      if ((TextUtils.isEmpty(str)) || (bges.a(str, "8.4.8.4810"))) {
        break label416;
      }
      i = 0;
    }
    catch (Exception paramAppRuntime)
    {
      for (;;)
      {
        String str;
        int j;
        int k;
        long l1;
        long l2;
        long l3;
        label287:
        label326:
        label367:
        QLog.e("WebViewTitleStyleHelper", 1, "isConfigValid exception", paramAppRuntime);
        bool1 = bool3;
        continue;
        int i = 1;
        continue;
        bool1 = false;
      }
    }
    j = i;
    if (i != 0)
    {
      j = i;
      if (paramJSONObject.has("maxVersion"))
      {
        str = paramJSONObject.getString("maxVersion");
        j = i;
        if (!TextUtils.isEmpty(str))
        {
          j = i;
          if (!bges.a("8.4.8.4810", str)) {
            j = 0;
          }
        }
      }
    }
    bool1 = bool3;
    if (j != 0)
    {
      paramAppRuntime = paramAppRuntime.getAccount();
      i = paramJSONObject.optInt("startIndex");
      j = paramJSONObject.optInt("endIndex");
      if (i < j) {
        break label367;
      }
      k = paramAppRuntime.length();
      if ((k < i) || (k < j)) {
        break label326;
      }
      l1 = Long.parseLong(paramAppRuntime.substring(k - i, k - j + 1));
      l2 = paramJSONObject.optLong("min");
      l3 = paramJSONObject.optLong("max");
      if ((l1 < l2) || (l1 > l3)) {
        break label421;
      }
    }
    for (bool1 = bool2;; bool1 = bool3)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebViewTitleStyleHelper", 2, "isConfigValid valid = " + bool1);
      return bool1;
      QLog.e("WebViewTitleStyleHelper", 1, "parseJson, index config error, uin length=" + k + ", config=" + paramJSONObject.toString());
      break label421;
      QLog.e("WebViewTitleStyleHelper", 1, "parseJson, startIndex < endIndex, element=" + paramJSONObject);
    }
  }
  
  public void parseJson(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    for (;;)
    {
      return;
      try
      {
        this.styleMap.clear();
        boolean bool = paramAppRuntime instanceof QQAppInterface;
        try
        {
          localObject = VasQuickUpdateManager.getJSONFromLocal(paramAppRuntime, "vipData_app_webviewNavStyle.json", bool, null);
          if (localObject != null) {
            break label75;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("WebViewTitleStyleHelper", 2, "parseJson file not exists");
        }
        catch (Exception paramAppRuntime)
        {
          QLog.e("WebViewTitleStyleHelper", 1, "parseJson exception e = ", paramAppRuntime);
        }
        continue;
      }
      finally {}
      label75:
      this.hasParseJson = true;
      Object localObject = ((JSONObject)localObject).optJSONArray("webViewStyleList");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int j = ((JSONArray)localObject).length();
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          if (isConfigValid(paramAppRuntime, localJSONObject))
          {
            String str = localJSONObject.optString("domain", "");
            if (!TextUtils.isEmpty(str))
            {
              WebViewTitleStyle localWebViewTitleStyle = new WebViewTitleStyle();
              localWebViewTitleStyle.statusBarColor = getColorFromStr(localJSONObject.optString("statusColor", ""));
              localWebViewTitleStyle.titleBgColor = getColorFromStr(localJSONObject.optString("bgColor", ""));
              localWebViewTitleStyle.titleColor = getColorFromStr(localJSONObject.optString("titleColor", ""));
              localWebViewTitleStyle.leftAndRightBtnColor = getColorFromStr(localJSONObject.optString("iconColor", ""));
              this.styleMap.put(str, localWebViewTitleStyle);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewTitleStyleHelper
 * JD-Core Version:    0.7.0.1
 */