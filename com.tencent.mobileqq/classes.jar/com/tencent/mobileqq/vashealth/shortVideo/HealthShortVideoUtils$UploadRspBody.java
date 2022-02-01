package com.tencent.mobileqq.vashealth.shortVideo;

import java.nio.ByteBuffer;

class HealthShortVideoUtils$UploadRspBody
{
  public final int a;
  public final long b;
  public final long c;
  
  public HealthShortVideoUtils$UploadRspBody(ByteBuffer paramByteBuffer)
  {
    this.a = (paramByteBuffer.get() & 0xFFFF);
    this.b = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.c = (paramByteBuffer.getInt() & 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.shortVideo.HealthShortVideoUtils.UploadRspBody
 * JD-Core Version:    0.7.0.1
 */