package com.tencent.theme;

import java.io.IOException;
import java.nio.ByteBuffer;

class a
{
  static final void a(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = paramByteBuffer.getInt();
    if (i == paramInt) {
      return;
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("Expected chunk of type 0x");
    paramByteBuffer.append(Integer.toHexString(paramInt));
    paramByteBuffer.append(", read 0x");
    paramByteBuffer.append(Integer.toHexString(i));
    paramByteBuffer.append(".");
    throw new IOException(paramByteBuffer.toString());
  }
  
  static final void b(ByteBuffer paramByteBuffer, int paramInt)
  {
    paramByteBuffer.position(paramByteBuffer.position() + paramInt);
  }
  
  static final int[] c(ByteBuffer paramByteBuffer, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfInt[i] = paramByteBuffer.getInt();
      i += 1;
    }
    return arrayOfInt;
  }
  
  static final byte[] d(ByteBuffer paramByteBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.a
 * JD-Core Version:    0.7.0.1
 */