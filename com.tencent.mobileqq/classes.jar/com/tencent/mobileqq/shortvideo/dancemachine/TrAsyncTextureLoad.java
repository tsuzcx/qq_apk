package com.tencent.mobileqq.shortvideo.dancemachine;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.os.Handler;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@TargetApi(18)
public class TrAsyncTextureLoad
{
  private static volatile TrAsyncTextureLoad INSTANCE;
  private EglHandlerThread eglHandlerThread;
  private final Object mLock = new Object();
  private ArrayList<HashMap<String, GLImage>> needUpdateCache = new ArrayList();
  
  public static TrAsyncTextureLoad getInstance()
  {
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new TrAsyncTextureLoad();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  public void asyncLoadBoyTexture()
  {
    boolean bool = false;
    if (this.eglHandlerThread != null) {
      bool = this.eglHandlerThread.isInitSuccess();
    }
    DanceLog.printFrameQueue("GLFrameImage", "asyncLoadBoyTexture initSuccess=" + bool);
    if (bool) {
      this.eglHandlerThread.getHandler().post(new TrAsyncTextureLoad.1(this));
    }
  }
  
  void notifyGLThreadUpdateTextureCache(HashMap<String, GLImage> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      DanceLog.printFrameQueue("GLFrameImage", "notifyGLThreadUpdateTextureCache needDo=" + bool + " itemSize=" + paramHashMap.size());
      if (bool) {
        synchronized (this.mLock)
        {
          this.needUpdateCache.add(paramHashMap);
          return;
        }
      }
      return;
    }
  }
  
  public void onSurfaceCreate()
  {
    EglHandlerThread localEglHandlerThread = this.eglHandlerThread;
    this.eglHandlerThread = new EglHandlerThread("async_load_texture", EGL14.eglGetCurrentContext());
    this.eglHandlerThread.start();
    if (localEglHandlerThread != null)
    {
      DanceLog.printFrameQueue("GLFrameImage", "TrAsyncTextureLoad lastHandler!=null");
      localEglHandlerThread.quitSafely();
    }
  }
  
  public void onSurfaceDestroy()
  {
    if (this.eglHandlerThread != null)
    {
      this.eglHandlerThread.quitSafely();
      this.eglHandlerThread = null;
    }
  }
  
  public void processInterrupt()
  {
    DanceLog.printFrameQueue("GLFrameImage", "processInterrupt");
    int i = this.needUpdateCache.size();
    DanceLog.printFrameQueue("GLFrameImage", "processInterrupt unsafeSize=" + i);
    if (i > 0)
    {
      for (;;)
      {
        HashMap localHashMap;
        synchronized (this.mLock)
        {
          if (this.needUpdateCache.size() <= 0) {
            break;
          }
          Iterator localIterator1 = this.needUpdateCache.iterator();
          if (!localIterator1.hasNext()) {
            break;
          }
          localHashMap = (HashMap)localIterator1.next();
          Iterator localIterator2 = localHashMap.keySet().iterator();
          if (localIterator2.hasNext())
          {
            GLImage localGLImage = (GLImage)localHashMap.get((String)localIterator2.next());
            if (localGLImage == null) {
              continue;
            }
            localGLImage.release();
          }
        }
        localHashMap.clear();
      }
      this.needUpdateCache.clear();
    }
  }
  
  public void updateGLFrameImageCache()
  {
    int i = this.needUpdateCache.size();
    DanceLog.printFrameQueue("GLFrameImage", "updateGLFrameImageCache unsafeSize=" + i);
    if (i > 0)
    {
      synchronized (this.mLock)
      {
        i = this.needUpdateCache.size();
        DanceLog.printFrameQueue("GLFrameImage", "updateGLFrameImageCache safeSize=" + i);
        if (i > 0)
        {
          Iterator localIterator = this.needUpdateCache.iterator();
          if (localIterator.hasNext())
          {
            HashMap localHashMap = (HashMap)localIterator.next();
            DanceLog.printFrameQueue("GLFrameImage", "updateGLFrameImageCache itemSize=" + localHashMap.size());
            GLFrameImage.updateGLFrameImageCache(localHashMap);
            localHashMap.clear();
          }
        }
      }
      this.needUpdateCache.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad
 * JD-Core Version:    0.7.0.1
 */