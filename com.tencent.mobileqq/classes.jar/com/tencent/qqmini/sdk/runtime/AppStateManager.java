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
    long l = this.onResumeTime;
    if ((l > 0L) && (paramLong - l < 5000L))
    {
      paramBaseRuntime = new StringBuilder();
      paramBaseRuntime.append("onResume time < 5000 not show clean info, onResumeTime: ");
      paramBaseRuntime.append(this.onResumeTime);
      paramBaseRuntime.append("  curTime:");
      paramBaseRuntime.append(paramLong);
      QMLog.e("minisdk-start_RuntimeState", paramBaseRuntime.toString());
      return true;
    }
    return false;
  }
  
  private boolean checkNeedShowCleanInfo(int paramInt, BaseRuntime paramBaseRuntime, MiniAppInfo paramMiniAppInfo)
  {
    if (this.hasShowCleanInfo)
    {
      QMLog.i("minisdk-start_RuntimeState", "has shown cleanInfo, not showCleanInfo 1");
      return true;
    }
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
    if ((paramBaseRuntime != null) && (paramBaseRuntime.getAttachedActivity() != null))
    {
      if (!paramBaseRuntime.isForground())
      {
        QMLog.e("minisdk-start_RuntimeState", "showCleanInfo failed, not is forground");
        return true;
      }
      if (!checkRestartCountValid(paramMiniAppInfo.appId)) {
        return true;
      }
      return !paramMiniAppInfo.isEngineTypeMiniApp();
    }
    paramMiniAppInfo = new StringBuilder();
    paramMiniAppInfo.append("showCleanInfo failed,");
    paramMiniAppInfo.append(paramBaseRuntime);
    QMLog.e("minisdk-start_RuntimeState", paramMiniAppInfo.toString());
    return true;
  }
  
  private boolean checkRestartCountValid(String paramString)
  {
    int i = WnsConfig.getConfig("qqminiapp", "mini_app_enable_show_clean_max_count", 3);
    int j = getRestartCount(paramString);
    if (j >= i)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Appid:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("  has restart count:");
      localStringBuilder.append(j);
      localStringBuilder.append("  reach the max count");
      QMLog.i("minisdk-start_RuntimeState", localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Appid:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("  has restart count:");
    localStringBuilder.append(j);
    QMLog.i("minisdk-start_RuntimeState", localStringBuilder.toString());
    setRestartCount(paramString, j + 1);
    return true;
  }
  
  private void checkWhiteScreen(Bitmap paramBitmap, MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      if (ScreenShotUtil.checkIfWhiteScreen(paramBitmap))
      {
        String str = ScreenShotUtil.bitmapTobase64(paramBitmap, WnsConfig.getConfig("qqminiapp", "mini_app_white_screen_shot_max_width", 500), WnsConfig.getConfig("qqminiapp", "mini_app_white_screen_shot_max_height", 500));
        int i = str.length();
        StringBuilder localStringBuilder;
        if (i < 5120)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("--- report white_screen appid:");
          localStringBuilder.append(paramMiniAppInfo.appId);
          localStringBuilder.append(" img:");
          localStringBuilder.append(str);
          QMLog.i("minisdk-start_RuntimeState", localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("--- report white_screen appid:");
          localStringBuilder.append(paramMiniAppInfo.appId);
          localStringBuilder.append(" base64 length:");
          localStringBuilder.append(str.length());
          QMLog.i("minisdk-start_RuntimeState", localStringBuilder.toString());
        }
        MiniReportManager.reportEventType(paramMiniAppInfo, 150, MiniReportManager.getAppType(paramMiniAppInfo), "dom_ready", String.valueOf(str.length()), "", "");
        if (WnsConfig.getConfig("qqminiapp", "mini_app_enable_show_clean_detect_whitescreen", 0) > 0) {
          showCleanInfo(2);
        }
      }
      if (paramBitmap != null)
      {
        paramBitmap.recycle();
        return;
      }
    }
    catch (Throwable paramBitmap)
    {
      QMLog.e("minisdk-start_RuntimeState", "---check white screen failed", paramBitmap);
    }
  }
  
  private void detectWhiteScreen(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.isEngineTypeMiniGame())
    {
      QMLog.i("minisdk-start_RuntimeState", "not detect mini game.");
      return;
    }
    if (WnsConfig.getConfig("qqminiapp", "mini_app_enable_white_screen_check_after_domready", 1) > 0) {
      ThreadManager.getSubThreadHandler().postDelayed(new AppStateManager.1(this, paramMiniAppInfo), 10000L);
    }
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
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.launchParam == null) {
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
  }
  
  private void onGameLaunch(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    Pair localPair = (Pair)paramMiniAppStateMessage.obj;
    int i;
    if (paramMiniAppStateMessage.obj != null) {
      i = ((Integer)localPair.first).intValue();
    } else {
      i = 0;
    }
    int j = i;
    if (i >= 0) {
      j = 0;
    }
    this.mLaunchResult = j;
  }
  
  private void onJsError(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    int i;
    label69:
    do
    {
      try
      {
        if (!mX5GuideShowed)
        {
          if (this.hasFirstDomReadied) {
            return;
          }
          paramMiniAppStateMessage = this.mRuntimeLoader.getRuntime();
          if (paramMiniAppStateMessage != null)
          {
            if (paramMiniAppStateMessage.getAttachedActivity() == null) {
              return;
            }
            i = 1;
            if (WnsConfig.getConfig("qqminiapp", "mini_app_jserror_tip_enable", 1) != 1) {
              break label69;
            }
            continue;
            startDownloadX5();
            return;
          }
        }
        return;
      }
      catch (Throwable paramMiniAppStateMessage)
      {
        QMLog.e("minisdk-start_RuntimeState", "onJsError exception.", paramMiniAppStateMessage);
        return;
      }
      i = 0;
    } while (i != 0);
  }
  
  private void onMsgBackKey()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    String str = getCurPagePath(this.mRuntimeLoader.getRuntime());
    int i;
    if (localMiniAppInfo != null) {
      i = localMiniAppInfo.getReportType();
    } else {
      i = 0;
    }
    if (i == 1) {
      if (localMiniAppInfo != null)
      {
        i = this.launchStatus;
        if (i == 0) {
          SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "load_fail", "loading_page_back_press");
        } else if (i == 1) {
          SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "show_fail", "loading_page_back_press");
        }
      }
      else
      {
        QMLog.e("minisdk-start_RuntimeState", "doOnBackPressed gameConfig=null");
      }
    }
    if (this.hasFirstDomReadied)
    {
      MiniAppReportManager2.reportPageView("2back_key", "inner_page", str, localMiniAppInfo);
      return;
    }
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
    if (localMiniAppInfo != null) {
      i = localMiniAppInfo.getReportType();
    } else {
      i = 0;
    }
    if (!this.hasFirstDomReadied)
    {
      this.hasFirstDomReadied = true;
      if ((localObject != null) && (localMiniAppInfo != null))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("--- report show firstframe appid:");
        ((StringBuilder)localObject).append(localMiniAppInfo.appId);
        QMLog.i("minisdk-start_RuntimeState", ((StringBuilder)localObject).toString());
        MiniAppReportManager2.reportPageView("2launch", "first_frame", str2, localMiniAppInfo);
        if (TextUtils.isEmpty(str2)) {
          localObject = localMiniAppInfo.launchParam.entryPath;
        } else {
          localObject = str2;
        }
        String str1;
        if (this.isFromPrelaunch) {
          str1 = "preLaunch";
        } else {
          str1 = null;
        }
        MiniReportManager.reportEventType(localMiniAppInfo, 21, (String)localObject, str1, null, 0);
        long l1 = System.currentTimeMillis();
        long l2 = this.mBeginOnCreate;
        int j = this.mLaunchResult;
        if (i == 0) {
          localObject = "0";
        } else {
          localObject = "1";
        }
        MiniReportManager.reportEventType(localMiniAppInfo, 1043, null, null, null, j, (String)localObject, l1 - l2, null);
        localObject = new Bundle();
        ((Bundle)localObject).putString("bundle_key_runtime_lifecycle", "first_frame");
        ((Bundle)localObject).putParcelable("bundle_key_appinfo", localMiniAppInfo);
        AppBrandCmdProxy.g().sendCmd("cmd_notify_runtime_lifecycle", (Bundle)localObject, null);
      }
      localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      if ((this.isFlutter) && (((MiniAppProxy)localObject).isDebugVersion())) {
        MiniToast.makeText(MiniAppEnv.g().getContext(), "进入native小程序,仅debug可见", 0).show();
      }
      ((MiniAppProxy)localObject).notifyMiniAppInfo(1, localMiniAppInfo);
      detectWhiteScreen(localMiniAppInfo);
    }
    MiniReportManager.reportEventType(localMiniAppInfo, 611, str2, null, null, 0, MiniAppStartState.getBaseLibDownloadDesc(localMiniAppInfo.appId), MiniAppStartState.getApkgDownloadDesc(localMiniAppInfo.appId), MiniAppStartState.getBaselibLoadDesc(localMiniAppInfo.appId), MiniAppStartState.getPageSwitchDesc(localMiniAppInfo.appId));
  }
  
  private void onMsgFrameworkCompleted(MiniAppInfo paramMiniAppInfo)
  {
    if ((this.isFromPreload) || (this.isFromPrelaunch)) {
      this.hasPreloadCompleted = true;
    }
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      MiniAppStartState.setBaseLibLoad(paramMiniAppInfo.appId, false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("framework load finished :");
      localStringBuilder.append(paramMiniAppInfo.appId);
      QMLog.d("minisdk-start_RuntimeState", localStringBuilder.toString());
    }
    QMLog.d("minisdk-start_RuntimeState", "framework load finished");
  }
  
  private void onMsgGameDestroy()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    if (localMiniAppInfo != null)
    {
      int i = this.launchStatus;
      if ((i == 0) || (i == 1))
      {
        SDKMiniProgramLpReportDC04239.reportPageView(localMiniAppInfo, "1", null, "load_fail", "loading_page_kill");
        MiniAppReportManager2.reportPageView("2launch_fail", "loading_page_kill", null, localMiniAppInfo);
      }
    }
    else
    {
      QMLog.e("minisdk-start_RuntimeState", "doOnDestroy kill self gameConfig=null");
    }
  }
  
  private void onMsgPause()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    Object localObject = getCurPagePath(this.mRuntimeLoader.getRuntime());
    int i;
    if (localMiniAppInfo != null) {
      i = localMiniAppInfo.getReportType();
    } else {
      i = 0;
    }
    long l3 = System.currentTimeMillis();
    long l2 = l3 - this.onResumeTime;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    MiniAppReportManager2.reportPageView("2hide", String.valueOf(l1), (String)localObject, localMiniAppInfo);
    notifyEvent(localMiniAppInfo, "onPause", l3);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(i);
    MiniReportManager.reportEventType(localMiniAppInfo, 20, ((StringBuilder)localObject).toString(), l1);
  }
  
  private void onMsgResume()
  {
    MiniAppInfo localMiniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
    Object localObject2 = this.mRuntimeLoader.getRuntime();
    if (localMiniAppInfo == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("--- report bring_to_front appid:");
    ((StringBuilder)localObject1).append(localMiniAppInfo.appId);
    QMLog.i("minisdk-start_RuntimeState", ((StringBuilder)localObject1).toString());
    long l = System.currentTimeMillis();
    this.onResumeTime = l;
    String str = getCurPagePath((BaseRuntime)localObject2);
    MiniAppReportManager2.reportPageView("2show", "bring_to_front", str, localMiniAppInfo);
    notifyEvent(localMiniAppInfo, "onResume", l);
    if (TextUtils.isEmpty(str)) {
      localObject1 = localMiniAppInfo.launchParam.entryPath;
    } else {
      localObject1 = str;
    }
    MiniReportManager.reportEventType(localMiniAppInfo, 1, (String)localObject1, null, null, 0);
    if ((localObject2 != null) && (this.hasFirstDomReadied))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("--- report click_resume appid:");
      ((StringBuilder)localObject2).append(localMiniAppInfo.appId);
      QMLog.i("minisdk-start_RuntimeState", ((StringBuilder)localObject2).toString());
      MiniAppReportManager2.reportPageView("2launch", "click_resume", str, localMiniAppInfo);
      MiniReportManager.reportEventType(localMiniAppInfo, 21, (String)localObject1, null, null, 0);
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
    if (localMiniAppInfo != null) {
      i = localMiniAppInfo.getReportType();
    } else {
      i = 0;
    }
    this.mBeginOnCreate = System.currentTimeMillis();
    String str2 = "";
    String str1;
    if (localMiniAppInfo != null) {
      str1 = localMiniAppInfo.appId;
    } else {
      str1 = "";
    }
    if (localMiniAppInfo != null) {
      str2 = localMiniAppInfo.name;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(str1);
    localStringBuilder.append("][");
    localStringBuilder.append(str2);
    localStringBuilder.append("] 启动(MiniActivity onCreate)");
    QMLog.i("minisdk-start_RuntimeState", localStringBuilder.toString());
    if (this.isFromPrelaunch) {
      str1 = "preLaunch";
    } else {
      str1 = null;
    }
    MiniReportManager.reportEventType(localMiniAppInfo, 24, null, str1, null, 0, String.valueOf(i), 0L, null, "", "", "", "");
    this.launchStatus = 0;
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
    if ((paramMiniAppStateMessage == null) && (paramMiniAppStateMessage.appRuntimeLoader == this.mRuntimeLoader)) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onStateChange message:");
    ((StringBuilder)localObject1).append(paramMiniAppStateMessage.what);
    QMLog.i("minisdk-start_RuntimeState", ((StringBuilder)localObject1).toString());
    Object localObject2 = this.mRuntimeLoader.getRuntime();
    localObject1 = this.mRuntimeLoader.getMiniAppInfo();
    localObject2 = getCurPagePath((BaseRuntime)localObject2);
    int i = paramMiniAppStateMessage.what;
    if (i != 3)
    {
      if (i != 4)
      {
        if (i != 20)
        {
          if (i != 21)
          {
            if (i != 24)
            {
              if (i != 25)
              {
                if (i != 71) {
                  switch (i)
                  {
                  default: 
                    switch (i)
                    {
                    default: 
                      return;
                    case 64: 
                      onMsgGameDestroy();
                      return;
                    case 63: 
                      onGameLaunch(paramMiniAppStateMessage);
                      return;
                    case 62: 
                      MiniAppReportManager2.reportPageView("2unload", null, (String)localObject2, (MiniAppInfo)localObject1);
                      MiniReportManager.reportEventType((MiniAppInfo)localObject1, 22, MiniReportManager.getAppType((MiniAppInfo)localObject1));
                      return;
                    case 61: 
                      MiniAppReportManager2.reportPageView("2close", "loading_page", null, (MiniAppInfo)localObject1);
                      return;
                    }
                    onMsgCloseInner();
                    return;
                  case 12: 
                    if (localObject1 == null) {
                      break;
                    }
                    paramMiniAppStateMessage = new StringBuilder();
                    paramMiniAppStateMessage.append("--- report launch fail appid:");
                    paramMiniAppStateMessage.append(((MiniAppInfo)localObject1).appId);
                    QMLog.i("minisdk-start_RuntimeState", paramMiniAppStateMessage.toString());
                    MiniAppReportManager2.reportPageView("2launch_fail", "flutter_sdk_fail", (String)localObject2, (MiniAppInfo)localObject1);
                    return;
                  case 11: 
                    this.launchStatus = 2;
                    onMsgDomReady();
                    return;
                  case 10: 
                    onMsgRouteDone();
                    return;
                  }
                } else {
                  onJsError(paramMiniAppStateMessage);
                }
              }
              else {
                onMsgBackKey();
              }
            }
            else {
              onMsgPause();
            }
          }
          else {
            onMsgResume();
          }
        }
        else {
          onMsgStart();
        }
      }
      else
      {
        this.launchStatus = 1;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("--- report load appid:");
        if (localObject1 != null) {
          paramMiniAppStateMessage = ((MiniAppInfo)localObject1).appId;
        } else {
          paramMiniAppStateMessage = Integer.valueOf(0);
        }
        ((StringBuilder)localObject2).append(paramMiniAppStateMessage);
        QMLog.i("minisdk-start_RuntimeState", ((StringBuilder)localObject2).toString());
        MiniAppReportManager2.reportPageView("2load", null, null, (MiniAppInfo)localObject1);
      }
    }
    else {
      onMsgFrameworkCompleted((MiniAppInfo)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager
 * JD-Core Version:    0.7.0.1
 */