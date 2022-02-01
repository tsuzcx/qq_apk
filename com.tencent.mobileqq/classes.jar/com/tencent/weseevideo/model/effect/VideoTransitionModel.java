package com.tencent.weseevideo.model.effect;

import com.tencent.weseevideo.composition.effectnode.VideoEffectType;

public class VideoTransitionModel
  extends VideoPagModel
{
  private String linkVideoId;
  private float mFirstHalfTime = 0.0F;
  private float mOverlapTime = 0.0F;
  private float mSpeed = 1.0F;
  private int mTransitionPosition = -1;
  private String subCategoryId = "";
  private String transitionId = "";
  
  public VideoTransitionModel()
  {
    this.effectType = VideoEffectType.TYPE_TRANSITION_EFFECT.value;
  }
  
  public float getFirstHalfTime()
  {
    return this.mFirstHalfTime;
  }
  
  public String getLinkVideoId()
  {
    return this.linkVideoId;
  }
  
  public float getOverlapTime()
  {
    return this.mOverlapTime;
  }
  
  public float getSpeed()
  {
    return this.mSpeed;
  }
  
  public String getSubCategoryId()
  {
    return this.subCategoryId;
  }
  
  public String getTransitionId()
  {
    return this.transitionId;
  }
  
  public int getTransitionPosition()
  {
    return this.mTransitionPosition;
  }
  
  public void setFirstHalfTime(float paramFloat)
  {
    this.mFirstHalfTime = paramFloat;
  }
  
  public void setLinkVideoId(String paramString)
  {
    this.linkVideoId = paramString;
  }
  
  public void setOverlapTime(float paramFloat)
  {
    this.mOverlapTime = paramFloat;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.mSpeed = paramFloat;
  }
  
  public void setSubCategoryId(String paramString)
  {
    this.subCategoryId = paramString;
  }
  
  public void setTransitionId(String paramString)
  {
    this.transitionId = paramString;
  }
  
  public void setTransitionPosition(int paramInt)
  {
    this.mTransitionPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.VideoTransitionModel
 * JD-Core Version:    0.7.0.1
 */