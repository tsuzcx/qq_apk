package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile;
import com.tencent.mobileqq.shortvideo.mediadevice.FilterPreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.Lock;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class GlPostProcessThread
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public GlPostProcessThread.FilterInitParam a;
  private SVOpenglFlipFilter jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public GlPostProcessThread()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread$FilterInitParam = new GlPostProcessThread.FilterInitParam();
  }
  
  public static CameraFilterGLView.SharedMemWriteFile a(SVFilterEncodeDoubleCache.SharedMemoryCache paramSharedMemoryCache)
  {
    if (paramSharedMemoryCache.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile == null) {
      paramSharedMemoryCache.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile = new CameraFilterGLView.SharedMemWriteFile();
    }
    return paramSharedMemoryCache.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SharedMemWriteFile;
  }
  
  @TargetApi(17)
  private SVFilterEncodeDoubleCache.SharedMemoryCache a(GlPostProcessThread.FilterDrawFrameParam paramFilterDrawFrameParam, int paramInt)
  {
    SVFilterEncodeDoubleCache.SharedMemoryCache localSharedMemoryCache = paramFilterDrawFrameParam.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a();
    if (localSharedMemoryCache == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]memoryCache=null");
      }
      return null;
    }
    if (localSharedMemoryCache.a(paramFilterDrawFrameParam.jdField_a_of_type_Int, paramFilterDrawFrameParam.jdField_b_of_type_Int, paramFilterDrawFrameParam.e))
    {
      long l1 = SystemClock.elapsedRealtimeNanos();
      if (PtvFilterUtils.a(paramInt, paramFilterDrawFrameParam.jdField_a_of_type_Int, paramFilterDrawFrameParam.jdField_b_of_type_Int, paramFilterDrawFrameParam.e, localSharedMemoryCache.jdField_a_of_type_JavaNioByteBuffer, paramFilterDrawFrameParam.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct) != 0)
      {
        localSharedMemoryCache.a();
        return null;
      }
      long l2 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory= old time " + paramFilterDrawFrameParam.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime + ", new time = " + l2 + ", diff=" + (l2 - paramFilterDrawFrameParam.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime));
      }
      paramFilterDrawFrameParam.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime = l2;
      l1 = (SystemClock.elapsedRealtimeNanos() - l1) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory=" + l1 + "us]");
      }
      return localSharedMemoryCache;
    }
    localSharedMemoryCache.a();
    return null;
  }
  
  private void a(GlPostProcessThread.FilterDrawFrameParam paramFilterDrawFrameParam, SVFilterEncodeDoubleCache.SharedMemoryCache paramSharedMemoryCache, int paramInt1, boolean paramBoolean, AVIOStruct paramAVIOStruct, int paramInt2, FilterPreviewContext paramFilterPreviewContext)
  {
    CameraFilterGLView.SharedMemWriteFile localSharedMemWriteFile = a(paramSharedMemoryCache);
    localSharedMemWriteFile.jdField_a_of_type_Int = paramFilterDrawFrameParam.jdField_a_of_type_Int;
    localSharedMemWriteFile.jdField_b_of_type_Int = paramFilterDrawFrameParam.jdField_b_of_type_Int;
    localSharedMemWriteFile.c = paramInt1;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = paramAVIOStruct;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache = paramSharedMemoryCache;
    localSharedMemWriteFile.jdField_a_of_type_Boolean = paramBoolean;
    localSharedMemWriteFile.jdField_b_of_type_Boolean = paramFilterDrawFrameParam.jdField_a_of_type_Boolean;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache = paramFilterDrawFrameParam.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener = null;
    localSharedMemWriteFile.d = paramInt2;
    localSharedMemWriteFile.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = paramFilterDrawFrameParam.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext = paramFilterPreviewContext;
    paramFilterDrawFrameParam.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a(localSharedMemWriteFile);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("glAsyncPostThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    }
  }
  
  public void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      PtvFilterUtils.a(this.jdField_a_of_type_AndroidOsHandlerThread);
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    }
    do
    {
      SVFilterEncodeDoubleCache.SharedMemoryCache localSharedMemoryCache;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                synchronized (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread$FilterInitParam.jdField_a_of_type_JavaLangObject)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread$FilterInitParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread$FilterInitParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread$FilterInitParam.jdField_a_of_type_AndroidOpenglEGLContext)))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("face", 2, "checkIsCanReusedPbuffer = false [release]");
                    }
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null)
                  {
                    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = new SVOpenglFlipFilter(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread$FilterInitParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread$FilterInitParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread$FilterInitParam.jdField_a_of_type_AndroidOpenglEGLContext);
                  }
                }
                try
                {
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a();
                  this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                  return true;
                  localObject = finally;
                  throw localObject;
                }
                catch (OffScreenInputSurface.EGLMakeCurrentException localEGLMakeCurrentException)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[initPbbufferSurfaceMakeCurrent]" + localEGLMakeCurrentException);
                    }
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                  }
                }
                catch (OffScreenInputSurface.EGLCreateContextException localEGLCreateContextException)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[initPbbufferSurfaceMakeCurrent]" + localEGLCreateContextException);
                    }
                  }
                }
                catch (OffScreenInputSurface.EGLCreatePbufferSurfaceException localEGLCreatePbufferSurfaceException)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[initPbbufferSurfaceMakeCurrent]" + localEGLCreatePbufferSurfaceException);
                    }
                  }
                }
                catch (SVOpenglFlipFilter.EGLCreateProgramException localEGLCreateProgramException)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[EGLCreateProgramException]" + localEGLCreateProgramException);
                    }
                  }
                }
                ??? = (GlPostProcessThread.FilterDrawFrameParam)???.obj;
                if (Lock.jdField_a_of_type_Boolean) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[FILTER_FLIP_GL_DRAW] ignore because stop capture, frame index = " + ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.pFrameIndex);
              return true;
            } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
            if (???.d != 180) {
              break;
            }
            localSharedMemoryCache = a(???, ???.c);
          } while (localSharedMemoryCache == null);
          a(???, localSharedMemoryCache, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, 0, ???.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext);
          return true;
          if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!PtvFilterConstData.jdField_a_of_type_Boolean)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a(???.c, ???.jdField_a_of_type_Int, ???.jdField_b_of_type_Int);
          localSharedMemoryCache = a(???, 0);
        } while (localSharedMemoryCache == null);
        a(???, localSharedMemoryCache, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.d, ???.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext);
        return true;
        localSharedMemoryCache = a(???, ???.c);
      } while (localSharedMemoryCache == null);
      a(???, localSharedMemoryCache, 180, true, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.d, ???.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext);
      return true;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.GlPostProcessThread
 * JD-Core Version:    0.7.0.1
 */