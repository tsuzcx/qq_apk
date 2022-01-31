package com.tencent.qgplayer.rtmpsdk;

import java.util.Arrays;

public class QGAVDownloadProfile
{
  public float bufferSize;
  public int clientEventType;
  public int curChunkBitrate;
  public int curPlayTime;
  public float downloadTime;
  public float duration;
  public int lastChunkBitrate;
  public int lastVideoArchIndex;
  public int nextChunkDuration;
  public float[] nextChunkDurations;
  public float[] nextChunkSize;
  public float[][] nextChunkSizes;
  public float playBufferCurChunkNums;
  public float playBufferMaxchunkNums;
  public int rebufferTime;
  public float remainChunks;
  public float reward;
  public long streamBitrate;
  public boolean terminal;
  public float throughput;
  public int totalPlayTime;
  public int videoTotalChunkNums;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("termianl:");
    localStringBuilder.append(this.terminal);
    localStringBuilder.append(";reward:");
    localStringBuilder.append(this.reward);
    localStringBuilder.append(";throughput:");
    localStringBuilder.append(this.throughput);
    localStringBuilder.append(";downloadTime:");
    localStringBuilder.append(this.downloadTime);
    localStringBuilder.append(";nextChunkSize:");
    localStringBuilder.append(Arrays.toString(this.nextChunkSize));
    localStringBuilder.append(";bufferSize:");
    localStringBuilder.append(this.bufferSize);
    localStringBuilder.append(";remainChunks:");
    localStringBuilder.append(this.remainChunks);
    localStringBuilder.append(";streamBitrate:");
    localStringBuilder.append(this.streamBitrate);
    localStringBuilder.append(";duration:");
    localStringBuilder.append(this.duration);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.QGAVDownloadProfile
 * JD-Core Version:    0.7.0.1
 */