package com.tencent.mobileqq.mini.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiniAppLauncher
{
  private static final String TAG = "MiniAppLauncher";
  private static final String URL_PATTERN_OF_AD_SCHEME = "mqqapi://miniapp/adopen(/[0-9]+)?\\?";
  private static final String URL_PREFIX_HTTP_MINIAPP_AD_REAL_HEAD_SCHEME_V3 = "mqqapi://miniapp/adopen";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V1 = "mqqapi://microapp/open?";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V2 = "mqqapi://miniapp/open?";
  private static final String URL_PREFIX_MINIAPP_HTTP = "http://imgcache.qq.com/channel/mini_app/upgrade.html";
  private static final String URL_PREFIX_MINIAPP_HTTPS = "https://imgcache.qq.com/channel/mini_app/upgrade.html";
  private static final String URL_PREFIX_MINIAPP_URL = "https://m.q.qq.com/a/";
  private static final String URL_PREFIX_MINIAPP_URL_HTTP = "http://m.q.qq.com/a/";
  private static final String URL_PREFIX_WX_MINIAPP_HTTPS = "https://mp.weixin.qq.com/a/";
  static long mLastGameTime;
  
  private static void LaunchMiniAppBySchemeRequest(Context paramContext, String paramString, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppController.startAppByLink(paramContext, paramString, 2, paramLaunchParam, paramMiniAppLaunchListener);
  }
  
  public static boolean isFakeUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("https://m.q.qq.com/a/")) && (!paramString.startsWith("http://m.q.qq.com/a/"))) {
      return false;
    }
    return true;
  }
  
  private static boolean isMiniAppADSchemeV3(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://miniapp/adopen");
  }
  
  public static boolean isMiniAppDetailUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.matches("^(http|https)://m.q.qq.com/a/d/.*");
    }
    return false;
  }
  
  public static boolean isMiniAppScheme(String paramString)
  {
    return (isMiniAppSchemeV1(paramString)) || (isMiniAppSchemeV2(paramString)) || (isMiniAppADSchemeV3(paramString));
  }
  
  private static boolean isMiniAppSchemeV1(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://microapp/open?");
  }
  
  public static boolean isMiniAppSchemeV2(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://miniapp/open?");
  }
  
  public static boolean isMiniAppUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!isFakeUrl(paramString)) && (!isMiniAppScheme(paramString))) {
      return false;
    }
    return true;
  }
  
  private static void jumpToDetailPage(String paramString)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString, 0, new MiniAppLauncher.1(paramString));
  }
  
  private static void launchAppByFakeLink(Context paramContext, String paramString, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppController.startAppByLink(paramContext, paramString, 0, paramLaunchParam, paramMiniAppLaunchListener);
  }
  
  public static void launchAppByMiniCode(Context paramContext, String paramString, int paramInt, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = paramInt;
    localLaunchParam.fakeUrl = paramString;
    MiniAppController.startAppByLink(paramContext, paramString, 1, localLaunchParam, paramMiniAppLaunchListener);
  }
  
  private static void launchAppByMiniCode(Context paramContext, String paramString, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppController.startAppByLink(paramContext, paramString, 1, paramLaunchParam, paramMiniAppLaunchListener);
  }
  
  public static void launchMiniAppById(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, int paramInt)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = paramInt;
    localLaunchParam.envVersion = paramString4;
    localLaunchParam.entryPath = paramString2;
    localLaunchParam.navigateExtData = paramString3;
    localLaunchParam.reportData = paramMap;
    MiniAppController.startAppByAppid(paramContext, localLaunchParam.miniAppId, localLaunchParam.entryPath, localLaunchParam.envVersion, localLaunchParam, null);
  }
  
  public static void launchMiniAppById(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, int paramInt, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = paramInt;
    localLaunchParam.envVersion = paramString4;
    localLaunchParam.entryPath = paramString2;
    localLaunchParam.navigateExtData = paramString3;
    localLaunchParam.reportData = paramMap;
    MiniAppController.startAppByAppid(paramContext, localLaunchParam.miniAppId, localLaunchParam.entryPath, localLaunchParam.envVersion, localLaunchParam, paramMiniAppLaunchListener);
  }
  
  public static boolean launchMiniAppByScheme(Context paramContext, HashMap<String, String> paramHashMap, int paramInt, EntryModel paramEntryModel, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if ((paramHashMap == null) || (paramContext == null)) {
      return false;
    }
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = paramInt;
    if (paramEntryModel != null)
    {
      localLaunchParam.entryModel = paramEntryModel;
      localLaunchParam.reportData = paramEntryModel.reportData;
    }
    if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("url"))) {
      paramEntryModel = (String)paramHashMap.get("url");
    }
    for (;;)
    {
      String str1;
      try
      {
        localLaunchParam.fakeUrl = URLDecoder.decode(paramEntryModel, "UTF-8");
        str1 = (String)paramHashMap.get("appid");
        paramEntryModel = str1;
        if (TextUtils.isEmpty(str1)) {
          paramEntryModel = (String)paramHashMap.get("mini_appid");
        }
        if (verifyAppid_Scence_Fakeurl_Model(paramEntryModel, localLaunchParam.scene, localLaunchParam.fakeUrl)) {
          break label468;
        }
        QLog.e("MiniAppLauncher", 1, "Appid is： " + paramEntryModel + ",scence:" + localLaunchParam.scene + ",fakeurl:" + localLaunchParam.fakeUrl + " is forbidden!!!");
        AppBrandTask.runTaskOnUiThread(new MiniAppLauncher.3());
        return false;
      }
      catch (Exception paramEntryModel)
      {
        QLog.e("MiniAppLauncher", 1, "launchMiniAppByScheme, " + Log.getStackTraceString(paramEntryModel));
        continue;
      }
      if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("fakeUrl")))
      {
        localLaunchParam.fakeUrl = ((String)paramHashMap.get("fakeUrl"));
      }
      else if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("appid")))
      {
        localLaunchParam.miniAppId = ((String)paramHashMap.get("appid"));
        str1 = (String)paramHashMap.get("path");
        String str2 = (String)paramHashMap.get("extraData");
        String str3 = (String)paramHashMap.get("envVersion");
        paramEntryModel = localLaunchParam.miniAppId;
        try
        {
          if (!TextUtils.isEmpty(str1)) {
            localLaunchParam.entryPath = URLDecoder.decode(str1, "UTF-8");
          }
          if (!TextUtils.isEmpty(str2)) {
            localLaunchParam.extendData = URLDecoder.decode(str2, "UTF-8");
          }
          if (!TextUtils.isEmpty(str3)) {
            localLaunchParam.envVersion = URLDecoder.decode(str3, "UTF-8");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            QLog.e("MiniAppLauncher", 1, "launchMiniAppByScheme, " + Log.getStackTraceString(localUnsupportedEncodingException));
          }
        }
        if (!verifyAppid(paramEntryModel))
        {
          QLog.e("MiniAppLauncher", 1, "Appid is forbidden： " + paramEntryModel);
          AppBrandTask.runTaskOnUiThread(new MiniAppLauncher.2(paramEntryModel));
          return false;
        }
      }
    }
    label468:
    return openMiniApp(paramContext, localLaunchParam, paramMiniAppLaunchListener);
  }
  
  private static boolean openMiniApp(Context paramContext, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppLauncher", 2, "launchMiniApp openMiniApp :" + paramLaunchParam);
    }
    long l = System.currentTimeMillis();
    if (l - mLastGameTime <= 1000L) {
      return false;
    }
    mLastGameTime = l;
    paramLaunchParam.standardize();
    if ((paramLaunchParam.scene == 1047) || (paramLaunchParam.scene == 1048) || (paramLaunchParam.scene == 1049)) {
      i = 1;
    }
    if (i != 0) {
      launchAppByMiniCode(paramContext, paramLaunchParam.fakeUrl, paramLaunchParam, paramMiniAppLaunchListener);
    }
    for (;;)
    {
      return true;
      if (!TextUtils.isEmpty(paramLaunchParam.fakeUrl)) {
        launchAppByFakeLink(paramContext, paramLaunchParam.fakeUrl, paramLaunchParam, paramMiniAppLaunchListener);
      } else {
        MiniAppController.startAppByAppid(paramContext, paramLaunchParam.miniAppId, paramLaunchParam.entryPath, paramLaunchParam.envVersion, paramLaunchParam, paramMiniAppLaunchListener);
      }
    }
  }
  
  public static boolean startMiniApp(Context paramContext, String paramString, int paramInt, EntryModel paramEntryModel, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    int i = 2054;
    QLog.d("MiniAppLauncher", 1, "startMiniApp scene:" + paramInt + " url:" + paramString);
    if (BaseActivity.sTopActivity != null) {
      QLog.d("MiniAppLauncher", 1, "cur Activity:" + BaseActivity.sTopActivity.getActivityName() + "  class :" + BaseActivity.sTopActivity.getLocalClassName());
    }
    Object localObject;
    if (isFakeUrl(paramString))
    {
      if (isMiniAppDetailUrl(paramString))
      {
        jumpToDetailPage(paramString);
        return true;
      }
      localObject = new LaunchParam();
      ((LaunchParam)localObject).scene = paramInt;
      ((LaunchParam)localObject).fakeUrl = paramString;
      if (paramEntryModel != null)
      {
        ((LaunchParam)localObject).entryModel = paramEntryModel;
        ((LaunchParam)localObject).reportData = paramEntryModel.reportData;
      }
      launchAppByFakeLink(paramContext, paramString, (LaunchParam)localObject, paramMiniAppLaunchListener);
      return true;
    }
    if (isMiniAppSchemeV1(paramString))
    {
      localObject = new HashMap();
      try
      {
        String[] arrayOfString = paramString.split("\\?");
        if ((arrayOfString.length < 2) || (arrayOfString[0].length() == 0))
        {
          QLog.e("MiniAppLauncher", 1, "startMiniApp parameter error:" + paramString);
          return false;
        }
        paramString = paramString.substring(arrayOfString[0].length() + 1).split("&");
        if (paramString != null)
        {
          i = 0;
          while (i < paramString.length)
          {
            arrayOfString = paramString[i].split("=");
            if ((arrayOfString != null) && (arrayOfString.length == 2))
            {
              ((HashMap)localObject).put(arrayOfString[0], arrayOfString[1]);
              if (QLog.isColorLevel()) {
                QLog.d("MiniAppLauncher", 2, "startMiniApp open microapp key=" + arrayOfString[0] + ", value=" + arrayOfString[1]);
              }
            }
            i += 1;
          }
        }
        return launchMiniAppByScheme(paramContext, (HashMap)localObject, paramInt, paramEntryModel, paramMiniAppLaunchListener);
      }
      catch (Exception paramContext)
      {
        QLog.e("MiniAppLauncher", 1, "launchMiniApp SchemeV1 parameter error:", paramContext);
        return false;
      }
    }
    if (isMiniAppSchemeV2(paramString))
    {
      localObject = new LaunchParam();
      ((LaunchParam)localObject).scene = paramInt;
      ((LaunchParam)localObject).fakeUrl = paramString;
      if (paramEntryModel != null)
      {
        ((LaunchParam)localObject).entryModel = paramEntryModel;
        ((LaunchParam)localObject).reportData = paramEntryModel.reportData;
      }
      LaunchMiniAppBySchemeRequest(paramContext, paramString, (LaunchParam)localObject, paramMiniAppLaunchListener);
      return true;
    }
    if (isMiniAppADSchemeV3(paramString)) {}
    for (;;)
    {
      try
      {
        localObject = Pattern.compile("mqqapi://miniapp/adopen(/[0-9]+)?\\?").matcher(paramString);
        if (!((Matcher)localObject).find()) {
          break label638;
        }
        localObject = ((Matcher)localObject).group();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label638;
        }
        localObject = Pattern.compile("(\\d+)").matcher((CharSequence)localObject);
        if (!((Matcher)localObject).find()) {
          break label638;
        }
        paramInt = Integer.parseInt(((Matcher)localObject).group());
        if (paramInt > 0) {
          break label635;
        }
        paramInt = i;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppLauncher", 1, new Object[] { "launchMiniApp decode ad scheme scene error url:", paramString, localThrowable });
        paramInt = i;
        continue;
      }
      localObject = new LaunchParam();
      ((LaunchParam)localObject).scene = paramInt;
      ((LaunchParam)localObject).fakeUrl = paramString;
      if (paramEntryModel != null)
      {
        ((LaunchParam)localObject).entryModel = paramEntryModel;
        ((LaunchParam)localObject).reportData = paramEntryModel.reportData;
      }
      LaunchMiniAppBySchemeRequest(paramContext, paramString, (LaunchParam)localObject, paramMiniAppLaunchListener);
      return true;
      QLog.e("MiniAppLauncher", 1, "launchMiniApp parameter error: dc04239" + paramString);
      return false;
      label635:
      continue;
      label638:
      paramInt = 2054;
    }
  }
  
  public static boolean startMiniApp(Context paramContext, String paramString, int paramInt, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    return startMiniApp(paramContext, paramString, paramInt, null, paramMiniAppLaunchListener);
  }
  
  private static boolean verifyAppid(String paramString)
  {
    Object localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_scheme_appid_white_list", "1108291530,1108164955,1108961705,1109048181");
    try
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = localObject[i].equals(paramString);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("MiniAppLauncher", 1, "verify Appid failed: " + paramString);
    }
  }
  
  private static boolean verifyAppid_Scence_Fakeurl_Model(String paramString1, int paramInt, String paramString2)
  {
    String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_outsite_black_list", "");
    for (;;)
    {
      int i;
      try
      {
        String str2 = Build.BRAND;
        String[] arrayOfString1 = str1.split(",");
        int j = arrayOfString1.length;
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("\\|");
          if (arrayOfString2.length < 3) {
            break label218;
          }
          String str3 = arrayOfString2[0];
          String str4 = arrayOfString2[1];
          String str5 = arrayOfString2[2];
          str1 = null;
          if (arrayOfString2.length > 3) {
            str1 = arrayOfString2[3];
          }
          if ((TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)) || (!str3.equals(paramString1)) || (!str5.equals(str2)) || (Integer.valueOf(arrayOfString2[1]).intValue() != paramInt)) {
            break label218;
          }
          if (!TextUtils.isEmpty(str1))
          {
            if (TextUtils.isEmpty(str1)) {
              break label218;
            }
            boolean bool = str1.equals(paramString2);
            if (!bool) {
              break label218;
            }
          }
          return false;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("MiniAppLauncher", 1, "verify appidWhiteList failed: " + paramString1);
      }
      return true;
      label218:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher
 * JD-Core Version:    0.7.0.1
 */