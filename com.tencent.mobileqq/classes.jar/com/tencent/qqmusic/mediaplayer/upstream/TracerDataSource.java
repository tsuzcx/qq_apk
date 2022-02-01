package com.tencent.qqmusic.mediaplayer.upstream;

import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class TracerDataSource
  implements IDataSource
{
  private static final String TAG = "TracerDataSource";
  @NonNull
  private final IDataSource impl;
  
  public TracerDataSource(@NonNull IDataSource paramIDataSource)
  {
    this.impl = paramIDataSource;
  }
  
  public void close()
  {
    try
    {
      this.impl.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[close] failed!", localThrowable);
      throw localThrowable;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return this.impl.equals(paramObject);
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    try
    {
      AudioFormat.AudioType localAudioType = this.impl.getAudioType();
      return localAudioType;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[getAudioType] failed!", localThrowable);
      throw localThrowable;
    }
  }
  
  public long getSize()
  {
    try
    {
      long l = this.impl.getSize();
      return l;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[getSize] failed!", localThrowable);
      throw localThrowable;
    }
  }
  
  public int hashCode()
  {
    return this.impl.hashCode();
  }
  
  public void open()
  {
    try
    {
      this.impl.open();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[open] failed!", localThrowable);
      throw localThrowable;
    }
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      int i = this.impl.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      return i;
    }
    catch (Throwable paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[readAt] failed! pos = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", offset = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", size = ");
      localStringBuilder.append(paramInt2);
      Logger.e("TracerDataSource", localStringBuilder.toString(), paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public String toString()
  {
    return this.impl.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.TracerDataSource
 * JD-Core Version:    0.7.0.1
 */