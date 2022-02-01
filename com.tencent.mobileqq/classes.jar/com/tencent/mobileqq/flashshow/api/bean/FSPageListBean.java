package com.tencent.mobileqq.flashshow.api.bean;

public class FSPageListBean
  extends FSInitBean
{
  private int mLaunchTo;
  
  public FSPageListBean(FSReportBean paramFSReportBean)
  {
    super(paramFSReportBean);
  }
  
  public int getLaunchTo()
  {
    return this.mLaunchTo;
  }
  
  public void setLaunchTo(int paramInt)
  {
    this.mLaunchTo = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.bean.FSPageListBean
 * JD-Core Version:    0.7.0.1
 */