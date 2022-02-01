package com.tencent.mobileqq.mini.api.impl;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_REPORT.REPORT.SingleDcData;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.springfestival.HBEntryBannerData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.api.IPrePullListener;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleLaunchParam;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.apkg.ApkgConfigManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.entry.ContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppEntity;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout;
import com.tencent.mobileqq.mini.entry.desktop.item.DeskTopAppEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopCardEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.mobileqq.mini.push.MiniAppControlInfo;
import com.tencent.mobileqq.mini.push.MiniAppPushControl;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.servlet.GetFriendPlayListV2Request;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequest;
import com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.share.WXShareHelperFromQQMiniApp;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.utils.MiniAppReportShareUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.mini.widget.MiniAppProfileCardView;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebViewJsPlugin;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.SharePlugin;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class MiniAppServiceImpl
  implements IMiniAppService
{
  private static final String TAG = "MiniAppServiceImpl";
  
  private MiniAppConfig convert(SimpleMiniAppConfig paramSimpleMiniAppConfig)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSimpleMiniAppConfig != null)
    {
      localObject1 = localObject2;
      if (paramSimpleMiniAppConfig.config != null)
      {
        if (paramSimpleMiniAppConfig.config.stApiAppInfo == null) {
          break label102;
        }
        localObject1 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(paramSimpleMiniAppConfig.config.stApiAppInfo);
      }
    }
    for (;;)
    {
      localObject1 = new MiniAppConfig((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1);
      ((MiniAppConfig)localObject1).launchParam = new LaunchParam();
      ((MiniAppConfig)localObject1).launchParam.scene = paramSimpleMiniAppConfig.launchParam.scene;
      ((MiniAppConfig)localObject1).launchParam.miniAppId = paramSimpleMiniAppConfig.launchParam.miniAppId;
      ((MiniAppConfig)localObject1).launchParam.reportData = paramSimpleMiniAppConfig.launchParam.reportData;
      return localObject1;
      label102:
      localObject1 = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).appId = paramSimpleMiniAppConfig.config.appId;
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).name = paramSimpleMiniAppConfig.config.name;
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).iconUrl = paramSimpleMiniAppConfig.config.iconUrl;
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).verType = paramSimpleMiniAppConfig.config.verType;
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).via = paramSimpleMiniAppConfig.config.via;
    }
  }
  
  public void addDesktopChangeListener(MiniAppPullInterface paramMiniAppPullInterface, DesktopChangeListener paramDesktopChangeListener)
  {
    if ((paramMiniAppPullInterface instanceof MiniAppDesktop)) {
      ((MiniAppDesktop)paramMiniAppPullInterface).getMiniAppDesktopLayout().addDesktopChangeListener(paramDesktopChangeListener);
    }
  }
  
  public void addMiniProgramReportData(Object paramObject)
  {
    if ((paramObject instanceof REPORT.SingleDcData)) {
      MiniProgramReporter.getInstance().add((REPORT.SingleDcData)paramObject);
    }
  }
  
  public boolean asyncShareMiniProgram(Object paramObject)
  {
    try
    {
      boolean bool = MiniProgramOpenSdkUtil.asyncShareMiniProgram((JumpAction)paramObject);
      return bool;
    }
    catch (Throwable paramObject)
    {
      QLog.e("MiniAppServiceImpl", 1, "validMoodInfo exception!", paramObject);
    }
    return false;
  }
  
  public void checkPreloadMiniApp()
  {
    AppBrandLaunchManager.g().checkPreloadApp();
  }
  
  public BaseContactsMiniAppEntryManager createContactsMiniAppEntryManager(Context paramContext, AppRuntime paramAppRuntime, RelativeLayout paramRelativeLayout, int paramInt)
  {
    return new ContactsMiniAppEntryManager(paramContext, (QQAppInterface)paramAppRuntime, paramRelativeLayout, paramInt);
  }
  
  public Entity createDeskTopAppEntity()
  {
    return new DeskTopAppEntity();
  }
  
  public Manager createMiniAppEntityManager(String paramString)
  {
    return new MiniAppEntityManager(paramString);
  }
  
  public MiniAppPullInterface createMiniAppEntryManager(boolean paramBoolean, Activity paramActivity, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, ViewGroup paramViewGroup)
  {
    if (paramBoolean) {}
    try
    {
      return new MiniAppDesktop(paramActivity, (Conversation)paramObject1, (ListView)paramObject2, (PullRefreshHeader)paramObject3, (DrawerFrame)paramObject4, paramViewGroup);
    }
    catch (Throwable paramActivity)
    {
      QLog.e("MiniAppServiceImpl", 1, "", paramActivity);
    }
    paramActivity = new QQMessagePageMiniAppEntryManager(paramActivity, (Conversation)paramObject1, (ListView)paramObject2, (PullRefreshHeader)paramObject3, (DrawerFrame)paramObject4);
    return paramActivity;
    return null;
  }
  
  public AppRuntime createMiniAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    if ((paramMobileQQ instanceof BaseApplicationImpl)) {
      return new MiniAppInterface((BaseApplicationImpl)paramMobileQQ, paramString);
    }
    return null;
  }
  
  public BaseMiniAppProfileCardView createMiniAppProfileCardView(Context paramContext)
  {
    return new MiniAppProfileCardView(paramContext);
  }
  
  public Object createMiniAppWebViewPlugin()
  {
    return new MiniAppPlugin();
  }
  
  public Object createMiniGamePublicAccountWebViewJsPlugin()
  {
    return new MiniGamePublicAccountWebViewJsPlugin();
  }
  
  public void createUpdatableMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, byte[] paramArrayOfByte, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().createUpdatableMsg(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramInt4, paramArrayOfByte, paramMiniAppCmdInterface);
  }
  
  public void doClearAfterLoginSuccess(boolean paramBoolean)
  {
    MiniAppSecurityUtil.doClearAfterLoginSuccess(paramBoolean);
  }
  
  public boolean enableHttp2()
  {
    return GameWnsUtils.enableHttp2();
  }
  
  public void forwardShareWithTryCatch(Context paramContext, HashMap<String, String> paramHashMap, Bundle paramBundle, Intent paramIntent)
  {
    MiniProgramOpenSdkUtil.forwardShareWithTryCatch(paramContext, paramHashMap, paramBundle, paramIntent);
  }
  
  public Class getApkgConfigManagerClass()
  {
    return ApkgConfigManager.class;
  }
  
  public Class getAppBrandLaunchUIClass()
  {
    return AppBrandLaunchUI.class;
  }
  
  public Class getAppBrandUIClass()
  {
    return AppBrandUI.class;
  }
  
  public void getAppInfoById(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, String paramString4, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().getAppInfoById(paramStCommonExt, paramString1, paramString2, paramString3, paramString4, paramMiniAppCmdInterface);
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString, paramInt, paramMiniAppCmdInterface);
  }
  
  public Class getDeskTopAppEntityClass()
  {
    return DeskTopAppEntity.class;
  }
  
  public Class getDesktopCardEntityClass()
  {
    return DesktopCardEntity.class;
  }
  
  public Class getDesktopDataManagerClass()
  {
    return DesktopDataManager.class;
  }
  
  public byte[] getGetFriendPlayListV2RequestBusiBuf(String paramString, int paramInt)
  {
    return new GetFriendPlayListV2Request(null, paramString, paramInt).getBusiBuf();
  }
  
  public byte[] getGetUserAppListRequestBusiBuf(long paramLong1, long paramLong2)
  {
    return new GetUserAppListRequest(null, paramLong1, paramLong2).getBusiBuf();
  }
  
  public Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean)
  {
    return MiniAppUtils.getIcon(paramContext, paramString, paramBoolean);
  }
  
  public Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return MiniAppUtils.getIcon(paramContext, paramString, paramBoolean, paramInt1, paramInt2);
  }
  
  public void getKuolieAppList(COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().getKuolieAppList(paramStCommonExt, paramMiniAppCmdInterface);
  }
  
  public List<MiniAppLocalSearchEntity> getLocalSearchData()
  {
    MiniAppLocalSearchManager localMiniAppLocalSearchManager = (MiniAppLocalSearchManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH);
    if (localMiniAppLocalSearchManager != null) {
      return localMiniAppLocalSearchManager.getLocalSearchData();
    }
    return null;
  }
  
  public long getMemeryUsage()
  {
    return TaskMonitorManager.g().getMemeryUsage();
  }
  
  public QIPCModule getMiniAppBannerIPCModule()
  {
    return MiniAppBannerIPCModule.getInstance();
  }
  
  public Class getMiniAppEntityClass()
  {
    return MiniAppEntity.class;
  }
  
  public Class getMiniAppEntryHandlerClass()
  {
    return MiniAppEntryHandler.class;
  }
  
  public Class getMiniAppExposureManagerClass()
  {
    return MiniAppExposureManager.class;
  }
  
  public Class getMiniAppGameDebugSettingFragmentClass()
  {
    return MiniAppGameDebugSettingFragment.class;
  }
  
  public Class getMiniAppLocalSearchManagerClass()
  {
    return MiniAppLocalSearchManager.class;
  }
  
  public Class getMiniAppSearchDataManagerClass()
  {
    return MiniAppSearchDataManager.class;
  }
  
  public Class getMiniAppSearchFragmentClass()
  {
    return MiniAppSearchFragment.class;
  }
  
  public QIPCModule getMiniAppTransferModule()
  {
    return MiniAppTransferModule.getInstance();
  }
  
  public Class getMiniAppUserAppInfoListManagerClass()
  {
    return MiniAppUserAppInfoListManager.class;
  }
  
  public QIPCModule getMiniGamePublicAccountIPCModule()
  {
    return MiniGamePublicAccountIPCModule.getInstance();
  }
  
  public Object getPhotoLocalMediaInfoByPath(String paramString)
  {
    return SharePlugin.a(paramString);
  }
  
  public Class getPublicFragmentActivityForMiniClass()
  {
    return PublicFragmentActivityForMini.class;
  }
  
  public String getTmpPathFromOut(String paramString1, String paramString2)
  {
    return MiniAppFileManager.getInstance().getTmpPathFromOut(paramString1, paramString2);
  }
  
  public void handleMiniAppMoreClick(Activity paramActivity)
  {
    MiniAppUtils.handleMiniAppMoreClick(paramActivity);
  }
  
  public void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent)
  {
    WXShareHelperFromQQMiniApp.getInstance().handleWXEntryActivityIntent(paramActivity, paramIntent);
  }
  
  public boolean isDebugMiniApp(String paramString)
  {
    return MiniAppUtils.isDebugMiniApp(paramString);
  }
  
  public boolean isMiniAppFakeUrl(String paramString)
  {
    return MiniAppLauncher.isFakeUrl(paramString);
  }
  
  public boolean isMiniAppScheme(String paramString)
  {
    return MiniAppLauncher.isMiniAppScheme(paramString);
  }
  
  public boolean isMiniAppUrl(String paramString)
  {
    return MiniAppLauncher.isMiniAppUrl(paramString);
  }
  
  public boolean isSharingMiniProgram(HashMap<String, String> paramHashMap)
  {
    return MiniProgramOpenSdkUtil.isSharingMiniProgram(paramHashMap);
  }
  
  public boolean isTroopAdminOrCreated()
  {
    return TroopApplicationListUtil.isAdminOrCreated();
  }
  
  public void launchAppByMiniCode(Context paramContext, String paramString, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppServiceImpl.6 local6 = null;
    if (paramMiniAppLaunchListener != null) {
      local6 = new MiniAppServiceImpl.6(this, paramMiniAppLaunchListener);
    }
    MiniAppLauncher.launchAppByMiniCode(paramContext, paramString, paramInt, local6);
  }
  
  public void launchMainPageFragment(Context paramContext, Parcelable paramParcelable, int paramInt)
  {
    if ((paramParcelable instanceof MiniAppConfig))
    {
      MainPageFragment.launch(paramContext, (MiniAppConfig)paramParcelable, paramInt);
      return;
    }
    QLog.e("MiniAppServiceImpl", 1, "appConfig is invalid! appConfig=" + paramParcelable);
  }
  
  public void launchMainPageFragmentForMiniGame(Context paramContext, Parcelable paramParcelable, int paramInt, boolean paramBoolean)
  {
    if ((paramParcelable instanceof MiniAppConfig))
    {
      MainPageFragment.launchForMiniGame(paramContext, (MiniAppConfig)paramParcelable, paramInt, paramBoolean);
      return;
    }
    QLog.e("MiniAppServiceImpl", 1, "appConfig is invalid! appConfig=" + paramParcelable);
  }
  
  public void launchMiniAppById(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppServiceImpl.4 local4 = null;
    if (paramMiniAppLaunchListener != null) {
      local4 = new MiniAppServiceImpl.4(this, paramMiniAppLaunchListener);
    }
    MiniAppLauncher.launchMiniAppById(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, local4);
  }
  
  public boolean launchMiniAppByScheme(Context paramContext, HashMap<String, String> paramHashMap, int paramInt, EntryModel paramEntryModel, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppServiceImpl.5 local5 = null;
    if (paramMiniAppLaunchListener != null) {
      local5 = new MiniAppServiceImpl.5(this, paramMiniAppLaunchListener);
    }
    return MiniAppLauncher.launchMiniAppByScheme(paramContext, paramHashMap, paramInt, paramEntryModel, local5);
  }
  
  public void launchMiniGamePublicAccount(Context paramContext)
  {
    MiniGamePublicAccountHelper.launchMiniGamePublicAccount(paramContext);
  }
  
  public void launchPermissionSettingFragmentForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    PermissionSettingFragment.launchForResult(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void onDexConfigUpdate(String paramString)
  {
    MiniSdkLauncher.onDexConfigUpdate(paramString);
  }
  
  public void onEnterBackground() {}
  
  public void onEnterForeground()
  {
    MiniAppReportManager.onEnterForeground();
    AppBrandLaunchManager.g().onEnterForeground();
  }
  
  public void onMiniGameCardShowMoreView(String paramString, int paramInt1, int paramInt2)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString, paramInt1, new MiniAppServiceImpl.7(this, paramInt2));
  }
  
  public void performUploadArkShareImage(String paramString, IMiniCallback paramIMiniCallback)
  {
    MiniArkShareAsyncManager.performUploadArkShareImage(paramString, paramIMiniCallback);
  }
  
  public void preLaunchMiniAppCheckinFromLeba() {}
  
  public void prePullAppinfoByLink(String paramString, int paramInt, boolean paramBoolean, IPrePullListener paramIPrePullListener)
  {
    MiniAppPrePullManager.getInstance().prePullAppinfoByLink(paramString, paramInt, paramBoolean, paramIPrePullListener);
  }
  
  public void prePullAppinfoByLink(String paramString, boolean paramBoolean, IPrePullListener paramIPrePullListener)
  {
    MiniAppPrePullManager.getInstance().prePullAppinfoByLink(paramString, paramBoolean, paramIPrePullListener);
  }
  
  public void preloadMiniProcess() {}
  
  public void processControlInfo(String paramString, MiniAppControlInfo paramMiniAppControlInfo)
  {
    MiniAppPushControl.getInstance(paramString).processControlInfo(paramMiniAppControlInfo);
  }
  
  public void registerMiniArkShareMessageProcessorAfterProcessRestart() {}
  
  public void removeDesktopChangeListener(MiniAppPullInterface paramMiniAppPullInterface, DesktopChangeListener paramDesktopChangeListener)
  {
    if ((paramMiniAppPullInterface instanceof MiniAppDesktop)) {
      ((MiniAppDesktop)paramMiniAppPullInterface).getMiniAppDesktopLayout().removeDesktopChangeListener(paramDesktopChangeListener);
    }
  }
  
  public void report4239Async(SimpleMiniAppConfig paramSimpleMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSimpleMiniAppConfig != null)
    {
      localObject1 = localObject2;
      if (paramSimpleMiniAppConfig.config != null)
      {
        if (paramSimpleMiniAppConfig.config.stApiAppInfo == null) {
          break label124;
        }
        localObject1 = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(paramSimpleMiniAppConfig.config.stApiAppInfo);
      }
    }
    for (;;)
    {
      localObject1 = new MiniAppConfig((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1);
      ((MiniAppConfig)localObject1).launchParam = new LaunchParam();
      ((MiniAppConfig)localObject1).launchParam.scene = paramSimpleMiniAppConfig.launchParam.scene;
      ((MiniAppConfig)localObject1).launchParam.miniAppId = paramSimpleMiniAppConfig.launchParam.miniAppId;
      ((MiniAppConfig)localObject1).launchParam.reportData = paramSimpleMiniAppConfig.launchParam.reportData;
      MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject1, paramString1, paramString2, paramString3, paramString4);
      return;
      label124:
      localObject1 = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).appId = paramSimpleMiniAppConfig.config.appId;
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).name = paramSimpleMiniAppConfig.config.name;
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).iconUrl = paramSimpleMiniAppConfig.config.iconUrl;
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).verType = paramSimpleMiniAppConfig.config.verType;
      ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject1).via = paramSimpleMiniAppConfig.config.via;
    }
  }
  
  public void report4239Async(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    MiniProgramLpReportDC04239.reportAsync(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void report4239AsyncBySdkMiniAppInfo(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MiniAppConfig localMiniAppConfig = null;
    if ((paramObject instanceof com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)) {
      localMiniAppConfig = new MiniAppConfig(MiniSdkLauncher.convert((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramObject));
    }
    MiniProgramLpReportDC04239.reportAsync(localMiniAppConfig, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void reportByQQ(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    reportByQQ(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public void reportByQQ(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    MiniProgramLpReportDC04239.reportByQQ(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  public void reportByQQqunInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MiniProgramLpReportDC04239.reportByQQqunInfo(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void reportEshopExpo(String paramString1, String paramString2)
  {
    MiniAppBusiReport.reportEshopExpo(paramString1, paramString2);
  }
  
  public void reportMiniAppExposureData(SimpleMiniAppConfig paramSimpleMiniAppConfig, int paramInt)
  {
    paramSimpleMiniAppConfig = convert(paramSimpleMiniAppConfig);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new MiniAppExposureManager.MiniAppExposureData(paramSimpleMiniAppConfig, paramInt));
    MiniProgramLpReportDC04239.reportPageView(localArrayList, "expo");
  }
  
  public void reportNavigatorbarExpose() {}
  
  public void reportProfileCardExposed(Object paramObject, boolean paramBoolean)
  {
    if ((paramObject instanceof ProfileMiniAppInfo)) {
      MiniAppUtils.reportProfileCardExposed((ProfileMiniAppInfo)paramObject, paramBoolean);
    }
  }
  
  public void reportShare(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    MiniAppReportShareUtil.getInstance().reportShare(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2);
  }
  
  public void sendUserAppListRequest(Manager paramManager, long paramLong1, long paramLong2)
  {
    if ((paramManager instanceof MiniAppUserAppInfoListManager)) {
      ((MiniAppUserAppInfoListManager)paramManager).sendUserAppListRequest(paramLong1, paramLong2);
    }
  }
  
  public void shareAsArkMessage(Activity paramActivity, MiniArkShareModel paramMiniArkShareModel, boolean paramBoolean, int paramInt, COMM.StCommonExt paramStCommonExt)
  {
    MiniProgramShareUtils.shareAsArkMessage(paramActivity, paramMiniArkShareModel, paramBoolean, paramInt, paramStCommonExt, null);
  }
  
  public void shareAsQzoneFeeds(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, String paramString8, String paramString9, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniProgramShareUtils.shareAsQzoneFeeds(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, paramInt4, paramString8, paramString9, paramMiniAppCmdInterface);
  }
  
  public boolean shouldOpenWebFragment(String paramString)
  {
    return MiniGamePublicAccountHelper.shouldOpenWebFragment(paramString);
  }
  
  public void splashMiniGameClickReport(SplashMiniGameData paramSplashMiniGameData)
  {
    MiniAppReportManager.splashMiniGameClickReport(paramSplashMiniGameData);
  }
  
  public void startApp(Activity paramActivity, SimpleMiniAppConfig paramSimpleMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    if ((paramSimpleMiniAppConfig == null) || (paramSimpleMiniAppConfig.config == null)) {
      return;
    }
    Object localObject = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
    ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).appId = paramSimpleMiniAppConfig.config.appId;
    ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).name = paramSimpleMiniAppConfig.config.name;
    ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).iconUrl = paramSimpleMiniAppConfig.config.iconUrl;
    ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).setEngineType(paramSimpleMiniAppConfig.config.engineType);
    ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).setReportType(paramSimpleMiniAppConfig.config.reportType);
    ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).developerDesc = paramSimpleMiniAppConfig.config.developerDesc;
    ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).verType = paramSimpleMiniAppConfig.config.verType;
    localObject = new MiniAppConfig((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject);
    ((MiniAppConfig)localObject).launchParam = new LaunchParam();
    if (paramSimpleMiniAppConfig.launchParam != null)
    {
      ((MiniAppConfig)localObject).launchParam.miniAppId = paramSimpleMiniAppConfig.launchParam.miniAppId;
      ((MiniAppConfig)localObject).launchParam.scene = paramSimpleMiniAppConfig.launchParam.scene;
    }
    MiniAppController.startApp(paramActivity, (MiniAppConfig)localObject, paramResultReceiver);
  }
  
  public void startAppByAppid(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppServiceImpl.3 local3 = null;
    if (paramMiniAppLaunchListener != null) {
      local3 = new MiniAppServiceImpl.3(this, paramMiniAppLaunchListener);
    }
    paramMiniAppLaunchListener = new LaunchParam();
    paramMiniAppLaunchListener.scene = paramInt;
    MiniAppController.startAppByAppid(paramContext, paramString1, paramString2, paramString3, paramMiniAppLaunchListener, local3);
  }
  
  public void startAppByLink(Context paramContext, String paramString, int paramInt1, int paramInt2, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppServiceImpl.2 local2 = null;
    if (paramMiniAppLaunchListener != null) {
      local2 = new MiniAppServiceImpl.2(this, paramMiniAppLaunchListener);
    }
    paramMiniAppLaunchListener = new LaunchParam();
    paramMiniAppLaunchListener.scene = paramInt2;
    MiniAppController.startAppByLink(paramContext, paramString, paramInt1, paramMiniAppLaunchListener, local2);
  }
  
  public boolean startMiniApp(Context paramContext, String paramString, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    return startMiniApp(paramContext, paramString, paramInt, null, paramMiniAppLaunchListener);
  }
  
  public boolean startMiniApp(Context paramContext, String paramString, int paramInt, EntryModel paramEntryModel, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    MiniAppServiceImpl.1 local1 = null;
    if (paramMiniAppLaunchListener != null) {
      local1 = new MiniAppServiceImpl.1(this, paramMiniAppLaunchListener);
    }
    return MiniAppLauncher.startMiniApp(paramContext, paramString, paramInt, paramEntryModel, local1);
  }
  
  public void updateDataDbFromNetResultInLocalSearchManager(MiniAppLocalSearchEntity paramMiniAppLocalSearchEntity)
  {
    MiniAppLocalSearchManager localMiniAppLocalSearchManager = (MiniAppLocalSearchManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH);
    if (localMiniAppLocalSearchManager != null) {
      localMiniAppLocalSearchManager.updateDataDbFromNetResult(paramMiniAppLocalSearchEntity);
    }
  }
  
  public void updateMiniAppList(int paramInt)
  {
    MiniAppUtils.updateMiniAppList(paramInt);
  }
  
  public void updateMiniDesktopBackground(MiniAppPullInterface paramMiniAppPullInterface, Drawable paramDrawable)
  {
    if ((paramMiniAppPullInterface instanceof MiniAppDesktop)) {
      ((MiniAppDesktop)paramMiniAppPullInterface).getMiniAppDesktopLayout().updateMiniDesktopBackground(paramDrawable);
    }
  }
  
  public void updateMiniHBBanner(Object paramObject)
  {
    if ((paramObject instanceof HBEntryBannerData)) {}
    for (paramObject = (HBEntryBannerData)paramObject;; paramObject = null)
    {
      ((DesktopDataManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).updateMiniHBBanner(paramObject);
      return;
    }
  }
  
  public Object validMoodInfo(Object paramObject)
  {
    try
    {
      paramObject = SharePlugin.a((PublishMoodInfo)paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      QLog.e("MiniAppServiceImpl", 1, "validMoodInfo exception!", paramObject);
    }
    return null;
  }
  
  public boolean verifyArkScene(int paramInt)
  {
    return MiniAppLauncher.verifyArkScene(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl
 * JD-Core Version:    0.7.0.1
 */