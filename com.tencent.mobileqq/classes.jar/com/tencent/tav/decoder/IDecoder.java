package com.tencent.tav.decoder;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public abstract interface IDecoder
{
  public static final String EXTRA_INFO_KEY_DECODE_INFO = "extra_info_key_decode_info";
  public static final long SAMPLE_STATE_ERROR = -3L;
  public static final long SAMPLE_STATE_FAILED = -2L;
  public static final long SAMPLE_STATE_FINISH = -1L;
  public static final long SAMPLE_STATE_TIMEOUT = -4L;
  public static final long SAMPLE_STATE_UN_START = -100L;
  
  public abstract String getSourcePath();
  
  public abstract boolean hasTrack();
  
  public abstract CMSampleState readSample(CMTime paramCMTime);
  
  public abstract void seekTo(CMTime paramCMTime);
  
  public abstract void start(@Nullable CMTimeRange paramCMTimeRange);
  
  public abstract void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.IDecoder
 * JD-Core Version:    0.7.0.1
 */