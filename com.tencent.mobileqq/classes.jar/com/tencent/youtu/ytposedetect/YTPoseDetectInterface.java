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
    if ((paramInt != 5) && (paramInt != 6) && (paramInt != 7) && (paramInt != 8))
    {
      localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
      localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
      return localYTPoseImage;
    }
    localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
    localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
    return localYTPoseImage;
  }
  
  public static void getBestImage(YTPoseDetectInterface.PoseDetectGetBestImage paramPoseDetectGetBestImage, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = mPoseDetectProcessManager.mCameraRotateTag;
    } else {
      i = 1;
    }
    byte[] arrayOfByte = YTPoseDetectJNIInterface.getBestImage(i);
    if ((i != 5) && (i != 6) && (i != 7) && (i != 8))
    {
      paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
      return;
    }
    paramPoseDetectGetBestImage.onGetBestImage(arrayOfByte, mPoseDetectProcessManager.mDesiredPreviewHeight, mPoseDetectProcessManager.mDesiredPreviewWidth);
  }
  
  public static YTPoseImage getEyeImage(int paramInt)
  {
    YTPoseImage localYTPoseImage = new YTPoseImage();
    localYTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getEyeImage(paramInt);
    if ((paramInt != 5) && (paramInt != 6) && (paramInt != 7) && (paramInt != 8))
    {
      localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
      localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
      return localYTPoseImage;
    }
    localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
    localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
    return localYTPoseImage;
  }
  
  public static YTPoseImage getMouthImage(int paramInt)
  {
    YTPoseImage localYTPoseImage = new YTPoseImage();
    localYTPoseImage.yuvRotateData = YTPoseDetectJNIInterface.getMouthImage(paramInt);
    if ((paramInt != 5) && (paramInt != 6) && (paramInt != 7) && (paramInt != 8))
    {
      localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewWidth;
      localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewHeight;
      return localYTPoseImage;
    }
    localYTPoseImage.width = mPoseDetectProcessManager.mDesiredPreviewHeight;
    localYTPoseImage.height = mPoseDetectProcessManager.mDesiredPreviewWidth;
    return localYTPoseImage;
  }
  
  public static String getVersion()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jar3.6.0_native");
    localStringBuilder.append(YTPoseDetectJNIInterface.getVersion());
    return localStringBuilder.toString();
  }
  
  public static int initModel()
  {
    try
    {
      YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] ---");
      if (mInitModel > 0)
      {
        YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTFacePreviewInterface.initModel] has already inited.");
        mInitModel += 1;
        return 0;
      }
      int i = YTPoseDetectJNIInterface.initModel("");
      if (i == 0)
      {
        mPoseDetectProcessManager = new PoseDetectProcessManager();
        mPoseDetectProcessManager.initAll();
        mInitModel += 1;
        return 0;
      }
      return i;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initModel failed. message: ");
      localStringBuilder.append(localException.getMessage());
      YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", localStringBuilder.toString());
      YTException.report(localException);
    }
    return 10;
  }
  
  public static boolean isDetecting()
  {
    PoseDetectProcessManager localPoseDetectProcessManager = mPoseDetectProcessManager;
    return (localPoseDetectProcessManager != null) && (localPoseDetectProcessManager.mIsDetecting);
  }
  
  private static void noticeFailed(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[YTPoseDetectInterface.noticeFailed] resultCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" \r\nmessage: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" \r\ntips: ");
    localStringBuilder.append(paramString2);
    YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", localStringBuilder.toString());
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
    if (mInitModel <= 0)
    {
      paramPoseDetectOnFrame.onFailed(2, "Not init model on poseDetect.", "Call YTPoseDetectInterface.initModel() before.");
      return;
    }
    if (!mIsStarted)
    {
      paramPoseDetectOnFrame.onFailed(3, "Not call start() interface before.", "Call YTPoseDetectInterface.start() before.");
      return;
    }
    paramPoseDetectOnFrame.onSuccess(mPoseDetectProcessManager.poseDetect(paramArrayOfFloat1, paramArrayOfFloat2, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramInt4));
    if (YTPoseDetectJNIInterface.canReflect()) {
      paramPoseDetectOnFrame.onCanReflect();
    }
    if (YTPoseDetectJNIInterface.isRecordingDone())
    {
      paramArrayOfFloat1 = YTPoseDetectJNIInterface.getFrameList();
      int j = mPoseDetectProcessManager.mCameraRotateTag;
      paramArrayOfFloat2 = new StringBuilder();
      paramArrayOfFloat2.append("[YTPoseDetectInterface.poseDetect] list num: ");
      paramArrayOfFloat2.append(paramArrayOfFloat1.length);
      YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", paramArrayOfFloat2.toString());
      paramInt3 = mPoseDetectProcessManager.mDesiredPreviewWidth;
      int i = mPoseDetectProcessManager.mDesiredPreviewHeight;
      paramInt2 = paramInt3;
      paramInt1 = i;
      if (paramInt4 == 1) {
        if ((j != 5) && (j != 6) && (j != 7))
        {
          paramInt2 = paramInt3;
          paramInt1 = i;
          if (j != 8) {}
        }
        else
        {
          paramInt2 = mPoseDetectProcessManager.mDesiredPreviewHeight;
          paramInt1 = mPoseDetectProcessManager.mDesiredPreviewWidth;
        }
      }
      paramPoseDetectOnFrame.onRecordingDone(paramArrayOfFloat1, paramInt2, paramInt1);
    }
  }
  
  public static void releaseModel()
  {
    YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTFacePreviewInterface.finalize] ---");
    mInitModel -= 1;
    if (mInitModel <= 0)
    {
      PoseDetectProcessManager localPoseDetectProcessManager = mPoseDetectProcessManager;
      if (localPoseDetectProcessManager != null) {
        localPoseDetectProcessManager.clearAll();
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
    } else {
      noticeFailed(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
    }
    return 0;
  }
  
  public static void stop()
  {
    YTPoseDetectJNIInterface.nativeLog("YoutuFaceDetect", "[YTPoseDetectInterface.stop] ---");
    PoseDetectProcessManager localPoseDetectProcessManager = mPoseDetectProcessManager;
    if (localPoseDetectProcessManager != null) {
      localPoseDetectProcessManager.stop();
    }
    mIsStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.YTPoseDetectInterface
 * JD-Core Version:    0.7.0.1
 */