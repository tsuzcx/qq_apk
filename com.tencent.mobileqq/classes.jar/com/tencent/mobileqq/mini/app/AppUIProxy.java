package com.tencent.mobileqq.mini.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import apkn;
import aple;
import avry;
import bhpc;
import bjeo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.swipeback.PostTable;
import com.tencent.mobileqq.mini.MiniCrashHandler;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.page.BrandPagePool;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment;
import com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.MiniAppSubProcessorInfo;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;
import com.tencent.mobileqq.mini.report.MiniGdtReporter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

public class AppUIProxy
  implements IAppUIProxy
{
  public static final String TAG = "miniapp-start_AppUIProxy";
  public static AppBrandFragment sCacheAppBrandFragment;
  protected boolean doNotMoveTaskToBackThisTime;
  private boolean hasCompletedLoading;
  private long loadCompleteTimeForLoadingAdReport;
  private AppBrandFragment mAppBrandFragment;
  private AppLoadingUI mAppLoadingUI;
  protected apkn mColorNoteController;
  private FragmentManager mFragmentManager;
  private Intent mIntent;
  public PostTable mPostTable;
  private AppUIProxy.AppBrandCommonReceiver mReceiver;
  private long onShowTime;
  
  private AppBrandLaunchManager.MiniAppSubProcessorInfo getCurrentProcessorInfo()
  {
    String str = BaseApplicationImpl.getApplication().getQQProcessName();
    if (str != null) {
      return (AppBrandLaunchManager.MiniAppSubProcessorInfo)AppBrandLaunchManager.subProcessorInfoMap.get(str);
    }
    return null;
  }
  
  private void initOnIntentChanged()
  {
    MiniAppConfig localMiniAppConfig = (MiniAppConfig)this.mIntent.getParcelableExtra("CONFIG");
    StringBuilder localStringBuilder;
    if (localMiniAppConfig != null)
    {
      AppBrandProxy.g().setMiniAppConfig(localMiniAppConfig);
      MiniAppClientQIPCModule.getQIPCModule().attachData(localMiniAppConfig.config.appId, localMiniAppConfig.config.verType);
      localStringBuilder = new StringBuilder().append("initOnCreateOrNewIntent ");
      if ((localMiniAppConfig == null) || (localMiniAppConfig.launchParam == null)) {
        break label93;
      }
    }
    label93:
    for (long l = localMiniAppConfig.launchParam.timestamp;; l = -1L)
    {
      QLog.i("miniapp-start_AppUIProxy", 1, l);
      return;
    }
  }
  
  private void notifyEvent(MiniAppConfig paramMiniAppConfig, String paramString, long paramLong)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.launchParam == null) || (paramMiniAppConfig.config == null)) {
      return;
    }
    String str = paramMiniAppConfig.config.appId;
    int i = paramMiniAppConfig.launchParam.scene;
    paramMiniAppConfig = paramMiniAppConfig.config.via;
    Bundle localBundle = new Bundle();
    localBundle.putString("key_appid", str);
    localBundle.putInt("key_scene", i);
    localBundle.putString("key_via", paramMiniAppConfig);
    localBundle.putString("key_event", paramString);
    localBundle.putLong("key_timestamp", paramLong);
    AppBrandProxy.g().sendCmd("cmd_notify_event_info", localBundle, null);
  }
  
  private void processSelectLoadingAdLogic(BaseActivity paramBaseActivity, MiniAppConfig paramMiniAppConfig)
  {
    long l = System.currentTimeMillis();
    MiniLoadingAdManager.getInstance().selectAd(paramMiniAppConfig, String.valueOf(bhpc.a().a()), new AppUIProxy.3(this, l, paramMiniAppConfig, paramBaseActivity));
  }
  
  private void recoveryIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((MiniAppConfig)paramIntent.getParcelableExtra("CONFIG") == null)
        {
          MiniAppConfig localMiniAppConfig = bjeo.a((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO"));
          if (localMiniAppConfig != null)
          {
            paramIntent.putExtra("CONFIG", localMiniAppConfig);
            return;
          }
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("miniapp-start_AppUIProxy", 1, "recoveryIntent exception!", paramIntent);
      }
    }
  }
  
  private void updateLoadingAdUI(BaseActivity paramBaseActivity, MiniAppConfig paramMiniAppConfig, String paramString, GdtAd paramGdtAd)
  {
    if (paramBaseActivity == null) {
      return;
    }
    paramBaseActivity.runOnUiThread(new AppUIProxy.4(this, paramBaseActivity, paramMiniAppConfig, paramString, paramGdtAd));
  }
  
  public void completeLoading(BaseActivity paramBaseActivity)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "completeLoading");
    if (!this.hasCompletedLoading) {
      MiniLoadingAdManager.getInstance().preloadLoadingAd(AppBrandProxy.g().getMiniAppConfig(), String.valueOf(bhpc.a().a()));
    }
    this.hasCompletedLoading = true;
    this.loadCompleteTimeForLoadingAdReport = System.currentTimeMillis();
    if ((this.mAppLoadingUI != null) && (this.mAppLoadingUI.isForeground()))
    {
      this.mAppLoadingUI.onStop();
      if (this.mAppBrandFragment != null)
      {
        this.mAppBrandFragment.onResume();
        this.mAppBrandFragment.completeLoading();
      }
    }
  }
  
  public boolean doBeforeOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "doBeforeOnCreate");
    paramBaseActivity.mActNeedImmersive = false;
    return true;
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    Fragment localFragment = getCurrentFragment();
    if ((localFragment != null) && ((localFragment instanceof AppBrandFragment))) {
      return ((AppBrandFragment)localFragment).doDispatchKeyEvent(paramKeyEvent);
    }
    return false;
  }
  
  public void doOnActivityResult(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    paramBaseActivity = getCurrentFragment();
    if (paramBaseActivity != null) {
      paramBaseActivity.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "doOnBackPressed");
    if ((this.mAppLoadingUI != null) && (this.mAppLoadingUI.isForeground()))
    {
      this.mAppLoadingUI.doOnBackPressed(paramBoolean);
      paramBaseActivity.finish();
    }
    do
    {
      return;
      paramBaseActivity = getCurrentFragment();
    } while ((paramBaseActivity == null) || (!(paramBaseActivity instanceof AppBrandFragment)));
    ((AppBrandFragment)paramBaseActivity).doOnBackPressed(paramBoolean);
  }
  
  public boolean doOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    EngineChannel localEngineChannel = null;
    QLog.i("miniapp-start_AppUIProxy", 1, "doOnCreate");
    paramBaseActivity.setContentView(getLayoutResourceId());
    paramBundle = paramBaseActivity.getWindow();
    if (paramBundle != null) {
      paramBundle.setSoftInputMode(18);
    }
    AppBrandRuntimeContainer.g().attachToActivity(paramBaseActivity);
    if (sCacheAppBrandFragment != null) {}
    for (paramBundle = sCacheAppBrandFragment;; paramBundle = new AppBrandFragment())
    {
      this.mAppBrandFragment = paramBundle;
      paramBundle = (ViewGroup)paramBaseActivity.findViewById(2131370293);
      if (paramBundle != null)
      {
        this.mAppLoadingUI = new AppLoadingUI(paramBaseActivity);
        this.mAppLoadingUI.initUI(paramBundle);
      }
      this.mIntent = paramBaseActivity.getIntent();
      recoveryIntent(this.mIntent);
      this.mFragmentManager = paramBaseActivity.getFragmentManager();
      this.mAppBrandFragment.setArgumentBundle(this.mIntent.getExtras());
      this.mFragmentManager.beginTransaction().replace(2131367133, this.mAppBrandFragment).commit();
      this.mReceiver = new AppUIProxy.AppBrandCommonReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mini.CreateShortcutSucceedReceiver");
      paramBaseActivity.registerReceiver(this.mReceiver, paramBundle);
      Bundle localBundle = this.mIntent.getExtras();
      paramBundle = localEngineChannel;
      if (localBundle != null) {}
      try
      {
        paramBundle = (MiniAppConfig)localBundle.getParcelable("CONFIG");
        localEngineChannel = (EngineChannel)this.mIntent.getParcelableExtra("engineChannel");
        avry.a().a(localEngineChannel);
        avry.a().a(paramBundle, null);
        MiniAppClientQIPCModule.registerModule();
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          QLog.e("miniapp-start_AppUIProxy", 1, "", paramBundle);
        }
      }
      initOnIntentChanged();
      this.mColorNoteController = new apkn(paramBaseActivity, false, true);
      this.mColorNoteController.a(paramBaseActivity);
      this.mColorNoteController.a(this);
      this.mColorNoteController.a(new AppUIProxy.1(this, paramBaseActivity));
      this.mColorNoteController.a(new AppUIProxy.2(this, paramBaseActivity));
      this.mPostTable = new PostTable(paramBaseActivity);
      ((ViewGroup)paramBaseActivity.getWindow().getDecorView()).addView(this.mPostTable);
      this.mPostTable.setVisibility(4);
      this.mPostTable.a(0.0D);
      return true;
    }
  }
  
  public void doOnDestroy(BaseActivity paramBaseActivity)
  {
    Object localObject2 = null;
    QLog.i("miniapp-start_AppUIProxy", 1, "doOnDestroy");
    for (;;)
    {
      try
      {
        AppBrandRuntime localAppBrandRuntime = AppBrandRuntimeContainer.g().getCurrentAppBrandRuntime();
        Object localObject1 = localObject2;
        if (localAppBrandRuntime != null)
        {
          localObject1 = localObject2;
          if (localAppBrandRuntime.apkgInfo != null) {
            localObject1 = localAppBrandRuntime.apkgInfo.appConfig;
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.mAppBrandFragment.getMiniConfig();
        }
        if (localObject2 == null) {
          continue;
        }
        if ((localAppBrandRuntime == null) || (localAppBrandRuntime.getBootState() != 2)) {
          continue;
        }
        QLog.i("miniapp-start_AppUIProxy", 1, "no need report loading_page_kill : state:" + localAppBrandRuntime.getBootState());
      }
      catch (Throwable paramBaseActivity)
      {
        QLog.e("miniapp-start_AppUIProxy", 1, "exception when doOnDestroy.", paramBaseActivity);
        continue;
        QLog.e("miniapp-start_AppUIProxy", 1, "no need report loading_page_kill : appConfig is null");
        continue;
      }
      paramBaseActivity.unregisterReceiver(this.mReceiver);
      AppBrandRuntimeContainer.g().detachFromActivity(paramBaseActivity);
      AppBrandRuntimeContainer.g().cleanup();
      BrandPagePool.g().cleanup();
      if (this.mAppBrandFragment != null) {
        this.mAppBrandFragment.doOnDestroy();
      }
      this.mColorNoteController.c();
      QLog.i("miniapp-start_AppUIProxy", 1, "doOnDestroy");
      return;
      QLog.i("miniapp-start_AppUIProxy", 1, "report loadfail    loading_page_kill");
      MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject2, "0", null, "load_fail", "loading_page_kill");
      MiniAppReportManager2.reportPageView("2launch_fail", "loading_page_kill", null, (MiniAppConfig)localObject2);
    }
  }
  
  public void doOnNewIntent(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "doOnNewIntent");
    this.mIntent = paramIntent;
    recoveryIntent(this.mIntent);
    initOnIntentChanged();
  }
  
  public void doOnPause(BaseActivity paramBaseActivity)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "doOnPause");
    getCurrentFragment();
    MiniAppConfig localMiniAppConfig = AppBrandProxy.g().getMiniAppConfig();
    if (localMiniAppConfig != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("app_config", localMiniAppConfig);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "launch_report_app_pause", localBundle);
      long l = System.currentTimeMillis() - this.onShowTime;
      MiniAppReportManager2.reportPageView("2hide", String.valueOf(l), null, localMiniAppConfig);
      notifyEvent(localMiniAppConfig, "onPause", System.currentTimeMillis());
      if ((this.onShowTime > 0L) && (l > 0L)) {
        MiniReportManager.reportEventType(localMiniAppConfig, 644, null, null, null, 0, "0", l, null);
      }
      QLog.e("miniapp-start_AppUIProxy", 1, "miniappstaytime: cost:" + l);
      MiniGamePerformanceStatics.getInstance().stopReport(0.0F);
      this.onShowTime = 0L;
      GameGrowthGuardianManager.executeEnd(paramBaseActivity, localMiniAppConfig);
    }
  }
  
  public void doOnResume(BaseActivity paramBaseActivity)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "doOnResume");
    MiniAppConfig localMiniAppConfig = AppBrandProxy.g().getMiniAppConfig();
    this.onShowTime = System.currentTimeMillis();
    if (localMiniAppConfig != null)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelable("app_config", localMiniAppConfig);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "launch_report_app_resume", (Bundle)localObject1);
      if (this.mAppBrandFragment == null) {
        break label306;
      }
      localObject1 = this.mAppBrandFragment.getCurPath();
      Object localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = localObject1;
        if (localMiniAppConfig.config != null)
        {
          localObject2 = localObject1;
          if (localMiniAppConfig.config.firstPage != null) {
            localObject2 = localMiniAppConfig.config.firstPage.pagePath;
          }
        }
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = "default.html";
        }
      }
      MiniAppReportManager2.reportPageView("2show", "bring_to_front", (String)localObject3, localMiniAppConfig);
      notifyEvent(localMiniAppConfig, "onResume", this.onShowTime);
      if (localMiniAppConfig.launchParam == null) {
        break label311;
      }
    }
    label306:
    label311:
    for (Object localObject1 = localMiniAppConfig.launchParam.entryPath;; localObject1 = "")
    {
      MiniReportManager.reportEventType(localMiniAppConfig, 1, (String)localObject1, null, null, 0);
      localObject1 = Thread.getDefaultUncaughtExceptionHandler();
      if ((localObject1 != null) && ((localObject1 instanceof MiniCrashHandler))) {
        ((MiniCrashHandler)localObject1).setMiniAppConfig(localMiniAppConfig);
      }
      MiniGamePerformanceStatics.getInstance().setGameConfig(localMiniAppConfig);
      MiniGamePerformanceStatics.getInstance().startReport();
      if (this.mIntent != null)
      {
        this.mAppBrandFragment.setArgumentBundle(this.mIntent.getExtras());
        MiniGdtReporter.prepareReport();
        MiniGdtReporter.report(localMiniAppConfig, 0);
      }
      if (!this.mAppBrandFragment.isAdded()) {
        this.mFragmentManager.beginTransaction().replace(2131367133, this.mAppBrandFragment).commitAllowingStateLoss();
      }
      this.mIntent = null;
      this.mColorNoteController.a();
      GameGrowthGuardianManager.executeBegin(paramBaseActivity, localMiniAppConfig);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public void doOnStart(BaseActivity paramBaseActivity)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "doOnStart");
  }
  
  public void doOnStop(BaseActivity paramBaseActivity)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "doOnStop");
    AppLoaderFactory.getAppLoaderManager().preloadNextRuntime();
    this.mColorNoteController.b();
  }
  
  public void doRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "doRefreshMiniBadge");
    paramBaseActivity = getCurrentFragment();
    if ((paramBaseActivity != null) && ((paramBaseActivity instanceof AppBrandFragment))) {
      ((AppBrandFragment)paramBaseActivity).doRefreshMiniBadge(paramBundle);
    }
  }
  
  public void finish(BaseActivity paramBaseActivity)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "finish");
    AnimUtil.setCloseAnim(paramBaseActivity);
  }
  
  public Fragment getAppBrandFragment()
  {
    return this.mAppBrandFragment;
  }
  
  public ColorNote getColorNote()
  {
    MiniAppConfig localMiniAppConfig = AppBrandProxy.g().getMiniAppConfig();
    if ((localMiniAppConfig == null) || (localMiniAppConfig.config == null))
    {
      QLog.e("miniapp-start_AppUIProxy", 1, "getColorNote, appConfig: " + localMiniAppConfig);
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("miniapp-start_AppUIProxy", 2, "getColorNote, appId: " + localMiniAppConfig.config.appId + ", name: " + localMiniAppConfig.config.name);
    }
    byte[] arrayOfByte = MiniAppUtils.packMiniAppInfo(localMiniAppConfig.config);
    return new aple().a(16842752).a(localMiniAppConfig.config.appId).b(localMiniAppConfig.config.name).c(localMiniAppConfig.config.desc).d(localMiniAppConfig.config.iconUrl).a(arrayOfByte).a();
  }
  
  public apkn getColorNoteController()
  {
    return this.mColorNoteController;
  }
  
  protected Fragment getCurrentFragment()
  {
    return this.mFragmentManager.findFragmentById(2131367133);
  }
  
  protected int getLayoutResourceId()
  {
    return 2131559401;
  }
  
  public boolean isWrapContent(BaseActivity paramBaseActivity)
  {
    if (this.mAppBrandFragment != null) {
      return this.mAppBrandFragment.isWrapContent();
    }
    return false;
  }
  
  public boolean moveTaskToBack(BaseActivity paramBaseActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBaseActivity == null)
    {
      QLog.i("miniapp-start_AppUIProxy", 1, "moveTaskToBack activity is null.");
      return false;
    }
    BaseActivity localBaseActivity = paramBaseActivity;
    if (paramBaseActivity.isFinishing())
    {
      localBaseActivity = paramBaseActivity;
      if (this.mAppBrandFragment != null)
      {
        localBaseActivity = paramBaseActivity;
        if (this.mAppBrandFragment.getActivity() != null)
        {
          localBaseActivity = paramBaseActivity;
          if (!this.mAppBrandFragment.getActivity().isFinishing()) {
            localBaseActivity = (BaseActivity)this.mAppBrandFragment.getActivity();
          }
        }
      }
    }
    boolean bool3 = this.mColorNoteController.c();
    boolean bool2;
    if (bool3)
    {
      this.mColorNoteController.d();
      bool2 = true;
    }
    for (;;)
    {
      paramBaseActivity = AppBrandProxy.g().getMiniAppConfig();
      if ((paramBaseActivity != null) && (!paramBaseActivity.isLimitedAccessApp())) {
        this.mColorNoteController.n();
      }
      QLog.d("miniapp-start_AppUIProxy", 1, "moveTaskToBack nonRoot=" + paramBoolean1 + " bAnim=" + paramBoolean2 + ", isColorNoteExist = " + bool3);
      return bool2;
      try
      {
        bool1 = localBaseActivity.moveTaskToBack(paramBoolean1);
        bool2 = bool1;
        if (!paramBoolean2) {
          continue;
        }
        AnimUtil.setCloseAnim(localBaseActivity);
        bool2 = bool1;
      }
      catch (Exception paramBaseActivity)
      {
        for (;;)
        {
          QLog.e("miniapp-start_AppUIProxy", 1, "moveTaskToBack exception", paramBaseActivity);
          boolean bool1 = true;
        }
      }
    }
  }
  
  public void onProcessBackground(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "onProcessBackground");
  }
  
  public void onProcessForeGround(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "onProcessForeGround");
  }
  
  public void onRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "onRefreshMiniBadge");
  }
  
  public void setColorNoteWithOutMoveTaskToBackThisTime()
  {
    this.doNotMoveTaskToBackThisTime = true;
  }
  
  public void startLoading(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppUIProxy", 1, "startLoading");
    this.hasCompletedLoading = false;
    if (this.mAppLoadingUI != null)
    {
      this.mAppLoadingUI.setArgumentBundle(paramBundle);
      this.mAppLoadingUI.onResume();
    }
    processSelectLoadingAdLogic(paramBaseActivity, AppBrandProxy.g().getMiniAppConfig());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppUIProxy
 * JD-Core Version:    0.7.0.1
 */