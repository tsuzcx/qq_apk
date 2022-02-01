package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$1
  implements Runnable
{
  SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$1(SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate paramSkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate, SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.InstanceDep paramInstanceDep, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("replaceDisplaySurface to origin ");
    ((StringBuilder)localObject1).append(this.val$dep.originDisplaySurface);
    ((StringBuilder)localObject1).append(" with id ");
    ((StringBuilder)localObject1).append(this.val$id);
    ((StringBuilder)localObject1).append(" appTag ");
    ((StringBuilder)localObject1).append(this.val$appTag);
    Log.d("SETPluginWithSTDelegate", ((StringBuilder)localObject1).toString());
    this.this$0.replaceDisplaySurface(this.val$id, this.val$appTag, this.val$dep.originDisplaySurface);
    localObject1 = this.val$dep.delegatedClonedDownStreamSurfaceMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ISkiaCanvasExternalTextureHandler)((Iterator)localObject1).next();
      localObject2 = (SurfaceTexture)this.val$dep.delegatedClonedDownStreamSurfaceMap.get(localObject2);
      if (localObject2 != null) {
        ((SurfaceTexture)localObject2).release();
      }
    }
    this.val$dep.delegatedUpStreamSurface.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate.1
 * JD-Core Version:    0.7.0.1
 */