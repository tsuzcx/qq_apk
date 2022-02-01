package com.tencent.richmedia.videocompress.mediacodec;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import java.lang.reflect.Method;

@TargetApi(18)
public class InputSurface
{
  static final int EGL_OPENGL_ES2_BIT = 4;
  static final int EGL_RECORDABLE_ANDROID = 12610;
  static final String TAG = "InputSurface";
  static final boolean VERBOSE = false;
  EGLContext mEGLContext;
  EGLDisplay mEGLDisplay;
  EGLSurface mEGLSurface;
  Surface mSurface;
  
  public InputSurface(Surface paramSurface)
  {
    if (paramSurface != null)
    {
      this.mSurface = paramSurface;
      eglSetup();
      return;
    }
    throw new NullPointerException();
  }
  
  void checkEglError(String paramString)
  {
    for (int i = 0;; i = 1)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(j));
      Log.e("InputSurface", localStringBuilder.toString());
    }
    if (i == 0) {
      return;
    }
    paramString = new RuntimeException("EGL error encountered (see log)");
    for (;;)
    {
      throw paramString;
    }
  }
  
  void eglSetup()
  {
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
      {
        localObject = new EGLConfig[1];
        int[] arrayOfInt = new int[1];
        EGLDisplay localEGLDisplay = this.mEGLDisplay;
        int i = localObject.length;
        if (EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344 }, 0, (EGLConfig[])localObject, 0, i, arrayOfInt, 0))
        {
          this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          checkEglError("eglCreateContext");
          if (this.mEGLContext != null)
          {
            this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, localObject[0], this.mSurface, new int[] { 12344 }, 0);
            checkEglError("eglCreateWindowSurface");
            if (this.mEGLSurface != null) {
              return;
            }
            throw new RuntimeException("surface was null");
          }
          throw new RuntimeException("null context");
        }
        throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
      }
      this.mEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    throw new RuntimeException("unable to get EGL14 display");
  }
  
  public void makeCurrent()
  {
    EGLDisplay localEGLDisplay = this.mEGLDisplay;
    EGLSurface localEGLSurface = this.mEGLSurface;
    if (EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.mEGLContext)) {
      return;
    }
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public void release()
  {
    if (EGL14.eglGetCurrentContext().equals(this.mEGLContext)) {
      EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
    }
    EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
    EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    this.mSurface.release();
    this.mEGLDisplay = null;
    this.mEGLContext = null;
    this.mEGLSurface = null;
    this.mSurface = null;
  }
  
  public void setPresentationTime(long paramLong)
  {
    try
    {
      Class.forName("android.opengl.EGLExt").getDeclaredMethod("eglPresentationTimeANDROID", new Class[] { EGLDisplay.class, EGLSurface.class, Long.TYPE }).invoke(null, new Object[] { this.mEGLDisplay, this.mEGLSurface, Long.valueOf(paramLong) });
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean swapBuffers()
  {
    return EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.mediacodec.InputSurface
 * JD-Core Version:    0.7.0.1
 */