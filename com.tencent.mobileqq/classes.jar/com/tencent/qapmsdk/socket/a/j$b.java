package com.tencent.qapmsdk.socket.a;

import com.tencent.qapmsdk.socket.c.a;
import java.io.ByteArrayOutputStream;

class j$b
{
  boolean f;
  a g;
  boolean h;
  int i;
  ByteArrayOutputStream j = new ByteArrayOutputStream();
  
  j$b(boolean paramBoolean, a parama)
  {
    this.f = paramBoolean;
    this.g = parama;
  }
  
  String a(byte[] paramArrayOfByte)
  {
    int k = this.i;
    while (k < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[k] == 10)
      {
        int i1 = this.i;
        int n = k - i1;
        int i2 = k - 1;
        int m = n;
        if (i2 >= 0)
        {
          m = n;
          if (paramArrayOfByte[i2] == 13) {
            m = n - 1;
          }
        }
        byte[] arrayOfByte = new byte[m];
        System.arraycopy(paramArrayOfByte, i1, arrayOfByte, 0, m);
        this.i = (k + 1);
        return new String(arrayOfByte);
      }
      k += 1;
    }
    return null;
  }
  
  byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.min(paramArrayOfByte.length - this.i, paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, this.i, arrayOfByte, 0, paramInt);
    this.i = (paramInt + this.i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.b
 * JD-Core Version:    0.7.0.1
 */