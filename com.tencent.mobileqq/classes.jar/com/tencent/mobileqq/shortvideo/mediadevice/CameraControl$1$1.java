package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera.Size;
import azcx;
import azcy;
import azdb;
import azdc;

public class CameraControl$1$1
  implements Runnable
{
  public CameraControl$1$1(azcy paramazcy, byte[] paramArrayOfByte, Camera.Size paramSize) {}
  
  public void run()
  {
    azdb localazdb = new azdb(this.jdField_a_of_type_Azcy.jdField_a_of_type_Azcx, null);
    localazdb.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localazdb.jdField_a_of_type_JavaIoFile = this.jdField_a_of_type_Azcy.jdField_a_of_type_JavaIoFile;
    localazdb.jdField_a_of_type_AndroidGraphicsRect = this.jdField_a_of_type_Azcy.jdField_a_of_type_AndroidGraphicsRect;
    localazdb.jdField_a_of_type_Ajrs = this.jdField_a_of_type_Azcy.jdField_a_of_type_Ajrs;
    localazdb.jdField_a_of_type_Int = this.jdField_a_of_type_Azcy.jdField_a_of_type_Int;
    localazdb.b = this.jdField_a_of_type_Azcy.jdField_a_of_type_Azcx.jdField_a_of_type_Int;
    localazdb.c = 100;
    localazdb.jdField_a_of_type_Boolean = this.jdField_a_of_type_Azcy.jdField_a_of_type_Boolean;
    localazdb.d = this.jdField_a_of_type_Azcy.b;
    localazdb.jdField_a_of_type_AndroidHardwareCamera$Size = this.jdField_a_of_type_AndroidHardwareCamera$Size;
    new azdc(this.jdField_a_of_type_Azcy.jdField_a_of_type_Azcx, localazdb).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.1.1
 * JD-Core Version:    0.7.0.1
 */