package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class GLTextureView$DefaultWindowSurfaceFactory
  implements GLTextureView.EGLWindowSurfaceFactory
{
  public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    try
    {
      paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
      return paramEGL10;
    }
    catch (IllegalArgumentException paramEGL10)
    {
      Log.e("GLTextureView", "eglCreateWindowSurface", paramEGL10);
    }
    return null;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView.DefaultWindowSurfaceFactory
 * JD-Core Version:    0.7.0.1
 */