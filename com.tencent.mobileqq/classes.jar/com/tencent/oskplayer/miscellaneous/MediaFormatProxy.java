package com.tencent.oskplayer.miscellaneous;

import android.media.MediaFormat;

public class MediaFormatProxy
{
  public MediaFormat videoFormat;
  public int videoTrack;
  
  public MediaFormatProxy(MediaFormat paramMediaFormat, int paramInt)
  {
    this.videoFormat = paramMediaFormat;
    this.videoTrack = paramInt;
  }
  
  public static MediaFormatProxy create(MediaFormat paramMediaFormat, int paramInt)
  {
    return new MediaFormatProxy(paramMediaFormat, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.miscellaneous.MediaFormatProxy
 * JD-Core Version:    0.7.0.1
 */