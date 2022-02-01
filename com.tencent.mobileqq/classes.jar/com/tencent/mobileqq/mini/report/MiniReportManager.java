package com.tencent.mobileqq.mini.report;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
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
    Object localObject1 = eventNameSparseArray;
    Integer localInteger1 = Integer.valueOf(4);
    ((SparseArray)localObject1).put(4, "basejsdownloadstart");
    Object localObject2 = eventNameSparseArray;
    localObject1 = Integer.valueOf(5);
    ((SparseArray)localObject2).put(5, "basejsdownloadend");
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
    SparseArray localSparseArray = eventNameSparseArray;
    localObject2 = Integer.valueOf(619);
    localSparseArray.put(619, "appdownloadstart");
    localSparseArray = eventNameSparseArray;
    Integer localInteger2 = Integer.valueOf(620);
    localSparseArray.put(620, "appdownloadend");
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
    eventNameSparseArray.put(1060, "mini_search_df_launch");
    eventNameSparseArray.put(1061, "mini_search_df_result");
    eventNameSparseArray.put(1062, "mini_search_df_load_start");
    eventNameSparseArray.put(1063, "mini_search_df_load_end");
    eventNeedRecordTime.add(Integer.valueOf(1));
    eventNeedRecordTime.add(localInteger1);
    eventNeedRecordTime.add(Integer.valueOf(6));
    eventNeedRecordTime.add(localObject2);
    eventNeedRecordTime.add(Integer.valueOf(613));
    eventNeedRecordTime.add(Integer.valueOf(621));
    eventNeedRecordTime.add(Integer.valueOf(626));
    eventNeedRecordTime.add(Integer.valueOf(100));
    eventNeedRecordTime.add(Integer.valueOf(101));
    eventNeedRecordTime.add(Integer.valueOf(102));
    eventNeedRecordTime.add(Integer.valueOf(103));
    eventNeedRecordTime.add(localObject2);
    eventNeedRecordTime.add(localInteger2);
    eventNeedRecordTime.add(localInteger1);
    eventNeedRecordTime.add(localObject1);
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
    eventNeedRecordTime.add(Integer.valueOf(1062));
    eventNeedRecordTime.add(Integer.valueOf(1063));
    eventNeedRecordTime.add(Integer.valueOf(2));
    eventNeedRecordTime.add(localObject1);
    eventNeedRecordTime.add(Integer.valueOf(617));
    eventNeedRecordTime.add(Integer.valueOf(7));
    eventNeedRecordTime.add(Integer.valueOf(618));
    eventNeedRecordTime.add(localInteger2);
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
    eventCostTimeSparseArray.put(1063, new MiniReportManager.CostTimeRecord("mini_search_df_load_result", 1062));
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
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null)) {
      paramMiniAppConfig = paramMiniAppConfig.config.appId;
    } else {
      paramMiniAppConfig = "0000000000";
    }
    getLaunchState(paramMiniAppConfig).attachInfo.put(Integer.valueOf(paramInt), paramString);
    paramMiniAppConfig = new StringBuilder();
    paramMiniAppConfig.append("addCostTimeEventAttachInfo:  mileStoneEventKey:");
    paramMiniAppConfig.append(paramInt);
    paramMiniAppConfig.append("   attachInfo:");
    paramMiniAppConfig.append(paramString);
    QLog.d("MiniReportManager", 2, paramMiniAppConfig.toString());
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
        paramMiniAppLaunchState = new StringBuilder();
        paramMiniAppLaunchState.append("detect white_screen. after routedone time:");
        paramMiniAppLaunchState.append(l2);
        QLog.e("MiniReportManager", 1, paramMiniAppLaunchState.toString());
        MiniProgramLpReportDC04266.report(paramMiniAppConfig, 150, paramString1, paramString2, "", 0, paramString3, 0L, "", paramLong, "route_done", String.valueOf(l2), "", "");
      }
    }
  }
  
  public static String getAppType(MiniAppConfig paramMiniAppConfig)
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
  
  public static String getEventName(int paramInt)
  {
    return (String)eventNameSparseArray.get(paramInt);
  }
  
  public static MiniAppConfig getFakeAppConfigForReport(String paramString)
  {
    Object localObject = new MiniAppInfo();
    ((MiniAppInfo)localObject).appId = paramString;
    localObject = new MiniAppConfig((MiniAppInfo)localObject);
    ((MiniAppConfig)localObject).launchParam = new LaunchParam();
    ((MiniAppConfig)localObject).launchParam.miniAppId = paramString;
    return localObject;
  }
  
  public static JSONArray getLaunchPerformance(String paramString)
  {
    MiniReportManager.MiniAppLaunchState localMiniAppLaunchState = getLaunchState(paramString);
    paramString = new JSONArray();
    try
    {
      int i = localMiniAppLaunchState.eventTime_first.size();
      JSONObject localJSONObject;
      if (i > 0)
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
      QLog.e("MiniReportManager", 1, "create performance result failed", localException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getformance: ");
    localStringBuilder.append(paramString.toString());
    QLog.e("MiniReportManager", 2, localStringBuilder.toString());
    return paramString;
  }
  
  public static long getLaunchStartTime(String paramString)
  {
    paramString = getLaunchState(paramString);
    int i = paramString.eventTime.size();
    long l = 0L;
    if (i > 0)
    {
      paramString = (Long)paramString.eventTime.get(Integer.valueOf(1));
      if (paramString == null) {
        return 0L;
      }
      l = paramString.longValue();
    }
    return l;
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
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      if (TextUtils.isEmpty(paramString)) {
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
    return true;
  }
  
  public static boolean needReportToDC4266(String paramString)
  {
    if (REPORT_EVENT_CONFIG.contains(paramString)) {
      return true;
    }
    return !eventNameNotToDC4266.contains(paramString);
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
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong1, long paramLong2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    Object localObject;
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null)) {
      localObject = paramMiniAppConfig.config.appId;
    } else {
      localObject = "0000000000";
    }
    MiniReportManager.MiniAppLaunchState localMiniAppLaunchState = getLaunchState((String)localObject);
    long l;
    if (paramInt1 == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launch start  uptimeMillis:");
      localStringBuilder.append(SystemClock.uptimeMillis());
      localStringBuilder.append("  currentTimeMillis :");
      localStringBuilder.append(paramLong2);
      QLog.d("MiniReportManager", 1, localStringBuilder.toString());
      MiniAppStartState.reset((String)localObject);
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null) && (paramMiniAppConfig.launchParam.launchClickTimeMillis != 0L))
      {
        l = paramMiniAppConfig.launchParam.launchClickTimeMillis;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportEventType: fix onlaunch timestamp to ");
        ((StringBuilder)localObject).append(paramMiniAppConfig.launchParam.launchClickTimeMillis);
        QLog.d("MiniReportManager", 2, ((StringBuilder)localObject).toString());
        paramMiniAppConfig.launchParam.launchClickTimeMillis = 0L;
      }
      else
      {
        l = paramLong2;
      }
      localMiniAppLaunchState.hasOnloaded = false;
      if (!localMiniAppLaunchState.firstRender)
      {
        localObject = getLaunchState("0000000000");
        if ((localObject != null) && (((MiniReportManager.MiniAppLaunchState)localObject).eventTime.size() > 0))
        {
          localMiniAppLaunchState.eventTime.putAll(((MiniReportManager.MiniAppLaunchState)localObject).eventTime);
          ((MiniReportManager.MiniAppLaunchState)localObject).eventTime.clear();
        }
      }
      else if (localMiniAppLaunchState.eventTime_first.size() == 0)
      {
        localMiniAppLaunchState.eventTime_first.putAll(localMiniAppLaunchState.eventTime);
        localMiniAppLaunchState.launchId_first = localMiniAppLaunchState.launchId;
        localMiniAppLaunchState.launchId = "";
      }
    }
    else
    {
      l = paramLong2;
    }
    if ((paramInt1 == 611) && (!localMiniAppLaunchState.hasOnloaded)) {
      paramInt1 = 2;
    }
    if (paramInt1 == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launch end  uptimeMillis:");
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
      ((StringBuilder)localObject).append("  currentTimeMillis :");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("MiniReportManager", 1, ((StringBuilder)localObject).toString());
      if (localMiniAppLaunchState.hasOnloaded)
      {
        QLog.d("MiniReportManager", 1, "has report apponloaded. ignore apponloaed ");
        return;
      }
      localMiniAppLaunchState.hasOnloaded = true;
      localMiniAppLaunchState.firstRender = true;
      localMiniAppLaunchState.launchId = MiniProgramReportHelper.launchIdForMiniAppConfig(paramMiniAppConfig);
    }
    detectWhiteScreen(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString4, l, localMiniAppLaunchState);
    if (eventNeedRecordTime.contains(Integer.valueOf(paramInt1))) {
      localMiniAppLaunchState.eventTime.put(Integer.valueOf(paramInt1), Long.valueOf(l));
    }
    MiniProgramLpReportDC04266.report(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong1, paramString5, l, paramString6, paramString7, paramString8, paramString9);
    paramString2 = (MiniReportManager.CostTimeRecord)eventCostTimeSparseArray.get(paramInt1);
    if (paramString2 != null)
    {
      paramString3 = (Long)localMiniAppLaunchState.eventTime.get(Integer.valueOf(paramString2.eventStart));
      if (paramString3 != null) {
        paramLong1 = paramString3.longValue();
      } else {
        paramLong1 = 0L;
      }
      if (paramLong1 > 0L)
      {
        paramLong1 = l - paramLong1;
        paramString2 = paramString2.eventName;
        paramString3 = (String)localMiniAppLaunchState.attachInfo.get(Integer.valueOf(paramInt1));
        if (paramLong1 >= 0L)
        {
          if (paramLong1 > MAX_TIME_COST)
          {
            paramString5 = new StringBuilder();
            paramString5.append("EventType: ");
            paramString5.append(paramInt1);
            paramString5.append(" real costTime : ");
            paramString5.append(paramLong1);
            QLog.d("MiniReportManager", 1, paramString5.toString());
            paramLong1 = MAX_TIME_COST;
          }
          MiniProgramLpReportDC04266.reportCostTimeEvent(paramMiniAppConfig, paramString2, paramString1, paramString3, paramInt2, paramLong1, l, paramString6, paramString7, paramString8, paramString9);
        }
        else
        {
          paramString2 = new StringBuilder();
          paramString2.append("costTime < 0 ");
          paramString2.append(paramLong1);
          QLog.e("MiniReportManager", 1, paramString2.toString());
        }
      }
    }
    if ((paramInt1 == 2) && ("0".equals(paramString4))) {
      MiniProgramLpReportDC04266.report(paramMiniAppConfig, 630, paramString1, String.valueOf(TaskMonitorManager.g().getCurrentFps()), null, 0, "0", 0L, null, l, "", "", "", "");
    }
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5)
  {
    reportEventType(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, paramString5, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    reportEventType(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, System.currentTimeMillis(), paramString5, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    reportEventType(paramMiniAppConfig, paramInt1, paramString1, paramString2, paramString3, paramInt2, "0", 0L, null, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void reportEventType(MiniAppConfig paramMiniAppConfig, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    reportEventType(paramMiniAppConfig, paramInt, null, null, null, 0, paramString1, 0L, null, paramString2, paramString3, paramString4, paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniReportManager
 * JD-Core Version:    0.7.0.1
 */