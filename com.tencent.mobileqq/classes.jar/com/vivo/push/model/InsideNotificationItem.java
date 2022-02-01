package com.vivo.push.model;

public class InsideNotificationItem
  extends UPSNotificationMessage
{
  private int mAppType;
  private int mInnerPriority;
  private boolean mIsShowBigPicOnMobileNet;
  private int mMessageType;
  private String mReactPackage;
  private String mSuitReactVersion;
  
  public int getAppType()
  {
    return this.mAppType;
  }
  
  public int getInnerPriority()
  {
    return this.mInnerPriority;
  }
  
  public int getMessageType()
  {
    return this.mMessageType;
  }
  
  public String getReactPackage()
  {
    return this.mReactPackage;
  }
  
  public String getSuitReactVersion()
  {
    return this.mSuitReactVersion;
  }
  
  public boolean isShowBigPicOnMobileNet()
  {
    return this.mIsShowBigPicOnMobileNet;
  }
  
  public void setAppType(int paramInt)
  {
    this.mAppType = paramInt;
  }
  
  public void setInnerPriority(int paramInt)
  {
    this.mInnerPriority = paramInt;
  }
  
  public void setIsShowBigPicOnMobileNet(boolean paramBoolean)
  {
    this.mIsShowBigPicOnMobileNet = paramBoolean;
  }
  
  public void setMessageType(int paramInt)
  {
    this.mMessageType = paramInt;
  }
  
  public void setReactPackage(String paramString)
  {
    this.mReactPackage = paramString;
  }
  
  public void setSuitReactVersion(String paramString)
  {
    this.mSuitReactVersion = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.model.InsideNotificationItem
 * JD-Core Version:    0.7.0.1
 */