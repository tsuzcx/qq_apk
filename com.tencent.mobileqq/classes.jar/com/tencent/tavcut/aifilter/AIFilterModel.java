package com.tencent.tavcut.aifilter;

import com.tencent.weseevideo.model.effect.BaseEffectModel;

public class AIFilterModel
  extends BaseEffectModel
{
  float alpha;
  String lutPath;
  float[] mConfig;
  private long mDuration = 2147483647L;
  private long mStartTime = 0L;
  
  public float getAlpha()
  {
    return this.alpha;
  }
  
  public float[] getConfig()
  {
    return this.mConfig;
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public String getLutPath()
  {
    return this.lutPath;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public void setAlpha(float paramFloat)
  {
    this.alpha = paramFloat;
  }
  
  public void setConfig(float[] paramArrayOfFloat)
  {
    this.mConfig = paramArrayOfFloat;
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }
  
  public void setLutPath(String paramString)
  {
    this.lutPath = paramString;
  }
  
  public void setStartTime(long paramLong)
  {
    this.mStartTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.aifilter.AIFilterModel
 * JD-Core Version:    0.7.0.1
 */