package com.tencent.tbs.one.impl.c.a;

import com.tencent.tbs.one.impl.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;

public final class a
  implements Closeable
{
  boolean a;
  private final RandomAccessFile b;
  private final File c;
  private final byte[] d = new byte[8];
  
  public a(File paramFile)
  {
    this.c = paramFile;
    this.b = new RandomAccessFile(this.c, "r");
  }
  
  public final int a(byte[] paramArrayOfByte)
  {
    return this.b.read(paramArrayOfByte);
  }
  
  public final int a(char[] paramArrayOfChar)
  {
    byte[] arrayOfByte = new byte[paramArrayOfChar.length];
    int j = this.b.read(arrayOfByte);
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
    int j = this.b.readShort();
    int i = j;
    if (this.a) {
      i = (short)((j & 0xFF00) >>> 8 | (j & 0xFF) << 8);
    }
    return i;
  }
  
  public final void a(long paramLong)
  {
    this.b.seek(paramLong);
  }
  
  public final int b()
  {
    int j = this.b.readInt();
    int i = j;
    if (this.a) {
      i = (j & 0xFF000000) >>> 24 | (j & 0xFF) << 24 | (0xFF00 & j) << 8 | (0xFF0000 & j) >>> 8;
    }
    return i;
  }
  
  public final long c()
  {
    if (this.a)
    {
      this.b.readFully(this.d, 0, 8);
      return this.d[7] << 56 | (this.d[6] & 0xFF) << 48 | (this.d[5] & 0xFF) << 40 | (this.d[4] & 0xFF) << 32 | (this.d[3] & 0xFF) << 24 | (this.d[2] & 0xFF) << 16 | (this.d[1] & 0xFF) << 8 | this.d[0] & 0xFF;
    }
    return this.b.readLong();
  }
  
  public final void close()
  {
    c.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.a
 * JD-Core Version:    0.7.0.1
 */