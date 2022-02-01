package com.tencent.mtt.hippy.b;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b$a
  extends DataInputStream
{
  public b$a(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    for (;;)
    {
      int j;
      if (i < paramInt)
      {
        j = read(arrayOfByte, i, paramInt - i);
        if (j != -1) {}
      }
      else
      {
        if (i == paramInt) {
          break;
        }
        throw new IOException(String.format("Read wrong number of bytes. Got: %s, Expected: %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
      }
      i += j;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.b.a
 * JD-Core Version:    0.7.0.1
 */