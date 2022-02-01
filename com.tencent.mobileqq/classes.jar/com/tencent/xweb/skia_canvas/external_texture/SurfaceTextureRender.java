package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class SurfaceTextureRender
{
  private static final String LOG_TAG = "SurfaceTextureRender";
  private EGL10 egl;
  private EGLConfig eglConfig;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private int mHeight;
  private boolean mInited;
  private int mWidth;
  private SurfaceTexture surfaceTexture;
  
  SurfaceTextureRender(SurfaceTexture paramSurfaceTexture)
  {
    this.surfaceTexture = paramSurfaceTexture;
  }
  
  private void initEGLSurface()
  {
    this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, this.surfaceTexture, null);
    Object localObject = this.eglSurface;
    if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
    {
      localObject = this.egl;
      EGLDisplay localEGLDisplay = this.eglDisplay;
      EGLSurface localEGLSurface = this.eglSurface;
      if (((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.eglContext))
      {
        localObject = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, (int[])localObject);
        this.mWidth = localObject[0];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, (int[])localObject);
        this.mHeight = localObject[0];
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("query w/h is ");
        ((StringBuilder)localObject).append(this.mWidth);
        ((StringBuilder)localObject).append(" / ");
        ((StringBuilder)localObject).append(this.mHeight);
        ((StringBuilder)localObject).append(" from ");
        ((StringBuilder)localObject).append(this.surfaceTexture);
        Log.d("SurfaceTextureRender", ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GL Make current error: ");
      ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GL Error: ");
    ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
    ((StringBuilder)localObject).append(" with surface ");
    ((StringBuilder)localObject).append(this.surfaceTexture);
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  void adjustViewPort()
  {
    GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
  }
  
  void deinitGL()
  {
    if (this.mInited)
    {
      this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
      Log.d("SurfaceTextureRender", "OpenGL deinit OK.");
      return;
    }
    Log.d("SurfaceTextureRender", "OpenGL deinit but never init.");
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public SurfaceTexture getSurface()
  {
    return this.surfaceTexture;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  void init(EGL10 paramEGL10, EGLContext paramEGLContext, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if (!this.mInited)
    {
      this.egl = paramEGL10;
      this.eglContext = paramEGLContext;
      this.eglDisplay = paramEGLDisplay;
      this.eglConfig = paramEGLConfig;
      initEGLSurface();
      this.mInited = true;
    }
  }
  
  void makeCurrent()
  {
    EGL10 localEGL10 = this.egl;
    EGLDisplay localEGLDisplay = this.eglDisplay;
    EGLSurface localEGLSurface = this.eglSurface;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.eglContext);
  }
  
  void swapBuffer()
  {
    this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SurfaceTextureRender
 * JD-Core Version:    0.7.0.1
 */