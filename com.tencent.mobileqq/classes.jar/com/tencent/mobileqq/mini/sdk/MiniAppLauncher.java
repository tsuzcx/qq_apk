package com.tencent.mobileqq.mini.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo;
import common.config.service.QzoneConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiniAppLauncher
{
  private static final String CONFIG_SPLIT = ",";
  private static final String TAG = "MiniAppLauncher";
  private static final String URL_PATTERN_OF_AD_SCHEME = "mqqapi://miniapp/adopen(/[0-9]+)?\\?";
  private static final String URL_PREFIX_HTTP_MINIAPP_AD_REAL_HEAD_SCHEME_V3 = "mqqapi://miniapp/adopen";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V1 = "mqqapi://microapp/open?";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_SCHEME_V2 = "mqqapi://miniapp/open?";
  private static final String URL_PREFIX_MINIAPP_HTTPS = "https://imgcache.qq.com/channel/mini_app/upgrade.html";
  private static final String URL_PREFIX_MINIAPP_URL = "https://m.q.qq.com/a/";
  private static final String URL_PREFIX_MINIAPP_URL_HTTP = "https://m.q.qq.com/a/";
  private static final String URL_PREFIX_WX_MINIAPP_HTTPS = "https://mp.weixin.qq.com/a/";
  private static ArrayList<String> arkSceneWhiteList;
  private static String mArkSceneWhiteListConfig;
  static long mLastGameTime;
  
  private static void LaunchMiniAppBySchemeRequest(Context paramContext, String paramString, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppController.startAppByLink(paramContext, paramString, 2, paramLaunchParam, paramMiniAppLaunchListener);
  }
  
  public static boolean decodeScheme(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramString.split("\\?");
        if ((arrayOfString.length >= 2) && (arrayOfString[0].length() != 0))
        {
          paramString = paramString.substring(arrayOfString[0].length() + 1).split("&");
          if (paramString == null) {
            break;
          }
          i = 0;
          if (i >= paramString.length) {
            break;
          }
          arrayOfString = paramString[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length == 2))
          {
            paramHashMap.put(arrayOfString[0], arrayOfString[1]);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("startMiniApp open microapp key=");
              localStringBuilder.append(arrayOfString[0]);
              localStringBuilder.append(", value=");
              localStringBuilder.append(arrayOfString[1]);
              QLog.d("MiniAppLauncher", 2, localStringBuilder.toString());
            }
          }
        }
        else
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("startMiniApp parameter error:");
          paramHashMap.append(paramString);
          QLog.e("MiniAppLauncher", 1, paramHashMap.toString());
          return false;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("MiniAppLauncher", 1, "launchMiniApp SchemeV1 parameter error:", paramString);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isFakeUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("https://m.q.qq.com/a/")) || (paramString.startsWith("https://m.q.qq.com/a/"))) {
      bool1 = true;
    }
    return bool1;
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
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((isFakeUrl(paramString)) || (isMiniAppScheme(paramString))) {
      bool1 = true;
    }
    return bool1;
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
  
  public static void launchMiniAppById(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = paramInt;
    localLaunchParam.envVersion = paramString4;
    localLaunchParam.entryPath = paramString2;
    localLaunchParam.navigateExtData = paramString3;
    localLaunchParam.reportData = paramString5;
    MiniAppController.startAppByAppid(paramContext, localLaunchParam.miniAppId, localLaunchParam.entryPath, localLaunchParam.envVersion, localLaunchParam, null);
  }
  
  public static void launchMiniAppById(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = paramInt;
    localLaunchParam.envVersion = paramString4;
    localLaunchParam.entryPath = paramString2;
    localLaunchParam.navigateExtData = paramString3;
    localLaunchParam.reportData = paramString5;
    MiniAppController.startAppByAppid(paramContext, localLaunchParam.miniAppId, localLaunchParam.entryPath, localLaunchParam.envVersion, localLaunchParam, paramMiniAppLaunchListener);
  }
  
  public static void launchMiniAppByIdWithFile(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, List<FileMaterialInfo> paramList)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.scene = paramInt;
    localLaunchParam.envVersion = paramString3;
    localLaunchParam.entryPath = paramString2;
    localLaunchParam.fileMaterialInfoList = paramList;
    MiniAppController.startAppByAppid(paramContext, localLaunchParam.miniAppId, localLaunchParam.entryPath, localLaunchParam.envVersion, localLaunchParam, null);
  }
  
  public static boolean launchMiniAppByScheme(Context paramContext, HashMap<String, String> paramHashMap, int paramInt, EntryModel paramEntryModel, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (paramHashMap != null)
    {
      if (paramContext == null) {
        return false;
      }
      LaunchParam localLaunchParam = new LaunchParam();
      localLaunchParam.scene = paramInt;
      if (paramEntryModel != null)
      {
        localLaunchParam.entryModel = paramEntryModel;
        localLaunchParam.reportData = paramEntryModel.reportData;
      }
      Object localObject1;
      if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("url")))
      {
        paramEntryModel = (String)paramHashMap.get("url");
        try
        {
          localLaunchParam.fakeUrl = URLDecoder.decode(paramEntryModel, "UTF-8");
        }
        catch (Exception paramEntryModel)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("launchMiniAppByScheme, ");
          ((StringBuilder)localObject1).append(Log.getStackTraceString(paramEntryModel));
          QLog.e("MiniAppLauncher", 1, ((StringBuilder)localObject1).toString());
        }
      }
      else if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("fakeUrl")))
      {
        localLaunchParam.fakeUrl = ((String)paramHashMap.get("fakeUrl"));
      }
      else if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("appid")))
      {
        localLaunchParam.miniAppId = ((String)paramHashMap.get("appid"));
        localObject1 = (String)paramHashMap.get("path");
        Object localObject2 = (String)paramHashMap.get("extraData");
        String str2 = (String)paramHashMap.get("envVersion");
        paramEntryModel = localLaunchParam.miniAppId;
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localLaunchParam.entryPath = URLDecoder.decode((String)localObject1, "UTF-8");
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localLaunchParam.extendData = URLDecoder.decode((String)localObject2, "UTF-8");
          }
          if (!TextUtils.isEmpty(str2)) {
            localLaunchParam.envVersion = URLDecoder.decode(str2, "UTF-8");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("launchMiniAppByScheme, ");
          ((StringBuilder)localObject2).append(Log.getStackTraceString(localUnsupportedEncodingException));
          QLog.e("MiniAppLauncher", 1, ((StringBuilder)localObject2).toString());
        }
        if (!verifyAppid(paramEntryModel))
        {
          paramContext = new StringBuilder();
          paramContext.append("Appid is forbidden： ");
          paramContext.append(paramEntryModel);
          QLog.e("MiniAppLauncher", 1, paramContext.toString());
          AppBrandTask.runTaskOnUiThread(new MiniAppLauncher.3(paramEntryModel));
          return false;
        }
      }
      String str1 = (String)paramHashMap.get("appid");
      paramEntryModel = str1;
      if (TextUtils.isEmpty(str1)) {
        paramEntryModel = (String)paramHashMap.get("mini_appid");
      }
      paramHashMap = new StringBuilder();
      paramHashMap.append("launchMiniAppByScheme appid:");
      paramHashMap.append(paramEntryModel);
      paramHashMap.append(", param:");
      paramHashMap.append(localLaunchParam);
      QLog.i("MiniAppLauncher", 1, paramHashMap.toString());
      if (!verifyAppid_Scence_Fakeurl_Model(paramEntryModel, localLaunchParam.scene, localLaunchParam.fakeUrl))
      {
        paramContext = new StringBuilder();
        paramContext.append("Appid is： ");
        paramContext.append(paramEntryModel);
        paramContext.append(",scence:");
        paramContext.append(localLaunchParam.scene);
        paramContext.append(",fakeurl:");
        paramContext.append(localLaunchParam.fakeUrl);
        paramContext.append(" is forbidden!!!");
        QLog.e("MiniAppLauncher", 1, paramContext.toString());
        AppBrandTask.runTaskOnUiThread(new MiniAppLauncher.4());
        return false;
      }
      return openMiniApp(paramContext, localLaunchParam, paramMiniAppLaunchListener);
    }
    return false;
  }
  
  private static boolean openMiniApp(Context paramContext, LaunchParam paramLaunchParam, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchMiniApp openMiniApp :");
    localStringBuilder.append(paramLaunchParam);
    QLog.i("MiniAppLauncher", 2, localStringBuilder.toString());
    long l1 = System.currentTimeMillis();
    long l2 = mLastGameTime;
    int i = 0;
    if (l1 - l2 <= 1000L) {
      return false;
    }
    mLastGameTime = l1;
    paramLaunchParam.standardize();
    if ((paramLaunchParam.scene == 1047) || (paramLaunchParam.scene == 1048) || (paramLaunchParam.scene == 1049)) {
      i = 1;
    }
    if (i != 0)
    {
      launchAppByMiniCode(paramContext, paramLaunchParam.fakeUrl, paramLaunchParam, paramMiniAppLaunchListener);
      return true;
    }
    if (!TextUtils.isEmpty(paramLaunchParam.fakeUrl))
    {
      launchAppByFakeLink(paramContext, paramLaunchParam.fakeUrl, paramLaunchParam, paramMiniAppLaunchListener);
      return true;
    }
    MiniAppController.startAppByAppid(paramContext, paramLaunchParam.miniAppId, paramLaunchParam.entryPath, paramLaunchParam.envVersion, paramLaunchParam, paramMiniAppLaunchListener);
    return true;
  }
  
  public static boolean startMiniApp(Context paramContext, String paramString, int paramInt, EntryModel paramEntryModel, MiniAppLauncher.MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startMiniApp scene:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("MiniAppLauncher", 1, ((StringBuilder)localObject).toString());
    if (BaseActivity.sTopActivity != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cur Activity:");
      ((StringBuilder)localObject).append(BaseActivity.sTopActivity.getActivityName());
      ((StringBuilder)localObject).append("  class :");
      ((StringBuilder)localObject).append(BaseActivity.sTopActivity.getLocalClassName());
      QLog.d("MiniAppLauncher", 1, ((StringBuilder)localObject).toString());
    }
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
      if (!decodeScheme(paramString, (HashMap)localObject)) {
        return false;
      }
      return launchMiniAppByScheme(paramContext, (HashMap)localObject, paramInt, paramEntryModel, paramMiniAppLaunchListener);
    }
    LaunchParam localLaunchParam2;
    HashMap localHashMap;
    if (isMiniAppSchemeV2(paramString))
    {
      localLaunchParam2 = new LaunchParam();
      localLaunchParam2.scene = paramInt;
      localLaunchParam2.fakeUrl = paramString;
      if (paramEntryModel != null)
      {
        localLaunchParam2.entryModel = paramEntryModel;
        localLaunchParam2.reportData = paramEntryModel.reportData;
      }
      localHashMap = new HashMap();
    }
    try
    {
      if (decodeScheme(paramString, localHashMap))
      {
        paramEntryModel = null;
        if (!TextUtils.isEmpty((CharSequence)localHashMap.get("url"))) {
          paramEntryModel = URLDecoder.decode(paramString, "UTF-8");
        } else if (!TextUtils.isEmpty((CharSequence)localHashMap.get("fakeUrl"))) {
          paramEntryModel = (String)localHashMap.get("fakeUrl");
        }
        String str = (String)localHashMap.get("appid");
        if (TextUtils.isEmpty(str))
        {
          localObject = (String)localHashMap.get("mini_appid");
        }
        else
        {
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = (String)localHashMap.get("_mappid");
          }
        }
        if (!verifyAppid_Scence_Fakeurl_Model((String)localObject, paramInt, paramEntryModel))
        {
          paramEntryModel = new StringBuilder();
          paramEntryModel.append("Appid is： ");
          paramEntryModel.append((String)localObject);
          paramEntryModel.append(",scence:");
          paramEntryModel.append(localLaunchParam2.scene);
          paramEntryModel.append(",fakeurl:");
          paramEntryModel.append(localLaunchParam2.fakeUrl);
          paramEntryModel.append(" is forbidden!!!");
          QLog.e("MiniAppLauncher", 1, paramEntryModel.toString());
          AppBrandTask.runTaskOnUiThread(new MiniAppLauncher.2());
          return false;
        }
      }
    }
    catch (Throwable paramEntryModel)
    {
      label509:
      int i;
      LaunchParam localLaunchParam1;
      break label509;
    }
    LaunchMiniAppBySchemeRequest(paramContext, paramString, localLaunchParam2, paramMiniAppLaunchListener);
    return true;
    if (isMiniAppADSchemeV3(paramString))
    {
      i = 2054;
      try
      {
        localObject = Pattern.compile("mqqapi://miniapp/adopen(/[0-9]+)?\\?").matcher(paramString);
        if (((Matcher)localObject).find())
        {
          localObject = ((Matcher)localObject).group();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = Pattern.compile("(\\d+)").matcher((CharSequence)localObject);
            if (((Matcher)localObject).find())
            {
              paramInt = Integer.parseInt(((Matcher)localObject).group());
              break label603;
            }
          }
        }
        paramInt = 2054;
        label603:
        if (paramInt <= 0) {
          paramInt = i;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppLauncher", 1, new Object[] { "launchMiniApp decode ad scheme scene error url:", paramString, localThrowable });
        paramInt = i;
      }
      localLaunchParam1 = new LaunchParam();
      localLaunchParam1.scene = paramInt;
      localLaunchParam1.fakeUrl = paramString;
      if (paramEntryModel != null)
      {
        localLaunchParam1.entryModel = paramEntryModel;
        localLaunchParam1.reportData = paramEntryModel.reportData;
      }
      LaunchMiniAppBySchemeRequest(paramContext, paramString, localLaunchParam1, paramMiniAppLaunchListener);
      return true;
    }
    paramContext = new StringBuilder();
    paramContext.append("launchMiniApp parameter error: dc04239");
    paramContext.append(paramString);
    QLog.e("MiniAppLauncher", 1, paramContext.toString());
    return false;
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verify Appid failed: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("MiniAppLauncher", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private static boolean verifyAppid_Scence_Fakeurl_Model(String paramString1, int paramInt, String paramString2)
  {
    String str1 = MiniAppConfProcessor.a("mini_app_outsite_black_list", "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("verifyAppid_Scence_Fakeurl_Model appid:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", scene:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", fakeUrl:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", blackList:");
    ((StringBuilder)localObject).append(str1);
    QLog.i("MiniAppLauncher", 1, ((StringBuilder)localObject).toString());
    try
    {
      localObject = Build.BRAND;
      localObject = str1.split(",");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = localObject[i].split("\\|");
        if (arrayOfString.length >= 3)
        {
          String str2 = arrayOfString[0];
          String str3 = arrayOfString[1];
          str1 = null;
          if (arrayOfString.length > 3) {
            str1 = arrayOfString[3];
          }
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (str2.equals(paramString1)) && (Integer.valueOf(arrayOfString[1]).intValue() == paramInt)) {
            if (!TextUtils.isEmpty(str1))
            {
              if (!TextUtils.isEmpty(str1))
              {
                boolean bool = str1.equals(paramString2);
                if (!bool) {}
              }
            }
            else {
              return false;
            }
          }
        }
        i += 1;
      }
      return true;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("verify appidWhiteList failed: ");
      paramString2.append(paramString1);
      QLog.e("MiniAppLauncher", 1, paramString2.toString());
    }
  }
  
  public static boolean verifyArkScene(int paramInt)
  {
    if (arkSceneWhiteList == null)
    {
      String str1 = MiniAppConfProcessor.a("ark_scene_white_list", "1007,1008,1014,1036,2061,2072,2075,2085,2105,2112,2114,2217,2218,4012,4016,4017,4018,4019,4021,4022,4023");
      if ((str1 != null) && (!str1.equals(mArkSceneWhiteListConfig)))
      {
        arkSceneWhiteList = new ArrayList();
        try
        {
          String[] arrayOfString = str1.split(",");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str2 = arrayOfString[i];
              if (!TextUtils.isEmpty(str2)) {
                arkSceneWhiteList.add(str2);
              }
              i += 1;
            }
          }
          return arkSceneWhiteList.contains(String.valueOf(paramInt));
        }
        catch (Throwable localThrowable)
        {
          QLog.e("MiniAppLauncher", 1, "verifyArkScene failed  ", localThrowable);
          mArkSceneWhiteListConfig = str1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher
 * JD-Core Version:    0.7.0.1
 */