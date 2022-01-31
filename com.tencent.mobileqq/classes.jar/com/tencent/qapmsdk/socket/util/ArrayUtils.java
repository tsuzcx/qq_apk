package com.tencent.qapmsdk.socket.util;

import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class ArrayUtils
{
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  
  public static byte[] toPrimitive(Byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = paramArrayOfByte[i].byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.ArrayUtils
 * JD-Core Version:    0.7.0.1
 */