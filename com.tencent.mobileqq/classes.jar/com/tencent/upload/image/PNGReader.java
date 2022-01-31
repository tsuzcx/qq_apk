package com.tencent.upload.image;

import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PNGReader
{
  private static final int IHDR = 1229472850;
  private static final long SIGNATURE = -8552249625308161526L;
  private byte bit_depth;
  private byte color_type;
  private int height = 0;
  private int width = 0;
  
  private int readInt(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[4];
    paramInputStream.read(arrayOfByte, 0, 4);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    int k = arrayOfByte[2];
    return arrayOfByte[3] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  private int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int i = j + 1;
    j = paramArrayOfByte[j];
    int k = i + 1;
    return (j & 0xFF) << 16 | (paramInt & 0xFF) << 24 | (paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[k] & 0xFF;
  }
  
  private long readLong(InputStream paramInputStream)
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
  
  private boolean read_IHDR(InputStream paramInputStream)
  {
    if ((readInt(paramInputStream) != 13) || (readInt(paramInputStream) != 1229472850)) {
      return false;
    }
    byte[] arrayOfByte = new byte[13];
    paramInputStream.read(arrayOfByte, 0, 13);
    this.width = readInt(arrayOfByte, 0);
    this.height = readInt(arrayOfByte, 4);
    this.bit_depth = arrayOfByte[8];
    this.color_type = arrayOfByte[9];
    return true;
  }
  
  public boolean isTransparentPng(String paramString)
  {
    try
    {
      unpackImage(new FileInputStream(paramString));
      if (((this.bit_depth == 8) || (this.bit_depth == 16)) && (this.color_type == 6)) {
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
  {
    if (readLong(paramInputStream) != -8552249625308161526L) {}
    while (read_IHDR(paramInputStream)) {
      return;
    }
    throw new IOException("Not a valid png image !!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.image.PNGReader
 * JD-Core Version:    0.7.0.1
 */