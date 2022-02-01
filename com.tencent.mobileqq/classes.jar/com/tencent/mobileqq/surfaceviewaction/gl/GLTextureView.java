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
  private int jdField_a_of_type_Int = 16;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private GLSurfaceView.Renderer jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer;
  private GLTextureView.RenderThreadRunnable jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<GLTextureView.OnSurfaceChangedListener> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  private EGLConfig jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig;
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  private EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  private EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  private GL10 jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private List<Runnable> jdField_b_of_type_JavaUtilList = new LinkedList();
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int c;
  
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
      if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable != null) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable.jdField_a_of_type_Boolean))
      {
        paramRenderer.onSurfaceCreated(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig);
        paramRenderer.onSurfaceChanged(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10, this.c, this.jdField_b_of_type_Int);
      }
    }
    finally {}
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer == null;
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer != null) {
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer.onDrawFrame(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10);
      }
      if ((!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglSwapBuffers(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface)) && (QLog.isColorLevel())) {
        QLog.e("GLTextureView", 2, "cannot swap buffers!");
      }
      return;
    }
    finally {}
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError();
    if ((i != 12288) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EGL error = 0x");
      localStringBuilder.append(Integer.toHexString(i));
      QLog.e("GLTextureView", 2, localStringBuilder.toString());
    }
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10;
    if (localObject != null)
    {
      int i = ((GL10)localObject).glGetError();
      if ((i != 0) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GL error = 0x");
        ((StringBuilder)localObject).append(Integer.toHexString(i));
        QLog.e("GLTextureView", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("GLTextureView", 2, "mGl == null");
    }
  }
  
  private void e()
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
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
        if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglChooseConfig(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 }, (EGLConfig[])localObject2, 1, (int[])localObject1))
        {
          if (localObject1[0] > 0) {
            this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = localObject2[0];
          }
          localObject1 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig;
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            c();
            this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateWindowSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null);
            c();
            localObject1 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
            if ((localObject1 != null) && (localObject1 != EGL10.EGL_NO_SURFACE))
            {
              localObject1 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
              localObject2 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
              EGLSurface localEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
              if (((EGL10)localObject1).eglMakeCurrent((EGLDisplay)localObject2, localEGLSurface, localEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext))
              {
                c();
                this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10 = ((GL10)this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext.getGL());
                c();
                return;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("eglMakeCurrent failed ");
              ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError()));
              throw new RuntimeException(((StringBuilder)localObject1).toString());
            }
            int i = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError();
            if (i == 12299)
            {
              if (QLog.isColorLevel()) {
                QLog.e("GLTextureView", 2, "eglCreateWindowSurface returned EGL10.EGL_BAD_NATIVE_WINDOW");
              }
              return;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("eglCreateWindowSurface failed ");
            ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(i));
            throw new RuntimeException(((StringBuilder)localObject1).toString());
          }
          throw new RuntimeException("eglConfig not initialized");
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("eglChooseConfig failed ");
        ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError()));
        throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("eglInitialize failed ");
      ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("eglGetDisplay failed ");
    ((StringBuilder)localObject1).append(GLUtils.getEGLErrorString(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError()));
    throw new RuntimeException(((StringBuilder)localObject1).toString());
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = EGL10.EGL_NO_CONTEXT;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = EGL10.EGL_NO_SURFACE;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, "Stopping and joining GLTextureView");
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable = null;
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
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable = new GLTextureView.RenderThreadRunnable(this, null);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    setDimensions(paramInt1, paramInt2);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView$RenderThreadRunnable, 10, null, true);
  }
  
  public void a(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnSurfaceChangedListener);
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilList.add(paramRunnable);
      return;
    }
  }
  
  public void b(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramOnSurfaceChangedListener);
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
    paramSurfaceTexture = this.jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.onSurfaceChanged(this.jdField_a_of_type_JavaxMicroeditionKhronosOpenglesGL10, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setDimensions(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setFps(int paramInt)
  {
    this.jdField_a_of_type_Int = ((int)(1.0F / paramInt * 1000.0F));
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer = paramRenderer;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView
 * JD-Core Version:    0.7.0.1
 */