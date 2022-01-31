package com.tencent.qqmini.sdk.runtime.util.TextureRender;

import android.opengl.GLUtils;
import android.os.Handler;
import android.view.Surface;
import com.tencent.qqmini.sdk.log.QMLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class TextureSurfaceRenderer
  implements Runnable
{
  protected int a;
  private long jdField_a_of_type_Long;
  protected Handler a;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  private EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  private EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private boolean b;
  private int c;
  
  public TextureSurfaceRenderer(Surface paramSurface, int paramInt1, int paramInt2, Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    new Thread(this).start();
  }
  
  private EGLConfig a()
  {
    int[] arrayOfInt1 = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = a();
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglChooseConfig(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, arrayOfInt2, arrayOfEGLConfig, 1, arrayOfInt1)) {
      throw new IllegalArgumentException("Failed to choose config: " + GLUtils.getEGLErrorString(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError()));
    }
    if (arrayOfInt1[0] > 0) {
      return arrayOfEGLConfig[0];
    }
    return null;
  }
  
  private EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  private int[] a()
  {
    return new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.c += 1;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.c = 0;
    }
  }
  
  private void g()
  {
    do
    {
      try
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)EGLContext.getEGL());
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        Object localObject = new int[2];
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject);
        localObject = a();
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (EGLConfig)localObject);
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateWindowSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (EGLConfig)localObject, this.jdField_a_of_type_AndroidViewSurface, null);
        if ((this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface == null) || (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface == EGL10.EGL_NO_SURFACE)) {
          throw new RuntimeException("GL Error: " + GLUtils.getEGLErrorString(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError()));
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("miniapp-embedded", "initGL error.", localThrowable);
        return;
      }
    } while (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext));
    throw new RuntimeException("GL Make current error: " + GLUtils.getEGLErrorString(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError()));
  }
  
  private void h()
  {
    try
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglTerminate(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
      QMLog.d("miniapp-embedded", "OpenGL deinit OK.");
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "deinitGL error, ", localThrowable);
    }
  }
  
  protected abstract void a();
  
  protected abstract boolean a();
  
  protected abstract void b();
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void finalize()
  {
    super.finalize();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    try
    {
      g();
      a();
      QMLog.d("miniapp-embedded", "OpenGL init OK.");
      while (this.jdField_a_of_type_Boolean) {
        if (!this.jdField_b_of_type_Boolean)
        {
          long l1 = System.currentTimeMillis();
          f();
          if (a()) {
            this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglSwapBuffers(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
          }
          long l2 = System.currentTimeMillis();
          l1 = 16L - (l2 - l1);
          if (l1 > 0L) {
            try
            {
              Thread.sleep(l1);
            }
            catch (InterruptedException localInterruptedException) {}
          }
        }
      }
      b();
      h();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "TextureSurfaceRenderer run error,", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.util.TextureRender.TextureSurfaceRenderer
 * JD-Core Version:    0.7.0.1
 */