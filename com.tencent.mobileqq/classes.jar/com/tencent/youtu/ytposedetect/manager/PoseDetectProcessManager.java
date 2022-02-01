package com.tencent.youtu.ytposedetect.manager;

import android.content.Context;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

public class PoseDetectProcessManager
{
  private static final String TAG = "FaceDetectProcess";
  public int mCameraRotateTag;
  public int mDesiredPreviewHeight = 720;
  public int mDesiredPreviewWidth = 1280;
  public boolean mIsDetecting = false;
  
  public void clearAll() {}
  
  protected void finalize()
  {
    super.finalize();
  }
  
  public void initAll() {}
  
  public int poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt4)
  {
    this.mDesiredPreviewWidth = paramInt2;
    this.mDesiredPreviewHeight = paramInt3;
    return YTPoseDetectJNIInterface.poseDetect(paramArrayOfFloat1, paramArrayOfFloat2, paramInt1, paramArrayOfByte, paramInt2, paramInt3, this.mCameraRotateTag, paramFloat1, paramFloat2, paramFloat3, paramInt4);
  }
  
  public void start(Context paramContext, int paramInt, YTPoseDetectInterface.PoseDetectResult paramPoseDetectResult)
  {
    if (this.mIsDetecting) {
      YTPoseDetectJNIInterface.nativeLog("FaceDetectProcess", "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
    }
    this.mCameraRotateTag = paramInt;
    this.mIsDetecting = true;
    paramPoseDetectResult.onSuccess();
  }
  
  public void stop()
  {
    if (this.mIsDetecting)
    {
      this.mIsDetecting = false;
      YTPoseDetectJNIInterface.resetDetect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager
 * JD-Core Version:    0.7.0.1
 */