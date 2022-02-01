package com.tencent.smtt.sdk;

import java.util.Arrays;

public class TbsCoreLoadStat$TbsSequenceQueue
{
  private int b = 10;
  private int c;
  private int[] d;
  private int e = 0;
  private int f = 0;
  
  public TbsCoreLoadStat$TbsSequenceQueue(TbsCoreLoadStat paramTbsCoreLoadStat)
  {
    this.c = this.b;
    this.d = new int[this.c];
  }
  
  public TbsCoreLoadStat$TbsSequenceQueue(TbsCoreLoadStat paramTbsCoreLoadStat, int paramInt1, int paramInt2)
  {
    this.c = paramInt2;
    this.d = new int[this.c];
    this.d[0] = paramInt1;
    this.f += 1;
  }
  
  public void add(int paramInt)
  {
    if (this.f > this.c - 1) {
      throw new IndexOutOfBoundsException("sequeue is full");
    }
    int[] arrayOfInt = this.d;
    int i = this.f;
    this.f = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  public void clear()
  {
    Arrays.fill(this.d, 0);
    this.e = 0;
    this.f = 0;
  }
  
  public int element()
  {
    if (empty()) {
      throw new IndexOutOfBoundsException("sequeue is null");
    }
    return this.d[this.e];
  }
  
  public boolean empty()
  {
    return this.f == this.e;
  }
  
  public int length()
  {
    return this.f - this.e;
  }
  
  public int remove()
  {
    if (empty()) {
      throw new IndexOutOfBoundsException("sequeue is null");
    }
    int i = this.d[this.e];
    int[] arrayOfInt = this.d;
    int j = this.e;
    this.e = (j + 1);
    arrayOfInt[j] = 0;
    return i;
  }
  
  public String toString()
  {
    if (empty()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = this.e;
    while (i < this.f)
    {
      localStringBuilder.append(String.valueOf(this.d[i]) + ",");
      i += 1;
    }
    i = localStringBuilder.length();
    return "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat.TbsSequenceQueue
 * JD-Core Version:    0.7.0.1
 */