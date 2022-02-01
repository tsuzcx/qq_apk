package com.tencent.mobileqq.weiyun.sdk.upload;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class StoragePlatomProto
{
  private final int a;
  private final byte[] b;
  private final byte[] c;
  private final short d;
  private final long e;
  private long f;
  private short g;
  private long h;
  private int i;
  
  public StoragePlatomProto(int paramInt, byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2)
  {
    this.a = paramInt;
    this.e = paramLong1;
    this.b = paramArrayOfByte2;
    this.f = paramLong2;
    this.c = new byte[20];
    if (paramArrayOfByte1.length <= 20)
    {
      this.d = ((short)paramArrayOfByte1.length);
      paramInt = 0;
      while (paramInt < paramArrayOfByte1.length)
      {
        this.c[paramInt] = paramArrayOfByte1[paramInt];
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
    if (this.a == 1000) {}
    for (int j = this.b.length + 2 + 34;; j = this.b.length + 2 + 42) {
      return j + 16;
    }
  }
  
  public int a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt2, paramInt3);
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
      paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    }
    paramArrayOfByte.putInt(-1412589450);
    paramArrayOfByte.putInt(this.a);
    paramArrayOfByte.putInt((int)this.f);
    if (this.a == 1000) {
      paramInt2 = this.b.length + 2 + 34;
    } else {
      paramInt2 = this.b.length + 2 + 42;
    }
    paramInt2 += paramInt1;
    paramArrayOfByte.putInt(paramInt2);
    short s = (short)this.b.length;
    paramArrayOfByte.putShort(s);
    paramArrayOfByte.put(this.b, 0, s);
    paramArrayOfByte.putShort(this.d);
    paramArrayOfByte.put(this.c);
    paramArrayOfByte.putInt((int)(this.e & 0xFFFFFFFF));
    paramArrayOfByte.putInt((int)(paramLong & 0xFFFFFFFF));
    paramArrayOfByte.putInt(paramInt1);
    if (this.a == 1007)
    {
      paramArrayOfByte.putInt((int)((this.e & 0x0) >> 32));
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
    this.i = paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    paramInt = paramArrayOfByte.getInt();
    if (l1 != -1412589450L) {
      return 100002;
    }
    int j = this.i;
    if (j != 0) {
      return j;
    }
    if (paramBoolean)
    {
      if ((paramInt != 5) && (paramInt != 9)) {
        return 100002;
      }
      this.g = ((short)paramArrayOfByte.get());
      l1 = 0L;
      long l2 = paramArrayOfByte.getInt();
      if (this.a == 1007) {
        l1 = paramArrayOfByte.getInt();
      }
      this.h = ((0xFFFFFFFF & l2) + (l1 << 32 & 0x0));
    }
    return 0;
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public short b()
  {
    return this.g;
  }
  
  public long c()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.upload.StoragePlatomProto
 * JD-Core Version:    0.7.0.1
 */