package com.tencent.qqmini.sdk.core.utils;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
public class AppBrandUtil
{
  public static final String TAG = "AppBrandUtil";
  public static ArrayList<String> sConfigFilter;
  
  public static long currTime()
  {
    return System.currentTimeMillis();
  }
  
  public static JSONObject getAppLaunchInfo(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("path", getUrlWithoutParams(paramString));
        localJSONObject.put("query", getQueryJson(paramString));
        localJSONObject.put("scene", getWikiScene(getScene(paramMiniAppInfo)));
        localJSONObject.put("shareTicket", getShareTicket(paramMiniAppInfo));
        localJSONObject.put("referrerInfo", getReferrerInfo(paramMiniAppInfo));
        paramString = getExtendData(paramMiniAppInfo);
        if (!TextUtils.isEmpty(paramString))
        {
          boolean bool = JSONUtil.isJson(paramString);
          if (!bool) {}
        }
        else
        {
          try
          {
            localJSONObject.put("extendData", new JSONObject(paramString));
            localJSONObject.put("entryDataHash", getEntryDataHash(paramMiniAppInfo));
            return localJSONObject;
          }
          catch (JSONException paramString)
          {
            QMLog.e("AppBrandUtil", "dispatch extendData parse error", paramString);
            continue;
          }
        }
        localJSONObject.put("extendData", paramString);
      }
      catch (Throwable paramString)
      {
        QMLog.e("AppBrandUtil", "getAppLaunchInfo error, ", paramString);
        return localJSONObject;
      }
    }
  }
  
  public static ArrayList<String> getConfigFilter()
  {
    if (sConfigFilter == null)
    {
      sConfigFilter = new ArrayList();
      Object localObject1 = WnsConfig.getConfig("qqminiapp", "MiniAppOpenUrlFilter", "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb|http://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if (localObject2 != null) {
              sConfigFilter.add(localObject2.trim());
            }
            i += 1;
          }
        }
      }
    }
    return sConfigFilter;
  }
  
  private static String getEntryDataHash(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && (paramMiniAppInfo.launchParam.entryModel != null)) {
      return paramMiniAppInfo.launchParam.entryModel.getEntryHash();
    }
    return null;
  }
  
  private static String getExtendData(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null) {
      return paramMiniAppInfo.extendData;
    }
    return null;
  }
  
  public static JSONObject getPageLoadInfo(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo)
  {
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("path", getUrlWithoutParams(paramString1));
        localJSONObject.put("query", getQueryJson(paramString1));
        localJSONObject.put("openType", paramString2);
        if ("appLaunch".equals(paramString2))
        {
          localJSONObject.put("scene", getScene(paramMiniAppInfo));
          localJSONObject.put("shareTicket", getShareTicket(paramMiniAppInfo));
          localJSONObject.put("referrerInfo", getReferrerInfo(paramMiniAppInfo));
          paramString1 = getExtendData(paramMiniAppInfo);
          if (!TextUtils.isEmpty(paramString1))
          {
            boolean bool = JSONUtil.isJson(paramString1);
            if (!bool) {
              continue;
            }
          }
        }
      }
      catch (Throwable paramString1)
      {
        QMLog.e("AppBrandUtil", "getPageShowInfo error, ", paramString1);
        continue;
        localJSONObject.put("extendData", paramString1);
        continue;
      }
      try
      {
        localJSONObject.put("extendData", new JSONObject(paramString1));
        QMLog.i("AppBrandUtil", "getPageLoadInfo : " + localJSONObject.toString());
        return localJSONObject;
      }
      catch (JSONException paramString1)
      {
        QMLog.e("AppBrandUtil", "dispatch extendData parse error", paramString1);
      }
    }
  }
  
  public static JSONObject getQueryJson(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str1;
      try
      {
        Iterator localIterator = Uri.parse("file:///" + paramString).getQueryParameterNames().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if (str1.startsWith("$"))
          {
            localObject2 = str1.substring(1);
            localObject1 = "[\\\\?&]" + "\\$";
            String str2 = "";
            localObject2 = Pattern.compile((String)localObject1 + (String)localObject2 + "=([^&#]*)").matcher(paramString);
            localObject1 = str2;
            if (((Matcher)localObject2).find()) {
              localObject1 = ((Matcher)localObject2).group(1);
            }
            localJSONObject.put(str1, localObject1);
          }
        }
        else
        {
          return localJSONObject;
        }
      }
      catch (Throwable paramString)
      {
        QMLog.e("AppBrandUtil", "getQueryJson err:", paramString);
      }
      Object localObject1 = "[\\\\?&]";
      Object localObject2 = str1;
    }
  }
  
  public static Map<String, Object> getQueryMap(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = Uri.parse("file:///" + paramString);
    for (;;)
    {
      String str1;
      try
      {
        Iterator localIterator = ((Uri)localObject1).getQueryParameterNames().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if (!str1.startsWith("$")) {
            break label173;
          }
          localObject2 = str1.substring(1);
          localObject1 = "[\\\\?&]" + "\\$";
          String str2 = "";
          localObject2 = Pattern.compile((String)localObject1 + (String)localObject2 + "=([^&#]*)").matcher(paramString);
          localObject1 = str2;
          if (((Matcher)localObject2).find()) {
            localObject1 = ((Matcher)localObject2).group(1);
          }
          localHashMap.put(str1, localObject1);
        }
        localObject1 = "[\\\\?&]";
      }
      catch (Throwable paramString)
      {
        return localHashMap;
      }
      finally
      {
        return localHashMap;
      }
      label173:
      Object localObject2 = str1;
    }
  }
  
  private static JSONObject getReferrerInfo(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      JSONObject localJSONObject = new JSONObject();
      int i = paramMiniAppInfo.launchParam.scene;
      try
      {
        localJSONObject.put("appId", paramMiniAppInfo.launchParam.fromMiniAppId);
        String str;
        if ((i == 1037) || (i == 1038))
        {
          str = paramMiniAppInfo.launchParam.navigateExtData;
          if (!TextUtils.isEmpty(str))
          {
            if (!JSONUtil.isJson(str)) {
              break label136;
            }
            localJSONObject.put("extraData", new JSONObject(str));
          }
        }
        for (;;)
        {
          str = paramMiniAppInfo.launchParam.privateExtraData;
          paramMiniAppInfo = localJSONObject;
          if (TextUtils.isEmpty(str)) {
            return paramMiniAppInfo;
          }
          if (!JSONUtil.isJson(str)) {
            break;
          }
          localJSONObject.put("privateExtraData", new JSONObject(str));
          return localJSONObject;
          label136:
          localJSONObject.put("extraData", str);
        }
        localJSONObject.put("privateExtraData", str);
      }
      catch (Throwable paramMiniAppInfo)
      {
        QMLog.e("getReferrerInfo", "error,", paramMiniAppInfo);
        return localJSONObject;
      }
      return localJSONObject;
    }
    else
    {
      paramMiniAppInfo = null;
    }
    return paramMiniAppInfo;
  }
  
  private static int getScene(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {
      return paramMiniAppInfo.launchParam.scene;
    }
    return 9999;
  }
  
  private static String getShareTicket(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {
      return paramMiniAppInfo.launchParam.shareTicket;
    }
    return null;
  }
  
  public static String getUrlWithoutParams(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("?");
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public static int getWikiScene(int paramInt)
  {
    String str1 = WnsConfig.getConfig("qqminiapp", "configSceneMap", "{}");
    QMLog.d("AppBrandUtil", "getWikiScene " + str1 + "  scene:" + paramInt);
    try
    {
      String str2 = new JSONObject(str1).optString(String.valueOf(paramInt));
      int i = paramInt;
      if (!TextUtils.isEmpty(str2)) {
        i = Integer.parseInt(str2);
      }
      return i;
    }
    catch (Exception localException)
    {
      QMLog.e("AppBrandUtil", "getWikiScene fail, " + str1 + "  scene:" + paramInt);
    }
    return paramInt;
  }
  
  public static boolean isMainThread()
  {
    return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
  }
  
  public static boolean isOpenUrlFilter(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = getConfigFilter();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((str != null) && (paramString.toLowerCase().startsWith(str.toLowerCase()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean needUpdate(MiniAppInfo paramMiniAppInfo1, MiniAppInfo paramMiniAppInfo2)
  {
    if ((paramMiniAppInfo1 != null) && (paramMiniAppInfo2 != null))
    {
      if ((paramMiniAppInfo1.versionId != null) && (!paramMiniAppInfo1.versionId.equals(paramMiniAppInfo2.versionId)) && (paramMiniAppInfo1.versionUpdateTime > 0) && (paramMiniAppInfo2.versionUpdateTime > paramMiniAppInfo1.versionUpdateTime))
      {
        QMLog.i("AppBrandUtil", "needUpdate=true oldVersionUpdateTime=" + paramMiniAppInfo1.versionUpdateTime + " newVersionUpdateTime=" + paramMiniAppInfo2.versionUpdateTime + " oldVersionId=" + paramMiniAppInfo1.versionId + " newVersionId=" + paramMiniAppInfo2.versionId);
        return true;
      }
      QMLog.i("AppBrandUtil", "needUpdate=false oldVersionUpdateTime=" + paramMiniAppInfo1.versionUpdateTime + " newVersionUpdateTime=" + paramMiniAppInfo2.versionUpdateTime + " oldVersionId=" + paramMiniAppInfo1.versionId + " newVersionId=" + paramMiniAppInfo2.versionId);
    }
    return false;
  }
  
  public static void parseToJsonMap(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        parseToJsonMap((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
  }
  
  public static String parseToLocalPath(String paramString)
  {
    String str = Uri.parse("file:///" + paramString).getPath();
    paramString = str;
    if (str != null)
    {
      paramString = str;
      if (str.startsWith("/")) {
        paramString = str.substring(1);
      }
    }
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.AppBrandUtil
 * JD-Core Version:    0.7.0.1
 */