package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.MiniLoadManager;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.report.MiniAppStartState;

@MiniKeep
public class AppUIProxy
  extends BaseUIProxy
{
  private boolean fromFackStart = false;
  private AppUIProxy.DebugLayout mDebugLayout;
  private TextView mDebugText;
  private EngineChannel mEngineChannel;
  private AppUIProxy.LoadingUI mLoadingUI;
  private final AppRuntimeEventCenter.RuntimeStateObserver mObserver = new AppUIProxy.1(this);
  
  private void showKingcardTip()
  {
    QMLog.i("minisdk-start_UIProxy", "showKingcardTip");
    this.mMainHandler.post(new AppUIProxy.5(this));
  }
  
  public void disableBreak()
  {
    new Handler(Looper.getMainLooper()).post(new AppUIProxy.7(this));
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.mCurrRuntimeLoader != null) {}
    for (Object localObject = this.mCurrRuntimeLoader.getRuntime();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((BaseRuntime)localObject).getPage();
        if (localObject != null) {
          ((IPage)localObject).doDispatchKeyEvent(paramKeyEvent);
        }
      }
      return false;
    }
  }
  
  public void enableBreak()
  {
    new Handler(Looper.getMainLooper()).post(new AppUIProxy.6(this));
  }
  
  protected AppRuntimeEventCenter.RuntimeStateObserver getRuntimeStateObserver()
  {
    return this.mObserver;
  }
  
  protected void hideLoading()
  {
    this.hasCompletedLoading = true;
    this.loadCompleteTimeForLoadingAdReport = System.currentTimeMillis();
    if (this.mLoadingUI == null) {
      return;
    }
    this.mMainHandler.post(new AppUIProxy.3(this));
    AdFrequencyLimit.setOnStartTime(System.currentTimeMillis());
    MiniLoadingAdManager.getInstance().preloadLoadingAd(this.mActivity, getMiniAppInfo());
  }
  
  public void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    super.onAttachActivity(paramActivity, paramBundle, paramViewGroup);
    this.mLoadingUI = new AppUIProxy.LoadingUI(this, paramActivity.getApplicationContext());
    this.mDebugLayout = new AppUIProxy.DebugLayout(this, paramActivity.getApplicationContext());
    this.mDebugLayout.setBackgroundColor(-822083584);
    this.mDebugText = new TextView(paramActivity.getApplicationContext());
    this.mDebugText.setTextColor(-1);
    this.mDebugText.setTextSize(30.0F);
    paramActivity = new FrameLayout.LayoutParams(-2, -2);
    paramActivity.gravity = 17;
    this.mDebugLayout.addView(this.mDebugText, paramActivity);
    this.mDebugLayout.setVisibility(4);
    if (this.mDebugLayout.getParent() != null) {
      ((ViewGroup)this.mDebugLayout.getParent()).removeView(this.mDebugLayout);
    }
    this.mDebugText.setText("调试断点中...");
    paramViewGroup.addView(this.mDebugLayout, new ViewGroup.LayoutParams(-1, -1));
    this.mDebugLayout.setVisibility(4);
  }
  
  public void onIntentUpdate(Intent paramIntent)
  {
    EngineChannel localEngineChannel = null;
    if (paramIntent != null) {}
    try
    {
      localEngineChannel = (EngineChannel)paramIntent.getParcelableExtra("engineChannel");
      this.mEngineChannel = localEngineChannel;
      MiniLoadManager.g().configTask(this.mActivity, null);
      MiniLoadManager.g().setDownloadEngineChannel(this.mEngineChannel);
      MiniLoadManager.g().startDownload(null);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("minisdk-start_UIProxy", "", localThrowable);
      }
    }
    super.onIntentUpdate(paramIntent);
  }
  
  protected void onRuntimeFail(int paramInt, String paramString)
  {
    if (13 == paramInt)
    {
      paramString = "";
      try
      {
        Object localObject2 = WnsConfig.getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
        String str = "";
        paramString = (String)localObject2;
        if (getMiniAppInfo() != null)
        {
          paramString = (String)localObject2;
          str = getMiniAppInfo().appId;
        }
        Object localObject1 = localObject2;
        paramString = (String)localObject2;
        if (((String)localObject2).contains("{appid}"))
        {
          localObject1 = localObject2;
          paramString = (String)localObject2;
          if (!TextUtils.isEmpty(str))
          {
            paramString = (String)localObject2;
            localObject1 = ((String)localObject2).replace("{appid}", str);
          }
        }
        paramString = (String)localObject1;
        QMLog.i("minisdk-start_UIProxy", "showUpdateMobileQQDialog jump to upgrate page:" + (String)localObject1);
        paramString = (String)localObject1;
        localObject2 = new Intent();
        paramString = (String)localObject1;
        ((Intent)localObject2).putExtra("hide_more_button", true);
        paramString = (String)localObject1;
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        paramString = (String)localObject1;
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        paramString = (String)localObject1;
        ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).startBrowserActivity(this.mActivity, (Intent)localObject2);
        paramString = (String)localObject1;
        AppBrandTask.runTaskOnUiThreadDelay(new AppUIProxy.2(this), 1500L);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start", "jump to upgrate page exception! url=" + paramString, localThrowable);
        return;
      }
    }
    super.onRuntimeFail(paramInt, paramString);
  }
  
  protected void onRuntimeReady()
  {
    if (this.mCurrRuntimeLoader != null)
    {
      if (this.mCurrRuntimeLoader.dismissLoadingAfterLoaded()) {
        break label104;
      }
      this.mCurrRuntimeLoader.addRuntimeStateObserver(new AppUIProxy.4(this));
    }
    for (;;)
    {
      this.mCurrRuntimeLoader.startLoadMiniAppContent(false);
      this.mCurrRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
      showKingcardTip();
      ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      MiniAppInfo localMiniAppInfo = getMiniAppInfo();
      if ((localChannelProxy != null) && (localMiniAppInfo != null)) {
        localChannelProxy.syncForceGroundAndRefreshBadge(this.mActivity, localMiniAppInfo.appId, AppLoaderFactory.g().getProcessName());
      }
      return;
      label104:
      hideLoading();
    }
  }
  
  protected void reloadMiniAppInfoIfNeed(BaseRuntimeLoader paramBaseRuntimeLoader, MiniAppInfo paramMiniAppInfo)
  {
    Object localObject;
    if (paramBaseRuntimeLoader.isLoadSucceed())
    {
      localObject = paramBaseRuntimeLoader.getMiniAppInfo();
      if ((paramMiniAppInfo.isShortcutFakeApp()) || (paramMiniAppInfo.launchParam.fromBackToMiniApp()))
      {
        ((MiniAppInfo)localObject).launchParam.clone(paramMiniAppInfo.launchParam);
        paramBaseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
        hideLoading();
      }
    }
    do
    {
      return;
      if (paramMiniAppInfo.isFakeAppInfo())
      {
        paramBaseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
        paramBaseRuntimeLoader.updateMiniAppInfoFromReload(paramMiniAppInfo);
        return;
      }
      String str2 = paramMiniAppInfo.launchParam.entryPath;
      String str1 = ((MiniAppInfo)localObject).launchParam.entryPath;
      localObject = str1;
      if (paramBaseRuntimeLoader.getRuntime().getPage() != null)
      {
        localObject = str1;
        if (paramBaseRuntimeLoader.getRuntime().getPage().getPageInfo(2) != null) {
          localObject = paramBaseRuntimeLoader.getRuntime().getPage().getPageInfo(2).pageUrl;
        }
      }
      if ((!paramMiniAppInfo.isAppStoreMiniApp()) && (!TextUtils.isEmpty(str2)))
      {
        QMLog.i("minisdk-start_UIProxy", "not appstore, entryPath need reload");
        paramBaseRuntimeLoader.updateMiniAppInfoFromReload(paramMiniAppInfo);
        if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
          MiniAppStartState.setSwitchPage(paramMiniAppInfo.appId, true);
        }
      }
      for (;;)
      {
        paramBaseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
        hideLoading();
        return;
        if ((TextUtils.isEmpty((CharSequence)localObject)) || ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!str2.equals(localObject))))
        {
          QMLog.i("minisdk-start_UIProxy", "entryPath need reload");
          paramBaseRuntimeLoader.updateMiniAppInfoFromReload(paramMiniAppInfo);
          if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
            MiniAppStartState.setSwitchPage(paramMiniAppInfo.appId, true);
          }
        }
        else
        {
          paramBaseRuntimeLoader.updateMiniAppInfo(paramMiniAppInfo);
        }
      }
      showLoading(paramMiniAppInfo);
      paramBaseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
    } while (paramBaseRuntimeLoader.isRunning());
    paramBaseRuntimeLoader.setMiniAppInfo(paramMiniAppInfo);
    paramBaseRuntimeLoader.start();
  }
  
  protected void showLoading(MiniAppInfo paramMiniAppInfo)
  {
    if (this.mLoadingUI == null) {
      return;
    }
    this.mLoadingUI.initData(paramMiniAppInfo);
    if (this.mLoadingUI.getVisibility() != 0) {
      this.mLoadingUI.setVisibility(0);
    }
    if (this.mLoadingUI.getParent() != null) {
      ((ViewGroup)this.mLoadingUI.getParent()).removeView(this.mLoadingUI);
    }
    this.mRootLayout.addView(this.mLoadingUI);
    this.mLoadingUI.onResume();
    this.hasCompletedLoading = false;
    processSelectLoadingAdLogic(this.mActivity, paramMiniAppInfo);
  }
  
  protected void startMiniAppInfo(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo");
    super.startMiniAppInfo(paramMiniAppInfo, paramBundle);
  }
  
  protected void updateLoadingAdUI(Activity paramActivity, MiniAppInfo paramMiniAppInfo, String paramString, long paramLong)
  {
    paramActivity.runOnUiThread(new AppUIProxy.8(this, paramActivity, paramMiniAppInfo, paramString, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy
 * JD-Core Version:    0.7.0.1
 */