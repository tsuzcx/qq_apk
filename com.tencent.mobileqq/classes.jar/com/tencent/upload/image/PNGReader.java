package com.tencent.upload.image;

import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PNGReader
{
  private byte a;
  private byte b;
  private int c = 0;
  private int d = 0;
  
  private int a(byte[] paramArrayOfByte, int paramInt)
    throws Exception
  {
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int i = j + 1;
    j = paramArrayOfByte[j];
    int k = i + 1;
    return (j & 0xFF) << 16 | (paramInt & 0xFF) << 24 | (paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[k] & 0xFF;
  }
  
  private long a(InputStream paramInputStream)
    throws Exception
  {
    byte[] arrayOfByte = new byte[8];
    paramInputStream.read(arrayOfByte, 0, 8);
    long l1 = arrayOfByte[0];
    long l2 = arrayOfByte[1];
    long l3 = arrayOfByte[2];
    long l4 = arrayOfByte[3];
    long l5 = arrayOfByte[4];
    long l6 = arrayOfByte[5];
    long l7 = arrayOfByte[6];
    return arrayOfByte[7] & 0xFF | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  private int b(InputStream paramInputStream)
    throws Exception
  {
    byte[] arrayOfByte = new byte[4];
    paramInputStream.read(arrayOfByte, 0, 4);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    int k = arrayOfByte[2];
    return arrayOfByte[3] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  private boolean c(InputStream paramInputStream)
    throws Exception
  {
    if ((b(paramInputStream) != 13) || (b(paramInputStream) != 1229472850)) {
      return false;
    }
    byte[] arrayOfByte = new byte[13];
    paramInputStream.read(arrayOfByte, 0, 13);
    this.c = a(arrayOfByte, 0);
    this.d = a(arrayOfByte, 4);
    this.a = arrayOfByte[8];
    this.b = arrayOfByte[9];
    return true;
  }
  
  public boolean isTransparentPng(String paramString)
  {
    try
    {
      unpackImage(new FileInputStream(paramString));
      if (((this.a == 8) || (this.a == 16)) && (this.b == 6)) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("ImageProcessService", paramString.toString());
      }
    }
    return false;
  }
  
  public void unpackImage(InputStream paramInputStream)
    throws Exception
  {
    if (a(paramInputStream) != -8552249625308161526L) {}
    while (c(paramInputStream)) {
      return;
    }
    throw new IOException("Not a valid png image !!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.image.PNGReader
 * JD-Core Version:    0.7.0.1
 */