package com.tencent.mobileqq.shortvideo.camera2;

import ajwh;
import aobe;
import azfq;
import azfu;
import bdhj;
import java.io.File;

public class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final azfq jdField_a_of_type_Azfq;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  public Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, azfq paramazfq)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Azfq = paramazfq;
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      azfu.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.jdField_a_of_type_Azfq.jdField_a_of_type_Ajwh != null) {
        this.jdField_a_of_type_Azfq.jdField_a_of_type_Ajwh.a_(null);
      }
    }
    do
    {
      return;
      int j = azfu.a(this.jdField_a_of_type_Azfq.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_Azfq.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_Azfq.jdField_a_of_type_Boolean;
      try
      {
        bdhj.a(aobe.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Azfq.jdField_a_of_type_AndroidGraphicsRect, bool, j), this.jdField_a_of_type_Azfq.jdField_a_of_type_JavaIoFile);
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ajwh localajwh;
          String str;
          localException.printStackTrace();
          azfu.a(2, "[Camera2]ImageSaveServer Exception:" + localException);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          azfu.a(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + localOutOfMemoryError);
          continue;
          Object localObject = null;
        }
      }
    } while (this.jdField_a_of_type_Azfq.jdField_a_of_type_Ajwh == null);
    localajwh = this.jdField_a_of_type_Azfq.jdField_a_of_type_Ajwh;
    if (i != 0)
    {
      str = this.jdField_a_of_type_Azfq.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      localajwh.a_(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */