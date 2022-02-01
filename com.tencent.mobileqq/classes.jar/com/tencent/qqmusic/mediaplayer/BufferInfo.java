package com.tencent.qqmusic.mediaplayer;

public class BufferInfo
{
  public int bufferSize;
  public byte[] byteBuffer;
  public byte[] tempByteBuffer;
  
  public void appendByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt1 >= 0) && (paramInt2 > 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length))
    {
      setByteBufferCapacity(this.bufferSize + paramInt2);
      System.arraycopy(paramArrayOfByte, paramInt1, this.byteBuffer, this.bufferSize, paramInt2);
    }
  }
  
  public void fillByte(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt > 0))
    {
      if (paramInt > paramArrayOfByte.length) {
        return;
      }
      this.byteBuffer = paramArrayOfByte;
      this.bufferSize = paramInt;
    }
  }
  
  public BufferInfo fillInto(BufferInfo paramBufferInfo)
  {
    paramBufferInfo.bufferSize = this.bufferSize;
    paramBufferInfo.byteBuffer = this.byteBuffer;
    paramBufferInfo.tempByteBuffer = this.tempByteBuffer;
    return paramBufferInfo;
  }
  
  public void setByteBufferCapacity(int paramInt)
  {
    byte[] arrayOfByte = this.byteBuffer;
    if ((arrayOfByte == null) || (arrayOfByte.length < paramInt)) {
      this.byteBuffer = new byte[paramInt];
    }
  }
  
  public void setTempByteBufferCapacity(int paramInt)
  {
    byte[] arrayOfByte = this.tempByteBuffer;
    if ((arrayOfByte == null) || (arrayOfByte.length < paramInt)) {
      this.tempByteBuffer = new byte[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.BufferInfo
 * JD-Core Version:    0.7.0.1
 */