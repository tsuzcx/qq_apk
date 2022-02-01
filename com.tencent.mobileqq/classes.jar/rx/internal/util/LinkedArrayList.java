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
    Object[] arrayOfObject;
    if (this.size == 0)
    {
      this.head = new Object[this.capacityHint + 1];
      arrayOfObject = this.head;
      this.tail = arrayOfObject;
      arrayOfObject[0] = paramObject;
      this.indexInTail = 1;
      this.size = 1;
      return;
    }
    int i = this.indexInTail;
    int j = this.capacityHint;
    if (i == j)
    {
      arrayOfObject = new Object[j + 1];
      arrayOfObject[0] = paramObject;
      this.tail[j] = arrayOfObject;
      this.tail = arrayOfObject;
      this.indexInTail = 1;
      this.size += 1;
      return;
    }
    this.tail[i] = paramObject;
    this.indexInTail = (i + 1);
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
    int k;
    for (int i = 0;; i = k)
    {
      int j = 0;
      int m;
      do
      {
        if (i >= i1) {
          break;
        }
        localArrayList.add(arrayOfObject[j]);
        k = i + 1;
        m = j + 1;
        i = k;
        j = m;
      } while (m != n);
      arrayOfObject = (Object[])arrayOfObject[n];
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return toList().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.LinkedArrayList
 * JD-Core Version:    0.7.0.1
 */