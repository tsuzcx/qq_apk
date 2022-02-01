package com.tencent.weseevideo.model.resource;

import com.tencent.weseevideo.model.BaseMediaModel;

public class VolumeEdgeModel
  extends BaseMediaModel
{
  private float endVolume;
  private float startVolume;
  private long timeDuration;
  private long timeStart;
  
  public float getEndVolume()
  {
    return this.endVolume;
  }
  
  public float getStartVolume()
  {
    return this.startVolume;
  }
  
  public long getTimeDuration()
  {
    return this.timeDuration;
  }
  
  public long getTimeStart()
  {
    return this.timeStart;
  }
  
  public void setEndVolume(float paramFloat)
  {
    this.endVolume = paramFloat;
  }
  
  public void setStartVolume(float paramFloat)
  {
    this.startVolume = paramFloat;
  }
  
  public void setTimeDuration(long paramLong)
  {
    this.timeDuration = paramLong;
  }
  
  public void setTimeStart(long paramLong)
  {
    this.timeStart = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.VolumeEdgeModel
 * JD-Core Version:    0.7.0.1
 */