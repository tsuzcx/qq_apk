package com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.framework.TLog;

@TargetApi(18)
public final class EglCore
{
  private EGLConfig jdField_a_of_type_AndroidOpenglEGLConfig = null;
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.EGL_NO_DISPLAY;
  
  public EglCore(EGLContext paramEGLContext, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      Object localObject = paramEGLContext;
      if (paramEGLContext == null)
      {
        localObject = EGL14.EGL_NO_CONTEXT;
        TLog.d("EglCore", "sharedContext == null");
      }
      this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.eglGetDisplay(0);
      if (this.jdField_a_of_type_AndroidOpenglEGLDisplay != EGL14.EGL_NO_DISPLAY)
      {
        paramEGLContext = new int[2];
        if (EGL14.eglInitialize(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLContext, 0, paramEGLContext, 1))
        {
          if ((paramInt & 0x2) != 0)
          {
            paramEGLContext = a(paramInt, 3);
            if (paramEGLContext != null)
            {
              EGLContext localEGLContext = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLContext, (EGLContext)localObject, new int[] { 12440, 3, 12344 }, 0);
              if (EGL14.eglGetError() == 12288)
              {
                this.jdField_a_of_type_AndroidOpenglEGLConfig = paramEGLContext;
                this.jdField_a_of_type_AndroidOpenglEGLContext = localEGLContext;
              }
            }
          }
          if (this.jdField_a_of_type_AndroidOpenglEGLContext == EGL14.EGL_NO_CONTEXT)
          {
            paramEGLContext = a(paramInt, 2);
            if (paramEGLContext != null)
            {
              localObject = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLContext, (EGLContext)localObject, new int[] { 12440, 2, 12344 }, 0);
              a("eglCreateContext");
              this.jdField_a_of_type_AndroidOpenglEGLConfig = paramEGLContext;
              this.jdField_a_of_type_AndroidOpenglEGLContext = ((EGLContext)localObject);
            }
            else
            {
              throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
          }
          paramEGLContext = new int[1];
          EGL14.eglQueryContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext, 12440, paramEGLContext, 0);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("EGLContext created, client version ");
          ((StringBuilder)localObject).append(paramEGLContext[0]);
          TLog.b("EglCore", ((StringBuilder)localObject).toString());
          return;
        }
        this.jdField_a_of_type_AndroidOpenglEGLDisplay = null;
        throw new RuntimeException("unable to initialize EGL14");
      }
      throw new RuntimeException("unable to get EGL14 display");
    }
    throw new RuntimeException("EGL already set up");
  }
  
  private EGLConfig a(int paramInt1, int paramInt2)
  {
    Object localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.jdField_a_of_type_AndroidOpenglEGLDisplay;
    paramInt1 = localObject.length;
    if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, (EGLConfig[])localObject, 0, paramInt1, arrayOfInt, 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to find RGB8888 / ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" EGLConfig");
      TLog.c("EglCore", ((StringBuilder)localObject).toString());
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
      paramString = new RuntimeException(localStringBuilder.toString());
      TLog.b("EglCore", paramString);
      if (!TopicSDK.b().a().a()) {
        return;
      }
      throw paramString;
    }
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
    paramObject = EGL14.eglCreateWindowSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLConfig, paramObject, new int[] { 12344 }, 0);
    b("eglCreateWindowSurface");
    if (paramObject != null) {
      return paramObject;
    }
    throw new RuntimeException("surface was null");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroyContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.jdField_a_of_type_AndroidOpenglEGLDisplay);
    }
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
    this.jdField_a_of_type_AndroidOpenglEGLConfig = null;
  }
  
  public void a(EGLSurface paramEGLSurface)
  {
    EGL14.eglDestroySurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLSurface);
  }
  
  public void a(EGLSurface paramEGLSurface, long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLSurface, paramLong);
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
      paramString = new RuntimeException(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("EGL14.eglGetCurrentContext() = ");
      localStringBuilder.append(EGL14.eglGetCurrentContext());
      localStringBuilder.append(", mEGLContext = ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidOpenglEGLContext);
      localStringBuilder.toString();
      a();
      if (!TopicSDK.b().a().a()) {
        return;
      }
      throw paramString;
    }
  }
  
  public boolean a(EGLSurface paramEGLSurface)
  {
    return EGL14.eglSwapBuffers(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLSurface);
  }
  
  public void b(EGLSurface paramEGLSurface)
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      TLog.b("EglCore", "NOTE: makeCurrent w/o display");
    }
    if (EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLSurface, paramEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLContext)) {
      return;
    }
    throw new RuntimeException("eglMakeCurrent failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.EglCore
 * JD-Core Version:    0.7.0.1
 */