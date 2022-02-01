package com.tencent.mobileqq.microapp.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils;
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://microapp/open");
  }
  
  public static boolean isMiniAppUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html")) || (paramString.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html")) || (paramString.startsWith("https://mp.weixin.qq.com/a/"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean launchMiniApp(Context paramContext, LaunchParam paramLaunchParam)
  {
    if ((paramContext != null) && (paramLaunchParam != null)) {}
    try
    {
      if (paramLaunchParam.isValid())
      {
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          return openMiniApp(paramContext, paramLaunchParam);
        }
        ComIPCUtils.lauchMiniApp(paramLaunchParam, null);
        return true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("launchMiniApp param invalid :");
        localStringBuilder.append(paramContext);
        localStringBuilder.append("|");
        localStringBuilder.append(paramLaunchParam);
        QLog.i("MiniAppLauncher", 2, localStringBuilder.toString());
      }
      return false;
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
    if (paramStructMsgForGeneralShare == null) {
      return false;
    }
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString1;
    int k = paramStructMsgForGeneralShare.uinType;
    int j = 1212;
    int i = j;
    if (k != 0) {
      if ((k != 1) && (k != 3000)) {
        i = j;
      } else {
        i = 1213;
      }
    }
    localLaunchParam.scene = i;
    if (!TextUtils.isEmpty(paramString2)) {
      localLaunchParam.entryPath = paramString2;
    }
    return launchMiniApp(paramContext, localLaunchParam);
  }
  
  public static boolean launchMiniAppByScanCode(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      boolean bool = paramString.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html");
      int j = 1207;
      int i = j;
      if (!bool) {
        if (paramString.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html"))
        {
          i = j;
        }
        else
        {
          i = j;
          if (paramString.startsWith("https://mp.weixin.qq.com/a/")) {
            i = 1208;
          }
        }
      }
      LaunchParam localLaunchParam = new LaunchParam();
      localLaunchParam.scene = i;
      localLaunchParam.extraKey = paramString;
      return launchMiniApp(paramContext, localLaunchParam);
    }
    return false;
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
    if (paramInt != 1200)
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append("&scene=");
      paramContext.append(paramInt);
      paramContext = paramContext.toString();
    }
    paramString = new Intent(localActivity, JumpActivity.class);
    paramString.setData(Uri.parse(paramContext));
    localActivity.startActivityForResult(paramString, -1);
  }
  
  public static boolean launchMiniAppByScheme(Context paramContext, HashMap paramHashMap)
  {
    if ((paramHashMap != null) && (paramContext != null))
    {
      str = (String)paramHashMap.get("mini_appid");
      localObject1 = null;
    }
    try
    {
      localObject2 = URLDecoder.decode((String)paramHashMap.get("entry_path"), "UTF-8");
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label76;
        }
        i = Integer.parseInt((String)localObject2);
        Object localObject2 = (String)paramHashMap.get("qqwallet_appinfo");
        paramHashMap = (HashMap)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label117;
        }
        try
        {
          paramHashMap = URLDecoder.decode((String)localObject2, "UTF-8");
        }
        catch (UnsupportedEncodingException paramHashMap)
        {
          paramHashMap.printStackTrace();
          paramHashMap = (HashMap)localObject2;
        }
        localObject2 = new LaunchParam();
        ((LaunchParam)localObject2).miniAppId = str;
        ((LaunchParam)localObject2).entryPath = localObject1;
        ((LaunchParam)localObject2).scene = i;
        ((LaunchParam)localObject2).appInfo = paramHashMap;
        return launchMiniApp(paramContext, (LaunchParam)localObject2);
        return false;
        localThrowable1 = localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          int j;
          int i = j;
        }
      }
    }
    localObject2 = (String)paramHashMap.get("scene");
    j = 1200;
    i = j;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchMiniApp openMiniApp :");
      ((StringBuilder)localObject).append(paramLaunchParam);
      QLog.i("MiniAppLauncher", 2, ((StringBuilder)localObject).toString());
    }
    long l = System.currentTimeMillis();
    if (l - mLastGameTime <= 1000L) {
      return false;
    }
    mLastGameTime = l;
    paramLaunchParam.standardize();
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject).putExtra("launch_param", paramLaunchParam);
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppLauncher
 * JD-Core Version:    0.7.0.1
 */