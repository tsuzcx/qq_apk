package com.tencent.mobileqq.transfile;

public class VideoSliceInfo
{
  public boolean mEncodeFinish;
  public int mIndex;
  public boolean mSendClicked;
  public int mVideoDuration;
  public int mVideoHeight;
  public String mVideoMd5;
  public String mVideoPath;
  public boolean mVideoSyncStory;
  public int mVideoWidth;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoSliceInfo\n");
    localStringBuilder.append("mIndex=").append(this.mIndex);
    localStringBuilder.append(",mVideoDuration=").append(this.mVideoDuration);
    localStringBuilder.append(",mEncodeFinish=").append(this.mEncodeFinish);
    localStringBuilder.append(",mVideoPath(").append(this.mVideoWidth + "*" + this.mVideoHeight).append(")=").append(this.mVideoPath);
    localStringBuilder.append(",mVideoMd5=").append(this.mVideoMd5);
    localStringBuilder.append(",mSendClicked=").append(this.mSendClicked);
    localStringBuilder.append(",mVideoSyncStory=").append(this.mVideoSyncStory);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VideoSliceInfo
 * JD-Core Version:    0.7.0.1
 */