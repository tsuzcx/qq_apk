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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("VideoSliceInfo\n");
    localStringBuilder1.append("mIndex=");
    localStringBuilder1.append(this.mIndex);
    localStringBuilder1.append(",mVideoDuration=");
    localStringBuilder1.append(this.mVideoDuration);
    localStringBuilder1.append(",mEncodeFinish=");
    localStringBuilder1.append(this.mEncodeFinish);
    localStringBuilder1.append(",mVideoPath(");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.mVideoWidth);
    localStringBuilder2.append("*");
    localStringBuilder2.append(this.mVideoHeight);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(")=");
    localStringBuilder1.append(this.mVideoPath);
    localStringBuilder1.append(",mVideoMd5=");
    localStringBuilder1.append(this.mVideoMd5);
    localStringBuilder1.append(",mSendClicked=");
    localStringBuilder1.append(this.mSendClicked);
    localStringBuilder1.append(",mVideoSyncStory=");
    localStringBuilder1.append(this.mVideoSyncStory);
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VideoSliceInfo
 * JD-Core Version:    0.7.0.1
 */