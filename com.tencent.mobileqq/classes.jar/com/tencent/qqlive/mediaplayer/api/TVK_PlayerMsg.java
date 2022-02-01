package com.tencent.qqlive.mediaplayer.api;

public class TVK_PlayerMsg
{
  public static final int DLNA_ERROR_DEVICE_UNUSED = 304;
  public static final int DLNA_ERROR_DISCONNECTED = 302;
  public static final int DLNA_ERROR_FETCH_URL = 301;
  public static final int DLNA_ERROR_ILLEGAL_ARGUMENT = 305;
  public static final int DLNA_ERROR_NO_DEVICE = 300;
  public static final int DLNA_ERROR_SET_AV_URI = 303;
  public static final int DLNA_STATUS_ERROR = 8;
  public static final int DLNA_STATUS_IDLE = 0;
  public static final int DLNA_STATUS_NO_MEDIA_PRESENT = 5;
  public static final int DLNA_STATUS_PAUSED = 2;
  public static final int DLNA_STATUS_PLAYING = 3;
  public static final int DLNA_STATUS_PREPARED = 7;
  public static final int DLNA_STATUS_PREPARING = 6;
  public static final int DLNA_STATUS_STOPPED = 1;
  public static final int DLNA_STATUS_TRANSITIONING = 4;
  public static final int MODEL_CGI_GETKEY_ERR = 102;
  public static final int MODEL_CGI_GETPROGINFO_ERR = 104;
  public static final int MODEL_CGI_GETVINFO_ERR = 101;
  public static final int MODEL_CGI_OPEN_QQ_ERR = 105;
  public static final int MODEL_DOWNLOAD_ERR = 230;
  public static final int MODEL_DRM_ERR = 400;
  public static final int MODEL_JAVA_LOGIC_ERR = 123;
  public static final int MODEL_PLAYER_CORE_ERR = 122;
  public static final String PLAYER_CHOICE = "player_choice";
  public static final String PLAYER_CHOICE_AUTO = "auto";
  public static final String PLAYER_CHOICE_SELF = "self";
  public static final String PLAYER_CHOICE_SELF_SOFT = "self_soft";
  public static final String PLAYER_CHOICE_SYSTEM = "system";
  public static final int PLAYER_ERR_AVSRC_ERR = 202;
  public static final int PLAYER_ERR_LOGIC_AUTHORIZED_FAIL = 105;
  public static final int PLAYER_ERR_LOGIC_CREATE_FAIL = 104;
  public static final int PLAYER_ERR_LOGIC_DEVICE_UNSUPPORT = 106;
  public static final int PLAYER_ERR_LOGIC_LIVECGI_ERR = 103;
  public static final int PLAYER_ERR_LOGIC_PARAM_ERR = 101;
  public static final int PLAYER_ERR_LOGIC_PROXY_LOAD_FAIL = 108;
  public static final int PLAYER_ERR_LOGIC_STATE_ERR = 102;
  public static final int PLAYER_ERR_LOGIC_UNKNOW = 100;
  public static final int PLAYER_ERR_LOGIC_URL_ISNULL = 107;
  public static final int PLAYER_ERR_NETWORK_ERR = 204;
  public static final int PLAYER_ERR_OPEN_FAILED = 201;
  public static final int PLAYER_ERR_UNKNOW = 200;
  public static final int PLAYER_ERR_UNSUPPORTED = 203;
  public static final int PLAYER_FORCE_TYPE_NONE = 0;
  public static final int PLAYER_FORCE_TYPE_SELF = 2;
  public static final int PLAYER_FORCE_TYPE_SYS = 1;
  public static final int PLAYER_INFO_CHANGE_HW_BACKUP_URL = 41;
  public static final int PLAYER_INFO_DECODER_BLOCK = 28;
  public static final int PLAYER_INFO_DOLBY_DECODE_FAIL = 27;
  public static final int PLAYER_INFO_ENDOF_BUFFERING = 22;
  public static final int PLAYER_INFO_END_GET_VINFO = 34;
  public static final int PLAYER_INFO_EXTRACT_FRAME_ERROR = 43;
  public static final int PLAYER_INFO_FETCH_NEXT_VIDEO_INFO = 36;
  public static final int PLAYER_INFO_HW_DECODE_FAILED = 39;
  public static final int PLAYER_INFO_LOOP_AD_START = 37;
  public static final int PLAYER_INFO_LOOP_VIDEO_START = 38;
  public static final int PLAYER_INFO_NEXT_NET_VINFO = 35;
  public static final int PLAYER_INFO_OFFLINE_NOMORE_CACHE = 35;
  public static final int PLAYER_INFO_PERFORMANCE_REPORT = 42;
  public static final int PLAYER_INFO_PLAYER_TYPE = 31;
  public static final int PLAYER_INFO_PLAYER_TYPE_SELF = 2;
  public static final int PLAYER_INFO_PLAYER_TYPE_SYSTEM = 1;
  public static final int PLAYER_INFO_PRE_AD_PLAYER_TYPE = 32;
  public static final int PLAYER_INFO_RETRY_PLAYER = 29;
  public static final int PLAYER_INFO_RETRY_URL = 30;
  public static final int PLAYER_INFO_RETURN_VIDEO_DURATION = 26;
  public static final int PLAYER_INFO_SKIPAD_FOR_VIPUSER = 25;
  public static final int PLAYER_INFO_SKIP_ONE_FRAME = 40;
  public static final int PLAYER_INFO_START_BUFFERING = 21;
  public static final int PLAYER_INFO_START_GET_VINFO = 33;
  public static final int PLAYER_INFO_START_RENDERING = 23;
  public static final int PLAYER_INFO_SUCC_SET_DECODER_MODE = 24;
  public static final int PLAYER_INFO_UNKNOW = 20;
  public static final int PLAYER_ORIGINAL_FULLSCREEN = 2;
  public static final int PLAYER_ORIGINAL_RATIO = 0;
  public static final int PLAYER_RETRY_TYPE_FIRST = 1;
  public static final int PLAYER_RETRY_TYPE_LAST = 3;
  public static final int PLAYER_RETRY_TYPE_NONE = 0;
  public static final int PLAYER_RETRY_TYPE_THEN = 2;
  public static final int PLAYER_SCALE_BOTH_FULLSCREEN = 1;
  public static final int PLAYER_SCALE_ORIGINAL_FULLSCREEN = 2;
  public static final int PLAYER_SCALE_ORIGINAL_RATIO = 0;
  public static final int PLAYER_SCALE_ORIGINAL_RATIO_SQUARE = 6;
  public static final int PLAYER_SCALE_ORIGINAL_TRANSLATE = 5;
  public static final int PLAYER_SCALE_X_FULLSCREEN = 3;
  public static final int PLAYER_SCALE_Y_FULLSCREEN = 4;
  public static final int PLAYER_TYPE_DLNA_LIVE = 6;
  public static final int PLAYER_TYPE_DLNA_VOD = 7;
  public static final int PLAYER_TYPE_EXTERNAL_URL = 5;
  public static final int PLAYER_TYPE_LOCAL_FILE = 4;
  public static final int PLAYER_TYPE_LOOP_VOD = 8;
  public static final int PLAYER_TYPE_MIN_BUF_LIVE = 9;
  public static final int PLAYER_TYPE_MIN_BUF_VOD = 8;
  public static final int PLAYER_TYPE_OFFLINE = 3;
  public static final int PLAYER_TYPE_ONLINE_LIVE = 1;
  public static final int PLAYER_TYPE_ONLINE_VOD = 2;
  public static final int PLAYER_VIDEO_FULL_CACHED = 2;
  public static final int PLAYER_VIDEO_NO_CACHED = 0;
  public static final int PLAYER_VIDEO_PARTIAL_CACHED = 1;
  public static final int PRELOAD_CGI_ERROR = 1001;
  public static final int PRELOAD_DOWNLOAD_ERROR = 1002;
  public static final int PRELOAD_OTHERS = 1003;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_PlayerMsg
 * JD-Core Version:    0.7.0.1
 */