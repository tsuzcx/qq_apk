package com.tencent.mobileqq.shortvideo.util;

import com.tencent.richmedia.videocompress.VideoConverterConfig;

final class ShortVideoTrimmer$1
  extends ShortVideoTrimmer.ProcessCallBack
{
  ShortVideoTrimmer$1(VideoConverterConfig paramVideoConverterConfig, String paramString1, String paramString2) {}
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    if (this.val$config != null) {}
    for (VideoConverterConfig localVideoConverterConfig = this.val$config;; localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(this.val$inputVideo))
    {
      localVideoConverterConfig.output = this.val$outputVideo;
      return localVideoConverterConfig;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.1
 * JD-Core Version:    0.7.0.1
 */