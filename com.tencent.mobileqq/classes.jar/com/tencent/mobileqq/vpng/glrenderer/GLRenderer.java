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
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != EGL10.EGL_NO_DISPLAY)
    {
      localObject1 = new int[2];
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject1))
      {
        localObject1 = new int[1];
        Object localObject2 = new EGLConfig[1];
        Object localObject3 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
        EGLDisplay localEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
        int i = localObject2.length;
        if (((EGL10)localObject3).eglChooseConfig(localEGLDisplay, new int[] { 12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344 }, (EGLConfig[])localObject2, i, (int[])localObject1))
        {
          localObject1 = localObject2[0];
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != EGL10.EGL_NO_CONTEXT)
          {
            i = this.jdField_a_of_type_Int;
            int j = this.b;
            localObject2 = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
            if (localObject2 != null) {
              this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateWindowSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (EGLConfig)localObject1, localObject2, null);
            } else {
              this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreatePbufferSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (EGLConfig)localObject1, new int[] { 12375, i, 12374, j, 12344 });
            }
            localObject1 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
            localObject2 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
            localObject3 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
            ((EGL10)localObject1).eglMakeCurrent((EGLDisplay)localObject2, (EGLSurface)localObject3, (EGLSurface)localObject3, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
            return;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("EGL error ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
          throw new RuntimeException(((StringBuilder)localObject1).toString());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("EGL error ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
        throw new RuntimeException(((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("EGL error ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
      throw new RuntimeException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("eglGetDisplay failed ");
    ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError()));
    throw new RuntimeException(((StringBuilder)localObject1).toString());
  }
  
  private void i()
  {
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localSurfaceTexture != null)
    {
      localSurfaceTexture.release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = EGL10.EGL_NO_CONTEXT;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = EGL10.EGL_NO_DISPLAY;
  }
  
  private void j()
  {
    EGL10 localEGL10 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
    EGLDisplay localEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
    EGLSurface localEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.b);
    e();
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglSwapBuffers(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
    f();
  }
  
  public void a()
  {
    GLRenderer.RenderThreadThread localRenderThreadThread = this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread;
    if ((localRenderThreadThread == null) || (!GLRenderer.RenderThreadThread.a(localRenderThreadThread)))
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
    GLRenderer.RenderThreadThread localRenderThreadThread = this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererGLRenderer$RenderThreadThread;
    if (localRenderThreadThread != null)
    {
      GLRenderer.RenderThreadThread.a(localRenderThreadThread, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.GLRenderer
 * JD-Core Version:    0.7.0.1
 */