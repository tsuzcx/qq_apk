package com.tencent.mobileqq.vpng.glrenderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class GLRenderer
{
  int jdField_a_of_type_Int;
  SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private GLRenderer.RenderThreadThread jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private LinkedList<Runnable> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = EGL10.EGL_NO_CONTEXT;
  private EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = EGL10.EGL_NO_DISPLAY;
  private EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = EGL10.EGL_NO_SURFACE;
  protected boolean a;
  int b;
  
  GLRenderer(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError()));
    }
    int[] arrayOfInt = new int[2];
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, arrayOfInt)) {
      throw new RuntimeException("EGL error " + this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
    }
    arrayOfInt = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    EGL10 localEGL10 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
    EGLDisplay localEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
    int i = arrayOfEGLConfig.length;
    if (!localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344 }, arrayOfEGLConfig, i, arrayOfInt)) {
      throw new RuntimeException("EGL error " + this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
    }
    arrayOfInt = arrayOfEGLConfig[0];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext == EGL10.EGL_NO_CONTEXT) {
      throw new RuntimeException("EGL error " + this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
    }
    i = this.jdField_a_of_type_Int;
    int j = this.b;
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {}
    for (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateWindowSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, arrayOfInt, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null);; this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreatePbufferSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, arrayOfInt, new int[] { 12375, i, 12374, j, 12344 }))
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
      return;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = EGL10.EGL_NO_CONTEXT;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = EGL10.EGL_NO_DISPLAY;
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.b);
    e();
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglSwapBuffers(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
    f();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread == null) || (!GLRenderer.RenderThreadThread.a(this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread)))
    {
      this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread = new GLRenderer.RenderThreadThread(this, null);
      this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread.start();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    a();
  }
  
  protected void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread != null)
    {
      GLRenderer.RenderThreadThread.a(this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread, false);
      this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread = null;
    }
  }
  
  public void c()
  {
    b();
  }
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.GLRenderer
 * JD-Core Version:    0.7.0.1
 */