package com.tencent.mobileqq.minigame.data;

public class PublishMoodInfo$MediaInfo
{
  public static final int TYPE_PHOTO = 1;
  public static final int TYPE_VIDEO = 2;
  public String mPath;
  public int mType;
  
  public PublishMoodInfo$MediaInfo() {}
  
  PublishMoodInfo$MediaInfo(int paramInt, String paramString)
  {
    this.mType = paramInt;
    this.mPath = paramString;
  }
  
  public String toString()
  {
    return "mType = " + this.mType + ", mPath = " + this.mPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo
 * JD-Core Version:    0.7.0.1
 */