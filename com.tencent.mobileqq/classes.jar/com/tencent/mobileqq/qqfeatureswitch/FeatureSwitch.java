package com.tencent.mobileqq.qqfeatureswitch;

public class FeatureSwitch
{
  public String mOwner;
  public boolean mSwitchEnable;
  public String mSwitchInfo;
  public String mSwitchName;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeatureSwitch{mSwitchEnable=");
    localStringBuilder.append(this.mSwitchEnable);
    localStringBuilder.append(", mSwitchName='");
    localStringBuilder.append(this.mSwitchName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSwitchInfo='");
    localStringBuilder.append(this.mSwitchInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mOwner='");
    localStringBuilder.append(this.mOwner);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.FeatureSwitch
 * JD-Core Version:    0.7.0.1
 */