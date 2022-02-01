package com.tencent.qqcamerakit.capture.camera;

import com.tencent.qqcamerakit.capture.cameraextend.TakePictureTask;

class CameraControl$1$1
  implements Runnable
{
  CameraControl$1$1(CameraControl.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraControl$1.a.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraControl$1.a.c = 100;
    new TakePictureTask(this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraControl$1.a).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera.CameraControl.1.1
 * JD-Core Version:    0.7.0.1
 */