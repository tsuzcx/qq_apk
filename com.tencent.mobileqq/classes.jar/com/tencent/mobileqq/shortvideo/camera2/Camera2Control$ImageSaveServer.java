package com.tencent.mobileqq.shortvideo.camera2;

import alun;
import aqmy;
import bczi;
import bczm;
import bheg;
import java.io.File;

public class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final bczi jdField_a_of_type_Bczi;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  public Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, bczi parambczi)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Bczi = parambczi;
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      bczm.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.jdField_a_of_type_Bczi.jdField_a_of_type_Alun != null) {
        this.jdField_a_of_type_Bczi.jdField_a_of_type_Alun.a(null);
      }
    }
    do
    {
      return;
      int j = bczm.a(this.jdField_a_of_type_Bczi.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_Bczi.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_Bczi.jdField_a_of_type_Boolean;
      try
      {
        bheg.a(aqmy.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Bczi.jdField_a_of_type_AndroidGraphicsRect, bool, j), this.jdField_a_of_type_Bczi.jdField_a_of_type_JavaIoFile);
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          alun localalun;
          String str;
          localException.printStackTrace();
          bczm.a(2, "[Camera2]ImageSaveServer Exception:" + localException);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          bczm.a(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + localOutOfMemoryError);
          continue;
          Object localObject = null;
        }
      }
    } while (this.jdField_a_of_type_Bczi.jdField_a_of_type_Alun == null);
    localalun = this.jdField_a_of_type_Bczi.jdField_a_of_type_Alun;
    if (i != 0)
    {
      str = this.jdField_a_of_type_Bczi.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      localalun.a(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */