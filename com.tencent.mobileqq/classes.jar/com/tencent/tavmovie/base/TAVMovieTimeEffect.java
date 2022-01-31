package com.tencent.tavmovie.base;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.component.TAVTimeEffect;

public class TAVMovieTimeEffect
  implements Cloneable
{
  private int loop = 1;
  private CMTimeRange sourceTimeRange;
  private float speed = 1.0F;
  private CMTimeRange timeRange = new CMTimeRange(CMTime.CMTimeZero, CMTime.CMTimeZero);
  
  public CMTime calculateSourceDuration()
  {
    if (this.sourceTimeRange != null) {
      return this.sourceTimeRange.getDuration();
    }
    return CMTime.CMTimeZero;
  }
  
  public TAVMovieTimeEffect clone()
  {
    TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
    localTAVMovieTimeEffect.sourceTimeRange = this.sourceTimeRange;
    localTAVMovieTimeEffect.timeRange = this.timeRange;
    localTAVMovieTimeEffect.loop = this.loop;
    localTAVMovieTimeEffect.speed = this.speed;
    return localTAVMovieTimeEffect;
  }
  
  public TAVTimeEffect convertToTimeEffect()
  {
    TAVTimeEffect localTAVTimeEffect = new TAVTimeEffect();
    localTAVTimeEffect.setLoopCount(this.loop);
    localTAVTimeEffect.setTimeRange(this.timeRange);
    if (Math.abs(this.speed - 0.0F) < 1.0E-004F)
    {
      localTAVTimeEffect.setFreeze(true);
      return localTAVTimeEffect;
    }
    if (this.speed < 0.0F) {
      localTAVTimeEffect.setReverse(true);
    }
    localTAVTimeEffect.setScaledDuration(this.timeRange.getDuration().divide(this.speed));
    return localTAVTimeEffect;
  }
  
  public int getLoop()
  {
    return this.loop;
  }
  
  public CMTimeRange getSourceTimeRange()
  {
    return this.sourceTimeRange;
  }
  
  public float getSpeed()
  {
    return this.speed;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public void setLoop(int paramInt)
  {
    this.loop = paramInt;
  }
  
  public void setSourceTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.sourceTimeRange = paramCMTimeRange;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.speed = paramFloat;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavmovie.base.TAVMovieTimeEffect
 * JD-Core Version:    0.7.0.1
 */