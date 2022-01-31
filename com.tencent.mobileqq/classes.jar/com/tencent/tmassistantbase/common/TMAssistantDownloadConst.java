package com.tencent.tmassistantbase.common;

public class TMAssistantDownloadConst
{
  public static final int BATCH_SDKDOWNLOAD_ACTION_CANCEL = 3;
  public static final int BATCH_SDKDOWNLOAD_ACTION_DELETE = 4;
  public static final int BATCH_SDKDOWNLOAD_ACTION_INSTALL = 5;
  public static final int BATCH_SDKDOWNLOAD_ACTION_OPEN = 6;
  public static final int BATCH_SDKDOWNLOAD_ACTION_PAUSE = 2;
  public static final int BATCH_SDKDOWNLOAD_ACTION_START = 1;
  public static final String CLIENT_KEY = "client_key";
  public static final byte DOWNLOADTYPE_DIFF_UPDATE = 3;
  public static final byte DOWNLOADTYPE_FULL_UPDATE = 1;
  public static final byte DOWNLOADTYPE_NORMAL_DOWNLOAD = 2;
  public static String PARAM_APPID = "appId";
  public static String PARAM_APP_NAME;
  public static String PARAM_CHANNELID;
  public static String PARAM_DOWNLOADSIZE;
  public static String PARAM_DOWNLOADTSTYLE;
  public static String PARAM_DOWNLOADTYPE;
  public static String PARAM_EXTRA_DATA;
  public static String PARAM_ICON_URL;
  public static String PARAM_IS_AUTOINSTALL_BY_SDK;
  public static String PARAM_SHOW_NOTIFICATION;
  public static String PARAM_TASK_PACKNAME = "packageName";
  public static String PARAM_TASK_VERSION = "versionCode";
  public static String PARAM_UIN;
  public static String PARAM_UIN_TYPE;
  public static String PARAM_VIA = "via";
  public static int SHOW_NOTIFICATION_FALSE = 0;
  public static int SHOW_NOTIFICATION_TRUE = 0;
  public static final String UINTYPE_CODE = "code";
  public static final String UINTYPE_COMMONID = "commonId";
  public static final String UINTYPE_OPENID = "game_openId";
  public static final String UINTYPE_QQ_NUM = "qqNumber";
  
  static
  {
    PARAM_DOWNLOADTYPE = "downloadType";
    PARAM_DOWNLOADTSTYLE = "downloadStyle";
    PARAM_DOWNLOADSIZE = "downloadSize";
    PARAM_UIN = "uin";
    PARAM_UIN_TYPE = "uinType";
    PARAM_CHANNELID = "channelId";
    PARAM_EXTRA_DATA = "extra_data";
    PARAM_ICON_URL = "icon_url";
    PARAM_APP_NAME = "app_name";
    PARAM_SHOW_NOTIFICATION = "show_notification";
    PARAM_IS_AUTOINSTALL_BY_SDK = "is_autoInstall_by_sdk";
    SHOW_NOTIFICATION_TRUE = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.common.TMAssistantDownloadConst
 * JD-Core Version:    0.7.0.1
 */