package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;
import java.nio.ByteBuffer;

public class CMSampleBuffer
{
  private ByteBuffer sampleByteBuffer;
  @NonNull
  private final CMSampleState state;
  private TextureInfo texture;
  
  public CMSampleBuffer(@NonNull CMSampleState paramCMSampleState)
  {
    this.state = paramCMSampleState;
    this.state.setNewFrame(false);
    this.texture = null;
    this.sampleByteBuffer = null;
  }
  
  public CMSampleBuffer(@NonNull CMSampleState paramCMSampleState, TextureInfo paramTextureInfo)
  {
    this.state = paramCMSampleState;
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
  }
  
  public CMSampleBuffer(@NonNull CMSampleState paramCMSampleState, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.texture = paramTextureInfo;
    this.sampleByteBuffer = null;
  }
  
  public CMSampleBuffer(@NonNull CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer)
  {
    this.state = paramCMSampleState;
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
  }
  
  public CMSampleBuffer(@NonNull CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this.state = paramCMSampleState;
    this.state.setNewFrame(paramBoolean);
    this.sampleByteBuffer = paramByteBuffer;
    this.texture = null;
  }
  
  public CMSampleBuffer(CMTime paramCMTime)
  {
    this(new CMSampleState(paramCMTime));
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramTextureInfo, paramBoolean);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer);
  }
  
  public CMSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this(new CMSampleState(paramCMTime), paramByteBuffer, paramBoolean);
  }
  
  public ByteBuffer getSampleByteBuffer()
  {
    return this.sampleByteBuffer;
  }
  
  @NonNull
  public CMSampleState getState()
  {
    return this.state;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.texture;
  }
  
  @NonNull
  public CMTime getTime()
  {
    return this.state.getTime();
  }
  
  public boolean isNewFrame()
  {
    return this.state.isNewFrame();
  }
  
  public void setNewFrame(boolean paramBoolean)
  {
    this.state.setNewFrame(paramBoolean);
  }
  
  public void setSampleByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.sampleByteBuffer = paramByteBuffer;
  }
  
  public String toString()
  {
    return "CMSampleBuffer{, state=" + this.state + ", texture=" + this.texture + ", sampleByteBuffer=" + this.sampleByteBuffer + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMSampleBuffer
 * JD-Core Version:    0.7.0.1
 */