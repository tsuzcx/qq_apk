package com.tencent.mobileqq.emoticon;

public class QQSmallEmoUtils
{
  public static int computeIntFromBytes(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j = j << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return j;
  }
  
  public static int[] getEmoDescripFromChars(char[] paramArrayOfChar)
  {
    return new int[] { computeIntFromBytes(new byte[] { (byte)paramArrayOfChar[0], (byte)paramArrayOfChar[1] }, 2), paramArrayOfChar[2] };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSmallEmoUtils
 * JD-Core Version:    0.7.0.1
 */