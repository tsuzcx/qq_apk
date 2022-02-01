package com.tencent.tavkit.composition.model;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavkit.composition.video.TAVVideoTransition.Filter;

class TAVTransition$EmptyVideoTransition
  implements TAVVideoTransition
{
  private CMTime duration;
  
  public TAVTransition$EmptyVideoTransition(CMTime paramCMTime)
  {
    this.duration = paramCMTime;
  }
  
  public TAVVideoTransition.Filter createFilter()
  {
    return null;
  }
  
  public String effectId()
  {
    return toString();
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVTransition.EmptyVideoTransition
 * JD-Core Version:    0.7.0.1
 */