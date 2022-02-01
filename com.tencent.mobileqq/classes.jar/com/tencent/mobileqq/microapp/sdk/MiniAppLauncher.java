package com.tencent.mobileqq.microapp.sdk;

import albn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public class MiniAppLauncher
{
  private static final String TAG = "MiniAppLauncher";
  private static final String URL_PREFIX_MINIAPP_HTTP = "https://imgcache.qq.com/channel/mini_app/upgrade.html";
  private static final String URL_PREFIX_MINIAPP_HTTPS = "https://imgcache.qq.com/channel/mini_app/upgrade.html";
  private static final String URL_PREFIX_WX_MINIAPP_HTTPS = "https://mp.weixin.qq.com/a/";
  static long mLastGameTime;
  
  public static boolean isMiniAppScheme(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("mqqapi://microapp/open")) {
      return false;
    }
    return true;
  }
  
  public static boolean isMiniAppUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html")) && (!paramString.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html")) && (!paramString.startsWith("https://mp.weixin.qq.com/a/"))) {
      return false;
    }
    return true;
  }
  
  public static boolean launchMiniApp(Context paramContext, LaunchParam paramLaunchParam)
  {
    if ((paramContext != null) && (paramLaunchParam != null)) {}
    try
    {
      if (!paramLaunchParam.isValid())
      {
        if (QLog.isColorLevel())
        {
          QLog.i("MiniAppLauncher", 2, "launchMiniApp param invalid :" + paramContext + "|" + paramLaunchParam);
          return false;
        }
      }
      else
      {
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          return openMiniApp(paramContext, paramLaunchParam);
        }
        albn.a(paramLaunchParam, null);
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean launchMiniApp(Context paramContext, String paramString, int paramInt)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString;
    localLaunchParam.scene = paramInt;
    return launchMiniApp(paramContext, localLaunchParam);
  }
  
  public static boolean launchMiniApp(Context paramContext, String paramString1, StructMsgForGeneralShare paramStructMsgForGeneralShare, String paramString2)
  {
    int j = 1212;
    if (paramStructMsgForGeneralShare == null) {
      return false;
    }
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    int i = j;
    switch (paramStructMsgForGeneralShare.uinType)
    {
    }
    for (i = j;; i = 1213)
    {
      localLaunchParam.scene = i;
      if (!TextUtils.isEmpty(paramString2)) {
        localLaunchParam.entryPath = paramString2;
      }
      return launchMiniApp(paramContext, localLaunchParam);
    }
  }
  
  public static boolean launchMiniAppByScanCode(Context paramContext, String paramString)
  {
    int j = 1207;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    int i = j;
    if (!paramString.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html"))
    {
      if (!paramString.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html")) {
        break label67;
      }
      i = j;
    }
    for (;;)
    {
      LaunchParam localLaunchParam = new LaunchParam();
      localLaunchParam.scene = i;
      localLaunchParam.extraKey = paramString;
      return launchMiniApp(paramContext, localLaunchParam);
      label67:
      i = j;
      if (paramString.startsWith("https://mp.weixin.qq.com/a/")) {
        i = 1208;
      }
    }
  }
  
  public static void launchMiniAppByScheme(Context paramContext, String paramString)
  {
    launchMiniAppByScheme(paramContext, paramString, 1200);
  }
  
  public static void launchMiniAppByScheme(Context paramContext, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) && (!(paramContext instanceof Activity))) {
      return;
    }
    Activity localActivity = (Activity)paramContext;
    paramContext = paramString;
    if (paramInt != 1200) {
      paramContext = paramString + "&scene=" + paramInt;
    }
    paramString = new Intent(localActivity, JumpActivity.class);
    paramString.setData(Uri.parse(paramContext));
    localActivity.startActivityForResult(paramString, -1);
  }
  
  public static boolean launchMiniAppByScheme(Context paramContext, HashMap paramHashMap)
  {
    if ((paramHashMap == null) || (paramContext == null)) {
      return false;
    }
    String str = (String)paramHashMap.get("mini_appid");
    Object localObject1 = null;
    try
    {
      localObject2 = URLDecoder.decode((String)paramHashMap.get("entry_path"), "UTF-8");
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        Object localObject2;
        continue;
        int i = 1200;
      }
    }
    localObject2 = (String)paramHashMap.get("scene");
    i = 1200;
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label168;
      }
      int j = Integer.parseInt((String)localObject2);
      i = j;
    }
    catch (Throwable localThrowable1)
    {
      label75:
      break label75;
    }
    localObject2 = (String)paramHashMap.get("qqwallet_appinfo");
    paramHashMap = (HashMap)localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      paramHashMap = URLDecoder.decode((String)localObject2, "UTF-8");
      localObject2 = new LaunchParam();
      ((LaunchParam)localObject2).miniAppId = str;
      ((LaunchParam)localObject2).entryPath = localObject1;
      ((LaunchParam)localObject2).scene = i;
      ((LaunchParam)localObject2).appInfo = paramHashMap;
      return launchMiniApp(paramContext, (LaunchParam)localObject2);
    }
    catch (UnsupportedEncodingException paramHashMap)
    {
      for (;;)
      {
        paramHashMap.printStackTrace();
        paramHashMap = (HashMap)localObject2;
      }
    }
  }
  
  public static boolean navigateBackMiniApp(Context paramContext, String paramString1, String paramString2)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = 1215;
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.navigateExtData = paramString2;
    localLaunchParam.scene = 1215;
    return launchMiniApp(paramContext, localLaunchParam);
  }
  
  public static boolean navigateToMiniApp(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = 1214;
    localLaunchParam.miniAppId = paramString1;
    localLaunchParam.entryPath = paramString2;
    localLaunchParam.fromMiniAppId = paramString3;
    localLaunchParam.navigateExtData = paramString4;
    localLaunchParam.scene = 1214;
    return launchMiniApp(paramContext, localLaunchParam);
  }
  
  private static boolean openMiniApp(Context paramContext, LaunchParam paramLaunchParam)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppLauncher", 2, "launchMiniApp openMiniApp :" + paramLaunchParam);
    }
    long l = System.currentTimeMillis();
    if (l - mLastGameTime <= 1000L) {
      bool = false;
    }
    Intent localIntent;
    do
    {
      return bool;
      mLastGameTime = l;
      paramLaunchParam.standardize();
      localIntent = new Intent();
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("launch_param", paramLaunchParam);
    } while ((paramContext instanceof Activity));
    localIntent.addFlags(268435456);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppLauncher
 * JD-Core Version:    0.7.0.1
 */