package com.tencent.mobileqq.qwallet.hb.emoji;

import java.io.Serializable;

public class ConvertParam
  implements Serializable
{
  public String inPath;
  public int tag;
  public long videoDuration;
  public int videoHeight;
  public int videoWidth;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConvertParam{, videoWidth=");
    localStringBuilder.append(this.videoWidth);
    localStringBuilder.append(", videoHeight=");
    localStringBuilder.append(this.videoHeight);
    localStringBuilder.append(", videoDuration=");
    localStringBuilder.append(this.videoDuration);
    localStringBuilder.append(", tag=");
    localStringBuilder.append(this.tag);
    localStringBuilder.append(", inPath='");
    localStringBuilder.append(this.inPath);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.ConvertParam
 * JD-Core Version:    0.7.0.1
 */