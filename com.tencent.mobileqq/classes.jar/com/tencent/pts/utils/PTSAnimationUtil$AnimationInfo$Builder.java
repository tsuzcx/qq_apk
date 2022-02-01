package com.tencent.pts.utils;

public class PTSAnimationUtil$AnimationInfo$Builder
{
  private double delay;
  private double duration;
  private int keyCount;
  private String[] keys;
  private String timingFunction;
  
  public PTSAnimationUtil.AnimationInfo build()
  {
    PTSAnimationUtil.AnimationInfo localAnimationInfo = new PTSAnimationUtil.AnimationInfo();
    PTSAnimationUtil.AnimationInfo.access$202(localAnimationInfo, this.keyCount);
    PTSAnimationUtil.AnimationInfo.access$302(localAnimationInfo, this.keys);
    PTSAnimationUtil.AnimationInfo.access$002(localAnimationInfo, this.duration);
    PTSAnimationUtil.AnimationInfo.access$402(localAnimationInfo, this.timingFunction);
    PTSAnimationUtil.AnimationInfo.access$102(localAnimationInfo, this.delay);
    return localAnimationInfo;
  }
  
  public Builder withDelay(double paramDouble)
  {
    this.delay = paramDouble;
    return this;
  }
  
  public Builder withDuration(double paramDouble)
  {
    this.duration = paramDouble;
    return this;
  }
  
  public Builder withTimingFuction(String paramString)
  {
    this.timingFunction = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo.Builder
 * JD-Core Version:    0.7.0.1
 */