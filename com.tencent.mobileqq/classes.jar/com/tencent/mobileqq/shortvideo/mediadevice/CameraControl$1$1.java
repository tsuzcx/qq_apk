package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera.Size;

class CameraControl$1$1
  implements Runnable
{
  CameraControl$1$1(CameraControl.1 param1, byte[] paramArrayOfByte, Camera.Size paramSize) {}
  
  public void run()
  {
    CameraControl.TakePictureData localTakePictureData = new CameraControl.TakePictureData(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$1.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl, null);
    localTakePictureData.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localTakePictureData.jdField_a_of_type_JavaIoFile = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$1.jdField_a_of_type_JavaIoFile;
    localTakePictureData.jdField_a_of_type_AndroidGraphicsRect = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$1.jdField_a_of_type_AndroidGraphicsRect;
    localTakePictureData.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$1.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback;
    localTakePictureData.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$1.jdField_a_of_type_Int;
    localTakePictureData.b = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$1.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl.jdField_a_of_type_Int;
    localTakePictureData.c = 100;
    localTakePictureData.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$1.jdField_a_of_type_Boolean;
    localTakePictureData.d = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$1.b;
    localTakePictureData.jdField_a_of_type_AndroidHardwareCamera$Size = this.jdField_a_of_type_AndroidHardwareCamera$Size;
    new CameraControl.TakePictureTask(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$1.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl, localTakePictureData).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.1.1
 * JD-Core Version:    0.7.0.1
 */