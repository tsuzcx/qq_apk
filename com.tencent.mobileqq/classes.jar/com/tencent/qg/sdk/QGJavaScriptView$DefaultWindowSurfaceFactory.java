package com.tencent.qg.sdk;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class QGJavaScriptView$DefaultWindowSurfaceFactory
  implements QGJavaScriptView.EGLWindowSurfaceFactory
{
  public EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    try
    {
      paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
      return paramEGL10;
    }
    catch (IllegalArgumentException paramEGL10)
    {
      Log.e("EJJavaScriptView", "eglCreateWindowSurface", paramEGL10);
    }
    return null;
  }
  
  public void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.DefaultWindowSurfaceFactory
 * JD-Core Version:    0.7.0.1
 */