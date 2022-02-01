package org.light;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Build.VERSION;
import android.view.Surface;

public class LightSurface
{
  private long nativeContext;
  
  static
  {
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  public static LightSurface FromSurface(Surface paramSurface, EGLContext paramEGLContext)
  {
    if (paramSurface == null) {
      return null;
    }
    long l2 = 0L;
    long l1 = l2;
    if (paramEGLContext != null)
    {
      l1 = l2;
      if (paramEGLContext != EGL14.EGL_NO_CONTEXT) {
        if (Build.VERSION.SDK_INT >= 21) {
          l1 = paramEGLContext.getNativeHandle();
        } else {
          l1 = paramEGLContext.getHandle();
        }
      }
    }
    return MakeFromSurface(paramSurface, l1);
  }
  
  public static LightSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    return FromSurfaceTexture(paramSurfaceTexture, EGL14.EGL_NO_CONTEXT);
  }
  
  public static LightSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture, EGLContext paramEGLContext)
  {
    if (paramSurfaceTexture == null) {
      return null;
    }
    return FromSurface(new Surface(paramSurfaceTexture), paramEGLContext);
  }
  
  public static LightSurface FromTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return FromTexture(paramInt1, paramInt2, paramInt3, false);
  }
  
  public static LightSurface FromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return MakeFromTexture(paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  private static native LightSurface MakeFromSurface(Surface paramSurface, long paramLong);
  
  private static native LightSurface MakeFromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  protected void finalize()
  {
    super.finalize();
    nativeFinalize();
  }
  
  public native void freeCache();
  
  public native void release();
  
  public native void updateSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.LightSurface
 * JD-Core Version:    0.7.0.1
 */