package com.tencent.tavkit.composition.model;

import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;

class TAVTransition$EmptyAudioTransition
  implements TAVAudioTransition
{
  private CMTime duration;
  private String identifier;
  
  TAVTransition$EmptyAudioTransition(CMTime paramCMTime)
  {
    this.duration = paramCMTime;
  }
  
  public void applyNextAudioMixInputParameters(MutableAudioMixInputParameters paramMutableAudioMixInputParameters, CMTimeRange paramCMTimeRange) {}
  
  public void applyPreviousAudioMixInputParameters(MutableAudioMixInputParameters paramMutableAudioMixInputParameters, CMTimeRange paramCMTimeRange) {}
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  public void setIdentifier(String paramString)
  {
    this.identifier = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVTransition.EmptyAudioTransition
 * JD-Core Version:    0.7.0.1
 */