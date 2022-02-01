package com.tencent.qqcamerakit.preview;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.qqcamerakit.common.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class CameraCaptureView$1
  implements GLSurfaceView.EGLContextFactory
{
  private int b = 12440;
  
  CameraCaptureView$1(CameraCaptureView paramCameraCaptureView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = this.b;
    if (QLog.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createContext. display = ");
      ((StringBuilder)localObject).append(paramEGLDisplay);
      ((StringBuilder)localObject).append(" tid = ");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.d("CameraCaptureView", 1, new Object[] { ((StringBuilder)localObject).toString() });
    }
    Object localObject = this.a;
    ((CameraCaptureView)localObject).h = paramEGLConfig;
    ((CameraCaptureView)localObject).i = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    return this.a.i;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    this.a.a();
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      paramEGL10 = new StringBuilder();
      paramEGL10.append("destroyContext. display = ");
      paramEGL10.append(paramEGLDisplay);
      paramEGL10.append(" context = ");
      paramEGL10.append(paramEGLContext);
      paramEGL10.append(" tid = ");
      paramEGL10.append(Thread.currentThread().getId());
      QLog.a("CameraCaptureView", 1, new Object[] { paramEGL10.toString() });
    }
    if (QLog.a())
    {
      paramEGL10 = new StringBuilder();
      paramEGL10.append("destroyContext. display = ");
      paramEGL10.append(paramEGLDisplay);
      paramEGL10.append(" context = ");
      paramEGL10.append(paramEGLContext);
      paramEGL10.append(" tid = ");
      paramEGL10.append(Thread.currentThread().getId());
      QLog.d("CameraCaptureView", 1, new Object[] { paramEGL10.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.CameraCaptureView.1
 * JD-Core Version:    0.7.0.1
 */