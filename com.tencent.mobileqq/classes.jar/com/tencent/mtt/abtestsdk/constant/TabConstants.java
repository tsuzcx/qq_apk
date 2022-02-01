package com.tencent.mtt.abtestsdk.constant;

public class TabConstants
{
  public static final String CACHE_EXP_DATA_KEY = "exp_data";
  public static final String CACHE_EXP_STRATEGY_KEY = "exp_strategy";
  public static final String CACHE_FEATURE_DATA_KEY = "feature_data";
  public static final String CACHE_FEATURE_STRATEGY_KEY = "feature_strategy";
  public static final String CACHE_REMOTE_CONFIG_DATA_KEY = "remote_config_data";
  public static final int CODE_FEATURE_INFO_EMPTY = 1;
  public static final int CODE_FEATURE_INVALID_APP_ID = 4;
  public static final int CODE_FEATURE_INVALID_REQUEST = 3;
  public static final int CODE_FEATURE_NOT_EXIST = 2;
  public static final int CODE_FEATURE_SUCCESS = 0;
  public static final int DEFAULT_CONFIG_REFRESH_TIME = 1800;
  public static final int DEFAULT_EXP_REFRESH_TIME = 30;
  public static final int DEFAULT_FEATURE_REFRESH_TIME = 30;
  public static final String DEV_FOR_EXP_URL = "https://tdata.ab.qq.com/wabt/get_gray_policy";
  public static final String DEV_FOR_FEATURE_URL = "https://tdata.ab.qq.com/wabt/get_feature_policy";
  public static final String DEV_FOR_QQ_EXP_URL = "https://tqqdata.ab.qq.com/wabt/get_gray_policy";
  public static final String DEV_FOR_QQ_FEATURE_URL = "https://tqqdata.ab.qq.com/wabt/get_feature_policy";
  public static final String EXP_DEFAULT_ASSIGNMENT = "default";
  public static final String EXP_DEFAULT_BUCKET = "0";
  public static final String EXP_DEFAULT_GRAYID = "-1";
  public static final String EXP_DEFAULT_LAYERCODE = "default";
  public static final String EXP_DEFAULT_PERCENTAGE = "0";
  public static final String FEATURE_DEFAULT_GRAYID = "-1";
  public static final String FEATURE_DEFAULT_KEY = "default";
  public static final String FEATURE_DEFAULT_LIFE_TYPE = "1";
  public static final String FEATURE_DEFAULT_REPORT_TYPE = "atta";
  public static final String FEATURE_DEFAULT_STATUS = "0";
  public static final String FORMAL_FOR_EXP_URL = "https://data.ab.qq.com/wabt/get_gray_policy";
  public static final String FORMAL_FOR_FEATURE_URL = "https://data.ab.qq.com/wabt/get_feature_policy";
  public static final String FORMAL_FOR_QQ_EXP_URL = "https://qqdata.ab.qq.com/wabt/get_gray_policy";
  public static final String FORMAL_FOR_QQ_FEATURE_URL = "https://qqdata.ab.qq.com/wabt/get_feature_policy";
  public static final int GET_CONFIGS_FAILED = 5;
  public static final int GET_CONFIGS_SUCCESS = 4;
  public static final int GET_FEATURES_FAILED = 3;
  public static final int GET_FEATURES_SUCCESS = 2;
  public static final String HTTP_FOR_CONFIG_URL = "https://config.ab.qq.com/trpc.tab.rconfigserver.RemoteConfigServer/GetRemoteConfig";
  public static final String HTTP_FOR_DEV_CONFIG_URL = "http://configserver.tab.sparta.html5.qq.com/trpc.tab.rconfigserver.RemoteConfigServer/GetRemoteConfig";
  public static final String JSON_STRING_ENCODING = "UTF-8";
  public static final String KEY_CONFIG_CODE = "status";
  public static final String KEY_CONFIG_DATA = "data";
  public static final String KEY_CONFIG_DATA_VALUE = "value";
  public static final String KEY_CONFIG_VERSION = "version";
  public static final String KEY_EXPERIMENTS_CODE = "code";
  public static final String KEY_EXPERIMENTS_DATA = "data";
  public static final String KEY_EXPERIMENTS_STRATEGY = "strategy";
  public static final String KEY_EXP_ENCRYPT_DATA = "data";
  public static final String KEY_FEATURES_CODE = "code";
  public static final String KEY_FEATURES_DATA = "data";
  public static final String KEY_FEATURES_STRATEGY = "featureStrategy";
  public static final String KEY_OF_BUNDLE_APP_NAME = "bundle_name";
  public static final String KEY_OF_BUNDLE_PKG_NAME = "bundle_package_name";
  public static final String KEY_OF_BUNDLE_VERSION = "bundle_version";
  public static final String KEY_OF_CITY = "city";
  public static final String KEY_OF_DEVICE_BRAND = "device_brand";
  public static final String KEY_OF_DEVICE_HEIGHT = "device_height";
  public static final String KEY_OF_DEVICE_VERSION = "device_version";
  public static final String KEY_OF_DEVICE_WIDTH = "device_width";
  public static final String KEY_OF_ENV = "ENV";
  public static final String KEY_OF_GUID = "guid";
  public static final String KEY_OF_IS_DISK_CACHE = "disk_cache";
  public static final String KEY_OF_LANGUAGE = "language";
  public static final String KEY_OF_OS_VERSION = "os_version";
  public static final String KEY_OF_PROVINCE = "province";
  public static final String KEY_OF_SEX = "sex";
  public static final String MOBILE_QQ_TAB_APP_ID = "1505";
  public static final int ON_EXPERIMENTS_FAILED = 1;
  public static final int ON_EXPERIMENTS_SUCCESS = 0;
  public static final String POST_REQUEST_KEY_APP_ID = "appid";
  public static final String POST_REQUEST_KEY_APP_KEY = "appkey";
  public static final String POST_REQUEST_KEY_APP_PROFILES = "profiles";
  public static final String POST_REQUEST_KEY_COMPRESS_TYPE = "compress_type";
  public static final String POST_REQUEST_KEY_CONFIG_APP_ID = "app_id";
  public static final String POST_REQUEST_KEY_CONFIG_APP_KEY = "app_key";
  public static final String POST_REQUEST_KEY_CONFIG_GUID = "guid";
  public static final String POST_REQUEST_KEY_CONFIG_KEYS = "config_keys";
  public static final String POST_REQUEST_KEY_CONFIG_VERSION = "config_version";
  public static final String POST_REQUEST_KEY_EXP_LAYERCODE = "layerCodes";
  public static final String POST_REQUEST_KEY_EXP_NAME = "expName";
  public static final String POST_REQUEST_KEY_FEATURE_KEY = "featureKey";
  public static final String POST_REQUEST_KEY_GUID = "guid";
  public static final String POST_REQUEST_KEY_LANGUAGE = "language";
  public static final String POST_REQUEST_KEY_PLATFORM = "platform";
  public static final String POST_REQUEST_KEY_SCENEID = "sceneId";
  public static final String POST_REQUEST_KEY_SDK_VERSION = "sdk_version";
  public static final int START_UPDATE_EXP_DATA = 0;
  public static final int START_UPDATE_FEATURE_DATA = 2;
  public static final int START_UPDATE_REMOTE_CONFIG_DATA = 4;
  public static final int STOP_UPDATE_EXP_DATA = 1;
  public static final int STOP_UPDATE_FEATURE_DATA = 3;
  public static final int STOP_UPDATE_REMOTE_CONFIG_DATA = 5;
  public static final String TAB_PUBLIC_PREFIX = "Tab";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.constant.TabConstants
 * JD-Core Version:    0.7.0.1
 */