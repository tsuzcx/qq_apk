package com.tencent.mobileqq.troop.data;

import java.nio.ByteBuffer;

class TroopBarShortVideoUploadUtil$UploadReqBody
{
  public final int a = 304;
  public final byte[] b;
  public final int c;
  public final byte[] d;
  public final long e;
  public final long f;
  public final long g;
  public final long h;
  public final long i;
  
  public TroopBarShortVideoUploadUtil$UploadReqBody(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.b = paramArrayOfByte1;
    this.c = 20;
    this.d = paramArrayOfByte2;
    this.e = paramLong1;
    this.f = paramLong2;
    this.g = paramLong3;
    this.h = paramLong4;
    this.i = paramLong5;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.putShort((short)(this.a & 0xFFFF));
    Object localObject = this.b;
    int k = localObject.length;
    int j = this.a;
    byte[] arrayOfByte;
    if (k != j)
    {
      arrayOfByte = new byte[j];
      if (localObject.length <= j) {
        j = localObject.length;
      }
      System.arraycopy(this.b, 0, arrayOfByte, 0, j);
      while (j < this.a)
      {
        arrayOfByte[j] = 0;
        j += 1;
      }
      localObject = arrayOfByte;
    }
    paramByteBuffer.put((byte[])localObject, 0, this.a);
    paramByteBuffer.putShort((short)(this.c & 0xFFFF));
    localObject = this.d;
    k = localObject.length;
    j = this.c;
    if (k != j)
    {
      arrayOfByte = new byte[j];
      if (localObject.length <= j) {
        j = localObject.length;
      }
      System.arraycopy(this.d, 0, arrayOfByte, 0, j);
      while (j < this.c)
      {
        arrayOfByte[j] = 0;
        j += 1;
      }
      localObject = arrayOfByte;
    }
    paramByteBuffer.put((byte[])localObject, 0, this.c);
    paramByteBuffer.putInt((int)(this.e & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.f & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.g & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.h & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.i & 0xFFFFFFFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.UploadReqBody
 * JD-Core Version:    0.7.0.1
 */