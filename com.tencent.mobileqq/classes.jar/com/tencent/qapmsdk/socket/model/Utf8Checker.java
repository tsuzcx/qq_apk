package com.tencent.qapmsdk.socket.model;

import java.io.EOFException;

public class Utf8Checker
{
  private static final int REPLACEMENT_CHARACTER = 65533;
  private int prefixOffset;
  
  private int readUtf8CodePoint(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length - this.prefixOffset == 0) {
      throw new EOFException();
    }
    int m = paramArrayOfByte[this.prefixOffset];
    int j;
    int i;
    int k;
    if ((m & 0x80) == 0)
    {
      j = 0;
      i = m & 0x7F;
      k = 1;
    }
    while (paramArrayOfByte.length - this.prefixOffset < k)
    {
      throw new EOFException("size < " + k + ": " + (paramArrayOfByte.length - this.prefixOffset) + " (to read code point prefixed 0x" + Integer.toHexString(m) + ")");
      if ((m & 0xE0) == 192)
      {
        i = m & 0x1F;
        k = 2;
        j = 128;
      }
      else if ((m & 0xF0) == 224)
      {
        i = m & 0xF;
        k = 3;
        j = 2048;
      }
      else if ((m & 0xF8) == 240)
      {
        i = m & 0x7;
        k = 4;
        j = 65536;
      }
      else
      {
        this.prefixOffset += 1;
        return 65533;
      }
    }
    m = 1;
    while (m < k)
    {
      int n = paramArrayOfByte[(this.prefixOffset + m)];
      if ((n & 0xC0) == 128)
      {
        m += 1;
        i = n & 0x3F | i << 6;
      }
      else
      {
        this.prefixOffset += m;
        return 65533;
      }
    }
    this.prefixOffset += k;
    if (i > 1114111) {
      return 65533;
    }
    if ((i >= 55296) && (i <= 57343)) {
      return 65533;
    }
    if (i < j) {
      return 65533;
    }
    return i;
  }
  
  public boolean isPlaintext(byte[] paramArrayOfByte)
  {
    int i = 64;
    boolean bool2 = false;
    boolean bool1;
    try
    {
      if (paramArrayOfByte.length < 64) {
        i = paramArrayOfByte.length;
      }
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      i = 0;
      while ((i < 16) && (arrayOfByte.length - this.prefixOffset != 0))
      {
        int j = readUtf8CodePoint(arrayOfByte);
        if (Character.isISOControl(j))
        {
          boolean bool3 = Character.isWhitespace(j);
          bool1 = bool2;
          if (!bool3) {
            break label94;
          }
        }
        i += 1;
      }
      bool1 = true;
    }
    catch (EOFException paramArrayOfByte)
    {
      return false;
    }
    label94:
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.model.Utf8Checker
 * JD-Core Version:    0.7.0.1
 */