package com.tencent.qqcamerakit.preview;

import android.opengl.EGL14;
import android.opengl.EGLSurface;

public class EglSurfaceBase
{
  protected EglCore a;
  private EGLSurface b = EGL14.EGL_NO_SURFACE;
  
  public EglSurfaceBase(EglCore paramEglCore)
  {
    this.a = paramEglCore;
  }
  
  public void a()
  {
    this.a.a(this.b);
    this.b = EGL14.EGL_NO_SURFACE;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.b == EGL14.EGL_NO_SURFACE)
    {
      this.b = this.a.a(paramInt1, paramInt2);
      return;
    }
    throw new IllegalStateException("surface already created");
  }
  
  public void b()
  {
    this.a.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */