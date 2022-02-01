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
    if (INSTANCE == null) {
      try
      {
        if (INSTANCE == null) {
          INSTANCE = new TrAsyncTextureLoad();
        }
      }
      finally {}
    }
    return INSTANCE;
  }
  
  public void asyncLoadBoyTexture()
  {
    Object localObject = this.eglHandlerThread;
    boolean bool;
    if (localObject != null) {
      bool = ((EglHandlerThread)localObject).isInitSuccess();
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("asyncLoadBoyTexture initSuccess=");
    ((StringBuilder)localObject).append(bool);
    DanceLog.printFrameQueue("GLFrameImage", ((StringBuilder)localObject).toString());
    if (bool) {
      this.eglHandlerThread.getHandler().post(new TrAsyncTextureLoad.1(this));
    }
  }
  
  void notifyGLThreadUpdateTextureCache(HashMap<String, GLImage> paramHashMap)
  {
    boolean bool;
    if ((paramHashMap != null) && (paramHashMap.size() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("notifyGLThreadUpdateTextureCache needDo=");
    ((StringBuilder)???).append(bool);
    ((StringBuilder)???).append(" itemSize=");
    ((StringBuilder)???).append(paramHashMap.size());
    DanceLog.printFrameQueue("GLFrameImage", ((StringBuilder)???).toString());
    if (bool) {
      synchronized (this.mLock)
      {
        this.needUpdateCache.add(paramHashMap);
        return;
      }
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
    EglHandlerThread localEglHandlerThread = this.eglHandlerThread;
    if (localEglHandlerThread != null)
    {
      localEglHandlerThread.quitSafely();
      this.eglHandlerThread = null;
    }
  }
  
  public void processInterrupt()
  {
    DanceLog.printFrameQueue("GLFrameImage", "processInterrupt");
    int i = this.needUpdateCache.size();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("processInterrupt unsafeSize=");
    ((StringBuilder)???).append(i);
    DanceLog.printFrameQueue("GLFrameImage", ((StringBuilder)???).toString());
    if (i > 0) {
      synchronized (this.mLock)
      {
        if (this.needUpdateCache.size() > 0)
        {
          Iterator localIterator1 = this.needUpdateCache.iterator();
          while (localIterator1.hasNext())
          {
            HashMap localHashMap = (HashMap)localIterator1.next();
            Iterator localIterator2 = localHashMap.keySet().iterator();
            while (localIterator2.hasNext())
            {
              GLImage localGLImage = (GLImage)localHashMap.get((String)localIterator2.next());
              if (localGLImage != null) {
                localGLImage.release();
              }
            }
            localHashMap.clear();
          }
        }
        this.needUpdateCache.clear();
        return;
      }
    }
  }
  
  public void updateGLFrameImageCache()
  {
    int i = this.needUpdateCache.size();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("updateGLFrameImageCache unsafeSize=");
    ((StringBuilder)???).append(i);
    DanceLog.printFrameQueue("GLFrameImage", ((StringBuilder)???).toString());
    if (i > 0) {
      synchronized (this.mLock)
      {
        i = this.needUpdateCache.size();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateGLFrameImageCache safeSize=");
        ((StringBuilder)localObject2).append(i);
        DanceLog.printFrameQueue("GLFrameImage", ((StringBuilder)localObject2).toString());
        if (i > 0)
        {
          localObject2 = this.needUpdateCache.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            HashMap localHashMap = (HashMap)((Iterator)localObject2).next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateGLFrameImageCache itemSize=");
            localStringBuilder.append(localHashMap.size());
            DanceLog.printFrameQueue("GLFrameImage", localStringBuilder.toString());
            GLFrameImage.updateGLFrameImageCache(localHashMap);
            localHashMap.clear();
          }
        }
        this.needUpdateCache.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad
 * JD-Core Version:    0.7.0.1
 */