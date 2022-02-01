package com.tencent.thumbplayer.core.common;

public class TPDecoderType
{
  public static int TP_AUDIO_DECODER_DOLBY = 4;
  public static int TP_AUDIO_DECODER_FFMPEG = 0;
  public static int TP_AUDIO_DECODER_MEDIACODEC = 0;
  public static final String TP_CODEC_MIMETYPE_AVC = "video/avc";
  public static final String TP_CODEC_MIMETYPE_DOLBYVISION = "video/dolby-vision";
  public static final String TP_CODEC_MIMETYPE_HEVC = "video/hevc";
  public static final String TP_CODEC_MIMETYPE_VP9 = "video/x-vnd.on2.vp9";
  public static int TP_DECODER_UNKNOWN = -1;
  public static int TP_VIDEO_DECODER_FFMPEG = 101;
  public static int TP_VIDEO_DECODER_MEDIACODEC = 102;
  
  static
  {
    TP_AUDIO_DECODER_FFMPEG = 1;
    TP_AUDIO_DECODER_MEDIACODEC = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPDecoderType
 * JD-Core Version:    0.7.0.1
 */