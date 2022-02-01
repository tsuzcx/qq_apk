package com.tencent.rtmp;

import java.util.Map;

public class TXLivePlayConfig
{
  boolean mAutoAdjustCacheTime = true;
  boolean mAutoRotate = true;
  String mCacheFolderPath;
  float mCacheTime = 5.0F;
  int mConnectRetryCount = 3;
  int mConnectRetryInterval = 3;
  boolean mEnableAec = false;
  boolean mEnableMessage = false;
  boolean mEnableMetaData = false;
  boolean mEnableNearestIP = true;
  String mFlvSessionKey = "";
  protected Map<String, String> mHeaders;
  float mMaxAutoAdjustCacheTime = 5.0F;
  int mMaxCacheItems;
  float mMinAutoAdjustCacheTime = 1.0F;
  int mRtmpChannelType = 0;
  int mVideoBlockThreshold = 800;
  
  public void enableAEC(boolean paramBoolean)
  {
    this.mEnableAec = paramBoolean;
  }
  
  public void setAutoAdjustCacheTime(boolean paramBoolean)
  {
    this.mAutoAdjustCacheTime = paramBoolean;
  }
  
  @Deprecated
  public void setCacheFolderPath(String paramString)
  {
    this.mCacheFolderPath = paramString;
  }
  
  public void setCacheTime(float paramFloat)
  {
    this.mCacheTime = paramFloat;
  }
  
  public void setConnectRetryCount(int paramInt)
  {
    this.mConnectRetryCount = paramInt;
  }
  
  public void setConnectRetryInterval(int paramInt)
  {
    this.mConnectRetryInterval = paramInt;
  }
  
  public void setEnableMessage(boolean paramBoolean)
  {
    this.mEnableMessage = paramBoolean;
  }
  
  public void setEnableMetaData(boolean paramBoolean)
  {
    this.mEnableMetaData = paramBoolean;
  }
  
  @Deprecated
  public void setEnableNearestIP(boolean paramBoolean)
  {
    this.mEnableNearestIP = paramBoolean;
  }
  
  public void setFlvSessionKey(String paramString)
  {
    this.mFlvSessionKey = paramString;
  }
  
  @Deprecated
  public void setHeaders(Map<String, String> paramMap)
  {
    this.mHeaders = paramMap;
  }
  
  public void setMaxAutoAdjustCacheTime(float paramFloat)
  {
    this.mMaxAutoAdjustCacheTime = paramFloat;
  }
  
  @Deprecated
  public void setMaxCacheItems(int paramInt)
  {
    this.mMaxCacheItems = paramInt;
  }
  
  public void setMinAutoAdjustCacheTime(float paramFloat)
  {
    this.mMinAutoAdjustCacheTime = paramFloat;
  }
  
  @Deprecated
  public void setRtmpChannelType(int paramInt)
  {
    this.mRtmpChannelType = paramInt;
  }
  
  public void setVideoBlockThreshold(int paramInt)
  {
    this.mVideoBlockThreshold = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{mCacheTime=");
    localStringBuilder.append(this.mCacheTime);
    localStringBuilder.append(", mMaxAutoAdjustCacheTime=");
    localStringBuilder.append(this.mMaxAutoAdjustCacheTime);
    localStringBuilder.append(", mMinAutoAdjustCacheTime=");
    localStringBuilder.append(this.mMinAutoAdjustCacheTime);
    localStringBuilder.append(", mAutoAdjustCacheTime=");
    localStringBuilder.append(this.mAutoAdjustCacheTime);
    localStringBuilder.append(", mVideoBlockThreshold=");
    localStringBuilder.append(this.mVideoBlockThreshold);
    localStringBuilder.append(", mConnectRetryCount=");
    localStringBuilder.append(this.mConnectRetryCount);
    localStringBuilder.append(", mConnectRetryInterval=");
    localStringBuilder.append(this.mConnectRetryInterval);
    localStringBuilder.append(", mEnableAec=");
    localStringBuilder.append(this.mEnableAec);
    localStringBuilder.append(", mEnableMessage=");
    localStringBuilder.append(this.mEnableMessage);
    localStringBuilder.append(", mEnableMetaData=");
    localStringBuilder.append(this.mEnableMetaData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePlayConfig
 * JD-Core Version:    0.7.0.1
 */