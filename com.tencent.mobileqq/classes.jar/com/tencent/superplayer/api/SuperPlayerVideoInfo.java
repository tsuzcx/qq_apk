package com.tencent.superplayer.api;

public class SuperPlayerVideoInfo
{
  public static final int LIVE_STREAM_FORMAT_FLV = 202;
  public static final int LIVE_STREAM_FORMAT_HLS = 201;
  public static final int LIVE_STREAM_FORMAT_UNKNOWN = 203;
  public static final int VIDEO_SOURCE_LOCAL = 3;
  public static final int VIDEO_SOURCE_TVIDEO = 1;
  public static final int VIDEO_TYPE_LOCAL = 3;
  public static final int VIDEO_TYPE_ONLINE_LIVE = 2;
  public static final int VIDEO_TYPE_ONLINE_VOD = 1;
  public static final int VOD_STREAM_FORMAT_HLS = 102;
  public static final int VOD_STREAM_FORMAT_MP4 = 101;
  public static final int VOD_STREAM_FORMAT_UNKNOWN = 103;
  private String mFileId;
  private int mFormat;
  private String mLocalSavePath;
  private String mPid;
  private String[] mPlayUrls;
  private String mVid;
  private int mVideoSource;
  private int mVideoType;
  
  public SuperPlayerVideoInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mVid = paramString;
  }
  
  public SuperPlayerVideoInfo(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.mVideoSource = paramInt1;
    this.mVideoType = paramInt2;
    this.mVid = paramString1;
    this.mPid = paramString2;
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
  
  public void setFileId(String paramString)
  {
    this.mFileId = paramString;
  }
  
  public void setLocalSavePath(String paramString)
  {
    this.mLocalSavePath = paramString;
  }
  
  public void setPlayUrl(String paramString)
  {
    this.mPlayUrls = new String[] { paramString };
  }
  
  public void setPlayUrls(String[] paramArrayOfString)
  {
    this.mPlayUrls = paramArrayOfString;
  }
  
  public void setVideoInfo(String paramString, int paramInt)
  {
    this.mPlayUrls = new String[] { paramString };
    this.mFormat = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FCCPlayerVideoInfo[ mVideoSource:").append(this.mVideoSource).append("\n");
    localStringBuilder.append("mVideoType:").append(this.mVideoType).append("\n");
    localStringBuilder.append("mVid:").append(this.mVid).append("\n");
    localStringBuilder.append("mPid:").append(this.mPid).append("\n");
    localStringBuilder.append("mPlayUrls:").append(this.mPlayUrls).append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerVideoInfo
 * JD-Core Version:    0.7.0.1
 */