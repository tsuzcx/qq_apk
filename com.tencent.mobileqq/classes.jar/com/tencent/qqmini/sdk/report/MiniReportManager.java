package com.tencent.qqmini.sdk.report;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.AppStateManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniReportManager
{
  private static final Map<String, List<String>> APPID_JS_ERROR_MAP;
  public static final String APP_TYPE_MINI_APP = "0";
  public static final String APP_TYPE_MINI_GAME = "1";
  static final int MAX_TIME_COST = WnsConfig.getConfig("qqminiapp", "mini_app_report_max_time_cost", 120000);
  private static final String TAG = "MiniReportManager";
  private static SparseArray<MiniReportManager.CostTimeRecord> eventCostTimeSparseArray;
  private static final Map<String, List<String>> eventForFirstTime;
  private static SparseArray<String> eventNameSparseArray;
  private static ArrayList<String> eventNameToDC5332;
  private static ArrayList<String> eventNeedRecordFirstTime;
  private static ArrayList<Integer> eventNeedRecordTime;
  public static HashMap<String, MiniReportManager.MiniAppLaunchState> launchStateMap;
  
  static
  {
    APPID_JS_ERROR_MAP = new HashMap();
    launchStateMap = new HashMap();
    eventNameSparseArray = new SparseArray();
    eventNeedRecordTime = new ArrayList();
    eventCostTimeSparseArray = new SparseArray();
    eventNameToDC5332 = new ArrayList();
    eventNeedRecordFirstTime = new ArrayList();
    eventForFirstTime = new HashMap();
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
    eventNameSparseArray.put(120, "app_on_webview_ready");
    eventNameSparseArray.put(121, "app_route_done");
    eventNameSparseArray.put(150, "app_err_white_screen");
    eventNameSparseArray.put(151, "app_init_v8_failed");
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
    eventNameSparseArray.put(200, "runtimecreatetaskstart");
    eventNameSparseArray.put(201, "runtimecreatetaskend");
    eventNameSparseArray.put(202, "runtimeinittaskstart");
    eventNameSparseArray.put(203, "runtimeinittaskend");
    eventNameSparseArray.put(204, "baselibloadasynctaskstart");
    eventNameSparseArray.put(205, "baselibloadasynctaskend");
    eventNameSparseArray.put(206, "apkgloadasynctaskstart");
    eventNameSparseArray.put(207, "apkgloadasynctaskend");
    eventNameSparseArray.put(208, "serviceinittaskstart");
    eventNameSparseArray.put(209, "serviceinittaskend");
    eventNameSparseArray.put(210, "preloadflagtaskstart");
    eventNameSparseArray.put(211, "preloadflagtaskend");
    Object localObject3 = eventNameSparseArray;
    localObject2 = Integer.valueOf(212);
    ((SparseArray)localObject3).put(212, "flutterviewinitstart");
    eventNameSparseArray.put(213, "flutterviewcreateend");
    eventNameSparseArray.put(214, "flutterviewchannelinitend");
    eventNameSparseArray.put(215, "flutterlaunchappstart");
    eventNameSparseArray.put(216, "flutterlaunchappend");
    eventNameSparseArray.put(217, "fluttermatchtimecost");
    eventNameSparseArray.put(218, "fluttersetdatatimecost");
    eventNameSparseArray.put(219, "flutterrendertimecost");
    eventNameSparseArray.put(220, "fluttertotaltimecost");
    eventNameSparseArray.put(221, "runtimecreatetaskstartrealtime");
    eventNameSparseArray.put(222, "runtimeinittaskstartrealtime");
    eventNameSparseArray.put(600, "ssocmdstart");
    eventNameSparseArray.put(601, "ssocmdend");
    eventNameSparseArray.put(602, "x5installsuccess");
    eventNameSparseArray.put(603, "x5installfail");
    eventNameSparseArray.put(604, "x5installtimeout");
    eventNameSparseArray.put(605, "preloadprocess");
    eventNameSparseArray.put(606, "pageshow");
    eventNameSparseArray.put(607, "pagehide");
    eventNameSparseArray.put(612, "pageclick");
    eventNameSparseArray.put(608, "onlaunchsucc");
    eventNameSparseArray.put(609, "onlaunchfail");
    eventNameSparseArray.put(610, "onlaunchtimeout");
    SparseArray localSparseArray = eventNameSparseArray;
    localObject3 = Integer.valueOf(619);
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
    eventNameSparseArray.put(636, "first_render_result");
    eventNameSparseArray.put(637, "re_render_result");
    eventNameSparseArray.put(638, "newpage_result");
    eventNameSparseArray.put(639, "storage_usage");
    eventNameSparseArray.put(640, "http_download");
    eventNameSparseArray.put(641, "http_upload");
    eventNameSparseArray.put(650, "mini_sdk_service_type");
    eventNameSparseArray.put(770, "mini_sdk_embedded_video_widget");
    eventNameSparseArray.put(771, "mini_sdk_embedded_liveplayer_widget");
    eventNameSparseArray.put(772, "mini_sdk_embedded_element_widget");
    eventNameSparseArray.put(780, "mini_sdk_embedded_support_result");
    eventNameSparseArray.put(781, "mini_sdk_embedded_update_result");
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
    eventNeedRecordTime.add(Integer.valueOf(1));
    eventNeedRecordTime.add(localInteger1);
    eventNeedRecordTime.add(Integer.valueOf(6));
    eventNeedRecordTime.add(localObject3);
    eventNeedRecordTime.add(Integer.valueOf(613));
    eventNeedRecordTime.add(Integer.valueOf(621));
    eventNeedRecordTime.add(Integer.valueOf(626));
    eventNeedRecordTime.add(Integer.valueOf(120));
    eventNeedRecordTime.add(Integer.valueOf(121));
    eventNeedRecordTime.add(Integer.valueOf(611));
    eventNeedRecordTime.add(Integer.valueOf(100));
    eventNeedRecordTime.add(Integer.valueOf(101));
    eventNeedRecordTime.add(Integer.valueOf(102));
    eventNeedRecordTime.add(Integer.valueOf(103));
    eventNeedRecordTime.add(localObject3);
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
    eventNeedRecordTime.add(Integer.valueOf(200));
    eventNeedRecordTime.add(Integer.valueOf(202));
    eventNeedRecordTime.add(Integer.valueOf(204));
    eventNeedRecordTime.add(Integer.valueOf(206));
    eventNeedRecordTime.add(Integer.valueOf(208));
    eventNeedRecordTime.add(Integer.valueOf(210));
    eventNeedRecordTime.add(localObject2);
    eventNeedRecordTime.add(localObject2);
    eventNeedRecordTime.add(Integer.valueOf(215));
    eventCostTimeSparseArray.put(2, new MiniReportManager.CostTimeRecord("launch_result", 1));
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
    eventCostTimeSparseArray.put(106, new MiniReportManager.CostTimeRecord("launch_to_web_app_start_result", 1));
    eventCostTimeSparseArray.put(104, new MiniReportManager.CostTimeRecord("launch_to_service_app_start_result", 1));
    eventCostTimeSparseArray.put(107, new MiniReportManager.CostTimeRecord("web_app_end_result", 106));
    eventCostTimeSparseArray.put(105, new MiniReportManager.CostTimeRecord("service_app_end_result", 104));
    eventCostTimeSparseArray.put(611, new MiniReportManager.CostTimeRecord("web_app_to_domready_result", 107));
    eventCostTimeSparseArray.put(121, new MiniReportManager.CostTimeRecord("service_app_to_routedone_result", 105));
    eventCostTimeSparseArray.put(201, new MiniReportManager.CostTimeRecord("runtime_create_task", 200));
    eventCostTimeSparseArray.put(203, new MiniReportManager.CostTimeRecord("runtime_init_task", 202));
    eventCostTimeSparseArray.put(205, new MiniReportManager.CostTimeRecord("base_lib_load_async_task", 204));
    eventCostTimeSparseArray.put(207, new MiniReportManager.CostTimeRecord("apkg_load_async_task", 206));
    eventCostTimeSparseArray.put(209, new MiniReportManager.CostTimeRecord("service_init_task", 208));
    eventCostTimeSparseArray.put(211, new MiniReportManager.CostTimeRecord("preload_flag_task", 210));
    eventCostTimeSparseArray.put(213, new MiniReportManager.CostTimeRecord("flutter_view_create", 212));
    eventCostTimeSparseArray.put(214, new MiniReportManager.CostTimeRecord("flutter_view_channel_init", 212));
    eventCostTimeSparseArray.put(216, new MiniReportManager.CostTimeRecord("flutter_launch_app", 215));
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
    eventNeedRecordFirstTime.add("launch_to_web_app_start_result");
    eventNeedRecordFirstTime.add("launch_to_service_app_start_result");
    eventNeedRecordFirstTime.add("web_app_end_result");
    eventNeedRecordFirstTime.add("service_app_end_result");
    eventNeedRecordFirstTime.add("web_app_to_domready_result");
    eventNeedRecordFirstTime.add("service_app_to_routedone_result");
  }
  
  public static void addCostTimeEventAttachInfo(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    if (paramMiniAppInfo != null) {
      paramMiniAppInfo = paramMiniAppInfo.appId;
    } else {
      paramMiniAppInfo = "0000000000";
    }
    getLaunchState(paramMiniAppInfo).attachInfo.put(Integer.valueOf(paramInt), paramString);
    paramMiniAppInfo = new StringBuilder();
    paramMiniAppInfo.append("addCostTimeEventAttachInfo:  mileStoneEventKey:");
    paramMiniAppInfo.append(paramInt);
    paramMiniAppInfo.append("   attachInfo:");
    paramMiniAppInfo.append(paramString);
    QMLog.d("MiniReportManager", paramMiniAppInfo.toString());
  }
  
  private static void addReportEventToFirstTime(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (eventNeedRecordFirstTime.contains(paramString))
    {
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo = paramMiniAppInfo.appId;
      } else {
        paramMiniAppInfo = "0000000000";
      }
      List localList = (List)eventForFirstTime.get(paramMiniAppInfo);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        eventForFirstTime.put(paramMiniAppInfo, localObject);
      }
      ((List)localObject).add(paramString);
    }
  }
  
  private static void appendJsErrorToReportedList(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (!TextUtils.isEmpty(paramString)))
    {
      if (APPID_JS_ERROR_MAP.get(paramMiniAppInfo.appId) == null) {
        APPID_JS_ERROR_MAP.put(paramMiniAppInfo.appId, new ArrayList());
      }
      ((List)APPID_JS_ERROR_MAP.get(paramMiniAppInfo.appId)).add(paramString);
    }
  }
  
  private static void detectWhiteScreen(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, MiniReportManager.MiniAppLaunchState paramMiniAppLaunchState)
  {
    if ((paramInt == 20) && (!paramMiniAppLaunchState.hasOnloaded) && (paramMiniAppLaunchState.eventTime.containsKey(Integer.valueOf(121))))
    {
      long l1 = ((Long)paramMiniAppLaunchState.eventTime.get(Integer.valueOf(121))).longValue();
      boolean bool = paramMiniAppLaunchState.eventTime.containsKey(Integer.valueOf(611));
      paramMiniAppLaunchState.eventTime.remove(Integer.valueOf(121));
      long l2 = paramLong - l1;
      paramInt = WnsConfig.getConfig("qqminiapp", "mini_app_report_white_screen_check", 5000);
      if ((l1 > 0L) && (l2 > paramInt) && (!bool))
      {
        paramMiniAppLaunchState = new StringBuilder();
        paramMiniAppLaunchState.append("detect white_screen. after routedone time:");
        paramMiniAppLaunchState.append(l2);
        paramMiniAppLaunchState.append(" domreadyTime:");
        paramMiniAppLaunchState.append(bool);
        QMLog.e("MiniReportManager", paramMiniAppLaunchState.toString());
        MiniProgramLpReportDC04266.report(paramMiniAppInfo, 150, paramString1, paramString2, "", 0, paramString3, 0L, "", paramLong, "route_done", String.valueOf(l2), "", "", paramString4);
        if (WnsConfig.getConfig("qqminiapp", "mini_app_report_white_screen_enable_clear_apkg_cache", 0) == 1)
        {
          paramString1 = new StringBuilder();
          paramString1.append("detect white_screen. clear apkg:");
          paramString1.append(paramMiniAppInfo);
          QMLog.e("MiniReportManager", paramString1.toString());
          MiniCacheFreeManager.freeCache(LoginManager.getInstance().getAccount(), paramMiniAppInfo, true, null);
        }
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
  
  public static String getAppType(MiniAppInfo paramMiniAppInfo)
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
      int i = localMiniAppLaunchState.eventTimeFirst.size();
      JSONObject localJSONObject;
      if (i > 0)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("navigationStart", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(1)));
        localJSONObject.put("serviceStart", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(100)));
        localJSONObject.put("serviceEnd", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(101)));
        localJSONObject.put("viewStart", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(102)));
        localJSONObject.put("viewEnd", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(103)));
        localJSONObject.put("fetchPkgStart", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(619)));
        localJSONObject.put("fetchPkgEnd", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(620)));
        localJSONObject.put("fetchSdkStart", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(4)));
        localJSONObject.put("fetchSdkEnd", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(5)));
        localJSONObject.put("loadSdkServiceStart", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(14)));
        localJSONObject.put("loadSdkServiceEnd", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(15)));
        localJSONObject.put("loadSdkViewStart", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(18)));
        localJSONObject.put("loadSdkViewEnd", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(19)));
        localJSONObject.put("loadAppServiceStart", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(104)));
        localJSONObject.put("loadAppServiceEnd", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(105)));
        localJSONObject.put("loadAppViewStart", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(106)));
        localJSONObject.put("loadAppViewEnd", localMiniAppLaunchState.eventTimeFirst.get(Integer.valueOf(107)));
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
        paramString.put(localJSONObject);
      }
    }
    catch (Exception localException)
    {
      QMLog.e("MiniReportManager", "create performance result failed", localException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getformance: ");
    localStringBuilder.append(paramString.toString());
    QMLog.e("MiniReportManager", localStringBuilder.toString());
    return paramString;
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
  
  private static long getStartTime(MiniReportManager.MiniAppLaunchState paramMiniAppLaunchState, MiniReportManager.CostTimeRecord paramCostTimeRecord)
  {
    paramMiniAppLaunchState = (Long)paramMiniAppLaunchState.eventTime.get(Integer.valueOf(paramCostTimeRecord.eventStart));
    if (paramMiniAppLaunchState != null) {
      return paramMiniAppLaunchState.longValue();
    }
    return 0L;
  }
  
  private static boolean isJsErrorReported(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (paramMiniAppInfo != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      paramMiniAppInfo = (List)APPID_JS_ERROR_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null)
      {
        paramMiniAppInfo = paramMiniAppInfo.iterator();
        while (paramMiniAppInfo.hasNext()) {
          if (paramString.equals((String)paramMiniAppInfo.next())) {
            return true;
          }
        }
      }
      return false;
    }
    return true;
  }
  
  private static boolean needReportEvent(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (eventNeedRecordFirstTime.contains(paramString))
    {
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo = paramMiniAppInfo.appId;
      } else {
        paramMiniAppInfo = "0000000000";
      }
      paramMiniAppInfo = (List)eventForFirstTime.get(paramMiniAppInfo);
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.contains(paramString))) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean needReportToDC5332(String paramString1, String paramString2, String paramString3)
  {
    if ((QUAUtil.isQQApp()) && ("1".equals(paramString1)) && (!"hot_start".equals(paramString3))) {
      return eventNameToDC5332.contains(paramString2);
    }
    return false;
  }
  
  private static long onLaunchStart(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong1, long paramLong2, String paramString, MiniReportManager.MiniAppLaunchState paramMiniAppLaunchState)
  {
    int i = 1;
    long l = paramLong1;
    if (paramInt == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launch start  uptimeMillis:");
      localStringBuilder.append(SystemClock.uptimeMillis());
      localStringBuilder.append("  currentTimeMillis :");
      localStringBuilder.append(paramLong2);
      QMLog.d("MiniReportManager", localStringBuilder.toString());
      if ((paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.supportNativeRenderMode())) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      if (paramInt == 0) {
        MiniAppStartState.reset(paramString);
      }
      paramLong2 = paramLong1;
      if (paramMiniAppInfo != null)
      {
        paramLong2 = paramLong1;
        if (paramMiniAppInfo.launchParam != null)
        {
          paramLong2 = paramLong1;
          if (paramMiniAppInfo.launchParam.launchClickTimeMillis != 0L)
          {
            paramLong2 = paramMiniAppInfo.launchParam.launchClickTimeMillis;
            paramString = new StringBuilder();
            paramString.append("reportEventType: fix onlaunch timestamp to ");
            paramString.append(paramMiniAppInfo.launchParam.launchClickTimeMillis);
            QMLog.d("MiniReportManager", paramString.toString());
            paramMiniAppInfo.launchParam.launchClickTimeMillis = 0L;
          }
        }
      }
      paramMiniAppLaunchState.hasOnloaded = false;
      if (!paramMiniAppLaunchState.firstRender)
      {
        paramMiniAppInfo = getLaunchState("0000000000");
        l = paramLong2;
        if (paramMiniAppInfo != null)
        {
          l = paramLong2;
          if (paramMiniAppInfo.eventTime.size() > 0)
          {
            paramMiniAppLaunchState.eventTime.putAll(paramMiniAppInfo.eventTime);
            paramMiniAppInfo.eventTime.clear();
            return paramLong2;
          }
        }
      }
      else
      {
        l = paramLong2;
        if (paramMiniAppLaunchState.eventTimeFirst.size() == 0)
        {
          paramMiniAppLaunchState.eventTimeFirst.putAll(paramMiniAppLaunchState.eventTime);
          paramMiniAppLaunchState.launchIdFirst = paramMiniAppLaunchState.launchId;
          paramMiniAppLaunchState.launchId = "";
          l = paramLong2;
        }
      }
    }
    return l;
  }
  
  private static void reportCostTimeEvent(MiniAppInfo paramMiniAppInfo, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, MiniReportManager.MiniAppLaunchState paramMiniAppLaunchState, String paramString5)
  {
    Object localObject = (MiniReportManager.CostTimeRecord)eventCostTimeSparseArray.get(paramInt1);
    if (localObject != null)
    {
      long l = getStartTime(paramMiniAppLaunchState, (MiniReportManager.CostTimeRecord)localObject);
      if (l > 0L)
      {
        l = paramLong1 - l;
        localObject = ((MiniReportManager.CostTimeRecord)localObject).eventName;
        boolean bool = needReportEvent(paramMiniAppInfo, (String)localObject);
        paramMiniAppLaunchState = (String)paramMiniAppLaunchState.attachInfo.get(Integer.valueOf(paramInt1));
        if (l >= 0L)
        {
          paramInt1 = MAX_TIME_COST;
          paramLong1 = l;
          if (l > paramInt1) {
            paramLong1 = paramInt1;
          }
          if (QMLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("timeCostEvent  event:");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(";costTime:");
            localStringBuilder.append(paramLong1);
            localStringBuilder.append("ms");
            QMLog.e("MiniReportManager", localStringBuilder.toString());
          }
          if (bool)
          {
            MiniProgramLpReportDC04266.reportCostTimeEvent(paramMiniAppInfo, (String)localObject, paramMiniAppLaunchState, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramString5);
            addReportEventToFirstTime(paramMiniAppInfo, (String)localObject);
          }
        }
        else
        {
          paramMiniAppInfo = new StringBuilder();
          paramMiniAppInfo.append("costTime < 0 ");
          paramMiniAppInfo.append(l);
          QMLog.e("MiniReportManager", paramMiniAppInfo.toString());
        }
      }
    }
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt1, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    long l = System.currentTimeMillis();
    String str3 = "";
    String str2;
    String str1;
    if (paramMiniAppInfo != null)
    {
      str2 = paramMiniAppInfo.appId;
      int i = paramMiniAppInfo.renderMode;
      str1 = String.valueOf(i);
    }
    else
    {
      str2 = "0000000000";
      str1 = "";
    }
    MiniReportManager.MiniAppLaunchState localMiniAppLaunchState = getLaunchState(str2);
    paramLong1 = onLaunchStart(paramMiniAppInfo, paramInt1, paramLong1, l, str2, localMiniAppLaunchState);
    if ((paramInt1 == 611) && (!localMiniAppLaunchState.hasOnloaded)) {
      paramInt1 = 2;
    }
    if (paramInt1 == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launch end  uptimeMillis:");
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis());
      ((StringBuilder)localObject).append("  currentTimeMillis :");
      ((StringBuilder)localObject).append(l);
      QMLog.d("MiniReportManager", ((StringBuilder)localObject).toString());
      if (localMiniAppLaunchState.hasOnloaded)
      {
        QMLog.d("MiniReportManager", "has report apponloaded. ignore apponloaed ");
        return;
      }
      localMiniAppLaunchState.hasOnloaded = true;
      localMiniAppLaunchState.firstRender = true;
      localMiniAppLaunchState.launchId = MiniProgramReportHelper.launchIdForMiniAppConfig(paramMiniAppInfo);
    }
    detectWhiteScreen(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString4, paramLong1, str1, localMiniAppLaunchState);
    if (eventNeedRecordTime.contains(Integer.valueOf(paramInt1))) {
      localMiniAppLaunchState.eventTime.put(Integer.valueOf(paramInt1), Long.valueOf(paramLong1));
    }
    Object localObject = getAppStateManager(paramMiniAppInfo);
    if (localObject != null)
    {
      str1 = str3;
      if (((AppStateManager)localObject).isFlutter) {
        str1 = "1";
      }
    }
    MiniProgramLpReportDC04266.report(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong2, paramString5, paramLong1, paramString6, paramString7, paramString8, paramString9, str1);
    reportCostTimeEvent(paramMiniAppInfo, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9, l, paramLong1, localMiniAppLaunchState, str1);
    if ((paramInt1 == 2) && ("0".equals(paramString4))) {
      MiniProgramLpReportDC04266.report(paramMiniAppInfo, 630, paramString1, "0", null, 0, paramString4, 0L, null, paramLong1, "", "", "", "", str1);
    }
    reportPostProcess(paramInt1, str2);
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString)
  {
    reportEventType(paramMiniAppInfo, paramInt, null, null, null, 0, paramString, 0L, null, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString, long paramLong)
  {
    reportEventType(paramMiniAppInfo, paramInt, null, null, null, 0, paramString, paramLong, null, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString1, String paramString2)
  {
    reportEventType(paramMiniAppInfo, paramInt, null, paramString1, null, 0, paramString2, 0L, null, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    reportEventType(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, getAppType(paramMiniAppInfo), 0L, null);
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5)
  {
    reportEventType(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, paramString5, "", "", "", "");
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    reportEventType(paramMiniAppInfo, paramInt1, System.currentTimeMillis(), paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong, paramString5, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    reportEventType(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, getAppType(paramMiniAppInfo), 0L, null, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void reportEventType(MiniAppInfo paramMiniAppInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    reportEventType(paramMiniAppInfo, paramInt, null, null, null, 0, paramString1, 0L, null, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static void reportJsError(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (!isJsErrorReported(paramMiniAppInfo, paramString2))
    {
      reportEventType(paramMiniAppInfo, 23, paramString1, paramString2, null, 0);
      appendJsErrorToReportedList(paramMiniAppInfo, paramString2);
    }
  }
  
  private static void reportPostProcess(int paramInt, String paramString)
  {
    if (paramInt == 22) {
      eventForFirstTime.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniReportManager
 * JD-Core Version:    0.7.0.1
 */