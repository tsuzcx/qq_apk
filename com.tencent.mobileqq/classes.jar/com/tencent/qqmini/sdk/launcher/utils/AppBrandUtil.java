package com.tencent.qqmini.sdk.launcher.utils;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.annotation.BindClass;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandUtil
{
  public static final String TAG = "AppBrandUtil";
  
  public static Object bindField(Object paramObject, String paramString)
  {
    try
    {
      Object localObject = bindField(paramObject, paramObject.getClass().getDeclaredField(paramString));
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.e("AppBrandUtil", "Failed to bindFiled " + paramObject + " " + paramString, localException);
    }
    return null;
  }
  
  public static Object bindField(Object paramObject, Field paramField)
  {
    try
    {
      paramField.setAccessible(true);
      Object localObject = paramField.get(paramObject);
      if (localObject != null) {
        return localObject;
      }
      if (paramField.isAnnotationPresent(BindClass.class))
      {
        localObject = ((BindClass)paramField.getAnnotation(BindClass.class)).className();
        localObject = MiniAppDexLoader.g().create((String)localObject);
        paramField.set(paramObject, localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("AppBrandUtil", "Failed to bindField " + paramObject + " " + paramField, localException);
    }
    return null;
  }
  
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
          boolean bool = isJson(paramString);
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
            boolean bool = isJson(paramString1);
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
            break label177;
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
      label177:
      Object localObject2 = str1;
    }
  }
  
  private static JSONObject getReferrerInfo(MiniAppInfo paramMiniAppInfo)
  {
    JSONObject localJSONObject1;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      JSONObject localJSONObject2 = new JSONObject();
      int i = paramMiniAppInfo.launchParam.scene;
      try
      {
        localJSONObject2.put("appId", paramMiniAppInfo.launchParam.fromMiniAppId);
        if (i != 1037)
        {
          localJSONObject1 = localJSONObject2;
          if (i != 1038) {
            return localJSONObject1;
          }
        }
        paramMiniAppInfo = paramMiniAppInfo.launchParam.navigateExtData;
        localJSONObject1 = localJSONObject2;
        if (TextUtils.isEmpty(paramMiniAppInfo)) {
          return localJSONObject1;
        }
        if (isJson(paramMiniAppInfo))
        {
          localJSONObject2.put("extraData", new JSONObject(paramMiniAppInfo));
          return localJSONObject2;
        }
        localJSONObject2.put("extraData", paramMiniAppInfo);
        return localJSONObject2;
      }
      catch (Throwable paramMiniAppInfo)
      {
        QMLog.e("getReferrerInfo", "error,", paramMiniAppInfo);
        return localJSONObject2;
      }
    }
    else
    {
      localJSONObject1 = null;
    }
    return localJSONObject1;
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
    return paramInt;
  }
  
  public static boolean isJson(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static boolean isMainThread()
  {
    return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
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
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil
 * JD-Core Version:    0.7.0.1
 */