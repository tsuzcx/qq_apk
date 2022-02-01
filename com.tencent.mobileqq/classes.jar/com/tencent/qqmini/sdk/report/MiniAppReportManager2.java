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
  public static final boolean isMainProcess = AppLoaderFactory.g().isMainProcess();
  public static HashMap<String, Integer> lanchFailCode;
  public static HashMap<String, MiniAppReportManager2.AppLaunchState> launchStateMap = new HashMap();
  private static Runnable launchTimeoutRunnable;
  private static boolean timerEnable;
  
  static
  {
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
      if (!"2click".equals(paramString2)) {
        break label32;
      }
      report(paramString1, "click", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
    }
    label32:
    do
    {
      return;
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
    } while (!"2finishshow".equals(paramString2));
    report(paramString1, "finishshow", paramString3, paramString4, paramString5, paramString6, paramString7, paramMiniAppInfo);
  }
  
  private static AppStateManager getAppStateManager(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return null;
      paramMiniAppInfo = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    } while (paramMiniAppInfo == null);
    return paramMiniAppInfo.getAppStateManager();
  }
  
  private static String getAppType(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      if (paramMiniAppInfo.isReportTypeMiniGame()) {
        return "1";
      }
      return "0";
    }
    return "0";
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
    if (paramLong < 15000L) {
      return "timeout_" + Math.round((float)(paramLong / 1000L));
    }
    if (paramLong < 25000L) {
      return "timeout_25";
    }
    return "timeout";
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
    if (QMLog.isDebugEnabled()) {
      QMLog.d("MiniAppReportManager2", "reportPageViewInMainProcess  new report called with: [launchId = " + paramString3 + "], [subActionType = " + paramString2 + "], [appType = " + str1 + "], [reserves = " + paramString5 + "], [reserves2 = " + paramString6 + "], [reserves3 = " + paramString7 + "], [path =" + paramString4 + "]");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
    String str2 = AppBrandUtil.getUrlWithoutParams(paramString4);
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null))
    {
      paramString4 = String.valueOf(paramMiniAppInfo.launchParam.scene);
      localArrayList.addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppInfo, str2, paramString4, paramString1, paramString2, paramString5, paramString6, paramString7, null, null, null, str1, paramString3));
      localArrayList.addAll(MiniProgramReportHelper.newGenericEntries());
      if (!QUAUtil.isQQApp())
      {
        localArrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        localArrayList.add(MiniProgramReportHelper.newEntry("customInfo", paramMiniAppInfo.customInfo));
      }
      if ((WnsConfig.getConfig("qqminiapp", "mini_app_report_first_frame_flush", 1) == 1) && (("2hide".equals(paramString2)) || (("2show".equals(paramString2)) && (("first_frame".equals(paramString5)) || ("click_resume".equals(paramString5)))))) {
        MiniProgramReporter.getInstance().setReportLaunchNeedflush(true);
      }
      if ((!QUAUtil.isQQApp()) && (!QUAUtil.isMicroApp())) {
        break label349;
      }
    }
    label349:
    for (int i = 2;; i = 12)
    {
      paramString1 = MiniProgramReportHelper.newSingleReportData(i, localArrayList, null);
      MiniProgramReporter.getInstance().addDcData(paramString1);
      return;
      paramString4 = null;
      break;
    }
  }
  
  public static void reportLaunchPiecewise(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo)
  {
    MiniAppReportManager2.AppLaunchState localAppLaunchState = (MiniAppReportManager2.AppLaunchState)launchStateMap.get(paramMiniAppInfo.appId);
    String str = "";
    if (localAppLaunchState != null)
    {
      if (!localAppLaunchState.flutterMode) {
        break label97;
      }
      paramString = "" + "flutter";
    }
    for (;;)
    {
      str = paramString;
      if (localAppLaunchState.hasPkg) {
        str = paramString + "_hasPkg";
      }
      MiniReportManager.reportEventType(paramMiniAppInfo, paramInt, str, MiniReportManager.getAppType(paramMiniAppInfo));
      return;
      label97:
      if (MiniAppReportManager2.AppLaunchState.hasX5) {
        paramString = "" + "_webview_x5";
      } else {
        paramString = "" + "_webview_system";
      }
    }
  }
  
  public static void reportPageView(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    try
    {
      if (isMainProcess)
      {
        reportPageViewInMainProcess(paramString1, paramString2, paramString3, paramMiniAppInfo);
        return;
      }
      MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager2.2(paramMiniAppInfo, paramString1, paramString3, paramString2));
      reportQulaityResult(paramString1, paramString2, paramString3, paramMiniAppInfo);
      if (("2unload".equals(paramString1)) && (paramMiniAppInfo != null))
      {
        MiniAppStartState.removeState(paramMiniAppInfo.appId);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.e("MiniAppReportManager2", "", paramString1);
    }
  }
  
  public static void reportPageViewInMainProcess(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    MiniAppReportManager2.AppLaunchState localAppLaunchState = updateLaunchState(paramString1, paramString2, paramString3, paramMiniAppInfo);
    if (localAppLaunchState == null) {
      QMLog.d("MiniAppReportManager2", "new report (launchState is not exist): [subActionType = " + paramString1 + "], [reserves = " + paramString2 + "], [path = " + paramString3 + "]");
    }
    long l1;
    long l4;
    long l5;
    long l6;
    long l7;
    do
    {
      do
      {
        return;
        if (QMLog.isDebugEnabled()) {
          QMLog.d("MiniAppReportManager2", "reportPageViewInMainProcess called with: launchId = [" + localAppLaunchState.launchId + "], subActionType = [" + paramString1 + "], reserves = [" + paramString2 + "], path = [" + paramString3 + "]");
        }
        l1 = localAppLaunchState.launchTime - localAppLaunchState.clickTime;
        long l2 = localAppLaunchState.hideTime;
        long l3 = localAppLaunchState.showTime;
        l4 = localAppLaunchState.loadTime;
        l5 = localAppLaunchState.clickTime;
        l6 = localAppLaunchState.loadEndTime;
        l7 = localAppLaunchState.clickTime;
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
        if (!"2launch_fail".equals(paramString1)) {
          break;
        }
      } while (!localAppLaunchState.needReportLaunchResult);
      report("page_view", "2show_fail", localAppLaunchState.launchId, null, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
      localAppLaunchState.needReportLaunchResult = false;
      return;
      if (!"2launch".equals(paramString1)) {
        break;
      }
      if (localAppLaunchState.needReportLaunchResult)
      {
        report("page_view", "2show", localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
        localAppLaunchState.needReportLaunchResult = false;
      }
    } while (!"first_frame".equals(paramString2));
    report("page_view", "2show", localAppLaunchState.launchId, paramString3, "first_frame_extend", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppInfo);
    return;
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
  
  private static void reportQulaityResult(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId))) {}
    for (String str1 = paramMiniAppInfo.appId;; str1 = "")
    {
      String str2;
      if (paramMiniAppInfo.isReportTypeMiniGame())
      {
        str2 = "1";
        if (!paramMiniAppInfo.isReportTypeMiniGame()) {
          break label120;
        }
      }
      label120:
      for (String str3 = MiniAppStartState.getProcessLoadDesc(str1);; str3 = MiniAppStartState.getBaselibLoadDesc(str1))
      {
        if (!"2launch_fail".equals(paramString1)) {
          break label130;
        }
        paramString2 = (Integer)lanchFailCode.get(paramString2);
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = Integer.valueOf(401);
        }
        MiniReportManager.reportEventType(paramMiniAppInfo, 2, paramString3, null, null, paramString1.intValue(), str2, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(str1), MiniAppStartState.getApkgDownloadDesc(str1), str3, MiniAppStartState.getPageSwitchDesc(str1));
        return;
        str2 = "0";
        break;
      }
      label130:
      int i;
      if (("2launch".equals(paramString1)) && ("first_frame".equals(paramString2)))
      {
        MiniAppStartState.updateState(str1, true);
        if ((paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.supportNativeRenderMode()))
        {
          i = 1;
          label173:
          if ((i != 0) && (!MiniAppPrelaunchRecorder.get().isCheckinColdStart())) {
            break label405;
          }
          boolean bool = MiniAppPrelaunchRecorder.get().isPrelaunchSuccess();
          paramString1 = MiniAppStartState.getApkgDownloadDesc(str1);
          str3 = paramString1;
          if (i != 0)
          {
            str3 = paramString1;
            if (bool) {
              str3 = "apkg_download_preloaded";
            }
          }
          if (!paramMiniAppInfo.isReportTypeMiniGame()) {
            break label407;
          }
          paramString1 = MiniAppStartState.getProcessLoadDesc(str1);
          label235:
          AppStateManager localAppStateManager = getAppStateManager(paramMiniAppInfo);
          paramString2 = paramString1;
          if (localAppStateManager != null)
          {
            paramString2 = paramString1;
            if (localAppStateManager.isFlutter) {
              if (!localAppStateManager.isFromPreload)
              {
                paramString2 = paramString1;
                if (!localAppStateManager.isFromPrelaunch) {}
              }
              else
              {
                paramString2 = paramString1;
                if (localAppStateManager.hasPreloadCompleted) {
                  paramString2 = "service_preload_finished";
                }
              }
            }
          }
          if (MiniAppStartState.getBaseLibDownload(str1) != 1) {
            break label513;
          }
          QMLog.i("MiniAppReportManager2", "check prelaunch  hasPreloadCompleted:" + localAppStateManager.hasPreloadCompleted + "   isFromPrelaunch:" + localAppStateManager.isFromPrelaunch);
          if ((localAppStateManager == null) || (!localAppStateManager.hasPreloadCompleted) || (!localAppStateManager.isFromPrelaunch)) {
            break label513;
          }
        }
      }
      label513:
      for (paramString1 = "service_prelaunch";; paramString1 = paramString2)
      {
        MiniReportManager.reportEventType(paramMiniAppInfo, 2, paramString3, null, null, 0, str2, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(str1), str3, paramString1, "cold_start");
        if (i == 0) {
          break;
        }
        MiniAppStartState.reset(str1, true);
        return;
        i = 0;
        break label173;
        label405:
        break;
        label407:
        paramString1 = MiniAppStartState.getBaselibLoadDesc(str1);
        break label235;
        if ((!"2launch".equals(paramString1)) || (!"click_resume".equals(paramString2))) {
          break;
        }
        if ((paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.supportNativeRenderMode())) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            MiniAppStartState.reset(str1, true);
          }
          if ((MiniAppStartState.getPageSwitch(str1) == 1) || (i != 0)) {
            break;
          }
          MiniReportManager.reportEventType(paramMiniAppInfo, 2, paramString3, null, null, 0, str2, 0L, null, MiniAppStartState.getBaseLibDownloadDesc(str1), MiniAppStartState.getApkgDownloadDesc(str1), str3, "hot_start");
          return;
        }
      }
    }
  }
  
  private static void reportTimeout(MiniAppReportManager2.AppLaunchState paramAppLaunchState)
  {
    paramAppLaunchState.launchResult = 2;
    long l = paramAppLaunchState.hideTime - paramAppLaunchState.clickTime;
    if (l <= 0L) {
      l = paramAppLaunchState.clickTime - System.currentTimeMillis();
    }
    for (;;)
    {
      String str2 = getTimeOutCode(l);
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
        label88:
        if (paramAppLaunchState.loadTime == 0L) {}
        for (String str1 = "2load_fail";; str1 = "2show_fail")
        {
          report("page_view", str1, paramAppLaunchState.launchId, null, str2, String.valueOf(l), paramAppLaunchState.hasPkgAndX5(), localMiniAppInfo);
          paramAppLaunchState.needReportLaunchResult = false;
          paramAppLaunchState.launchResult = 2;
          saveLaunchStates();
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label88;
      }
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
  
  private static void setTimeOutForLaunch()
  {
    if (handler == null) {
      handler = new Handler(Looper.getMainLooper());
    }
    if ((handler != null) && (!timerEnable))
    {
      handler.postDelayed(launchTimeoutRunnable, LAUNCH_TIME_OUT);
      timerEnable = true;
    }
  }
  
  public static void stopTimeOutForLaunch()
  {
    timerEnable = false;
    if (handler != null) {
      handler.removeCallbacks(launchTimeoutRunnable);
    }
  }
  
  private static MiniAppReportManager2.AppLaunchState updateLaunchState(String paramString1, String paramString2, String paramString3, MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      QMLog.d("MiniAppReportManager2", "new report (appId is null)");
      paramString1 = null;
      return paramString1;
    }
    long l = System.currentTimeMillis();
    if (first)
    {
      first = false;
      loadLaunchStates();
      launchTimeoutRunnable.run();
    }
    paramString3 = (MiniAppReportManager2.AppLaunchState)launchStateMap.get(paramMiniAppInfo.appId);
    if (paramString3 == null)
    {
      paramString3 = new MiniAppReportManager2.AppLaunchState();
      paramString3.launchId = String.valueOf(l);
      launchStateMap.put(paramMiniAppInfo.appId, paramString3);
    }
    for (;;)
    {
      paramString3.appId = paramMiniAppInfo.appId;
      paramString3.engineType = paramMiniAppInfo.getEngineType();
      paramString3.reportType = paramMiniAppInfo.getReportType();
      paramString3.verType = paramMiniAppInfo.verType;
      paramString3.activeTime = l;
      if ("2click".equals(paramString1))
      {
        if (paramString3.launchResult != 0) {
          break label548;
        }
        label153:
        paramString3.reset();
        setTimeOutForLaunch();
        paramString3.clickTime = l;
        if (!MiniAppReportManager2.AppLaunchState.hasX5) {
          if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getTbsVersion() <= 0) {
            break label560;
          }
        }
      }
      label548:
      label560:
      for (boolean bool = true;; bool = false)
      {
        MiniAppReportManager2.AppLaunchState.hasX5 = bool;
        paramString3.hasPkg = ApkgManager.pkgExists(paramMiniAppInfo);
        paramString3.flutterMode = true;
        saveLaunchStates();
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
        paramString1 = paramString3;
        if (!QMLog.isDebugEnabled()) {
          break;
        }
        QMLog.d("MiniAppReportManager2", "launchState: launchId = [" + paramString3.launchId + "], launchResult = [" + paramString3.launchResult + "], clickTime = [" + paramString3.clickTime + "], launchTime = [" + paramString3.launchTime + "], showTime = [" + paramString3.showTime + "], hideTime = [" + paramString3.hideTime + "]");
        return paramString3;
        paramString3.launchId = String.valueOf(l);
        break label153;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppReportManager2
 * JD-Core Version:    0.7.0.1
 */