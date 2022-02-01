package com.tencent.qqcamerakit.preview;

import android.opengl.EGL14;
import android.opengl.EGLSurface;

public class EglSurfaceBase
{
  private EGLSurface a;
  protected EglCore a;
  
  public EglSurfaceBase(EglCore paramEglCore)
  {
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewEglCore = paramEglCore;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewEglCore.a(this.jdField_a_of_type_AndroidOpenglEGLSurface);
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLSurface == EGL14.EGL_NO_SURFACE)
    {
      this.jdField_a_of_type_AndroidOpenglEGLSurface = this.jdField_a_of_type_ComTencentQqcamerakitPreviewEglCore.a(paramInt1, paramInt2);
      return;
    }
    throw new IllegalStateException("surface already created");
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewEglCore.b(this.jdField_a_of_type_AndroidOpenglEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */