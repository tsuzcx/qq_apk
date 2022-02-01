package com.tencent.mobileqq.shortvideo.api.impl;

import com.tencent.mobileqq.shortvideo.api.IVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

public class VideoTrimmerImpl
  implements IVideoTrimmer
{
  public VideoConverterConfig getCompressConfig(String paramString)
  {
    return ShortVideoTrimmer.getCompressConfig(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.api.impl.VideoTrimmerImpl
 * JD-Core Version:    0.7.0.1
 */