package com.tencent.tav.decoder;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.nio.ByteBuffer;

public abstract interface IDecoder
{
  public static final CMTime SAMPLE_TIME_ERROR = new CMTime(-3L);
  public static final CMTime SAMPLE_TIME_FAILED;
  public static final CMTime SAMPLE_TIME_FINISH;
  public static final CMTime SAMPLE_TIME_TIMEOUT = new CMTime(-4L);
  public static final CMTime SAMPLE_TIME_UNSTART = new CMTime(-100L);
  
  static
  {
    SAMPLE_TIME_FINISH = new CMTime(-1L);
    SAMPLE_TIME_FAILED = new CMTime(-2L);
  }
  
  public abstract String getSourcePath();
  
  public abstract boolean hasTrack();
  
  public abstract ByteBuffer outputBuffer();
  
  public abstract CMTime readSample();
  
  public abstract CMTime readSample(CMTime paramCMTime);
  
  public abstract void release();
  
  public abstract void seekTo(CMTime paramCMTime);
  
  public abstract void start(@Nullable CMTimeRange paramCMTimeRange);
  
  public abstract void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.IDecoder
 * JD-Core Version:    0.7.0.1
 */