package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.view.Surface;

public final class PreloadSurface
  extends Surface
{
  @NonNull
  private final SurfaceTexture surfaceTexture;
  
  public PreloadSurface(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    super(paramSurfaceTexture);
    this.surfaceTexture = paramSurfaceTexture;
  }
  
  @NonNull
  public final SurfaceTexture getSurfaceTexture()
  {
    return this.surfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.PreloadSurface
 * JD-Core Version:    0.7.0.1
 */