package com.tencent.thumbplayer.utils;

import com.tencent.thumbplayer.core.common.TPDecoderType;

public class TPEnumUtils
{
  public static int convertAudioFrameFormat2Outter(int paramInt)
  {
    if (-1 == paramInt) {}
    do
    {
      return -1;
      if (paramInt == 0) {
        return 0;
      }
      if (1 == paramInt) {
        return 1;
      }
    } while (2 != paramInt);
    return 2;
  }
  
  public static int convertCodecType2Inner(int paramInt)
  {
    int i;
    if (26 == paramInt) {
      i = 26;
    }
    do
    {
      return i;
      i = paramInt;
    } while (172 != paramInt);
    return 172;
  }
  
  public static int convertDRMType2Inner(int paramInt)
  {
    int i;
    if (paramInt == 0) {
      i = 0;
    }
    do
    {
      return i;
      if (1 == paramInt) {
        return 1;
      }
      if (2 == paramInt) {
        return 2;
      }
      i = paramInt;
    } while (3 != paramInt);
    return 3;
  }
  
  public static int convertDRMType2Outter(int paramInt)
  {
    int i;
    if (paramInt == 0) {
      i = 0;
    }
    do
    {
      return i;
      if (1 == paramInt) {
        return 1;
      }
      if (2 == paramInt) {
        return 2;
      }
      i = paramInt;
    } while (3 != paramInt);
    return 3;
  }
  
  public static int convertDecType2Inner(int paramInt)
  {
    int i;
    if (101 == paramInt) {
      i = TPDecoderType.TP_VIDEO_DECODER_FFMPEG;
    }
    do
    {
      return i;
      i = paramInt;
    } while (102 != paramInt);
    return TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC;
  }
  
  public static int convertDecoderType2Inner(int paramInt)
  {
    int i;
    if (101 == paramInt) {
      i = TPDecoderType.TP_VIDEO_DECODER_FFMPEG;
    }
    do
    {
      return i;
      i = paramInt;
    } while (102 != paramInt);
    return TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC;
  }
  
  public static int convertHDRType2Inner(int paramInt)
  {
    int i;
    if (paramInt == 0) {
      i = 0;
    }
    do
    {
      return i;
      if (1 == paramInt) {
        return 1;
      }
      if (2 == paramInt) {
        return 2;
      }
      i = paramInt;
    } while (3 != paramInt);
    return 3;
  }
  
  public static int convertSubtitleFrameFormat2Outer(int paramInt)
  {
    if (-1 == paramInt) {}
    while (26 != paramInt) {
      return -1;
    }
    return 26;
  }
  
  public static int convertVideoFrameFormat2Outter(int paramInt)
  {
    if (-1 == paramInt) {}
    do
    {
      return -1;
      if (paramInt == 0) {
        return 0;
      }
      if (12 == paramInt) {
        return 12;
      }
    } while (37 != paramInt);
    return 37;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPEnumUtils
 * JD-Core Version:    0.7.0.1
 */