package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;

@TargetApi(14)
public class DecodeOutputSurface
{
  public Surface surface;
  public SurfaceTexture surfaceTexture;
  public int textureId;
  
  public DecodeOutputSurface(int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    this.textureId = paramInt;
    this.surfaceTexture = new SurfaceTexture(paramInt);
    this.surfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    this.surface = new Surface(this.surfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeOutputSurface
 * JD-Core Version:    0.7.0.1
 */