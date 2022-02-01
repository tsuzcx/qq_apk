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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mType = ");
    localStringBuilder.append(this.mType);
    localStringBuilder.append(", mPath = ");
    localStringBuilder.append(this.mPath);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.data.PublishMoodInfo.MediaInfo
 * JD-Core Version:    0.7.0.1
 */