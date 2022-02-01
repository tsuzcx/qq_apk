package com.tencent.mobileqq.qqvideoplatform.api;

public class SceneID
{
  public static final int AE_ALBUM_VIDEO = 113;
  public static final int AIO_LONG_BUBBLE = 101;
  public static final int AIO_QQFLOATING = 116;
  public static final int AIO_SHORT_BUBBLE = 100;
  public static final int ALBUM_VIDEO = 105;
  public static final int AR_VIDEO = 108;
  public static final int AVGAME_VIDEO = 107;
  public static final int COMIC_VIDEO = 119;
  public static final int FILE_VIDEO = 109;
  public static final int GDT_AD_VIDEO = 110;
  public static final int MINIAPP_VIDEO = 114;
  public static final int QQGME_VIDEO = 106;
  public static final int QQ_HEALTH_CENTER = 117;
  public static final int QQ_RTC_VIDEO = 115;
  public static final int QQ_VOICE = 118;
  public static final int QZONE_GDT_VIDEO = 103;
  public static final int QZONE_VIDEO = 102;
  public static final int READINJOY_VIDEO = 104;
  public static final int TRIBE_VIDEO = 111;
  public static final int WS_VIDEO = 112;
  
  public static String getSceneStr(int paramInt)
  {
    switch (paramInt)
    {
    case 118: 
    default: 
      return "UNKNOW";
    case 119: 
      return "COMIC_VIDEO";
    case 117: 
      return "QQ_HEALTH_CENTER";
    case 116: 
      return "AIO_QQFLOATING";
    case 115: 
      return "QQ_RTC_VIDEO";
    case 114: 
      return "MINIAPP_VIDEO";
    case 113: 
      return "AE_ALBUM_VIDEO";
    case 112: 
      return "WS_VIDEO";
    case 111: 
      return "TRIBE_VIDEO";
    case 110: 
      return "GDT_AD_VIDEO";
    case 109: 
      return "FILE_VIDEO";
    case 108: 
      return "AR_VIDEO";
    case 107: 
      return "AVGAME_VIDEO";
    case 106: 
      return "QQGME_VIDEO";
    case 105: 
      return "ALBUM_VIDEO";
    case 104: 
      return "READINJOY_VIDEO";
    case 103: 
      return "QZONE_GDT_VIDEO";
    case 102: 
      return "QZONE_VIDEO";
    case 101: 
      return "AIO_LONG_BUBBLE";
    }
    return "AIO_SHORT_BUBBLE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.SceneID
 * JD-Core Version:    0.7.0.1
 */