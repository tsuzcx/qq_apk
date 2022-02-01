package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;

public abstract interface INativeDataSource
{
  public abstract AudioFormat.AudioType getAudioType();
  
  public abstract long getNativeInstance();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
 * JD-Core Version:    0.7.0.1
 */