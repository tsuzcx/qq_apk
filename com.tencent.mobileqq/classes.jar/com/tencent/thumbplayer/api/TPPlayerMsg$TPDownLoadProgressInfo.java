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
    return "TPDownLoadProgressInfo{playableDurationMS=" + this.playableDurationMS + ", downloadSpeedKBps=" + this.downloadSpeedKBps + ", currentDownloadSize=" + this.currentDownloadSize + ", totalFileSize=" + this.totalFileSize + ", extraInfo='" + this.extraInfo + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo
 * JD-Core Version:    0.7.0.1
 */