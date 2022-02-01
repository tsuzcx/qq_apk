package com.tencent.thumbplayer.api;

public class TPPlayerMsg$TPDownLoadProgressInfo
{
  public long currentDownloadSize;
  public int downloadSpeedKBps;
  public String extraInfo;
  public long playableDurationMS;
  public long totalFileSize;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TPDownLoadProgressInfo{playableDurationMS=");
    localStringBuilder.append(this.playableDurationMS);
    localStringBuilder.append(", downloadSpeedKBps=");
    localStringBuilder.append(this.downloadSpeedKBps);
    localStringBuilder.append(", currentDownloadSize=");
    localStringBuilder.append(this.currentDownloadSize);
    localStringBuilder.append(", totalFileSize=");
    localStringBuilder.append(this.totalFileSize);
    localStringBuilder.append(", extraInfo='");
    localStringBuilder.append(this.extraInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo
 * JD-Core Version:    0.7.0.1
 */