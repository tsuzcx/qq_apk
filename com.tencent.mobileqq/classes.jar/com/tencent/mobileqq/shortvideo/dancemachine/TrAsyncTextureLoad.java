package com.tencent.mobileqq.shortvideo.dancemachine;

import aiap;
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
  private static volatile TrAsyncTextureLoad jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTrAsyncTextureLoad;
  private EglHandlerThread jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static TrAsyncTextureLoad a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTrAsyncTextureLoad == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTrAsyncTextureLoad == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTrAsyncTextureLoad = new TrAsyncTextureLoad();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTrAsyncTextureLoad;
    }
    finally {}
  }
  
  public void a()
  {
    EglHandlerThread localEglHandlerThread = this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread = new EglHandlerThread("async_load_texture", EGL14.eglGetCurrentContext());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread.start();
    if (localEglHandlerThread != null)
    {
      DanceLog.b("GLFrameImage", "TrAsyncTextureLoad lastHandler!=null");
      localEglHandlerThread.quitSafely();
    }
  }
  
  void a(HashMap paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      DanceLog.b("GLFrameImage", "notifyGLThreadUpdateTextureCache needDo=" + bool + " itemSize=" + paramHashMap.size());
      if (bool) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramHashMap);
          return;
        }
      }
      return;
    }
  }
  
  public void b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread.a();
    }
    DanceLog.b("GLFrameImage", "asyncLoadBoyTexture initSuccess=" + bool);
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread.a().post(new aiap(this));
    }
  }
  
  public void c()
  {
    DanceLog.b("GLFrameImage", "processInterrupt");
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    DanceLog.b("GLFrameImage", "processInterrupt unsafeSize=" + i);
    if (i > 0)
    {
      for (;;)
      {
        HashMap localHashMap;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break;
          }
          Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
            localGLImage.a();
          }
        }
        localHashMap.clear();
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void d()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    DanceLog.b("GLFrameImage", "updateGLFrameImageCache unsafeSize=" + i);
    if (i > 0)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        DanceLog.b("GLFrameImage", "updateGLFrameImageCache safeSize=" + i);
        if (i > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            HashMap localHashMap = (HashMap)localIterator.next();
            DanceLog.b("GLFrameImage", "updateGLFrameImageCache itemSize=" + localHashMap.size());
            GLFrameImage.a(localHashMap);
            localHashMap.clear();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread.quitSafely();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad
 * JD-Core Version:    0.7.0.1
 */