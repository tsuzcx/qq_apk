package com.tencent.mobileqq.mini.reuse;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.MessageToShowBanner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class MiniAppBannerIPCModule
  extends QIPCModule
{
  public static final String ACTION_ENTER_BACKGROUND = "action.miniapp.enterbackground";
  public static final String ACTION_ENTER_FOREGROUND = "action.miniapp.enterforeground";
  private static final int AUTO_CLOSE_DELAY = 300000;
  private static final int MSG_AUTO_CLOSE_TIMEOUT = 1;
  public static final String NAME = "MiniAppBannerIPCModule";
  public static final String TAG = "MiniAppBannerIPCModule";
  public static final String TVALUE_CLICK_MINIAPP = "0X800A123";
  public static final String TVALUE_CLOSE_MINIAPP = "0X800A124";
  public static final String TVALUE_SHOW_MINIAPP = "0X800A121";
  private Handler mHandler = new MiniAppBannerIPCModule.1(this, Looper.getMainLooper());
  private BBannerHelper.MessageToShowBanner mMessageToShowBanner;
  
  private MiniAppBannerIPCModule()
  {
    super("MiniAppBannerIPCModule");
  }
  
  private static QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static MiniAppBannerIPCModule getInstance()
  {
    return MiniAppBannerIPCModule.Holder.access$200();
  }
  
  private void hideExistingMessageToBanner()
  {
    if (this.mMessageToShowBanner != null)
    {
      BBannerHelper.a(getAppInterface(), this.mMessageToShowBanner);
      this.mMessageToShowBanner = null;
    }
  }
  
  private static void notifyBannerStateChange(String paramString, ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return;
    }
    if (!paramApkgInfo.appConfig.config.isSupportBlueBar) {
      return;
    }
    ThreadManagerV2.excute(new MiniAppBannerIPCModule.2(paramApkgInfo, paramString), 16, null, true);
  }
  
  public static void notifyEnterBackground(ApkgInfo paramApkgInfo)
  {
    notifyBannerStateChange("action.miniapp.enterbackground", paramApkgInfo);
  }
  
  public static void notifyEnterForeground(ApkgInfo paramApkgInfo)
  {
    notifyBannerStateChange("action.miniapp.enterforeground", paramApkgInfo);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {
      return null;
    }
    if ((QLog.isColorLevel()) && (paramBundle != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MiniAppBannerIPCModule : ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramBundle.toString());
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d("MiniAppBannerIPCModule", 2, new Object[] { localObject1, ((StringBuilder)localObject2).toString() });
    }
    paramBundle.setClassLoader(MiniAppConfig.class.getClassLoader());
    Object localObject1 = paramBundle.getString("apkgName");
    Object localObject2 = (MiniAppConfig)paramBundle.getParcelable("appConfig");
    if (localObject2 == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (((MiniAppConfig)localObject2).isReportTypeMiniGame()) {
      paramBundle = "正在玩";
    } else {
      paramBundle = "正在使用";
    }
    localStringBuilder.append(paramBundle);
    localStringBuilder.append((String)localObject1);
    if (((MiniAppConfig)localObject2).isReportTypeMiniGame()) {
      paramInt = 12;
    } else {
      paramInt = 11;
    }
    hideExistingMessageToBanner();
    if ("action.miniapp.enterbackground".equals(paramString))
    {
      this.mMessageToShowBanner = BBannerHelper.a(getAppInterface(), paramInt, "com.tencent.mobileqq.miniapp", localStringBuilder.toString(), new MiniAppBannerIPCModule.BannerInteract((MiniAppConfig)localObject2));
      this.mHandler.sendEmptyMessageDelayed(1, 300000L);
      ReportController.a(getAppInterface(), "dc00898", "", "", "0X800A121", "0X800A121", 4, 0, "", "", "", "");
    }
    return new EIPCResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule
 * JD-Core Version:    0.7.0.1
 */