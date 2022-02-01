package com.tencent.mobileqq.mini.appbrand.utils;

import afur;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import aufz;
import blsb;
import blsi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import cooperation.qzone.share.QZoneShareActivity;
import eipc.EIPCClient;
import mqq.app.AppRuntime;

public class ShareUtils
{
  private static final int REQ_CODE_SHARE_PIC_TO_QQ = 1010;
  public static final String TAG = "ShareUtils";
  
  private static boolean doOnSharePicActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1010) && (paramInt2 == -1) && (paramActivity != null) && (!paramActivity.isFinishing()))
    {
      Intent localIntent = afur.a(new Intent(paramActivity, SplashActivity.class), null);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_mini_report_event_action_type", "user_click");
      localBundle.putString("key_mini_report_event_sub_action_type", "custom_button");
      localBundle.putString("key_mini_report_event_reserves", "share_QQ");
      localBundle.putString("key_mini_report_event_reserves2", "success");
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
      if (paramIntent != null)
      {
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        paramActivity.startActivity(localIntent);
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  public static String getFileUri(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 104	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 110	java/io/File:exists	()Z
    //   13: ifne +7 -> 20
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: ldc 112
    //   23: aload_2
    //   24: invokestatic 118	android/support/v4/content/FileProvider:getUriForFile	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   27: astore_2
    //   28: aload_0
    //   29: ldc 120
    //   31: aload_2
    //   32: iconst_1
    //   33: invokevirtual 126	android/content/Context:grantUriPermission	(Ljava/lang/String;Landroid/net/Uri;I)V
    //   36: aload_2
    //   37: ifnull -19 -> 18
    //   40: aload_2
    //   41: invokevirtual 132	android/net/Uri:toString	()Ljava/lang/String;
    //   44: areturn
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_2
    //   48: ldc 11
    //   50: iconst_1
    //   51: ldc 134
    //   53: aload_0
    //   54: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   57: aload_0
    //   58: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   61: goto -25 -> 36
    //   64: astore_0
    //   65: goto -17 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramContext	android.content.Context
    //   0	68	1	paramString	String
    //   8	40	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	28	45	java/lang/Exception
    //   28	36	64	java/lang/Exception
  }
  
  public static void startSharePicToQQ(Activity paramActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "startSharePicToQQ. localPicPath=" + paramString);
    }
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_urldrawable_thumb_url", paramString);
    localBundle.putString("forward_filepath", paramString);
    localBundle.putString("forward_extra", paramString);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    if ((AppLoaderFactory.isSDKMode()) || ((paramActivity instanceof GameActivity1))) {
      ActivityResultManager.g().addActivityResultListener(new ShareUtils.1(paramActivity));
    }
    for (;;)
    {
      aufz.a(paramActivity, paramString, 1010);
      return;
      MiniAppController.getInstance().setActivityResultListener(new ShareUtils.2(paramActivity));
    }
  }
  
  public static void startSharePicToQzone(Activity paramActivity, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "startSharePicToQzone. localPicPath=" + paramString1);
    }
    blsi localblsi = blsi.a();
    localblsi.a = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    blsb.a(paramActivity, localblsi, paramString1, paramString2, "", -1);
    paramActivity = new Bundle();
    paramActivity.putString("key_mini_report_event_action_type", "user_click");
    paramActivity.putString("key_mini_report_event_sub_action_type", "custom_button");
    paramActivity.putString("key_mini_report_event_reserves", "share_QZ");
    paramActivity.putString("key_mini_report_event_reserves2", "success");
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", paramActivity, null);
  }
  
  public static void startSharePicToWeChat(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (!WXShareHelper.a().a()) {
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.3(paramActivity));
    }
    do
    {
      return;
      if (!WXShareHelper.a().b())
      {
        ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.4(paramActivity));
        return;
      }
    } while (TextUtils.isEmpty(paramString));
    try
    {
      paramActivity = BitmapFactory.decodeFile(paramString);
      if (paramBoolean)
      {
        WXShareHelper.a().a(paramString, paramActivity, 0);
        return;
      }
    }
    catch (OutOfMemoryError paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    WXShareHelper.a().a(paramString, paramActivity, 1);
  }
  
  public static void startShareToQzone(Activity paramActivity, String paramString1, String paramString2, String paramString3, ApkgInfo paramApkgInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "startShareToQzone. content=" + paramString1 + ",sharePicPath=" + paramString2 + ",entryPath=" + paramString3);
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramApkgInfo.appConfig.config.desc;
    }
    paramString1 = new Intent();
    paramString1.setClassName("com.tencent.mobileqq", QZoneShareActivity.class.getName());
    paramString1.putExtra("isSharedFromMiniProgram", true);
    paramString1.putExtra("miniShareParamAppId", paramApkgInfo.appConfig.config.appId);
    paramString1.putExtra("miniShareParamTitle", paramApkgInfo.apkgName);
    paramString1.putExtra("miniShareParamDescription", str);
    paramString1.putExtra("miniShareParamShareScene", 1);
    paramString1.putExtra("miniShareParamTemplateType", 1);
    paramString1.putExtra("miniShareParamBusinessType", paramApkgInfo.appConfig.config.getReportType());
    paramString1.putExtra("miniShareParamPicUrl", paramString2);
    paramString1.putExtra("miniShareParamJumpUrl", paramString3);
    paramString1.putExtra("miniShareParamIconUrl", paramApkgInfo.iconUrl);
    paramString1.putExtra("miniShareParamVersionType", paramApkgInfo.appConfig.config.verType);
    paramString1.putExtra("miniShareParamVersionId", paramApkgInfo.appConfig.config.versionId);
    paramString1.putExtra("miniShareIsFromInnerButton", paramBoolean);
    paramActivity.startActivity(paramString1);
  }
  
  public static void startShareToWeChat(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, ApkgInfo paramApkgInfo)
  {
    if (!WXShareHelper.a().a())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.5(paramActivity));
      return;
    }
    if (!WXShareHelper.a().b())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.6(paramActivity));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "startShareToWeChat. content=" + paramString1 + ",sharePicPath=" + paramString2 + ",entryPath=" + paramString3);
    }
    if (paramApkgInfo == null)
    {
      QLog.e("AppBrandRuntime", 1, "startShareToWeChat. apkgInfo is null!");
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = paramApkgInfo.appConfig.config.desc;
    }
    for (;;)
    {
      MiniProgramShareUtils.shareAsWeChatMsg(paramApkgInfo.appConfig.config.appId, paramApkgInfo.apkgName, paramString1, 1, 1, paramApkgInfo.appConfig.config.getReportType(), paramString2, null, paramString3, paramApkgInfo.iconUrl, paramApkgInfo.appConfig.config.verType, paramApkgInfo.appConfig.config.versionId, null, paramInt, new ShareUtils.7(paramActivity, paramString2, paramInt, paramString1, paramApkgInfo));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShareUtils
 * JD-Core Version:    0.7.0.1
 */