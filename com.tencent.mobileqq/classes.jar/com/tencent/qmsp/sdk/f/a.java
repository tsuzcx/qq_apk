package com.tencent.qmsp.sdk.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class a
{
  private static a e = new a(102400);
  protected static final Comparator<byte[]> f = new a.a();
  private List<byte[]> a = new LinkedList();
  private List<byte[]> b = new ArrayList(64);
  private int c = 0;
  private final int d;
  
  public a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public static a a()
  {
    return e;
  }
  
  private void b()
  {
    try
    {
      while (this.c > this.d)
      {
        byte[] arrayOfByte = (byte[])this.a.remove(0);
        this.b.remove(arrayOfByte);
        this.c -= arrayOfByte.length;
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length <= this.d)
        {
          this.a.add(paramArrayOfByte);
          int j = Collections.binarySearch(this.b, paramArrayOfByte, f);
          int i = j;
          if (j < 0) {
            i = -j - 1;
          }
          this.b.add(i, paramArrayOfByte);
          this.c += paramArrayOfByte.length;
          b();
          return;
        }
      }
      finally {}
    }
  }
  
  public byte[] a(int paramInt)
  {
    int i = 0;
    try
    {
      while (i < this.b.size())
      {
        arrayOfByte = (byte[])this.b.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          this.c -= arrayOfByte.length;
          this.b.remove(i);
          this.a.remove(arrayOfByte);
          return arrayOfByte;
        }
        i += 1;
      }
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */