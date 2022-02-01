package com.tencent.mobileqq.shortvideo.camera2;

import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;

class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final Camera2Control.Camera2PictureData jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, Camera2Control.Camera2PictureData paramCamera2PictureData)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData = paramCamera2PictureData;
  }
  
  public void run()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    String str = null;
    if (arrayOfByte == null)
    {
      Camera2Utils.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback.a(null);
      }
      return;
    }
    int i = Camera2Utils.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_Int);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_Boolean;
    try
    {
      ImageUtil.a(CameraUtils.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_AndroidGraphicsRect, bool, i), this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_JavaIoFile);
      i = 1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]ImageSaveServer OutOfMemoryError:");
      localStringBuilder.append(localOutOfMemoryError);
      Camera2Utils.a(2, localStringBuilder.toString());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]ImageSaveServer Exception:");
      localStringBuilder.append(localException);
      Camera2Utils.a(2, localStringBuilder.toString());
    }
    i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback != null)
    {
      CameraCover.PictureCallback localPictureCallback = this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback;
      if (i != 0) {
        str = this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      }
      localPictureCallback.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */