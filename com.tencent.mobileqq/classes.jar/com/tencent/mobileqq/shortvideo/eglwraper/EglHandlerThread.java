package com.tencent.mobileqq.shortvideo.eglwraper;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.sveffects.SLog;

@TargetApi(18)
public class EglHandlerThread
  extends HandlerThread
{
  private static final String TAG = "EglHandlerThread";
  private EglCore eglCore;
  private EglSurfaceBase eglSurfaceBase;
  private Handler handler;
  private boolean initSuccess = false;
  private EGLContext sharedContext;
  
  public EglHandlerThread(String paramString, EGLContext paramEGLContext)
  {
    super(paramString);
    this.sharedContext = paramEGLContext;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public boolean isInitSuccess()
  {
    return this.initSuccess;
  }
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
    this.handler = new Handler(getLooper());
    this.eglCore = new EglCore(this.sharedContext, 1);
    this.eglSurfaceBase = new EglSurfaceBase(this.eglCore);
    try
    {
      this.eglSurfaceBase.createOffscreenSurface(64, 64);
      this.eglSurfaceBase.makeCurrent();
      this.initSuccess = true;
      return;
    }
    catch (Exception localException)
    {
      this.initSuccess = false;
      SLog.e("EglHandlerThread", localException);
    }
  }
  
  public boolean quit()
  {
    boolean bool = super.quit();
    release();
    return bool;
  }
  
  public boolean quitSafely()
  {
    boolean bool = super.quitSafely();
    release();
    return bool;
  }
  
  public void release()
  {
    if (!this.initSuccess) {
      return;
    }
    Object localObject = this.eglSurfaceBase;
    if (localObject != null)
    {
      ((EglSurfaceBase)localObject).releaseEglSurface();
      this.eglSurfaceBase = null;
    }
    localObject = this.eglCore;
    if (localObject != null)
    {
      ((EglCore)localObject).release();
      this.eglCore = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread
 * JD-Core Version:    0.7.0.1
 */