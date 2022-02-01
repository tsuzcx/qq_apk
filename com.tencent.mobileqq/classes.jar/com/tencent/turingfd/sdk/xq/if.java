package com.tencent.turingfd.sdk.xq;

public class if
{
  public static final char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      int k = i * 2;
      char[] arrayOfChar2 = digits;
      arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
      arrayOfChar1[(k + 0)] = arrayOfChar2[((byte)(j >>> 4) & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.if
 * JD-Core Version:    0.7.0.1
 */