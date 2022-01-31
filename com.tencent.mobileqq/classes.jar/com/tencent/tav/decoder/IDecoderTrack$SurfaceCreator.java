package com.tencent.tav.decoder;

import android.view.Surface;

public abstract interface IDecoderTrack$SurfaceCreator
{
  public abstract Surface createOutputSurface(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void free(Surface paramSurface);
  
  public abstract void release();
  
  public abstract VideoTexture videoTextureForSurface(Surface paramSurface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator
 * JD-Core Version:    0.7.0.1
 */