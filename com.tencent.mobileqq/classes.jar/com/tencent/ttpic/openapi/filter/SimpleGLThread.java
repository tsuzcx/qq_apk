package com.tencent.ttpic.openapi.filter;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.util.HandlerUtil;

@TargetApi(18)
public class SimpleGLThread
{
  private EglCore mCore;
  private Handler mHandler;
  private OffscreenSurface mOffscreenSurface;
  private String mThreadName;
  
  public SimpleGLThread(EGLContext paramEGLContext, String paramString)
  {
    this(paramEGLContext, paramString, null);
  }
  
  public SimpleGLThread(EGLContext paramEGLContext, String paramString, SimpleGLThread.OnSurfaceCreatedListener paramOnSurfaceCreatedListener)
  {
    this.mThreadName = paramString;
    paramString = new HandlerThread(this.mThreadName);
    paramString.start();
    this.mHandler = new Handler(paramString.getLooper());
    this.mHandler.post(new SimpleGLThread.1(this, paramEGLContext, paramOnSurfaceCreatedListener));
  }
  
  public void destroy()
  {
    destroy(null);
  }
  
  public void destroy(Runnable paramRunnable)
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.post(new SimpleGLThread.2(this, paramRunnable));
    }
  }
  
  public Looper getLooper()
  {
    Handler localHandler = this.mHandler;
    if (localHandler == null) {
      return null;
    }
    return localHandler.getLooper();
  }
  
  public void makeCurrent()
  {
    this.mOffscreenSurface.makeCurrent();
  }
  
  public void postJob(Runnable paramRunnable)
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  public void postJobSync(Runnable paramRunnable)
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      localHandler.post(paramRunnable);
      HandlerUtil.waitDone(this.mHandler);
    }
  }
  
  public void removeCallbacksAndMessages(Object paramObject)
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(paramObject);
    }
  }
  
  public void sendEmptyMessage(int paramInt)
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(paramInt);
    }
  }
  
  public void waitDone()
  {
    HandlerUtil.waitDone(this.mHandler);
  }
  
  public void waitDone(int paramInt)
  {
    HandlerUtil.waitDone(this.mHandler, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.SimpleGLThread
 * JD-Core Version:    0.7.0.1
 */