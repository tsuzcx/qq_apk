package com.tencent.tkd.comment.util.io;

import java.util.Comparator;

final class ByteArrayPool$1
  implements Comparator<byte[]>
{
  public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length < paramArrayOfByte2.length) {
      return -1;
    }
    if (paramArrayOfByte1.length == paramArrayOfByte2.length) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.util.io.ByteArrayPool.1
 * JD-Core Version:    0.7.0.1
 */