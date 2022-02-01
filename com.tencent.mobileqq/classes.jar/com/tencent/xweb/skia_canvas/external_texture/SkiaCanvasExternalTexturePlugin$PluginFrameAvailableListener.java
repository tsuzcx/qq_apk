package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class SkiaCanvasExternalTexturePlugin$PluginFrameAvailableListener
  implements SurfaceTexture.OnFrameAvailableListener
{
  private ISkiaCanvasExternalTextureHandler mHandler;
  
  SkiaCanvasExternalTexturePlugin$PluginFrameAvailableListener(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler)
  {
    this.mHandler = paramISkiaCanvasExternalTextureHandler;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.mHandler.onFrameAvailable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin.PluginFrameAvailableListener
 * JD-Core Version:    0.7.0.1
 */