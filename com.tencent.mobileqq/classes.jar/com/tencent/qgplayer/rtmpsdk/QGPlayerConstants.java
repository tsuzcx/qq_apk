package com.tencent.qgplayer.rtmpsdk;

public abstract interface QGPlayerConstants
{
  public static final String ADJUST_CACHE_TIME_NEW = "ADJUST_CACHE_TIME_NEW";
  public static final String ADJUST_CACHE_TIME_OLD = "ADJUST_CACHE_TIME_OLD";
  public static final String EVENT_DESCRIPTION = "event_description";
  public static final String EVENT_PARAM1 = "event_param1";
  public static final String EVENT_PARAM2 = "event_param2";
  public static final String EVENT_TIME = "event_time";
  public static final int INIT_VIDEO_HEIGHT = 540;
  public static final int INIT_VIDEO_WIDTH = 960;
  public static final int LOG_LEVEL_DEBUG = 1;
  public static final int LOG_LEVEL_ERROR = 4;
  public static final int LOG_LEVEL_INFO = 3;
  public static final int LOG_LEVEL_WARN = 2;
  public static final int PLAYER_STATUS_DECODE_AUDIO_ERROR = 7;
  public static final int PLAYER_STATUS_DECODE_H264_ERROR = 5;
  public static final int PLAYER_STATUS_DECODE_H265_ERROR = 4;
  public static final int PLAYER_STATUS_DEMUEX_ERROR = 3;
  public static final int PLAYER_STATUS_ERROR = 6;
  public static final String PLAYER_STATUS_ERROR_INFO = "player_status_error_info";
  public static final String PLAYER_STATUS_ERROR_TYPE = "player_status_error_type";
  public static final int PLAYER_STATUS_IDLE = 0;
  public static final int PLAYER_STATUS_NETWORK_ERROR = 1;
  public static final int PLAYER_STATUS_NOT_ERROR = 0;
  public static final int PLAYER_STATUS_PAUSED = 5;
  public static final int PLAYER_STATUS_PLAY_BACK_COMPLETED = 3;
  public static final int PLAYER_STATUS_PLAY_ERROR = 6;
  public static final int PLAYER_STATUS_PREPARED = 1;
  public static final int PLAYER_STATUS_RELEASED = 7;
  public static final int PLAYER_STATUS_STARTED = 2;
  public static final int PLAYER_STATUS_STOPPED = 4;
  public static final int PLAYER_STATUS_URL_ERROR = 2;
  public static final int PLAYER_VALUE_TYPE_ENCRYPT_KEY = 1;
  public static final int PLAY_ERROR_HW_ACCELERATION_FAIL_AUDIO_AAC = 2303;
  public static final int PLAY_ERROR_HW_ACCELERATION_FAIL_VIDEO_H264 = 2301;
  public static final int PLAY_ERROR_HW_ACCELERATION_FAIL_VIDEO_H265 = 2302;
  public static final int PLAY_ERROR_SOFT_DECODER_FAIL_VIDEO_H264 = 2304;
  public static final int PLAY_ERROR_SOFT_DECODER_FAIL_VIDEO_H265 = 2305;
  public static final int PLAY_EVT_AUDIO_DECODE_HW_SWITCH_SW = 2002;
  public static final int PLAY_EVT_DOWNLOAD_CONNECTED = 1002;
  public static final int PLAY_EVT_DOWNLOAD_EOF = 1003;
  public static final int PLAY_EVT_DOWNLOAD_ITERATION = 1004;
  public static final int PLAY_EVT_DOWNLOAD_STOPED = 1001;
  public static final int PLAY_EVT_JITTER_BUFFER_ADJUST_CACHE = 5004;
  public static final int PLAY_EVT_JITTER_BUFFER_AUDIO_LOADING = 5001;
  public static final int PLAY_EVT_JITTER_BUFFER_AUDIO_PLAY = 5003;
  public static final int PLAY_EVT_JITTER_BUFFER_AVSYNC_DISABLE = 5005;
  public static final int PLAY_EVT_JITTER_BUFFER_AVSYNC_ENABLE = 5006;
  public static final int PLAY_EVT_JITTER_BUFFER_RCV_IFRAME = 5002;
  public static final int PLAY_EVT_PLAYER_SEEKED = 6001;
  public static final int PLAY_EVT_PLAYER_STREAMS_INFO = 6007;
  public static final int PLAY_EVT_PLAYER_UPDATE_BUFFERED_TIME = 6008;
  public static final int PLAY_EVT_PLAYER_UPDATE_TIME = 6003;
  public static final int PLAY_EVT_RENDER_QUEUE_EMPTY = 4001;
  public static final int PLAY_EVT_RENDER_VIDEO_RESOLUTION_CHANGED = 4003;
  public static final int PLAY_EVT_VIDEO_DECODE_HW_SWITCH_SW = 2001;
  public static final int PLAY_EVT_VIDEO_FRAME_EXTRA_DATA = 6006;
  public static final int PLAY_LIBHEVC_SWITCH_AVC = 7000;
  public static final int RENDER_MODE_ADJUST_RESOLUTION = 1;
  public static final int RENDER_MODE_FULL_FILL_SCREEN = 0;
  public static final String RENDER_NEW_CLARIFY_INDEX = "render_new_clarify_index";
  public static final String UPDATE_TIME_DURATION = "update_time_duration";
  public static final String UPDATE_TIME_PROGRESS = "update_time_progress";
  public static final String VIDEO_FRAME_EXTRA_DATA = "video_frame_extra_data";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.QGPlayerConstants
 * JD-Core Version:    0.7.0.1
 */