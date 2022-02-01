package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;

@TargetApi(14)
public class DecodeOutputSurface
{
  public Surface a;
  public int b;
  
  DecodeOutputSurface(int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    this.b = paramInt;
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(paramInt);
    localSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    this.a = new Surface(localSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.DecodeOutputSurface
 * JD-Core Version:    0.7.0.1
 */