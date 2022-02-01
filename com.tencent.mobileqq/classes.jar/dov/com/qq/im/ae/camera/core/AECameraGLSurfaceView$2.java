package dov.com.qq.im.ae.camera.core;

import android.opengl.GLSurfaceView.EGLContextFactory;
import bnrh;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class AECameraGLSurfaceView$2
  implements GLSurfaceView.EGLContextFactory
{
  private final int eglContextClientVersion = 12440;
  
  AECameraGLSurfaceView$2(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AECameraGLSurfaceView.access$202(this.this$0, paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }));
    bnrh.d("AECameraGLSurfaceView", "[EGLContext] createContext finish");
    return AECameraGLSurfaceView.access$200(this.this$0);
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    bnrh.d("AECameraGLSurfaceView", "[EGLContext] destroyContext start");
    if (paramEGLDisplay == null) {
      bnrh.d("AECameraGLSurfaceView", "EGLDisplay is null.");
    }
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    bnrh.d("AECameraGLSurfaceView", "[EGLContext] destroyContext finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */