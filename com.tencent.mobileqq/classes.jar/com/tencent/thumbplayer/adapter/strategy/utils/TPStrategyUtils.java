package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public class TPStrategyUtils
{
  public static boolean enableFfmpegCodec(TPPlaybackInfo paramTPPlaybackInfo)
  {
    return TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_FFMPEG, paramTPPlaybackInfo.getVideoCodedId(), (int)paramTPPlaybackInfo.getWidth(), (int)paramTPPlaybackInfo.getHeight(), paramTPPlaybackInfo.getVideoProfile(), paramTPPlaybackInfo.getVideoLevel());
  }
  
  public static boolean enableMediaCodec(TPPlaybackInfo paramTPPlaybackInfo)
  {
    return TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC, paramTPPlaybackInfo.getVideoCodedId(), (int)paramTPPlaybackInfo.getWidth(), (int)paramTPPlaybackInfo.getHeight(), paramTPPlaybackInfo.getVideoProfile(), paramTPPlaybackInfo.getVideoLevel());
  }
  
  public static boolean enablePlayBySystemPlayer(TPPlaybackInfo paramTPPlaybackInfo)
  {
    if (paramTPPlaybackInfo.getVideoCodedId() == 0) {
      return true;
    }
    return enableMediaCodec(paramTPPlaybackInfo);
  }
  
  public static boolean enablePlayByThumbPlayer(TPPlaybackInfo paramTPPlaybackInfo)
  {
    if (paramTPPlaybackInfo == null) {}
    while ((paramTPPlaybackInfo.getVideoCodedId() == 0) || (enableFfmpegCodec(paramTPPlaybackInfo)) || (enableMediaCodec(paramTPPlaybackInfo))) {
      return true;
    }
    return false;
  }
  
  public static boolean isSystemPlayerEnable()
  {
    return true;
  }
  
  public static boolean isTVPlatform()
  {
    return false;
  }
  
  public static boolean isThumbPlayerEnable()
  {
    return TPNativeLibraryLoader.isLibLoaded();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPStrategyUtils
 * JD-Core Version:    0.7.0.1
 */