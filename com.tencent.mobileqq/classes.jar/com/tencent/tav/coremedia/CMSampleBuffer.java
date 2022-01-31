package com.tencent.tav.coremedia;

import java.nio.ByteBuffer;

public class CMSampleBuffer
{
  private boolean isNewFrame = true;
  private ByteBuffer sampleByteBuffer;
  private TextureInfo texture;
  private CMTime time;
  
  public CMSampleBuffer(CMTime paramCMTime)
  {
    this.time = paramCMTime;
    this.texture = null;
    this.sampleByteBuffer = null;
    this.isNewFrame = false;
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo)
  {
    this.time = paramCMTime;
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    this.time = paramCMTime;
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
    this.isNewFrame = paramBoolean;
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer)
  {
    this.time = paramCMTime;
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this.time = paramCMTime;
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
    this.isNewFrame = paramBoolean;
  }
  
  public ByteBuffer getSampleByteBuffer()
  {
    return this.sampleByteBuffer;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.texture;
  }
  
  public CMTime getTime()
  {
    return this.time;
  }
  
  public boolean isNewFrame()
  {
    return this.isNewFrame;
  }
  
  public void setNewFrame(boolean paramBoolean)
  {
    this.isNewFrame = paramBoolean;
  }
  
  public void setSampleByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.sampleByteBuffer = paramByteBuffer;
  }
  
  public String toString()
  {
    return "CMSampleBuffer{, time=" + this.time + ", texture=" + this.texture + ", sampleByteBuffer=" + this.sampleByteBuffer + ", isNewFrame=" + this.isNewFrame + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleBuffer
 * JD-Core Version:    0.7.0.1
 */