package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public final class EglCore
{
  private EGLDisplay a = EGL14.EGL_NO_DISPLAY;
  private EGLContext b = EGL14.EGL_NO_CONTEXT;
  private EGLConfig c = null;
  
  public EglCore(EGLContext paramEGLContext, int paramInt)
  {
    if (this.a == EGL14.EGL_NO_DISPLAY)
    {
      Object localObject = paramEGLContext;
      if (paramEGLContext == null)
      {
        localObject = EGL14.EGL_NO_CONTEXT;
        QLog.e("EglCore", 2, "sharedContext == null");
      }
      this.a = EGL14.eglGetDisplay(0);
      if (this.a != EGL14.EGL_NO_DISPLAY)
      {
        paramEGLContext = new int[2];
        if (EGL14.eglInitialize(this.a, paramEGLContext, 0, paramEGLContext, 1))
        {
          if ((paramInt & 0x2) != 0)
          {
            paramEGLContext = b(paramInt, 3);
            if (paramEGLContext != null)
            {
              EGLContext localEGLContext = EGL14.eglCreateContext(this.a, paramEGLContext, (EGLContext)localObject, new int[] { 12440, 3, 12344 }, 0);
              if (EGL14.eglGetError() == 12288)
              {
                this.c = paramEGLContext;
                this.b = localEGLContext;
              }
            }
          }
          if (this.b == EGL14.EGL_NO_CONTEXT)
          {
            paramEGLContext = b(paramInt, 2);
            if (paramEGLContext != null)
            {
              localObject = EGL14.eglCreateContext(this.a, paramEGLContext, (EGLContext)localObject, new int[] { 12440, 2, 12344 }, 0);
              a("eglCreateContext");
              this.c = paramEGLContext;
              this.b = ((EGLContext)localObject);
            }
            else
            {
              throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
          }
          paramEGLContext = new int[1];
          EGL14.eglQueryContext(this.a, this.b, 12440, paramEGLContext, 0);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("EGLContext created, client version ");
            ((StringBuilder)localObject).append(paramEGLContext[0]);
            QLog.d("EglCore", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
        this.a = null;
        throw new RuntimeException("unable to initialize EGL14");
      }
      throw new RuntimeException("unable to get EGL14 display");
    }
    throw new RuntimeException("EGL already set up");
  }
  
  private EGLConfig b(int paramInt1, int paramInt2)
  {
    Object localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.a;
    paramInt1 = localObject.length;
    if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, (EGLConfig[])localObject, 0, paramInt1, arrayOfInt, 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unable to find RGB8888 / ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" EGLConfig");
        QLog.w("EglCore", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    return localObject[0];
  }
  
  private void b(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(i));
      QLog.e("EglCore", 2, new RuntimeException(localStringBuilder.toString()), new Object[0]);
    }
  }
  
  public EGLSurface a(int paramInt1, int paramInt2)
  {
    EGLSurface localEGLSurface = EGL14.eglCreatePbufferSurface(this.a, this.c, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    b("eglCreatePbufferSurface");
    if (localEGLSurface != null) {
      return localEGLSurface;
    }
    throw new RuntimeException("surface was null");
  }
  
  public EGLSurface a(Object paramObject)
  {
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid surface: ");
      localStringBuilder.append(paramObject);
      throw new RuntimeException(localStringBuilder.toString());
    }
    paramObject = EGL14.eglCreateWindowSurface(this.a, this.c, paramObject, new int[] { 12344 }, 0);
    b("eglCreateWindowSurface");
    if (paramObject != null) {
      return paramObject;
    }
    throw new RuntimeException("surface was null");
  }
  
  public void a()
  {
    if (this.a != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglMakeCurrent(this.a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroyContext(this.a, this.b);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.a);
    }
    this.a = EGL14.EGL_NO_DISPLAY;
    this.b = EGL14.EGL_NO_CONTEXT;
    this.c = null;
  }
  
  public void a(EGLSurface paramEGLSurface)
  {
    EGL14.eglDestroySurface(this.a, paramEGLSurface);
  }
  
  public void a(EGLSurface paramEGLSurface, long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.a, paramEGLSurface, paramLong);
  }
  
  void a(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(i));
      new RuntimeException(localStringBuilder.toString());
      paramString = new StringBuilder();
      paramString.append("EGL14.eglGetCurrentContext() = ");
      paramString.append(EGL14.eglGetCurrentContext());
      paramString.append(", mEGLContext = ");
      paramString.append(this.b);
      paramString.toString();
      a();
    }
  }
  
  public void b(EGLSurface paramEGLSurface)
  {
    if ((this.a == EGL14.EGL_NO_DISPLAY) && (QLog.isColorLevel())) {
      QLog.d("EglCore", 2, "NOTE: makeCurrent w/o display");
    }
    if (EGL14.eglMakeCurrent(this.a, paramEGLSurface, paramEGLSurface, this.b)) {
      return;
    }
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public boolean c(EGLSurface paramEGLSurface)
  {
    return EGL14.eglSwapBuffers(this.a, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.encoder.EglCore
 * JD-Core Version:    0.7.0.1
 */