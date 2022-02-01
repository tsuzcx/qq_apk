package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;

public class DefaultNativeDataSource
  implements INativeDataSource
{
  private final AudioFormat.AudioType audioType;
  private final long nativeInstance;
  
  public DefaultNativeDataSource(long paramLong, AudioFormat.AudioType paramAudioType)
  {
    this.nativeInstance = paramLong;
    this.audioType = paramAudioType;
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return this.audioType;
  }
  
  public long getNativeInstance()
  {
    return this.nativeInstance;
  }
  
  public String toString()
  {
    return "DefaultNativeDataSource";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultNativeDataSource
 * JD-Core Version:    0.7.0.1
 */