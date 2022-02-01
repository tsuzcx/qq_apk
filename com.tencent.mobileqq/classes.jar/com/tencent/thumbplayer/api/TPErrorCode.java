package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapErrorType;

public class TPErrorCode
{
  public static final int TP_ERROR_CODE_LOGIC = 13000102;
  public static final int TP_ERROR_CODE_UNKONW = 13000101;
  @TPNativeKeyMap.MapErrorType(1000)
  public static final int TP_ERROR_OK = 1000;
  public static final int TP_ERROR_QQ_VIDEO_EXPIRED = 14011001;
  @TPNativeKeyMap.MapErrorType(1210)
  public static final int TP_ERROR_TYPE_DECODER_AUDIO_NOT_SUPPORT = 1210;
  @TPNativeKeyMap.MapErrorType(1211)
  public static final int TP_ERROR_TYPE_DECODER_AUDIO_STREAM = 1211;
  @TPNativeKeyMap.MapErrorType(1200)
  public static final int TP_ERROR_TYPE_DECODER_OTHERS = 1200;
  @TPNativeKeyMap.MapErrorType(1230)
  public static final int TP_ERROR_TYPE_DECODER_SUBTITLE_NOT_SUPPORT = 1230;
  @TPNativeKeyMap.MapErrorType(1231)
  public static final int TP_ERROR_TYPE_DECODER_SUBTITLE_STREAM = 1231;
  @TPNativeKeyMap.MapErrorType(1220)
  public static final int TP_ERROR_TYPE_DECODER_VIDEO_NOT_SUPPORT = 1220;
  @TPNativeKeyMap.MapErrorType(1221)
  public static final int TP_ERROR_TYPE_DECODER_VIDEO_STREAM = 1221;
  @TPNativeKeyMap.MapErrorType(1103)
  public static final int TP_ERROR_TYPE_DEMUXER_BUFFERING_TIMEOUT = 1103;
  @TPNativeKeyMap.MapErrorType(1101)
  public static final int TP_ERROR_TYPE_DEMUXER_NETWORK = 1101;
  @TPNativeKeyMap.MapErrorType(1100)
  public static final int TP_ERROR_TYPE_DEMUXER_OTHERS = 1100;
  @TPNativeKeyMap.MapErrorType(1102)
  public static final int TP_ERROR_TYPE_DEMUXER_STREAM = 1102;
  public static final int TP_ERROR_TYPE_DOWNLOAD_PROXY = 4000;
  @TPNativeKeyMap.MapErrorType(1500)
  public static final int TP_ERROR_TYPE_PROCESS_AUDIO_OTHERS = 1500;
  @TPNativeKeyMap.MapErrorType(1600)
  public static final int TP_ERROR_TYPE_PROCESS_VIDEO_OTHERS = 1600;
  @TPNativeKeyMap.MapErrorType(1300)
  public static final int TP_ERROR_TYPE_RENDERER_OTHERS = 1300;
  public static final int TP_ERROR_TYPE_SYSTEM_PLAYER_NETWORK = 2001;
  public static final int TP_ERROR_TYPE_SYSTEM_PLAYER_OTHERS = 2000;
  @TPNativeKeyMap.MapErrorType(1001)
  public static final int TP_ERROR_TYPE_THUMBPLAYER_GENERAL = 1001;
  public static final int TP_ERROR_TYPE_TPPLAYER_GENERAL = 3000;
  public static final int TP_ERROR_TYPE_UNKONW = 999;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPErrorCode
 * JD-Core Version:    0.7.0.1
 */