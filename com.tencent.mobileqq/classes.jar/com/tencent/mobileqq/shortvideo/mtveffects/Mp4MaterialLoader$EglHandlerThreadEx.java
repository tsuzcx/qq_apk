package com.tencent.mobileqq.shortvideo.mtveffects;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Looper;
import com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread;
import java.lang.ref.WeakReference;

public class Mp4MaterialLoader$EglHandlerThreadEx
  extends EglHandlerThread
{
  private WeakReference<Object> mSynObjectRef;
  
  public Mp4MaterialLoader$EglHandlerThreadEx(String paramString, EGLContext paramEGLContext, Object paramObject)
  {
    super(paramString, paramEGLContext);
    if (paramObject != null) {
      this.mSynObjectRef = new WeakReference(paramObject);
    }
  }
  
  public void onLooperExited()
  {
    release();
  }
  
  public void onLooperPrepared()
  {
    super.onLooperPrepared();
    if (this.mSynObjectRef != null)
    {
      Object localObject1 = this.mSynObjectRef.get();
      if (localObject1 != null) {
        try
        {
          localObject1.notify();
          return;
        }
        finally {}
      }
    }
  }
  
  @TargetApi(18)
  public boolean quitSafely()
  {
    Looper localLooper = getLooper();
    if (localLooper != null)
    {
      localLooper.quitSafely();
      return true;
    }
    return false;
  }
  
  public void run()
  {
    try
    {
      super.run();
      onLooperExited();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.Mp4MaterialLoader.EglHandlerThreadEx
 * JD-Core Version:    0.7.0.1
 */