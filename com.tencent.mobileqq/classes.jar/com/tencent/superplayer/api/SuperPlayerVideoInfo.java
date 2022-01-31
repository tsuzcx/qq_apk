package com.tencent.superplayer.api;

import java.util.Arrays;

public class SuperPlayerVideoInfo
{
  public static final int VIDEO_LIVE_FORMAT_HLS = 104;
  public static final int VIDEO_LIVE_FORMAT_UNKNOWN = 105;
  public static final int VIDEO_SOURCE_DIRECT_URL = 3;
  public static final int VIDEO_SOURCE_TVIDEO = 1;
  public static final int VIDEO_VOD_FORMAT_HLS = 102;
  public static final int VIDEO_VOD_FORMAT_MP4 = 101;
  public static final int VIDEO_VOD_FORMAT_UNKNOWN = 103;
  private int mBusiPlatform;
  private String mFileId;
  private int mFormat;
  private String mLocalSavePath;
  private String mPid;
  private String[] mPlayUrls;
  private String mRequestDefinition;
  private TVideoNetInfo mTVideoNetInfo;
  private String mVid;
  private int mVideoSource;
  private int mVideoType;
  
  protected SuperPlayerVideoInfo(int paramInt)
  {
    this.mVideoSource = paramInt;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = paramInt3;
    this.mVid = paramString;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = paramInt3;
    this.mVid = paramString1;
    this.mPid = paramString2;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = SuperPlayerSDKMgr.getPlatform();
    this.mVid = paramString;
  }
  
  protected SuperPlayerVideoInfo(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mBusiPlatform = SuperPlayerSDKMgr.getPlatform();
    this.mVid = paramString1;
    this.mPid = paramString2;
  }
  
  public int getBusiPlatform()
  {
    return this.mBusiPlatform;
  }
  
  public String getFileId()
  {
    return this.mFileId;
  }
  
  public int getFormat()
  {
    return this.mFormat;
  }
  
  public String getLocalSavePath()
  {
    return this.mLocalSavePath;
  }
  
  public String getPid()
  {
    return this.mPid;
  }
  
  public String getPlayUrl()
  {
    if ((this.mPlayUrls != null) && (this.mPlayUrls.length > 0)) {
      return this.mPlayUrls[0];
    }
    return null;
  }
  
  public String[] getPlayUrls()
  {
    return this.mPlayUrls;
  }
  
  public String getRequestDefinition()
  {
    if (this.mRequestDefinition == null) {
      return "";
    }
    return this.mRequestDefinition;
  }
  
  public TVideoNetInfo getTVideoNetInfo()
  {
    return this.mTVideoNetInfo;
  }
  
  public String getVid()
  {
    return this.mVid;
  }
  
  public int getVideoSource()
  {
    return this.mVideoSource;
  }
  
  public int getVideoType()
  {
    return this.mVideoType;
  }
  
  public void setBusiPlatform(int paramInt)
  {
    this.mBusiPlatform = paramInt;
  }
  
  void setFileId(String paramString)
  {
    this.mFileId = paramString;
  }
  
  public void setFormat(int paramInt)
  {
    this.mFormat = paramInt;
  }
  
  void setLocalSavePath(String paramString)
  {
    this.mLocalSavePath = paramString;
  }
  
  public void setPlayUrl(String paramString)
  {
    this.mPlayUrls = new String[] { paramString };
  }
  
  void setPlayUrl(String[] paramArrayOfString)
  {
    this.mPlayUrls = paramArrayOfString;
  }
  
  public void setRequestDefinition(String paramString)
  {
    this.mRequestDefinition = paramString;
  }
  
  public void setTVideoNetInfo(TVideoNetInfo paramTVideoNetInfo)
  {
    this.mTVideoNetInfo = paramTVideoNetInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperPlayerVideoInfo[ mVideoSource:").append(this.mVideoSource).append("\n");
    localStringBuilder.append("mVideoType:").append(this.mVideoType).append("\n");
    localStringBuilder.append("mBusiPlatform:").append(this.mBusiPlatform).append("\n");
    localStringBuilder.append("mVid:").append(this.mVid).append("\n");
    localStringBuilder.append("mPid:").append(this.mPid).append("\n");
    localStringBuilder.append("mPlayUrls:").append(Arrays.toString(this.mPlayUrls)).append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerVideoInfo
 * JD-Core Version:    0.7.0.1
 */