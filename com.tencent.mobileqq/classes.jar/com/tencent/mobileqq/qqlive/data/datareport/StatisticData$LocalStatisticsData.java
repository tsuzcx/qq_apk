package com.tencent.mobileqq.qqlive.data.datareport;

public class StatisticData$LocalStatisticsData
{
  public int audioBitrate;
  public int audioCaptureState;
  public int audioSampleRate;
  public int frameRate;
  public int height;
  public int streamType;
  public int videoBitrate;
  public int width;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalStatisticsData{width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", frameRate=");
    localStringBuilder.append(this.frameRate);
    localStringBuilder.append(", videoBitrate=");
    localStringBuilder.append(this.videoBitrate);
    localStringBuilder.append(", audioSampleRate=");
    localStringBuilder.append(this.audioSampleRate);
    localStringBuilder.append(", audioBitrate=");
    localStringBuilder.append(this.audioBitrate);
    localStringBuilder.append(", streamType=");
    localStringBuilder.append(this.streamType);
    localStringBuilder.append(", audioCaptureState=");
    localStringBuilder.append(this.audioCaptureState);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.datareport.StatisticData.LocalStatisticsData
 * JD-Core Version:    0.7.0.1
 */