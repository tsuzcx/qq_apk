package com.tencent.weseevideo.model.effect;

import com.tencent.weseevideo.composition.effectnode.VideoEffectType;

public class VideoPagModel
  extends BaseEffectModel
{
  protected String assetFilePath;
  protected float duration;
  protected int effectType = VideoEffectType.TYPE_DEFAULT.value;
  protected String filePath;
  protected float startTime;
  protected String stickerId = "";
  
  public String getAssetFilePath()
  {
    return this.assetFilePath;
  }
  
  public float getDuration()
  {
    return this.duration;
  }
  
  public int getEffectType()
  {
    return this.effectType;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public float getStartTime()
  {
    return this.startTime;
  }
  
  public String getStickerId()
  {
    return this.stickerId;
  }
  
  public void setAssetFilePath(String paramString)
  {
    this.assetFilePath = paramString;
  }
  
  public void setDuration(float paramFloat)
  {
    this.duration = paramFloat;
  }
  
  public void setEffectType(int paramInt)
  {
    this.effectType = paramInt;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setStartTime(float paramFloat)
  {
    this.startTime = paramFloat;
  }
  
  public void setStickerId(String paramString)
  {
    this.stickerId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.VideoPagModel
 * JD-Core Version:    0.7.0.1
 */