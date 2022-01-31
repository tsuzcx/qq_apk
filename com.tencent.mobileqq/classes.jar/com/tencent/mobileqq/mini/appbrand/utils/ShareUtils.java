package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import aqbe;
import bgyp;
import bgyw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.share.QZoneShareActivity;
import eipc.EIPCClient;
import mqq.app.AppRuntime;

public class ShareUtils
{
  private static final int REQ_CODE_SHARE_PIC_TO_QQ = 1010;
  public static final String TAG = "ShareUtils";
  
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
    MiniAppController.getInstance().setActivityResultListener(new ShareUtils.1(paramActivity));
    aqbe.a(paramActivity, paramString, 1010);
  }
  
  public static void startSharePicToQzone(Activity paramActivity, String paramString, ApkgInfo paramApkgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "startSharePicToQzone. localPicPath=" + paramString);
    }
    bgyw localbgyw = bgyw.a();
    localbgyw.a = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bgyp.a(paramActivity, localbgyw, paramString, paramApkgInfo.apkgName, "", -1);
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
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.2(paramActivity));
    }
    do
    {
      return;
      if (!WXShareHelper.a().b())
      {
        ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.3(paramActivity));
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
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.4(paramActivity));
      return;
    }
    if (!WXShareHelper.a().b())
    {
      ThreadManagerV2.getUIHandlerV2().post(new ShareUtils.5(paramActivity));
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
      MiniProgramShareUtils.shareAsWeChatMsg(paramApkgInfo.appConfig.config.appId, paramApkgInfo.apkgName, paramString1, 1, 1, paramApkgInfo.appConfig.config.getReportType(), paramString2, null, paramString3, paramApkgInfo.iconUrl, paramApkgInfo.appConfig.config.verType, paramApkgInfo.appConfig.config.versionId, null, paramInt, new ShareUtils.6(paramActivity, paramString2, paramInt, paramString1, paramApkgInfo));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShareUtils
 * JD-Core Version:    0.7.0.1
 */