package com.tencent.qg.sdk;

import android.opengl.GLDebugHelper;
import android.util.Log;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class QGJavaScriptView$EglHelper
{
  EGL10 mEgl;
  EGLConfig mEglConfig;
  EGLContext mEglContext;
  EGLDisplay mEglDisplay;
  EGLSurface mEglSurface;
  private WeakReference<QGJavaScriptView> mGLSurfaceViewWeakRef;
  
  public QGJavaScriptView$EglHelper(WeakReference<QGJavaScriptView> paramWeakReference)
  {
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }
  
  private void destroySurfaceImp()
  {
    if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
    {
      this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      QGJavaScriptView localQGJavaScriptView = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
      if (localQGJavaScriptView != null) {
        localQGJavaScriptView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
      }
      this.mEglSurface = null;
    }
  }
  
  public static String formatEglError(String paramString, int paramInt)
  {
    return paramString + " failed: " + QGJavaScriptView.getErrorString(paramInt);
  }
  
  public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt)
  {
    Log.w(paramString1, formatEglError(paramString2, paramInt));
  }
  
  private void throwEglException(String paramString)
  {
    throwEglException(paramString, this.mEgl.eglGetError());
  }
  
  public static void throwEglException(String paramString, int paramInt)
  {
    throw new RuntimeException(formatEglError(paramString, paramInt));
  }
  
  GL createGL()
  {
    GL localGL2 = this.mEglContext.getGL();
    QGJavaScriptView localQGJavaScriptView = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
    Object localObject = localGL2;
    GL localGL1;
    int i;
    if (localQGJavaScriptView != null)
    {
      localGL1 = localGL2;
      if (localQGJavaScriptView.mGLWrapper != null) {
        localGL1 = localQGJavaScriptView.mGLWrapper.wrap(localGL2);
      }
      localObject = localGL1;
      if ((localQGJavaScriptView.mDebugFlags & 0x3) != 0)
      {
        i = 0;
        if ((localQGJavaScriptView.mDebugFlags & 0x1) != 0) {
          i = 1;
        }
        if ((localQGJavaScriptView.mDebugFlags & 0x2) == 0) {
          break label106;
        }
      }
    }
    label106:
    for (localObject = new QGJavaScriptView.LogWriter();; localObject = null)
    {
      localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
      return localObject;
    }
  }
  
  public boolean createSurface()
  {
    if (this.mEgl == null) {
      throw new RuntimeException("egl not initialized");
    }
    if (this.mEglDisplay == null) {
      throw new RuntimeException("eglDisplay not initialized");
    }
    if (this.mEglConfig == null) {
      throw new RuntimeException("mEglConfig not initialized");
    }
    destroySurfaceImp();
    QGJavaScriptView localQGJavaScriptView = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
    if (localQGJavaScriptView != null) {}
    for (this.mEglSurface = localQGJavaScriptView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, localQGJavaScriptView.getHolder()); (this.mEglSurface == null) || (this.mEglSurface == EGL10.EGL_NO_SURFACE); this.mEglSurface = null)
    {
      if (this.mEgl.eglGetError() == 12299) {
        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
      }
      return false;
    }
    if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
    {
      logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
      return false;
    }
    return true;
  }
  
  public void destroySurface()
  {
    destroySurfaceImp();
  }
  
  public void finish()
  {
    if (this.mEglContext != null)
    {
      QGJavaScriptView localQGJavaScriptView = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
      if (localQGJavaScriptView != null) {
        localQGJavaScriptView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
      }
      this.mEglContext = null;
    }
    if (this.mEglDisplay != null)
    {
      this.mEgl.eglTerminate(this.mEglDisplay);
      this.mEglDisplay = null;
    }
  }
  
  public int getError()
  {
    return this.mEgl.eglGetError();
  }
  
  public void start()
  {
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed");
    }
    Object localObject = new int[2];
    if (!this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject)) {
      throw new RuntimeException("eglInitialize failed");
    }
    localObject = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
    if (localObject == null) {
      this.mEglConfig = null;
    }
    for (this.mEglContext = null;; this.mEglContext = ((QGJavaScriptView)localObject).mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig))
    {
      if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
      {
        this.mEglContext = null;
        throwEglException("createContext");
      }
      this.mEglSurface = null;
      return;
      this.mEglConfig = ((QGJavaScriptView)localObject).mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
    }
  }
  
  public int swap()
  {
    if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
      return this.mEgl.eglGetError();
    }
    return 12288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.EglHelper
 * JD-Core Version:    0.7.0.1
 */