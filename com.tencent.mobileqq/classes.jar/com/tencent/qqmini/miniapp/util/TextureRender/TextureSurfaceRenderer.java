package com.tencent.qqmini.miniapp.util.TextureRender;

import android.opengl.GLUtils;
import android.os.Handler;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class TextureSurfaceRenderer
  implements Runnable
{
  private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static final String TAG = "miniapp-embedded";
  private EGL10 egl;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private int frames;
  protected int height;
  private long lastFpsOutput = 0L;
  protected Handler mHandler;
  private boolean pause = false;
  private boolean running;
  private Surface surface;
  protected int width;
  
  public TextureSurfaceRenderer(Surface paramSurface, int paramInt1, int paramInt2, Handler paramHandler)
  {
    this.surface = paramSurface;
    this.width = paramInt1;
    this.height = paramInt2;
    this.running = true;
    this.mHandler = paramHandler;
    new Thread(this).start();
  }
  
  private EGLConfig chooseEglConfig()
  {
    Object localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = getConfig();
    if (this.egl.eglChooseConfig(this.eglDisplay, arrayOfInt, arrayOfEGLConfig, 1, (int[])localObject))
    {
      if (localObject[0] > 0) {
        return arrayOfEGLConfig[0];
      }
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to choose config: ");
    ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  private void deinitGL()
  {
    try
    {
      this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
      this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
      this.egl.eglTerminate(this.eglDisplay);
      QMLog.d("miniapp-embedded", "OpenGL deinit OK.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "deinitGL error, ", localThrowable);
    }
  }
  
  private int[] getConfig()
  {
    return new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  private void initGL()
  {
    try
    {
      this.egl = ((EGL10)EGLContext.getEGL());
      this.eglDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      Object localObject = new int[2];
      this.egl.eglInitialize(this.eglDisplay, (int[])localObject);
      localObject = chooseEglConfig();
      this.eglContext = createContext(this.egl, this.eglDisplay, (EGLConfig)localObject);
      this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, (EGLConfig)localObject, this.surface, null);
      if ((this.eglSurface != null) && (this.eglSurface != EGL10.EGL_NO_SURFACE))
      {
        if (this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
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
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "initGL error.", localThrowable);
    }
  }
  
  private void pingFps()
  {
    if (this.lastFpsOutput == 0L) {
      this.lastFpsOutput = System.currentTimeMillis();
    }
    this.frames += 1;
    if (System.currentTimeMillis() - this.lastFpsOutput > 1000L)
    {
      this.lastFpsOutput = System.currentTimeMillis();
      this.frames = 0;
    }
  }
  
  protected abstract void deinitGLComponents();
  
  protected abstract boolean draw();
  
  protected void finalize()
  {
    super.finalize();
    this.running = false;
  }
  
  protected abstract void initGLComponents();
  
  public void onPause()
  {
    this.running = false;
  }
  
  public void pauseRender()
  {
    this.pause = true;
  }
  
  public void resumeRender()
  {
    this.pause = false;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        initGL();
        initGLComponents();
        QMLog.d("miniapp-embedded", "OpenGL init OK.");
        if (this.running)
        {
          if (this.pause) {
            continue;
          }
          l1 = System.currentTimeMillis();
          pingFps();
          if (draw()) {
            this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
          }
          long l2 = System.currentTimeMillis();
          l1 = 16L - (l2 - l1);
          if (l1 <= 0L) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        long l1;
        QMLog.e("miniapp-embedded", "TextureSurfaceRenderer run error,", localThrowable);
        return;
      }
      try
      {
        Thread.sleep(l1);
      }
      catch (InterruptedException localInterruptedException) {}
      deinitGLComponents();
      deinitGL();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.TextureRender.TextureSurfaceRenderer
 * JD-Core Version:    0.7.0.1
 */