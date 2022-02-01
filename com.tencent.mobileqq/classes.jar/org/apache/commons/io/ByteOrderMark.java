package org.apache.commons.io;

import java.io.Serializable;

public class ByteOrderMark
  implements Serializable
{
  public static final ByteOrderMark UTF_16BE = new ByteOrderMark("UTF-16BE", new int[] { 254, 255 });
  public static final ByteOrderMark UTF_16LE = new ByteOrderMark("UTF-16LE", new int[] { 255, 254 });
  public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", new int[] { 0, 0, 254, 255 });
  public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", new int[] { 255, 254, 0, 0 });
  public static final ByteOrderMark UTF_8 = new ByteOrderMark("UTF-8", new int[] { 239, 187, 191 });
  public static final char UTF_BOM = '﻿';
  private static final long serialVersionUID = 1L;
  private final int[] bytes;
  private final String charsetName;
  
  public ByteOrderMark(String paramString, int... paramVarArgs)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0))
      {
        this.charsetName = paramString;
        this.bytes = new int[paramVarArgs.length];
        System.arraycopy(paramVarArgs, 0, this.bytes, 0, paramVarArgs.length);
        return;
      }
      throw new IllegalArgumentException("No bytes specified");
    }
    throw new IllegalArgumentException("No charsetName specified");
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ByteOrderMark)) {
      return false;
    }
    paramObject = (ByteOrderMark)paramObject;
    if (this.bytes.length != paramObject.length()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.bytes;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (arrayOfInt[i] != paramObject.get(i)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int get(int paramInt)
  {
    return this.bytes[paramInt];
  }
  
  public byte[] getBytes()
  {
    byte[] arrayOfByte = new byte[this.bytes.length];
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.bytes;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfByte[i] = ((byte)arrayOfInt[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public String getCharsetName()
  {
    return this.charsetName;
  }
  
  public int hashCode()
  {
    int j = getClass().hashCode();
    int[] arrayOfInt = this.bytes;
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      j += arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public int length()
  {
    return this.bytes.length;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append('[');
    localStringBuilder.append(this.charsetName);
    localStringBuilder.append(": ");
    int i = 0;
    while (i < this.bytes.length)
    {
      if (i > 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("0x");
      localStringBuilder.append(Integer.toHexString(this.bytes[i] & 0xFF).toUpperCase());
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.ByteOrderMark
 * JD-Core Version:    0.7.0.1
 */