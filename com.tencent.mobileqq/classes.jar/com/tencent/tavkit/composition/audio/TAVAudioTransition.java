package com.tencent.tavkit.composition.audio;

import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public abstract interface TAVAudioTransition
{
  public abstract void applyNextAudioMixInputParameters(MutableAudioMixInputParameters paramMutableAudioMixInputParameters, CMTimeRange paramCMTimeRange);
  
  public abstract void applyPreviousAudioMixInputParameters(MutableAudioMixInputParameters paramMutableAudioMixInputParameters, CMTimeRange paramCMTimeRange);
  
  public abstract CMTime getDuration();
  
  public abstract String getIdentifier();
  
  public abstract void setIdentifier(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioTransition
 * JD-Core Version:    0.7.0.1
 */