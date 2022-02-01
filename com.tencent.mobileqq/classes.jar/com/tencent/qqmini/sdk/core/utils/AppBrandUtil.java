package com.tencent.qqmini.sdk.core.utils;

import android.net.Uri;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
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
      paramString = getForwardMaterialsInfo(paramMiniAppInfo);
      if ((paramString != null) && (paramString.length() > 0))
      {
        localJSONObject.put("forwardMaterials", paramString);
        return localJSONObject;
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("AppBrandUtil", "getAppLaunchInfo error, ", paramString);
    }
    return localJSONObject;
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
  
  private static JSONArray getForwardMaterialsInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    Object localObject1 = paramMiniAppInfo.launchParam.fileMaterialInfoList;
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return null;
      }
      paramMiniAppInfo = MiniAppFileManager.getMiniAppFileManager(paramMiniAppInfo.appId);
      if (paramMiniAppInfo == null)
      {
        QMLog.e("AppBrandUtil", "getForwardMaterialsInfo: fileManager not ready");
        return null;
      }
      Object localObject2 = ((List)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileMaterialInfo)((Iterator)localObject2).next();
        if (TextUtils.isEmpty(((FileMaterialInfo)localObject3).getTmpPath())) {
          ((FileMaterialInfo)localObject3).setTmpPath(paramMiniAppInfo.getWxFilePath(((FileMaterialInfo)localObject3).getPath()));
        }
      }
      paramMiniAppInfo = new JSONArray();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileMaterialInfo)((Iterator)localObject1).next();
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("type", ((FileMaterialInfo)localObject2).getMimeType());
        ((JSONObject)localObject3).put("name", ((FileMaterialInfo)localObject2).getName());
        ((JSONObject)localObject3).put("path", ((FileMaterialInfo)localObject2).getTmpPath());
        ((JSONObject)localObject3).put("size", ((FileMaterialInfo)localObject2).getSize());
        paramMiniAppInfo.put(localObject3);
      }
      return paramMiniAppInfo;
    }
    return null;
  }
  
  @Deprecated
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
          boolean bool = JSONUtil.isJson(paramString1);
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
        boolean bool;
        if ((i == 1037) || (i == 1038))
        {
          String str = paramMiniAppInfo.launchParam.navigateExtData;
          if (!TextUtils.isEmpty(str))
          {
            bool = JSONUtil.isJson(str);
            if (bool) {
              localJSONObject.put("extraData", new JSONObject(str));
            } else {
              localJSONObject.put("extraData", str);
            }
          }
        }
        paramMiniAppInfo = paramMiniAppInfo.launchParam.privateExtraData;
        if (!TextUtils.isEmpty(paramMiniAppInfo))
        {
          bool = JSONUtil.isJson(paramMiniAppInfo);
          if (bool)
          {
            localJSONObject.put("privateExtraData", new JSONObject(paramMiniAppInfo));
            return localJSONObject;
          }
          localJSONObject.put("privateExtraData", paramMiniAppInfo);
          return localJSONObject;
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
    String str = WnsConfig.getConfig("qqminiapp", "configSceneMap", "{}");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getWikiScene ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("  scene:");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.d("AppBrandUtil", ((StringBuilder)localObject).toString());
    label132:
    try
    {
      localObject = new JSONObject(str).optString(String.valueOf(paramInt));
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label132;
      }
      int i = Integer.parseInt((String)localObject);
      return i;
    }
    catch (Exception localException)
    {
      label87:
      break label87;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getWikiScene fail, ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("  scene:");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.e("AppBrandUtil", ((StringBuilder)localObject).toString());
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
  
  private static void replaceFileMaterialInfo(@NonNull MiniAppInfo paramMiniAppInfo)
  {
    Object localObject = paramMiniAppInfo.apkgInfo;
    if (!(localObject instanceof ApkgInfo)) {
      return;
    }
    localObject = (ApkgInfo)localObject;
    JSONObject localJSONObject = ((ApkgInfo)localObject).getAppLaunchInfo();
    if (localJSONObject == null) {
      return;
    }
    try
    {
      paramMiniAppInfo = getForwardMaterialsInfo(paramMiniAppInfo);
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.length() > 0))
      {
        localJSONObject.put("forwardMaterials", paramMiniAppInfo);
        ((ApkgInfo)localObject).updateAppLaunchInfo(localJSONObject);
        return;
      }
    }
    catch (JSONException paramMiniAppInfo)
    {
      QMLog.e("AppBrandUtil", "updateFileMaterialInfo: error:", paramMiniAppInfo);
    }
  }
  
  public static void updateAppLaunchInfoForApkgInfo(@NonNull MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo.launchParam.fileMaterialInfoList != null) && (!paramMiniAppInfo.launchParam.fileMaterialInfoList.isEmpty())) {
      replaceFileMaterialInfo(paramMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.AppBrandUtil
 * JD-Core Version:    0.7.0.1
 */