package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;

@TargetApi(14)
public class DecodeOutputSurface
{
  public int a;
  public SurfaceTexture a;
  public Surface a;
  
  public DecodeOutputSurface(int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(paramInt);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.decoder.DecodeOutputSurface
 * JD-Core Version:    0.7.0.1
 */