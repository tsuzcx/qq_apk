package com.tencent.youtu.ytposedetect;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager;

public class YTPoseDetectInterface
{
  private static final String TAG = "YoutuFaceDetect";
  public static final String VERSION = "3.2.3";
  private static YTPoseDetectInterface.PoseDetectResult mCheckResult;
  private static boolean mInitModel = false;
  private static boolean mIsStarted = false;
  public static int mModelRetainCount = 0;
  private static PoseDetectProcessManager mPoseDetectProcessManager;
  
  public static void getBestImage(YTPoseDetectInterface.PoseDetectGetBestImage paramPoseDetectGetBestImage, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    byte[] arrayOfByte;
    for (int i = 1;; i = YTCameraSetting.getRotateTag(mPoseDetectProcessManager.mCameraRotate))
    {
      arrayOfByte = YTPoseDetectJNIInterface.getBestImage(i);
      if ((i != 5) && (i != 6) && (i != 7) && (i != 8)) {
        break;
      }
      paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewHeight, mPoseDetectProcessManager.mDesiredPreviewWidth);
      return;
    }
    paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
  }
  
  public static int getFrameNum()
  {
    return YTPoseDetectJNIInterface.getFrameNum();
  }
  
  public static int initModel(String paramString)
  {
    int i;
    try
    {
      YTLogger.i("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] ---");
      if (mInitModel)
      {
        YTLogger.i("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] has already inited.");
        return 0;
      }
      i = YTPoseDetectJNIInterface.initModel(paramString);
      if (i == 0)
      {
        mPoseDetectProcessManager = new PoseDetectProcessManager();
        mPoseDetectProcessManager.initAll();
        mInitModel = true;
        return 0;
      }
    }
    catch (Exception paramString)
    {
      YTLogger.w("YoutuFaceDetect", "initModel failed. message: " + paramString.getMessage());
      YTException.report(paramString);
      return 10;
    }
    return i;
  }
  
  public static boolean isDetecting()
  {
    return (mPoseDetectProcessManager != null) && (mPoseDetectProcessManager.mIsDetecting);
  }
  
  private static void noticeFailed(int paramInt, String paramString1, String paramString2)
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.noticeFailed] resultCode: " + paramInt + " \r\nmessage: " + paramString1 + " \r\ntips: " + paramString2);
    mPoseDetectProcessManager.restoreCamera();
    if (mCheckResult != null)
    {
      mCheckResult.onFailed(paramInt, paramString1, paramString2);
      mCheckResult = null;
    }
    mIsStarted = false;
  }
  
  private static void noticeSuccess()
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.noticeSuccess] ---");
    if (mCheckResult != null)
    {
      mCheckResult.onSuccess();
      mCheckResult = null;
    }
    mIsStarted = true;
  }
  
  public static void poseDetect(float[] paramArrayOfFloat, int paramInt, byte[] paramArrayOfByte, Camera paramCamera, float paramFloat1, float paramFloat2, float paramFloat3, YTPoseDetectInterface.PoseDetectOnFrame paramPoseDetectOnFrame)
  {
    if (!YTCommonExInterface.isAuthSuccess()) {
      paramPoseDetectOnFrame.onFailed(1, "Auth check failed on poseDetect.", "1. Check your lisence. 2. Call YTCommonExInterface.initAuth() before.");
    }
    do
    {
      return;
      if (!mInitModel)
      {
        paramPoseDetectOnFrame.onFailed(2, "Not init model on poseDetect.", "Call YTPoseDetectInterface.initModel() before.");
        return;
      }
      if (!mIsStarted)
      {
        paramPoseDetectOnFrame.onFailed(3, "Not call start() interface before.", "Call YTPoseDetectInterface.start() before.");
        return;
      }
      paramPoseDetectOnFrame.onSuccess(mPoseDetectProcessManager.poseDetect(paramArrayOfFloat, paramInt, paramArrayOfByte, paramFloat1, paramFloat2, paramFloat3));
    } while (!YTPoseDetectJNIInterface.isRecordingDone());
    paramArrayOfFloat = YTPoseDetectJNIInterface.getFrameList();
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.poseDetect] list num: " + paramArrayOfFloat.length);
    paramPoseDetectOnFrame.onRecordingDone(paramArrayOfFloat, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
  }
  
  public static void releaseModel()
  {
    YTLogger.i("YoutuFaceDetect", "[YTFacePreviewInterface.finalize] ---");
    if (mInitModel)
    {
      mPoseDetectProcessManager.clearAll();
      YTPoseDetectJNIInterface.releaseAll();
      mInitModel = false;
    }
  }
  
  public static void setFrameNum(int paramInt)
  {
    YTPoseDetectJNIInterface.setFrameNum(paramInt);
  }
  
  public static void start(Context paramContext, Camera paramCamera, int paramInt, YTPoseDetectInterface.PoseDetectResult paramPoseDetectResult)
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.start] ---");
    mCheckResult = paramPoseDetectResult;
    if (YTCommonExInterface.isAuthSuccess())
    {
      if (mInitModel)
      {
        mPoseDetectProcessManager.start(paramContext, paramCamera, paramInt, new YTPoseDetectInterface.1());
        return;
      }
      noticeFailed(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
      return;
    }
    noticeFailed(1, "Auth check failed.", "1. Check your lisence. 2. Call YTCommonExInterface.initAuth() before.");
  }
  
  public static void stop()
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.stop] ---");
    if (mPoseDetectProcessManager != null) {
      mPoseDetectProcessManager.stop();
    }
    mIsStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.YTPoseDetectInterface
 * JD-Core Version:    0.7.0.1
 */