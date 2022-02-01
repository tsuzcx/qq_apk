package org.light;

import android.util.Log;
import org.light.listener.AIDataListener;
import org.light.listener.LightAssetListener;
import org.light.listener.TipsListener;

public class CameraConfig
  extends Config
{
  private static final String TAG = "CameraConfig";
  private float eps = 3.0F;
  private float lastXAxis;
  CameraConfig.DeviceCameraOrientation recognizedOrientation;
  
  public static native CameraConfig make();
  
  public native void clearAIDataListener();
  
  public native void clearLightAssetListener();
  
  public native void clearTipsListener();
  
  public native void needSyncInitProcessor(boolean paramBoolean, String paramString);
  
  public native void onCameraChanged(int paramInt);
  
  public void onSensorOrientationChanged(int paramInt1, int paramInt2)
  {
    CameraConfig.DeviceCameraOrientation localDeviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_0;
    if (Math.abs(paramInt2) > Math.abs(paramInt1))
    {
      if (paramInt2 > 1) {
        localDeviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_0;
      } else if (paramInt2 < -1) {
        localDeviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_180;
      }
    }
    else if (paramInt1 > 1) {
      localDeviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_90;
    } else if (paramInt1 < -1) {
      localDeviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_270;
    }
    if (this.recognizedOrientation != localDeviceCameraOrientation)
    {
      float f = paramInt1;
      if ((Math.abs(f - this.lastXAxis) > this.eps) || (Math.abs(paramInt2 - this.lastXAxis) > this.eps))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("orientation is changed from");
        localStringBuilder.append(this.recognizedOrientation);
        localStringBuilder.append(" to ");
        localStringBuilder.append(localDeviceCameraOrientation);
        localStringBuilder.append(", and current XAxis:");
        localStringBuilder.append(paramInt1);
        Log.d("CameraConfig", localStringBuilder.toString());
        this.lastXAxis = f;
        this.recognizedOrientation = localDeviceCameraOrientation;
        onSensorOrientationChanged(localDeviceCameraOrientation);
      }
    }
  }
  
  public native void onSensorOrientationChanged(CameraConfig.DeviceCameraOrientation paramDeviceCameraOrientation);
  
  public native void setAIDataListener(AIDataListener paramAIDataListener);
  
  public native void setAutoTestMode(boolean paramBoolean);
  
  public native void setBeautyReshapeStrength(float paramFloat);
  
  public native void setBeautySmoothStrength(float paramFloat);
  
  public void setCameraTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setCameraTexture(paramInt1, paramInt2, paramInt3, CameraConfig.DeviceCameraOrientation.ROTATION_0);
  }
  
  public void setCameraTexture(int paramInt1, int paramInt2, int paramInt3, CameraConfig.DeviceCameraOrientation paramDeviceCameraOrientation)
  {
    setCameraTexture(paramInt1, paramInt2, paramInt3, paramDeviceCameraOrientation, CameraConfig.ImageOrigin.BottomLeft);
  }
  
  public native void setCameraTexture(int paramInt1, int paramInt2, int paramInt3, CameraConfig.DeviceCameraOrientation paramDeviceCameraOrientation, CameraConfig.ImageOrigin paramImageOrigin);
  
  public native void setLightAssetListener(LightAssetListener paramLightAssetListener);
  
  public native void setLightSDKEnvironment(String paramString);
  
  public native void setLutPath(String paramString);
  
  public native void setLutStrength(float paramFloat);
  
  public native void setTipsListener(TipsListener paramTipsListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.CameraConfig
 * JD-Core Version:    0.7.0.1
 */