package com.tencent.mobileqq.shortvideo.eglwraper;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.tencent.sveffects.SLog;

@TargetApi(18)
public final class EglCore
{
  private EGLConfig jdField_a_of_type_AndroidOpenglEGLConfig = null;
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.EGL_NO_DISPLAY;
  
  public EglCore(EGLContext paramEGLContext, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay != EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("EGL already set up");
    }
    EGLContext localEGLContext1 = paramEGLContext;
    if (paramEGLContext == null)
    {
      localEGLContext1 = EGL14.EGL_NO_CONTEXT;
      SLog.a("EglCore", "sharedContext == null");
    }
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    paramEGLContext = new int[2];
    if (!EGL14.eglInitialize(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLContext, 0, paramEGLContext, 1))
    {
      this.jdField_a_of_type_AndroidOpenglEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    if ((paramInt & 0x2) != 0)
    {
      paramEGLContext = a(paramInt, 3);
      if (paramEGLContext != null)
      {
        EGLContext localEGLContext2 = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLContext, localEGLContext1, new int[] { 12440, 3, 12344 }, 0);
        if (EGL14.eglGetError() == 12288)
        {
          this.jdField_a_of_type_AndroidOpenglEGLConfig = paramEGLContext;
          this.jdField_a_of_type_AndroidOpenglEGLContext = localEGLContext2;
        }
      }
    }
    if (this.jdField_a_of_type_AndroidOpenglEGLContext == EGL14.EGL_NO_CONTEXT)
    {
      paramEGLContext = a(paramInt, 2);
      if (paramEGLContext == null) {
        throw new RuntimeException("Unable to find a suitable EGLConfig");
      }
      localEGLContext1 = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLContext, localEGLContext1, new int[] { 12440, 2, 12344 }, 0);
      a("eglCreateContext");
      this.jdField_a_of_type_AndroidOpenglEGLConfig = paramEGLContext;
      this.jdField_a_of_type_AndroidOpenglEGLContext = localEGLContext1;
    }
    paramEGLContext = new int[1];
    EGL14.eglQueryContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext, 12440, paramEGLContext, 0);
    if (SLog.a()) {
      SLog.d("EglCore", "EGLContext created, client version " + paramEGLContext[0]);
    }
  }
  
  private EGLConfig a(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 3) {}
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.jdField_a_of_type_AndroidOpenglEGLDisplay;
    paramInt1 = arrayOfEGLConfig.length;
    if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, arrayOfEGLConfig, 0, paramInt1, arrayOfInt, 0))
    {
      if (SLog.a()) {
        SLog.b("EglCore", "unable to find RGB8888 / " + paramInt2 + " EGLConfig");
      }
      return null;
    }
    return arrayOfEGLConfig[0];
  }
  
  private void a(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288) {
      SLog.a("EglCore", new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i)));
    }
  }
  
  public EGLSurface a(int paramInt1, int paramInt2)
  {
    EGLSurface localEGLSurface = EGL14.eglCreatePbufferSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    a("eglCreatePbufferSurface");
    if (localEGLSurface == null) {
      throw new RuntimeException("surface was null");
    }
    return localEGLSurface;
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
  
  public void b(EGLSurface paramEGLSurface)
  {
    if ((this.jdField_a_of_type_AndroidOpenglEGLDisplay == EGL14.EGL_NO_DISPLAY) && (SLog.a())) {
      SLog.d("EglCore", "NOTE: makeCurrent w/o display");
    }
    if (!EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, paramEGLSurface, paramEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLContext)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  protected void finalize()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOpenglEGLDisplay != EGL14.EGL_NO_DISPLAY)
      {
        if (SLog.a()) {
          SLog.b("EglCore", "WARNING: EglCore was not explicitly released -- state may be leaked");
        }
        a();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.eglwraper.EglCore
 * JD-Core Version:    0.7.0.1
 */