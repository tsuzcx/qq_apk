package com.tencent.mtt.hippy.adapter.image;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferInputStream
  extends InputStream
{
  private final ByteBuffer byteBuffer;
  private int markPos = -1;
  
  ByteBufferInputStream(ByteBuffer paramByteBuffer)
  {
    this.byteBuffer = paramByteBuffer;
    paramByteBuffer.flip();
  }
  
  public int available()
  {
    return this.byteBuffer.remaining();
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.markPos = this.byteBuffer.position();
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
    return true;
  }
  
  public int read()
  {
    if (!this.byteBuffer.hasRemaining()) {
      return -1;
    }
    return this.byteBuffer.get();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.byteBuffer.hasRemaining()) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, available());
    this.byteBuffer.get(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
  
  public void reset()
  {
    try
    {
      if (this.markPos == -1) {
        throw new IOException("Cannot reset to unset mark position");
      }
    }
    finally {}
    this.byteBuffer.position(this.markPos);
  }
  
  public long skip(long paramLong)
  {
    if (!this.byteBuffer.hasRemaining()) {
      return -1L;
    }
    paramLong = Math.min(paramLong, available());
    this.byteBuffer.position((int)(this.byteBuffer.position() + paramLong));
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.image.ByteBufferInputStream
 * JD-Core Version:    0.7.0.1
 */