package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private GLSurfaceView.Renderer a;
  private SurfaceTexture b;
  private EGLDisplay c;
  private EGLSurface d;
  private EGLContext e;
  private EGL10 f;
  private EGLConfig g;
  private GL10 h;
  private boolean i = false;
  private GLTextureView.RenderThreadRunnable j;
  private int k = 16;
  private int l;
  private int m;
  private List<GLTextureView.OnSurfaceChangedListener> n = Collections.synchronizedList(new ArrayList());
  private List<Runnable> o = new LinkedList();
  private Object p = new Object();
  private volatile boolean q = false;
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOpaque(false);
    setSurfaceTextureListener(this);
  }
  
  private void a(GLSurfaceView.Renderer paramRenderer)
  {
    if (paramRenderer != null) {}
    try
    {
      if ((this.j != null) && (this.j.a))
      {
        paramRenderer.onSurfaceCreated(this.h, this.g);
        paramRenderer.onSurfaceChanged(this.h, this.m, this.l);
      }
    }
    finally {}
  }
  
  private boolean b()
  {
    return this.a == null;
  }
  
  private void c()
  {
    try
    {
      if (this.a != null) {
        this.a.onDrawFrame(this.h);
      }
      if ((!this.f.eglSwapBuffers(this.c, this.d)) && (QLog.isColorLevel())) {
        QLog.e("GLTextureView", 2, "cannot swap buffers!");
      }
      return;
    }
    finally {}
  }
  
  private void d()
  {
    int i1 = this.f.eglGetError();
    if ((i1 != 12288) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EGL error = 0x");
      localStringBuilder.append(Integer.toHexString(i1));
      QLog.e("GLTextureView", 2, localStringBuilder.toString());
    }
  }
  
  private void e()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      int i1 = ((GL10)localObject).glGetError();
      if ((i1 != 0) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GL error = 0x");
        ((StringBuilder)localObject).append(Integer.toHexString(i1));
        QLog.e("GLTextureView", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("GLTextureView", 2, "mGl == null");
    }
  }
  
  private void f()
  {
    this.f = ((EGL10)EGLContext.getEGL());
    this.c = this.f.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.c != EGL10.EGL_NO_DISPLAY)
    {
      localObject1 = new int[2];
      if (this.f.eglInitialize(this.c, (int[])localObject1))
      {
        localObject1 = new int[1];
        Object localObject2 = new EGLConfig[1];
        this.g = null;
        if (this.f.eglChooseConfig(this.c, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 }, (EGLConfig[])localObject2, 1, (int[])localObject1))
        {
          if (localObject1[0] > 0) {
            this.g = localObject2[0];
          }
          localObject1 = this.g;
          if (localObject1 != null)
          {
            this.e = this.f.eglCreateContext(this.c, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            d();
            this.d = this.f.eglCreateWindowSurface(this.c, this.g, this.b, null);
            d();
            localObject1 = this.d;
            if ((localObject1 != null) && (localObject1 != EGL10.EGL_NO_SURFACE))
            {
              localObject1 = this.f;
              localObject2 = this.c;
              EGLSurface localEGLSurface = this.d;
              if (((EGL10)localObject1).eglMakeCurrent((EGLDisplay)localObject2, localEGLSurface, localEGLSurface, this.e))
              {
                d();
                this.h = ((GL10)this.e.getGL());
                d();
                return;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("eglMakeCurrent failed ");
              ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.f.eglGetError()));
              throw new RuntimeException(((StringBuilder)localObject1).toString());
            }
            int i1 = this.f.eglGetError();
            if (i1 == 12299)
            {
              if (QLog.isColorLevel()) {
                QLog.e("GLTextureView", 2, "eglCreateWindowSurface returned EGL10.EGL_BAD_NATIVE_WINDOW");
              }
              return;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("eglCreateWindowSurface failed ");
            ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(i1));
            throw new RuntimeException(((StringBuilder)localObject1).toString());
          }
          throw new RuntimeException("eglConfig not initialized");
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("eglChooseConfig failed ");
        ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.f.eglGetError()));
        throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("eglInitialize failed ");
      ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.f.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("eglGetDisplay failed ");
    ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.f.eglGetError()));
    throw new RuntimeException(((StringBuilder)localObject1).toString());
  }
  
  private void g()
  {
    this.f.eglDestroyContext(this.c, this.e);
    this.f.eglDestroySurface(this.c, this.d);
    this.e = EGL10.EGL_NO_CONTEXT;
    this.d = EGL10.EGL_NO_SURFACE;
  }
  
  public void a()
  {
    if (this.j != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, "Stopping and joining GLTextureView");
      }
      try
      {
        this.j.a = false;
        this.j = null;
        return;
      }
      finally {}
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, "Starting GLTextureView thread");
    }
    this.j = new GLTextureView.RenderThreadRunnable(this, null);
    this.b = paramSurfaceTexture;
    setDimensions(paramInt1, paramInt2);
    ThreadManager.post(this.j, 10, null, true);
  }
  
  public void a(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    this.n.add(paramOnSurfaceChangedListener);
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.p)
    {
      this.o.add(paramRunnable);
      return;
    }
  }
  
  public void b(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    this.n.remove(paramOnSurfaceChangedListener);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("GLTextureView", 1, "onSurfaceTextureAvailable");
    a(paramSurfaceTexture, paramInt1, paramInt2);
    setAlpha(0.0F);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    QLog.i("GLTextureView", 1, "onSurfaceTextureDestroyed");
    a();
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("GLTextureView", 1, "onSurfaceTextureSizeChanged");
    setDimensions(paramInt1, paramInt2);
    paramSurfaceTexture = this.a;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.onSurfaceChanged(this.h, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setDimensions(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.l = paramInt2;
  }
  
  public void setFps(int paramInt)
  {
    this.k = ((int)(1.0F / paramInt * 1000.0F));
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    this.a = paramRenderer;
    this.i = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView
 * JD-Core Version:    0.7.0.1
 */