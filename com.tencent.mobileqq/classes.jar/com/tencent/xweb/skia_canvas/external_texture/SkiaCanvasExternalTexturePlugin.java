package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SkiaCanvasExternalTexturePlugin
  implements ISkiaCanvasExternalTextureController
{
  private Map<ISkiaCanvasExternalTextureHandler, SkiaCanvasExternalTexturePlugin.PluginLoadResult> mLoadResultMap = new ConcurrentHashMap();
  private Map<ISkiaCanvasExternalTextureHandler, Boolean> mSurfaceTextureAttachedMap = new ConcurrentHashMap();
  
  public boolean load(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    paramString1 = onPluginInstanceLoad(paramISkiaCanvasExternalTextureHandler, paramString1, paramInt, paramString2);
    if ((paramString1.surfaceTexture != null) && (paramString1.height >= 0))
    {
      if (paramString1.width < 0) {
        return false;
      }
      paramString1.surfaceTexture.setOnFrameAvailableListener(new SkiaCanvasExternalTexturePlugin.PluginFrameAvailableListener(paramISkiaCanvasExternalTextureHandler));
      paramString1.surfaceTexture.setDefaultBufferSize(paramString1.width, paramString1.height);
      paramISkiaCanvasExternalTextureHandler.onLoad(paramString1.surfaceTexture, paramString1.width, paramString1.height);
      this.mLoadResultMap.put(paramISkiaCanvasExternalTextureHandler, paramString1);
      this.mSurfaceTextureAttachedMap.put(paramISkiaCanvasExternalTextureHandler, Boolean.valueOf(false));
      return true;
    }
    return false;
  }
  
  public void onDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    onPluginInstanceDestroy(paramISkiaCanvasExternalTextureHandler, paramInt, paramString2);
    this.mLoadResultMap.remove(paramISkiaCanvasExternalTextureHandler);
    this.mSurfaceTextureAttachedMap.remove(paramISkiaCanvasExternalTextureHandler);
  }
  
  public abstract void onPluginInstanceDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt, String paramString);
  
  public SkiaCanvasExternalTexturePlugin.PluginUpdateResult onPluginInstanceImageUpdate(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt1, int paramInt2)
  {
    Boolean localBoolean = (Boolean)this.mSurfaceTextureAttachedMap.get(paramISkiaCanvasExternalTextureHandler);
    SkiaCanvasExternalTexturePlugin.PluginLoadResult localPluginLoadResult = (SkiaCanvasExternalTexturePlugin.PluginLoadResult)this.mLoadResultMap.get(paramISkiaCanvasExternalTextureHandler);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      localPluginLoadResult.surfaceTexture.attachToGLContext(paramInt1);
      this.mSurfaceTextureAttachedMap.put(paramISkiaCanvasExternalTextureHandler, Boolean.valueOf(true));
    }
    localPluginLoadResult.surfaceTexture.updateTexImage();
    paramISkiaCanvasExternalTextureHandler = new float[16];
    localPluginLoadResult.surfaceTexture.getTransformMatrix(paramISkiaCanvasExternalTextureHandler);
    return new SkiaCanvasExternalTexturePlugin.PluginUpdateResult(paramISkiaCanvasExternalTextureHandler);
  }
  
  public abstract SkiaCanvasExternalTexturePlugin.PluginLoadResult onPluginInstanceLoad(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2);
  
  public abstract boolean supportType(String paramString);
  
  public float[] updateImage(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    return onPluginInstanceImageUpdate(paramISkiaCanvasExternalTextureHandler, paramInt1, paramInt2).transform;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin
 * JD-Core Version:    0.7.0.1
 */