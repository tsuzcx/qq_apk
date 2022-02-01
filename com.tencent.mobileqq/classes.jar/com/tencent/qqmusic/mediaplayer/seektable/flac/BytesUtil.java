package com.tencent.qqmusic.mediaplayer.seektable.flac;

public class BytesUtil
{
  public static int from(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length <= 4)
    {
      int i;
      if (paramArrayOfByte.length == 3)
      {
        i = paramArrayOfByte[0];
        int j = paramArrayOfByte[1];
        return paramArrayOfByte[2] & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
      }
      if (paramArrayOfByte.length == 2)
      {
        i = paramArrayOfByte[0];
        return paramArrayOfByte[1] & 0xF | (i & 0xFF) << 8;
      }
      if (paramArrayOfByte.length == 1) {
        return paramArrayOfByte[0] & 0xFF;
      }
      throw new RuntimeException("bytes must be greater than 8 bit!");
    }
    throw new RuntimeException("bytes can't be greater than 32 bit!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.BytesUtil
 * JD-Core Version:    0.7.0.1
 */