package com.tencent.mobileqq.mini.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class MiniAppReportManager2
{
  public static final String KEY_ACTION_TYPE = "action_type";
  public static final String KEY_APP_CONFIG = "app_config";
  public static final String KEY_APP_TYPE = "app_type";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESERVES = "reserves";
  public static final String KEY_SUB_ACTION = "sub_action";
  public static final long LAUNCH_TIME_OUT = ;
  public static final String PAGE_VIEW_ACTION = "page_view";
  public static final String TAG = "MiniAppReportManager2";
  private static boolean first;
  private static Handler handler = null;
  public static final boolean isMainProcess;
  public static HashMap<String, Integer> lanchFailCode;
  public static HashMap<String, MiniAppReportManager2.AppLaunchState> launchStateMap = new HashMap();
  private static Runnable launchTimeoutRunnable;
  private static boolean timerEnable;
  
  static
  {
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1) {
      bool = true;
    } else {
      bool = false;
    }
    isMainProcess = bool;
    lanchFailCode = new HashMap();
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
    first = true;
    launchTimeoutRunnable = new MiniAppReportManager2.2();
    timerEnable = false;
  }
  
  private static String getAppType(MiniAppConfig paramMiniAppConfig)
  {
    String str2 = "0";
    String str1 = str2;
    if (paramMiniAppConfig != null)
    {
      str1 = str2;
      if (paramMiniAppConfig.isReportTypeMiniGame()) {
        str1 = "1";
      }
    }
    return str1;
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
  
  private static void loadLaunchStates()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppLaunshState", 4);
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
  
  public static boolean needReportData(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    return true;
  }
  
  private static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, MiniAppConfig paramMiniAppConfig)
  {
    String str1 = getAppType(paramMiniAppConfig);
    if (QLog.isColorLevel())
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
      QLog.d("MiniAppReportManager2", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((List)localObject).addAll(MiniProgramReportHelper.newUserInfoEntries());
    String str2 = AppBrandUtil.getUrlWithoutParams(paramString4);
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null)) {
      paramString4 = String.valueOf(paramMiniAppConfig.launchParam.scene);
    } else {
      paramString4 = null;
    }
    ((List)localObject).addAll(MiniProgramReportHelper.newBusinessEntries(paramMiniAppConfig, str2, paramString4, paramString1, paramString2, paramString5, paramString6, paramString7, null, null, null, str1, paramString3));
    ((List)localObject).addAll(MiniProgramReportHelper.newGenericEntries());
    paramString1 = MiniProgramReportHelper.newSingleReportData(2, (List)localObject, null);
    MiniProgramReporter.getInstance().addDcData(paramString1);
    if ((QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_first_frame_flush", 1) == 1) && ("2show".equals(paramString2)) && ("first_frame".equals(paramString5))) {
      MiniProgramReporter.getInstance().setReportLaunchNeedflush(true);
    }
  }
  
  public static void reportPageView(String paramString1, String paramString2, String paramString3, MiniAppConfig paramMiniAppConfig)
  {
    for (;;)
    {
      try
      {
        if (isMainProcess)
        {
          reportPageViewInMainProcess(paramString1, paramString2, paramString3, paramMiniAppConfig);
          return;
        }
        MiniProgramReporter.getInstance().getReportHandler().post(new MiniAppReportManager2.1(paramMiniAppConfig, paramString1, paramString3, paramString2));
        if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.appId))) {
          break label437;
        }
        str2 = paramMiniAppConfig.config.appId;
        boolean bool = "2launch_fail".equals(paramString1);
        String str1 = "0";
        Object localObject;
        int i;
        String str3;
        if (bool)
        {
          localObject = (Integer)lanchFailCode.get(paramString2);
          paramString2 = (String)localObject;
          if (localObject == null) {
            paramString2 = Integer.valueOf(401);
          }
          i = paramString2.intValue();
          if (paramMiniAppConfig.isReportTypeMiniGame()) {
            str1 = "1";
          }
          localObject = MiniAppStartState.getBaseLibDownloadDesc(str2);
          str3 = MiniAppStartState.getApkgDownloadDesc(str2);
          if (paramMiniAppConfig.isReportTypeMiniGame()) {
            paramString2 = MiniAppStartState.getProcessLoadDesc(str2);
          } else {
            paramString2 = MiniAppStartState.getBaselibLoadDesc(str2);
          }
          str2 = MiniAppStartState.getPageSwitchDesc(str2);
        }
        try
        {
          MiniReportManager.reportEventType(paramMiniAppConfig, 2, paramString3, null, null, i, str1, 0L, null, (String)localObject, str3, paramString2, str2);
          continue;
          if (("2launch".equals(paramString1)) && ("first_frame".equals(paramString2)))
          {
            MiniAppStartState.updateState(str2, true);
            if (paramMiniAppConfig.isReportTypeMiniGame()) {
              str1 = "1";
            }
            localObject = MiniAppStartState.getBaseLibDownloadDesc(str2);
            str3 = MiniAppStartState.getApkgDownloadDesc(str2);
            if (paramMiniAppConfig.isReportTypeMiniGame()) {
              paramString2 = MiniAppStartState.getProcessLoadDesc(str2);
            } else {
              paramString2 = MiniAppStartState.getBaselibLoadDesc(str2);
            }
            MiniReportManager.reportEventType(paramMiniAppConfig, 2, paramString3, null, null, 0, str1, 0L, null, (String)localObject, str3, paramString2, "cold_start");
          }
          else if (("2launch".equals(paramString1)) && ("click_resume".equals(paramString2)))
          {
            MiniAppStartState.reset(str2, true);
            if (MiniAppStartState.getPageSwitch(str2) != 1)
            {
              if (paramMiniAppConfig.isReportTypeMiniGame()) {
                str1 = "1";
              }
              localObject = MiniAppStartState.getBaseLibDownloadDesc(str2);
              str3 = MiniAppStartState.getApkgDownloadDesc(str2);
              if (paramMiniAppConfig.isReportTypeMiniGame()) {
                paramString2 = MiniAppStartState.getProcessLoadDesc(str2);
              } else {
                paramString2 = MiniAppStartState.getBaselibLoadDesc(str2);
              }
              MiniReportManager.reportEventType(paramMiniAppConfig, 2, paramString3, null, null, 0, str1, 0L, null, (String)localObject, str3, paramString2, "hot_start");
            }
          }
          if (!"2unload".equals(paramString1)) {
            break label436;
          }
          MiniAppStartState.removeState(paramMiniAppConfig.config.appId);
          return;
        }
        catch (Throwable paramString1) {}
        QLog.e("MiniAppReportManager2", 2, "", paramString1);
      }
      catch (Throwable paramString1) {}
      label436:
      return;
      label437:
      String str2 = "";
    }
  }
  
  private static void reportPageViewInMainProcess(String paramString1, String paramString2, String paramString3, MiniAppConfig paramMiniAppConfig)
  {
    MiniAppReportManager2.AppLaunchState localAppLaunchState = updateLaunchState(paramString1, paramString2, paramString3, paramMiniAppConfig);
    if (localAppLaunchState == null)
    {
      paramMiniAppConfig = new StringBuilder();
      paramMiniAppConfig.append("new report (launchState is not exist): [subActionType = ");
      paramMiniAppConfig.append(paramString1);
      paramMiniAppConfig.append("], [reserves = ");
      paramMiniAppConfig.append(paramString2);
      paramMiniAppConfig.append("], [path = ");
      paramMiniAppConfig.append(paramString3);
      paramMiniAppConfig.append("]");
      QLog.d("MiniAppReportManager2", 2, paramMiniAppConfig.toString());
      return;
    }
    if (QLog.isColorLevel())
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
      QLog.d("MiniAppReportManager2", 2, localStringBuilder.toString());
    }
    long l1 = localAppLaunchState.launchTime - localAppLaunchState.clickTime;
    long l2 = localAppLaunchState.hideTime - localAppLaunchState.showTime;
    long l3 = localAppLaunchState.loadTime;
    long l4 = localAppLaunchState.clickTime;
    long l5 = localAppLaunchState.loadEndTime;
    long l6 = localAppLaunchState.clickTime;
    if (("2back_key".equals(paramString1)) && (localAppLaunchState.needReportLaunchResult))
    {
      report("page_view", "2show_fail", localAppLaunchState.launchId, null, "back_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
      localAppLaunchState.needReportLaunchResult = false;
    }
    if (("2close".equals(paramString1)) && (localAppLaunchState.needReportLaunchResult))
    {
      report("page_view", "2show_fail", localAppLaunchState.launchId, null, "close_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
      localAppLaunchState.needReportLaunchResult = false;
    }
    if ("2hide".equals(paramString1))
    {
      if (localAppLaunchState.needReportLaunchResult)
      {
        report("page_view", "2show_fail", localAppLaunchState.launchId, null, "home_cancel", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
        localAppLaunchState.needReportLaunchResult = false;
      }
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, null, paramString2, String.valueOf(l2), paramMiniAppConfig);
      paramString1 = new StringBuilder();
      paramString1.append("2hide: cost:");
      paramString1.append(paramString2);
      paramString1.append("  duration:");
      paramString1.append(l2);
      QLog.e("MiniAppReportManager2", 1, paramString1.toString());
      return;
    }
    if ("2launch_fail".equals(paramString1))
    {
      if (localAppLaunchState.needReportLaunchResult)
      {
        report("page_view", "2show_fail", localAppLaunchState.launchId, null, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
        localAppLaunchState.needReportLaunchResult = false;
      }
      return;
    }
    if ("2launch".equals(paramString1))
    {
      if (localAppLaunchState.needReportLaunchResult)
      {
        report("page_view", "2show", localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
        localAppLaunchState.needReportLaunchResult = false;
      }
      if ("first_frame".equals(paramString2)) {
        report("page_view", "2show", localAppLaunchState.launchId, paramString3, "first_frame_extend", String.valueOf(l1), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
      }
      return;
    }
    if ("2load".equals(paramString1))
    {
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l3 - l4), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
      return;
    }
    if ("2load_end".equals(paramString1))
    {
      report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, String.valueOf(l5 - l6), localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
      return;
    }
    report("page_view", paramString1, localAppLaunchState.launchId, paramString3, paramString2, null, localAppLaunchState.hasPkgAndX5(), paramMiniAppConfig);
  }
  
  private static void reportTimeout(MiniAppReportManager2.AppLaunchState paramAppLaunchState)
  {
    paramAppLaunchState.launchResult = 2;
    long l2 = paramAppLaunchState.hideTime - paramAppLaunchState.clickTime;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = paramAppLaunchState.clickTime - NetConnInfoCenter.getServerTimeMillis();
    }
    String str = getTimeOutCode(l1);
    Object localObject;
    if (paramAppLaunchState.needReportLaunchResult)
    {
      localObject = new MiniAppInfo();
      ((MiniAppInfo)localObject).appId = paramAppLaunchState.appId;
    }
    try
    {
      ((MiniAppInfo)localObject).verType = paramAppLaunchState.verType;
      ((MiniAppInfo)localObject).setEngineType(paramAppLaunchState.engineType);
      ((MiniAppInfo)localObject).setReportType(paramAppLaunchState.reportType);
      label90:
      MiniAppConfig localMiniAppConfig = new MiniAppConfig((MiniAppInfo)localObject);
      if (paramAppLaunchState.loadTime == 0L) {
        localObject = "2load_fail";
      } else {
        localObject = "2show_fail";
      }
      report("page_view", (String)localObject, paramAppLaunchState.launchId, null, str, String.valueOf(l1), paramAppLaunchState.hasPkgAndX5(), localMiniAppConfig);
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
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppLaunshState", 4).edit();
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
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppReportManager2", 2, "setTimeOut for launch");
    }
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
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppReportManager2", 2, "stopTimeOut for report timeout");
    }
    timerEnable = false;
    Handler localHandler = handler;
    if (localHandler != null) {
      localHandler.removeCallbacks(launchTimeoutRunnable);
    }
  }
  
  private static MiniAppReportManager2.AppLaunchState updateLaunchState(String paramString1, String paramString2, String paramString3, MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      boolean bool2 = first;
      boolean bool1 = false;
      if (bool2)
      {
        first = false;
        loadLaunchStates();
        launchTimeoutRunnable.run();
      }
      MiniAppReportManager2.AppLaunchState localAppLaunchState = (MiniAppReportManager2.AppLaunchState)launchStateMap.get(paramMiniAppConfig.config.appId);
      paramString3 = localAppLaunchState;
      if (localAppLaunchState == null)
      {
        paramString3 = new MiniAppReportManager2.AppLaunchState();
        paramString3.launchId = String.valueOf(l);
        launchStateMap.put(paramMiniAppConfig.config.appId, paramString3);
      }
      paramString3.appId = paramMiniAppConfig.config.appId;
      paramString3.engineType = paramMiniAppConfig.config.getEngineType();
      paramString3.reportType = paramMiniAppConfig.config.getReportType();
      paramString3.verType = paramMiniAppConfig.config.verType;
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
          int i = QbSdk.getTbsVersion(BaseApplicationImpl.getContext());
          int j = QbSdk.getTmpDirTbsVersion(BaseApplicationImpl.getContext());
          if ((i > 0) || (j > 0)) {
            bool1 = true;
          }
          MiniAppReportManager2.AppLaunchState.hasX5 = bool1;
        }
        paramString3.hasPkg = ApkgManager.pkgExists(paramMiniAppConfig.config);
        paramString3.flutterMode = paramMiniAppConfig.isSdkMode;
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
        launchStateMap.remove(paramMiniAppConfig.config.appId);
      }
      if (QLog.isColorLevel())
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
        QLog.d("MiniAppReportManager2", 2, paramString1.toString());
      }
      return paramString3;
    }
    QLog.d("MiniAppReportManager2", 2, "new report (appId is null)");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager2
 * JD-Core Version:    0.7.0.1
 */