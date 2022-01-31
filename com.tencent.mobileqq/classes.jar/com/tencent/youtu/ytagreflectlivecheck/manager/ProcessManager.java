package com.tencent.youtu.ytagreflectlivecheck.manager;

import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.controller.FinishController;
import com.tencent.youtu.ytagreflectlivecheck.controller.InitController;
import com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessManager
{
  private static String TAG = "ProcessManager";
  private static final Lock lock = new ReentrantLock();
  private static CameraWorker mCameraWorker;
  private static DataWorker mDataWorker;
  public static int mProcessState = 0;
  private static ReflectController mReflectController;
  private static int mRetainCount = 0;
  
  private static void FinishStart(long paramLong)
  {
    YTLogger.i(TAG, "[ProcessManager.FinishStart] --- " + paramLong);
    if (YTAGReflectLiveCheckInterface.isCanceled(paramLong))
    {
      YTLogger.d(TAG, "[ProcessManager.FinishStart] canceled. stop this procession");
      return;
    }
    mProcessState = 3;
    FinishController localFinishController = new FinishController();
    if (YTAGReflectLiveCheckInterface.mUploadVideoRequesterV3 != null)
    {
      localFinishController.start(YTAGReflectLiveCheckInterface.mUploadVideoRequesterV3, new ProcessManager.3(), paramLong);
      return;
    }
    if (YTAGReflectLiveCheckInterface.mUploadVideoRequesterV2 != null)
    {
      localFinishController.start(YTAGReflectLiveCheckInterface.mUploadVideoRequesterV2, new ProcessManager.4(), paramLong);
      return;
    }
    localFinishController.start(YTAGReflectLiveCheckInterface.mUploadVideoRequester, new ProcessManager.5(), paramLong);
  }
  
  private static void ReflectStart(long paramLong)
  {
    YTLogger.i(TAG, "[ProcessManager.ReflectStart] --- " + paramLong);
    if (YTAGReflectLiveCheckInterface.isCanceled(paramLong))
    {
      YTLogger.d(TAG, "[ProcessManager.ReflectStart] canceled. stop this procession");
      return;
    }
    mProcessState = 2;
    mReflectController = new ReflectController();
    mReflectController.start(YTAGReflectLiveCheckInterface.mReflectLayout, YTAGReflectLiveCheckInterface.getReflectListener(), new ProcessManager.2(), paramLong);
  }
  
  public static CameraWorker cameraWorker()
  {
    return mCameraWorker;
  }
  
  public static void cancel()
  {
    if (mCameraWorker != null) {
      mCameraWorker.cleanup();
    }
    if (mProcessState == 2) {
      mReflectController.cancel();
    }
    mProcessState = 0;
  }
  
  public static void clearAll()
  {
    lock.lock();
    try
    {
      mRetainCount -= 1;
      if (mRetainCount == 0)
      {
        mDataWorker = null;
        mCameraWorker = null;
        mProcessState = 0;
      }
      return;
    }
    finally
    {
      lock.unlock();
    }
  }
  
  public static DataWorker dataWorker()
  {
    return mDataWorker;
  }
  
  public static void initAll()
  {
    lock.lock();
    try
    {
      mDataWorker = new DataWorker();
      mCameraWorker = new CameraWorker();
      mProcessState = 0;
      mRetainCount += 1;
      return;
    }
    finally
    {
      lock.unlock();
    }
  }
  
  public static void start(long paramLong)
  {
    mProcessState = 1;
    YTLogger.i(TAG, "[ProcessManager.InitStart] --- " + paramLong);
    new InitController().start(YTAGReflectLiveCheckInterface.mRgbConfigRequester, new ProcessManager.1(), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager
 * JD-Core Version:    0.7.0.1
 */