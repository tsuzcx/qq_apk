package com.tencent.richmedia.videocompress.strategy;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.os.Build.VERSION;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecUtil;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecWrapper;
import java.util.Iterator;
import java.util.List;

public class MediaCodecSupport
{
  public static String AVC_CODEC_MIME = "video/avc";
  public static final int COLOR_FormatYUV420Planar = 19;
  public static final int COLOR_FormatYUV420SemiPlanar = 21;
  public static final int COLOR_MTK_FormatYUV420Planar = 2130706944;
  public static final int COLOR_QCOM_FormatYUV420PackedSemiPlanar32m = 2141391876;
  public static String HEVC_CODEC_MIME = "video/hevc";
  public static final int SUPPORT_AVC_DEC = 1;
  public static final int SUPPORT_AVC_ENC = 2;
  public static final int SUPPORT_HEVC_DEC = 4;
  public static final int SUPPORT_HEVC_ENC = 8;
  public static final int SUPPORT_NONE = 0;
  private static final String TAG = "MediaCodecSupport";
  public static int mMediaCodecFeature = -1;
  
  private static boolean checkDecoderSupportColorFormat(int paramInt)
  {
    return (paramInt == 19) || (paramInt == 21) || (paramInt == 2130706944) || (paramInt == 2141391876);
  }
  
  private static boolean checkEncoderSupportColorFormat(int paramInt)
  {
    return (paramInt == 19) || (paramInt == 21);
  }
  
  public static int checkSupportMediaCodecFeature(Context paramContext)
  {
    int i = mMediaCodecFeature;
    if (i >= 0) {
      return i;
    }
    mMediaCodecFeature = 0;
    if (paramContext == null) {
      return mMediaCodecFeature;
    }
    if (Build.VERSION.SDK_INT < 16) {
      return mMediaCodecFeature;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      MediaCodecWrapper.invoke21Apis();
      if (!MediaCodecWrapper.invokeAPILevel21)
      {
        mMediaCodecFeature = 0;
        return mMediaCodecFeature;
      }
    }
    if (isAVCDecSupportColorFormats()) {
      mMediaCodecFeature = 1;
    }
    if (isAVCEncSupportColorFormats()) {
      mMediaCodecFeature += 2;
    }
    return mMediaCodecFeature;
  }
  
  private static boolean isAVCDecSupportColorFormats()
  {
    Iterator localIterator = MediaCodecUtil.getDecoderInfoList(AVC_CODEC_MIME, false).iterator();
    while (localIterator.hasNext())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = MediaCodecUtil.getCodecCapabilities((MediaCodecInfo)localIterator.next(), AVC_CODEC_MIME);
      if ((localCodecCapabilities != null) && (localCodecCapabilities.colorFormats != null))
      {
        int i = 0;
        while (i < localCodecCapabilities.colorFormats.length)
        {
          if (checkDecoderSupportColorFormat(localCodecCapabilities.colorFormats[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private static boolean isAVCEncSupportColorFormats()
  {
    Iterator localIterator = MediaCodecUtil.getEncoderInfoList(AVC_CODEC_MIME).iterator();
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      int i = 0;
      if (!bool) {
        break;
      }
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = MediaCodecUtil.getCodecCapabilities((MediaCodecInfo)localIterator.next(), AVC_CODEC_MIME);
      if (localCodecCapabilities != null) {
        while (i < localCodecCapabilities.colorFormats.length)
        {
          if (checkEncoderSupportColorFormat(localCodecCapabilities.colorFormats[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.strategy.MediaCodecSupport
 * JD-Core Version:    0.7.0.1
 */