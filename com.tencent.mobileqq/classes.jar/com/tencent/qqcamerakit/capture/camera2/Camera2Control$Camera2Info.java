package com.tencent.qqcamerakit.capture.camera2;

import android.hardware.camera2.CameraCharacteristics;
import android.text.TextUtils;

public class Camera2Control$Camera2Info
{
  public CameraCharacteristics a;
  public String a;
  
  public Camera2Control$Camera2Info(String paramString, CameraCharacteristics paramCameraCharacteristics)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics = paramCameraCharacteristics;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control.Camera2Info
 * JD-Core Version:    0.7.0.1
 */