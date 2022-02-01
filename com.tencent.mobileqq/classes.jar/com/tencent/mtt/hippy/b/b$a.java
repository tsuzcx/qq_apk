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
    Object localObject = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = read((byte[])localObject, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i == paramInt) {
      return localObject;
    }
    localObject = new IOException(String.format("Read wrong number of bytes. Got: %s, Expected: %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.b.a
 * JD-Core Version:    0.7.0.1
 */