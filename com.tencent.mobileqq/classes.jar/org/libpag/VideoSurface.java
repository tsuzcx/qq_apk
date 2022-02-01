package org.libpag;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class VideoSurface
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static int HandlerThreadCount;
  private static final Object handlerLock = new Object();
  private static HandlerThread handlerThread;
  private boolean frameAvailable = false;
  private final Object frameSyncObject = new Object();
  private int height = 0;
  private Surface outputSurface;
  private boolean released = false;
  private SurfaceTexture surfaceTexture;
  private int width = 0;
  
  private static VideoSurface Make(int paramInt1, int paramInt2)
  {
    VideoSurface localVideoSurface = new VideoSurface();
    localVideoSurface.width = paramInt1;
    localVideoSurface.height = paramInt2;
    synchronized (handlerLock)
    {
      StartHandlerThread();
      if (Build.VERSION.SDK_INT >= 26)
      {
        localVideoSurface.surfaceTexture = new SurfaceTexture(false);
      }
      else
      {
        localVideoSurface.surfaceTexture = new SurfaceTexture(0);
        localVideoSurface.surfaceTexture.detachFromGLContext();
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        localVideoSurface.surfaceTexture.setOnFrameAvailableListener(localVideoSurface, new Handler(handlerThread.getLooper()));
      }
      else
      {
        localVideoSurface.surfaceTexture.setOnFrameAvailableListener(localVideoSurface);
        localVideoSurface.reflectLooper();
      }
      localVideoSurface.outputSurface = new Surface(localVideoSurface.surfaceTexture);
      return localVideoSurface;
    }
  }
  
  private static void StartHandlerThread()
  {
    try
    {
      HandlerThreadCount += 1;
      if (handlerThread == null)
      {
        handlerThread = new HandlerThread("libpag_VideoSurface");
        handlerThread.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean attachToGLContext(int paramInt)
  {
    try
    {
      this.surfaceTexture.attachToGLContext(paramInt);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private Surface getOutputSurface()
  {
    return this.outputSurface;
  }
  
  private void onRelease()
  {
    if (this.released) {
      return;
    }
    this.released = true;
    synchronized (handlerLock)
    {
      HandlerThreadCount -= 1;
      if (HandlerThreadCount == 0)
      {
        handlerThread.quit();
        handlerThread = null;
      }
      ??? = this.outputSurface;
      if (??? != null)
      {
        ((Surface)???).release();
        this.outputSurface = null;
      }
      ??? = this.surfaceTexture;
      if (??? != null)
      {
        ((SurfaceTexture)???).release();
        this.surfaceTexture = null;
      }
      return;
    }
  }
  
  private void reflectLooper()
  {
    Object localObject2 = SurfaceTexture.class.getDeclaredClasses();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = localObject2[i];
      if (localObject1.getName().toLowerCase().contains("handler")) {
        break label50;
      }
      i += 1;
    }
    Object localObject1 = null;
    label50:
    if (localObject1 == null) {
      return;
    }
    try
    {
      localObject1 = localObject1.getConstructor(new Class[] { SurfaceTexture.class, Looper.class }).newInstance(new Object[] { this.surfaceTexture, handlerThread.getLooper() });
      localObject2 = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(this.surfaceTexture, localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean updateTexImage()
  {
    Object localObject1 = this.frameSyncObject;
    int i = 10;
    try
    {
      for (;;)
      {
        boolean bool = this.frameAvailable;
        if ((bool) || (i <= 0)) {
          break;
        }
        i -= 1;
        try
        {
          this.frameSyncObject.wait(50L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.frameAvailable = false;
      if (i == 0) {
        return false;
      }
      try
      {
        this.surfaceTexture.updateTexImage();
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
  
  private int videoHeight()
  {
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[5]);
    if (f > 0.0F) {
      return Math.round(this.height / (f + (arrayOfFloat[13] - f) * 2.0F));
    }
    return this.height;
  }
  
  private int videoWidth()
  {
    float[] arrayOfFloat = new float[16];
    this.surfaceTexture.getTransformMatrix(arrayOfFloat);
    float f = Math.abs(arrayOfFloat[0]);
    if (f > 0.0F) {
      return Math.round(this.width / (f + arrayOfFloat[12] * 2.0F));
    }
    return this.width;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.frameSyncObject)
    {
      if (this.frameAvailable)
      {
        new RuntimeException("frameAvailable already set, frame could be dropped").printStackTrace();
        return;
      }
      this.frameAvailable = true;
      this.frameSyncObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.VideoSurface
 * JD-Core Version:    0.7.0.1
 */