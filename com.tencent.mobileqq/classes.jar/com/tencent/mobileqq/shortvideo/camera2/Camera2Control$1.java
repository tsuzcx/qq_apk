package com.tencent.mobileqq.shortvideo.camera2;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.support.annotation.NonNull;
import java.util.concurrent.Semaphore;

class Camera2Control$1
  extends CameraDevice.StateCallback
{
  Camera2Control$1(Camera2Control paramCamera2Control, long paramLong) {}
  
  public void onDisconnected(@NonNull CameraDevice paramCameraDevice)
  {
    Camera2Utils.a(2, "[Camera2]openCamera2 onDisconnected!");
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    Camera2Control.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    paramCameraDevice.close();
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, null);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).release();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.a.a(-105);
    }
  }
  
  public void onError(@NonNull CameraDevice paramCameraDevice, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]openCamera2 onError, error:");
    localStringBuilder.append(paramInt);
    Camera2Utils.a(2, localStringBuilder.toString());
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    Camera2Control.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    paramCameraDevice.close();
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, null);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).release();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control.a.a(-102);
    }
  }
  
  public void onOpened(@NonNull CameraDevice paramCameraDevice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]openCamera2 onOpen, cost:");
    localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    Camera2Utils.a(1, localStringBuilder.toString());
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, paramCameraDevice);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, true);
    Camera2Control.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control, false);
    Camera2Control.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control).release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.1
 * JD-Core Version:    0.7.0.1
 */