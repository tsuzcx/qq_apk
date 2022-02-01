package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.graphics.Bitmap;
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
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.ScreenShotUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.HashMap;

public class AppStateManager
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  private static final int LAUNCH_STATUS_CLICK = 0;
  private static final int LAUNCH_STATUS_FIRST_FRAME = 2;
  private static final int LAUNCH_STATUS_LOAD = 1;
  private static final String TAG = "minisdk-start_RuntimeState";
  private static final int WHITE_SCREEN_ERROR_TYPE_DETECT_WHITESCREEN = 2;
  private static final int WHITE_SCREEN_ERROR_TYPE_NO_DOMREADY = 1;
  private static volatile boolean mX5GuideShowed = false;
  private static HashMap<String, Integer> restartCount = new HashMap();
  public boolean hasFirstDomReadied;
  public boolean hasPreloadCompleted;
  private boolean hasShowCleanInfo = false;
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
  
  private boolean canShowCleanInfo(long paramLong, int paramInt, BaseRuntime paramBaseRuntime)
  {
    if (this.hasShowCleanInfo)
    {
      QMLog.i("minisdk-start_RuntimeState", "has shown cleanInfo, not showCleanInfo 2");
      return true;
    }
    if (mX5GuideShowed)
    {
      QMLog.i("minisdk-start_RuntimeState", "mX5GuideShowed not showCleanInfo 2");
      return true;
    }
    if ((paramInt == 1) && (this.hasFirstDomReadied))
    {
      QMLog.i("minisdk-start_RuntimeState", "hasFirstDomReadied not showCleanInfo 2");
      return true;
    }
    if (!paramBaseRuntime.isForground())
    {
      QMLog.e("minisdk-start_RuntimeState", "showCleanInfo failed, not is forground");
      return true;
    }
    if ((this.onResumeTime > 0L) && (paramLong - this.onResumeTime < 5000L))
    {
      QMLog.e("minisdk-start_RuntimeState", "onResume time < 5000 not show clean info, onResumeTime: " + this.onResumeTime + "  curTime:" + paramLong);
      return true;
    }
    return false;
  }
  
  private boolean checkNeedShowCleanInfo(int paramInt, BaseRuntime paramBaseRuntime, MiniAppInfo paramMiniAppInfo)
  {
    if (this.hasShowCleanInfo) {
      QMLog.i("minisdk-start_RuntimeState", "has shown cleanInfo, not showCleanInfo 1");
    }
    do
    {
      return true;
      if (mX5GuideShowed)
      {
        QMLog.i("minisdk-start_RuntimeState", "has mX5GuideShowed not showCleanInfo 1");
        return true;
      }
      if ((paramInt == 1) && (this.hasFirstDomReadied))
      {
        QMLog.i("minisdk-start_RuntimeState", "hasFirstDomReadied not showCleanInfo 1");
        return true;
      }
      if ((paramBaseRuntime == null) || (paramBaseRuntime.getAttachedActivity() == null))
      {
        QMLog.e("minisdk-start_RuntimeState", "showCleanInfo failed," + paramBaseRuntime);
        return true;
      }
      if (!paramBaseRuntime.isForground())
      {
        QMLog.e("minisdk-start_RuntimeState", "showCleanInfo failed, not is forground");
        return true;
      }
    } while ((!checkRestartCountValid(paramMiniAppInfo.appId)) || (!paramMiniAppInfo.isEngineTypeMiniApp()));
    return false;
  }
  
  private boolean checkRestartCountValid(String paramString)
  {
    int i = WnsConfig.getConfig("qqminiapp", "mini_app_enable_show_clean_max_count", 3);
    int j = getRestartCount(paramString);
    if (j >= i)
    {
      QMLog.i("minisdk-start_RuntimeState", "Appid:" + paramString + "  has restart count:" + j + "  reach the max count");
      return false;
    }
    QMLog.i("minisdk-start_RuntimeState", "Appid:" + paramString + "  has restart count:" + j);
    setRestartCount(paramString, j + 1);
    return true;
  }
  
  private void checkWhiteScreen(Bitmap paramBitmap, MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      String str;
      if (ScreenShotUtil.checkIfWhiteScreen(paramBitmap))
      {
        str = ScreenShotUtil.bitmapTobase64(paramBitmap, WnsConfig.getConfig("qqminiapp", "mini_app_white_screen_shot_max_width", 500), WnsConfig.getConfig("qqminiapp", "mini_app_white_screen_shot_max_height", 500));
        if (str.length() >= 5120) {
          break label127;
        }
        QMLog.i("minisdk-start_RuntimeState", "--- report white_screen appid:" + paramMiniAppInfo.appId + " img:" + str);
      }
      for (;;)
      {
        MiniReportManager.reportEventType(paramMiniAppInfo, 150, MiniReportManager.getAppType(paramMiniAppInfo), "dom_ready", String.valueOf(str.length()), "", "");
        if (WnsConfig.getConfig("qqminiapp", "mini_app_enable_show_clean_detect_whitescreen", 0) > 0) {
          showCleanInfo(2);
        }
        if (paramBitmap == null) {
          break;
        }
        paramBitmap.recycle();
        return;
        label127:
        QMLog.i("minisdk-start_RuntimeState", "--- report white_screen appid:" + paramMiniAppInfo.appId + " base64 length:" + str.length());
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      QMLog.e("minisdk-start_RuntimeState", "---check white screen failed", paramBitmap);
    }
  }
  
  private void detectWhiteScreen(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      QMLog.i("minisdk-start_RuntimeState", "not detect mini game.");
    }
    while (WnsConfig.getConfig("qqminiapp", "mini_app_enable_white_screen_check_after_domready", 1) <= 0) {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AppStateManager.1(this, paramMiniAppInfo), 10000L);
  }
  
  private String getCurPagePath(BaseRuntime paramBaseRuntime)
  {
    if ((paramBaseRuntime != null) && (paramBaseRuntime.getPage() != null)) {
      return PageAction.obtain(paramBaseRuntime).getPageUrl();
    }
    return null;
  }
  
  private int getRestartCount(String paramString)
  {
    if (restartCount.containsKey(paramString)) {
      return ((Integer)restartCount.get(paramString)).intValue();
    }
    return 0;
  }
  
  private void notifyEvent(MiniAppInfo paramMiniAppInfo, String paramString, long paramLong)
  {
    if ((paramMiniAppInfo == null) || (paramMiniAppInfo.launchParam == null)) {
      return;
    }
    String str = paramMiniAppInfo.appId;
    int i = paramMiniAppInfo.launchParam.scene;
    paramMiniAppInfo = paramMiniAppInfo.via;
    Bundle localBundle = new Bundle();
    localBundle.putString("key_appid", str);
    localBundle.putInt("key_scene", i);
    localBundle.putString("key_via", paramMiniAppInfo);
    localBundle.putString("key_event", paramString);
    localBundle.putLong("key_timestamp", paramLong);
    AppBrandCmdProxy.g().sendCmd("cmd_notify_event_info", localBundle, null);
  }
  
  private void onGameLaunch(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    Pair localPair = (Pair)paramMiniAppStateMessage.obj;
    if (paramMiniAppStateMessage.obj != null) {}
    for (int i = ((Integer)localPair.first).intValue();; i = 0)
    {
      int j = i;
      if (i >= 0) {
        j = 0;
      }
      this.mLaunchResult = j;
      return;
    }
  }
  
  private void onJsError(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    for (int i = 1;; i = 0) {
      try
      {
        if (mX5GuideShowed) {
          break;
        }
        if (this.hasFirstDomReadied) {
          return;
        }
        paramMiniAppStateMessage = this.mRuntimeLoader.getRuntime();
        if ((paramMiniAppStateMessage == null) || (paramMiniAppStateMessage.getAttachedActivity() == null)) {
          break;
        }
        if (WnsConfig.getConfig("qqminiapp", "mini_app_jserror_tip_enable", 1) == 1)
        {
          if (i == 0) {
            break;
          }
          startDownloadX5();
          return;
        }
      }
      catch (Throwable paramMiniAppStateMessage)
      {
        QMLog.e("minisdk-start_RuntimeState", "onJsError exception.", paramMiniAppStateMessage);
        return;
      }
    }
  }
  
  private void onMsgBackKey()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    String str = getCurPagePath(this.mRuntimeLoader.getRuntime());
    int i;
    if (localMiniAppInfo != null)
    {
      i = localMiniAppInfo.getReportType();
      if (i == 1)
      {
        if (localMiniAppInfo == null) {
          break label108;
        }
        if (this.launchStatus != 0) {
          break label83;
        }
        SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "load_fail", "loading_page_back_press");
      }
    }
    for (;;)
    {
      if (!this.hasFirstDomReadied) {
        break label119;
      }
      MiniAppReportManager2.reportPageView("2back_key", "inner_page", str, localMiniAppInfo);
      return;
      i = 0;
      break;
      label83:
      if (this.launchStatus == 1)
      {
        SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "show_fail", "loading_page_back_press");
        continue;
        label108:
        QMLog.e("minisdk-start_RuntimeState", "doOnBackPressed gameConfig=null");
      }
    }
    label119:
    MiniAppReportManager2.reportPageView("2back_key", "loading_page", str, localMiniAppInfo);
  }
  
  private void onMsgCloseInner()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    BaseRuntime localBaseRuntime = this.mRuntimeLoader.getRuntime();
    MiniAppReportManager2.reportPageView("2close", "inner_page", getCurPagePath(localBaseRuntime), localMiniAppInfo);
    if ((this.mRuntimeLoader.isLoadSucceed()) && (localBaseRuntime != null) && (localBaseRuntime.isMiniGame()))
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 1025, "1");
      return;
    }
    MiniReportManager.reportEventType(localMiniAppInfo, 1026, "1");
  }
  
  private void onMsgDomReady()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    Object localObject = this.mRuntimeLoader.getRuntime();
    String str2 = getCurPagePath((BaseRuntime)localObject);
    int i;
    label119:
    String str1;
    label131:
    long l1;
    long l2;
    int j;
    if (localMiniAppInfo != null)
    {
      i = localMiniAppInfo.getReportType();
      if (!this.hasFirstDomReadied)
      {
        this.hasFirstDomReadied = true;
        if ((localObject != null) && (localMiniAppInfo != null))
        {
          QMLog.i("minisdk-start_RuntimeState", "--- report show firstframe appid:" + localMiniAppInfo.appId);
          MiniAppReportManager2.reportPageView("2launch", "first_frame", str2, localMiniAppInfo);
          if (!TextUtils.isEmpty(str2)) {
            break label337;
          }
          localObject = localMiniAppInfo.launchParam.entryPath;
          if (!this.isFromPrelaunch) {
            break label344;
          }
          str1 = "preLaunch";
          MiniReportManager.reportEventType(localMiniAppInfo, 21, (String)localObject, str1, null, 0);
          l1 = System.currentTimeMillis();
          l2 = this.mBeginOnCreate;
          j = this.mLaunchResult;
          if (i != 0) {
            break label350;
          }
        }
      }
    }
    label337:
    label344:
    label350:
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
      MiniReportManager.reportEventType(localMiniAppInfo, 611, str2, null, null, 0, MiniAppStartState.getBaseLibDownloadDesc(localMiniAppInfo.appId), MiniAppStartState.getApkgDownloadDesc(localMiniAppInfo.appId), MiniAppStartState.getBaselibLoadDesc(localMiniAppInfo.appId), MiniAppStartState.getPageSwitchDesc(localMiniAppInfo.appId));
      return;
      i = 0;
      break;
      localObject = str2;
      break label119;
      str1 = null;
      break label131;
    }
  }
  
  private void onMsgFrameworkCompleted(MiniAppInfo paramMiniAppInfo)
  {
    if ((this.isFromPreload) || (this.isFromPrelaunch)) {
      this.hasPreloadCompleted = true;
    }
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      MiniAppStartState.setBaseLibLoad(paramMiniAppInfo.appId, false);
      QMLog.d("minisdk-start_RuntimeState", "framework load finished :" + paramMiniAppInfo.appId);
    }
    QMLog.d("minisdk-start_RuntimeState", "framework load finished");
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
    String str = getCurPagePath(this.mRuntimeLoader.getRuntime());
    int i;
    long l3;
    long l2;
    if (localMiniAppInfo != null)
    {
      i = localMiniAppInfo.getReportType();
      l3 = System.currentTimeMillis();
      l2 = l3 - this.onResumeTime;
      if (l2 >= 0L) {
        break label114;
      }
    }
    for (;;)
    {
      MiniAppReportManager2.reportPageView("2hide", String.valueOf(l1), str, localMiniAppInfo);
      notifyEvent(localMiniAppInfo, "onPause", l3);
      MiniReportManager.reportEventType(localMiniAppInfo, 20, "" + i, l1);
      return;
      i = 0;
      break;
      label114:
      l1 = l2;
    }
  }
  
  private void onMsgResume()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    BaseRuntime localBaseRuntime = this.mRuntimeLoader.getRuntime();
    if (localMiniAppInfo == null) {
      return;
    }
    QMLog.i("minisdk-start_RuntimeState", "--- report bring_to_front appid:" + localMiniAppInfo.appId);
    long l = System.currentTimeMillis();
    this.onResumeTime = l;
    String str2 = getCurPagePath(localBaseRuntime);
    MiniAppReportManager2.reportPageView("2show", "bring_to_front", str2, localMiniAppInfo);
    notifyEvent(localMiniAppInfo, "onResume", l);
    if (TextUtils.isEmpty(str2)) {}
    for (String str1 = localMiniAppInfo.launchParam.entryPath;; str1 = str2)
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 1, str1, null, null, 0);
      if ((localBaseRuntime == null) || (!this.hasFirstDomReadied)) {
        break;
      }
      QMLog.i("minisdk-start_RuntimeState", "--- report click_resume appid:" + localMiniAppInfo.appId);
      MiniAppReportManager2.reportPageView("2launch", "click_resume", str2, localMiniAppInfo);
      MiniReportManager.reportEventType(localMiniAppInfo, 21, str1, null, null, 0);
      return;
    }
  }
  
  private void onMsgRouteDone()
  {
    MiniReportManager.reportEventType(this.mRuntimeLoader.getMiniAppInfo(), 121, getCurPagePath(this.mRuntimeLoader.getRuntime()), null, null, 0);
    int i = WnsConfig.getConfig("qqminiapp", "mini_app_enable_show_clean_routedone", 1);
    int j = WnsConfig.getConfig("qqminiapp", "mini_app_enable_show_clean_time_limit", 5000);
    if (i > 0) {
      ThreadManager.getSubThreadHandler().postDelayed(new AppStateManager.2(this), j);
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
        break label137;
      }
      str1 = localMiniAppInfo.appId;
      if (localMiniAppInfo == null) {
        break label143;
      }
      str2 = localMiniAppInfo.name;
      label49:
      QMLog.i("minisdk-start_RuntimeState", "[" + str1 + "][" + str2 + "] 启动(MiniActivity onCreate)");
      if (!this.isFromPrelaunch) {
        break label149;
      }
    }
    label137:
    label143:
    label149:
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
  
  private void setRestartCount(String paramString, int paramInt)
  {
    restartCount.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void showCleanInfo(int paramInt)
  {
    BaseRuntime localBaseRuntime = this.mRuntimeLoader.getRuntime();
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    if (checkNeedShowCleanInfo(paramInt, localBaseRuntime, localMiniAppInfo)) {
      return;
    }
    Activity localActivity = localBaseRuntime.getAttachedActivity();
    localActivity.runOnUiThread(new AppStateManager.3(this, paramInt, localBaseRuntime, localActivity, localMiniAppInfo));
  }
  
  private void startDownloadX5()
  {
    AppBrandTask.runTaskOnUiThreadDelay(new AppStateManager.4(this), 2000L);
  }
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if ((paramMiniAppStateMessage == null) && (paramMiniAppStateMessage.appRuntimeLoader == this.mRuntimeLoader)) {}
    Object localObject;
    MiniAppInfo localMiniAppInfo;
    do
    {
      return;
      QMLog.i("minisdk-start_RuntimeState", "onStateChange message:" + paramMiniAppStateMessage.what);
      localObject = this.mRuntimeLoader.getRuntime();
      localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
      localObject = getCurPagePath((BaseRuntime)localObject);
      switch (paramMiniAppStateMessage.what)
      {
      default: 
        return;
      case 3: 
        onMsgFrameworkCompleted(localMiniAppInfo);
        return;
      case 20: 
        onMsgStart();
        return;
      case 4: 
        this.launchStatus = 1;
        localObject = new StringBuilder().append("--- report load appid:");
        if (localMiniAppInfo != null) {}
        for (paramMiniAppStateMessage = localMiniAppInfo.appId;; paramMiniAppStateMessage = Integer.valueOf(0))
        {
          QMLog.i("minisdk-start_RuntimeState", paramMiniAppStateMessage);
          MiniAppReportManager2.reportPageView("2load", null, null, localMiniAppInfo);
          return;
        }
      case 10: 
        onMsgRouteDone();
        return;
      case 11: 
        this.launchStatus = 2;
        onMsgDomReady();
        return;
      case 21: 
        onMsgResume();
        return;
      }
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
    onGameLaunch(paramMiniAppStateMessage);
    return;
    onMsgGameDestroy();
    return;
    onJsError(paramMiniAppStateMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager
 * JD-Core Version:    0.7.0.1
 */