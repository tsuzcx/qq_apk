package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDataSource
  implements IDataSource
{
  private long currentPosition;
  private InputStream currentStream;
  private final InputStreamDataSource.InputStreamFactory factory;
  private long size;
  
  public InputStreamDataSource(InputStreamDataSource.InputStreamFactory paramInputStreamFactory)
  {
    this.factory = paramInputStreamFactory;
  }
  
  public void close()
  {
    InputStream localInputStream = this.currentStream;
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return FormatDetector.getAudioFormat(this, false);
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public void open()
  {
    InputStream localInputStream = this.currentStream;
    if (localInputStream != null) {
      localInputStream.close();
    }
    this.currentStream = this.factory.create();
    this.size = this.currentStream.available();
    this.currentPosition = 0L;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = this.currentPosition;
    if (paramLong < l1)
    {
      open();
      return readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    }
    if (paramLong > l1)
    {
      l1 = paramLong - l1;
      long l3;
      long l2;
      do
      {
        do
        {
          l3 = this.currentStream.skip(l1);
          l2 = l1 - l3;
          l1 = l2;
        } while (l2 > 0L);
        l1 = l2;
      } while (l3 <= 0L);
      if (l2 >= 0L) {
        this.currentPosition = paramLong;
      } else {
        throw new IOException("skipped too much bytes");
      }
    }
    paramInt1 = this.currentStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 > 0) {
      this.currentPosition += paramInt1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.InputStreamDataSource
 * JD-Core Version:    0.7.0.1
 */