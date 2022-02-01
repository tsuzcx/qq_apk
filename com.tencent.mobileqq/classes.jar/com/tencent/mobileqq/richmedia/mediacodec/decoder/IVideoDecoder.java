package com.tencent.mobileqq.richmedia.mediacodec.decoder;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;

public abstract interface IVideoDecoder
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.IVideoDecoder
 * JD-Core Version:    0.7.0.1
 */