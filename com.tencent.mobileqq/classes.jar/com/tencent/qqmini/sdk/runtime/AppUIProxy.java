package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.MiniLoadManager;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.manager.PreloadResource;
import com.tencent.qqmini.sdk.report.MiniAppStartState;

@MiniKeep
public class AppUIProxy
  extends BaseUIProxy
{
  private boolean fromFackStart = false;
  private AppUIProxy.DebugLayout mDebugLayout;
  private EngineChannel mEngineChannel;
  private View.OnClickListener mLoadingClickListener = new AppUIProxy.6(this);
  private AppUIProxy.LoadingUI mLoadingUI;
  private final AppRuntimeEventCenter.RuntimeStateObserver mObserver = new AppUIProxy.1(this);
  
  private boolean isLaunchFromAppIdWithoutEntryPath(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo.isStartFromAppId()) && (TextUtils.isEmpty(paramMiniAppInfo.launchParam.entryPath));
  }
  
  private void showKingcardTip()
  {
    QMLog.i("minisdk-start_UIProxy", "showKingcardTip");
    this.mMainHandler.post(new AppUIProxy.5(this));
  }
  
  public void disableBreak()
  {
    new Handler(Looper.getMainLooper()).post(new AppUIProxy.8(this));
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    Object localObject;
    if (this.mCurrRuntimeLoader != null) {
      localObject = this.mCurrRuntimeLoader.getRuntime();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((BaseRuntime)localObject).getPage();
      if (localObject != null) {
        ((IPage)localObject).doDispatchKeyEvent(paramKeyEvent);
      }
    }
    return false;
  }
  
  public void enableBreak()
  {
    new Handler(Looper.getMainLooper()).post(new AppUIProxy.7(this));
  }
  
  protected AppRuntimeEventCenter.RuntimeStateObserver getRuntimeStateObserver()
  {
    return this.mObserver;
  }
  
  protected void hideLoading()
  {
    this.hasCompletedLoading = true;
    this.loadCompleteTimeForLoadingAdReport = System.currentTimeMillis();
    AppUIProxy.LoadingUI localLoadingUI = this.mLoadingUI;
    if (localLoadingUI == null) {
      return;
    }
    localLoadingUI.setCustomClickListener(null);
    this.mMainHandler.post(new AppUIProxy.3(this));
    AdFrequencyLimit.setOnStartTime(System.currentTimeMillis());
    MiniLoadingAdManager.getInstance().preloadLoadingAd(this.mActivity, getMiniAppInfo());
  }
  
  protected boolean isAbleToShowAd()
  {
    return this.hasCompletedLoading ^ true;
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramActivity, paramInt1, paramInt2, paramIntent);
    paramActivity = (AdProxy)ProxyManager.get(AdProxy.class);
    if (paramActivity != null) {
      paramActivity.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    super.onAttachActivity(paramActivity, paramBundle, paramViewGroup);
    this.mLoadingUI = PreloadResource.g().getAppLoadingUI(paramActivity);
  }
  
  public void onIntentUpdate(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (;;)
    {
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
        EngineChannel localEngineChannel;
        continue;
      }
      QMLog.e("minisdk-start_UIProxy", "", localEngineChannel);
      super.onIntentUpdate(paramIntent);
      return;
      Object localObject = null;
    }
  }
  
  public void onMiniStart()
  {
    super.onMiniStart();
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if (localAdProxy != null) {
      localAdProxy.onActivityStart();
    }
  }
  
  public void onMiniStop()
  {
    super.onMiniStop();
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if (localAdProxy != null) {
      localAdProxy.onActivityStop();
    }
  }
  
  protected void onRuntimeFail(int paramInt, String paramString)
  {
    Object localObject2 = "";
    if (13 == paramInt)
    {
      paramString = (String)localObject2;
      try
      {
        Object localObject1 = WnsConfig.getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
        try
        {
          if (getMiniAppInfo() != null) {
            localObject2 = getMiniAppInfo().appId;
          }
          paramString = (String)localObject1;
          if (((String)localObject1).contains("{appid}"))
          {
            paramString = (String)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              paramString = ((String)localObject1).replace("{appid}", (CharSequence)localObject2);
            }
          }
          localObject1 = paramString;
          paramString = (String)localObject1;
          localObject2 = new StringBuilder();
          paramString = (String)localObject1;
          ((StringBuilder)localObject2).append("showUpdateMobileQQDialog jump to upgrate page:");
          paramString = (String)localObject1;
          ((StringBuilder)localObject2).append((String)localObject1);
          paramString = (String)localObject1;
          QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject2).toString());
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
        catch (Throwable localThrowable2)
        {
          paramString = (String)localObject1;
          localObject1 = localThrowable2;
        }
        localStringBuilder = new StringBuilder();
      }
      catch (Throwable localThrowable1) {}
      StringBuilder localStringBuilder;
      localStringBuilder.append("jump to upgrate page exception! url=");
      localStringBuilder.append(paramString);
      QMLog.e("minisdk-start", localStringBuilder.toString(), localThrowable1);
      return;
    }
    super.onRuntimeFail(paramInt, paramString);
  }
  
  protected void onRuntimeReady()
  {
    AppBrandTask.runTaskOnUiThread(new AppUIProxy.4(this));
    showKingcardTip();
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localChannelProxy != null) && (localMiniAppInfo != null)) {
      localChannelProxy.syncForceGroundAndRefreshBadge(this.mActivity, localMiniAppInfo.appId, AppLoaderFactory.g().getProcessName());
    }
  }
  
  protected void reloadMiniAppInfoIfNeed(BaseRuntimeLoader paramBaseRuntimeLoader, MiniAppInfo paramMiniAppInfo)
  {
    if (paramBaseRuntimeLoader.isLoadSucceed())
    {
      Object localObject = paramBaseRuntimeLoader.getMiniAppInfo();
      if ((!paramMiniAppInfo.isShortcutFakeApp()) && (!paramMiniAppInfo.launchParam.fromBackToMiniApp()) && (!isLaunchFromAppIdWithoutEntryPath(paramMiniAppInfo)))
      {
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
        if ((!paramMiniAppInfo.appMode.reloadWithFirstPageChange) && (!TextUtils.isEmpty(str2)))
        {
          QMLog.i("minisdk-start_UIProxy", "not appstore, entryPath need reload");
          paramBaseRuntimeLoader.updateMiniAppInfoFromReload(paramMiniAppInfo);
          if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
            MiniAppStartState.setSwitchPage(paramMiniAppInfo.appId, true);
          }
        }
        else if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject)) || (str2.equals(localObject))))
        {
          paramBaseRuntimeLoader.updateMiniAppInfo(paramMiniAppInfo);
        }
        else
        {
          QMLog.i("minisdk-start_UIProxy", "entryPath need reload");
          paramBaseRuntimeLoader.updateMiniAppInfoFromReload(paramMiniAppInfo);
          if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
            MiniAppStartState.setSwitchPage(paramMiniAppInfo.appId, true);
          }
        }
        paramBaseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
        hideLoading();
        return;
      }
      ((MiniAppInfo)localObject).launchParam.clone(paramMiniAppInfo.launchParam);
      paramBaseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
      hideLoading();
      return;
    }
    showLoading(paramMiniAppInfo);
    paramBaseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
    if (!paramBaseRuntimeLoader.isRunning())
    {
      paramBaseRuntimeLoader.setMiniAppInfo(paramMiniAppInfo);
      paramBaseRuntimeLoader.start();
    }
  }
  
  protected void showLoading(MiniAppInfo paramMiniAppInfo)
  {
    AppUIProxy.LoadingUI localLoadingUI = this.mLoadingUI;
    if (localLoadingUI == null) {
      return;
    }
    localLoadingUI.initData(paramMiniAppInfo);
    this.mLoadingUI.setCustomClickListener(this.mLoadingClickListener);
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
  
  protected void updateLoadingAdUI(Activity paramActivity, MiniAppInfo paramMiniAppInfo, String paramString, long paramLong1, long paramLong2)
  {
    paramActivity.runOnUiThread(new AppUIProxy.9(this, paramActivity, paramMiniAppInfo, paramString, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy
 * JD-Core Version:    0.7.0.1
 */