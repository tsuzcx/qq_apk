package com.tencent.vbox.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import com.tencent.vbox.encode.hard.GlUtil;

public class EglHelper
{
  public static final String TAG = EglHelper.class.getSimpleName();
  EGLConfig mEGLConfig;
  EGLContext mEGLContext;
  EGLDisplay mEGLDisplay;
  EGLSurface mEGLSurface;
  private EGLContext mSavedEglContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay mSavedEglDisplay;
  private EGLSurface mSavedEglDrawSurface;
  private EGLSurface mSavedEglReadSurface;
  
  public static boolean hasGlContext()
  {
    return EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT;
  }
  
  public void destroy()
  {
    EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
    EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.mEGLDisplay);
  }
  
  public void makeCurrent()
  {
    EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
  }
  
  public void restoreRenderState()
  {
    if ((this.mSavedEglContext != EGL14.EGL_NO_CONTEXT) && (!EGL14.eglMakeCurrent(this.mSavedEglDisplay, this.mSavedEglDrawSurface, this.mSavedEglReadSurface, this.mSavedEglContext))) {
      Log.e(TAG, "eglMakeCurrent failed");
    }
  }
  
  public void saveRenderState()
  {
    if (hasGlContext())
    {
      this.mSavedEglDisplay = EGL14.eglGetCurrentDisplay();
      this.mSavedEglDrawSurface = EGL14.eglGetCurrentSurface(12377);
      this.mSavedEglReadSurface = EGL14.eglGetCurrentSurface(12378);
      this.mSavedEglContext = EGL14.eglGetCurrentContext();
    }
  }
  
  public void setup()
  {
    Log.i(TAG, "eglSetup");
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      Log.e(TAG, "unable to get EGL14 display");
    }
    do
    {
      return;
      Object localObject = new int[2];
      if (!EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
      {
        this.mEGLDisplay = null;
        Log.e(TAG, "unable to initialize EGL14");
        return;
      }
      localObject = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      EGLDisplay localEGLDisplay = this.mEGLDisplay;
      int i = localObject.length;
      if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12325, 0, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344 }, 0, (EGLConfig[])localObject, 0, i, arrayOfInt, 0))
      {
        Log.e(TAG, "unable to find RGB888+recordable ES2 EGL config");
        return;
      }
      this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
      if (this.mEGLContext == null)
      {
        Log.e(TAG, "null context");
        return;
      }
      this.mEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, localObject[0], new int[] { 12375, 100, 12374, 100, 12344 }, 0);
      GlUtil.checkEglError("eglCreateWindowSurface");
    } while (this.mEGLSurface != null);
    Log.e(TAG, "surface was null");
  }
  
  public int swap()
  {
    if (!EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface)) {
      return EGL14.eglGetError();
    }
    return 12288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.egl.EglHelper
 * JD-Core Version:    0.7.0.1
 */