package io.flutter.view;

import android.graphics.SurfaceTexture;

public abstract interface TextureRegistry$SurfaceTextureEntry
{
  public abstract long id();
  
  public abstract void release();
  
  public abstract SurfaceTexture surfaceTexture();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.TextureRegistry.SurfaceTextureEntry
 * JD-Core Version:    0.7.0.1
 */