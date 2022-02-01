package com.tencent.upload.image;

public class Milestone
{
  private int mMilestone = 0;
  
  public void disable(int paramInt)
  {
    this.mMilestone = ((paramInt ^ 0xFFFFFFFF) & this.mMilestone);
  }
  
  public void disableAll(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      disable(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public void enable(int paramInt)
  {
    this.mMilestone = (paramInt | this.mMilestone);
  }
  
  public void enableAll(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      enable(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public String getMilestoneString()
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i = 31;
    while (i >= 0)
    {
      String str;
      if (isEnabled(1 << i)) {
        str = "1";
      } else {
        str = "0";
      }
      localStringBuilder.append(str);
      i -= 1;
    }
    return localStringBuilder.toString();
  }
  
  public int getMilestoneValue()
  {
    return this.mMilestone;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return (this.mMilestone & paramInt) == paramInt;
  }
  
  public void reset()
  {
    this.mMilestone = 0;
  }
  
  public void toggle(int paramInt)
  {
    this.mMilestone = (paramInt ^ this.mMilestone);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.image.Milestone
 * JD-Core Version:    0.7.0.1
 */