package com.tencent.mobileqq.pb;

import java.io.UnsupportedEncodingException;

public final class ByteStringMicro
{
  public static final ByteStringMicro EMPTY = new ByteStringMicro(new byte[0]);
  private final byte[] bytes;
  private volatile int hash = 0;
  
  private ByteStringMicro(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }
  
  public static ByteStringMicro copyFrom(String paramString1, String paramString2)
  {
    return new ByteStringMicro(paramString1.getBytes(paramString2));
  }
  
  public static ByteStringMicro copyFrom(byte[] paramArrayOfByte)
  {
    return copyFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ByteStringMicro copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new ByteStringMicro(arrayOfByte);
  }
  
  public static ByteStringMicro copyFromUtf8(String paramString)
  {
    try
    {
      paramString = new ByteStringMicro(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label16:
      break label16;
    }
    throw new RuntimeException("UTF-8 not supported?");
  }
  
  public byte byteAt(int paramInt)
  {
    return this.bytes[paramInt];
  }
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.bytes;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt, arrayOfByte.length);
  }
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ByteStringMicro)) {
      return false;
    }
    Object localObject = (ByteStringMicro)paramObject;
    paramObject = this.bytes;
    int j = paramObject.length;
    localObject = ((ByteStringMicro)localObject).bytes;
    if (j != localObject.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return true;
      }
      if (paramObject[i] != localObject[i]) {
        return false;
      }
      i += 1;
    }
  }
  
  public int hashCode()
  {
    int i = this.hash;
    if (i == 0)
    {
      byte[] arrayOfByte = this.bytes;
      int k = arrayOfByte.length;
      int j = 0;
      i = k;
      for (;;)
      {
        if (j >= k)
        {
          if (i == 0) {
            i = 1;
          }
          this.hash = i;
          return i;
        }
        i = i * 31 + arrayOfByte[j];
        j += 1;
      }
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    return this.bytes.length == 0;
  }
  
  public int size()
  {
    return this.bytes.length;
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte1 = this.bytes;
    int i = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    return arrayOfByte2;
  }
  
  public String toString(String paramString)
  {
    return new String(this.bytes, paramString);
  }
  
  public String toStringUtf8()
  {
    try
    {
      String str = new String(this.bytes, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label16:
      break label16;
    }
    throw new RuntimeException("UTF-8 not supported?");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pb.ByteStringMicro
 * JD-Core Version:    0.7.0.1
 */