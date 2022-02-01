package com.tencent.qqcamerakit.capture.camera2;

import android.hardware.camera2.CameraCharacteristics;
import android.text.TextUtils;

public class Camera2Control$Camera2Info
{
  public String a;
  public CameraCharacteristics b;
  
  public Camera2Control$Camera2Info(String paramString, CameraCharacteristics paramCameraCharacteristics)
  {
    this.a = paramString;
    this.b = paramCameraCharacteristics;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (this.b != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control.Camera2Info
 * JD-Core Version:    0.7.0.1
 */