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
      byte[] arrayOfByte = this.d;
      long l1 = arrayOfByte[7];
      long l2 = arrayOfByte[6] & 0xFF;
      long l3 = arrayOfByte[5] & 0xFF;
      long l4 = arrayOfByte[4] & 0xFF;
      long l5 = arrayOfByte[3] & 0xFF;
      long l6 = arrayOfByte[2] & 0xFF;
      return (arrayOfByte[1] & 0xFF) << 8 | l1 << 56 | l2 << 48 | l3 << 40 | l4 << 32 | l5 << 24 | l6 << 16 | arrayOfByte[0] & 0xFF;
    }
    return this.b.readLong();
  }
  
  public final void close()
  {
    c.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.a
 * JD-Core Version:    0.7.0.1
 */