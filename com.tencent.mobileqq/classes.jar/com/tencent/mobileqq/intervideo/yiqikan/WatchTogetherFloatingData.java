package com.tencent.mobileqq.intervideo.yiqikan;

import java.io.Serializable;

public class WatchTogetherFloatingData
  implements Serializable
{
  private String mBigUrl;
  private int mCurType;
  private String mCurUin;
  private String mFrom = null;
  private boolean mIsAdm = false;
  private int mLoadingStatus;
  private int mOrientation;
  private String mSmallUrl;
  private double mVideoHeight;
  private double mVideoWidth;
  
  public String getBigUrl()
  {
    return this.mBigUrl;
  }
  
  public int getCurType()
  {
    return this.mCurType;
  }
  
  public String getCurUin()
  {
    return this.mCurUin;
  }
  
  public String getFrom()
  {
    return this.mFrom;
  }
  
  public int getLoadingStatus()
  {
    return this.mLoadingStatus;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public String getSmallUrl()
  {
    return this.mSmallUrl;
  }
  
  public double getVideoHeight()
  {
    return this.mVideoHeight;
  }
  
  public double getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public boolean isIsAdm()
  {
    return this.mIsAdm;
  }
  
  public void setBigUrl(String paramString)
  {
    this.mBigUrl = paramString;
  }
  
  public void setCurType(int paramInt)
  {
    this.mCurType = paramInt;
  }
  
  public void setCurUin(String paramString)
  {
    this.mCurUin = paramString;
  }
  
  public void setFrom(String paramString)
  {
    this.mFrom = paramString;
  }
  
  public void setIsAdm(boolean paramBoolean)
  {
    this.mIsAdm = paramBoolean;
  }
  
  public void setLoadingStatus(int paramInt)
  {
    this.mLoadingStatus = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setSmallUrl(String paramString)
  {
    this.mSmallUrl = paramString;
  }
  
  public void setVideoHeight(double paramDouble)
  {
    this.mVideoHeight = paramDouble;
  }
  
  public void setVideoWidth(double paramDouble)
  {
    this.mVideoWidth = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData
 * JD-Core Version:    0.7.0.1
 */