package com.tencent.ttpic.openapi.config;

public class MediaConfig
{
  public static int BPS_HIGH = 5242880;
  public static int BPS_LOW = 5242880;
  public static int BPS_MEDIUM = 5242880;
  public static int GIF_OUTPUT_TEX_HEIGHT = 720;
  public static int GIF_OUTPUT_TEX_WIDTH = 720;
  public static int GIF_OUTPUT_WATERMARK_HEIGHT = 50;
  public static int GIF_OUTPUT_WATERMARK_WIDTH = 180;
  public static float GIF_PLAY_RATE = 0.5F;
  public static long GIF_SAMPLE_TIME_MS = 200L;
  public static int INTERMIDIATE_IMAGE_WIDTH_HIGH = 1080;
  public static int INTERMIDIATE_IMAGE_WIDTH_LOW = 540;
  public static int INTERMIDIATE_IMAGE_WIDTH_MEDIUM = 720;
  public static int MS_VIDEO_FRAME_RATE = 25;
  public static final String VIDEO_AAC_FILE_POSTFIX = ".m4a";
  public static int VIDEO_FRAME_RATE = 25;
  public static int VIDEO_IMAGE_HEIGHT = 640;
  public static int VIDEO_IMAGE_WIDTH = 480;
  public static int VIDEO_OUTPUT_HEIGHT = 960;
  public static int VIDEO_OUTPUT_HEIGHT_LONG = 1280;
  public static int VIDEO_OUTPUT_HEIGHT_SHORT = 720;
  public static int VIDEO_OUTPUT_WATERMARK_HEIGHT = 55;
  public static int VIDEO_OUTPUT_WATERMARK_WIDTH = 140;
  public static int VIDEO_OUTPUT_WIDTH = 720;
  
  public static int getDowngradeWidth(int paramInt)
  {
    if (paramInt <= 0) {
      return MediaConfig.ENCODE_SIZE.HIGH.width;
    }
    if (paramInt == MediaConfig.ENCODE_SIZE.HIGH.width) {
      return MediaConfig.ENCODE_SIZE.MEDIUM.width;
    }
    if (paramInt == MediaConfig.ENCODE_SIZE.MEDIUM.width) {
      return MediaConfig.ENCODE_SIZE.LOW.width;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.config.MediaConfig
 * JD-Core Version:    0.7.0.1
 */