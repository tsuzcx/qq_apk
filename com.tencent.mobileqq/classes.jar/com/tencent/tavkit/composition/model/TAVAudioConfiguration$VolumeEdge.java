package com.tencent.tavkit.composition.model;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class TAVAudioConfiguration$VolumeEdge
{
  private float endVolume;
  private float startVolume;
  private CMTimeRange timeRange;
  
  public TAVAudioConfiguration$VolumeEdge() {}
  
  public TAVAudioConfiguration$VolumeEdge(@NonNull CMTime paramCMTime, float paramFloat1, float paramFloat2)
  {
    this.timeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
    this.startVolume = paramFloat1;
    this.endVolume = paramFloat2;
  }
  
  public TAVAudioConfiguration$VolumeEdge(CMTimeRange paramCMTimeRange, float paramFloat1, float paramFloat2)
  {
    this.timeRange = paramCMTimeRange;
    this.startVolume = paramFloat1;
    this.endVolume = paramFloat2;
  }
  
  public CMTime getDuration()
  {
    CMTimeRange localCMTimeRange = this.timeRange;
    if (localCMTimeRange != null) {
      return localCMTimeRange.getDuration();
    }
    return CMTime.CMTimeZero;
  }
  
  public float getEndVolume()
  {
    return this.endVolume;
  }
  
  public float getStartVolume()
  {
    return this.startVolume;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public float getVolume(CMTime paramCMTime)
  {
    long l = paramCMTime.getTimeUs();
    float f = this.startVolume;
    return f + (this.endVolume - f) * ((float)l * 1.0F / (float)getDuration().getTimeUs());
  }
  
  public void setDuration(@NonNull CMTime paramCMTime)
  {
    this.timeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
  }
  
  public void setEndVolume(float paramFloat)
  {
    this.endVolume = paramFloat;
  }
  
  public void setStartVolume(float paramFloat)
  {
    this.startVolume = paramFloat;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVAudioConfiguration.VolumeEdge
 * JD-Core Version:    0.7.0.1
 */