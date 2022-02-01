package com.tencent.qqmini.sdk.core.proxy.service;

import java.io.InputStream;

class DownloaderProxyDefault$DownloadTask$PositionFixedInputStream
  extends InputStream
{
  private int markPosition = -1;
  private int position = 0;
  private InputStream proxiedStream;
  
  public DownloaderProxyDefault$DownloadTask$PositionFixedInputStream(DownloaderProxyDefault.DownloadTask paramDownloadTask, InputStream paramInputStream)
  {
    this.proxiedStream = paramInputStream;
  }
  
  public int available()
  {
    return this.proxiedStream.available();
  }
  
  public void close()
  {
    this.proxiedStream.close();
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.markPosition = paramInt;
      this.proxiedStream.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return this.proxiedStream.markSupported();
  }
  
  public int read()
  {
    this.position += 1;
    return this.proxiedStream.read();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    this.position += paramArrayOfByte.length;
    return this.proxiedStream.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.position += paramInt2;
    return this.proxiedStream.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
  {
    try
    {
      this.position = this.markPosition;
      this.proxiedStream.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    return this.proxiedStream.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault.DownloadTask.PositionFixedInputStream
 * JD-Core Version:    0.7.0.1
 */