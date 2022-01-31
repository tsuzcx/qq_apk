package com.tencent.mobileqq.nearby.now.send.uploader;

import java.io.ByteArrayOutputStream;

public class OutBuffer
{
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
  private boolean jdField_a_of_type_Boolean = true;
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramInt);
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.flush();
  }
  
  public void a(long paramLong)
  {
    a(paramLong, 4);
  }
  
  public void a(long paramLong, int paramInt)
  {
    int j = -1;
    if ((paramInt <= 0) || (paramInt > 8)) {
      throw new IllegalArgumentException("argument len should be >0 and <=8");
    }
    byte[] arrayOfByte = new byte[paramInt];
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = paramInt - 1;
      if (this.jdField_a_of_type_Boolean) {
        paramInt = -1;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label95;
      }
    }
    for (;;)
    {
      if (i == paramInt) {
        break label101;
      }
      arrayOfByte[i] = ((byte)(int)(0xFF & paramLong));
      paramLong >>>= 8;
      i += j;
      continue;
      i = 0;
      break;
      label95:
      j = 1;
    }
    label101:
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(arrayOfByte);
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.flush();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramArrayOfByte);
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 2);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      b(0);
      return;
    }
    b(paramArrayOfByte.length);
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.OutBuffer
 * JD-Core Version:    0.7.0.1
 */