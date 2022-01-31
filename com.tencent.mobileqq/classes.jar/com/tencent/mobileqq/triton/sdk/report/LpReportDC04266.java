package com.tencent.mobileqq.triton.sdk.report;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LpReportDC04266
{
  private static final Map<String, List<String>> APPID_JS_ERROR_MAP = new HashMap();
  public static final int APP_DOWNLOAD_END = 620;
  public static final int APP_DOWNLOAD_START = 619;
  public static final int APP_EXIT = 22;
  public static final int APP_FIRST_NEWPAGE_RESULT = 638;
  public static final int APP_FIRST_RENDER_RESULT = 636;
  public static final int APP_FIRST_RE_RENDER_RESULT = 637;
  public static final int APP_FIRST_STORAGE_USAGE = 639;
  public static final int APP_LOAD_END = 105;
  public static final int APP_LOAD_FAIL = 609;
  public static final int APP_LOAD_START = 104;
  public static final int APP_LOAD_SUCC = 608;
  public static final int APP_LOAD_TIMEOUT = 610;
  public static final int APP_STAY_DURATION = 644;
  public static final int APP_UNZIP_END = 622;
  public static final int APP_UNZIP_START = 621;
  public static final int BASE_JS_DOWNLOAD_END = 5;
  public static final int BASE_JS_DOWNLOAD_FAILED = 617;
  public static final int BASE_JS_DOWNLOAD_START = 4;
  public static final int BASE_JS_LOAD_END = 17;
  public static final int BASE_JS_LOAD_START = 16;
  public static final int BASE_JS_READ_END = 9;
  public static final int BASE_JS_READ_START = 8;
  public static final int BASE_JS_UNZIP_END = 7;
  public static final int BASE_JS_UNZIP_FAILED = 618;
  public static final int BASE_JS_UNZIP_START = 6;
  public static final int CAPSULE_BUTTON_CLOSE_CLICK = 1025;
  public static final int CPU_PERFORMANCE = 629;
  public static final int DOM_READY = 611;
  public static final int FPS_PERFORMANCE = 630;
  public static final int FPS_VARIANCE = 642;
  public static final int GET_APKG_INFO_END = 13;
  public static final int GET_APKG_INFO_START = 12;
  public static final int HIDE = 20;
  public static final int HTTP_DOWNLOAD = 640;
  public static final int HTTP_REQUEST_RESULT = 628;
  public static final int HTTP_UPLOAD = 641;
  public static final int JS_ERROR = 23;
  public static final int LAUNCH_END = 2;
  public static final int LAUNCH_START = 1;
  public static final int LOADING_PAGE_CLOSE_CLICK = 1026;
  public static final int MEMORY_GROWTH = 643;
  public static final int MEMORY_PERFORMANCE = 631;
  public static final int MINI_APP_START_BY_CACHE = 1028;
  public static final int MINI_GAME_BASE_LIB_INSTALL_SKIP = 1012;
  public static final int MINI_GAME_BASE_LIB_LOAD_JAR = 1003;
  public static final int MINI_GAME_BASE_LIB_LOAD_JAR_END = 1004;
  public static final int MINI_GAME_BASE_LIB_LOAD_JS = 1005;
  public static final int MINI_GAME_BASE_LIB_LOAD_JS_END = 1006;
  public static final int MINI_GAME_BASE_LIB_LOAD_SO = 1001;
  public static final int MINI_GAME_BASE_LIB_LOAD_SO_END = 1002;
  public static final int MINI_GAME_BLACK_SCREEN = 1018;
  public static final int MINI_GAME_ENTER_LOADING_PAGE = 1013;
  public static final int MINI_GAME_ERROR_DIALOG = 1024;
  public static final int MINI_GAME_FIRST_LAUNCH = 1022;
  public static final int MINI_GAME_FIRST_STAY_DURATION = 1020;
  public static final int MINI_GAME_IMAGE_DOWNLOAD = 1027;
  public static final int MINI_GAME_LOAD_BASE_LIB = 1014;
  public static final int MINI_GAME_LOAD_BASE_LIB_END = 1015;
  public static final int MINI_GAME_LOAD_MAIN_PKG = 1007;
  public static final int MINI_GAME_LOAD_MAIN_PKG_END = 1008;
  public static final int MINI_GAME_LOAD_SUB_PKG = 1009;
  public static final int MINI_GAME_LOAD_SUB_PKG_END = 1010;
  public static final int MINI_GAME_NO_REFRESH = 1019;
  public static final int MINI_GAME_ON_FIRST_HIDE = 1016;
  public static final int MINI_GAME_PROGRESS_ERROR = 1011;
  public static final int MINI_GAME_STAY_DURATION = 1021;
  public static final int MINI_GAME_SURVIVAL = 1017;
  public static final int MINI_GAME_TWICE_LAUNCH = 1023;
  public static final int PAGE_CLICK = 612;
  public static final int PAGE_FRAME_LOAD_END = 624;
  public static final int PAGE_FRAME_LOAD_START = 623;
  public static final int PAGE_HIDE = 607;
  public static final int PAGE_SHOW = 606;
  public static final int PRELOAD_PROCESS = 605;
  public static final int PRELOAD_PROCESS_END = 627;
  public static final int PRELOAD_PROCESS_START = 626;
  public static final int SERVICE_APP_END = 105;
  public static final int SERVICE_APP_START = 104;
  public static final int SERVICE_CREATE_END = 101;
  public static final int SERVICE_CREATE_START = 100;
  public static final int SERVICE_JS_LOAD_END = 15;
  public static final int SERVICE_JS_LOAD_START = 14;
  public static final int SERVICE_JS_READ_END = 11;
  public static final int SERVICE_JS_READ_START = 10;
  public static final int SHOW = 21;
  public static final int SSO_CMD_END = 601;
  public static final int SSO_CMD_START = 600;
  public static final int SUB_PACKAGE_DOWNLOAD_END = 614;
  public static final int SUB_PACKAGE_DOWNLOAD_START = 613;
  public static final int SUB_PACKAGE_UNPACK_END = 616;
  public static final int SUB_PACKAGE_UNPACK_START = 615;
  private static final String TAG = "LpReportDC04266";
  public static final int WEBVIEW_APP_END = 107;
  public static final int WEBVIEW_APP_START = 106;
  public static final int WEBVIEW_CREATE_END = 103;
  public static final int WEBVIEW_CREATE_START = 102;
  public static final int WEBVIEW_INIT = 625;
  public static final int WEBVIEW_JS_LOAD_END = 19;
  public static final int WEBVIEW_JS_LOAD_START = 18;
  public static final int WEB_SOCKET_CLOSE = 633;
  public static final int WEB_SOCKET_FAILURE = 634;
  public static final int WEB_SOCKET_OPEN = 632;
  public static final int X5_INSTALL_FAIL = 603;
  public static final int X5_INSTALL_SUCCESS = 602;
  public static final int X5_INSTALL_TIMEOUT = 604;
  private static SparseArray<String> eventNameSparseArray = new SparseArray();
  
  static
  {
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
    eventNameSparseArray.put(16, "basejsstart");
    eventNameSparseArray.put(17, "basejsready");
    eventNameSparseArray.put(18, "basejsstart");
    eventNameSparseArray.put(19, "basejsready");
    eventNameSparseArray.put(2, "apponloaded");
    eventNameSparseArray.put(20, "apponhide");
    eventNameSparseArray.put(21, "apponshow");
    eventNameSparseArray.put(22, "apponunload");
    eventNameSparseArray.put(23, "jsonerror");
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
    eventNameSparseArray.put(1028, "miniappstartbycache");
  }
  
  public static String getEventName(int paramInt)
  {
    if (!TextUtils.isEmpty((CharSequence)eventNameSparseArray.get(paramInt))) {
      return (String)eventNameSparseArray.get(paramInt);
    }
    return String.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.report.LpReportDC04266
 * JD-Core Version:    0.7.0.1
 */