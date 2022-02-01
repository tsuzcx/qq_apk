package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class c
  implements Closeable
{
  private final RandomAccessFile a;
  private final File b;
  private final byte[] c = new byte[8];
  private boolean d;
  
  public c(File paramFile)
  {
    this.b = paramFile;
    this.a = new RandomAccessFile(this.b, "r");
  }
  
  public c(String paramString)
  {
    this(new File(paramString));
  }
  
  public final int a(byte[] paramArrayOfByte)
  {
    return this.a.read(paramArrayOfByte);
  }
  
  public final int a(char[] paramArrayOfChar)
  {
    byte[] arrayOfByte = new byte[paramArrayOfChar.length];
    int j = this.a.read(arrayOfByte);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = ((char)arrayOfByte[i]);
      i += 1;
    }
    return j;
  }
  
  public final short a()
  {
    int j = this.a.readShort();
    int i = j;
    if (this.d) {
      i = (short)((j & 0xFF00) >>> 8 | (j & 0xFF) << 8);
    }
    return i;
  }
  
  public void a(long paramLong)
  {
    this.a.seek(paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final int b()
  {
    int j = this.a.readInt();
    int i = j;
    if (this.d) {
      i = (j & 0xFF000000) >>> 24 | (j & 0xFF) << 24 | (0xFF00 & j) << 8 | (0xFF0000 & j) >>> 8;
    }
    return i;
  }
  
  public final long c()
  {
    if (this.d)
    {
      this.a.readFully(this.c, 0, 8);
      return this.c[7] << 56 | (this.c[6] & 0xFF) << 48 | (this.c[5] & 0xFF) << 40 | (this.c[4] & 0xFF) << 32 | (this.c[3] & 0xFF) << 24 | (this.c[2] & 0xFF) << 16 | (this.c[1] & 0xFF) << 8 | this.c[0] & 0xFF;
    }
    return this.a.readLong();
  }
  
  public void close()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.c
 * JD-Core Version:    0.7.0.1
 */