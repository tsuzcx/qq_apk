package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.qzonehub.api.IQzoneShareApi;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import eipc.EIPCClient;
import java.io.File;
import mqq.app.AppRuntime;

public class ShareUtils
{
  public static final String KEY_MINI_REPORT_EVENT_ACTION_TYPE = "key_mini_report_event_action_type";
  public static final String KEY_MINI_REPORT_EVENT_RESERVES = "key_mini_report_event_reserves";
  public static final String KEY_MINI_REPORT_EVENT_RESERVES2 = "key_mini_report_event_reserves2";
  public static final String KEY_MINI_REPORT_EVENT_SUB_ACTION_TYPE = "key_mini_report_event_sub_action_type";
  private static final int REQ_CODE_SHARE_PIC_TO_QQ = 1010;
  public static final String TAG = "ShareUtils";
  
  private static boolean doOnSharePicActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1010) && (paramInt2 == -1) && (paramActivity != null) && (!paramActivity.isFinishing()))
    {
      Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
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
  
  public static String getFileUri(Context paramContext, String paramString)
  {
    Object localObject2 = new File(paramString);
    boolean bool = ((File)localObject2).exists();
    Object localObject1 = null;
    if (!bool) {
      return null;
    }
    try
    {
      localObject2 = FileProvider.getUriForFile(paramContext, "com.tencent.mobileqq.fileprovider", (File)localObject2);
      localObject1 = localObject2;
      paramContext.grantUriPermission("com.tencent.mm", (Uri)localObject2, 1);
      localObject1 = localObject2;
    }
    catch (Exception paramContext)
    {
      QLog.e("ShareUtils", 1, "getFileUri failed with exception:", paramContext);
      paramContext.printStackTrace();
    }
    if (localObject1 != null) {
      paramString = localObject1.toString();
    }
    return paramString;
  }
  
  public static void startSharePicToQQ(Activity paramActivity, String paramString)
  {
    startSharePicToQQ(paramActivity, paramString, null);
  }
  
  public static void startSharePicToQQ(Activity paramActivity, String paramString, ShareChatModel paramShareChatModel)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSharePicToQQ. localPicPath=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ShareUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("forward_type", 1);
      ((Bundle)localObject).putString("forward_urldrawable_thumb_url", paramString);
      ((Bundle)localObject).putString("forward_filepath", paramString);
      ((Bundle)localObject).putString("forward_extra", paramString);
      AppLoaderFactory.g().getCommonManager().addActivityResultListener(new ShareUtils.1(paramActivity));
      if (paramShareChatModel == null)
      {
        paramString = new Intent();
        paramString.putExtras((Bundle)localObject);
        ForwardBaseOption.a(paramActivity, paramString, 1010);
        return;
      }
      MiniProgramShareUtils.shareToChatDirectly(paramActivity, (Bundle)localObject, paramShareChatModel.type, String.valueOf(paramShareChatModel.uin), paramShareChatModel.name, 1010, true);
    }
  }
  
  public static void startSharePicToQzone(Activity paramActivity, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSharePicToQzone. localPicPath=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("ShareUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = QZoneHelper.UserInfo.getInstance();
    ((QZoneHelper.UserInfo)localObject).qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    QZoneHelper.forwardToPublishMood(paramActivity, (QZoneHelper.UserInfo)localObject, paramString1, paramString2, "", -1);
    paramActivity = new Bundle();
    paramActivity.putString("key_mini_report_event_action_type", "user_click");
    paramActivity.putString("key_mini_report_event_sub_action_type", "custom_button");
    paramActivity.putString("key_mini_report_event_reserves", "share_QZ");
    paramActivity.putString("key_mini_report_event_reserves2", "success");
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", paramActivity, null);
  }
  
  public static void startSharePicToWeChat(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (!WXShareHelper.a().b())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.2(paramActivity));
      return;
    }
    if (!WXShareHelper.a().c())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.3(paramActivity));
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramActivity = BitmapFactory.decodeFile(paramString);
      if (paramBoolean)
      {
        WXShareHelper.a().a(paramString, paramActivity, 0);
        return;
      }
      WXShareHelper.a().a(paramString, paramActivity, 1);
      return;
    }
    catch (OutOfMemoryError paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void startShareToQzone(Activity paramActivity, String paramString1, String paramString2, String paramString3, ApkgInfo paramApkgInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startShareToQzone. content=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",sharePicPath=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",entryPath=");
      localStringBuilder.append(paramString3);
      QLog.d("ShareUtils", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = paramApkgInfo.appConfig.config.desc;
    }
    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).shareQzoneForMini(paramActivity, paramApkgInfo.appConfig.config.appId, paramApkgInfo.apkgName, paramString1, 1, 1, paramApkgInfo.appConfig.config.getReportType(), paramString2, paramString3, paramApkgInfo.iconUrl, paramApkgInfo.appConfig.config.verType, paramApkgInfo.appConfig.config.versionId, paramBoolean);
  }
  
  public static void startShareToWeChat(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, ApkgInfo paramApkgInfo)
  {
    if (!WXShareHelper.a().b())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.4(paramActivity));
      return;
    }
    if (!WXShareHelper.a().c())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.5(paramActivity));
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startShareToWeChat. content=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",sharePicPath=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",entryPath=");
      localStringBuilder.append(paramString3);
      QLog.d("ShareUtils", 2, localStringBuilder.toString());
    }
    if (paramApkgInfo == null)
    {
      QLog.e("ShareUtils", 1, "startShareToWeChat. apkgInfo is null!");
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = paramApkgInfo.appConfig.config.desc;
    }
    MiniProgramShareUtils.shareAsWeChatMsg(paramApkgInfo.appConfig.config.appId, paramApkgInfo.apkgName, paramString1, 1, 1, paramApkgInfo.appConfig.config.getReportType(), paramString2, null, paramString3, paramApkgInfo.iconUrl, paramApkgInfo.appConfig.config.verType, paramApkgInfo.appConfig.config.versionId, null, paramInt, new ShareUtils.6(paramActivity, paramString2, paramInt, paramString1, paramApkgInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShareUtils
 * JD-Core Version:    0.7.0.1
 */