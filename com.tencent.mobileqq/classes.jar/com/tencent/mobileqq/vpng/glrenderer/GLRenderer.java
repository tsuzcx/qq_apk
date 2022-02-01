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
  protected boolean a = false;
  SurfaceTexture b;
  int c;
  int d;
  private EGLDisplay e = EGL10.EGL_NO_DISPLAY;
  private EGLContext f = EGL10.EGL_NO_CONTEXT;
  private EGLSurface g = EGL10.EGL_NO_SURFACE;
  private EGL10 h;
  private GLRenderer.RenderThreadThread i;
  private LinkedList<Runnable> j = new LinkedList();
  private final Object k = new Object();
  private Runnable l;
  
  GLRenderer(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  private void h()
  {
    this.h = ((EGL10)EGLContext.getEGL());
    this.e = this.h.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.e != EGL10.EGL_NO_DISPLAY)
    {
      localObject1 = new int[2];
      if (this.h.eglInitialize(this.e, (int[])localObject1))
      {
        localObject1 = new int[1];
        Object localObject2 = new EGLConfig[1];
        Object localObject3 = this.h;
        EGLDisplay localEGLDisplay = this.e;
        int m = localObject2.length;
        if (((EGL10)localObject3).eglChooseConfig(localEGLDisplay, new int[] { 12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344 }, (EGLConfig[])localObject2, m, (int[])localObject1))
        {
          localObject1 = localObject2[0];
          this.f = this.h.eglCreateContext(this.e, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          if (this.f != EGL10.EGL_NO_CONTEXT)
          {
            m = this.c;
            int n = this.d;
            localObject2 = this.b;
            if (localObject2 != null) {
              this.g = this.h.eglCreateWindowSurface(this.e, (EGLConfig)localObject1, localObject2, null);
            } else {
              this.g = this.h.eglCreatePbufferSurface(this.e, (EGLConfig)localObject1, new int[] { 12375, m, 12374, n, 12344 });
            }
            localObject1 = this.h;
            localObject2 = this.e;
            localObject3 = this.g;
            ((EGL10)localObject1).eglMakeCurrent((EGLDisplay)localObject2, (EGLSurface)localObject3, (EGLSurface)localObject3, this.f);
            return;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("EGL error ");
          ((StringBuilder)localObject1).append(this.h.eglGetError());
          throw new RuntimeException(((StringBuilder)localObject1).toString());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("EGL error ");
        ((StringBuilder)localObject1).append(this.h.eglGetError());
        throw new RuntimeException(((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("EGL error ");
      ((StringBuilder)localObject1).append(this.h.eglGetError());
      throw new RuntimeException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("eglGetDisplay failed ");
    ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.h.eglGetError()));
    throw new RuntimeException(((StringBuilder)localObject1).toString());
  }
  
  private void i()
  {
    SurfaceTexture localSurfaceTexture = this.b;
    if (localSurfaceTexture != null)
    {
      localSurfaceTexture.release();
      this.b = null;
    }
    this.h.eglDestroyContext(this.e, this.f);
    this.h.eglDestroySurface(this.e, this.g);
    this.f = EGL10.EGL_NO_CONTEXT;
    this.e = EGL10.EGL_NO_DISPLAY;
  }
  
  private void j()
  {
    EGL10 localEGL10 = this.h;
    EGLDisplay localEGLDisplay = this.e;
    EGLSurface localEGLSurface = this.g;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.f);
    GLES20.glViewport(0, 0, this.c, this.d);
    e();
    this.h.eglSwapBuffers(this.e, this.g);
    f();
  }
  
  public void a()
  {
    GLRenderer.RenderThreadThread localRenderThreadThread = this.i;
    if ((localRenderThreadThread == null) || (!GLRenderer.RenderThreadThread.a(localRenderThreadThread)))
    {
      this.i = new GLRenderer.RenderThreadThread(this, null);
      this.i.start();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.b = paramSurfaceTexture;
    a();
  }
  
  protected void a(Runnable paramRunnable)
  {
    this.l = paramRunnable;
  }
  
  public void b()
  {
    GLRenderer.RenderThreadThread localRenderThreadThread = this.i;
    if (localRenderThreadThread != null)
    {
      GLRenderer.RenderThreadThread.a(localRenderThreadThread, false);
      this.i = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.GLRenderer
 * JD-Core Version:    0.7.0.1
 */