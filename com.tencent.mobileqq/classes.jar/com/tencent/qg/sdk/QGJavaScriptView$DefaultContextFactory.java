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
    if (this.this$0.sharedEGLConfig == null) {
      localObject = paramEGLConfig;
    } else {
      localObject = this.this$0.sharedEGLConfig;
    }
    EGLContext localEGLContext;
    if (this.this$0.sharedEGLContext == null) {
      localEGLContext = EGL10.EGL_NO_CONTEXT;
    } else {
      localEGLContext = this.this$0.sharedEGLContext;
    }
    int[] arrayOfInt2;
    if (this.this$0.mEGLContextClientVersion != 0) {
      arrayOfInt2 = arrayOfInt1;
    } else {
      arrayOfInt2 = null;
    }
    Object localObject = paramEGL10.eglCreateContext(paramEGLDisplay, (EGLConfig)localObject, localEGLContext, arrayOfInt2);
    if (((EGL10)EGLContext.getEGL()).eglGetError() == 12294)
    {
      localObject = this.this$0;
      ((QGJavaScriptView)localObject).sharedEGLContext = null;
      if (((QGJavaScriptView)localObject).sharedEGLConfig != null) {
        paramEGLConfig = this.this$0.sharedEGLConfig;
      }
      localObject = EGL10.EGL_NO_CONTEXT;
      if (this.this$0.mEGLContextClientVersion == 0) {
        arrayOfInt1 = null;
      }
      localObject = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, (EGLContext)localObject, arrayOfInt1);
    }
    return localObject;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("display:");
      localStringBuilder.append(paramEGLDisplay);
      localStringBuilder.append(" context: ");
      localStringBuilder.append(paramEGLContext);
      Log.e("DefaultContextFactory", localStringBuilder.toString());
      QGJavaScriptView.EglHelper.throwEglException("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.DefaultContextFactory
 * JD-Core Version:    0.7.0.1
 */