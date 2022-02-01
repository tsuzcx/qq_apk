package com.tencent.mobileqq.shortvideo.camera2;

import akwr;
import apju;
import bbsn;
import bbsr;
import bfvo;
import java.io.File;

public class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final bbsn jdField_a_of_type_Bbsn;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  public Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, bbsn parambbsn)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Bbsn = parambbsn;
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      bbsr.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.jdField_a_of_type_Bbsn.jdField_a_of_type_Akwr != null) {
        this.jdField_a_of_type_Bbsn.jdField_a_of_type_Akwr.a(null);
      }
    }
    do
    {
      return;
      int j = bbsr.a(this.jdField_a_of_type_Bbsn.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_Bbsn.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_Bbsn.jdField_a_of_type_Boolean;
      try
      {
        bfvo.a(apju.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Bbsn.jdField_a_of_type_AndroidGraphicsRect, bool, j), this.jdField_a_of_type_Bbsn.jdField_a_of_type_JavaIoFile);
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          akwr localakwr;
          String str;
          localException.printStackTrace();
          bbsr.a(2, "[Camera2]ImageSaveServer Exception:" + localException);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          bbsr.a(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + localOutOfMemoryError);
          continue;
          Object localObject = null;
        }
      }
    } while (this.jdField_a_of_type_Bbsn.jdField_a_of_type_Akwr == null);
    localakwr = this.jdField_a_of_type_Bbsn.jdField_a_of_type_Akwr;
    if (i != 0)
    {
      str = this.jdField_a_of_type_Bbsn.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      localakwr.a(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */