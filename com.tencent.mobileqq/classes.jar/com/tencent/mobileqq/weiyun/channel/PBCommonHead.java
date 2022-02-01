package com.tencent.mobileqq.weiyun.channel;

import com.tencent.mobileqq.util.EndianUtil;

final class PBCommonHead
{
  public static int f = 16;
  int a = 538116905;
  short b = 1;
  int c;
  int d;
  short e = 0;
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
    this.a = EndianUtil.a(arrayOfByte);
    arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 4, arrayOfByte, 0, 2);
    this.b = EndianUtil.b(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 6, arrayOfByte, 0, 4);
    this.c = EndianUtil.a(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 10, arrayOfByte, 0, 4);
    this.d = EndianUtil.a(arrayOfByte);
    arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 14, arrayOfByte, 0, 2);
    this.e = EndianUtil.b(arrayOfByte);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte = new byte[16];
    System.arraycopy(EndianUtil.a(this.a), 0, arrayOfByte, 0, 4);
    System.arraycopy(EndianUtil.a(this.b), 0, arrayOfByte, 4, 2);
    System.arraycopy(EndianUtil.a(this.c), 0, arrayOfByte, 6, 4);
    System.arraycopy(EndianUtil.a(this.d), 0, arrayOfByte, 10, 4);
    System.arraycopy(EndianUtil.a(this.e), 0, arrayOfByte, 14, 2);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.channel.PBCommonHead
 * JD-Core Version:    0.7.0.1
 */