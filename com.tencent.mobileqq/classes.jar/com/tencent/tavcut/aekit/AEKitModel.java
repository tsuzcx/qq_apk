package com.tencent.tavcut.aekit;

import java.util.Map;

public class AEKitModel
{
  public static final int MEDIA_TYPE_IMAGE = 1;
  public static final int MEDIA_TYPE_VIDEO = 2;
  private Map<String, String> adjustParams;
  private boolean disable;
  private float effectStrength = 1.0F;
  private float glowAlpha = 0.0F;
  private boolean lastState;
  private float lutAlpha = 1.0F;
  private String lutPath;
  private long mDuration = 2147483647L;
  private long mStartTime = 0L;
  private String material = "";
  private final int mediaType;
  private String overlayImgPath;
  private int smoothLevel = 0;
  
  public AEKitModel(int paramInt)
  {
    this.mediaType = paramInt;
  }
  
  public Map<String, String> getAdjustParams()
  {
    return this.adjustParams;
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public float getEffectStrength()
  {
    return this.effectStrength;
  }
  
  public float getGlowAlpha()
  {
    return this.glowAlpha;
  }
  
  public boolean getLastState()
  {
    return this.lastState;
  }
  
  public float getLutAlpha()
  {
    return this.lutAlpha;
  }
  
  public String getLutPath()
  {
    return this.lutPath;
  }
  
  public String getMaterial()
  {
    return this.material;
  }
  
  public int getMediaType()
  {
    return this.mediaType;
  }
  
  public String getOverlayImgPath()
  {
    return this.overlayImgPath;
  }
  
  public int getSmoothLevel()
  {
    return this.smoothLevel;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public boolean isDisable()
  {
    return this.disable;
  }
  
  public void setAdjustParams(Map<String, String> paramMap)
  {
    this.adjustParams = paramMap;
  }
  
  public void setDisable(boolean paramBoolean)
  {
    this.lastState = this.disable;
    this.disable = paramBoolean;
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }
  
  public void setEffectStrength(float paramFloat)
  {
    this.effectStrength = paramFloat;
  }
  
  public void setGlowAlpha(float paramFloat)
  {
    this.glowAlpha = paramFloat;
  }
  
  public void setLastState(boolean paramBoolean)
  {
    this.lastState = paramBoolean;
  }
  
  public void setLutAlpha(float paramFloat)
  {
    this.lutAlpha = paramFloat;
  }
  
  public void setLutPath(String paramString)
  {
    this.lutPath = paramString;
  }
  
  public void setMaterial(String paramString)
  {
    this.material = paramString;
  }
  
  public void setOverlayImagePath(String paramString)
  {
    this.overlayImgPath = paramString;
  }
  
  public void setSmoothLevel(int paramInt)
  {
    this.smoothLevel = paramInt;
  }
  
  public void setStartTime(long paramLong)
  {
    this.mStartTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.aekit.AEKitModel
 * JD-Core Version:    0.7.0.1
 */