package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
  extends SkiaCanvasExternalTexturePlugin
{
  private static final String TAG = "SETPluginWithSTDelegate";
  private Map<String, Map<Integer, SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.InstanceDep>> mDepMap = new ConcurrentHashMap();
  
  private Map<Integer, SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.InstanceDep> getInstanceMapForCanvas(String paramString)
  {
    if (!this.mDepMap.containsKey(paramString)) {
      this.mDepMap.put(paramString, new ConcurrentHashMap());
    }
    return (Map)this.mDepMap.get(paramString);
  }
  
  private void initDelegateChain(SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.InstanceDep paramInstanceDep)
  {
    paramInstanceDep.delegatedUpStreamSurface = new SurfaceTexture(0);
    paramInstanceDep.delegatedUpStreamSurface.detachFromGLContext();
    paramInstanceDep.delegate = new SurfaceTextureRenderDelegate(paramInstanceDep.delegatedUpStreamSurface, paramInstanceDep.originDisplaySurface);
  }
  
  protected void onOriginSurfaceChanged(int paramInt, String paramString, SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      paramString = (SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.InstanceDep)getInstanceMapForCanvas(paramString).get(Integer.valueOf(paramInt));
      if ((paramString != null) && (paramString.delegate != null))
      {
        paramString.delegate.removeDownStreamSurfaceTexture(paramString.originDisplaySurface);
        if (paramSurfaceTexture != null)
        {
          paramString.delegate.addDownStreamSurfaceTexture(paramSurfaceTexture);
          paramString.originDisplaySurface = paramSurfaceTexture;
        }
      }
      return;
    }
    finally {}
  }
  
  public void onPluginInstanceDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt, String paramString)
  {
    try
    {
      paramString = (SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.InstanceDep)getInstanceMapForCanvas(paramString).get(Integer.valueOf(paramInt));
      if (paramString != null)
      {
        paramISkiaCanvasExternalTextureHandler = (SurfaceTexture)paramString.delegatedClonedDownStreamSurfaceMap.get(paramISkiaCanvasExternalTextureHandler);
        if (paramISkiaCanvasExternalTextureHandler != null)
        {
          paramString.delegate.removeDownStreamSurfaceTexture(paramISkiaCanvasExternalTextureHandler);
          paramInt = paramString.delegate.getAvailableDownStreamCount();
          paramISkiaCanvasExternalTextureHandler = new StringBuilder();
          paramISkiaCanvasExternalTextureHandler.append("last ");
          paramISkiaCanvasExternalTextureHandler.append(paramInt);
          paramISkiaCanvasExternalTextureHandler.append(" downstream surface.");
          Log.d("SETPluginWithSTDelegate", paramISkiaCanvasExternalTextureHandler.toString());
          if (paramInt == 1)
          {
            paramString.delegate.destroy();
            paramString.delegate = null;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public SkiaCanvasExternalTexturePlugin.PluginLoadResult onPluginInstanceLoad(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    try
    {
      paramString1 = (SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.InstanceDep)getInstanceMapForCanvas(paramString2).get(Integer.valueOf(paramInt));
      if (paramString1 == null)
      {
        paramISkiaCanvasExternalTextureHandler = new SkiaCanvasExternalTexturePlugin.PluginLoadResult(null, -1, -1);
        return paramISkiaCanvasExternalTextureHandler;
      }
      if (paramString1.delegate == null)
      {
        initDelegateChain(paramString1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("replaceDisplaySurface from origin ");
        ((StringBuilder)localObject).append(paramString1.originDisplaySurface);
        ((StringBuilder)localObject).append(" with id ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" appTag ");
        ((StringBuilder)localObject).append(paramString2);
        Log.d("SETPluginWithSTDelegate", ((StringBuilder)localObject).toString());
        replaceDisplaySurface(paramInt, paramString2, paramString1.delegatedUpStreamSurface);
        paramString1.originDisplaySurface.setDefaultBufferSize(paramString1.width, paramString1.height);
        paramString1.delegate.addReleaseCallback(new SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.1(this, paramString1, paramInt, paramString2));
      }
      Object localObject = new SurfaceTexture(0);
      ((SurfaceTexture)localObject).detachFromGLContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add one more downstream surface ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(" with id ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" appTag ");
      localStringBuilder.append(paramString2);
      Log.d("SETPluginWithSTDelegate", localStringBuilder.toString());
      paramString1.delegate.addDownStreamSurfaceTexture((SurfaceTexture)localObject);
      paramString1.delegatedClonedDownStreamSurfaceMap.put(paramISkiaCanvasExternalTextureHandler, localObject);
      paramISkiaCanvasExternalTextureHandler = new SkiaCanvasExternalTexturePlugin.PluginLoadResult((SurfaceTexture)localObject, paramString1.width, paramString1.height);
      return paramISkiaCanvasExternalTextureHandler;
    }
    finally {}
  }
  
  protected void registerInstance(int paramInt1, String paramString, int paramInt2, int paramInt3, SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = new SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.InstanceDep(paramInt2, paramInt3, paramSurfaceTexture);
    getInstanceMapForCanvas(paramString).put(Integer.valueOf(paramInt1), paramSurfaceTexture);
  }
  
  protected abstract void replaceDisplaySurface(int paramInt, String paramString, SurfaceTexture paramSurfaceTexture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
 * JD-Core Version:    0.7.0.1
 */