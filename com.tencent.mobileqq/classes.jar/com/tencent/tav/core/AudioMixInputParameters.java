package com.tencent.tav.core;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;

public class AudioMixInputParameters
{
  protected AudioTapProcessor audioTapProcessor;
  protected String audioTimePitchAlgorithm;
  protected int trackID;
  protected ArrayList<AudioMixInputParameters.VolumeRange> volumeRanges = new ArrayList();
  
  public AudioMixInputParameters(int paramInt, String paramString)
  {
    this.trackID = paramInt;
    this.audioTimePitchAlgorithm = paramString;
  }
  
  public boolean containsTime(CMTime paramCMTime)
  {
    Iterator localIterator = this.volumeRanges.iterator();
    while (localIterator.hasNext()) {
      if (((AudioMixInputParameters.VolumeRange)localIterator.next()).timeRange.containsTime(paramCMTime)) {
        return true;
      }
    }
    return false;
  }
  
  public AudioTapProcessor getAudioTapProcessor()
  {
    return this.audioTapProcessor;
  }
  
  public String getAudioTimePitchAlgorithm()
  {
    return this.audioTimePitchAlgorithm;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public float getVolumeAtTime(CMTime paramCMTime)
  {
    long l1 = paramCMTime.getTimeUs();
    Iterator localIterator = this.volumeRanges.iterator();
    while (localIterator.hasNext())
    {
      paramCMTime = (AudioMixInputParameters.VolumeRange)localIterator.next();
      if ((l1 >= paramCMTime.timeRange.getStart().getTimeUs()) && (l1 < paramCMTime.timeRange.getEnd().getTimeUs())) {
        break label70;
      }
    }
    paramCMTime = null;
    label70:
    if (paramCMTime == null) {
      return 1.0F;
    }
    long l2 = paramCMTime.timeRange.getStart().getTimeUs();
    return paramCMTime.startVolume + (paramCMTime.endVolume - paramCMTime.startVolume) * ((float)(l1 - l2) * 1.0F / (float)paramCMTime.timeRange.getDuration().getTimeUs());
  }
  
  public AudioMixInputParameters.VolumeRange getVolumeRampAtTimeRange(CMTime paramCMTime)
  {
    Iterator localIterator = this.volumeRanges.iterator();
    while (localIterator.hasNext())
    {
      AudioMixInputParameters.VolumeRange localVolumeRange = (AudioMixInputParameters.VolumeRange)localIterator.next();
      if (localVolumeRange.timeRange.containsTime(paramCMTime)) {
        return localVolumeRange;
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioMixInputParameters{trackID=");
    localStringBuilder.append(this.trackID);
    localStringBuilder.append(", audioTimePitchAlgorithm='");
    localStringBuilder.append(this.audioTimePitchAlgorithm);
    localStringBuilder.append('\'');
    localStringBuilder.append(", audioTapProcessor=");
    localStringBuilder.append(this.audioTapProcessor);
    localStringBuilder.append(", volumeRanges=");
    localStringBuilder.append(this.volumeRanges);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AudioMixInputParameters
 * JD-Core Version:    0.7.0.1
 */