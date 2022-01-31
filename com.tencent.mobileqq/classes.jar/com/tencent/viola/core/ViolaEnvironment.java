package com.tencent.viola.core;

import android.app.Application;

public class ViolaEnvironment
{
  public static String BIZ_END_EXIT_CACHE;
  public static String BIZ_END_EXIT_OFFLINE;
  public static String BIZ_END_NET;
  public static String BIZ_END_OFFLINE;
  public static String BIZ_ERROR_CHANGE_CGI;
  public static String BIZ_ERROR_NET;
  public static String BIZ_ERROR_OFFLINE;
  public static String BIZ_START;
  public static String CHANGE_END = "9";
  public static String CHANGE_ERROR_CONNECT_TIMEOUT;
  public static String CHANGE_ERROR_CONNECT_UNAVALIABLE;
  public static String CHANGE_ERROR_DATA;
  public static String CHANGE_ERROR_HTTP_CODE;
  public static String CHANGE_ERROR_IO;
  public static String CHANGE_ERROR_UNKNOW;
  public static String CHANGE_ERROR_URL;
  public static String CHANGE_START;
  public static String COMMON_APPLICATION;
  public static String COMMON_BIZ;
  public static String COMMON_NET;
  public static String COMMON_OPEN_COUNT;
  public static String COMMON_OPERATION_VERSION;
  public static String COMMON_PAGE_NAME;
  public static String COMMON_PHONE_TYPE;
  public static String COMMON_PLATFORM;
  public static String COMMON_QQ_VERSION;
  public static String COMMON_RELEASE;
  public static String COMMON_UIN;
  public static String COMMON_VIOLA_JSON;
  public static String HTTP_DATA_LENGTH;
  public static String HTTP_TIME;
  public static String JS_END;
  public static String JS_ERROR_AFTER_RENDER;
  public static String JS_ERROR_BEFORE_RENDER;
  public static String JS_START;
  public static String KEY_BIZ;
  public static String KEY_CHANGE;
  public static String KEY_FRAME_PAGE;
  public static String KEY_MAIN;
  public static String KEY_PAGE_PROCESS;
  public static String KEY_RENDER_JS;
  public static String KEY_SO;
  public static String LIST_KANDIAN_VIOLA;
  public static String MAIN_END_EXIT;
  public static String MAIN_END_EXIT_CACHE;
  public static String MAIN_END_NET;
  public static String MAIN_END_OFFLINE;
  public static String MAIN_ERROR_NET;
  public static String MAIN_ERROR_OFFLINE;
  public static String MAIN_START;
  public static String MEMORY_PAGE;
  public static String MEMORY_RENDER;
  public static String MEMORY_RENDER_BEFORE;
  public static String PAGE_ERROR_BIZ_JS;
  public static String PAGE_ERROR_CHANGE_CGI;
  public static String PAGE_ERROR_MAIN_JS;
  public static String PAGE_ERROR_NOT_RECEIVE_ORDER;
  public static String PAGE_ERROR_SDK;
  public static String PAGE_ERROR_SO;
  public static String PAGE_ERROR_UNKNOW_CRASH;
  public static String PAGE_OPEN_END;
  public static String SO_END_EXIT;
  public static String SO_END_NET;
  public static String SO_END_OFFLINE;
  public static String SO_ERROR_NET;
  public static String SO_ERROR_OFFLINE;
  public static String SO_ERROR_UNZIP;
  public static String SO_START;
  public static String TIME_APPLY_LAYPUTANDEVENT;
  public static String TIME_BIND_DATA;
  public static String TIME_BIZ_JS_NET;
  public static String TIME_BIZ_JS_OFFLINE;
  public static String TIME_COMPONENT_TREE;
  public static String TIME_CREATE_VIEW;
  public static String TIME_DOM_TREE;
  public static String TIME_LAYOUT;
  public static String TIME_MAIN_JS_NET;
  public static String TIME_MAIN_JS_OFFLINE;
  public static String TIME_PAGE;
  public static String TIME_RENDER_JS;
  public static String TIME_REVEIVE_ORDER;
  public static String TIME_SDK_INIT;
  public static String TIME_SDK_MAIN;
  public static String TIME_SO;
  public static boolean debugable = false;
  public static Application sApplication;
  
  static
  {
    TIME_SO = "TIME_SO";
    TIME_MAIN_JS_OFFLINE = "TIME_MAIN_JS_OFFLINE";
    TIME_MAIN_JS_NET = "TIME_MAIN_JS_NET";
    TIME_SDK_MAIN = "TIME_SDK_MAIN";
    TIME_SDK_INIT = "TIME_SDK_INIT";
    TIME_BIZ_JS_OFFLINE = "TIME_BIZ_JS_OFFLINE";
    TIME_BIZ_JS_NET = "TIME_BIZ_JS_NET";
    TIME_REVEIVE_ORDER = "TIME_REVEIVE_ORDER";
    TIME_DOM_TREE = "TIME_DOM_TREE";
    TIME_COMPONENT_TREE = "TIME_COMPONENT_TREE";
    TIME_LAYOUT = "TIME_LAYOUT";
    TIME_CREATE_VIEW = "TIME_CREATE_VIEW";
    TIME_APPLY_LAYPUTANDEVENT = "TIME_APPLY_LAYPUTANDEVENT";
    TIME_BIND_DATA = "TIME_BIND_DATA";
    TIME_PAGE = "TIME_PAGE";
    TIME_RENDER_JS = "TIME_RENDER_JS";
    KEY_FRAME_PAGE = "KEY_FRAME_PAGE";
    KEY_PAGE_PROCESS = "KEY_PAGE_PROCESS";
    PAGE_ERROR_SO = "2";
    PAGE_ERROR_MAIN_JS = "3";
    PAGE_ERROR_SDK = "4";
    PAGE_ERROR_BIZ_JS = "5";
    PAGE_OPEN_END = "6";
    PAGE_ERROR_CHANGE_CGI = "7";
    PAGE_ERROR_UNKNOW_CRASH = "9";
    PAGE_ERROR_NOT_RECEIVE_ORDER = "10";
    JS_ERROR_BEFORE_RENDER = "JS_ERROR_BEFORE_RENDER";
    JS_ERROR_AFTER_RENDER = "JS_ERROR_AFTER_RENDER";
    KEY_RENDER_JS = "KEY_RENDER_JS";
    JS_START = "1";
    JS_END = "2";
    KEY_SO = "KEY_SO";
    SO_START = "1";
    SO_ERROR_OFFLINE = "2";
    SO_ERROR_NET = "3";
    SO_ERROR_UNZIP = "4";
    SO_END_OFFLINE = "5";
    SO_END_NET = "6";
    SO_END_EXIT = "7";
    KEY_MAIN = "KEY_MAIN";
    MAIN_START = "1";
    MAIN_ERROR_OFFLINE = "2";
    MAIN_ERROR_NET = "3";
    MAIN_END_OFFLINE = "4";
    MAIN_END_NET = "5";
    MAIN_END_EXIT = "6";
    MAIN_END_EXIT_CACHE = "7";
    KEY_BIZ = "KEY_BIZ";
    BIZ_START = "1";
    BIZ_ERROR_OFFLINE = "2";
    BIZ_ERROR_NET = "3";
    BIZ_END_OFFLINE = "4";
    BIZ_END_NET = "5";
    BIZ_END_EXIT_OFFLINE = "6";
    BIZ_ERROR_CHANGE_CGI = "7";
    BIZ_END_EXIT_CACHE = "8";
    COMMON_UIN = "COMMON_UIN";
    COMMON_QQ_VERSION = "COMMON_QQ_VERSION";
    COMMON_OPERATION_VERSION = "COMMON_OPERATION_VERSION";
    COMMON_PHONE_TYPE = "COMMON_PHONE_TYPE";
    COMMON_PLATFORM = "COMMON_PLATFORM";
    COMMON_NET = "COMMON_NET";
    COMMON_BIZ = "COMMON_BIZ";
    COMMON_OPEN_COUNT = "COMMON_OPEN_COUNT";
    COMMON_PAGE_NAME = "COMMON_PAGE_NAME";
    COMMON_RELEASE = "COMMON_RELEASE";
    COMMON_APPLICATION = "COMMON_APPLICATION";
    MEMORY_PAGE = "MEMORY_PAGE";
    MEMORY_RENDER_BEFORE = "MEMORY_RENDER_BEFORE";
    MEMORY_RENDER = "MEMORY_RENDER";
    HTTP_TIME = "HTTP_TIME";
    HTTP_DATA_LENGTH = "HTTP_DATA_LENGTH";
    LIST_KANDIAN_VIOLA = "list_kandian_viola";
    COMMON_VIOLA_JSON = "COMMON_VIOLA_JSON";
    KEY_CHANGE = "KEY_CHANGE";
    CHANGE_START = "1";
    CHANGE_ERROR_CONNECT_TIMEOUT = "2";
    CHANGE_ERROR_CONNECT_UNAVALIABLE = "3";
    CHANGE_ERROR_URL = "4";
    CHANGE_ERROR_HTTP_CODE = "5";
    CHANGE_ERROR_DATA = "6";
    CHANGE_ERROR_IO = "7";
    CHANGE_ERROR_UNKNOW = "8";
  }
  
  public static Application getApplication()
  {
    return sApplication;
  }
  
  public static boolean isDebugable()
  {
    return debugable;
  }
  
  public static void setDebugable(boolean paramBoolean)
  {
    debugable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.ViolaEnvironment
 * JD-Core Version:    0.7.0.1
 */