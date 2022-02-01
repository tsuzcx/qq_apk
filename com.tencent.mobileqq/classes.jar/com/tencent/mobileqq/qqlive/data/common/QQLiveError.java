package com.tencent.mobileqq.qqlive.data.common;

public final class QQLiveError
{
  public static final int ANCHOR_ENTER_ERR = 6250;
  public static final int ANCHOR_FACE_AUTH_ERR = 6210;
  public static final int ANCHOR_FACE_AUTH_TIMEOUT = 6211;
  public static final int ANCHOR_HEART_ERROR = 6105;
  public static final int ANCHOR_INIT_LOGIN_ERR = 6100;
  public static final int ANCHOR_INIT_TRTC_ERR = 6101;
  public static final int ANCHOR_INIT_WAIT_SCREEN_ERR = 6103;
  public static final int ANCHOR_INIT_WAIT_SCREEN_TIMEOUT = 6104;
  public static final int ANCHOR_ISOLATE_CLOSE_ARGUMENT_INVALID = 6401;
  public static final int ANCHOR_ISOLATE_CLOSE_SDK_NOT_READY = 6400;
  public static final int ANCHOR_PERMISSION_DENIED = 6102;
  public static final int ANCHOR_PLAYER_ERR = 6300;
  public static final int ANCHOR_PREPARE_ERR = 6200;
  public static final int ANCHOR_PUBLISH_ERR = 6260;
  public static final int ANCHOR_PULL_URL_ERR = 6231;
  public static final int ANCHOR_PULL_URL_STYLE_ERR = 6230;
  public static final int ANCHOR_PUSH_URL_ERR = 6221;
  public static final int ANCHOR_PUSH_URL_STYLE_ERR = 6220;
  public static final int ANCHOR_SET_ERR = 6240;
  public static final int ANCHOR_STATE_ERR = 6000;
  public static final int ANCHOR_THIRD_PUSH_CHECK_ERR = 6270;
  public static final int LIVE_URL_EMPTY = 5107;
  public static final int LOGIN_FAILED = 5105;
  public static final int LOGIN_INFO_INVALID = 9999;
  public static final int NOT_ENTER_ROOM = 5106;
  private static final int RTC_BASE_ERROR = -2000000;
  public static final int RTC_ERR_AUDIO_ENCODE_FAIL = -1304;
  public static final int RTC_ERR_BUFFER_TYPE_UNSUPPORTED = -1328;
  public static final int RTC_ERR_CAMERA_OCCUPY = -1316;
  public static final int RTC_ERR_CAMERA_OPEN_FAIL = -1301;
  public static final int RTC_ERR_CAMERA_PREVIEW_FAIL = -1314;
  public static final int RTC_ERR_CAMERA_SET_PARAM_FAIL = -1315;
  public static final int RTC_ERR_CONNECT_OTHER_ROOM_AS_AUDIENCE = -3330;
  public static final int RTC_ERR_FAIL = -2001001;
  public static final int RTC_ERR_INVALID_ARGUMENT = -2001002;
  public static final int RTC_ERR_MIC_NOT_AUTHORIZED = -1317;
  public static final int RTC_ERR_MIC_OCCUPY = -1319;
  public static final int RTC_ERR_MIC_SET_PARAM_FAIL = -1318;
  public static final int RTC_ERR_MIC_START_FAIL = -1302;
  public static final int RTC_ERR_MIC_STOP_FAIL = -1320;
  public static final int RTC_ERR_OK = 0;
  public static final int RTC_ERR_PIXEL_FORMAT_UNSUPPORTED = -1327;
  public static final int RTC_ERR_ROOM_ENTER_FAIL = -3301;
  public static final int RTC_ERR_ROOM_ENTER_PARAM_NULL = -3316;
  public static final int RTC_ERR_ROOM_ID_INVALID = -3318;
  public static final int RTC_ERR_ROOM_REQUEST_CONN_ROOM_INVALID_PARAM = -3328;
  public static final int RTC_ERR_ROOM_REQUEST_CONN_ROOM_TIMEOUT = -3326;
  public static final int RTC_ERR_ROOM_REQUEST_DISCONN_ROOM_TIMEOUT = -3327;
  public static final int RTC_ERR_ROOM_REQUEST_ENTER_ROOM_TIMEOUT = -3308;
  public static final int RTC_ERR_ROOM_REQUEST_QUIT_ROOM_TIMEOUT = -3325;
  public static final int RTC_ERR_ROOM_SDK_APPID_INVALID = -3317;
  public static final int RTC_ERR_ROOM_USER_ID_INVALID = -3319;
  public static final int RTC_ERR_ROOM_USER_SIG_INVALID = -3320;
  public static final int RTC_ERR_SCREEN_CAPTURE_START_FAIL = -1308;
  public static final int RTC_ERR_SCREEN_CAPTURE_STOPPED = -7001;
  public static final int RTC_ERR_SCREEN_CAPTURE_UNSURPORT = -1309;
  public static final int RTC_ERR_SERVER_CENTER_ANOTHER_USER_PUSH_SUB_VIDEO = -102016;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_CANCEL_FAILED = -102045;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_CONNED_REACH_MAX_ROOM = -102047;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_CONNED_ROOM_NOT_EXIST = -102046;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_CONNED_USER_DELETED = -102049;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_CONNED_USER_FULL = -102050;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_CONNED_USER_NOT_EXIST = -102048;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_DECRYPT_SIG = -102037;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_FAILED = -102044;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_INVALID_SEQ = -102051;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_INVALID_SIG_TIME = -102040;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_NOT_CONNED = -102042;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_NOT_SUPPORT = -102031;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_NO_KEY = -102038;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_NO_SIG = -102036;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_PARSE_SIG = -102039;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_REACH_MAX_NUM = -102032;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_REACH_MAX_RETRY_TIMES = -102033;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_REQ = -102035;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_REQ_TIMEOUT = -102034;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_SIG_GROUPID = -102041;
  public static final int RTC_ERR_SERVER_CENTER_CONN_ROOM_USER_NOT_CONNED = -102043;
  public static final int RTC_ERR_SERVER_CENTER_NO_PRIVILEDGE_PUSH_SUB_VIDEO = -102015;
  public static final int RTC_ERR_SERVER_INFO_SERVICE_SUSPENDED = -100013;
  public static final int RTC_ERR_SPEAKER_SET_PARAM_FAIL = -1322;
  public static final int RTC_ERR_SPEAKER_START_FAIL = -1321;
  public static final int RTC_ERR_SPEAKER_STOP_FAIL = -1323;
  public static final int RTC_ERR_UNSUPPORTED_RESOLUTION = -1305;
  public static final int RTC_ERR_UNSUPPORTED_SAMPLERATE = -1306;
  public static final int RTC_ERR_VIDEO_ENCODE_FAIL = -1303;
  public static final int RTC_WARNING_AUDIO_FRAME_DECODE_FAIL = 2102;
  public static final int RTC_WARNING_AUDIO_RECORDING_WRITE_FAIL = 7001;
  public static final int RTC_WARNING_CAMERA_DEVICE_EMPTY = 1111;
  public static final int RTC_WARNING_CAMERA_NOT_AUTHORIZED = 1112;
  public static final int RTC_WARNING_HW_DECODER_START_FAIL = 2106;
  public static final int RTC_WARNING_HW_ENCODER_START_FAIL = 1103;
  public static final int RTC_WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE = 6001;
  public static final int RTC_WARNING_INSUFFICIENT_CAPTURE_FPS = 1108;
  public static final int RTC_WARNING_LIVE_STREAM_SERVER_RECONNECT = 2103;
  public static final int RTC_WARNING_MICROPHONE_DEVICE_ABNORMAL = 1204;
  public static final int RTC_WARNING_MICROPHONE_DEVICE_EMPTY = 1201;
  public static final int RTC_WARNING_MICROPHONE_NOT_AUTHORIZED = 1203;
  public static final int RTC_WARNING_NET_BUSY = 1101;
  public static final int RTC_WARNING_NO_STEAM_SOURCE_FAIL = 3010;
  public static final int RTC_WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL = 3009;
  public static final int RTC_WARNING_RECV_DATA_LAG = 2104;
  public static final int RTC_WARNING_REDUCE_CAPTURE_RESOLUTION = 1110;
  public static final int RTC_WARNING_ROOM_DISCONNECT = 5101;
  public static final int RTC_WARNING_ROOM_NET_BUSY = 5103;
  public static final int RTC_WARNING_ROOM_RECONNECT = 5102;
  public static final int RTC_WARNING_RTMP_DNS_FAIL = 3001;
  public static final int RTC_WARNING_RTMP_NO_DATA = 3008;
  public static final int RTC_WARNING_RTMP_READ_FAIL = 3007;
  public static final int RTC_WARNING_RTMP_READ_WRITE_FAIL = 3005;
  public static final int RTC_WARNING_RTMP_SERVER_BREAK_CONNECT = 3004;
  public static final int RTC_WARNING_RTMP_SERVER_RECONNECT = 1102;
  public static final int RTC_WARNING_RTMP_SEVER_CONN_FAIL = 3002;
  public static final int RTC_WARNING_RTMP_SHAKE_FAIL = 3003;
  public static final int RTC_WARNING_RTMP_WRITE_FAIL = 3006;
  public static final int RTC_WARNING_SPEAKER_DEVICE_ABNORMAL = 1205;
  public static final int RTC_WARNING_SPEAKER_DEVICE_EMPTY = 1202;
  public static final int RTC_WARNING_START_CAPTURE_IGNORED = 4000;
  public static final int RTC_WARNING_SW_DECODER_START_FAIL = 2109;
  public static final int RTC_WARNING_SW_ENCODER_START_FAIL = 1109;
  public static final int RTC_WARNING_VIDEO_DECODER_HW_TO_SW = 2108;
  public static final int RTC_WARNING_VIDEO_ENCODER_SW_TO_HW = 1107;
  public static final int RTC_WARNING_VIDEO_FRAME_DECODE_FAIL = 2101;
  public static final int RTC_WARNING_VIDEO_PLAY_LAG = 2105;
  public static final int RTC_WARNING_VIDEO_RENDER_FAIL = 2110;
  public static final int SSO_ERROR = 5108;
  public static final int UPLOAD_BITMAP_DOING = 6500;
  public static final int UPLOAD_BITMAP_FAILED = 6501;
  public static final int VIDEO_SDK_INIT_FAILED = 5104;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.common.QQLiveError
 * JD-Core Version:    0.7.0.1
 */