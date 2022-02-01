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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to bindFiled ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      QMLog.e("AppBrandUtil", localStringBuilder.toString(), localException);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to bindField ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramField);
      QMLog.e("AppBrandUtil", localStringBuilder.toString(), localException);
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
        if (bool) {
          try
          {
            localJSONObject.put("extendData", new JSONObject(paramString));
          }
          catch (JSONException paramString)
          {
            QMLog.e("AppBrandUtil", "dispatch extendData parse error", paramString);
          }
        } else {
          localJSONObject.put("extendData", paramString);
        }
      }
      localJSONObject.put("entryDataHash", getEntryDataHash(paramMiniAppInfo));
      return localJSONObject;
    }
    catch (Throwable paramString)
    {
      QMLog.e("AppBrandUtil", "getAppLaunchInfo error, ", paramString);
    }
    return localJSONObject;
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
    JSONObject localJSONObject = new JSONObject();
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
          if (bool) {
            try
            {
              localJSONObject.put("extendData", new JSONObject(paramString1));
            }
            catch (JSONException paramString1)
            {
              QMLog.e("AppBrandUtil", "dispatch extendData parse error", paramString1);
            }
          } else {
            localJSONObject.put("extendData", paramString1);
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.e("AppBrandUtil", "getPageShowInfo error, ", paramString1);
    }
    paramString1 = new StringBuilder();
    paramString1.append("getPageLoadInfo : ");
    paramString1.append(localJSONObject.toString());
    QMLog.i("AppBrandUtil", paramString1.toString());
    return localJSONObject;
  }
  
  public static JSONObject getQueryJson(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str1;
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("file:///");
        ((StringBuilder)localObject1).append(paramString);
        Iterator localIterator = Uri.parse(((StringBuilder)localObject1).toString()).getQueryParameterNames().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          localObject1 = "[\\\\?&]";
          if (str1.startsWith("$"))
          {
            localObject2 = str1.substring(1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[\\\\?&]");
            ((StringBuilder)localObject1).append("\\$");
            localObject1 = ((StringBuilder)localObject1).toString();
            String str2 = "";
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("=([^&#]*)");
            localObject2 = Pattern.compile(localStringBuilder.toString()).matcher(paramString);
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
      Object localObject2 = str1;
    }
  }
  
  public static Map<String, Object> getQueryMap(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("file:///");
    ((StringBuilder)localObject1).append(paramString);
    localObject1 = Uri.parse(((StringBuilder)localObject1).toString());
    for (;;)
    {
      String str1;
      try
      {
        Iterator localIterator = ((Uri)localObject1).getQueryParameterNames().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          localObject1 = "[\\\\?&]";
          if (str1.startsWith("$"))
          {
            localObject2 = str1.substring(1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[\\\\?&]");
            ((StringBuilder)localObject1).append("\\$");
            localObject1 = ((StringBuilder)localObject1).toString();
            String str2 = "";
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("=([^&#]*)");
            localObject2 = Pattern.compile(localStringBuilder.toString()).matcher(paramString);
            localObject1 = str2;
            if (((Matcher)localObject2).find()) {
              localObject1 = ((Matcher)localObject2).group(1);
            }
            localHashMap.put(str1, localObject1);
          }
        }
        else
        {
          return localHashMap;
        }
      }
      catch (Throwable paramString)
      {
        return localHashMap;
      }
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
        if ((i == 1037) || (i == 1038))
        {
          paramMiniAppInfo = paramMiniAppInfo.launchParam.navigateExtData;
          if (!TextUtils.isEmpty(paramMiniAppInfo))
          {
            boolean bool = isJson(paramMiniAppInfo);
            if (bool)
            {
              localJSONObject.put("extraData", new JSONObject(paramMiniAppInfo));
              return localJSONObject;
            }
            localJSONObject.put("extraData", paramMiniAppInfo);
            return localJSONObject;
          }
        }
      }
      catch (Throwable paramMiniAppInfo)
      {
        QMLog.e("getReferrerInfo", "error,", paramMiniAppInfo);
      }
      return localJSONObject;
    }
    return null;
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
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = paramString.indexOf("?");
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(0, i);
    }
    return str;
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
    catch (Throwable paramString)
    {
      label11:
      break label11;
    }
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("needUpdate=true oldVersionUpdateTime=");
        localStringBuilder.append(paramMiniAppInfo1.versionUpdateTime);
        localStringBuilder.append(" newVersionUpdateTime=");
        localStringBuilder.append(paramMiniAppInfo2.versionUpdateTime);
        localStringBuilder.append(" oldVersionId=");
        localStringBuilder.append(paramMiniAppInfo1.versionId);
        localStringBuilder.append(" newVersionId=");
        localStringBuilder.append(paramMiniAppInfo2.versionId);
        QMLog.i("AppBrandUtil", localStringBuilder.toString());
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needUpdate=false oldVersionUpdateTime=");
      localStringBuilder.append(paramMiniAppInfo1.versionUpdateTime);
      localStringBuilder.append(" newVersionUpdateTime=");
      localStringBuilder.append(paramMiniAppInfo2.versionUpdateTime);
      localStringBuilder.append(" oldVersionId=");
      localStringBuilder.append(paramMiniAppInfo1.versionId);
      localStringBuilder.append(" newVersionId=");
      localStringBuilder.append(paramMiniAppInfo2.versionId);
      QMLog.i("AppBrandUtil", localStringBuilder.toString());
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
        localObject2 = (Map)localObject2;
        parseToJsonMap((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
  }
  
  public static String parseToLocalPath(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file:///");
    ((StringBuilder)localObject).append(paramString);
    localObject = Uri.parse(((StringBuilder)localObject).toString()).getPath();
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (((String)localObject).startsWith("/")) {
        paramString = ((String)localObject).substring(1);
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