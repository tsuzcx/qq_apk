package com.tencent.thumbplayer.utils;

import com.tencent.thumbplayer.core.common.TPDecoderType;

public class TPEnumUtils
{
  public static int convertAudioFrameFormat2Inner(int paramInt)
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
      if (2 == paramInt) {
        return 2;
      }
      if (3 == paramInt) {
        return 3;
      }
      if (4 == paramInt) {
        return 4;
      }
      if (5 == paramInt) {
        return 5;
      }
      if (6 == paramInt) {
        return 6;
      }
      if (7 == paramInt) {
        return 7;
      }
      if (8 == paramInt) {
        return 8;
      }
      if (9 == paramInt) {
        return 9;
      }
      if (10 == paramInt) {
        return 10;
      }
    } while (11 != paramInt);
    return 11;
  }
  
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
      if (2 == paramInt) {
        return 2;
      }
      if (3 == paramInt) {
        return 3;
      }
      if (4 == paramInt) {
        return 4;
      }
      if (5 == paramInt) {
        return 5;
      }
      if (6 == paramInt) {
        return 6;
      }
      if (7 == paramInt) {
        return 7;
      }
      if (8 == paramInt) {
        return 8;
      }
      if (9 == paramInt) {
        return 9;
      }
      if (10 == paramInt) {
        return 10;
      }
    } while (11 != paramInt);
    return 11;
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
  
  public static int convertMediaType2Inner(int paramInt)
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
      if (2 == paramInt) {
        return 2;
      }
      if (3 == paramInt) {
        return 3;
      }
    } while (4 != paramInt);
    return 4;
  }
  
  public static int convertMediaType2Outer(int paramInt)
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
      if (2 == paramInt) {
        return 2;
      }
      if (3 == paramInt) {
        return 3;
      }
    } while (4 != paramInt);
    return 4;
  }
  
  public static int convertSubtitleFrameFormat2Outer(int paramInt)
  {
    if (-1 == paramInt) {}
    while (26 != paramInt) {
      return -1;
    }
    return 26;
  }
  
  public static int convertVideoFrameFormat2Inner(int paramInt)
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
      if (26 == paramInt) {
        return 26;
      }
    } while (37 != paramInt);
    return 37;
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
      if (26 == paramInt) {
        return 26;
      }
    } while (37 != paramInt);
    return 37;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPEnumUtils
 * JD-Core Version:    0.7.0.1
 */