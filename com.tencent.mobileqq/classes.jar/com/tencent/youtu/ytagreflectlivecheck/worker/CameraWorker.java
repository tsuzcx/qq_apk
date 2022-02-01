package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;

public class CameraWorker
{
  private static final String TAG = "YoutuLightLiveCheck";
  private static int mDesiredPreviewHeight = 720;
  private static int mDesiredPreviewWidth = 1280;
  private int GET_CAMERA_PARAMETERS_FAILED = 0;
  public Camera mCamera;
  private Camera.Parameters mCameraParameters;
  private boolean mIsCameraOpened = false;
  private Camera.PreviewCallback mPreviewCallback;
  
  public void cleanup()
  {
    if (this.mCamera != null) {}
    try
    {
      this.mCamera.setParameters(this.mCameraParameters);
      this.mCamera = null;
      this.mIsCameraOpened = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        YTLogger.d("YoutuLightLiveCheck", "[CameraWorker.cleanup] camera is already released.");
      }
    }
  }
  
  public int getDesiredPreviewHeight()
  {
    return mDesiredPreviewHeight;
  }
  
  public int getDesiredPreviewWidth()
  {
    return mDesiredPreviewWidth;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.mPreviewCallback != null) && (this.mIsCameraOpened)) {
      try
      {
        this.mPreviewCallback.onPreviewFrame(paramArrayOfByte, paramCamera);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        YTException.report(paramArrayOfByte);
        return;
      }
    }
    YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.onPreviewFrame] ---callback is nil, or mIsCameraOpened: " + this.mIsCameraOpened);
  }
  
  public void setCamera(Camera paramCamera)
  {
    this.mCamera = paramCamera;
    this.mCameraParameters = paramCamera.getParameters();
    mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
    mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
    this.mIsCameraOpened = true;
  }
  
  public void setCameraPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    this.mPreviewCallback = paramPreviewCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker
 * JD-Core Version:    0.7.0.1
 */