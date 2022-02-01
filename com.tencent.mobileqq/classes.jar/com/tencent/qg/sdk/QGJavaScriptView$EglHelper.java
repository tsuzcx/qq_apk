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
    Object localObject = this.mEglSurface;
    if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
    {
      this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      localObject = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
      if (localObject != null) {
        ((QGJavaScriptView)localObject).mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
      }
      this.mEglSurface = null;
    }
  }
  
  public static String formatEglError(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" failed: ");
    localStringBuilder.append(QGJavaScriptView.getErrorString(paramInt));
    return localStringBuilder.toString();
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
    if (localQGJavaScriptView != null)
    {
      GL localGL1 = localGL2;
      if (localQGJavaScriptView.mGLWrapper != null) {
        localGL1 = localQGJavaScriptView.mGLWrapper.wrap(localGL2);
      }
      localObject = localGL1;
      if ((localQGJavaScriptView.mDebugFlags & 0x3) != 0)
      {
        int i = 0;
        localObject = null;
        if ((localQGJavaScriptView.mDebugFlags & 0x1) != 0) {
          i = 1;
        }
        if ((localQGJavaScriptView.mDebugFlags & 0x2) != 0) {
          localObject = new QGJavaScriptView.LogWriter();
        }
        localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
      }
    }
    return localObject;
  }
  
  public boolean createSurface()
  {
    if (this.mEgl != null)
    {
      if (this.mEglDisplay != null)
      {
        if (this.mEglConfig != null)
        {
          destroySurfaceImp();
          Object localObject = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
          if (localObject != null) {
            this.mEglSurface = ((QGJavaScriptView)localObject).mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, ((QGJavaScriptView)localObject).getHolder());
          } else {
            this.mEglSurface = null;
          }
          localObject = this.mEglSurface;
          if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
          {
            localObject = this.mEgl;
            EGLDisplay localEGLDisplay = this.mEglDisplay;
            EGLSurface localEGLSurface = this.mEglSurface;
            if (!((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.mEglContext))
            {
              logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
              return false;
            }
            return true;
          }
          if (this.mEgl.eglGetError() == 12299) {
            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
          }
          return false;
        }
        throw new RuntimeException("mEglConfig not initialized");
      }
      throw new RuntimeException("eglDisplay not initialized");
    }
    throw new RuntimeException("egl not initialized");
  }
  
  public void destroySurface()
  {
    destroySurfaceImp();
  }
  
  public void finish()
  {
    if (this.mEglContext != null)
    {
      localObject = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
      if (localObject != null) {
        ((QGJavaScriptView)localObject).mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
      }
      this.mEglContext = null;
    }
    Object localObject = this.mEglDisplay;
    if (localObject != null)
    {
      this.mEgl.eglTerminate((EGLDisplay)localObject);
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
    if (this.mEglDisplay != EGL10.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject))
      {
        localObject = (QGJavaScriptView)this.mGLSurfaceViewWeakRef.get();
        if (localObject == null)
        {
          this.mEglConfig = null;
          this.mEglContext = null;
        }
        else
        {
          this.mEglConfig = ((QGJavaScriptView)localObject).mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
          this.mEglContext = ((QGJavaScriptView)localObject).mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
        }
        localObject = this.mEglContext;
        if ((localObject == null) || (localObject == EGL10.EGL_NO_CONTEXT))
        {
          this.mEglContext = null;
          throwEglException("createContext");
        }
        this.mEglSurface = null;
        return;
      }
      throw new RuntimeException("eglInitialize failed");
    }
    throw new RuntimeException("eglGetDisplay failed");
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