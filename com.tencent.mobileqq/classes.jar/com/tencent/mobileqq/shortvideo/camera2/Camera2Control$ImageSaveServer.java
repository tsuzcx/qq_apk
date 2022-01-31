package com.tencent.mobileqq.shortvideo.camera2;

import aiak;
import amfw;
import axfz;
import axgd;
import bbdr;
import java.io.File;

public class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final axfz jdField_a_of_type_Axfz;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  public Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, axfz paramaxfz)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Axfz = paramaxfz;
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      axgd.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.jdField_a_of_type_Axfz.jdField_a_of_type_Aiak != null) {
        this.jdField_a_of_type_Axfz.jdField_a_of_type_Aiak.a_(null);
      }
    }
    do
    {
      return;
      int j = axgd.a(this.jdField_a_of_type_Axfz.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_Axfz.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_Axfz.jdField_a_of_type_Boolean;
      try
      {
        bbdr.a(amfw.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Axfz.jdField_a_of_type_AndroidGraphicsRect, bool, j), this.jdField_a_of_type_Axfz.jdField_a_of_type_JavaIoFile);
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          aiak localaiak;
          String str;
          localException.printStackTrace();
          axgd.a(2, "[Camera2]ImageSaveServer Exception:" + localException);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          axgd.a(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + localOutOfMemoryError);
          continue;
          Object localObject = null;
        }
      }
    } while (this.jdField_a_of_type_Axfz.jdField_a_of_type_Aiak == null);
    localaiak = this.jdField_a_of_type_Axfz.jdField_a_of_type_Aiak;
    if (i != 0)
    {
      str = this.jdField_a_of_type_Axfz.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      localaiak.a_(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */