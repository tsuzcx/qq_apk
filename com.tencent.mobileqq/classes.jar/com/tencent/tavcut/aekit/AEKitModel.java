package com.tencent.tavcut.aekit;

import java.util.HashMap;

public class AEKitModel
{
  private HashMap<String, String> adjustParams;
  private boolean enableAIFilter = true;
  private float glowAlpha = 0.0F;
  private float lutAlpha = 1.0F;
  private String lutPath;
  private long mDuration = 2147483647L;
  private long mStartTime = 0L;
  private int smoothLevel = 0;
  
  public HashMap<String, String> getAdjustParams()
  {
    return this.adjustParams;
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public float getGlowAlpha()
  {
    return this.glowAlpha;
  }
  
  public float getLutAlpha()
  {
    return this.lutAlpha;
  }
  
  public String getLutPath()
  {
    return this.lutPath;
  }
  
  public int getSmoothLevel()
  {
    return this.smoothLevel;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public boolean isEnableAIFilter()
  {
    return this.enableAIFilter;
  }
  
  public void setAdjustParams(HashMap<String, String> paramHashMap)
  {
    this.adjustParams = paramHashMap;
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }
  
  public void setEnableAIFilter(boolean paramBoolean)
  {
    this.enableAIFilter = paramBoolean;
  }
  
  public void setGlowAlpha(float paramFloat)
  {
    this.glowAlpha = paramFloat;
  }
  
  public void setLutAlpha(float paramFloat)
  {
    this.lutAlpha = paramFloat;
  }
  
  public void setLutPath(String paramString)
  {
    this.lutPath = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.aekit.AEKitModel
 * JD-Core Version:    0.7.0.1
 */