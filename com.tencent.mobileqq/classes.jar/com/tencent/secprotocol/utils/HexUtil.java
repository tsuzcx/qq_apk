package com.tencent.secprotocol.utils;

public class HexUtil
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    try
    {
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
        j = (byte)(j >>> 4);
        arrayOfChar[(i * 2 + 0)] = digits[(j & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.secprotocol.utils.HexUtil
 * JD-Core Version:    0.7.0.1
 */