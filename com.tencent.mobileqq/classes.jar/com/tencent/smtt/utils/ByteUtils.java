package com.tencent.smtt.utils;

public class ByteUtils
{
  public static void Word2Byte(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)paramShort);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if ((paramArrayOfByte[i] & 0xFF) < 16) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(Long.toString(paramArrayOfByte[i] & 0xFF, 16));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] subByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    Object localObject;
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > i))
    {
      localObject = null;
      return localObject;
    }
    i = paramInt2;
    if (paramInt2 < 0) {
      i = paramArrayOfByte.length - paramInt1;
    }
    byte[] arrayOfByte = new byte[i];
    paramInt2 = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (paramInt2 >= i) {
        break;
      }
      arrayOfByte[paramInt2] = paramArrayOfByte[(paramInt2 + paramInt1)];
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.ByteUtils
 * JD-Core Version:    0.7.0.1
 */