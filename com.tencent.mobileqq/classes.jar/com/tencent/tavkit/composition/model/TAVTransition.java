package com.tencent.tavkit.composition.model;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.video.TAVVideoTransition;

public class TAVTransition
{
  private TAVAudioTransition audioTransition;
  private CMTime duration;
  private TAVVideoTransition videoTransition;
  
  public TAVTransition(CMTime paramCMTime)
  {
    this.duration = paramCMTime;
    this.audioTransition = new TAVTransition.EmptyAudioTransition(paramCMTime);
    this.videoTransition = new TAVTransition.EmptyVideoTransition(paramCMTime);
  }
  
  public TAVAudioTransition getAudioTransition()
  {
    return this.audioTransition;
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public TAVVideoTransition getVideoTransition()
  {
    return this.videoTransition;
  }
  
  public void setAudioTransition(TAVAudioTransition paramTAVAudioTransition)
  {
    this.audioTransition = paramTAVAudioTransition;
  }
  
  public void setVideoTransition(TAVVideoTransition paramTAVVideoTransition)
  {
    this.videoTransition = paramTAVVideoTransition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVTransition
 * JD-Core Version:    0.7.0.1
 */