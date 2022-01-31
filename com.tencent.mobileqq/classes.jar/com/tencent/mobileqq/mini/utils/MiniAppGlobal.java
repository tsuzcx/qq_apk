package com.tencent.mobileqq.mini.utils;

import android.os.Environment;
import common.config.service.QzoneConfig;
import java.io.File;

public class MiniAppGlobal
{
  public static final String CAPSULE_CLOSE_DARK_URL;
  public static final String CAPSULE_CLOSE_URL;
  public static final String CONFIG_DEFAULT_BASE_LIB_VERSION = "1.10.0.00173";
  public static final String DEFAULT_APPID_WHITE_LIST = "1108291530,1108164955,1108961705,1109048181";
  public static final String DEFAULT_OUTSITE_BLACK_LIST = "";
  public static final String INNER_JSSDK_ASSETS_PATH = "mini";
  public static final String KINGCARD_GUIDE_DARK_LOTTIE = QzoneConfig.getInstance().getConfig("qqminiapp", "kingcardGuideDarkLottie", "https://d3g.qq.com/sngapp/app/update/20191105162320_6114/kingCardDark.zip");
  public static final String KINGCARD_GUIDE_ICON;
  public static final String KINGCARD_GUIDE_LOTTIE = QzoneConfig.getInstance().getConfig("qqminiapp", "kingcardGuideLottie", "https://d3g.qq.com/sngapp/app/update/20191105163020_3367/kingCard.zip");
  public static final String KINGCARD_GUIDE_TEXT;
  public static final String MINI_FILE_SUB_PATH = "/tencent/mini/files/";
  public static final String MINI_LOG_PATH;
  public static final int MSG_WHAT_APKG_FAIL = 315;
  public static final int MSG_WHAT_APKG_SUCC = 316;
  public static final int MSG_WHAT_APP_EVENT_APPROUTE_DONE = 317;
  public static final int MSG_WHAT_APP_EVEN_JSCORE_INIT_FINISH = 320;
  public static final int MSG_WHAT_APP_LOAD_TIMEOUT = 318;
  public static final int MSG_WHAT_APP_WEBVIEW_STARTED = 319;
  public static final int MSG_WHAT_BASE = 300;
  public static final int MSG_WHAT_BASELIB_LOAD_COMPLETED = 321;
  public static final int MSG_WHAT_BASELIB_LOAD_FAIL = 310;
  public static final int MSG_WHAT_BASELIB_LOAD_SUCC = 311;
  public static final int MSG_WHAT_SERVICE_INIT_TIMEOUT = 322;
  public static final int MSG_WHAT_X5_DOWNLOAD_FAIL = 302;
  public static final int MSG_WHAT_X5_DOWNLOAD_PROGRESS = 303;
  public static final int MSG_WHAT_X5_DOWNLOAD_SUCC = 301;
  public static final int MSG_WHAT_X5_INSTALL_FAIL = 305;
  public static final int MSG_WHAT_X5_INSTALL_SUCC = 304;
  public static final int MSG_WHAT_X5_TIMEOUT = 306;
  public static final String STR_WXFILE = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppFileString", "wxfile://");
  public static final String URL_UPGRADE = "https://m.q.qq.com/upgrade/{appid}";
  
  static
  {
    MINI_LOG_PATH = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/files/";
    CAPSULE_CLOSE_URL = QzoneConfig.getInstance().getConfig("qqminiapp", "closebutton", null);
    CAPSULE_CLOSE_DARK_URL = QzoneConfig.getInstance().getConfig("qqminiapp", "closebuttondark", null);
    KINGCARD_GUIDE_TEXT = QzoneConfig.getInstance().getConfig("qqminiapp", "kingcardGuideText", "");
    KINGCARD_GUIDE_ICON = QzoneConfig.getInstance().getConfig("qqminiapp", "kingcardGuideIcon", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.MiniAppGlobal
 * JD-Core Version:    0.7.0.1
 */