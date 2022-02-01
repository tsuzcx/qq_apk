package com.tencent.qqcamerakit.preview;

import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qqcamerakit.common.QLog;

public class EglHandlerThread
  extends HandlerThread
{
  private EglCore a;
  private EGLContext b;
  private EglSurfaceBase c;
  private Handler d;
  private boolean e = false;
  
  public EglHandlerThread(String paramString, EGLContext paramEGLContext)
  {
    super(paramString);
    this.b = paramEGLContext;
  }
  
  private void c()
  {
    if (getLooper().getThread() != Thread.currentThread())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("release should be called in origin thread ");
      ((StringBuilder)localObject).append(getThreadId());
      QLog.a("EglHandlerThread", 1, new Object[] { ((StringBuilder)localObject).toString() });
      return;
    }
    if (!this.e) {
      return;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((EglSurfaceBase)localObject).a();
      this.c = null;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((EglCore)localObject).a();
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public Handler b()
  {
    return this.d;
  }
  
  protected void onLooperPrepared()
  {
    try
    {
      super.onLooperPrepared();
      this.d = new Handler(getLooper());
      this.a = new EglCore(this.b, 1);
      this.c = new EglSurfaceBase(this.a);
      this.c.a(64, 64);
      this.c.b();
      this.e = true;
      return;
    }
    catch (Exception localException)
    {
      this.e = false;
      QLog.a("EglHandlerThread", 1, localException, new Object[0]);
    }
  }
  
  public boolean quit()
  {
    if (getLooper().getThread() != Thread.currentThread())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("quit should be called in origin thread ");
      localStringBuilder.append(getThreadId());
      QLog.a("EglHandlerThread", 1, new Object[] { localStringBuilder.toString() });
      this.d.post(new EglHandlerThread.1(this));
      return false;
    }
    boolean bool = super.quit();
    c();
    return bool;
  }
  
  public boolean quitSafely()
  {
    this.d.post(new EglHandlerThread.2(this));
    return super.quitSafely();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.EglHandlerThread
 * JD-Core Version:    0.7.0.1
 */