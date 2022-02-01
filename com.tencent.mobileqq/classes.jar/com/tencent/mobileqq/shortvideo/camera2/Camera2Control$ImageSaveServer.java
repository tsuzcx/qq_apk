package com.tencent.mobileqq.shortvideo.camera2;

import amap;
import aqql;
import bczi;
import bczm;
import bhmq;
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
      if (this.jdField_a_of_type_Bczi.jdField_a_of_type_Amap != null) {
        this.jdField_a_of_type_Bczi.jdField_a_of_type_Amap.a_(null);
      }
    }
    do
    {
      return;
      int j = bczm.a(this.jdField_a_of_type_Bczi.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_Bczi.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_Bczi.jdField_a_of_type_Boolean;
      try
      {
        bhmq.a(aqql.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Bczi.jdField_a_of_type_AndroidGraphicsRect, bool, j), this.jdField_a_of_type_Bczi.jdField_a_of_type_JavaIoFile);
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          amap localamap;
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
    } while (this.jdField_a_of_type_Bczi.jdField_a_of_type_Amap == null);
    localamap = this.jdField_a_of_type_Bczi.jdField_a_of_type_Amap;
    if (i != 0)
    {
      str = this.jdField_a_of_type_Bczi.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      localamap.a_(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */