package com.tencent.mobileqq.shortvideo.eglwraper;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.sveffects.SLog;

@TargetApi(18)
public final class EglCore
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  public static final int FLAG_RECORDABLE = 1;
  public static final int FLAG_TRY_GLES3 = 2;
  private static final String TAG = "EglCore";
  private EGLConfig mEGLConfig = null;
  private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
  
  public EglCore(EGLContext paramEGLContext, int paramInt)
  {
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("EGL already set up");
    }
    EGLContext localEGLContext1 = paramEGLContext;
    if (paramEGLContext == null)
    {
      localEGLContext1 = EGL14.EGL_NO_CONTEXT;
      SLog.e("EglCore", "sharedContext == null");
    }
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    paramEGLContext = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, paramEGLContext, 0, paramEGLContext, 1))
    {
      this.mEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    if ((paramInt & 0x2) != 0)
    {
      paramEGLContext = getConfig(paramInt, 3);
      if (paramEGLContext != null)
      {
        EGLContext localEGLContext2 = EGL14.eglCreateContext(this.mEGLDisplay, paramEGLContext, localEGLContext1, new int[] { 12440, 3, 12344 }, 0);
        if (EGL14.eglGetError() == 12288)
        {
          this.mEGLConfig = paramEGLContext;
          this.mEGLContext = localEGLContext2;
        }
      }
    }
    if (this.mEGLContext == EGL14.EGL_NO_CONTEXT)
    {
      paramEGLContext = getConfig(paramInt, 2);
      if (paramEGLContext == null) {
        throw new RuntimeException("Unable to find a suitable EGLConfig");
      }
      localEGLContext1 = EGL14.eglCreateContext(this.mEGLDisplay, paramEGLContext, localEGLContext1, new int[] { 12440, 2, 12344 }, 0);
      checkEglError("eglCreateContext");
      this.mEGLConfig = paramEGLContext;
      this.mEGLContext = localEGLContext1;
    }
    paramEGLContext = new int[1];
    EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, 12440, paramEGLContext, 0);
    if (SLog.isEnable()) {
      SLog.d("EglCore", "EGLContext created, client version " + paramEGLContext[0]);
    }
  }
  
  private void checkEglError(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288) {
      SLog.e("EglCore", new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i)));
    }
  }
  
  private EGLConfig getConfig(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 3) {}
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.mEGLDisplay;
    paramInt1 = arrayOfEGLConfig.length;
    if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, arrayOfEGLConfig, 0, paramInt1, arrayOfInt, 0))
    {
      if (SLog.isEnable()) {
        SLog.w("EglCore", "unable to find RGB8888 / " + paramInt2 + " EGLConfig");
      }
      return null;
    }
    return arrayOfEGLConfig[0];
  }
  
  public EGLSurface createOffscreenSurface(int paramInt1, int paramInt2)
  {
    EGLSurface localEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    checkEglError("eglCreatePbufferSurface");
    if (localEGLSurface == null) {
      throw new RuntimeException("surface was null");
    }
    return localEGLSurface;
  }
  
  public EGLSurface createWindowSurface(Object paramObject)
  {
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture))) {
      throw new RuntimeException("invalid surface: " + paramObject);
    }
    paramObject = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, paramObject, new int[] { 12344 }, 0);
    checkEglError("eglCreateWindowSurface");
    if (paramObject == null) {
      throw new RuntimeException("surface was null");
    }
    return paramObject;
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
      {
        if (SLog.isEnable()) {
          SLog.w("EglCore", "WARNING: EglCore was not explicitly released -- state may be leaked");
        }
        release();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void makeCurrent(EGLSurface paramEGLSurface)
  {
    if ((this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) && (SLog.isEnable())) {
      SLog.d("EglCore", "NOTE: makeCurrent w/o display");
    }
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, paramEGLSurface, paramEGLSurface, this.mEGLContext)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  public void release()
  {
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
    this.mEGLConfig = null;
  }
  
  public void releaseSurface(EGLSurface paramEGLSurface)
  {
    EGL14.eglDestroySurface(this.mEGLDisplay, paramEGLSurface);
  }
  
  public void setPresentationTime(EGLSurface paramEGLSurface, long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, paramEGLSurface, paramLong);
  }
  
  public boolean swapBuffers(EGLSurface paramEGLSurface)
  {
    return EGL14.eglSwapBuffers(this.mEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.eglwraper.EglCore
 * JD-Core Version:    0.7.0.1
 */