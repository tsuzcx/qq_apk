package com.tencent.thumbplayer.api;

public class TPPlayerMsg$TPMediaCodecInfo
{
  public static int TP_DEC_MEDIA_TYPE_AUDIO = 1;
  public static int TP_DEC_MEDIA_TYPE_UNKNOWN;
  public static int TP_DEC_MEDIA_TYPE_VIDEO;
  public static int TP_INFO_MEDIA_CODEC_EXCEPTION;
  public static int TP_INFO_MEDIA_CODEC_READY;
  public static int TP_INFO_UNKNOWN = -1;
  public int infoType;
  public int mediaType;
  public String msg;
  
  static
  {
    TP_INFO_MEDIA_CODEC_READY = 0;
    TP_INFO_MEDIA_CODEC_EXCEPTION = 1;
    TP_DEC_MEDIA_TYPE_UNKNOWN = -1;
    TP_DEC_MEDIA_TYPE_VIDEO = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo
 * JD-Core Version:    0.7.0.1
 */