package com.tencent.mobileqq.shortvideo.eglwraper;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;

@TargetApi(17)
public class EglSurfaceBase
{
  private EGLSurface a;
  protected EglCore a;
  
  public EglSurfaceBase(EglCore paramEglCore)
  {
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore = paramEglCore;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore.a(this.jdField_a_of_type_AndroidOpenglEGLSurface);
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.jdField_a_of_type_AndroidOpenglEGLSurface = this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore.a(paramInt1, paramInt2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglCore.b(this.jdField_a_of_type_AndroidOpenglEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.eglwraper.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */