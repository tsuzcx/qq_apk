package com.tencent.mobileqq.mini.api.impl;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_MINI_REPORT.REPORT.SingleDcData;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
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
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CommonExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
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
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.SharePlugin;
import com.tencent.qqmini.proxyimpl.ShareQQArkHelper;
import com.tencent.widget.ListView;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class MiniAppServiceImpl
  implements IMiniAppService
{
  private static final String FAKE_APPID_FOR_REPORT = "0000000000";
  private static final String MINI_APP_DF_SEARCH_FRAGMENT = "com.tencent.mobileqq.mini.entry.dfsearch.ui.MiniAppSearchFragment";
  private static final String TAG = "MiniAppServiceImpl";
  
  private MiniAppConfig convert(SimpleMiniAppConfig paramSimpleMiniAppConfig)
  {
    if ((paramSimpleMiniAppConfig != null) && (paramSimpleMiniAppConfig.config != null))
    {
      if (paramSimpleMiniAppConfig.config.stApiAppInfo != null)
      {
        localObject = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(paramSimpleMiniAppConfig.config.stApiAppInfo);
      }
      else
      {
        localObject = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).appId = paramSimpleMiniAppConfig.config.appId;
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).name = paramSimpleMiniAppConfig.config.name;
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).iconUrl = paramSimpleMiniAppConfig.config.iconUrl;
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).verType = paramSimpleMiniAppConfig.config.verType;
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).via = paramSimpleMiniAppConfig.config.via;
      }
      Object localObject = new MiniAppConfig((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject);
      ((MiniAppConfig)localObject).launchParam = new LaunchParam();
      ((MiniAppConfig)localObject).launchParam.scene = paramSimpleMiniAppConfig.launchParam.scene;
      ((MiniAppConfig)localObject).launchParam.miniAppId = paramSimpleMiniAppConfig.launchParam.miniAppId;
      ((MiniAppConfig)localObject).launchParam.reportData = paramSimpleMiniAppConfig.launchParam.reportData;
      return localObject;
    }
    return null;
  }
  
  private com.tencent.qqmini.sdk.launcher.model.MiniAppInfo getFakeMiniAppInfoForReport(String paramString1, String paramString2)
  {
    com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo = new com.tencent.qqmini.sdk.launcher.model.MiniAppInfo();
    localMiniAppInfo.appId = paramString1;
    try
    {
      localMiniAppInfo.verType = Integer.parseInt(paramString2);
      return localMiniAppInfo;
    }
    catch (Throwable paramString1)
    {
      QLog.e("MiniAppServiceImpl", 2, "reportColorSignClickAndStartMiniApp parseInt err:", paramString1);
    }
    return localMiniAppInfo;
  }
  
  private void reportColorSignClick(int paramInt, com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramInt == 1132)
    {
      if (paramMiniAppInfo != null)
      {
        report4239AsyncBySdkMiniAppInfo(paramMiniAppInfo, "addRecentColorSign", "recentColorSign_enter", "click", null);
        return;
      }
      report4239Async("addRecentColorSign", "recentColorSign_enter", "click", null, null, null);
      return;
    }
    if (paramMiniAppInfo != null)
    {
      report4239AsyncBySdkMiniAppInfo(paramMiniAppInfo, "addColorSign", "colorSign_enter", "click", null);
      return;
    }
    report4239Async("addColorSign", "colorSign_enter", "click", null, null, null);
  }
  
  private void reportMiniSearchDFResult(boolean paramBoolean)
  {
    String str;
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramBoolean) {
        str = "mmcl_suc";
      } else {
        str = "mmcl_fail";
      }
    }
    else if (paramBoolean) {
      str = "dex_suc";
    } else {
      str = "dex_fail";
    }
    MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1061, "0", str, "", "", "");
  }
  
  private void reportMiniSearchLaunchMode(String paramString)
  {
    MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1060, "0", paramString, "", "", "");
  }
  
  private void triggerMiniSearchDFInstall(IQRoutePlugin paramIQRoutePlugin)
  {
    MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1062, "0");
    paramIQRoutePlugin.install(new MiniAppServiceImpl.1(this));
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
  
  public void addSearchItemAndCheckReport(SimpleMiniAppConfig paramSimpleMiniAppConfig, String paramString1, String paramString2)
  {
    paramSimpleMiniAppConfig = convert(paramSimpleMiniAppConfig);
    ((MiniAppExposureManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(paramSimpleMiniAppConfig, "page_view", "expo"));
  }
  
  public void addSearchItemAndCheckReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ((MiniAppExposureManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).addSearchItemAndCheckReport(new MiniAppExposureManager.CommonExposureData(paramString1, paramString2, paramString3, paramString4, paramString5));
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
  
  public void getHotSearchApps(COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().getHotSearchApps(paramStCommonExt, paramMiniAppCmdInterface);
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
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_enable_search_dynamic_feature", 1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QLog.d("MiniAppServiceImpl", 1, "getMiniAppSearchFragmentClass and enableMiniSearchDf is false");
      reportMiniSearchLaunchMode("launch_normal");
      return MiniAppSearchFragment.class;
    }
    Object localObject = QRoute.plugin("qqminisearch_feature.apk");
    QLog.d("MiniAppServiceImpl", 1, "start install miniSearchPlugin!");
    if (!((IQRoutePlugin)localObject).isInstalled())
    {
      QLog.d("MiniAppServiceImpl", 1, "getMiniAppSearchFragmentClass - miniSearchPlugin do not installed!");
      triggerMiniSearchDFInstall((IQRoutePlugin)localObject);
      reportMiniSearchLaunchMode("launch_normal");
      return MiniAppSearchFragment.class;
    }
    QLog.d("MiniAppServiceImpl", 1, "getMiniAppSearchFragmentClass - miniSearchPlugin has been installed!");
    try
    {
      ((IQRoutePlugin)localObject).loadPlugin();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[同步调用-获取dfFragment] classloader:");
      ((StringBuilder)localObject).append(BaseApplicationImpl.sApplication.getClassLoader());
      QLog.e("MiniAppServiceImpl", 1, ((StringBuilder)localObject).toString());
      localObject = Class.forName("com.tencent.mobileqq.mini.entry.dfsearch.ui.MiniAppSearchFragment");
      QLog.e("MiniAppServiceImpl", 1, "[同步调用-获取dfFragment成功!]");
      reportMiniSearchLaunchMode("launch_df");
      reportMiniSearchDFResult(true);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QLog.e("MiniAppServiceImpl", 1, "ClassNotFoundException:", localClassNotFoundException);
      QLog.e("MiniAppServiceImpl", 1, "[同步调用-获取dfFragment失败]");
      reportMiniSearchLaunchMode("launch_normal");
      reportMiniSearchDFResult(false);
    }
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
  
  public void guessYouLike(COMM.StCommonExt paramStCommonExt, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().guessYouLike(paramStCommonExt, paramInt, paramMiniAppCmdInterface);
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
    if (paramMiniAppLaunchListener != null) {
      paramMiniAppLaunchListener = new MiniAppServiceImpl.7(this, paramMiniAppLaunchListener);
    } else {
      paramMiniAppLaunchListener = null;
    }
    MiniAppLauncher.launchAppByMiniCode(paramContext, paramString, paramInt, paramMiniAppLaunchListener);
  }
  
  public void launchMainPageFragment(Context paramContext, Parcelable paramParcelable, int paramInt)
  {
    if ((paramParcelable instanceof MiniAppConfig))
    {
      MainPageFragment.launch(paramContext, (MiniAppConfig)paramParcelable, paramInt);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("appConfig is invalid! appConfig=");
    paramContext.append(paramParcelable);
    QLog.e("MiniAppServiceImpl", 1, paramContext.toString());
  }
  
  public void launchMainPageFragmentForMiniGame(Context paramContext, Parcelable paramParcelable, int paramInt, boolean paramBoolean)
  {
    if ((paramParcelable instanceof MiniAppConfig))
    {
      MainPageFragment.launchForMiniGame(paramContext, (MiniAppConfig)paramParcelable, paramInt, paramBoolean);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("appConfig is invalid! appConfig=");
    paramContext.append(paramParcelable);
    QLog.e("MiniAppServiceImpl", 1, paramContext.toString());
  }
  
  public void launchMiniAppByApiAppInfo(@NonNull Activity paramActivity, @NonNull INTERFACE.StApiAppInfo paramStApiAppInfo, int paramInt)
  {
    try
    {
      MiniAppController.launchMiniAppByAppInfo(paramActivity, com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(paramStApiAppInfo), paramInt);
      return;
    }
    catch (MiniAppException paramActivity)
    {
      QLog.e("MiniAppServiceImpl", 1, "launchMiniAppByApiAppInfo get an exception:", paramActivity);
    }
  }
  
  public void launchMiniAppByAppInfo(Activity paramActivity, INTERFACE.StUserAppInfo paramStUserAppInfo, int paramInt)
  {
    try
    {
      QLog.d("MiniAppServiceImpl", 2, "launchMiniAppByAppInfo");
      MiniAppController.launchMiniAppByAppInfo(paramActivity, com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(paramStUserAppInfo), paramInt);
      return;
    }
    catch (MiniAppException paramActivity)
    {
      QLog.e("MiniAppServiceImpl", 1, "launchMiniAppByAppInfo get an exception:", paramActivity);
    }
  }
  
  public void launchMiniAppById(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (paramMiniAppLaunchListener != null) {
      paramMiniAppLaunchListener = new MiniAppServiceImpl.5(this, paramMiniAppLaunchListener);
    } else {
      paramMiniAppLaunchListener = null;
    }
    MiniAppLauncher.launchMiniAppById(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramMiniAppLaunchListener);
  }
  
  public boolean launchMiniAppByScheme(Context paramContext, HashMap<String, String> paramHashMap, int paramInt, EntryModel paramEntryModel, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (paramMiniAppLaunchListener != null) {
      paramMiniAppLaunchListener = new MiniAppServiceImpl.6(this, paramMiniAppLaunchListener);
    } else {
      paramMiniAppLaunchListener = null;
    }
    return MiniAppLauncher.launchMiniAppByScheme(paramContext, paramHashMap, paramInt, paramEntryModel, paramMiniAppLaunchListener);
  }
  
  public void launchMiniGamePublicAccount(Context paramContext)
  {
    launchMiniGamePublicAccount(paramContext, "");
  }
  
  public void launchMiniGamePublicAccount(Context paramContext, String paramString)
  {
    MiniGamePublicAccountHelper.launchMiniGamePublicAccount(paramContext, paramString);
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
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString, paramInt1, new MiniAppServiceImpl.8(this, paramInt2));
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
  
  public void removeDesktopChangeListener(MiniAppPullInterface paramMiniAppPullInterface, DesktopChangeListener paramDesktopChangeListener)
  {
    if ((paramMiniAppPullInterface instanceof MiniAppDesktop)) {
      ((MiniAppDesktop)paramMiniAppPullInterface).getMiniAppDesktopLayout().removeDesktopChangeListener(paramDesktopChangeListener);
    }
  }
  
  public void report4239Async(SimpleMiniAppConfig paramSimpleMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramSimpleMiniAppConfig != null) && (paramSimpleMiniAppConfig.config != null))
    {
      if (paramSimpleMiniAppConfig.config.stApiAppInfo != null)
      {
        localObject = com.tencent.mobileqq.mini.apkg.MiniAppInfo.from(paramSimpleMiniAppConfig.config.stApiAppInfo);
      }
      else
      {
        localObject = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).appId = paramSimpleMiniAppConfig.config.appId;
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).name = paramSimpleMiniAppConfig.config.name;
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).iconUrl = paramSimpleMiniAppConfig.config.iconUrl;
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).verType = paramSimpleMiniAppConfig.config.verType;
        ((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject).via = paramSimpleMiniAppConfig.config.via;
      }
      Object localObject = new MiniAppConfig((com.tencent.mobileqq.mini.apkg.MiniAppInfo)localObject);
      ((MiniAppConfig)localObject).launchParam = new LaunchParam();
      ((MiniAppConfig)localObject).launchParam.scene = paramSimpleMiniAppConfig.launchParam.scene;
      ((MiniAppConfig)localObject).launchParam.miniAppId = paramSimpleMiniAppConfig.launchParam.miniAppId;
      ((MiniAppConfig)localObject).launchParam.reportData = paramSimpleMiniAppConfig.launchParam.reportData;
      paramSimpleMiniAppConfig = (SimpleMiniAppConfig)localObject;
    }
    else
    {
      paramSimpleMiniAppConfig = null;
    }
    MiniProgramLpReportDC04239.reportAsync(paramSimpleMiniAppConfig, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void report4239Async(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    MiniProgramLpReportDC04239.reportAsync(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void report4239AsyncBySdkMiniAppInfo(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramObject instanceof com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)) {
      paramObject = new MiniAppConfig(MiniSdkLauncher.convert((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramObject));
    } else {
      paramObject = null;
    }
    MiniProgramLpReportDC04239.reportAsync(paramObject, paramString1, paramString2, paramString3, paramString4);
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
  
  public void reportColorNoteExpoForMiniApp(String paramString, boolean paramBoolean)
  {
    String str2;
    String str1;
    if (paramBoolean)
    {
      str2 = "addRecentColorSign";
      str1 = "recentColorSign_enter";
    }
    else
    {
      str2 = "addColorSign";
      str1 = "colorSign_enter";
    }
    if (paramString.contains("#@#"))
    {
      paramString = paramString.split("#@#");
      if (paramString.length == 2) {
        report4239AsyncBySdkMiniAppInfo(getFakeMiniAppInfoForReport(paramString[0], paramString[1]), str2, str1, "expo", null);
      }
    }
    else
    {
      report4239Async(str2, str1, "expo", null, null, null);
    }
  }
  
  public void reportColorSignClickAndStartMiniApp(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    reportColorSignClick(paramInt, getFakeMiniAppInfoForReport(paramString1, paramString3));
    paramString2 = SimpleMiniAppConfig.SimpleLaunchParam.standardEntryPath(paramString2);
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startAppByAppid(paramContext, paramString1, paramString2, paramString3, paramInt, null);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("startMiniApp, appId: ");
      paramContext.append(paramString1);
      paramContext.append(", entryPath: ");
      paramContext.append(paramString2);
      paramContext.append(", versionType: ");
      paramContext.append(paramString3);
      paramContext.append(", colorSignScene: ");
      paramContext.append(paramInt);
      QLog.d("MiniAppServiceImpl", 2, paramContext.toString());
    }
  }
  
  public void reportColorSignClickWithNoAppInfo(int paramInt)
  {
    if (paramInt == 1132)
    {
      report4239Async("addRecentColorSign", "recentColorSign_enter", "click", null, null, null);
      return;
    }
    report4239Async("addColorSign", "colorSign_enter", "click", null, null, null);
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
  
  public void searchApp(COMM.StCommonExt paramStCommonExt, String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().searchApp(paramStCommonExt, paramString, paramMiniAppCmdInterface);
  }
  
  public void sendUserAppListRequest(Manager paramManager, long paramLong1, long paramLong2)
  {
    if ((paramManager instanceof MiniAppUserAppInfoListManager)) {
      ((MiniAppUserAppInfoListManager)paramManager).sendUserAppListRequest(paramLong1, paramLong2);
    }
  }
  
  public void shareAsArkMessage(Activity paramActivity, MiniArkShareModel paramMiniArkShareModel)
  {
    ShareQQArkHelper.a(paramActivity, paramMiniArkShareModel, null);
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
    if (paramSimpleMiniAppConfig != null)
    {
      if (paramSimpleMiniAppConfig.config == null) {
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
  }
  
  public void startAppByAppid(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (paramMiniAppLaunchListener != null) {
      paramMiniAppLaunchListener = new MiniAppServiceImpl.4(this, paramMiniAppLaunchListener);
    } else {
      paramMiniAppLaunchListener = null;
    }
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = paramInt;
    MiniAppController.startAppByAppid(paramContext, paramString1, paramString2, paramString3, localLaunchParam, paramMiniAppLaunchListener);
  }
  
  public void startAppByLink(Context paramContext, String paramString, int paramInt1, int paramInt2, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (paramMiniAppLaunchListener != null) {
      paramMiniAppLaunchListener = new MiniAppServiceImpl.3(this, paramMiniAppLaunchListener);
    } else {
      paramMiniAppLaunchListener = null;
    }
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = paramInt2;
    MiniAppController.startAppByLink(paramContext, paramString, paramInt1, localLaunchParam, paramMiniAppLaunchListener);
  }
  
  public boolean startMiniApp(Context paramContext, String paramString, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    return startMiniApp(paramContext, paramString, paramInt, null, paramMiniAppLaunchListener);
  }
  
  public boolean startMiniApp(Context paramContext, String paramString, int paramInt, EntryModel paramEntryModel, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (paramMiniAppLaunchListener != null) {
      paramMiniAppLaunchListener = new MiniAppServiceImpl.2(this, paramMiniAppLaunchListener);
    } else {
      paramMiniAppLaunchListener = null;
    }
    return MiniAppLauncher.startMiniApp(paramContext, paramString, paramInt, paramEntryModel, paramMiniAppLaunchListener);
  }
  
  public void submitSearchReportData()
  {
    ((MiniAppExposureManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).submitSearchReportData();
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
    if ((paramObject instanceof HBEntryBannerData)) {
      paramObject = (HBEntryBannerData)paramObject;
    } else {
      paramObject = null;
    }
    ((DesktopDataManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).updateMiniHBBanner(paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl
 * JD-Core Version:    0.7.0.1
 */