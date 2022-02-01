package com.tencent.mobileqq.kandian.base.image;

import java.io.File;

public class RIJImageOptBitmapFile
  extends File
{
  private byte[] bitmapBytes;
  private long length;
  
  public RIJImageOptBitmapFile()
  {
    super("");
  }
  
  public RIJImageOptBitmapFile(byte[] paramArrayOfByte, long paramLong)
  {
    super("");
    this.bitmapBytes = paramArrayOfByte;
    this.length = paramLong;
  }
  
  public boolean delete()
  {
    if (this.bitmapBytes != null) {
      this.bitmapBytes = null;
    }
    return true;
  }
  
  public byte[] getBytes()
  {
    return this.bitmapBytes;
  }
  
  public long getLength()
  {
    return this.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RIJImageOptBitmapFile
 * JD-Core Version:    0.7.0.1
 */