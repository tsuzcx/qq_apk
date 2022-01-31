package com.tencent.qqlive.tvkplayer.playerwrapper.player;

public class TVKPlayerCommonEnum
{
  public static final int LIVE_PLAY_BACK_TO_NORMAL_KEY = -1;
  public static final String[] LIVE_STREAM_HLS_TAG = { "#EXT-QQHLS-AD", "#EXT-X-PROGRAM-DATE-TIME" };
  public static int PLAYER_AUDIO_DECODER_FFMPEG = 0;
  public static int PLAYER_AUDIO_DECODER_MEDIACODEC = 0;
  public static final int PLAYER_AV_FORMAT_LIVE_FLV = 1;
  public static final int PLAYER_AV_FORMAT_LIVE_HLS = 2;
  public static final int PLAYER_AV_FORMAT_UNKNOW = 0;
  public static final int PLAYER_AV_FORMAT_VOD_20MIN_MP4 = 8;
  public static final int PLAYER_AV_FORMAT_VOD_5MIN_MP4 = 7;
  public static final int PLAYER_AV_FORMAT_VOD_AD_MP4 = 99;
  public static final int PLAYER_AV_FORMAT_VOD_COMPOSITION = 9;
  public static final int PLAYER_AV_FORMAT_VOD_HLS = 5;
  public static final int PLAYER_AV_FORMAT_VOD_RECORD = 10;
  public static final int PLAYER_AV_FORMAT_VOD_WHOLE_MP4 = 6;
  public static final String PLAYER_CODEC_MIMETYPE_AVC = "video/avc";
  public static final String PLAYER_CODEC_MIMETYPE_HEVC = "video/hevc";
  public static int PLAYER_DECODER_UNKNOWN = 0;
  public static final int PLAYER_DESC_ID_ANDROID_PLAYER = 1;
  public static final int PLAYER_DESC_ID_THUMB_PLAYER = 2;
  public static final int PLAYER_DESC_ID_UNKNOWN = 0;
  public static int PLAYER_VIDEO_DECODER_FFMPEG;
  public static int PLAYER_VIDEO_DECODER_MEDIACODEC;
  
  static
  {
    PLAYER_AUDIO_DECODER_FFMPEG = 1;
    PLAYER_AUDIO_DECODER_MEDIACODEC = 2;
    PLAYER_VIDEO_DECODER_FFMPEG = 101;
    PLAYER_VIDEO_DECODER_MEDIACODEC = 102;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKPlayerCommonEnum
 * JD-Core Version:    0.7.0.1
 */