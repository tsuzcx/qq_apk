package com.tencent.tavmovie.base;

import com.tencent.tav.coremedia.CMTimeRange;

public class TAVSegmentTimeEffect
  extends TAVSegmentEffect
  implements Cloneable
{
  protected int loop;
  protected float speed;
  
  public TAVSegmentTimeEffect clone()
  {
    TAVSegmentTimeEffect localTAVSegmentTimeEffect = new TAVSegmentTimeEffect();
    localTAVSegmentTimeEffect.timeRange = this.timeRange.clone();
    localTAVSegmentTimeEffect.loop = this.loop;
    localTAVSegmentTimeEffect.speed = this.speed;
    return localTAVSegmentTimeEffect;
  }
  
  public int getLoop()
  {
    return this.loop;
  }
  
  public float getSpeed()
  {
    return this.speed;
  }
  
  public void setLoop(int paramInt)
  {
    this.loop = paramInt;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.speed = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.base.TAVSegmentTimeEffect
 * JD-Core Version:    0.7.0.1
 */