package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import java.io.Closeable;

public abstract interface IDataSource
  extends Closeable
{
  public abstract AudioFormat.AudioType getAudioType();
  
  public abstract long getSize();
  
  public abstract void open();
  
  public abstract int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.IDataSource
 * JD-Core Version:    0.7.0.1
 */