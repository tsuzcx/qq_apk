package com.tencent.mobileqq.kandian.base.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BytePool
{
  protected static final Comparator<byte[]> a = new BytePool.1();
  private List<byte[]> b = new ArrayList(64);
  private int c = 0;
  private final int d;
  
  public BytePool(int paramInt)
  {
    this.d = paramInt;
  }
  
  private void b()
  {
    try
    {
      while (this.c > this.d)
      {
        byte[] arrayOfByte = (byte[])this.b.get(0);
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
  
  public void a()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
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
          int j = Collections.binarySearch(this.b, paramArrayOfByte, a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.BytePool
 * JD-Core Version:    0.7.0.1
 */