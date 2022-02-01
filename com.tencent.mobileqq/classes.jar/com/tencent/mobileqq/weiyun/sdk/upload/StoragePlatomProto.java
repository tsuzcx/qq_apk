package com.tencent.mobileqq.weiyun.sdk.upload;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class StoragePlatomProto
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final short jdField_a_of_type_Short;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private short jdField_b_of_type_Short;
  private final byte[] jdField_b_of_type_ArrayOfByte;
  private long c;
  
  public StoragePlatomProto(int paramInt, byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte2;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_ArrayOfByte = new byte[20];
    if (paramArrayOfByte1.length <= 20)
    {
      this.jdField_a_of_type_Short = ((short)paramArrayOfByte1.length);
      paramInt = 0;
      while (paramInt < paramArrayOfByte1.length)
      {
        this.jdField_b_of_type_ArrayOfByte[paramInt] = paramArrayOfByte1[paramInt];
        paramInt += 1;
      }
      return;
    }
    paramArrayOfByte1 = new IllegalArgumentException("file Hash is too long.");
    for (;;)
    {
      throw paramArrayOfByte1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 1000) {}
    for (int i = this.jdField_a_of_type_ArrayOfByte.length + 2 + 34;; i = this.jdField_a_of_type_ArrayOfByte.length + 2 + 42) {
      return i + 16;
    }
  }
  
  public int a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt2, paramInt3);
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
      paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    }
    paramArrayOfByte.putInt(-1412589450);
    paramArrayOfByte.putInt(this.jdField_a_of_type_Int);
    paramArrayOfByte.putInt((int)this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Int == 1000) {
      paramInt2 = this.jdField_a_of_type_ArrayOfByte.length + 2 + 34;
    } else {
      paramInt2 = this.jdField_a_of_type_ArrayOfByte.length + 2 + 42;
    }
    paramInt2 += paramInt1;
    paramArrayOfByte.putInt(paramInt2);
    short s = (short)this.jdField_a_of_type_ArrayOfByte.length;
    paramArrayOfByte.putShort(s);
    paramArrayOfByte.put(this.jdField_a_of_type_ArrayOfByte, 0, s);
    paramArrayOfByte.putShort(this.jdField_a_of_type_Short);
    paramArrayOfByte.put(this.jdField_b_of_type_ArrayOfByte);
    paramArrayOfByte.putInt((int)(this.jdField_a_of_type_Long & 0xFFFFFFFF));
    paramArrayOfByte.putInt((int)(paramLong & 0xFFFFFFFF));
    paramArrayOfByte.putInt(paramInt1);
    if (this.jdField_a_of_type_Int == 1007)
    {
      paramArrayOfByte.putInt((int)((this.jdField_a_of_type_Long & 0x0) >> 32));
      paramArrayOfByte.putInt((int)((paramLong & 0x0) >> 32));
    }
    return paramInt2 + 16 - paramInt1;
  }
  
  public int a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, 0, paramInt);
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
      paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    }
    long l1 = paramArrayOfByte.getInt();
    this.jdField_b_of_type_Int = paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    paramInt = paramArrayOfByte.getInt();
    if (l1 != -1412589450L) {
      return 100002;
    }
    int i = this.jdField_b_of_type_Int;
    if (i != 0) {
      return i;
    }
    if (paramBoolean)
    {
      if ((paramInt != 5) && (paramInt != 9)) {
        return 100002;
      }
      this.jdField_b_of_type_Short = ((short)paramArrayOfByte.get());
      l1 = 0L;
      long l2 = paramArrayOfByte.getInt();
      if (this.jdField_a_of_type_Int == 1007) {
        l1 = paramArrayOfByte.getInt();
      }
      this.c = ((0xFFFFFFFF & l2) + (l1 << 32 & 0x0));
    }
    return 0;
  }
  
  public long a()
  {
    return this.c;
  }
  
  public short a()
  {
    return this.jdField_b_of_type_Short;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.upload.StoragePlatomProto
 * JD-Core Version:    0.7.0.1
 */