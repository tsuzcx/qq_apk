package com.tencent.smtt.sdk;

import java.util.Arrays;

public class TbsCoreLoadStat$TbsSequenceQueue
{
  private int DEFAULT_SIZE = 10;
  private int capacity;
  private int[] elementData;
  private int front = 0;
  private int rear = 0;
  
  public TbsCoreLoadStat$TbsSequenceQueue(TbsCoreLoadStat paramTbsCoreLoadStat)
  {
    this.capacity = this.DEFAULT_SIZE;
    this.elementData = new int[this.capacity];
  }
  
  public TbsCoreLoadStat$TbsSequenceQueue(TbsCoreLoadStat paramTbsCoreLoadStat, int paramInt1, int paramInt2)
  {
    this.capacity = paramInt2;
    this.elementData = new int[this.capacity];
    this.elementData[0] = paramInt1;
    this.rear += 1;
  }
  
  public void add(int paramInt)
  {
    if (this.rear > this.capacity - 1) {
      throw new IndexOutOfBoundsException("sequeue is full");
    }
    int[] arrayOfInt = this.elementData;
    int i = this.rear;
    this.rear = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  public void clear()
  {
    Arrays.fill(this.elementData, 0);
    this.front = 0;
    this.rear = 0;
  }
  
  public int element()
  {
    if (empty()) {
      throw new IndexOutOfBoundsException("sequeue is null");
    }
    return this.elementData[this.front];
  }
  
  public boolean empty()
  {
    return this.rear == this.front;
  }
  
  public int length()
  {
    return this.rear - this.front;
  }
  
  public int remove()
  {
    if (empty()) {
      throw new IndexOutOfBoundsException("sequeue is null");
    }
    int i = this.elementData[this.front];
    int[] arrayOfInt = this.elementData;
    int j = this.front;
    this.front = (j + 1);
    arrayOfInt[j] = 0;
    return i;
  }
  
  public String toString()
  {
    if (empty()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = this.front;
    while (i < this.rear)
    {
      localStringBuilder.append(String.valueOf(this.elementData[i]) + ",");
      i += 1;
    }
    i = localStringBuilder.length();
    return "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat.TbsSequenceQueue
 * JD-Core Version:    0.7.0.1
 */