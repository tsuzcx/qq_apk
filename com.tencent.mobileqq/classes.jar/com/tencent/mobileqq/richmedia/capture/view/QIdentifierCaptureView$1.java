package com.tencent.mobileqq.richmedia.capture.view;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class QIdentifierCaptureView$1
  implements GLSurfaceView.EGLContextFactory
{
  QIdentifierCaptureView$1(QIdentifierCaptureView paramQIdentifierCaptureView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "createContext. display = " + paramEGLDisplay + " tid = " + Thread.currentThread().getId());
    }
    this.a.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = paramEGLConfig;
    this.a.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    return this.a.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    this.a.h();
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {
      QLog.e("QIdentifierCaptureView", 1, "destroyContext. display = " + paramEGLDisplay + " context = " + paramEGLContext + " tid = " + Thread.currentThread().getId());
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "destroyContext. display = " + paramEGLDisplay + " context = " + paramEGLContext + " tid = " + Thread.currentThread().getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.1
 * JD-Core Version:    0.7.0.1
 */