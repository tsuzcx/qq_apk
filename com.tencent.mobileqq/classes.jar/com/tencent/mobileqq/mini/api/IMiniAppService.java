package com.tencent.mobileqq.mini.api;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.mobileqq.mini.push.MiniAppControlInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

@QAPI(process={"all"})
public abstract interface IMiniAppService
  extends QRouteApi
{
  public static final int TYPE_HIDE_PULL_DOWN_ENTRY = 100;
  
  public abstract void addDesktopChangeListener(MiniAppPullInterface paramMiniAppPullInterface, DesktopChangeListener paramDesktopChangeListener);
  
  public abstract void addMiniProgramReportData(Object paramObject);
  
  public abstract void addSearchItemAndCheckReport(SimpleMiniAppConfig paramSimpleMiniAppConfig, String paramString1, String paramString2);
  
  public abstract void addSearchItemAndCheckReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract boolean asyncShareMiniProgram(Object paramObject);
  
  public abstract void checkPreloadMiniApp();
  
  public abstract BaseContactsMiniAppEntryManager createContactsMiniAppEntryManager(Context paramContext, AppRuntime paramAppRuntime, RelativeLayout paramRelativeLayout, int paramInt);
  
  public abstract Entity createDeskTopAppEntity();
  
  public abstract Manager createMiniAppEntityManager(String paramString);
  
  public abstract MiniAppPullInterface createMiniAppEntryManager(boolean paramBoolean, Activity paramActivity, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, ViewGroup paramViewGroup);
  
  public abstract AppRuntime createMiniAppInterface(MobileQQ paramMobileQQ, String paramString);
  
  public abstract BaseMiniAppProfileCardView createMiniAppProfileCardView(Context paramContext);
  
  public abstract Object createMiniAppWebViewPlugin();
  
  public abstract Object createMiniGamePublicAccountWebViewJsPlugin();
  
  public abstract void createUpdatableMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, byte[] paramArrayOfByte, MiniAppCmdInterface paramMiniAppCmdInterface);
  
  public abstract void doClearAfterLoginSuccess(boolean paramBoolean);
  
  public abstract boolean enableHttp2();
  
  public abstract void forwardShareWithTryCatch(Context paramContext, HashMap<String, String> paramHashMap, Bundle paramBundle, Intent paramIntent);
  
  public abstract Class getApkgConfigManagerClass();
  
  public abstract Class getAppBrandLaunchUIClass();
  
  public abstract Class getAppBrandUIClass();
  
  public abstract void getAppInfoById(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, String paramString4, MiniAppCmdInterface paramMiniAppCmdInterface);
  
  public abstract void getAppInfoByLink(String paramString, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface);
  
  public abstract Class getDeskTopAppEntityClass();
  
  public abstract Class getDesktopCardEntityClass();
  
  public abstract Class getDesktopDataManagerClass();
  
  public abstract byte[] getGetFriendPlayListV2RequestBusiBuf(String paramString, int paramInt);
  
  public abstract byte[] getGetUserAppListRequestBusiBuf(long paramLong1, long paramLong2);
  
  public abstract void getHotSearchApps(COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface);
  
  public abstract Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void getKuolieAppList(COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface);
  
  public abstract List<MiniAppLocalSearchEntity> getLocalSearchData();
  
  public abstract long getMemeryUsage();
  
  public abstract QIPCModule getMiniAppBannerIPCModule();
  
  public abstract Class getMiniAppEntityClass();
  
  public abstract Class getMiniAppEntryHandlerClass();
  
  public abstract Class getMiniAppExposureManagerClass();
  
  public abstract Class getMiniAppGameDebugSettingFragmentClass();
  
  public abstract Class getMiniAppLocalSearchManagerClass();
  
  public abstract Class getMiniAppSearchDataManagerClass();
  
  public abstract Class getMiniAppSearchFragmentClass();
  
  public abstract QIPCModule getMiniAppTransferModule();
  
  public abstract Class getMiniAppUserAppInfoListManagerClass();
  
  public abstract QIPCModule getMiniGamePublicAccountIPCModule();
  
  public abstract Object getPhotoLocalMediaInfoByPath(String paramString);
  
  public abstract Class getPublicFragmentActivityForMiniClass();
  
  public abstract String getTmpPathFromOut(String paramString1, String paramString2);
  
  public abstract void guessYouLike(COMM.StCommonExt paramStCommonExt, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface);
  
  public abstract void handleMiniAppMoreClick(Activity paramActivity);
  
  public abstract void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent);
  
  public abstract boolean isDebugMiniApp(String paramString);
  
  public abstract boolean isMiniAppFakeUrl(String paramString);
  
  public abstract boolean isMiniAppScheme(String paramString);
  
  public abstract boolean isMiniAppUrl(String paramString);
  
  public abstract boolean isSharingMiniProgram(HashMap<String, String> paramHashMap);
  
  public abstract boolean isTroopAdminOrCreated();
  
  public abstract void launchAppByMiniCode(Context paramContext, String paramString, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener);
  
  public abstract void launchMainPageFragment(Context paramContext, Parcelable paramParcelable, int paramInt);
  
  public abstract void launchMainPageFragmentForMiniGame(Context paramContext, Parcelable paramParcelable, int paramInt, boolean paramBoolean);
  
  public abstract void launchMiniAppByApiAppInfo(@NonNull Activity paramActivity, @NonNull INTERFACE.StApiAppInfo paramStApiAppInfo, int paramInt);
  
  public abstract void launchMiniAppByAppInfo(Activity paramActivity, INTERFACE.StUserAppInfo paramStUserAppInfo, int paramInt);
  
  public abstract void launchMiniAppById(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener);
  
  public abstract boolean launchMiniAppByScheme(Context paramContext, HashMap<String, String> paramHashMap, int paramInt, EntryModel paramEntryModel, MiniAppLaunchListener paramMiniAppLaunchListener);
  
  public abstract void launchMiniGamePublicAccount(Context paramContext);
  
  public abstract void launchMiniGamePublicAccount(Context paramContext, String paramString);
  
  public abstract void launchPermissionSettingFragmentForResult(Activity paramActivity, String paramString1, String paramString2, int paramInt);
  
  public abstract void onDexConfigUpdate(String paramString);
  
  public abstract void onEnterBackground();
  
  public abstract void onEnterForeground();
  
  public abstract void onMiniGameCardShowMoreView(String paramString, int paramInt1, int paramInt2);
  
  public abstract void performUploadArkShareImage(String paramString, IMiniCallback paramIMiniCallback);
  
  public abstract void preLaunchMiniAppCheckinFromLeba();
  
  public abstract void prePullAppinfoByLink(String paramString, int paramInt, boolean paramBoolean, IPrePullListener paramIPrePullListener);
  
  public abstract void prePullAppinfoByLink(String paramString, boolean paramBoolean, IPrePullListener paramIPrePullListener);
  
  public abstract void preloadMiniProcess();
  
  public abstract void processControlInfo(String paramString, MiniAppControlInfo paramMiniAppControlInfo);
  
  public abstract void removeDesktopChangeListener(MiniAppPullInterface paramMiniAppPullInterface, DesktopChangeListener paramDesktopChangeListener);
  
  public abstract void report4239Async(SimpleMiniAppConfig paramSimpleMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void report4239Async(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void report4239AsyncBySdkMiniAppInfo(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void reportByQQ(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract void reportByQQ(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
  
  public abstract void reportByQQqunInfo(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void reportColorNoteExpoForMiniApp(String paramString, boolean paramBoolean);
  
  public abstract void reportColorSignClickAndStartMiniApp(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void reportColorSignClickWithNoAppInfo(int paramInt);
  
  public abstract void reportEshopExpo(String paramString1, String paramString2);
  
  public abstract void reportMiniAppExposureData(SimpleMiniAppConfig paramSimpleMiniAppConfig, int paramInt);
  
  public abstract void reportNavigatorbarExpose();
  
  public abstract void reportProfileCardExposed(Object paramObject, boolean paramBoolean);
  
  public abstract void reportShare(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2);
  
  public abstract void searchApp(COMM.StCommonExt paramStCommonExt, String paramString, MiniAppCmdInterface paramMiniAppCmdInterface);
  
  public abstract void sendUserAppListRequest(Manager paramManager, long paramLong1, long paramLong2);
  
  public abstract void shareAsArkMessage(Activity paramActivity, MiniArkShareModel paramMiniArkShareModel);
  
  public abstract void shareAsQzoneFeeds(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4, String paramString8, String paramString9, MiniAppCmdInterface paramMiniAppCmdInterface);
  
  public abstract boolean shouldOpenWebFragment(String paramString);
  
  public abstract void splashMiniGameClickReport(SplashMiniGameData paramSplashMiniGameData);
  
  public abstract void startApp(Activity paramActivity, SimpleMiniAppConfig paramSimpleMiniAppConfig, ResultReceiver paramResultReceiver);
  
  public abstract void startAppByAppid(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener);
  
  public abstract void startAppByLink(Context paramContext, String paramString, int paramInt1, int paramInt2, MiniAppLaunchListener paramMiniAppLaunchListener);
  
  public abstract boolean startMiniApp(Context paramContext, String paramString, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener);
  
  public abstract boolean startMiniApp(Context paramContext, String paramString, int paramInt, EntryModel paramEntryModel, MiniAppLaunchListener paramMiniAppLaunchListener);
  
  public abstract void submitSearchReportData();
  
  public abstract void updateDataDbFromNetResultInLocalSearchManager(MiniAppLocalSearchEntity paramMiniAppLocalSearchEntity);
  
  public abstract void updateMiniAppList(int paramInt);
  
  public abstract void updateMiniDesktopBackground(MiniAppPullInterface paramMiniAppPullInterface, Drawable paramDrawable);
  
  public abstract void updateMiniHBBanner(Object paramObject);
  
  public abstract Object validMoodInfo(Object paramObject);
  
  public abstract boolean verifyArkScene(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.IMiniAppService
 * JD-Core Version:    0.7.0.1
 */