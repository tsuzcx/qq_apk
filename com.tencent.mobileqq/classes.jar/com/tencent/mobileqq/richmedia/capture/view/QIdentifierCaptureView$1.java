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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createContext. display = ");
      ((StringBuilder)localObject).append(paramEGLDisplay);
      ((StringBuilder)localObject).append(" tid = ");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.d("QIdentifierCaptureView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    ((QIdentifierCaptureView)localObject).q = paramEGLConfig;
    ((QIdentifierCaptureView)localObject).r = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    return this.a.r;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    this.a.f();
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      paramEGL10 = new StringBuilder();
      paramEGL10.append("destroyContext. display = ");
      paramEGL10.append(paramEGLDisplay);
      paramEGL10.append(" context = ");
      paramEGL10.append(paramEGLContext);
      paramEGL10.append(" tid = ");
      paramEGL10.append(Thread.currentThread().getId());
      QLog.e("QIdentifierCaptureView", 1, paramEGL10.toString());
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
      QLog.d("QIdentifierCaptureView", 2, paramEGL10.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView.1
 * JD-Core Version:    0.7.0.1
 */