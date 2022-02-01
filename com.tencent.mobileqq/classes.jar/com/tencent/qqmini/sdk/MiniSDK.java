package com.tencent.qqmini.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.MiniSDKImpl;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher.FragmentType;

@MiniKeep
public class MiniSDK
{
  public static final String LAUNCH_SERVICE = "LAUNCH_SERVICE";
  public static final int LINKTYPE_FAKEURL = 0;
  public static final int LINKTYPE_MINICODE = 1;
  public static final int LINKTYPE_SCHEMA = 2;
  public static final String OPEN_LINK_URL_PREFIX = "{@schema}://minisdk/open?link=";
  public static final int STATE_CREATE = 0;
  public static final int STATE_SHOW = 1;
  public static final String TAG = "minisdk-start_MiniSDK";
  private static MiniSDKImpl sMiniSDKImpl = new MiniSDKImpl();
  
  public static void init(Context paramContext)
  {
    sMiniSDKImpl.init(paramContext);
  }
  
  public static void notifyPeriodicCacheUpdate(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyPeriodicCacheUpdate, MiniAppInfo = ");
    localStringBuilder.append(paramMiniAppInfo);
    QMLog.i("minisdk-start_MiniSDK", localStringBuilder.toString());
    sMiniSDKImpl.init(paramContext);
    sMiniSDKImpl.notifyPeriodicCacheUpdate(paramMiniAppInfo);
  }
  
  public static void notifyShareResult(Context paramContext, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    notifyShareResult(paramContext, paramMiniAppInfo, paramBundle, null);
  }
  
  public static void notifyShareResult(Context paramContext, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyShareResult, MiniAppInfo = ");
    localStringBuilder.append(paramMiniAppInfo);
    QMLog.i("minisdk-start_MiniSDK", localStringBuilder.toString());
    sMiniSDKImpl.init(paramContext);
    sMiniSDKImpl.notifyShareResult(paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public static void onHostAppBackground(Context paramContext)
  {
    sMiniSDKImpl.init(paramContext);
    sMiniSDKImpl.onHostAppBackground();
  }
  
  public static void preDownloadPkg(Context paramContext, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    sMiniSDKImpl.init(paramContext);
    sMiniSDKImpl.preDownloadPkg(paramMiniAppInfo, paramResultReceiver);
  }
  
  public static void preloadMiniApp(Context paramContext)
  {
    QMLog.i("minisdk-start_MiniSDK", "preloadMiniApp");
    preloadMiniApp(paramContext, new Bundle());
  }
  
  public static void preloadMiniApp(Context paramContext, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_MiniSDK", "preloadMiniApp");
    sMiniSDKImpl.init(paramContext);
    sMiniSDKImpl.preloadMiniApp(paramContext, paramBundle);
  }
  
  public static String scanMiniCode(Context paramContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    sMiniSDKImpl.init(paramContext);
    return sMiniSDKImpl.scanMiniCode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public static void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    startMiniApp(paramActivity, paramMiniAppInfo, null, null);
  }
  
  public static void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startMiniApp miniappInfo:");
    ((StringBuilder)localObject).append(paramMiniAppInfo);
    QMLog.i("minisdk-start_MiniSDK", ((StringBuilder)localObject).toString());
    MiniSDKImpl localMiniSDKImpl = sMiniSDKImpl;
    if (paramActivity != null) {
      localObject = paramActivity.getApplicationContext();
    } else {
      localObject = null;
    }
    localMiniSDKImpl.init((Context)localObject);
    sMiniSDKImpl.startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public static void startMiniApp(Activity paramActivity, String paramString)
  {
    startMiniApp(paramActivity, paramString, 1001, null);
  }
  
  public static void startMiniApp(Activity paramActivity, String paramString, int paramInt)
  {
    startMiniApp(paramActivity, paramString, paramInt, null);
  }
  
  public static void startMiniApp(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    startMiniApp(paramActivity, paramString, paramInt1, paramInt2, null);
  }
  
  public static void startMiniApp(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    startMiniApp(paramActivity, paramString1, paramInt1, paramInt2, paramString2, null);
  }
  
  public static void startMiniApp(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2, ResultReceiver paramResultReceiver)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startMiniApp link: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", linkType: ");
    ((StringBuilder)localObject).append(paramInt1);
    QMLog.i("minisdk-start_MiniSDK", ((StringBuilder)localObject).toString());
    MiniSDKImpl localMiniSDKImpl = sMiniSDKImpl;
    if (paramActivity != null) {
      localObject = paramActivity.getApplicationContext();
    } else {
      localObject = null;
    }
    localMiniSDKImpl.init((Context)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("mini_link", paramString1);
    ((Intent)localObject).putExtra("mini_link_type", paramInt1);
    ((Intent)localObject).putExtra("mini_customInfo", paramString2);
    paramString1 = new LaunchParam();
    paramString1.scene = paramInt2;
    ((Intent)localObject).putExtra("mini_launch_param", paramString1);
    ((Intent)localObject).putExtra("mini_receiver", paramResultReceiver);
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    MiniFragmentLauncher.startTranslucent(paramActivity, (Intent)localObject, MiniFragmentLauncher.FragmentType.FRAGMENT_APPINFO_LOADING);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public static void startMiniApp(Activity paramActivity, String paramString, int paramInt, ResultReceiver paramResultReceiver)
  {
    startMiniApp(paramActivity, paramString, paramInt, new LaunchParam(), paramResultReceiver);
  }
  
  public static void startMiniApp(Activity paramActivity, String paramString, int paramInt, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    startMiniApp(paramActivity, paramString, paramInt, null, null, paramLaunchParam, paramResultReceiver);
  }
  
  public static void startMiniApp(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, LaunchParam paramLaunchParam, ResultReceiver paramResultReceiver)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startMiniApp appId:");
    ((StringBuilder)localObject).append(paramString1);
    QMLog.i("minisdk-start_MiniSDK", ((StringBuilder)localObject).toString());
    MiniSDKImpl localMiniSDKImpl = sMiniSDKImpl;
    if (paramActivity != null) {
      localObject = paramActivity.getApplicationContext();
    } else {
      localObject = null;
    }
    localMiniSDKImpl.init((Context)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_appid", paramString1);
    paramLaunchParam.scene = paramInt;
    ((Intent)localObject).putExtra("mini_entryPath", paramString2);
    ((Intent)localObject).putExtra("mini_envVersion", paramString3);
    ((Intent)localObject).putExtra("mini_launch_param", paramLaunchParam);
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject).putExtra("mini_receiver", paramResultReceiver);
    MiniFragmentLauncher.startTranslucent(paramActivity, (Intent)localObject, MiniFragmentLauncher.FragmentType.FRAGMENT_APPINFO_LOADING);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public static void stopAllMiniApp(Context paramContext)
  {
    QMLog.i("minisdk-start_MiniSDK", "stopAllMiniApp");
    sMiniSDKImpl.init(paramContext);
    sMiniSDKImpl.stopAllMiniApp();
  }
  
  public static void stopMiniApp(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopMiniApp ");
    localStringBuilder.append(paramMiniAppInfo);
    QMLog.i("minisdk-start_MiniSDK", localStringBuilder.toString());
    sMiniSDKImpl.init(paramContext);
    sMiniSDKImpl.stopMiniApp(paramMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.MiniSDK
 * JD-Core Version:    0.7.0.1
 */