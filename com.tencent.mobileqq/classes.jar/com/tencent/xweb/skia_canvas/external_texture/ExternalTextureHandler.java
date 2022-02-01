package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.util.Log;

public class ExternalTextureHandler
  implements ISkiaCanvasExternalTextureHandler
{
  private volatile boolean mIsDestroyed;
  private volatile long mNativePeer;
  
  private ExternalTextureHandler(long paramLong)
  {
    this.mNativePeer = paramLong;
  }
  
  public static ExternalTextureHandler create(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create with ");
    localStringBuilder.append(paramLong);
    Log.d("ExternalTextureHandler", localStringBuilder.toString());
    return new ExternalTextureHandler(paramLong);
  }
  
  private boolean isValid()
  {
    return this.mIsDestroyed ^ true;
  }
  
  private boolean load(String paramString1, int paramInt, String paramString2)
  {
    return SkiaCanvasExternalTextureManager.getInstance().load(this, paramString1, paramInt, paramString2);
  }
  
  private native void nativeOnFrameAvailable(long paramLong);
  
  private native void nativeOnLoad(long paramLong, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);
  
  private void notifyDestroyed(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      Log.d("ExternalTextureHandler", "notifyDestroyed");
      onDestroy(paramString1, paramInt, paramString2);
      this.mIsDestroyed = true;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private void onDestroy(String paramString1, int paramInt, String paramString2)
  {
    SkiaCanvasExternalTextureManager.getInstance().onDestroy(this, paramString1, paramInt, paramString2);
  }
  
  private float[] updateImage(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    return SkiaCanvasExternalTextureManager.getInstance().updateImage(this, paramInt1, paramString1, paramInt2, paramString2);
  }
  
  public void onFrameAvailable()
  {
    try
    {
      if (isValid()) {
        nativeOnFrameAvailable(this.mNativePeer);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onLoad(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (isValid()) {
      nativeOnLoad(this.mNativePeer, paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.ExternalTextureHandler
 * JD-Core Version:    0.7.0.1
 */