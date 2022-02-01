package com.tencent.mobileqq.tts.stream;

import java.io.DataOutputStream;
import java.io.OutputStream;

public class ChunkedOutputStream
  extends DataOutputStream
{
  private static final byte[] e = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final byte[] f = { 13, 10 };
  private static final byte[] g = { 48, 13, 10 };
  protected byte[] a = null;
  protected int b = 0;
  protected int c = -1;
  protected byte[] d = new byte[32];
  
  public ChunkedOutputStream(OutputStream paramOutputStream)
  {
    this(new byte[512], paramOutputStream);
  }
  
  public ChunkedOutputStream(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
    this.a = paramArrayOfByte;
    this.c = paramArrayOfByte.length;
  }
  
  protected void a()
  {
    this.out.write(g, 0, 3);
    this.out.write(f, 0, 2);
    this.out.flush();
  }
  
  protected final void a(int paramInt)
  {
    if (this.b + 1 >= this.c) {
      b();
    }
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b();
      a();
      super.close();
      return;
    }
    b();
    a();
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    byte[] arrayOfByte = this.d;
    arrayOfByte[30] = 13;
    arrayOfByte[31] = 10;
    int j = paramInt2;
    int i = 3;
    while (j > 15)
    {
      this.d[(32 - i)] = e[(j % 16)];
      j >>= 4;
      i += 1;
    }
    arrayOfByte = this.d;
    int k = 32 - i;
    arrayOfByte[k] = e[j];
    this.out.write(this.d, k, i);
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.out.write(f, 0, 2);
    this.out.flush();
  }
  
  protected void b()
  {
    int i = this.b;
    if (i == 0) {
      return;
    }
    a(this.a, 0, i);
    this.b = 0;
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b + paramInt2 >= this.c) {
      b();
    }
    byte[] arrayOfByte = this.a;
    if (paramInt2 < arrayOfByte.length)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this.b, paramInt2);
      this.b += paramInt2;
      return;
    }
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void close()
  {
    a(true);
  }
  
  public void flush()
  {
    b();
    super.flush();
  }
  
  public void write(int paramInt)
  {
    a(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.stream.ChunkedOutputStream
 * JD-Core Version:    0.7.0.1
 */