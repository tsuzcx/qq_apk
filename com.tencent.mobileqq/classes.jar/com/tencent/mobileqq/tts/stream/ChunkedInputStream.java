package com.tencent.mobileqq.tts.stream;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class ChunkedInputStream
  extends InputStream
{
  private int a;
  private int b = 0;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  private final InputStream f;
  
  public ChunkedInputStream(InputStream paramInputStream)
  {
    this.f = paramInputStream;
  }
  
  private static int a(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInputStream == null) {
      return -1;
    }
    int i = 0;
    while (i != -1)
    {
      int j = paramInputStream.read();
      if (j == 123)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChunkedInputStream", 1, "Server did not return any chunk");
        }
        localStringBuilder = new StringBuilder("{");
        for (;;)
        {
          i = paramInputStream.read();
          if (-1 == i) {
            break;
          }
          localStringBuilder.append((char)i);
        }
        paramInputStream = new StringBuilder();
        paramInputStream.append("[getChunkSize] error: ");
        paramInputStream.append(localStringBuilder);
        QLog.d("ChunkedInputStream", 1, paramInputStream.toString());
        return -1;
      }
      if (i != 0)
      {
        if (i == 1) {
          if (j == 10) {
            i = -1;
          } else {
            throw new IOException("Read CRLF invalid!");
          }
        }
      }
      else if (j == 13) {
        i = 1;
      } else {
        localStringBuilder.append((char)j);
      }
    }
    return Integer.parseInt(localStringBuilder.toString(), 16);
  }
  
  private boolean b()
  {
    boolean bool1 = this.c;
    boolean bool3 = false;
    if (!bool1) {
      bool1 = c();
    } else {
      bool1 = false;
    }
    this.a = a(this.f);
    this.c = false;
    this.b = 0;
    if (this.a == 0) {
      this.d = true;
    }
    boolean bool2 = bool3;
    if (this.a >= 0)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private boolean c()
  {
    int i = this.f.read();
    int j = this.f.read();
    return (i == 13) && (j == 10);
  }
  
  public byte[] a()
  {
    boolean bool;
    if (!this.c) {
      bool = c();
    } else {
      bool = true;
    }
    this.c = false;
    Object localObject = this.f;
    if (localObject == null) {
      return new byte[0];
    }
    this.a = a((InputStream)localObject);
    if (4 == this.a) {
      read(new byte[4], 0, 4);
    }
    int i = this.a;
    if ((i > 0) && (bool))
    {
      localObject = new byte[i];
      int j;
      do
      {
        j = read((byte[])localObject, this.b, i);
        if (j < 0) {
          return new byte[0];
        }
        j = i - j;
        i = j;
      } while (j > 0);
      return localObject;
    }
    return new byte[0];
  }
  
  public int read()
  {
    if (!this.e)
    {
      if (this.d) {
        return -1;
      }
      if (this.b >= this.a)
      {
        b();
        if (this.d) {
          return -1;
        }
      }
      this.b += 1;
      return this.f.read();
    }
    throw new IOException("Attempted read from closed stream.");
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.e)
    {
      if (this.d) {
        return -1;
      }
      if (this.b >= this.a)
      {
        boolean bool = b();
        if ((this.d) || (!bool)) {
          return -1;
        }
      }
      paramInt2 = Math.min(paramInt2, this.a - this.b);
      paramInt1 = this.f.read(paramArrayOfByte, paramInt1, paramInt2);
      this.b += paramInt1;
      if (this.b == this.a) {
        this.b = 0;
      }
      return paramInt1;
    }
    throw new IOException("Attempted read from closed stream.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.stream.ChunkedInputStream
 * JD-Core Version:    0.7.0.1
 */