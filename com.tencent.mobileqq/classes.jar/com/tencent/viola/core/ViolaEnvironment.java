package com.tencent.viola.core;

import android.app.Application;

public class ViolaEnvironment
{
  public static String BIZ_END_EXIT_CACHE = "8";
  public static String BIZ_END_EXIT_OFFLINE = "6";
  public static String BIZ_END_NET = "5";
  public static String BIZ_END_OFFLINE = "4";
  public static String BIZ_ERROR_CHANGE_CGI = "7";
  public static String BIZ_ERROR_NET = "3";
  public static String BIZ_ERROR_OFFLINE = "2";
  public static String BIZ_START = "1";
  public static String CHANGE_END = "9";
  public static String CHANGE_ERROR_CONNECT_TIMEOUT = "2";
  public static String CHANGE_ERROR_CONNECT_UNAVALIABLE = "3";
  public static String CHANGE_ERROR_DATA = "6";
  public static String CHANGE_ERROR_HTTP_CODE = "5";
  public static String CHANGE_ERROR_IO = "7";
  public static String CHANGE_ERROR_UNKNOW = "8";
  public static String CHANGE_ERROR_URL = "4";
  public static String CHANGE_START = "1";
  public static String COMMON_APPLICATION = "COMMON_APPLICATION";
  public static String COMMON_BIZ = "COMMON_BIZ";
  public static String COMMON_NET = "COMMON_NET";
  public static String COMMON_OPEN_COUNT = "COMMON_OPEN_COUNT";
  public static String COMMON_OPERATION_VERSION = "COMMON_OPERATION_VERSION";
  public static String COMMON_PAGE_NAME = "COMMON_PAGE_NAME";
  public static String COMMON_PHONE_TYPE = "COMMON_PHONE_TYPE";
  public static String COMMON_PLATFORM = "COMMON_PLATFORM";
  public static String COMMON_QQ_VERSION = "COMMON_QQ_VERSION";
  public static String COMMON_RELEASE = "COMMON_RELEASE";
  public static String COMMON_UIN = "COMMON_UIN";
  public static String COMMON_VIOLA_JSON = "COMMON_VIOLA_JSON";
  public static String HTTP_DATA_LENGTH = "HTTP_DATA_LENGTH";
  public static String HTTP_TIME = "HTTP_TIME";
  public static String JS_END = "2";
  public static String JS_ERROR_AFTER_RENDER = "JS_ERROR_AFTER_RENDER";
  public static String JS_ERROR_BEFORE_RENDER = "JS_ERROR_BEFORE_RENDER";
  public static String JS_START = "1";
  public static String KEY_BIZ = "KEY_BIZ";
  public static String KEY_CHANGE = "KEY_CHANGE";
  public static String KEY_FRAME_PAGE = "KEY_FRAME_PAGE";
  public static String KEY_MAIN = "KEY_MAIN";
  public static final String KEY_NV_PROCESS = "KEY_NV_PROCESS";
  public static String KEY_PAGE_PROCESS = "KEY_PAGE_PROCESS";
  public static String KEY_RENDER_JS = "KEY_RENDER_JS";
  public static String KEY_SO = "KEY_SO";
  public static String LIST_KANDIAN_VIOLA = "list_kandian_viola";
  public static String MAIN_END_EXIT = "6";
  public static String MAIN_END_EXIT_CACHE = "7";
  public static String MAIN_END_NET = "5";
  public static String MAIN_END_OFFLINE = "4";
  public static String MAIN_ERROR_NET = "3";
  public static String MAIN_ERROR_OFFLINE = "2";
  public static String MAIN_START = "1";
  public static String MEMORY_PAGE = "MEMORY_PAGE";
  public static String MEMORY_RENDER = "MEMORY_RENDER";
  public static String MEMORY_RENDER_BEFORE = "MEMORY_RENDER_BEFORE";
  public static String PAGE_ERROR_BIZ_JS = "5";
  public static String PAGE_ERROR_CHANGE_CGI = "7";
  public static String PAGE_ERROR_MAIN_JS = "3";
  public static String PAGE_ERROR_NOT_RECEIVE_ORDER = "10";
  public static String PAGE_ERROR_SDK = "4";
  public static String PAGE_ERROR_SO = "2";
  public static String PAGE_ERROR_UNKNOW_CRASH = "9";
  public static String PAGE_OPEN_END = "6";
  public static String SO_END_EXIT = "7";
  public static String SO_END_NET = "6";
  public static String SO_END_OFFLINE = "5";
  public static String SO_ERROR_NET = "3";
  public static String SO_ERROR_OFFLINE = "2";
  public static String SO_ERROR_UNZIP = "4";
  public static String SO_START = "1";
  public static String TIME_APPLY_LAYPUTANDEVENT = "TIME_APPLY_LAYPUTANDEVENT";
  public static String TIME_BIND_DATA = "TIME_BIND_DATA";
  public static String TIME_BIZ_JS_NET = "TIME_BIZ_JS_NET";
  public static String TIME_BIZ_JS_OFFLINE = "TIME_BIZ_JS_OFFLINE";
  public static String TIME_COMPONENT_TREE = "TIME_COMPONENT_TREE";
  public static String TIME_CREATE_VIEW = "TIME_CREATE_VIEW";
  public static String TIME_DOM_TREE = "TIME_DOM_TREE";
  public static String TIME_LAYOUT = "TIME_LAYOUT";
  public static String TIME_MAIN_JS_NET = "TIME_MAIN_JS_NET";
  public static String TIME_MAIN_JS_OFFLINE = "TIME_MAIN_JS_OFFLINE";
  public static String TIME_NATIVE_VUE = "TIME_NATIVE_VUE";
  public static String TIME_PAGE = "TIME_PAGE";
  public static String TIME_RENDER_JS = "TIME_RENDER_JS";
  public static String TIME_REVEIVE_ORDER = "TIME_REVEIVE_ORDER";
  public static String TIME_SDK_INIT = "TIME_SDK_INIT";
  public static String TIME_SDK_MAIN = "TIME_SDK_MAIN";
  public static String TIME_SO = "TIME_SO";
  public static boolean debugable = false;
  public static Application sApplication;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.ViolaEnvironment
 * JD-Core Version:    0.7.0.1
 */