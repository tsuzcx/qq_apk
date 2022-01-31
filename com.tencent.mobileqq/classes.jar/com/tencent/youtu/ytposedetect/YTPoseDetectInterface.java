package com.tencent.youtu.ytposedetect;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager;

public class YTPoseDetectInterface
{
  private static final String TAG = "YoutuFaceDetect";
  public static final String VERSION = "3.4.2.2";
  private static YTPoseDetectInterface.PoseDetectResult mCheckResult;
  private static boolean mInitModel = false;
  private static boolean mIsStarted = false;
  public static int mModelRetainCount = 0;
  private static PoseDetectProcessManager mPoseDetectProcessManager;
  
  public static YTActRefData getActReflectData()
  {
    return YTPoseDetectJNIInterface.getActionReflectData(YTCameraSetting.getRotateTag(mPoseDetectProcessManager.mCameraRotate, 1));
  }
  
  public static YTPoseImage getBestImage(int paramInt)
  {
    YTPoseImage localYTPoseImage = new YTPoseImage();
    localYTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getBestImage(paramInt);
    if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8))
    {
      localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
      localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
      return localYTPoseImage;
    }
    localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
    localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
    return localYTPoseImage;
  }
  
  public static void getBestImage(YTPoseDetectInterface.PoseDetectGetBestImage paramPoseDetectGetBestImage, boolean paramBoolean)
  {
    int i = 1;
    if (!paramBoolean) {}
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = YTPoseDetectJNIInterface.getBestImage(i);
      if ((i != 5) && (i != 6) && (i != 7) && (i != 8)) {
        break;
      }
      paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewHeight, mPoseDetectProcessManager.mDesiredPreviewWidth);
      return;
      i = YTCameraSetting.getRotateTag(mPoseDetectProcessManager.mCameraRotate, 1);
    }
    paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
  }
  
  public static YTPoseImage getEyeImage(int paramInt)
  {
    YTPoseImage localYTPoseImage = new YTPoseImage();
    localYTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getEyeImage(paramInt);
    if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8))
    {
      localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
      localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
      return localYTPoseImage;
    }
    localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
    localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
    return localYTPoseImage;
  }
  
  public static int getFrameNum()
  {
    return YTPoseDetectJNIInterface.getFrameNum();
  }
  
  public static YTPoseImage getMouthImage(int paramInt)
  {
    YTPoseImage localYTPoseImage = new YTPoseImage();
    localYTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getMouthImage(paramInt);
    if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8))
    {
      localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
      localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
      return localYTPoseImage;
    }
    localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
    localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
    return localYTPoseImage;
  }
  
  public static String getVersion()
  {
    return "jar3.4.2.2_native" + YTPoseDetectJNIInterface.getVersion();
  }
  
  public static int initModel()
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
      i = YTPoseDetectJNIInterface.initModel("");
      if (i == 0)
      {
        mPoseDetectProcessManager = new PoseDetectProcessManager();
        mPoseDetectProcessManager.initAll();
        mInitModel = true;
        return 0;
      }
    }
    catch (Exception localException)
    {
      YTLogger.w("YoutuFaceDetect", "initModel failed. message: " + localException.getMessage());
      YTException.report(localException);
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
    mCheckResult.onFailed(paramInt, paramString1, paramString2);
    mCheckResult = null;
    mIsStarted = false;
  }
  
  private static void noticeSuccess()
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.noticeSuccess] ---");
    mCheckResult.onSuccess();
    mCheckResult = null;
    mIsStarted = true;
  }
  
  public static void poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt, byte[] paramArrayOfByte, Camera paramCamera, float paramFloat1, float paramFloat2, float paramFloat3, YTPoseDetectInterface.PoseDetectOnFrame paramPoseDetectOnFrame)
  {
    if (!mInitModel) {
      paramPoseDetectOnFrame.onFailed(2, "Not init model on poseDetect.", "Call YTPoseDetectInterface.initModel() before.");
    }
    do
    {
      return;
      if (!mIsStarted)
      {
        paramPoseDetectOnFrame.onFailed(3, "Not call start() interface before.", "Call YTPoseDetectInterface.start() before.");
        return;
      }
      paramPoseDetectOnFrame.onSuccess(mPoseDetectProcessManager.poseDetect(paramArrayOfFloat1, paramArrayOfFloat2, paramInt, paramArrayOfByte, paramFloat1, paramFloat2, paramFloat3));
      if (YTPoseDetectJNIInterface.canReflect()) {
        paramPoseDetectOnFrame.onCanReflect();
      }
    } while (!YTPoseDetectJNIInterface.isRecordingDone());
    paramArrayOfFloat1 = YTPoseDetectJNIInterface.getFrameList();
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.poseDetect] list num: " + paramArrayOfFloat1.length);
    paramPoseDetectOnFrame.onRecordingDone(paramArrayOfFloat1, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
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
  
  public static void reset() {}
  
  public static void setFrameNum(int paramInt)
  {
    YTPoseDetectJNIInterface.setFrameNum(paramInt);
  }
  
  public static void setSafetyLevel(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {
      YTPoseDetectJNIInterface.setSafetyLevel(paramInt);
    }
  }
  
  public static int start(Context paramContext, Camera paramCamera, int paramInt, YTPoseDetectInterface.PoseDetectResult paramPoseDetectResult)
  {
    YTLogger.i("YoutuFaceDetect", "[YTPoseDetectInterface.start] ---");
    if (paramPoseDetectResult == null) {
      return -1;
    }
    mCheckResult = paramPoseDetectResult;
    if (mInitModel) {
      mPoseDetectProcessManager.start(paramContext, paramCamera, paramInt, new YTPoseDetectInterface.1());
    }
    for (;;)
    {
      return 0;
      noticeFailed(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.YTPoseDetectInterface
 * JD-Core Version:    0.7.0.1
 */