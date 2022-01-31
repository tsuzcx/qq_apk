package com.tencent.upload.e;

public class d
{
  public static int a = 23;
  public final int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public short g = 0;
  public short h = 0;
  public int i = 0;
  private byte[] j = new byte[23];
  
  public d(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.i = paramInt3;
    this.e = paramInt2;
    byte[] arrayOfByte = new byte[4];
    a(paramInt1, arrayOfByte);
    System.arraycopy(arrayOfByte, 0, this.j, a.b, arrayOfByte.length);
    if (paramInt2 != 0)
    {
      a(paramInt2, arrayOfByte);
      System.arraycopy(arrayOfByte, 0, this.j, a.d, arrayOfByte.length);
    }
    a(this.i, arrayOfByte);
    System.arraycopy(arrayOfByte, 0, this.j, a.i, arrayOfByte.length);
  }
  
  public static d a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, a.b, arrayOfByte, 0, 4);
    int k = b(arrayOfByte);
    System.arraycopy(paramArrayOfByte, a.d, arrayOfByte, 0, 4);
    int m = b(arrayOfByte);
    System.arraycopy(paramArrayOfByte, a.i, arrayOfByte, 0, 4);
    return new d(k, m, b(arrayOfByte));
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte)
  {
    a(paramInt, paramArrayOfByte, 0);
  }
  
  public static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)paramInt1);
  }
  
  public static int b(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  public byte[] a()
  {
    return this.j;
  }
  
  public static class a
  {
    public static int a = 0;
    public static int b = 1;
    public static int c = 5;
    public static int d = 7;
    public static int e = 11;
    public static int f = 15;
    public static int g = 16;
    public static int h = 18;
    public static int i = 19;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.d
 * JD-Core Version:    0.7.0.1
 */