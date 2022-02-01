package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.DebugInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.app.IAppUIProxy;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateObserver;
import com.tencent.mobileqq.mini.app.PreCacheManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.KeyboardObserver;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.jsapi.AdFrequencyLimit;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.mini.utils.NavigateBackUtils;
import com.tencent.mobileqq.mini.widget.input.WebInputHandler;
import com.tencent.mobileqq.mini.widget.input.WebInputHandler.KeyboardHiddenObserver;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import java.util.LinkedList;

public class AppBrandFragment
  extends ReportFragment
  implements INetEventHandler
{
  public static final String TAG = "AppBrandFragment";
  private static boolean isFirstStart;
  AppBrandRuntimeContainer appBrandRuntimeContainer;
  private boolean isLoadFail;
  private AppBrandRuntime.KeyboardObserver keyboardObserver;
  private Bundle mBundle;
  private SoftKeyboardStateHelper.SoftKeyboardStateListener mListener = new AppBrandFragment.1(this);
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private SoftKeyboardStateHelper mSoftKeyboardStateHelper;
  protected MiniAppConfig miniConfig;
  private boolean needResume = true;
  private FrameLayout rootFrameLayout = new FrameLayout(BaseApplicationImpl.getContext());
  MiniAppStateManager.MiniAppStateObserver stateObserver = new AppBrandFragment.6(this);
  
  public AppBrandFragment()
  {
    this.rootFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    isFirstStart = true;
  }
  
  private void changeWindowInfo(MiniAppConfig paramMiniAppConfig)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while ((paramMiniAppConfig == null) || (paramMiniAppConfig.isInternalApp())) {
      return;
    }
    ThreadManagerV2.excute(new AppBrandFragment.3(this, paramMiniAppConfig, getActivity()), 16, null, false);
  }
  
  private void onLoadFail()
  {
    this.isLoadFail = false;
    if (this.appBrandRuntimeContainer.getAppBrandRuntimeSize() < 1) {
      finish();
    }
  }
  
  private void registComponentCallback()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      getActivity().registerComponentCallbacks(new AppBrandFragment.2(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void showKingCardGuideAfterPageLoaded()
  {
    AppBrandRuntime localAppBrandRuntime = this.appBrandRuntimeContainer.peek();
    if ((localAppBrandRuntime != null) && (localAppBrandRuntime.pageContainer != null) && (localAppBrandRuntime.pageContainer.getCurrentPage() != null) && (localAppBrandRuntime.pageContainer.getCurrentPage().getNavBar() != null) && (localAppBrandRuntime.pageContainer.getCurrentPage().getNavBar().getCapsuleButton() != null)) {
      localAppBrandRuntime.pageContainer.getCurrentPage().getNavBar().getCapsuleButton().showKingCardTips();
    }
  }
  
  private void syncForceGroundAndRefreshBadge()
  {
    ThreadManagerV2.excute(new AppBrandFragment.7(this, getActivity()), 16, null, true);
  }
  
  public void completeLoading()
  {
    showKingCardGuideAfterPageLoaded();
    AdFrequencyLimit.setOnStartTime(System.currentTimeMillis());
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppBrandRuntime localAppBrandRuntime = this.appBrandRuntimeContainer.peek();
    if ((localAppBrandRuntime != null) && (localAppBrandRuntime.pageContainer != null) && (localAppBrandRuntime.pageContainer.getCurrentPageWebview() != null)) {
      return localAppBrandRuntime.pageContainer.getCurrentPageWebview().doDispatchKeyEvent(paramKeyEvent);
    }
    return false;
  }
  
  public void doOnBackPressed(boolean paramBoolean)
  {
    int i = this.appBrandRuntimeContainer.getAppBrandRuntimeSize();
    QLog.d("AppBrandFragment", 1, "onBackPressed appBrandRuntimeSize=" + i);
    if (i > 0)
    {
      if (paramBoolean) {
        MiniAppReportManager2.reportPageView("2back_key", "inner_page", null, getMiniConfig());
      }
      AppBrandRuntime localAppBrandRuntime = this.appBrandRuntimeContainer.peek();
      if (localAppBrandRuntime.pageContainer.handleBackPressed()) {
        return;
      }
      i = localAppBrandRuntime.pageContainer.getPageCount();
      QLog.d("AppBrandFragment", 1, "onBackPressed pageCount=" + i);
      if (i > 1)
      {
        localAppBrandRuntime.pageContainer.navigateBack(1, true);
        return;
      }
      AppLoaderFactory.getAppUIProxy().moveTaskToBack((BaseActivity)getActivity(), true, true);
      return;
    }
    finish();
  }
  
  public void doOnDestroy()
  {
    MiniAppStateManager.getInstance().deleteObserver(this.stateObserver);
    AppNetConnInfo.unregisterNetEventHandler(this);
  }
  
  public void doRefreshMiniBadge(Bundle paramBundle)
  {
    int i;
    if (paramBundle != null)
    {
      String str = paramBundle.getString("miniAppID");
      if (QLog.isColorLevel()) {
        QLog.d("TAG", 2, "appbrandfragment doRefreshMiniBadge appID : " + str + "； cur: " + this.miniConfig.config.appId);
      }
      if (this.miniConfig.config.appId.equals(str))
      {
        i = paramBundle.getInt("param_proc_badge_count");
        if (QLog.isColorLevel()) {
          QLog.e("AppBrandFragment", 2, "doRefreshMiniBadge badge : " + i);
        }
        paramBundle = this.appBrandRuntimeContainer.peek();
        if (paramBundle == null) {}
      }
    }
    try
    {
      if ((paramBundle.pageContainer != null) && (paramBundle.pageContainer.getCurrentPage() != null) && (paramBundle.pageContainer.getCurrentPage().getNavBar() != null) && (paramBundle.pageContainer.getCurrentPage().getNavBar().getCapsuleButton() != null)) {
        paramBundle.pageContainer.getCurrentPage().getNavBar().getCapsuleButton().setUnReadCount(i, false);
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("AppBrandFragment", 1, "doRefreshMiniBadge ", paramBundle);
      paramBundle.printStackTrace();
    }
  }
  
  public void finish()
  {
    QLog.d("AppBrandFragment", 1, "finish");
    AnimUtil.setCloseAnim(getActivity());
  }
  
  public Bundle getArgumentBundle()
  {
    return this.mBundle;
  }
  
  public String getCurPath()
  {
    if (this.miniConfig == null) {}
    do
    {
      return null;
      AppBrandRuntime localAppBrandRuntime = this.appBrandRuntimeContainer.getAppBrandRunTime(this.miniConfig.config);
      if ((localAppBrandRuntime != null) && (localAppBrandRuntime.getCurPage() != null)) {
        return localAppBrandRuntime.getCurPage().getUrl();
      }
    } while (this.miniConfig.launchParam == null);
    return this.miniConfig.launchParam.entryPath;
  }
  
  public MiniAppConfig getMiniConfig()
  {
    return this.miniConfig;
  }
  
  public boolean isWrapContent()
  {
    return (this.appBrandRuntimeContainer != null) && (this.appBrandRuntimeContainer.peek() != null) && (this.appBrandRuntimeContainer.peek().pageContainer != null) && (this.appBrandRuntimeContainer.peek().pageContainer.pageLinkedList != null) && (this.appBrandRuntimeContainer.peek().pageContainer.pageLinkedList.peek() != null) && (((AbsAppBrandPage)this.appBrandRuntimeContainer.peek().pageContainer.pageLinkedList.peek()).isHomePage());
  }
  
  protected void jumpToLoadingUI()
  {
    AppLoaderFactory.getAppUIProxy().startLoading((BaseActivity)getActivity(), getArgumentBundle());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    QLog.d("AppBrandFragment", 1, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {}
      for (;;)
      {
        this.isLoadFail = bool;
        return;
        bool = false;
      }
    }
    if ((paramInt1 == 1001) || (paramInt1 == 1002))
    {
      AppBrandRuntime localAppBrandRuntime = this.appBrandRuntimeContainer.peek();
      try
      {
        localAppBrandRuntime.pageContainer.getCurrentPage().getNavBar().getCapsuleButton().doOnActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("AppBrandFragment", 1, paramIntent, new Object[0]);
        paramIntent.printStackTrace();
        return;
      }
    }
    MiniAppController.getInstance().notifyResultListener(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("miniapp-start", 1, "AppBrandFragment onCreate");
    if (getActivity() != null)
    {
      getActivity().getWindow().addFlags(1);
      getActivity().getWindow().addFlags(16777216);
    }
    this.appBrandRuntimeContainer = AppBrandRuntimeContainer.g();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.rootFrameLayout == null)
    {
      this.rootFrameLayout = new FrameLayout(getActivity());
      this.rootFrameLayout.setContentDescription("AppBrandFragment-rootFrameLayout");
      this.rootFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    paramLayoutInflater = this.rootFrameLayout;
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    QLog.i("miniapp-start", 1, "onNetChangeEvent, " + paramBoolean);
    AppBrandRuntime localAppBrandRuntime = this.appBrandRuntimeContainer.peek();
    if ((localAppBrandRuntime != null) && (localAppBrandRuntime.pageContainer != null) && (localAppBrandRuntime.pageContainer.getCurrentPage() != null) && (localAppBrandRuntime.pageContainer.getCurrentPage().getNavBar() != null) && (localAppBrandRuntime.pageContainer.getCurrentPage().getNavBar().getCapsuleButton() != null)) {
      localAppBrandRuntime.pageContainer.getCurrentPage().getNavBar().getCapsuleButton().onNetChangeEvent(paramBoolean);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.d("AppBrandFragment", 1, "onPause");
    MiniAppConfig localMiniAppConfig;
    if (this.appBrandRuntimeContainer != null)
    {
      localObject = this.appBrandRuntimeContainer.peek();
      if ((localObject != null) && (((AppBrandRuntime)localObject).apkgInfo != null))
      {
        localMiniAppConfig = ((AppBrandRuntime)localObject).apkgInfo.appConfig;
        if (((AppBrandRuntime)localObject).pageContainer == null) {
          break label78;
        }
      }
    }
    label78:
    for (Object localObject = MiniProgramReportHelper.currentUrlFromAppBrandRuntime(((AppBrandRuntime)localObject).pageContainer.appBrandRuntime);; localObject = null)
    {
      MiniProgramLpReportDC04239.reportPageView(localMiniAppConfig, "0", (String)localObject, "hide", null);
      return;
    }
  }
  
  public void onResume()
  {
    QLog.d("miniapp-start", 4, "AppBrandFragment onResume isLoadFail=" + this.isLoadFail);
    Object localObject1 = getArgumentBundle();
    int i;
    if (localObject1 == null)
    {
      super.onResume();
      if (this.needResume) {
        syncForceGroundAndRefreshBadge();
      }
      if ((this.miniConfig != null) && (this.miniConfig.config != null))
      {
        localObject1 = this.miniConfig.config.appId;
        i = this.miniConfig.config.verType;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(NavigateBackUtils.getTagAppid())) && (this.miniConfig.launchParam != null)) {
          this.miniConfig.launchParam.scene = 1038;
        }
        NavigateBackUtils.clearTag();
        localObject1 = this.appBrandRuntimeContainer.getAppBrandRunTime(this.miniConfig.config);
        if ((localObject1 != null) && ((this.needResume) || (((AppBrandRuntime)localObject1).isPauseByopenUrl())))
        {
          ((AppBrandRuntime)localObject1).onResume(this.miniConfig, false);
          ((AppBrandRuntime)localObject1).setPauseByopenUrl(false);
          this.needResume = false;
        }
        MiniAppReportManager2.reportPageView("2launch", "click_resume", null, this.miniConfig);
      }
      return;
    }
    Object localObject2 = (MiniAppConfig)((Bundle)localObject1).getParcelable("CONFIG");
    int j = ((Bundle)localObject1).getInt("start_mode", 0);
    this.miniConfig = ((MiniAppConfig)localObject2);
    Object localObject3;
    if ((localObject2 != null) && (((MiniAppConfig)localObject2).isShortcutFakeApp()))
    {
      localObject3 = ((MiniAppConfig)localObject2).config.appId;
      localObject3 = this.appBrandRuntimeContainer.getAppBrandRunTime((String)localObject3, -1);
      if (localObject3 != null)
      {
        this.miniConfig = ((AppBrandRuntime)localObject3).apkgInfo.appConfig;
        this.miniConfig.launchParam = ((MiniAppConfig)localObject2).launchParam;
        i = 1;
      }
    }
    for (;;)
    {
      if ((localObject2 != null) && (((MiniAppConfig)localObject2).isBackToMiniApp()) && (((MiniAppConfig)localObject2).config != null))
      {
        localObject3 = this.appBrandRuntimeContainer.getAppBrandRunTime(((MiniAppConfig)localObject2).config.appId, -1);
        if (localObject3 != null)
        {
          localObject3 = ((AppBrandRuntime)localObject3).apkgInfo.appConfig;
          ((MiniAppConfig)localObject3).launchParam = ((MiniAppConfig)localObject2).launchParam;
          this.miniConfig = ((MiniAppConfig)localObject3);
        }
      }
      if (this.miniConfig == null)
      {
        QLog.e("miniapp-start", 1, "AppBrandFragment onResume miniConfig is Null!!!");
        super.onResume();
        return;
        this.miniConfig = ((MiniAppConfig)localObject2);
        i = 1;
      }
      else
      {
        syncForceGroundAndRefreshBadge();
        ThreadManagerV2.excute(new AppBrandFragment.4(this, getActivity()), 16, null, false);
        changeWindowInfo(this.miniConfig);
        localObject3 = this.miniConfig.config.appId;
        if ((this.miniConfig.isFromShowInfo()) && (!this.miniConfig.isBackToMiniApp())) {
          this.appBrandRuntimeContainer.cleanup();
        }
        localObject2 = this.appBrandRuntimeContainer.getAppBrandRunTime(this.miniConfig.config);
        if (this.miniConfig.launchParam == null) {
          this.miniConfig.launchParam = new LaunchParam();
        }
        this.miniConfig.launchParam.tempState = 1;
        ResultReceiver localResultReceiver = (ResultReceiver)((Bundle)localObject1).getParcelable("receiver");
        if (localResultReceiver != null) {
          localResultReceiver.send(0, new Bundle());
        }
        QLog.d("miniapp-start", 1, "onResume appConfig=" + this.miniConfig.toString() + ", appBrandRunTime=" + localObject2);
        if (localObject2 == null)
        {
          PreCacheManager.g().fetchPreCacheData(this.miniConfig);
          PreCacheManager.g().fetchPreResourceIfNeed(this.miniConfig);
          QLog.d("AppBrandFragment", 1, "onResume appBrandRunTime not found! isLoadFail=" + this.isLoadFail);
          this.mSoftKeyboardStateHelper = new SoftKeyboardStateHelper(this.rootFrameLayout);
          this.mSoftKeyboardStateHelper.addSoftKeyboardStateListener(this.mListener);
          MiniReportManager.addCostTimeEventAttachInfo(this.miniConfig, 2, "StartMode_" + j);
          QLog.d("AppBrandFragment", 1, "onResume startActivityForResult isLoadFail=" + this.isLoadFail + ",appid =" + (String)localObject3 + ",entryPath=" + this.miniConfig.launchParam.entryPath);
          if ((this.miniConfig.config.debugInfo != null) && (!TextUtils.isEmpty(this.miniConfig.config.debugInfo.roomId)) && (!TextUtils.isEmpty(this.miniConfig.config.debugInfo.wsUrl))) {
            AppLoaderFactory.getAppLoaderManager().onBaselibUpdated(getActivity(), this.miniConfig);
          }
          jumpToLoadingUI();
          super.onResume();
          return;
        }
        long l = ((Bundle)localObject1).getLong("startDuration", 0L);
        if ((l != 0L) && (MiniAppMonitorInfoView.sStartTime != l))
        {
          MiniAppMonitorInfoView.sStartTime = l;
          MiniAppMonitorInfoView.sStartDuration = System.currentTimeMillis() - l;
        }
        this.appBrandRuntimeContainer.bringToFront((AppBrandRuntime)localObject2, this.rootFrameLayout);
        try
        {
          ((AppBrandRuntime)localObject2).onAttachWindow(getActivity());
          if (this.needResume)
          {
            localObject3 = this.miniConfig;
            if (i == 0)
            {
              bool = true;
              ((AppBrandRuntime)localObject2).onResume((MiniAppConfig)localObject3, bool);
              if (((AppBrandRuntime)localObject2).getContainer() != null) {
                ((AppBrandRuntime)localObject2).getContainer().postInvalidate();
              }
              this.needResume = false;
            }
          }
          else
          {
            if (((AppBrandRuntime)localObject2).isFirstDomReady) {
              MiniAppReportManager2.reportPageView("2launch", "click_resume", null, this.miniConfig);
            }
            QLog.d("AppBrandFragment", 1, "onResume bringToFront appBrandRunTime=" + localObject2);
            if (this.keyboardObserver == null)
            {
              this.keyboardObserver = ((AppBrandRuntime)localObject2).getKeyboardObserver();
              if (this.keyboardObserver != null) {
                MiniAppStateManager.getInstance().addObserver(this.keyboardObserver);
              }
            }
            super.onResume();
            ((Bundle)localObject1).clear();
            setArgumentBundle(null);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("AppBrandFragment", 1, "", localThrowable);
            continue;
            boolean bool = false;
          }
        }
        i = 0;
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandFragment", 1, "onStart");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Object localObject = this.appBrandRuntimeContainer.peek();
    if ((!this.needResume) && (localObject != null))
    {
      ((AppBrandRuntime)localObject).onPause();
      this.needResume = true;
    }
    if ((this.appBrandRuntimeContainer != null) && (this.miniConfig != null) && (this.miniConfig.config != null))
    {
      localObject = this.appBrandRuntimeContainer.getAppBrandRunTime(this.miniConfig.config);
      if ((localObject != null) && (((AppBrandRuntime)localObject).isNeedReboot()))
      {
        QLog.d("AppBrandFragment", 1, "activity onstop, and reboot.");
        localObject = getActivity();
        if ((localObject != null) && ((localObject instanceof AppBrandUI)))
        {
          localObject = ((AppBrandUI)localObject).getAppInterface();
          if ((localObject != null) && ((localObject instanceof MiniAppInterface))) {
            ((MiniAppInterface)localObject).exitProcess();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandFragment", 1, "onStop");
    }
    ThreadManagerV2.excute(new AppBrandFragment.5(this, getActivity()), 16, null, true);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    QLog.i("miniapp-start", 1, "AppBrandFragment onViewCreated");
    MiniAppStateManager.getInstance().addObserver(this.stateObserver);
    paramView = MiniAppStateManager.getInstance();
    paramBundle = WebInputHandler.getInstance();
    paramBundle.getClass();
    paramView.addObserver(new WebInputHandler.KeyboardHiddenObserver(paramBundle));
    AppNetConnInfo.registerNetChangeReceiver(getActivity(), this);
    registComponentCallback();
    DisplayUtil.updatePortrait(getActivity());
  }
  
  public void setArgumentBundle(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment
 * JD-Core Version:    0.7.0.1
 */