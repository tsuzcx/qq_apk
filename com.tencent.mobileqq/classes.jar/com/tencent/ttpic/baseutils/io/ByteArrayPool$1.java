package com.tencent.ttpic.baseutils.io;

import java.util.Comparator;

final class ByteArrayPool$1
  implements Comparator<byte[]>
{
  public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return paramArrayOfByte1.length - paramArrayOfByte2.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.io.ByteArrayPool.1
 * JD-Core Version:    0.7.0.1
 */