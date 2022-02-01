package com.tencent.mobileqq.mini.report;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniReportManager
{
  private static final Map<String, List<String>> APPID_JS_ERROR_MAP = new HashMap();
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  static final int MAX_TIME_COST = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_max_time_cost", 120000);
  static final String REPORT_EVENT_CONFIG = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_event_config", "");
  private static final String TAG = "MiniReportManager";
  private static SparseArray<MiniReportManager.CostTimeRecord> eventCostTimeSparseArray;
  private static ArrayList<String> eventNameNotToDC4266;
  private static SparseArray<String> eventNameSparseArray = new SparseArray();
  private static ArrayList<String> eventNameToDC5332;
  private static ArrayList<Integer> eventNeedRecordTime = new ArrayList();
  public static HashMap<String, MiniReportManager.MiniAppLaunchState> launchStateMap;
  
  static
  {
    eventCostTimeSparseArray = new SparseArray();
    eventNameToDC5332 = new ArrayList();
    eventNameNotToDC4266 = new ArrayList();
    eventNameSparseArray.put(1, "onlaunch");
    eventNameSparseArray.put(4, "basejsdownloadstart");
    eventNameSparseArray.put(5, "basejsdownloadend");
    eventNameSparseArray.put(6, "basejsunzipstart");
    eventNameSparseArray.put(7, "basejsunzipend");
    eventNameSparseArray.put(8, "basejsreadstart");
    eventNameSparseArray.put(9, "basejsreadend");
    eventNameSparseArray.put(10, "basejsreadstart");
    eventNameSparseArray.put(11, "basejsreadend");
    eventNameSparseArray.put(12, "appconfigreadstart");
    eventNameSparseArray.put(13, "appconfigreadend");
    eventNameSparseArray.put(14, "servicejsstart");
    eventNameSparseArray.put(15, "servicejsend");
    eventNameSparseArray.put(121, "app_route_done");
    eventNameSparseArray.put(150, "app_err_white_screen");
    eventNameSparseArray.put(122, "page_js_start");
    eventNameSparseArray.put(123, "page_js_end");
    eventNameSparseArray.put(124, "apkg_download_pipeline_start");
    eventNameSparseArray.put(125, "apkg_download_pipeline_end");
    eventNameSparseArray.put(16, "basejsstart");
    eventNameSparseArray.put(17, "basejsready");
    eventNameSparseArray.put(18, "webviewjsstart");
    eventNameSparseArray.put(19, "webviewjsready");
    eventNameSparseArray.put(2, "apponloaded");
    eventNameSparseArray.put(20, "apponhide");
    eventNameSparseArray.put(21, "apponshow");
    eventNameSparseArray.put(22, "apponunload");
    eventNameSparseArray.put(23, "jsonerror");
    eventNameSparseArray.put(24, "appcreate");
    eventNameSparseArray.put(100, "service_start");
    eventNameSparseArray.put(101, "service_end");
    eventNameSparseArray.put(102, "webview_start");
    eventNameSparseArray.put(103, "webview_end");
    eventNameSparseArray.put(104, "app_load_start");
    eventNameSparseArray.put(105, "app_load_end");
    eventNameSparseArray.put(104, "service_app_start");
    eventNameSparseArray.put(105, "service_app_end");
    eventNameSparseArray.put(106, "webview_app_start");
    eventNameSparseArray.put(107, "webview_app_end");
    eventNameSparseArray.put(599, "ssocmdresult");
    eventNameSparseArray.put(600, "ssocmdstart");
    eventNameSparseArray.put(601, "ssocmdend");
    eventNameSparseArray.put(602, "x5installsuccess");
    eventNameSparseArray.put(603, "x5installfail");
    eventNameSparseArray.put(604, "x5installtimeout");
    eventNameSparseArray.put(605, "preloadprocess");
    eventNameSparseArray.put(606, "pageshow");
    eventNameSparseArray.put(607, "pagehide");
    eventNameSparseArray.put(645, "pageloadend");
    eventNameSparseArray.put(612, "pageclick");
    eventNameSparseArray.put(608, "onlaunchsucc");
    eventNameSparseArray.put(609, "onlaunchfail");
    eventNameSparseArray.put(610, "onlaunchtimeout");
    eventNameSparseArray.put(619, "appdownloadstart");
    eventNameSparseArray.put(620, "appdownloadend");
    eventNameSparseArray.put(621, "appunzipstart");
    eventNameSparseArray.put(622, "appunzipend");
    eventNameSparseArray.put(611, "domready");
    eventNameSparseArray.put(613, "subpkgdownloadstart");
    eventNameSparseArray.put(614, "subpkgdownloadend");
    eventNameSparseArray.put(615, "subpkgunpackstart");
    eventNameSparseArray.put(616, "subpkgunpackend");
    eventNameSparseArray.put(617, "basejsdownloadfailed");
    eventNameSparseArray.put(618, "basejsunzipfailed");
    eventNameSparseArray.put(623, "pageframeloadstart");
    eventNameSparseArray.put(624, "pageframeloadend");
    eventNameSparseArray.put(626, "preload_process_start");
    eventNameSparseArray.put(627, "preload_process_end");
    eventNameSparseArray.put(628, "http_request_result");
    eventNameSparseArray.put(629, "cpuPerformance");
    eventNameSparseArray.put(630, "fpsPerformance");
    eventNameSparseArray.put(631, "memoryPerformance");
    eventNameSparseArray.put(632, "web_socket_open");
    eventNameSparseArray.put(633, "web_socket_close");
    eventNameSparseArray.put(634, "web_socket_failure");
    eventNameSparseArray.put(642, "fpsVariance");
    eventNameSparseArray.put(643, "memoryGrowth");
    eventNameSparseArray.put(644, "miniappstaytime");
    eventNameSparseArray.put(700, "miniappembeddedvideo");
    eventNameSparseArray.put(701, "miniappembeddedvideoresult");
    eventNameSparseArray.put(710, "miniappembeddedlive");
    eventNameSparseArray.put(711, "miniappembeddedliveresult");
    eventNameSparseArray.put(636, "first_render_result");
    eventNameSparseArray.put(637, "re_render_result");
    eventNameSparseArray.put(638, "newpage_result");
    eventNameSparseArray.put(639, "storage_usage");
    eventNameSparseArray.put(640, "http_download");
    eventNameSparseArray.put(641, "http_upload");
    eventNameSparseArray.put(1001, "minigamebaselibloadso");
    eventNameSparseArray.put(1002, "minigamebaselibloadsoend");
    eventNameSparseArray.put(1003, "minigamebaselibloadjar");
    eventNameSparseArray.put(1004, "minigamebaselibloadjarend");
    eventNameSparseArray.put(1005, "minigamebaselibloadjs");
    eventNameSparseArray.put(1006, "minigamebaselibloadjsend");
    eventNameSparseArray.put(1007, "minigameloadmainpkg");
    eventNameSparseArray.put(1008, "minigameloadmainpkgend");
    eventNameSparseArray.put(1009, "minigameloadsubpkg");
    eventNameSparseArray.put(1010, "minigameloadsubpkgend");
    eventNameSparseArray.put(1011, "minigameprogresserror");
    eventNameSparseArray.put(1012, "minigamebaselibinstallskip");
    eventNameSparseArray.put(1013, "minigameenterloadingpage");
    eventNameSparseArray.put(1014, "minigameloadbaselib");
    eventNameSparseArray.put(1015, "minigameloadbaselibend");
    eventNameSparseArray.put(1016, "minigamefirsthide");
    eventNameSparseArray.put(1017, "minigamesurvival");
    eventNameSparseArray.put(1018, "minigameblackscreen");
    eventNameSparseArray.put(1019, "minigamenorefresh");
    eventNameSparseArray.put(1020, "minigamefirststaytime");
    eventNameSparseArray.put(1021, "minigamestaytime");
    eventNameSparseArray.put(1022, "minigamefirstlaunch");
    eventNameSparseArray.put(1023, "minigametwicelaunch");
    eventNameSparseArray.put(1024, "minigameerrordialog");
    eventNameSparseArray.put(1025, "capsulebuttoncloseclick");
    eventNameSparseArray.put(1026, "loadingpagecloseclick");
    eventNameSparseArray.put(1027, "minigameimagedownload");
    eventNameSparseArray.put(1029, "minigameloadsubpack_impossible");
    eventNameSparseArray.put(1028, "miniappstartbycache");
    eventNameSparseArray.put(1030, "stepstartactivity");
    eventNameSparseArray.put(1031, "steponcreate");
    eventNameSparseArray.put(1032, "stepinitdatamustonresume");
    eventNameSparseArray.put(1033, "steploadbaselibtimecost");
    eventNameSparseArray.put(1034, "stepinitjspluginlist");
    eventNameSparseArray.put(1035, "steponresume");
    eventNameSparseArray.put(1036, "steploadgpkg");
    eventNameSparseArray.put(1037, "stepinitruntime");
    eventNameSparseArray.put(1038, "stepinitjspluginengine");
    eventNameSparseArray.put(1039, "stepcreatesurfaceview");
    eventNameSparseArray.put(1040, "steplaunchgame");
    eventNameSparseArray.put(1042, "stepfirstframefromgamelaunched");
    eventNameSparseArray.put(1043, "stepfirstframefromcreate");
    eventNameSparseArray.put(1044, "download_with_cache");
    eventNameSparseArray.put(1050, "game_load_so_exception");
    eventNeedRecordTime.add(Integer.valueOf(1));
    eventNeedRecordTime.add(Integer.valueOf(4));
    eventNeedRecordTime.add(Integer.valueOf(6));
    eventNeedRecordTime.add(Integer.valueOf(619));
    eventNeedRecordTime.add(Integer.valueOf(613));
    eventNeedRecordTime.add(Integer.valueOf(621));
    eventNeedRecordTime.add(Integer.valueOf(626));
    eventNeedRecordTime.add(Integer.valueOf(100));
    eventNeedRecordTime.add(Integer.valueOf(101));
    eventNeedRecordTime.add(Integer.valueOf(102));
    eventNeedRecordTime.add(Integer.valueOf(103));
    eventNeedRecordTime.add(Integer.valueOf(619));
    eventNeedRecordTime.add(Integer.valueOf(620));
    eventNeedRecordTime.add(Integer.valueOf(4));
    eventNeedRecordTime.add(Integer.valueOf(5));
    eventNeedRecordTime.add(Integer.valueOf(14));
    eventNeedRecordTime.add(Integer.valueOf(15));
    eventNeedRecordTime.add(Integer.valueOf(18));
    eventNeedRecordTime.add(Integer.valueOf(19));
    eventNeedRecordTime.add(Integer.valueOf(104));
    eventNeedRecordTime.add(Integer.valueOf(105));
    eventNeedRecordTime.add(Integer.valueOf(106));
    eventNeedRecordTime.add(Integer.valueOf(107));
    eventNeedRecordTime.add(Integer.valueOf(122));
    eventNeedRecordTime.add(Integer.valueOf(123));
    eventNeedRecordTime.add(Integer.valueOf(124));
    eventNeedRecordTime.add(Integer.valueOf(125));
    eventNeedRecordTime.add(Integer.valueOf(606));
    eventNeedRecordTime.add(Integer.valueOf(645));
    eventNeedRecordTime.add(Integer.valueOf(2));
    eventNeedRecordTime.add(Integer.valueOf(5));
    eventNeedRecordTime.add(Integer.valueOf(617));
    eventNeedRecordTime.add(Integer.valueOf(7));
    eventNeedRecordTime.add(Integer.valueOf(618));
    eventNeedRecordTime.add(Integer.valueOf(620));
    eventNeedRecordTime.add(Integer.valueOf(614));
    eventNeedRecordTime.add(Integer.valueOf(622));
    eventNeedRecordTime.add(Integer.valueOf(627));
    eventNeedRecordTime.add(Integer.valueOf(1022));
    eventNeedRecordTime.add(Integer.valueOf(1023));
    eventCostTimeSparseArray.put(2, new MiniReportManager.CostTimeRecord("launch_result", 1));
    eventCostTimeSparseArray.put(645, new MiniReportManager.CostTimeRecord("page_load_result", 606));
    eventCostTimeSparseArray.put(5, new MiniReportManager.CostTimeRecord("basejs_download_result", 4));
    eventCostTimeSparseArray.put(617, new MiniReportManager.CostTimeRecord("basejs_download_result", 4));
    eventCostTimeSparseArray.put(7, new MiniReportManager.CostTimeRecord("basejs_unzip_result", 6));
    eventCostTimeSparseArray.put(618, new MiniReportManager.CostTimeRecord("basejs_unzip_result", 6));
    eventCostTimeSparseArray.put(620, new MiniReportManager.CostTimeRecord("app_download_result", 619));
    eventCostTimeSparseArray.put(614, new MiniReportManager.CostTimeRecord("sub_download_result", 613));
    eventCostTimeSparseArray.put(622, new MiniReportManager.CostTimeRecord("app_unzip_result", 621));
    eventCostTimeSparseArray.put(627, new MiniReportManager.CostTimeRecord("preload_result", 626));
    eventCostTimeSparseArray.put(1022, new MiniReportManager.CostTimeRecord("game_first_launch_result", 1));
    eventCostTimeSparseArray.put(1023, new MiniReportManager.CostTimeRecord("game_twice_launch_result", 1));
    eventCostTimeSparseArray.put(1008, new MiniReportManager.CostTimeRecord("game_after_launch_time_cost", 1));
    eventCostTimeSparseArray.put(125, new MiniReportManager.CostTimeRecord("apkg_download_pipeline_result", 124));
    eventNameToDC5332.add("launch_result");
    eventNameToDC5332.add("app_download_result");
    eventNameToDC5332.add("stepstartactivity");
    eventNameToDC5332.add("steponcreate");
    eventNameToDC5332.add("stepinitdatamustonresume");
    eventNameToDC5332.add("steploadbaselibtimecost");
    eventNameToDC5332.add("stepinitjspluginlist");
    eventNameToDC5332.add("steponresume");
    eventNameToDC5332.add("steploadgpkg");
    eventNameToDC5332.add("stepinitruntime");
    eventNameToDC5332.add("stepinitjspluginengine");
    eventNameToDC5332.add("stepcreatesurfaceview");
    eventNameToDC5332.add("stepfirstframefromgamelaunched");
    eventNameToDC5332.add("stepfirstframefromcreate");
    eventNameToDC5332.add("steplaunchgame");
    eventNameNotToDC4266.add("ssocmdstart");
    eventNameNotToDC4266.add("ssocmdend");
    eventNameNotToDC4266.add("preloadprocess");
    eventNameNotToDC4266.add("preload_process_end");
    eventNameNotToDC4266.add("preload_process_start");
    eventNameNotToDC4266.add("preload_result");
    eventNameNotToDC4266.add("basejsstart");
    eventNameNotToDC4266.add("basejsready");
    eventNameNotToDC4266.add("minigamebaselibloadjs");
    eventNameNotToDC4266.add("minigamebaselibloadjsend");
    eventNameNotToDC4266.add("minigameloadbaselib");
    eventNameNotToDC4266.add("minigameloadbaselibend");
    eventNameNotToDC4266.add("minigamebaselibloadso");
    eventNameNotToDC4266.add("minigamebaselibloadsoend");
    eventNameNotToDC4266.add("minigamebaselibloadso");
    eventNameNotToDC4266.add("minigamebaselibloadsoend");
    launchStateMap = new HashMap();
  }
  
  public static void addCostTimeEventAttachInfo(MiniAppConfig paramMiniAppConfig, int paramInt, String paramString)
  {
    String str2 = "0000000000";
    String str1 = str2;
    if (paramMiniAppConfig != null)
    {
      str1 = str2;
      if (paramMiniAppConfig.config != null) {
        str1 = paramMiniAppConfig.config.appId;
      }
    }
    getLaunchState(str1).attachInfo.put(Integer.valueOf(paramInt), paramString);
    QLog.d("MiniReportManager", 2, "addCostTimeEventAttachInfo:  mileStoneEventKey:" + paramInt + "   attachInfo:" + paramString);
  }
  
  private static void appendJsErrorToReportedList(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) && (!TextUtils.isEmpty(paramString)))
    {
      if (APPID_JS_ERROR_MAP.get(paramMiniAppConfig.config.appId) == null) {
        APPID_JS_ERROR_MAP.put(paramMiniAppConfig.config.appId, new ArrayList());
      }
      ((List)APPID_JS_ERROR_MAP.get(paramMiniAppConfig.config.appId)).add(paramString);
    }
  }
  
  private static void detectWhiteScreen(MiniAppConfig paramMiniAppConfig, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, MiniReportManager.MiniAppLaunchState paramMiniAppLaunchState)
  {
    if ((paramInt == 20) && (!paramMiniAppLaunchState.hasOnloaded) && (paramMiniAppLaunchState.eventTime.containsKey(Integer.valueOf(121))))
    {
      long l1 = ((Long)paramMiniAppLaunchState.eventTime.get(Integer.valueOf(121))).longValue();
      paramMiniAppLaunchState.eventTime.remove(Integer.valueOf(121));
      long l2 = paramLong - l1;
      paramInt = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_report_white_screen_check", 5000);
      if ((l1 > 0L) && (l2 > paramInt))
      {
        QLog.e("MiniReportManager", 1, "detect white_screen. after routedone time:" + l2);
        MiniProgramLpReportDC04266.report(paramMiniAppConfig, 150, paramString1, paramString2, "", 0, paramString3, 0L, "", paramLong, "route_done", String.valueOf(l2), "", "");
      }
    }
  }
  
  public static String getAppType(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.isReportTypeMiniGame()) {
        return "1";
      }
      return "0";
    }
    return "0";
  }
  
  public static String getEventName(int paramInt)
  {
    return (String)eventNameSparseArray.get(paramInt);
  }
  
  public static JSONArray getLaunchPerformance(String paramString)
  {
    MiniReportManager.MiniAppLaunchState localMiniAppLaunchState = getLaunchState(paramString);
    paramString = new JSONArray();
    try
    {
      JSONObject localJSONObject;
      if (localMiniAppLaunchState.eventTime_first.size() > 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("navigationStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(1)));
        localJSONObject.put("serviceStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(100)));
        localJSONObject.put("serviceEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(101)));
        localJSONObject.put("viewStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(102)));
        localJSONObject.put("viewEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(103)));
        localJSONObject.put("fetchPkgStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(619)));
        localJSONObject.put("fetchPkgEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(620)));
        localJSONObject.put("fetchSdkStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(4)));
        localJSONObject.put("fetchSdkEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(5)));
        localJSONObject.put("loadSdkServiceStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(14)));
        localJSONObject.put("loadSdkServiceEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(15)));
        localJSONObject.put("loadSdkViewStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(18)));
        localJSONObject.put("loadSdkViewEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(19)));
        localJSONObject.put("loadAppServiceStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(104)));
        localJSONObject.put("loadAppServiceEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(105)));
        localJSONObject.put("loadAppViewStart", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(106)));
        localJSONObject.put("loadAppViewEnd", localMiniAppLaunchState.eventTime_first.get(Integer.valueOf(107)));
        localJSONObject.put("launchId", localMiniAppLaunchState.launchId_first);
        paramString.put(localJSONObject);
      }
      if (localMiniAppLaunchState.eventTime.size() > 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("navigationStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(1)));
        localJSONObject.put("serviceStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(100)));
        localJSONObject.put("serviceEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(101)));
        localJSONObject.put("viewStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(102)));
        localJSONObject.put("viewEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(103)));
        localJSONObject.put("fetchPkgStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(619)));
        localJSONObject.put("fetchPkgEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(620)));
        localJSONObject.put("fetchSdkStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(4)));
        localJSONObject.put("fetchSdkEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(5)));
        localJSONObject.put("loadSdkServiceStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(14)));
        localJSONObject.put("loadSdkServiceEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(15)));
        localJSONObject.put("loadSdkViewStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(18)));
        localJSONObject.put("loadSdkViewEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(19)));
        localJSONObject.put("loadAppServiceStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(104)));
        localJSONObject.put("loadAppServiceEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(105)));
        localJSONObject.put("loadAppViewStart", localMiniAppLaunchState.eventTime.get(Integer.valueOf(106)));
        localJSONObject.put("loadAppViewEnd", localMiniAppLaunchState.eventTime.get(Integer.valueOf(107)));
        localJSONObject.put("launchId", localMiniAppLaunchState.launchId);
        paramString.put(localJSONObject);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MiniReportManager", 1, "create performance result failed", localException);
      }
    }
    QLog.e("MiniReportManager", 2, " getformance: " + paramString.toString());
    return paramString;
  }
  
  public static long getLaunchStartTime(String paramString)
  {
    paramString = getLaunchState(paramString);
    if (paramString.eventTime.size() > 0)
    {
      paramString = (Long)paramString.eventTime.get(Integer.valueOf(1));
      if (paramString == null) {
        return 0L;
      }
      return paramString.longValue();
    }
    return 0L;
  }
  
  public static MiniReportManager.MiniAppLaunchState getLaunchState(String paramString)
  {
    MiniReportManager.MiniAppLaunchState localMiniAppLaunchState2 = (MiniReportManager.MiniAppLaunchState)launchStateMap.get(paramString);
    MiniReportManager.MiniAppLaunchState localMiniAppLaunchState1 = localMiniAppLaunchState2;
    if (localMiniAppLaunchState2 == null)
    {
      localMiniAppLaunchState1 = new MiniReportManager.MiniAppLaunchState();
      localMiniAppLaunchState1.appId = paramString;
      launchStateMap.put(paramString, localMiniAppLaunchState1);
    }
    return localMiniAppLaunchState1;
  }
  
  private static boolean isJsErrorReported(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramString))) {
      return true;
    }
    paramMiniAppConfig = (List)APPID_JS_ERROR_MAP.get(paramMiniAppConfig.config.appId);
    if (paramMiniAppConfig != null)
    {
      paramMiniAppConfig = paramMiniAppConfig.iterator();
      while (paramMiniAppConfig.hasNext()) {
        if (paramString.equals((String)paramMiniAppConfig.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean needReportToDC4266(String paramString)
  {
    if (REPORT_EVENT_CONFIG.contains(paramString)) {}
    while (!eventNameNotToDC4266.contains(paramString)) {
      return true;
    }
    return false;
  }
  
  public static boolean needReportToDC5332(String paramString1, String paramString2, String paramString3)
  {
    if (("1".equals(paramString1)) && (!"hot_start".equals(paramString3))) {
      return eventNameToDC5332.contains(paramString2);
    }
    return false;
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt, String paramString)
  {
    reportEventType(paramMiniAppConfig, paramInt, null, null, null, 0, paramString, 0L, null, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt, String paramString1, String paramString2)
  {
    reportEventType(paramMiniAppConfig, paramInt, null, paramString1, null, 0, paramString2, 0L, null, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    reportEventType(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString3, paramInt2, "0", 0L, null);
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5)
  {
    reportEventType(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, paramString5, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    long l2 = System.currentTimeMillis();
    Object localObject2 = "0000000000";
    Object localObject1 = localObject2;
    if (paramMiniAppConfig != null)
    {
      localObject1 = localObject2;
      if (paramMiniAppConfig.config != null) {
        localObject1 = paramMiniAppConfig.config.appId;
      }
    }
    localObject2 = getLaunchState((String)localObject1);
    long l1;
    if (paramInt1 == 1)
    {
      QLog.d("MiniReportManager", 1, "launch start  uptimeMillis:" + SystemClock.uptimeMillis() + "  currentTimeMillis :" + l2);
      MiniAppStartState.reset((String)localObject1);
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null) && (paramMiniAppConfig.launchParam.launchClickTimeMillis != 0L))
      {
        l1 = paramMiniAppConfig.launchParam.launchClickTimeMillis;
        QLog.d("MiniReportManager", 2, "reportEventType: fix onlaunch timestamp to " + paramMiniAppConfig.launchParam.launchClickTimeMillis);
        paramMiniAppConfig.launchParam.launchClickTimeMillis = 0L;
        ((MiniReportManager.MiniAppLaunchState)localObject2).hasOnloaded = false;
        if (!((MiniReportManager.MiniAppLaunchState)localObject2).firstRender)
        {
          localObject1 = getLaunchState("0000000000");
          if ((localObject1 != null) && (((MiniReportManager.MiniAppLaunchState)localObject1).eventTime.size() > 0))
          {
            ((MiniReportManager.MiniAppLaunchState)localObject2).eventTime.putAll(((MiniReportManager.MiniAppLaunchState)localObject1).eventTime);
            ((MiniReportManager.MiniAppLaunchState)localObject1).eventTime.clear();
          }
        }
      }
    }
    for (;;)
    {
      if ((paramInt1 == 611) && (!((MiniReportManager.MiniAppLaunchState)localObject2).hasOnloaded)) {
        paramInt1 = 2;
      }
      for (;;)
      {
        if (paramInt1 == 2)
        {
          QLog.d("MiniReportManager", 1, "launch end  uptimeMillis:" + SystemClock.uptimeMillis() + "  currentTimeMillis :" + l2);
          if (((MiniReportManager.MiniAppLaunchState)localObject2).hasOnloaded) {
            QLog.d("MiniReportManager", 1, "has report apponloaded. ignore apponloaed ");
          }
        }
        label674:
        label680:
        label708:
        for (;;)
        {
          return;
          if (((MiniReportManager.MiniAppLaunchState)localObject2).eventTime_first.size() == 0)
          {
            ((MiniReportManager.MiniAppLaunchState)localObject2).eventTime_first.putAll(((MiniReportManager.MiniAppLaunchState)localObject2).eventTime);
            ((MiniReportManager.MiniAppLaunchState)localObject2).launchId_first = ((MiniReportManager.MiniAppLaunchState)localObject2).launchId;
            ((MiniReportManager.MiniAppLaunchState)localObject2).launchId = "";
          }
          break;
          ((MiniReportManager.MiniAppLaunchState)localObject2).hasOnloaded = true;
          ((MiniReportManager.MiniAppLaunchState)localObject2).firstRender = true;
          ((MiniReportManager.MiniAppLaunchState)localObject2).launchId = MiniProgramReportHelper.launchIdForMiniAppConfig(paramMiniAppConfig);
          detectWhiteScreen(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString4, l1, (MiniReportManager.MiniAppLaunchState)localObject2);
          if (eventNeedRecordTime.contains(Integer.valueOf(paramInt1))) {
            ((MiniReportManager.MiniAppLaunchState)localObject2).eventTime.put(Integer.valueOf(paramInt1), Long.valueOf(l1));
          }
          MiniProgramLpReportDC04266.report(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, paramString5, l1, paramString6, paramString7, paramString8, paramString9);
          paramString2 = (MiniReportManager.CostTimeRecord)eventCostTimeSparseArray.get(paramInt1);
          if (paramString2 != null)
          {
            paramString3 = (Long)((MiniReportManager.MiniAppLaunchState)localObject2).eventTime.get(Integer.valueOf(paramString2.eventStart));
            if (paramString3 == null) {
              break label674;
            }
            paramLong = paramString3.longValue();
            if (paramLong > 0L)
            {
              l2 = l1 - paramLong;
              paramString2 = paramString2.eventName;
              paramString3 = (String)((MiniReportManager.MiniAppLaunchState)localObject2).attachInfo.get(Integer.valueOf(paramInt1));
              if (l2 < 0L) {
                break label680;
              }
              paramLong = l2;
              if (l2 > MAX_TIME_COST)
              {
                QLog.d("MiniReportManager", 1, "EventType: " + paramInt1 + " real costTime : " + l2);
                paramLong = MAX_TIME_COST;
              }
              MiniProgramLpReportDC04266.reportCostTimeEvent(paramMiniAppConfig, paramString2, paramString1, paramString3, paramInt2, paramLong, l1, paramString6, paramString7, paramString8, paramString9);
            }
          }
          for (;;)
          {
            if ((paramInt1 != 2) || (!"0".equals(paramString4))) {
              break label708;
            }
            MiniProgramLpReportDC04266.report(paramMiniAppConfig, 630, paramString1, String.valueOf(TaskMonitorManager.g().getCurrentFps()), null, 0, "0", 0L, null, l1, "", "", "", "");
            return;
            paramLong = 0L;
            break;
            QLog.e("MiniReportManager", 1, "costTime < 0 " + l2);
          }
        }
      }
      l1 = l2;
      break;
      l1 = l2;
    }
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    reportEventType(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString3, paramInt2, "0", 0L, null, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    reportEventType(paramMiniAppConfig, paramInt, null, null, null, 0, paramString1, 0L, null, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static void reportJsError(AppBrandRuntime paramAppBrandRuntime, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return;
      if ((paramAppBrandRuntime != null) && (paramAppBrandRuntime.apkgInfo != null)) {}
      for (paramAppBrandRuntime = paramAppBrandRuntime.apkgInfo.appConfig; !isJsErrorReported(paramAppBrandRuntime, paramString2); paramAppBrandRuntime = null)
      {
        reportEventType(paramAppBrandRuntime, 23, paramString1, paramString2, null, 0);
        appendJsErrorToReportedList(paramAppBrandRuntime, paramString2);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniReportManager
 * JD-Core Version:    0.7.0.1
 */