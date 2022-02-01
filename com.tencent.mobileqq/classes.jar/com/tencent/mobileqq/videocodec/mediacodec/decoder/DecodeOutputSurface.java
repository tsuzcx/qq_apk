package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;

@TargetApi(14)
public class DecodeOutputSurface
{
  public Surface a;
  public int b;
  public SurfaceTexture c;
  
  public DecodeOutputSurface(int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    this.b = paramInt;
    this.c = new SurfaceTexture(paramInt);
    this.c.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    this.a = new Surface(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.decoder.DecodeOutputSurface
 * JD-Core Version:    0.7.0.1
 */