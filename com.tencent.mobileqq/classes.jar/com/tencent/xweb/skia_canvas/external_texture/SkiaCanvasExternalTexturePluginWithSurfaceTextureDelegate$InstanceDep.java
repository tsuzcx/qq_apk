package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import java.util.HashMap;
import java.util.Map;

class SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep
{
  SurfaceTextureRenderDelegate delegate;
  Map<ISkiaCanvasExternalTextureHandler, SurfaceTexture> delegatedClonedDownStreamSurfaceMap;
  SurfaceTexture delegatedUpStreamSurface;
  final int height;
  SurfaceTexture originDisplaySurface;
  final int width;
  
  SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep(int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.originDisplaySurface = paramSurfaceTexture;
    this.delegatedClonedDownStreamSurfaceMap = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.InstanceDep
 * JD-Core Version:    0.7.0.1
 */