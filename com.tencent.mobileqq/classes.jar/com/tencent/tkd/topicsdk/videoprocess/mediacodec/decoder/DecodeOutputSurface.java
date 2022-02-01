package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;

@TargetApi(14)
public class DecodeOutputSurface
{
  public int a;
  public Surface a;
  
  DecodeOutputSurface(int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(paramInt);
    localSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(localSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.DecodeOutputSurface
 * JD-Core Version:    0.7.0.1
 */