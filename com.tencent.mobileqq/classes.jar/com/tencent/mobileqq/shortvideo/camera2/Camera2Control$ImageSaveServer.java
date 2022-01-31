package com.tencent.mobileqq.shortvideo.camera2;

import ajrs;
import anwv;
import azbh;
import azbl;
import bdda;
import java.io.File;

public class Camera2Control$ImageSaveServer
  implements Runnable
{
  private final azbh jdField_a_of_type_Azbh;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  public Camera2Control$ImageSaveServer(byte[] paramArrayOfByte, azbh paramazbh)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Azbh = paramazbh;
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      azbl.a(2, "[Camera2]ImageSaveServer params error!");
      if (this.jdField_a_of_type_Azbh.jdField_a_of_type_Ajrs != null) {
        this.jdField_a_of_type_Azbh.jdField_a_of_type_Ajrs.a_(null);
      }
    }
    do
    {
      return;
      int j = azbl.a(this.jdField_a_of_type_Azbh.jdField_a_of_type_AndroidHardwareCamera2CameraCharacteristics, this.jdField_a_of_type_Azbh.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_Azbh.jdField_a_of_type_Boolean;
      try
      {
        bdda.a(anwv.b(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Azbh.jdField_a_of_type_AndroidGraphicsRect, bool, j), this.jdField_a_of_type_Azbh.jdField_a_of_type_JavaIoFile);
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ajrs localajrs;
          String str;
          localException.printStackTrace();
          azbl.a(2, "[Camera2]ImageSaveServer Exception:" + localException);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          azbl.a(2, "[Camera2]ImageSaveServer OutOfMemoryError:" + localOutOfMemoryError);
          continue;
          Object localObject = null;
        }
      }
    } while (this.jdField_a_of_type_Azbh.jdField_a_of_type_Ajrs == null);
    localajrs = this.jdField_a_of_type_Azbh.jdField_a_of_type_Ajrs;
    if (i != 0)
    {
      str = this.jdField_a_of_type_Azbh.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      localajrs.a_(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer
 * JD-Core Version:    0.7.0.1
 */