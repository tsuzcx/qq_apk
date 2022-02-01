package com.tencent.mobileqq.shortvideo.camera2;

import alox;
import aqbj;
import bcgq;
import bcgu;
import bgmo;
import java.io.File;

public class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final bcgq jdField_a_of_type_Bcgq;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  public Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, bcgq parambcgq)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Bcgq = parambcgq;
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      bcgu.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.jdField_a_of_type_Bcgq.jdField_a_of_type_Alox != null) {
        this.jdField_a_of_type_Bcgq.jdField_a_of_type_Alox.a_(null);
      }
    }
    do
    {
      return;
      int j = bcgu.a(this.jdField_a_of_type_Bcgq.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_Bcgq.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_Bcgq.jdField_a_of_type_Boolean;
      try
      {
        bgmo.a(aqbj.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Bcgq.jdField_a_of_type_AndroidGraphicsRect, bool, j), this.jdField_a_of_type_Bcgq.jdField_a_of_type_JavaIoFile);
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          alox localalox;
          String str;
          localException.printStackTrace();
          bcgu.a(2, "[Camera2]ImageSaveServer Exception:" + localException);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          bcgu.a(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + localOutOfMemoryError);
          continue;
          Object localObject = null;
        }
      }
    } while (this.jdField_a_of_type_Bcgq.jdField_a_of_type_Alox == null);
    localalox = this.jdField_a_of_type_Bcgq.jdField_a_of_type_Alox;
    if (i != 0)
    {
      str = this.jdField_a_of_type_Bcgq.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      localalox.a_(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */