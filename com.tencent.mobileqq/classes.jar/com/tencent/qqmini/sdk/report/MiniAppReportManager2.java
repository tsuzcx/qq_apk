package com.tencent.qqmini.sdk.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniReportProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.AppStateManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class MiniAppReportManager2
{
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  public static final boolean IS_MAIN_PROCESS;
  public static final String KEY_ACTION_TYPE = "action_type";
  public static final String KEY_ADD_DURATION_MS = "add_duration_ms";
  public static final String KEY_APP_CONFIG = "app_config";
  public static final String KEY_APP_TYPE = "app_type";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESERVES = "reserves";
  public static final String KEY_RESERVES2 = "reserves2";
  public static final String KEY_SUB_ACTION = "sub_action";
  public static final String KEY_X5_ENABLE = "x5_enable";
  public static final long LAUNCH_TIME_OUT = ;
  public static final String PAGE_VIEW_ACTION = "page_view";
  public static final String TAG = "MiniAppReportManager2";
  public static final String VALUE_SERVICE_NOT_PRELOAD = "service_not_preload";
  public static final String VALUE_SERVICE_PRELAUNCH = "service_prelaunch";
  public static final String VALUE_SERVICE_PRELOAD = "service_preload";
  public static final String VALUE_SERVICE_PRELOAD_FINISHED = "service_preload_finished";
  private static boolean first;
  private static Handler handler;
  public static HashMap<String, Integer> lanchFailCode;
  public static HashMap<String, MiniAppReportManager2.AppLaunchState> launchStateMap;
  private static Runnable launchTimeoutRunnable;
  private static boolean timerEnable;
  
  static
  {
    IS_MAIN_PROCESS = AppLoaderFactory.g().isMainProcess();
    launchStateMap = new HashMap();
    lanchFailCode = new HashMap();
    first = true;
    timerEnable = false;
    handler = null;
    launchTimeoutRunnable = new MiniAppReportManager2.1();
    lanchFailCode.put("load_baselib_fail", Integer.valueOf(402));
    lanchFailCode.put("download_url_fail", Integer.valueOf(403));
    lanchFailCode.put("download_apk_fail", Integer.valueOf(404));
    lanchFailCode.put("unpkg_fail", Integer.valueOf(405));
    lanchFailCode.put("load_pkg_fail", Integer.valueOf(406));
    lanchFailCode.put("system_version_limit_fail", Integer.valueOf(407));
    lanchFailCode.put("qq_version_limit_fail", Integer.valueOf(408));
    lanchFailCode.put("loading_page_kill", Integer.valueOf(409));
    lanchFailCode.put("baselib_task_fail", Integer.valueOf(410));
    lanchFailCode.put("pkg_task_fail", Integer.valueOf(411));
    lanchFailCode.put("start_no_intent", Integer.valueOf(412));
    lanchFailCode.put("appid_conflict", Integer.valueOf(413));
    lanchFailCode.put("init_data_fail", Integer.valueOf(414));
    lanchFailCode.put("not_foreground", Integer.valueOf(415));
    lanchFailCode.put("splash_exit_when_fail", Integer.valueOf(416));
    lanchFailCode.put("shotcut_request_fail", Integer.valueOf(417));
    lanchFailCode.put("offline_not_support", Integer.valueOf(418));
    lanchFailCode.put("offline_not_ready", Integer.valueOf(419));
    lanchFailCode.put("not_ready", Integer.valueOf(420));
    lanchFailCode.put("show_page_kill", Integer.valueOf(421));
  }
  
  private static void doReportOld(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, MiniAppInfo paramMiniAppInfo)
  {
    if (QUAUtil.isQQApp())
    {
      if ("2click".equals(paramString2))
      {
        report(paramString1, "click", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        return;
      }
      if ("2show".equals(paramString2))
      {
        report(paramString1, "show", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        return;
      }
      if ("2hide".equals(paramString2))
      {
        report(paramString1, "hide", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        return;
      }
      if ("2load".equals(paramString2))
      {
        report(paramString1, "load", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        return;
      }
      if ("2close".equals(paramString2))
      {
        report(paramString1, "close", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        return;
      }
      if ("2unload".equals(paramString2))
      {
        report(paramString1, "unload", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        return;
      }
      if ("2show_fail".equals(paramString2))
      {
        report(paramString1, "show_fail", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        return;
      }
      if ("2load_fail".equals(paramString2))
      {
        report(paramString1, "load_fail", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
        return;
      }
      if ("2finishshow".equals(paramString2)) {
        report(paramString1, "finishshow", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
      }
    }
  }
  
  private static AppStateManager getAppStateManager(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    paramMiniAppInfo = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    if (paramMiniAppInfo != null) {
      return paramMiniAppInfo.getAppStateManager();
    }
    return null;
  }
  
  private static String getAppType(MiniAppInfo paramMiniAppInfo)
  {
    String str2 = "0";
    String str1 = str2;
    if (paramMiniAppInfo != null)
    {
      str1 = str2;
      if (paramMiniAppInfo.isReportTypeMiniGame()) {
        str1 = "1";
      }
    }
    return str1;
  }
  
  private static String getReserve2(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = MiniAppStartState.getApkgDownloadDesc(paramString);
    paramString = str;
    if (paramBoolean1)
    {
      paramString = str;
      if (paramBoolean2) {
        paramString = "apkg_download_preloaded";
      }
    }
    return paramString;
  }
  
  private static String getReserve3(MiniAppInfo paramMiniAppInfo, String paramString, AppStateManager paramAppStateManager)
  {
    if (paramMiniAppInfo.isReportTypeMiniGame()) {
      paramMiniAppInfo = MiniAppStartState.getProcessLoadDesc(paramString);
    } else {
      paramMiniAppInfo = MiniAppStartState.getBaselibLoadDesc(paramString);
    }
    paramString = paramMiniAppInfo;
    if (paramAppStateManager != null)
    {
      paramString = paramMiniAppInfo;
      if (paramAppStateManager.isFlutter) {
        if (!paramAppStateManager.isFromPreload)
        {
          paramString = paramMiniAppInfo;
          if (!paramAppStateManager.isFromPrelaunch) {}
        }
        else
        {
          paramString = paramMiniAppInfo;
          if (paramAppStateManager.hasPreloadCompleted) {
            paramString = "service_preload_finished";
          }
        }
      }
    }
    return paramString;
  }
  
  public static long getShowTimeout()
  {
    return WnsConfig.getConfig("qqtriton", "MiniShowTimeout", 45000L);
  }
  
  private static String getTimeOutCode(long paramLong)
  {
    if (paramLong < 0L) {
      return "timeout-1";
    }
    if (paramLong < 15000L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeout_");
      localStringBuilder.append(Math.round((float)(paramLong / 1000L)));
      return localStringBuilder.toString();
    }
    if (paramLong < 25000L) {
      return "timeout_25";
    }
    return "timeout";
  }
  
  private static boolean isNeedFlush(String paramString1, String paramString2)
  {
    return ("2hide".equals(paramString1)) || (("2show".equals(paramString1)) && (("first_frame".equals(paramString2)) || ("click_resume".equals(paramString2))));
  }
  
  private static void loadLaunchStates()
  {
    SharedPreferences localSharedPreferences = AppLoaderFactory.g().getContext().getSharedPreferences("MiniAppLaunshState", 4);
    Object localObject = localSharedPreferences.getString("appid", null);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(",");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if (!TextUtils.isEmpty(localCharSequence))
        {
          String str = localSharedPreferences.getString(localCharSequence, null);
          if (str != null)
          {
            MiniAppReportManager2.AppLaunchState localAppLaunchState = new MiniAppReportManager2.AppLaunchState();
            localAppLaunchState.fromJson(str);
            if (!TextUtils.isEmpty(localAppLaunchState.appId)) {
              launchStateMap.put(localCharSequence, localAppLaunchState);
            }
          }
        }
        i += 1;
      }
      setTimeOutForLaunch();
    }
  }
  
  public static boolean needReportData(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    return true;
  }
  
  public static void onEnterBackground()
  {
    QMLog.d("MiniAppReportManager2", "onEnterBackground");
    try
    {
      MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager2.3());
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniAppReportManager2", "onEnterBackground exception", localThrowable);
    }
  }
  
  private static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, MiniAppInfo paramMiniAppInfo)
  {
    doReportOld(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
    String str1 = getAppType(paramMiniAppInfo);
    if (QMLog.isDebugEnabled())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportPageViewInMainProcess  new report called with: [launchId = ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("], [subActionType = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], [appType = ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("], [reserves = ");
      ((StringBuilder)localObject).append(paramString5);
      ((StringBuilder)localObject).append("], [reserves2 = ");
      ((StringBuilder)localObject).append(paramString6);
      ((StringBuilder)localObject).append("], [reserves3 = ");
      ((StringBuilder)localObject).append(paramString7);
      ((StringBuilder)localObject).append("], [path =");
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append("]");
      QMLog.d("MiniAppReportManager2", ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((List)localObject).addAll(MiniProgramReportHelper.newUserInfoEntries());
    String str2 = AppBrandUtil.getUrlWithoutParams(paramString4);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null)) {
      paramString4 = String.valueOf(paramMiniAppInfo.launchParam.scene);
    } else {
      paramString4 = null;
    }
    ((List)localObject).addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppInfo, str2, paramString4, paramString1, paramString2, paramString5, paramString6, paramString7, null, null, null, str1, paramString3));
    ((List)localObject).addAll(MiniProgramReportHelper.newGenericEntries());
    if (!QUAUtil.isQQApp())
    {
      ((List)localObject).addAll(MiniProgramReportHelper.newThirdSourceEntries());
      ((List)localObject).add(MiniProgramReportHelper.newEntry("customInfo", paramMiniAppInfo.customInfo));
    }
    if ((WnsConfig.getConfig("qqminiapp", "mini_app_report_first_frame_flush", 1) == 1) && (isNeedFlush(paramString2, paramString5))) {
      MiniProgramReporter.getInstance().setReportLaunchNeedflush(true);
    }
    int i;
    if ((!QUAUtil.isQQApp()) && (!QUAUtil.isMicroApp())) {
      i = 12;
    } else {
      i = 2;
    }
    paramString1 = MiniProgramReportHelper.newSingleReportData(i, (List)localObject, null);
    MiniProgramReporter.getInstance().addDcData(paramString1);
  }
  
  private static void reportLaunchFail(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, String paramString3, String paramString4, String paramString5)
  {
    Integer localInteger = (Integer)lanchFailCode.get(paramString1);
    paramString1 = localInteger;
    if (localInteger == null) {
      paramString1 = Integer.valueOf(401);
    }
    MiniReportManager.reportEventType(paramMiniAppInfo, 2, paramString2, null, null, paramString1.intValue(), paramString4, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(paramString3), MiniAppStartState.getApkgDownloadDesc(paramString3), paramString5, MiniAppStartState.getPageSwitchDesc(paramString3));
  }
  
  public static void reportLaunchPiecewise(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    MiniAppReportManager2.AppLaunchState localAppLaunchState = (MiniAppReportManager2.AppLaunchState)launchStateMap.get(paramMiniAppInfo.appId);
    Object localObject = "";
    if (localAppLaunchState != null)
    {
      if (localAppLaunchState.flutterMode)
      {
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append("flutter");
        paramString = paramString.toString();
      }
      else if (MiniAppReportManager2.AppLaunchState.hasX5)
      {
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append("_webview_x5");
        paramString = paramString.toString();
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append("_webview_system");
        paramString = paramString.toString();
      }
      localObject = paramString;
      if (localAppLaunchState.hasPkg)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_hasPkg");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    MiniReportManager.reportEventType(paramMiniAppInfo, paramInt, (String)localObject, MiniReportManager.getAppType(paramMiniAppInfo));
  }
  
  public static void reportPageView(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      if (IS_MAIN_PROCESS)
      {
        reportPageViewInMainProcess(paramString1, paramString2, paramString3, paramMiniAppInfo);
        return;
      }
      MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager2.2(paramMiniAppInfo, paramString1, paramString3, paramString2));
      reportQulaityResult(paramString1, paramString2, paramString3, paramMiniAppInfo);
      if (("2unload".equals(paramString1)) && (paramMiniAppInfo != null)) {
        MiniAppStartState.removeState(paramMiniAppInfo.appId);
      }
      setCrashReportAppInfo(paramString1, paramMiniAppInfo);
      return;
    }
    catch (Throwable paramString1)
    {
      QMLog.e("MiniAppReportManager2", "", paramString1);
    }
  }
  
  public static void reportPageViewInMainProcess(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    MiniAppReportManager2.AppLaunchState localAppLaunchState = updateLaunchState(paramString1, paramString2, paramString3, paramMiniAppInfo);
    if (localAppLaunchState == null)
    {
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("new report (launchState is not exist): [subActionType = ");
      paramMiniAppInfo.append(paramString1);
      paramMiniAppInfo.append("], [reserves = ");
      paramMiniAppInfo.append(paramString2);
      paramMiniAppInfo.append("], [path = ");
      paramMiniAppInfo.append(paramString3);
      paramMiniAppInfo.append("]");
      QMLog.d("MiniAppReportManager2", paramMiniAppInfo.toString());
      return;
    }
    if (QMLog.isDebugEnabled())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportPageViewInMainProcess called with: launchId = [");
      localStringBuilder.append(localAppLaunchState.launchId);
      localStringBuilder.append("], subActionType = [");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], reserves = [");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], path = [");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("]");
      QMLog.d("MiniAppReportManager2", localStringBuilder.toString());
    }
    long l1 = localAppLaunchState.launchTime - localAppLaunchState.clickTime;
    long l2 = localAppLaunchState.hideTime;
    long l3 = localAppLaunchState.showTime;
    long l4 = localAppLaunchState.loadTime;
    long l5 = localAppLaunchState.clickTime;
    long l6 = localAppLaunchState.loadEndTime;
    long l7 = localAppLaunchState.clickTime;
    if (("2back_key".equals(paramString1)) && (localAppLaunchState.needReportLaunchResult))
    {
      report("page_view", "2show_fail", localAppLaunchState.launchId, null, "back_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
      localAppLaunchState.needReportLaunchResult = false;
    }
    if (("2close".equals(paramString1)) && (localAppLaunchState.needReportLaunchResult))
    {
      report("page_view", "2show_fail", localAppLaunchState.launchId, null, "close_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
      localAppLaunchState.needReportLaunchResult = false;
    }
    if ("2hide".equals(paramString1))
    {
      if (localAppLaunchState.needReportLaunchResult)
      {
        report("page_view", "2show_fail", localAppLaunchState.launchId, null, "home_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
        localAppLaunchState.needReportLaunchResult = false;
      }
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, null, paramString2, String.valueOf(l2 - l3), paramMiniAppInfo);
      return;
    }
    if ("2launch_fail".equals(paramString1))
    {
      if (localAppLaunchState.needReportLaunchResult)
      {
        report("page_view", "2show_fail", localAppLaunchState.launchId, null, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
        localAppLaunchState.needReportLaunchResult = false;
      }
      return;
    }
    if ("2launch".equals(paramString1))
    {
      if (localAppLaunchState.needReportLaunchResult)
      {
        report("page_view", "2show", localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
        localAppLaunchState.needReportLaunchResult = false;
      }
      if ("first_frame".equals(paramString2)) {
        report("page_view", "2show", localAppLaunchState.launchId, paramString3, "first_frame_extend", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
      }
      return;
    }
    if ("2load".equals(paramString1))
    {
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l4 - l5), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
      return;
    }
    if ("2load_end".equals(paramString1))
    {
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l6 - l7), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
      return;
    }
    report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, null, localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
  }
  
  private static void reportQualityColdStart(String paramString1, MiniAppInfo paramMiniAppInfo, String paramString2, String paramString3)
  {
    MiniAppStartState.updateState(paramString2, true);
    boolean bool;
    if ((paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.supportNativeRenderMode())) {
      bool = true;
    } else {
      bool = false;
    }
    if ((bool) && (!MiniAppPrelaunchRecorder.get().isCheckinColdStart())) {
      return;
    }
    String str2 = getReserve2(paramString2, bool, MiniAppPrelaunchRecorder.get().isPrelaunchSuccess());
    AppStateManager localAppStateManager = getAppStateManager(paramMiniAppInfo);
    String str1 = getReserve3(paramMiniAppInfo, paramString2, localAppStateManager);
    if ((MiniAppStartState.getBaseLibDownload(paramString2) == 1) && (localAppStateManager != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check prelaunch  hasPreloadCompleted:");
      localStringBuilder.append(localAppStateManager.hasPreloadCompleted);
      localStringBuilder.append("   isFromPrelaunch:");
      localStringBuilder.append(localAppStateManager.isFromPrelaunch);
      QMLog.i("MiniAppReportManager2", localStringBuilder.toString());
      if ((localAppStateManager.hasPreloadCompleted) && (localAppStateManager.isFromPrelaunch)) {
        str1 = "service_prelaunch";
      }
    }
    MiniReportManager.reportEventType(paramMiniAppInfo, 2, paramString1, null, null, 0, paramString3, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(paramString2), str2, str1, "cold_start");
    if (bool) {
      MiniAppStartState.reset(paramString2, true);
    }
  }
  
  private static void reportQulaityResult(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    String str1;
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      str1 = paramMiniAppInfo.appId;
    } else {
      str1 = "";
    }
    String str2;
    if (paramMiniAppInfo.isReportTypeMiniGame()) {
      str2 = "1";
    } else {
      str2 = "0";
    }
    String str3;
    if (paramMiniAppInfo.isReportTypeMiniGame()) {
      str3 = MiniAppStartState.getProcessLoadDesc(str1);
    } else {
      str3 = MiniAppStartState.getBaselibLoadDesc(str1);
    }
    if ("2launch_fail".equals(paramString1))
    {
      reportLaunchFail(paramString2, paramString3, paramMiniAppInfo, str1, str2, str3);
      return;
    }
    if (("2launch".equals(paramString1)) && ("first_frame".equals(paramString2)))
    {
      reportQualityColdStart(paramString3, paramMiniAppInfo, str1, str2);
      return;
    }
    if (("2launch".equals(paramString1)) && ("click_resume".equals(paramString2)))
    {
      int i;
      if ((paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.supportNativeRenderMode())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        MiniAppStartState.reset(str1, true);
      }
      if (MiniAppStartState.getPageSwitch(str1) != 1) {
        MiniReportManager.reportEventType(paramMiniAppInfo, 2, paramString3, null, null, 0, str2, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(str1), MiniAppStartState.getApkgDownloadDesc(str1), str3, "hot_start");
      }
    }
  }
  
  private static void reportTimeout(MiniAppReportManager2.AppLaunchState paramAppLaunchState)
  {
    paramAppLaunchState.launchResult = 2;
    long l2 = paramAppLaunchState.hideTime - paramAppLaunchState.clickTime;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = paramAppLaunchState.clickTime - System.currentTimeMillis();
    }
    String str2 = getTimeOutCode(l1);
    MiniAppInfo localMiniAppInfo;
    if (paramAppLaunchState.needReportLaunchResult)
    {
      localMiniAppInfo = new MiniAppInfo();
      localMiniAppInfo.appId = paramAppLaunchState.appId;
    }
    try
    {
      localMiniAppInfo.verType = paramAppLaunchState.verType;
      localMiniAppInfo.setEngineType(paramAppLaunchState.engineType);
      localMiniAppInfo.setReportType(paramAppLaunchState.reportType);
      label90:
      String str1;
      if (paramAppLaunchState.loadTime == 0L) {
        str1 = "2load_fail";
      } else {
        str1 = "2show_fail";
      }
      report("page_view", str1, paramAppLaunchState.launchId, null, str2, String.valueOf(l1), paramAppLaunchState.hasPkgAndX5(), localMiniAppInfo);
      paramAppLaunchState.needReportLaunchResult = false;
      paramAppLaunchState.launchResult = 2;
      saveLaunchStates();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label90;
    }
  }
  
  private static void saveLaunchStates()
  {
    SharedPreferences.Editor localEditor = AppLoaderFactory.g().getContext().getSharedPreferences("MiniAppLaunshState", 4).edit();
    localEditor.clear();
    Iterator localIterator = launchStateMap.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (MiniAppReportManager2.AppLaunchState)((Map.Entry)localObject).getValue();
      if (((MiniAppReportManager2.AppLaunchState)localObject).launchResult == 0)
      {
        localStringBuilder.append(str);
        localStringBuilder.append(',');
        localEditor.putString(str, ((MiniAppReportManager2.AppLaunchState)localObject).toJson());
      }
    }
    localEditor.putString("appid", localStringBuilder.toString());
    localEditor.commit();
  }
  
  public static void setCrashReportAppInfo(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    if (("2show".equals(paramString)) && (paramMiniAppInfo != null))
    {
      paramString = (IMiniReportProxy)ProxyManager.get(IMiniReportProxy.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMiniAppInfo.appId);
      localStringBuilder.append(paramMiniAppInfo.name);
      paramString.setMiniAppInfo(localStringBuilder.toString());
    }
  }
  
  private static void setTimeOutForLaunch()
  {
    if (handler == null) {
      handler = new Handler(Looper.getMainLooper());
    }
    Handler localHandler = handler;
    if ((localHandler != null) && (!timerEnable))
    {
      localHandler.postDelayed(launchTimeoutRunnable, LAUNCH_TIME_OUT);
      timerEnable = true;
    }
  }
  
  public static void stopTimeOutForLaunch()
  {
    timerEnable = false;
    Handler localHandler = handler;
    if (localHandler != null) {
      localHandler.removeCallbacks(launchTimeoutRunnable);
    }
  }
  
  private static MiniAppReportManager2.AppLaunchState updateLaunchState(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      long l = System.currentTimeMillis();
      boolean bool2 = first;
      boolean bool1 = false;
      if (bool2)
      {
        first = false;
        loadLaunchStates();
        launchTimeoutRunnable.run();
      }
      MiniAppReportManager2.AppLaunchState localAppLaunchState = (MiniAppReportManager2.AppLaunchState)launchStateMap.get(paramMiniAppInfo.appId);
      paramString3 = localAppLaunchState;
      if (localAppLaunchState == null)
      {
        paramString3 = new MiniAppReportManager2.AppLaunchState();
        paramString3.launchId = String.valueOf(l);
        launchStateMap.put(paramMiniAppInfo.appId, paramString3);
      }
      paramString3.appId = paramMiniAppInfo.appId;
      paramString3.engineType = paramMiniAppInfo.getEngineType();
      paramString3.reportType = paramMiniAppInfo.getReportType();
      paramString3.verType = paramMiniAppInfo.verType;
      paramString3.activeTime = l;
      if ("2click".equals(paramString1))
      {
        if (paramString3.launchResult != 0) {
          paramString3.launchId = String.valueOf(l);
        }
        paramString3.reset();
        setTimeOutForLaunch();
        paramString3.clickTime = l;
        if (!MiniAppReportManager2.AppLaunchState.hasX5)
        {
          if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getTbsVersion() > 0) {
            bool1 = true;
          }
          MiniAppReportManager2.AppLaunchState.hasX5 = bool1;
        }
        paramString3.hasPkg = ApkgManager.pkgExists(paramMiniAppInfo);
        paramString3.flutterMode = true;
        saveLaunchStates();
      }
      if ((paramString3.launchResult != 0) && ("2show".equals(paramString1)) && ("bring_to_front".equals(paramString2)))
      {
        paramString3.reset();
        setTimeOutForLaunch();
        paramString3.clickTime = l;
        saveLaunchStates();
      }
      if ("2load".equals(paramString1)) {
        paramString3.loadTime = l;
      }
      if ("2load_end".equals(paramString1)) {
        paramString3.loadEndTime = l;
      }
      if ((paramString3.launchResult == 0) && ("2launch".equals(paramString1)))
      {
        paramString3.launchTime = l;
        paramString3.launchResult = 1;
        paramString3.needReportLaunchResult = true;
        saveLaunchStates();
      }
      if ((paramString3.launchResult == 0) && (("2launch_fail".equals(paramString1)) || ("2close".equals(paramString1)) || ("2back_key".equals(paramString1)) || ("2hide".equals(paramString1))))
      {
        paramString3.launchTime = l;
        paramString3.launchResult = 2;
        paramString3.needReportLaunchResult = true;
        saveLaunchStates();
      }
      if ("2show".equals(paramString1))
      {
        paramString3.showTime = l;
        paramString3.hideTime = 0L;
      }
      if ("2hide".equals(paramString1)) {
        paramString3.hideTime = l;
      }
      if ("2unload".equals(paramString1)) {
        launchStateMap.remove(paramMiniAppInfo.appId);
      }
      if (QMLog.isDebugEnabled())
      {
        paramString1 = new StringBuilder();
        paramString1.append("launchState: launchId = [");
        paramString1.append(paramString3.launchId);
        paramString1.append("], launchResult = [");
        paramString1.append(paramString3.launchResult);
        paramString1.append("], clickTime = [");
        paramString1.append(paramString3.clickTime);
        paramString1.append("], launchTime = [");
        paramString1.append(paramString3.launchTime);
        paramString1.append("], showTime = [");
        paramString1.append(paramString3.showTime);
        paramString1.append("], hideTime = [");
        paramString1.append(paramString3.hideTime);
        paramString1.append("]");
        QMLog.d("MiniAppReportManager2", paramString1.toString());
      }
      return paramString3;
    }
    QMLog.d("MiniAppReportManager2", "new report (appId is null)");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppReportManager2
 * JD-Core Version:    0.7.0.1
 */