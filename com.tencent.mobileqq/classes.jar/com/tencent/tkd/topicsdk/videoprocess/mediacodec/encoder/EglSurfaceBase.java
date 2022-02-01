package com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import com.tencent.tkd.topicsdk.framework.TLog;

@TargetApi(17)
public class EglSurfaceBase
{
  private EGLSurface a;
  protected EglCore a;
  
  public EglSurfaceBase(EglCore paramEglCore)
  {
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore = paramEglCore;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore.a(this.jdField_a_of_type_AndroidOpenglEGLSurface);
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore.a(this.jdField_a_of_type_AndroidOpenglEGLSurface, paramLong);
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.jdField_a_of_type_AndroidOpenglEGLSurface = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore.a(paramObject);
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore.a(this.jdField_a_of_type_AndroidOpenglEGLSurface);
    if (!bool) {
      TLog.b("EglSurfaceBase", "WARNING: swapBuffers() failed");
    }
    return bool;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore.b(this.jdField_a_of_type_AndroidOpenglEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */