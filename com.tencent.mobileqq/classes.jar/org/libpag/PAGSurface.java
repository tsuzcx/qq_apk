package org.libpag;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Build.VERSION;
import android.view.Surface;
import java.util.HashMap;
import org.extra.tools.LibraryLoadUtils;
import org.libpag.reporter.AVReportCenter;

public class PAGSurface
{
  long nativeSurface = 0L;
  private Surface surface = null;
  private int textureID = 0;
  
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
    PAGFont.loadSystemFonts();
    if (LibraryLoadUtils.getAppContext() != null) {
      AVReportCenter.getInstance().init(LibraryLoadUtils.getAppContext());
    }
  }
  
  private PAGSurface(long paramLong)
  {
    this.nativeSurface = paramLong;
  }
  
  public static PAGSurface FromSurface(Surface paramSurface)
  {
    return FromSurface(paramSurface, EGL14.EGL_NO_CONTEXT);
  }
  
  public static PAGSurface FromSurface(Surface paramSurface, EGLContext paramEGLContext)
  {
    if (paramSurface == null) {
      return null;
    }
    long l;
    if ((paramEGLContext != null) && (paramEGLContext != EGL14.EGL_NO_CONTEXT)) {
      if (Build.VERSION.SDK_INT >= 21) {
        l = paramEGLContext.getNativeHandle();
      }
    }
    for (;;)
    {
      l = SetupFromSurfaceWithGLContext(paramSurface, l);
      if (l == 0L)
      {
        return null;
        l = paramEGLContext.getHandle();
      }
      else
      {
        paramEGLContext = new PAGSurface(l);
        paramEGLContext.surface = paramSurface;
        return paramEGLContext;
        l = 0L;
      }
    }
  }
  
  public static PAGSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    return FromSurfaceTexture(paramSurfaceTexture, EGL14.EGL_NO_CONTEXT);
  }
  
  public static PAGSurface FromSurfaceTexture(SurfaceTexture paramSurfaceTexture, EGLContext paramEGLContext)
  {
    if (paramSurfaceTexture == null) {
      return null;
    }
    return FromSurface(new Surface(paramSurfaceTexture), paramEGLContext);
  }
  
  public static PAGSurface FromTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return FromTexture(paramInt1, paramInt2, paramInt3, false);
  }
  
  public static PAGSurface FromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l = SetupFromTexture(paramInt1, paramInt2, paramInt3, paramBoolean);
    if (l == 0L) {
      return null;
    }
    PAGSurface localPAGSurface = new PAGSurface(l);
    localPAGSurface.textureID = paramInt1;
    return localPAGSurface;
  }
  
  public static void OnReportData(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
      return;
    }
    AVReportCenter.getInstance().commit(paramHashMap);
  }
  
  private static native long SetupFromSurfaceWithGLContext(Surface paramSurface, long paramLong);
  
  public static native long SetupFromTexture(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  private native void nativeRelease();
  
  protected void finalize()
  {
    nativeFinalize();
  }
  
  public native void freeCache();
  
  public native int height();
  
  public native boolean present();
  
  public void release()
  {
    nativeRelease();
  }
  
  public native void updateSize();
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     org.libpag.PAGSurface
 * JD-Core Version:    0.7.0.1
 */