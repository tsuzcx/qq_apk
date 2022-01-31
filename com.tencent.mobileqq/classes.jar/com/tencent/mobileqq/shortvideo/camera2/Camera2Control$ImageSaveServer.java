package com.tencent.mobileqq.shortvideo.camera2;

import aiai;
import amfv;
import axgb;
import axgf;
import bbef;
import java.io.File;

public class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final axgb jdField_a_of_type_Axgb;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  public Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, axgb paramaxgb)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Axgb = paramaxgb;
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      axgf.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.jdField_a_of_type_Axgb.jdField_a_of_type_Aiai != null) {
        this.jdField_a_of_type_Axgb.jdField_a_of_type_Aiai.a_(null);
      }
    }
    do
    {
      return;
      int j = axgf.a(this.jdField_a_of_type_Axgb.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_Axgb.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_Axgb.jdField_a_of_type_Boolean;
      try
      {
        bbef.a(amfv.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Axgb.jdField_a_of_type_AndroidGraphicsRect, bool, j), this.jdField_a_of_type_Axgb.jdField_a_of_type_JavaIoFile);
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          aiai localaiai;
          String str;
          localException.printStackTrace();
          axgf.a(2, "[Camera2]ImageSaveServer Exception:" + localException);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          axgf.a(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + localOutOfMemoryError);
          continue;
          Object localObject = null;
        }
      }
    } while (this.jdField_a_of_type_Axgb.jdField_a_of_type_Aiai == null);
    localaiai = this.jdField_a_of_type_Axgb.jdField_a_of_type_Aiai;
    if (i != 0)
    {
      str = this.jdField_a_of_type_Axgb.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      localaiai.a_(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */