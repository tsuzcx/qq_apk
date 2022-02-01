package com.tencent.richmedia.videocompress.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.util.Log;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
public class OutputSurface
  implements SurfaceTexture.OnFrameAvailableListener
{
  static final int EGL_OPENGL_ES2_BIT = 4;
  static final String TAG = "OutputSurface";
  static final boolean VERBOSE = false;
  EGL10 mEGL;
  EGLContext mEGLContext;
  EGLDisplay mEGLDisplay;
  EGLSurface mEGLSurface;
  boolean mFrameAvailable;
  Object mFrameSyncObject = new Object();
  Surface mSurface;
  SurfaceTexture mSurfaceTexture;
  TextureRender mTextureRender;
  
  public OutputSurface()
  {
    setup();
  }
  
  public OutputSurface(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      eglSetup(paramInt1, paramInt2);
      makeCurrent();
      setup();
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @SuppressLint({"NewApi"})
  public void awaitNewImage()
  {
    synchronized (this.mFrameSyncObject)
    {
      for (;;)
      {
        boolean bool = this.mFrameAvailable;
        if (bool) {
          break;
        }
        try
        {
          this.mFrameSyncObject.wait(5000L);
          if (this.mFrameAvailable) {
            continue;
          }
          throw new RuntimeException("Surface frame wait timed out");
        }
        catch (InterruptedException localInterruptedException)
        {
          label46:
          break label46;
        }
        Thread.currentThread().interrupt();
      }
      this.mFrameAvailable = false;
      this.mTextureRender.checkGlError("before updateTexImage");
      this.mSurfaceTexture.updateTexImage();
      return;
    }
  }
  
  public void changeFragmentShader(String paramString)
  {
    this.mTextureRender.changeFragmentShader(paramString);
  }
  
  void checkEglError(String paramString)
  {
    for (int i = 0;; i = 1)
    {
      int j = this.mEGL.eglGetError();
      if (j == 12288) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(j));
      Log.e("OutputSurface", localStringBuilder.toString());
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
  
  public void drawImage()
  {
    this.mTextureRender.drawFrame(this.mSurfaceTexture);
  }
  
  void eglSetup(int paramInt1, int paramInt2)
  {
    this.mEGL = ((EGL10)EGLContext.getEGL());
    this.mEGLDisplay = this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEGL.eglInitialize(this.mEGLDisplay, null))
    {
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      if (this.mEGL.eglChooseConfig(this.mEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12339, 1, 12352, 4, 12344 }, arrayOfEGLConfig, 1, arrayOfInt))
      {
        this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, arrayOfEGLConfig[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
        checkEglError("eglCreateContext");
        if (this.mEGLContext != null)
        {
          this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, arrayOfEGLConfig[0], new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
          checkEglError("eglCreatePbufferSurface");
          if (this.mEGLSurface != null) {
            return;
          }
          throw new RuntimeException("surface was null");
        }
        throw new RuntimeException("null context");
      }
      throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
    }
    throw new RuntimeException("unable to initialize EGL10");
  }
  
  public Surface getSurface()
  {
    return this.mSurface;
  }
  
  public void makeCurrent()
  {
    if (this.mEGL != null)
    {
      checkEglError("before makeCurrent");
      EGL10 localEGL10 = this.mEGL;
      EGLDisplay localEGLDisplay = this.mEGLDisplay;
      EGLSurface localEGLSurface = this.mEGLSurface;
      if (localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.mEGLContext)) {
        return;
      }
      throw new RuntimeException("eglMakeCurrent failed");
    }
    throw new RuntimeException("not configured for makeCurrent");
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.mFrameSyncObject)
    {
      if (!this.mFrameAvailable)
      {
        this.mFrameAvailable = true;
        this.mFrameSyncObject.notifyAll();
        return;
      }
      throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
    }
  }
  
  public void release()
  {
    EGL10 localEGL10 = this.mEGL;
    if (localEGL10 != null)
    {
      if (localEGL10.eglGetCurrentContext().equals(this.mEGLContext)) {
        this.mEGL.eglMakeCurrent(this.mEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      }
      this.mEGL.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
      this.mEGL.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    }
    this.mSurface.release();
    this.mEGLDisplay = null;
    this.mEGLContext = null;
    this.mEGLSurface = null;
    this.mEGL = null;
    this.mTextureRender = null;
    this.mSurface = null;
    this.mSurfaceTexture = null;
  }
  
  void setup()
  {
    this.mTextureRender = new TextureRender();
    this.mTextureRender.surfaceCreated();
    this.mSurfaceTexture = new SurfaceTexture(this.mTextureRender.getTextureId());
    this.mSurfaceTexture.setOnFrameAvailableListener(this);
    this.mSurface = new Surface(this.mSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.mediacodec.OutputSurface
 * JD-Core Version:    0.7.0.1
 */