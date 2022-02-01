package com.tencent.youtu.ytposedetect;

import android.content.Context;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager;

public class YTPoseDetectInterface
{
  private static final String TAG = "YoutuFaceDetect";
  public static final String VERSION = "3.6.0";
  private static YTPoseDetectInterface.PoseDetectResult mCheckResult;
  private static int mInitModel = 0;
  private static boolean mIsStarted = false;
  public static int mModelRetainCount = 0;
  private static PoseDetectProcessManager mPoseDetectProcessManager;
  public static int mRotateTag = 1;
  
  public static YTActRefData getActReflectData()
  {
    return YTPoseDetectJNIInterface.getActionReflectData(mPoseDetectProcessManager.mCameraRotateTag);
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
    if (paramBoolean) {
      i = mPoseDetectProcessManager.mCameraRotateTag;
    }
    byte[] arrayOfByte = YTPoseDetectJNIInterface.getBestImage(i);
    if ((i == 5) || (i == 6) || (i == 7) || (i == 8))
    {
      paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewHeight, mPoseDetectProcessManager.mDesiredPreviewWidth);
      return;
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
    return "jar3.6.0_native" + YTPoseDetectJNIInterface.getVersion();
  }
  
  public static int initModel()
  {
    int i;
    try
    {
      YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] ---");
      if (mInitModel > 0)
      {
        YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] has already inited.");
        mInitModel += 1;
        return 0;
      }
      i = YTPoseDetectJNIInterface.initModel("");
      if (i == 0)
      {
        mPoseDetectProcessManager = new PoseDetectProcessManager();
        mPoseDetectProcessManager.initAll();
        mInitModel += 1;
        return 0;
      }
    }
    catch (Exception localException)
    {
      YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "initModel failed. message: " + localException.getMessage());
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
    YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTPoseDetectInterface.noticeFailed] resultCode: " + paramInt + " \r\nmessage: " + paramString1 + " \r\ntips: " + paramString2);
    mCheckResult.onFailed(paramInt, paramString1, paramString2);
    mCheckResult = null;
    mIsStarted = false;
  }
  
  private static void noticeSuccess()
  {
    YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTPoseDetectInterface.noticeSuccess] ---");
    mCheckResult.onSuccess();
    mCheckResult = null;
    mIsStarted = true;
  }
  
  public static void poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, YTPoseDetectInterface.PoseDetectOnFrame paramPoseDetectOnFrame, int paramInt4)
  {
    if (mInitModel <= 0) {
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
      paramPoseDetectOnFrame.onSuccess(mPoseDetectProcessManager.poseDetect(paramArrayOfFloat1, paramArrayOfFloat2, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramInt4));
      if (YTPoseDetectJNIInterface.canReflect()) {
        paramPoseDetectOnFrame.onCanReflect();
      }
    } while (!YTPoseDetectJNIInterface.isRecordingDone());
    paramArrayOfFloat1 = YTPoseDetectJNIInterface.getFrameList();
    int j = mPoseDetectProcessManager.mCameraRotateTag;
    YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTPoseDetectInterface.poseDetect] list num: " + paramArrayOfFloat1.length);
    paramInt3 = mPoseDetectProcessManager.mDesiredPreviewWidth;
    int i = mPoseDetectProcessManager.mDesiredPreviewHeight;
    paramInt2 = i;
    paramInt1 = paramInt3;
    if (paramInt4 == 1) {
      if ((j != 5) && (j != 6) && (j != 7))
      {
        paramInt2 = i;
        paramInt1 = paramInt3;
        if (j != 8) {}
      }
      else
      {
        paramInt1 = mPoseDetectProcessManager.mDesiredPreviewHeight;
        paramInt2 = mPoseDetectProcessManager.mDesiredPreviewWidth;
      }
    }
    paramPoseDetectOnFrame.onRecordingDone(paramArrayOfFloat1, paramInt1, paramInt2);
  }
  
  public static void releaseModel()
  {
    YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTFacePreviewInterface.finalize] ---");
    mInitModel -= 1;
    if (mInitModel <= 0)
    {
      if (mPoseDetectProcessManager != null) {
        mPoseDetectProcessManager.clearAll();
      }
      YTPoseDetectJNIInterface.releaseAll();
      mInitModel = 0;
    }
  }
  
  public static void reset() {}
  
  public static void setSafetyLevel(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {
      YTPoseDetectJNIInterface.setSafetyLevel(paramInt);
    }
  }
  
  public static int start(Context paramContext, int paramInt, YTPoseDetectInterface.PoseDetectResult paramPoseDetectResult)
  {
    YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTPoseDetectInterface.start] ---");
    if (paramPoseDetectResult == null) {
      return -1;
    }
    mCheckResult = paramPoseDetectResult;
    if (mInitModel > 0) {
      mPoseDetectProcessManager.start(paramContext, paramInt, new YTPoseDetectInterface.1());
    }
    for (;;)
    {
      return 0;
      noticeFailed(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
    }
  }
  
  public static void stop()
  {
    YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTPoseDetectInterface.stop] ---");
    if (mPoseDetectProcessManager != null) {
      mPoseDetectProcessManager.stop();
    }
    mIsStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.YTPoseDetectInterface
 * JD-Core Version:    0.7.0.1
 */