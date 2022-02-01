package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.List;

public abstract interface IDecoderTrack
{
  public abstract void asyncReadNextSample(CMTime paramCMTime);
  
  public abstract void clipRangeAndClearRange(CMTimeRange paramCMTimeRange);
  
  public abstract CMTime getCurrentSampleTime();
  
  public abstract CMTime getDuration();
  
  public abstract CMTime getFrameDuration();
  
  public abstract int getFrameRate();
  
  public abstract int getTrackId();
  
  public abstract CMSampleBuffer readSample();
  
  public abstract CMSampleBuffer readSample(CMTime paramCMTime);
  
  public abstract void release();
  
  public abstract CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setDecodeType(IDecoder.DecodeType paramDecodeType);
  
  public abstract void setFrameRate(int paramInt);
  
  public abstract void setTrackSegments(List<DecoderTrackSegment> paramList);
  
  public abstract void setVolume(float paramFloat);
  
  public abstract void start();
  
  public abstract void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator);
  
  public abstract void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.IDecoderTrack
 * JD-Core Version:    0.7.0.1
 */