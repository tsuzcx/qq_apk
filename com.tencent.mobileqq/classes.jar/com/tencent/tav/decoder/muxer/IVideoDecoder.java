package com.tencent.tav.decoder.muxer;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public abstract interface IVideoDecoder
{
  public abstract boolean prepare(String paramString);
  
  public abstract CMSampleState readSample(CMTime paramCMTime);
  
  public abstract void release();
  
  public abstract void seekTo(CMTime paramCMTime, boolean paramBoolean);
  
  public abstract boolean start(@Nullable CMTimeRange paramCMTimeRange);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.IVideoDecoder
 * JD-Core Version:    0.7.0.1
 */