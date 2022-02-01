package com.tencent.qqmini.sdk.runtime;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniToast;

public class AppStateManager
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  private static final int LAUNCH_STATUS_CLICK = 0;
  private static final int LAUNCH_STATUS_FIRST_FRAME = 2;
  private static final int LAUNCH_STATUS_LOAD = 1;
  private static final String TAG = "minisdk-start_RuntimeState";
  public boolean hasFirstDomReadied;
  public boolean hasPreloadCompleted;
  public boolean isFlutter;
  public boolean isFromPrelaunch;
  public boolean isFromPreload;
  public int launchStatus = 0;
  private long mBeginOnCreate;
  private int mLaunchResult = 0;
  private final BaseRuntimeLoader mRuntimeLoader;
  private long onResumeTime = 0L;
  
  public AppStateManager(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    this.mRuntimeLoader = paramBaseRuntimeLoader;
  }
  
  private void detectWhiteScreen(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      QMLog.i("minisdk-start_RuntimeState", "not detect mini game.");
    }
    while (WnsConfig.getConfig("qqminiapp", "mini_app_enable_white_screen_check_after_domready", 1) <= 0) {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AppStateManager.1(this, paramMiniAppInfo), 5000L);
  }
  
  private void notifyEvent(MiniAppInfo paramMiniAppInfo, String paramString, long paramLong)
  {
    if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null)) {
      return;
    }
    String str = paramMiniAppInfo.appId;
    paramMiniAppInfo = paramMiniAppInfo.via;
    Bundle localBundle = new Bundle();
    localBundle.putString("key_appid", str);
    localBundle.putInt("key_scene", 9999);
    localBundle.putString("key_via", paramMiniAppInfo);
    localBundle.putString("key_event", paramString);
    localBundle.putLong("key_timestamp", paramLong);
    AppBrandCmdProxy.g().sendCmd("cmd_notify_event_info", localBundle, null);
  }
  
  private void onMsgBackKey()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    Object localObject = this.mRuntimeLoader.getRuntime();
    int i;
    if ((localObject != null) && (((BaseRuntime)localObject).getPage() != null))
    {
      localObject = PageAction.obtain((IMiniAppContext)localObject).getPageUrl();
      if (localMiniAppInfo == null) {
        break label93;
      }
      i = localMiniAppInfo.getReportType();
      label44:
      if (i == 1)
      {
        if (localMiniAppInfo == null) {
          break label120;
        }
        if (this.launchStatus != 0) {
          break label98;
        }
        SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "load_fail", "loading_page_back_press");
      }
    }
    for (;;)
    {
      if (!this.hasFirstDomReadied) {
        break label130;
      }
      MiniAppReportManager2.reportPageView("2back_key", "inner_page", (String)localObject, localMiniAppInfo);
      return;
      localObject = null;
      break;
      label93:
      i = 0;
      break label44;
      label98:
      if (this.launchStatus == 1)
      {
        SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "show_fail", "loading_page_back_press");
        continue;
        label120:
        QMLog.e("minisdk-start_RuntimeState", "doOnBackPressed gameConfig=null");
      }
    }
    label130:
    MiniAppReportManager2.reportPageView("2back_key", "loading_page", (String)localObject, localMiniAppInfo);
  }
  
  private void onMsgCloseInner()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    BaseRuntime localBaseRuntime = this.mRuntimeLoader.getRuntime();
    if ((localBaseRuntime != null) && (localBaseRuntime.getPage() != null)) {}
    for (String str = PageAction.obtain(localBaseRuntime).getPageUrl();; str = null)
    {
      MiniAppReportManager2.reportPageView("2close", "inner_page", str, localMiniAppInfo);
      if ((!this.mRuntimeLoader.isLoadSucceed()) || (localBaseRuntime == null) || (!localBaseRuntime.isMiniGame())) {
        break;
      }
      MiniReportManager.reportEventType(localMiniAppInfo, 1025, "1");
      return;
    }
    MiniReportManager.reportEventType(localMiniAppInfo, 1026, "1");
  }
  
  private void onMsgDomReady()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    Object localObject = this.mRuntimeLoader.getRuntime();
    String str1;
    int i;
    label52:
    String str2;
    label131:
    label142:
    long l1;
    long l2;
    int j;
    if ((localObject != null) && (((BaseRuntime)localObject).getPage() != null))
    {
      str1 = PageAction.obtain((IMiniAppContext)localObject).getPageUrl();
      if (localMiniAppInfo == null) {
        break label348;
      }
      i = localMiniAppInfo.getReportType();
      if (!this.hasFirstDomReadied)
      {
        this.hasFirstDomReadied = true;
        if ((localObject != null) && (localMiniAppInfo != null))
        {
          QMLog.i("minisdk-start_RuntimeState", "--- report show firstframe appid:" + localMiniAppInfo.appId);
          MiniAppReportManager2.reportPageView("2launch", "first_frame", str1, localMiniAppInfo);
          if (!TextUtils.isEmpty(str1)) {
            break label353;
          }
          localObject = localMiniAppInfo.launchParam.entryPath;
          if (!this.isFromPrelaunch) {
            break label360;
          }
          str2 = "preLaunch";
          MiniReportManager.reportEventType(localMiniAppInfo, 21, (String)localObject, str2, null, 0);
          l1 = System.currentTimeMillis();
          l2 = this.mBeginOnCreate;
          j = this.mLaunchResult;
          if (i != 0) {
            break label366;
          }
        }
      }
    }
    label348:
    label353:
    label360:
    label366:
    for (localObject = "0";; localObject = "1")
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 1043, null, null, null, j, (String)localObject, l1 - l2, null);
      localObject = new Bundle();
      ((Bundle)localObject).putString("bundle_key_runtime_lifecycle", "first_frame");
      ((Bundle)localObject).putParcelable("bundle_key_appinfo", localMiniAppInfo);
      AppBrandCmdProxy.g().sendCmd("cmd_notify_runtime_lifecycle", (Bundle)localObject, null);
      localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      if ((this.isFlutter) && (((MiniAppProxy)localObject).isDebugVersion())) {
        MiniToast.makeText(MiniAppEnv.g().getContext(), "进入native小程序,仅debug可见", 0).show();
      }
      ((MiniAppProxy)localObject).notifyMiniAppInfo(1, localMiniAppInfo);
      detectWhiteScreen(localMiniAppInfo);
      MiniReportManager.reportEventType(localMiniAppInfo, 611, str1, null, null, 0, MiniAppStartState.getBaseLibDownloadDesc(localMiniAppInfo.appId), MiniAppStartState.getApkgDownloadDesc(localMiniAppInfo.appId), MiniAppStartState.getBaselibLoadDesc(localMiniAppInfo.appId), MiniAppStartState.getPageSwitchDesc(localMiniAppInfo.appId));
      return;
      str1 = null;
      break;
      i = 0;
      break label52;
      localObject = str1;
      break label131;
      str2 = null;
      break label142;
    }
  }
  
  private void onMsgGameDestroy()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    if (localMiniAppInfo != null)
    {
      if ((this.launchStatus == 0) || (this.launchStatus == 1))
      {
        SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "load_fail", "loading_page_kill");
        MiniAppReportManager2.reportPageView("2launch_fail", "loading_page_kill", null, localMiniAppInfo);
      }
      return;
    }
    QMLog.e("minisdk-start_RuntimeState", "doOnDestroy kill self gameConfig=null");
  }
  
  private void onMsgPause()
  {
    long l1 = 0L;
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    Object localObject = this.mRuntimeLoader.getRuntime();
    int i;
    label54:
    long l3;
    long l2;
    if ((localObject != null) && (((BaseRuntime)localObject).getPage() != null))
    {
      localObject = PageAction.obtain((IMiniAppContext)localObject).getPageUrl();
      if (localMiniAppInfo == null) {
        break label135;
      }
      i = localMiniAppInfo.getReportType();
      l3 = System.currentTimeMillis();
      l2 = l3 - this.onResumeTime;
      if (l2 >= 0L) {
        break label140;
      }
    }
    for (;;)
    {
      MiniAppReportManager2.reportPageView("2hide", String.valueOf(l1), (String)localObject, localMiniAppInfo);
      notifyEvent(localMiniAppInfo, "onPause", l3);
      MiniReportManager.reportEventType(localMiniAppInfo, 20, "" + i, l1);
      return;
      localObject = null;
      break;
      label135:
      i = 0;
      break label54;
      label140:
      l1 = l2;
    }
  }
  
  private void onMsgResume()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    BaseRuntime localBaseRuntime = this.mRuntimeLoader.getRuntime();
    if ((localBaseRuntime != null) && (localBaseRuntime.getPage() != null)) {}
    for (String str1 = PageAction.obtain(localBaseRuntime).getPageUrl(); localMiniAppInfo == null; str1 = null) {
      return;
    }
    QMLog.i("minisdk-start_RuntimeState", "--- report bring_to_front appid:" + localMiniAppInfo.appId);
    long l = System.currentTimeMillis();
    this.onResumeTime = l;
    MiniAppReportManager2.reportPageView("2show", "bring_to_front", str1, localMiniAppInfo);
    notifyEvent(localMiniAppInfo, "onResume", l);
    if (TextUtils.isEmpty(str1)) {}
    for (String str2 = localMiniAppInfo.launchParam.entryPath;; str2 = str1)
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 1, str2, null, null, 0);
      if ((localBaseRuntime == null) || (!this.hasFirstDomReadied)) {
        break;
      }
      QMLog.i("minisdk-start_RuntimeState", "--- report click_resume appid:" + localMiniAppInfo.appId);
      MiniAppReportManager2.reportPageView("2launch", "click_resume", str1, localMiniAppInfo);
      MiniReportManager.reportEventType(localMiniAppInfo, 21, str2, null, null, 0);
      return;
    }
  }
  
  private void onMsgRouteDone()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    Object localObject = this.mRuntimeLoader.getRuntime();
    if ((localObject != null) && (((BaseRuntime)localObject).getPage() != null)) {}
    for (localObject = PageAction.obtain((IMiniAppContext)localObject).getPageUrl();; localObject = null)
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 121, (String)localObject, null, null, 0);
      return;
    }
  }
  
  private void onMsgStart()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    int i;
    label38:
    String str2;
    if (localMiniAppInfo != null)
    {
      i = localMiniAppInfo.getReportType();
      this.mBeginOnCreate = System.currentTimeMillis();
      if (localMiniAppInfo == null) {
        break label140;
      }
      str1 = localMiniAppInfo.appId;
      if (localMiniAppInfo == null) {
        break label147;
      }
      str2 = localMiniAppInfo.name;
      label49:
      QMLog.i("minisdk-start_RuntimeState", "[" + str1 + "][" + str2 + "] 启动(MiniActivity onCreate)");
      if (!this.isFromPrelaunch) {
        break label154;
      }
    }
    label140:
    label147:
    label154:
    for (String str1 = "preLaunch";; str1 = null)
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 24, null, str1, null, 0, String.valueOf(i), 0L, null, "", "", "", "");
      this.launchStatus = 0;
      return;
      i = 0;
      break;
      str1 = "";
      break label38;
      str2 = "";
      break label49;
    }
  }
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if ((paramMiniAppStateMessage == null) && (paramMiniAppStateMessage.appRuntimeLoader == this.mRuntimeLoader)) {}
    MiniAppInfo localMiniAppInfo;
    do
    {
      return;
      QMLog.i("minisdk-start_RuntimeState", "onStateChange message:" + paramMiniAppStateMessage.what);
      localObject = this.mRuntimeLoader.getRuntime();
      localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
      if (localMiniAppInfo != null) {
        localMiniAppInfo.getReportType();
      }
      if ((localObject != null) && (((BaseRuntime)localObject).getPage() != null)) {}
      for (localObject = PageAction.obtain((IMiniAppContext)localObject).getPageUrl();; localObject = null) {
        switch (paramMiniAppStateMessage.what)
        {
        default: 
          return;
        case 3: 
          if ((this.isFromPreload) || (this.isFromPrelaunch)) {
            this.hasPreloadCompleted = true;
          }
          if ((localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId)))
          {
            MiniAppStartState.setBaseLibLoad(localMiniAppInfo.appId, false);
            QMLog.d("minisdk-start_RuntimeState", "framework load finished :" + localMiniAppInfo.appId);
          }
          QMLog.d("minisdk-start_RuntimeState", "framework load finished");
          return;
        }
      }
      onMsgStart();
      return;
      this.launchStatus = 1;
      localObject = new StringBuilder().append("--- report load appid:");
      if (localMiniAppInfo != null) {}
      for (paramMiniAppStateMessage = localMiniAppInfo.appId;; paramMiniAppStateMessage = Integer.valueOf(0))
      {
        QMLog.i("minisdk-start_RuntimeState", paramMiniAppStateMessage);
        MiniAppReportManager2.reportPageView("2load", null, null, localMiniAppInfo);
        return;
      }
      onMsgRouteDone();
      return;
      this.launchStatus = 2;
      onMsgDomReady();
      return;
      onMsgResume();
      return;
    } while (localMiniAppInfo == null);
    QMLog.i("minisdk-start_RuntimeState", "--- report launch fail appid:" + localMiniAppInfo.appId);
    MiniAppReportManager2.reportPageView("2launch_fail", "flutter_sdk_fail", (String)localObject, localMiniAppInfo);
    return;
    MiniAppReportManager2.reportPageView("2close", "loading_page", null, localMiniAppInfo);
    return;
    onMsgCloseInner();
    return;
    MiniAppReportManager2.reportPageView("2unload", null, (String)localObject, localMiniAppInfo);
    return;
    onMsgPause();
    return;
    onMsgBackKey();
    return;
    Object localObject = (Pair)paramMiniAppStateMessage.obj;
    if (paramMiniAppStateMessage.obj != null) {}
    for (int i = ((Integer)((Pair)localObject).first).intValue();; i = 0)
    {
      int j = i;
      if (i >= 0) {
        j = 0;
      }
      this.mLaunchResult = j;
      return;
    }
    onMsgGameDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager
 * JD-Core Version:    0.7.0.1
 */