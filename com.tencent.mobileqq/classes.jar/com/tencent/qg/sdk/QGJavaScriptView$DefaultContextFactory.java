package com.tencent.qg.sdk;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class QGJavaScriptView$DefaultContextFactory
  implements QGJavaScriptView.EGLContextFactory
{
  private int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  private QGJavaScriptView$DefaultContextFactory(QGJavaScriptView paramQGJavaScriptView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt1 = new int[3];
    arrayOfInt1[0] = this.EGL_CONTEXT_CLIENT_VERSION;
    arrayOfInt1[1] = this.this$0.mEGLContextClientVersion;
    arrayOfInt1[2] = 12344;
    Object localObject;
    EGLContext localEGLContext;
    label59:
    int[] arrayOfInt2;
    if (this.this$0.sharedEGLConfig == null)
    {
      localObject = paramEGLConfig;
      if (this.this$0.sharedEGLContext != null) {
        break label163;
      }
      localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (this.this$0.mEGLContextClientVersion == 0) {
        break label175;
      }
      arrayOfInt2 = arrayOfInt1;
      label73:
      localObject = paramEGL10.eglCreateContext(paramEGLDisplay, (EGLConfig)localObject, localEGLContext, arrayOfInt2);
      if (((EGL10)EGLContext.getEGL()).eglGetError() != 12294) {
        break label198;
      }
      this.this$0.sharedEGLContext = null;
      if (this.this$0.sharedEGLConfig != null) {
        break label181;
      }
      label123:
      localObject = EGL10.EGL_NO_CONTEXT;
      if (this.this$0.mEGLContextClientVersion == 0) {
        break label192;
      }
    }
    for (;;)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, (EGLContext)localObject, arrayOfInt1);
      localObject = this.this$0.sharedEGLConfig;
      break;
      label163:
      localEGLContext = this.this$0.sharedEGLContext;
      break label59;
      label175:
      arrayOfInt2 = null;
      break label73;
      label181:
      paramEGLConfig = this.this$0.sharedEGLConfig;
      break label123;
      label192:
      arrayOfInt1 = null;
    }
    label198:
    return localObject;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
      QGJavaScriptView.EglHelper.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.DefaultContextFactory
 * JD-Core Version:    0.7.0.1
 */