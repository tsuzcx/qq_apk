package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
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

public class AppBrandUtil
{
  public static final String STATUS_BAR_HEIGHT = "status_bar_height";
  public static final String TAG = "AppBrandUtil";
  public static ArrayList<String> sConfigFilter;
  
  public static long currTime()
  {
    return System.currentTimeMillis();
  }
  
  public static JSONObject getAppLaunchInfo(String paramString, LaunchParam paramLaunchParam, MiniAppInfo paramMiniAppInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    int i = 9999;
    String str1 = null;
    Object localObject1 = null;
    if (paramLaunchParam != null) {}
    for (;;)
    {
      try
      {
        i = paramLaunchParam.scene;
        str1 = paramLaunchParam.shareTicket;
        localObject3 = paramLaunchParam.fromMiniAppId;
        if (paramLaunchParam.entryModel != null) {
          localObject1 = paramLaunchParam.entryModel.getEntryHash();
        }
        String str2 = paramLaunchParam.privateExtraData;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = str2;
        localJSONObject.put("scene", getWikiScene(i));
        localJSONObject.put("path", getUrlWithoutParams(paramString));
        localJSONObject.put("query", getQueryJson(paramString));
        paramString = new JSONObject();
        paramString.put("shareTicket", str1);
        localJSONObject.put("shareInfo", paramString);
        paramString = new JSONObject();
        paramString.put("appId", localObject1);
        boolean bool;
        if ((i == 1037) || (i == 1038))
        {
          paramLaunchParam = paramLaunchParam.navigateExtData;
          if (!TextUtils.isEmpty(paramLaunchParam))
          {
            bool = JSONUtil.isJson(paramLaunchParam);
            if (bool) {
              paramString.put("extraData", new JSONObject(paramLaunchParam));
            } else {
              paramString.put("extraData", paramLaunchParam);
            }
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          bool = JSONUtil.isJson((String)localObject3);
          if (bool) {
            paramString.put("privateExtraData", new JSONObject((String)localObject3));
          } else {
            paramString.put("privateExtraData", localObject3);
          }
        }
        localJSONObject.put("referrerInfo", paramString);
        localJSONObject.put("entryDataHash", localObject2);
        if (paramMiniAppInfo != null)
        {
          paramString = paramMiniAppInfo.extendData;
          if (!TextUtils.isEmpty(paramString))
          {
            bool = JSONUtil.isJson(paramString);
            if (bool)
            {
              try
              {
                localJSONObject.put("extendData", new JSONObject(paramString));
                return localJSONObject;
              }
              catch (JSONException paramString)
              {
                if (!QLog.isColorLevel()) {
                  break label373;
                }
              }
              QLog.e("AppBrandUtil", 4, "dispatch extendData parse error", paramString);
              return localJSONObject;
            }
            else
            {
              localJSONObject.put("extendData", paramString);
              return localJSONObject;
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("AppBrandUtil", 1, "getAppLaunchInfo error, ", paramString);
      }
      label373:
      return localJSONObject;
      Object localObject2 = null;
      localObject1 = localObject2;
      Object localObject3 = localObject1;
    }
  }
  
  public static ArrayList<String> getConfigFilter()
  {
    if (sConfigFilter == null)
    {
      sConfigFilter = new ArrayList();
      Object localObject1 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppOpenUrlFilter", "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb|http://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb");
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
        QLog.e("AppBrandUtil", 1, "getQueryJson err:", paramString);
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
          if (!str1.startsWith("$")) {
            break label214;
          }
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
      catch (Throwable paramString)
      {
        QLog.e("AppBrandUtil", 1, "getQueryMap err:", paramString);
      }
      finally
      {
        return localHashMap;
      }
      label214:
      Object localObject2 = str1;
    }
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      i = paramContext.getDimensionPixelSize(i);
    } else {
      i = 0;
    }
    float f3 = paramContext.getDisplayMetrics().density;
    float f2 = f3 / paramContext.getDisplayMetrics().density;
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = 1.0F;
    }
    if (i <= 0) {
      return Math.round(f1 * 25.0F * f3);
    }
    return (int)Math.ceil(i * f1 + 0.5F);
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
    String str = QzoneConfig.getInstance().getConfig("qqminiapp", "configSceneMap", "{}");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getWikiScene ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("  scene:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("AppBrandUtil", 2, ((StringBuilder)localObject).toString());
    label137:
    try
    {
      localObject = new JSONObject(str).optString(String.valueOf(paramInt));
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label137;
      }
      int i = Integer.parseInt((String)localObject);
      return i;
    }
    catch (Exception localException)
    {
      label91:
      break label91;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getWikiScene fail, ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("  scene:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("AppBrandUtil", 2, ((StringBuilder)localObject).toString());
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
  
  public static String jsonObject2HttpParameter(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append('&');
        }
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.optString(str1);
        localStringBuilder.append(str1);
        localStringBuilder.append('=');
        localStringBuilder.append(str2);
      }
    }
    return URLUtil.c(localStringBuilder.toString());
  }
  
  public static boolean needUpdate(MiniAppInfo paramMiniAppInfo1, MiniAppInfo paramMiniAppInfo2)
  {
    if ((paramMiniAppInfo1 != null) && (paramMiniAppInfo2 != null))
    {
      StringBuilder localStringBuilder;
      if ((paramMiniAppInfo1.versionId != null) && (!paramMiniAppInfo1.versionId.equals(paramMiniAppInfo2.versionId)) && (paramMiniAppInfo1.versionUpdateTime > 0) && (paramMiniAppInfo2.versionUpdateTime > paramMiniAppInfo1.versionUpdateTime))
      {
        if (QLog.isColorLevel())
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
          QLog.i("AppBrandUtil", 2, localStringBuilder.toString());
        }
        return true;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("needUpdate=false oldVersionUpdateTime=");
        localStringBuilder.append(paramMiniAppInfo1.versionUpdateTime);
        localStringBuilder.append(" newVersionUpdateTime=");
        localStringBuilder.append(paramMiniAppInfo2.versionUpdateTime);
        localStringBuilder.append(" oldVersionId=");
        localStringBuilder.append(paramMiniAppInfo1.versionId);
        localStringBuilder.append(" newVersionId=");
        localStringBuilder.append(paramMiniAppInfo2.versionId);
        QLog.i("AppBrandUtil", 2, localStringBuilder.toString());
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil
 * JD-Core Version:    0.7.0.1
 */