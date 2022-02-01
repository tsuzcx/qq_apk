package com.tencent.qq.effect.alphavideo.videoplayer.view;

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

class GLTextureView$EglHelper
{
  EGL10 mEgl;
  EGLConfig mEglConfig;
  EGLContext mEglContext;
  EGLDisplay mEglDisplay;
  EGLSurface mEglSurface;
  private WeakReference<GLTextureView> mGLTextureViewWeakRef;
  
  public GLTextureView$EglHelper(WeakReference<GLTextureView> paramWeakReference)
  {
    this.mGLTextureViewWeakRef = paramWeakReference;
  }
  
  private void destroySurfaceImp()
  {
    Object localObject = this.mEglSurface;
    if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
    {
      this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      localObject = (GLTextureView)this.mGLTextureViewWeakRef.get();
      if (localObject != null) {
        GLTextureView.access$1300((GLTextureView)localObject).destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
      }
      this.mEglSurface = null;
    }
  }
  
  public static String formatEglError(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" failed: ");
    localStringBuilder.append(getErrorString(paramInt));
    return localStringBuilder.toString();
  }
  
  public static String getErrorString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return getHex(paramInt);
    case 12302: 
      return "EGL_CONTEXT_LOST";
    case 12301: 
      return "EGL_BAD_SURFACE";
    case 12300: 
      return "EGL_BAD_PARAMETER";
    case 12299: 
      return "EGL_BAD_NATIVE_WINDOW";
    case 12298: 
      return "EGL_BAD_NATIVE_PIXMAP";
    case 12297: 
      return "EGL_BAD_MATCH";
    case 12296: 
      return "EGL_BAD_DISPLAY";
    case 12295: 
      return "EGL_BAD_CURRENT_SURFACE";
    case 12294: 
      return "EGL_BAD_CONTEXT";
    case 12293: 
      return "EGL_BAD_CONFIG";
    case 12292: 
      return "EGL_BAD_ATTRIBUTE";
    case 12291: 
      return "EGL_BAD_ALLOC";
    case 12290: 
      return "EGL_BAD_ACCESS";
    case 12289: 
      return "EGL_NOT_INITIALIZED";
    }
    return "EGL_SUCCESS";
  }
  
  private static String getHex(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
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
    GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
    Object localObject = localGL2;
    if (localGLTextureView != null)
    {
      GL localGL1 = localGL2;
      if (GLTextureView.access$1400(localGLTextureView) != null) {
        localGL1 = GLTextureView.access$1400(localGLTextureView).wrap(localGL2);
      }
      localObject = localGL1;
      if ((GLTextureView.access$1500(localGLTextureView) & 0x3) != 0)
      {
        int i = 0;
        localObject = null;
        if ((GLTextureView.access$1500(localGLTextureView) & 0x1) != 0) {
          i = 1;
        }
        if ((GLTextureView.access$1500(localGLTextureView) & 0x2) != 0) {
          localObject = new GLTextureView.LogWriter();
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
          Object localObject = (GLTextureView)this.mGLTextureViewWeakRef.get();
          if (localObject != null) {
            this.mEglSurface = GLTextureView.access$1300((GLTextureView)localObject).createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, ((GLTextureView)localObject).getSurfaceTexture());
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
      localObject = (GLTextureView)this.mGLTextureViewWeakRef.get();
      if (localObject != null) {
        GLTextureView.access$1200((GLTextureView)localObject).destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
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
  
  public void start()
  {
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay != EGL10.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject))
      {
        localObject = (GLTextureView)this.mGLTextureViewWeakRef.get();
        if (localObject == null)
        {
          this.mEglConfig = null;
          this.mEglContext = null;
        }
        else
        {
          this.mEglConfig = GLTextureView.access$1100((GLTextureView)localObject).chooseConfig(this.mEgl, this.mEglDisplay);
          this.mEglContext = GLTextureView.access$1200((GLTextureView)localObject).createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
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
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.GLTextureView.EglHelper
 * JD-Core Version:    0.7.0.1
 */