package rx.internal.util;

import java.util.ArrayList;
import java.util.List;

public class LinkedArrayList
{
  final int capacityHint;
  Object[] head;
  int indexInTail;
  volatile int size;
  Object[] tail;
  
  public LinkedArrayList(int paramInt)
  {
    this.capacityHint = paramInt;
  }
  
  public void add(Object paramObject)
  {
    if (this.size == 0)
    {
      this.head = new Object[this.capacityHint + 1];
      this.tail = this.head;
      this.head[0] = paramObject;
      this.indexInTail = 1;
      this.size = 1;
      return;
    }
    if (this.indexInTail == this.capacityHint)
    {
      Object[] arrayOfObject = new Object[this.capacityHint + 1];
      arrayOfObject[0] = paramObject;
      this.tail[this.capacityHint] = arrayOfObject;
      this.tail = arrayOfObject;
      this.indexInTail = 1;
      this.size += 1;
      return;
    }
    this.tail[this.indexInTail] = paramObject;
    this.indexInTail += 1;
    this.size += 1;
  }
  
  public int capacityHint()
  {
    return this.capacityHint;
  }
  
  public Object[] head()
  {
    return this.head;
  }
  
  public int indexInTail()
  {
    return this.indexInTail;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public Object[] tail()
  {
    return this.tail;
  }
  
  List<Object> toList()
  {
    int n = this.capacityHint;
    int i1 = this.size;
    ArrayList localArrayList = new ArrayList(i1 + 1);
    Object[] arrayOfObject = head();
    int j = 0;
    int i = 0;
    while (j < i1)
    {
      localArrayList.add(arrayOfObject[i]);
      int k = j + 1;
      int m = i + 1;
      i = m;
      j = k;
      if (m == n)
      {
        arrayOfObject = (Object[])arrayOfObject[n];
        i = 0;
        j = k;
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return toList().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.LinkedArrayList
 * JD-Core Version:    0.7.0.1
 */