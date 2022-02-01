package org.light;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Build.VERSION;

public class LightTestCase
{
  private long nativeContext = 0L;
  
  static
  {
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  public static native LightTestCase Make(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, float paramFloat, long paramLong);
  
  public static LightTestCase Make(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, float paramFloat, EGLContext paramEGLContext)
  {
    if (paramEGLContext == null) {
      return null;
    }
    long l = 0L;
    if (paramEGLContext != EGL14.EGL_NO_CONTEXT) {
      if (Build.VERSION.SDK_INT < 21) {
        break label49;
      }
    }
    label49:
    for (l = paramEGLContext.getNativeHandle();; l = paramEGLContext.getHandle()) {
      return Make(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramFloat, l);
    }
  }
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  private native void nativeRelease();
  
  protected void finalize()
  {
    super.finalize();
    nativeFinalize();
  }
  
  public void release()
  {
    nativeRelease();
  }
  
  public native LightTestResult run();
  
  public native void setFrameInterval(long paramLong);
  
  public native void setSaveResultDirectory(String paramString);
  
  public native void setSimilarityThreshold(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.LightTestCase
 * JD-Core Version:    0.7.0.1
 */