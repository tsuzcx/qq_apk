package com.tencent.mobileqq.richmedia.capture.view;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class CameraCaptureView$1
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  CameraCaptureView$1(CameraCaptureView paramCameraCaptureView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = this.jdField_a_of_type_Int;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createContext. display = ");
      ((StringBuilder)localObject).append(paramEGLDisplay);
      ((StringBuilder)localObject).append(" tid = ");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.d("CameraCaptureView", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
    ((CameraCaptureView)localObject).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = paramEGLConfig;
    ((CameraCaptureView)localObject).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.i();
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      paramEGL10 = new StringBuilder();
      paramEGL10.append("destroyContext. display = ");
      paramEGL10.append(paramEGLDisplay);
      paramEGL10.append(" context = ");
      paramEGL10.append(paramEGLContext);
      paramEGL10.append(" tid = ");
      paramEGL10.append(Thread.currentThread().getId());
      QLog.e("CameraCaptureView", 1, paramEGL10.toString());
    }
    if (QLog.isColorLevel())
    {
      paramEGL10 = new StringBuilder();
      paramEGL10.append("destroyContext. display = ");
      paramEGL10.append(paramEGLDisplay);
      paramEGL10.append(" context = ");
      paramEGL10.append(paramEGLContext);
      paramEGL10.append(" tid = ");
      paramEGL10.append(Thread.currentThread().getId());
      QLog.d("CameraCaptureView", 1, paramEGL10.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.1
 * JD-Core Version:    0.7.0.1
 */