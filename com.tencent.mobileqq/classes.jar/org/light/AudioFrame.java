package org.light;

import java.nio.ByteBuffer;

public class AudioFrame
{
  public ByteBuffer data;
  public long length;
  public long pts;
  
  public AudioFrame(long paramLong1, long paramLong2, ByteBuffer paramByteBuffer)
  {
    this.pts = paramLong1;
    this.length = paramLong2;
    this.data = paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.AudioFrame
 * JD-Core Version:    0.7.0.1
 */