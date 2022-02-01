package com.tencent.xweb.skia_canvas.external_texture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SkiaCanvasExternalTextureManager
  implements ISkiaCanvasExternalTextureController
{
  private static final String TAG = "ExternalTextureManager";
  private List<SkiaCanvasExternalTexturePlugin> mPluginList = new ArrayList();
  
  private SkiaCanvasExternalTexturePlugin findPlugin(String paramString)
  {
    try
    {
      Iterator localIterator = this.mPluginList.iterator();
      while (localIterator.hasNext())
      {
        SkiaCanvasExternalTexturePlugin localSkiaCanvasExternalTexturePlugin = (SkiaCanvasExternalTexturePlugin)localIterator.next();
        boolean bool = localSkiaCanvasExternalTexturePlugin.supportType(paramString);
        if (bool) {
          return localSkiaCanvasExternalTexturePlugin;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static SkiaCanvasExternalTextureManager getInstance()
  {
    return SkiaCanvasExternalTextureManager.Holder.INSTANCE;
  }
  
  public boolean load(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    SkiaCanvasExternalTexturePlugin localSkiaCanvasExternalTexturePlugin = findPlugin(paramString1);
    if (localSkiaCanvasExternalTexturePlugin != null) {
      return localSkiaCanvasExternalTexturePlugin.load(paramISkiaCanvasExternalTextureHandler, paramString1, paramInt, paramString2);
    }
    return false;
  }
  
  public void onDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    SkiaCanvasExternalTexturePlugin localSkiaCanvasExternalTexturePlugin = findPlugin(paramString1);
    if (localSkiaCanvasExternalTexturePlugin != null) {
      localSkiaCanvasExternalTexturePlugin.onDestroy(paramISkiaCanvasExternalTextureHandler, paramString1, paramInt, paramString2);
    }
  }
  
  public void registerPlugin(SkiaCanvasExternalTexturePlugin paramSkiaCanvasExternalTexturePlugin)
  {
    try
    {
      this.mPluginList.add(paramSkiaCanvasExternalTexturePlugin);
      return;
    }
    finally
    {
      paramSkiaCanvasExternalTexturePlugin = finally;
      throw paramSkiaCanvasExternalTexturePlugin;
    }
  }
  
  public float[] updateImage(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    SkiaCanvasExternalTexturePlugin localSkiaCanvasExternalTexturePlugin = findPlugin(paramString1);
    if (localSkiaCanvasExternalTexturePlugin != null) {
      return localSkiaCanvasExternalTexturePlugin.updateImage(paramISkiaCanvasExternalTextureHandler, paramInt1, paramString1, paramInt2, paramString2);
    }
    return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTextureManager
 * JD-Core Version:    0.7.0.1
 */