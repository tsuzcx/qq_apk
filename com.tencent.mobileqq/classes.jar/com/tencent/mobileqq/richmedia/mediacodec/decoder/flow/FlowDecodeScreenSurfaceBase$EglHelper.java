package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class FlowDecodeScreenSurfaceBase$EglHelper
{
  private WeakReference<FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView> jdField_a_of_type_JavaLangRefWeakReference;
  EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  EGLConfig jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig;
  EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  
  public FlowDecodeScreenSurfaceBase$EglHelper(WeakReference<FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + " failed: " + paramInt;
  }
  
  private void a(String paramString)
  {
    a(paramString, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
  }
  
  public static void a(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    SLog.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + paramString);
    throw new RuntimeException(paramString);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    SLog.d(paramString1, a(paramString2, paramInt));
  }
  
  public void a()
  {
    SLog.d("EglHelper", "start() tid=" + Thread.currentThread().getId());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed");
    }
    Object localObject = new int[2];
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject)) {
      throw new RuntimeException("eglInitialize failed");
    }
    localObject = (FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != EGL10.EGL_NO_CONTEXT)) {
        break label289;
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError() == 12294)
      {
        throw new FlowDecodeScreenSurfaceBase.FlowDecodeException(a("createContext", 12294));
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = ((FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView)localObject).a().chooseConfig(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
        SLog.a("FlowEdit_FlowDecodeScreenSurfaceBase", "chooseConfig %s", this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig);
        try
        {
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = ((FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView)localObject).a().createContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig);
          SLog.a("FlowEdit_FlowDecodeScreenSurfaceBase", "createContext %s", this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          SLog.d("FlowEdit_FlowDecodeScreenSurfaceBase", localIllegalArgumentException, "createContext", new Object[0]);
          throw new FlowDecodeScreenSurfaceBase.FlowDecodeException("createContext failed", localIllegalArgumentException);
        }
      }
    }
    a("createContext");
    label289:
    SLog.d("EglHelper", "createContext " + this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext + " tid=" + Thread.currentThread().getId());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreatePbufferSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    if ((this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface == null) || (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface == EGL10.EGL_NO_SURFACE))
    {
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError() == 12299) {
        SLog.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
      }
      return false;
    }
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext))
    {
      a("EGLHelper", "eglMakeCurrent", this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface != EGL10.EGL_NO_SURFACE))
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
    }
  }
  
  public void c()
  {
    SLog.d("EglHelper", "finish() tid=" + Thread.currentThread().getId());
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != null)
    {
      FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView localFakeGLSurfaceView = (FlowDecodeScreenSurfaceBase.EglHelper.FakeGLSurfaceView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFakeGLSurfaceView != null) {
        localFakeGLSurfaceView.a().destroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    }
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != null)
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglTerminate(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase.EglHelper
 * JD-Core Version:    0.7.0.1
 */