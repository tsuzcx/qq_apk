package com.tencent.mobileqq.troop.data;

import java.nio.ByteBuffer;

class TroopBarShortVideoUploadUtil$UploadReqBody
{
  public final int a;
  public final long a;
  public final byte[] a;
  public final int b;
  public final long b;
  public final byte[] b;
  public final long c;
  public final long d;
  public final long e;
  
  public TroopBarShortVideoUploadUtil$UploadReqBody(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.jdField_a_of_type_Int = 304;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_Int = 20;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramLong5;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.putShort((short)(this.jdField_a_of_type_Int & 0xFFFF));
    Object localObject = this.jdField_a_of_type_ArrayOfByte;
    int j = localObject.length;
    int i = this.jdField_a_of_type_Int;
    byte[] arrayOfByte;
    if (j != i)
    {
      arrayOfByte = new byte[i];
      if (localObject.length <= i) {
        i = localObject.length;
      }
      System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, i);
      while (i < this.jdField_a_of_type_Int)
      {
        arrayOfByte[i] = 0;
        i += 1;
      }
      localObject = arrayOfByte;
    }
    paramByteBuffer.put((byte[])localObject, 0, this.jdField_a_of_type_Int);
    paramByteBuffer.putShort((short)(this.jdField_b_of_type_Int & 0xFFFF));
    localObject = this.jdField_b_of_type_ArrayOfByte;
    j = localObject.length;
    i = this.jdField_b_of_type_Int;
    if (j != i)
    {
      arrayOfByte = new byte[i];
      if (localObject.length <= i) {
        i = localObject.length;
      }
      System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, arrayOfByte, 0, i);
      while (i < this.jdField_b_of_type_Int)
      {
        arrayOfByte[i] = 0;
        i += 1;
      }
      localObject = arrayOfByte;
    }
    paramByteBuffer.put((byte[])localObject, 0, this.jdField_b_of_type_Int);
    paramByteBuffer.putInt((int)(this.jdField_a_of_type_Long & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.jdField_b_of_type_Long & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.c & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.d & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.e & 0xFFFFFFFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.UploadReqBody
 * JD-Core Version:    0.7.0.1
 */