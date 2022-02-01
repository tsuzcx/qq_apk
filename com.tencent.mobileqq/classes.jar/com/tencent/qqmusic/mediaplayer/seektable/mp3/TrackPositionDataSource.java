package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

class TrackPositionDataSource
{
  private final IDataSource mDataSource;
  private long mPosition = 0L;
  
  TrackPositionDataSource(IDataSource paramIDataSource)
  {
    this.mDataSource = paramIDataSource;
  }
  
  public long getCurPosition()
  {
    return this.mPosition;
  }
  
  public long getSize()
  {
    return this.mDataSource.getSize();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = this.mDataSource.readAt(this.mPosition, paramArrayOfByte, 0, paramInt);
    this.mPosition += paramInt;
    return paramInt;
  }
  
  public long seek(long paramLong)
  {
    if (paramLong < this.mDataSource.getSize())
    {
      this.mPosition = paramLong;
      return paramLong;
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.mp3.TrackPositionDataSource
 * JD-Core Version:    0.7.0.1
 */