package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;

@TargetApi(17)
public class OffScreenInputSurface
{
  static final int[] jdField_a_of_type_ArrayOfInt = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 };
  static final int[] jdField_b_of_type_ArrayOfInt = { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12339, 1, 12344 };
  private int jdField_a_of_type_Int;
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  private EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay;
  private EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface;
  private int jdField_b_of_type_Int;
  private EGLContext jdField_b_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
  
  public OffScreenInputSurface(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_AndroidOpenglEGLContext = paramEGLContext;
    a();
  }
  
  static int a(EGLContext paramEGLContext)
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    return 0;
  }
  
  static EGLContext a()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return EGL14.EGL_NO_CONTEXT;
    }
    return null;
  }
  
  int a()
  {
    return a(this.jdField_b_of_type_AndroidOpenglEGLContext);
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    int[] arrayOfInt1 = new int[2];
    if (!EGL14.eglInitialize(this.jdField_a_of_type_AndroidOpenglEGLDisplay, arrayOfInt1, 0, arrayOfInt1, 1))
    {
      this.jdField_a_of_type_AndroidOpenglEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = new int[1];
    arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    boolean bool = CameraCompatibleList.e(CameraCompatibleList.v);
    if (bool) {
      arrayOfInt1 = jdField_b_of_type_ArrayOfInt;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OffScreenInputSurface", 2, "OffScreenInputSurface[eglSetup] isBlack=" + bool);
    }
    if (!EGL14.eglChooseConfig(this.jdField_a_of_type_AndroidOpenglEGLDisplay, arrayOfInt1, 0, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt2, 0)) {
      throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
    }
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, arrayOfEGLConfig[0], this.jdField_b_of_type_AndroidOpenglEGLContext, new int[] { 12440, 2, 12344 }, 0);
    a("eglCreateContext", 1);
    if (this.jdField_a_of_type_AndroidOpenglEGLContext == null) {
      throw new OffScreenInputSurface.EGLCreateContextException("null context");
    }
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.eglCreatePbufferSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, arrayOfEGLConfig[0], new int[] { 12375, i, 12374, j, 12376, 1, 12344 }, 0);
    a("eglCreateWindowSurface", 2);
    if (this.jdField_a_of_type_AndroidOpenglEGLSurface == null) {
      throw new OffScreenInputSurface.EGLCreatePbufferSurfaceException("surface was null");
    }
  }
  
  void a(String paramString, int paramInt)
  {
    int j = 0;
    int i = 12288;
    for (;;)
    {
      int k = EGL14.eglGetError();
      if (k == 12288) {
        break;
      }
      Log.e("OffScreenInputSurface", paramString + ": EGL error: 0x" + Integer.toHexString(k));
      i = k;
      j = 1;
    }
    if (j != 0)
    {
      if (paramInt == 1)
      {
        b();
        throw new OffScreenInputSurface.EGLCreateContextException("EGL error encountered (see log)" + i);
      }
      if (paramInt == 2)
      {
        b();
        throw new OffScreenInputSurface.EGLCreatePbufferSurfaceException("EGL error encountered (see log)" + i);
      }
      throw new RuntimeException("EGL error encountered (see log)" + i);
    }
  }
  
  public boolean a()
  {
    return EGL14.eglGetCurrentContext().equals(this.jdField_a_of_type_AndroidOpenglEGLContext);
  }
  
  boolean a(EGLContext paramEGLContext)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramEGLContext.equals(this.jdField_b_of_type_AndroidOpenglEGLContext);
    }
    return paramEGLContext == this.jdField_b_of_type_AndroidOpenglEGLContext;
  }
  
  public void b()
  {
    if (EGL14.eglGetCurrentContext().equals(this.jdField_a_of_type_AndroidOpenglEGLContext)) {
      EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
    }
    if ((this.jdField_a_of_type_AndroidOpenglEGLSurface != null) && (this.jdField_a_of_type_AndroidOpenglEGLSurface != EGL14.EGL_NO_SURFACE)) {
      EGL14.eglDestroySurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface);
    }
    if ((this.jdField_a_of_type_AndroidOpenglEGLContext != null) && (this.jdField_a_of_type_AndroidOpenglEGLContext != EGL14.EGL_NO_CONTEXT)) {
      EGL14.eglDestroyContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext);
    }
    EGL14.eglReleaseThread();
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay != null)
    {
      EGL14.eglTerminate(this.jdField_a_of_type_AndroidOpenglEGLDisplay);
      this.jdField_a_of_type_AndroidOpenglEGLDisplay = null;
    }
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = null;
    this.jdField_a_of_type_AndroidOpenglEGLContext = null;
    this.jdField_a_of_type_AndroidOpenglEGLSurface = null;
    this.jdField_b_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
  }
  
  boolean b()
  {
    return this.jdField_b_of_type_AndroidOpenglEGLContext == a();
  }
  
  public void c()
  {
    if (!EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLContext)) {
      throw new OffScreenInputSurface.EGLMakeCurrentException("eglMakeCurrent failed " + EGL14.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface
 * JD-Core Version:    0.7.0.1
 */