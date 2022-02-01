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
    int i = this.f;
    if (i <= this.c - 1)
    {
      int[] arrayOfInt = this.d;
      this.f = (i + 1);
      arrayOfInt[i] = paramInt;
      return;
    }
    throw new IndexOutOfBoundsException("sequeue is full");
  }
  
  public void clear()
  {
    Arrays.fill(this.d, 0);
    this.e = 0;
    this.f = 0;
  }
  
  public int element()
  {
    if (!empty()) {
      return this.d[this.e];
    }
    throw new IndexOutOfBoundsException("sequeue is null");
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
    if (!empty())
    {
      int[] arrayOfInt = this.d;
      int i = this.e;
      int j = arrayOfInt[i];
      this.e = (i + 1);
      arrayOfInt[i] = 0;
      return j;
    }
    throw new IndexOutOfBoundsException("sequeue is null");
  }
  
  public String toString()
  {
    if (empty()) {
      return "";
    }
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = this.e;
    while (i < this.f)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(String.valueOf(this.d[i]));
      localStringBuilder2.append(",");
      localStringBuilder1.append(localStringBuilder2.toString());
      i += 1;
    }
    i = localStringBuilder1.length();
    localStringBuilder1 = localStringBuilder1.delete(i - 1, i);
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat.TbsSequenceQueue
 * JD-Core Version:    0.7.0.1
 */