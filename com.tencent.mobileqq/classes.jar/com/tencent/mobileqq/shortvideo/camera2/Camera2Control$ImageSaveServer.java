package com.tencent.mobileqq.shortvideo.camera2;

import ahns;
import alrg;
import awgt;
import awgx;
import bacm;
import java.io.File;

public class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final awgt jdField_a_of_type_Awgt;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  public Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, awgt paramawgt)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Awgt = paramawgt;
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      awgx.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.jdField_a_of_type_Awgt.jdField_a_of_type_Ahns != null) {
        this.jdField_a_of_type_Awgt.jdField_a_of_type_Ahns.a_(null);
      }
    }
    do
    {
      return;
      int j = awgx.a(this.jdField_a_of_type_Awgt.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_Awgt.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_Awgt.jdField_a_of_type_Boolean;
      try
      {
        bacm.a(alrg.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Awgt.jdField_a_of_type_AndroidGraphicsRect, bool, j), this.jdField_a_of_type_Awgt.jdField_a_of_type_JavaIoFile);
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ahns localahns;
          String str;
          localException.printStackTrace();
          awgx.a(2, "[Camera2]ImageSaveServer Exception:" + localException);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          awgx.a(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + localOutOfMemoryError);
          continue;
          Object localObject = null;
        }
      }
    } while (this.jdField_a_of_type_Awgt.jdField_a_of_type_Ahns == null);
    localahns = this.jdField_a_of_type_Awgt.jdField_a_of_type_Ahns;
    if (i != 0)
    {
      str = this.jdField_a_of_type_Awgt.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      localahns.a_(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */