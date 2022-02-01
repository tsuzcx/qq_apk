package com.tencent.weseevideo.model.effect;

import com.tencent.weseevideo.composition.effectnode.VideoEffectType;

public class LutModel
  extends BaseEffectModel
{
  private int effectType = VideoEffectType.TYPE_LUT.value;
  private float lutAlpha = 1.0F;
  private String lutBitmap = "";
  private long lutDuration = 2147483647L;
  private long lutStartTime = 0L;
  
  public int getEffectType()
  {
    return this.effectType;
  }
  
  public float getLutAlpha()
  {
    return this.lutAlpha;
  }
  
  public String getLutBitmap()
  {
    return this.lutBitmap;
  }
  
  public long getLutDuration()
  {
    return this.lutDuration;
  }
  
  public long getLutStartTime()
  {
    return this.lutStartTime;
  }
  
  public void setEffectType(int paramInt)
  {
    this.effectType = paramInt;
  }
  
  public void setLutAlpha(float paramFloat)
  {
    this.lutAlpha = paramFloat;
  }
  
  public void setLutBitmap(String paramString)
  {
    this.lutBitmap = paramString;
  }
  
  public void setLutDuration(long paramLong)
  {
    this.lutDuration = paramLong;
  }
  
  public void setLutStartTime(long paramLong)
  {
    this.lutStartTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.LutModel
 * JD-Core Version:    0.7.0.1
 */