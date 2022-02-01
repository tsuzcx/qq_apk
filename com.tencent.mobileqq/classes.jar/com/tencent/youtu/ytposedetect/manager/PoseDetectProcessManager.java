package com.tencent.youtu.ytposedetect.manager;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

public class PoseDetectProcessManager
{
  private static final String TAG = "FaceDetectProcess";
  private Camera mCamera = null;
  private Camera.Parameters mCameraParameters = null;
  public int mCameraRotate;
  public int mDesiredPreviewHeight = 720;
  public int mDesiredPreviewWidth = 1280;
  public boolean mIsDetecting = false;
  
  private void setCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    this.mCamera = paramCamera;
    this.mCameraParameters = paramCamera.getParameters();
    this.mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
    this.mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
    YTPoseDetectJNIInterface.nativeLog("FaceDetectProcess", "[PoseDetectProcessManager.setCamera] mDesiredPreviewWidth: " + this.mDesiredPreviewWidth + " mDesiredPreviewHeight: " + this.mDesiredPreviewHeight);
  }
  
  public void clearAll()
  {
    restoreCamera();
  }
  
  protected void finalize()
  {
    super.finalize();
  }
  
  public void initAll() {}
  
  public int poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2)
  {
    int i = YTCameraSetting.getRotateTag(this.mCameraRotate, 1);
    return YTPoseDetectJNIInterface.poseDetect(paramArrayOfFloat1, paramArrayOfFloat2, paramInt1, paramArrayOfByte, this.mDesiredPreviewWidth, this.mDesiredPreviewHeight, i, paramFloat1, paramFloat2, paramFloat3, paramInt2);
  }
  
  public void restoreCamera()
  {
    if (this.mCamera != null) {}
    try
    {
      this.mCamera.setParameters(this.mCameraParameters);
      return;
    }
    catch (Exception localException)
    {
      YTPoseDetectJNIInterface.nativeLog("FaceDetectProcess", "restoreCamera failed. ");
      YTException.report(localException);
      return;
    }
    finally
    {
      this.mCamera = null;
      this.mCameraParameters = null;
    }
  }
  
  public void start(Context paramContext, Camera paramCamera, int paramInt, YTPoseDetectInterface.PoseDetectResult paramPoseDetectResult)
  {
    if (this.mIsDetecting) {
      YTPoseDetectJNIInterface.nativeLog("FaceDetectProcess", "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
    }
    setCamera(paramContext, paramCamera, paramInt);
    this.mCameraRotate = YTCameraSetting.getVideoRotate(paramContext, paramInt);
    this.mIsDetecting = true;
    paramPoseDetectResult.onSuccess();
  }
  
  public void stop()
  {
    if (this.mIsDetecting)
    {
      this.mIsDetecting = false;
      restoreCamera();
      YTPoseDetectJNIInterface.resetDetect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager
 * JD-Core Version:    0.7.0.1
 */