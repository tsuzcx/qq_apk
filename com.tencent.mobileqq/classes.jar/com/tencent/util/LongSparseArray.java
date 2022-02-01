package com.tencent.util;

public class LongSparseArray<E>
  implements Cloneable
{
  private static final Object a = new Object();
  private boolean b = false;
  private long[] c;
  private Object[] d;
  private int e;
  
  public LongSparseArray()
  {
    this(10);
  }
  
  public LongSparseArray(int paramInt)
  {
    paramInt = e(paramInt);
    this.c = new long[paramInt];
    this.d = new Object[paramInt];
    this.e = 0;
  }
  
  private static int a(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    int j = paramInt2 + paramInt1;
    paramInt2 = paramInt1 - 1;
    paramInt1 = j;
    while (paramInt1 - paramInt2 > 1)
    {
      int i = (paramInt1 + paramInt2) / 2;
      if (paramArrayOfLong[i] < paramLong) {
        paramInt2 = i;
      } else {
        paramInt1 = i;
      }
    }
    if (paramInt1 == j) {
      return j ^ 0xFFFFFFFF;
    }
    if (paramArrayOfLong[paramInt1] == paramLong) {
      return paramInt1;
    }
    return paramInt1 ^ 0xFFFFFFFF;
  }
  
  public static int d(int paramInt)
  {
    int i = 4;
    while (i < 32)
    {
      int j = (1 << i) - 12;
      if (paramInt <= j) {
        return j;
      }
      i += 1;
    }
    return paramInt;
  }
  
  private void d()
  {
    int m = this.e;
    long[] arrayOfLong = this.c;
    Object[] arrayOfObject = this.d;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != a)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.b = false;
    this.e = j;
  }
  
  public static int e(int paramInt)
  {
    return d(paramInt * 8) / 8;
  }
  
  public LongSparseArray<E> a()
  {
    for (;;)
    {
      try
      {
        localLongSparseArray = (LongSparseArray)super.clone();
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        LongSparseArray localLongSparseArray;
        continue;
        return localCloneNotSupportedException1;
      }
      try
      {
        localLongSparseArray.c = ((long[])this.c.clone());
        localLongSparseArray.d = ((Object[])this.d.clone());
        return localLongSparseArray;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
    }
    return null;
  }
  
  public E a(long paramLong)
  {
    return a(paramLong, null);
  }
  
  public E a(long paramLong, E paramE)
  {
    int i = a(this.c, 0, this.e, paramLong);
    if (i >= 0)
    {
      Object[] arrayOfObject = this.d;
      if (arrayOfObject[i] == a) {
        return paramE;
      }
      return arrayOfObject[i];
    }
    return paramE;
  }
  
  public void a(int paramInt)
  {
    Object[] arrayOfObject = this.d;
    Object localObject1 = arrayOfObject[paramInt];
    Object localObject2 = a;
    if (localObject1 != localObject2)
    {
      arrayOfObject[paramInt] = localObject2;
      this.b = true;
    }
  }
  
  public int b()
  {
    if (this.b) {
      d();
    }
    return this.e;
  }
  
  public long b(int paramInt)
  {
    if (this.b) {
      d();
    }
    return this.c[paramInt];
  }
  
  public void b(long paramLong)
  {
    int i = a(this.c, 0, this.e, paramLong);
    if (i >= 0)
    {
      Object[] arrayOfObject = this.d;
      Object localObject1 = arrayOfObject[i];
      Object localObject2 = a;
      if (localObject1 != localObject2)
      {
        arrayOfObject[i] = localObject2;
        this.b = true;
      }
    }
  }
  
  public void b(long paramLong, E paramE)
  {
    int i = a(this.c, 0, this.e, paramLong);
    if (i >= 0)
    {
      this.d[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    Object localObject1;
    if (j < this.e)
    {
      localObject1 = this.d;
      if (localObject1[j] == a)
      {
        this.c[j] = paramLong;
        localObject1[j] = paramE;
        return;
      }
    }
    i = j;
    if (this.b)
    {
      i = j;
      if (this.e >= this.c.length)
      {
        d();
        i = a(this.c, 0, this.e, paramLong) ^ 0xFFFFFFFF;
      }
    }
    j = this.e;
    if (j >= this.c.length)
    {
      j = e(j + 1);
      localObject1 = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject2 = this.c;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.d;
      System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
      this.c = ((long[])localObject1);
      this.d = arrayOfObject;
    }
    j = this.e;
    if (j - i != 0)
    {
      localObject1 = this.c;
      int k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j - i);
      localObject1 = this.d;
      System.arraycopy(localObject1, i, localObject1, k, this.e - i);
    }
    this.c[i] = paramLong;
    this.d[i] = paramE;
    this.e += 1;
  }
  
  public E c(int paramInt)
  {
    if (this.b) {
      d();
    }
    return this.d[paramInt];
  }
  
  public void c()
  {
    int j = this.e;
    Object[] arrayOfObject = this.d;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.e = 0;
    this.b = false;
  }
  
  public void c(long paramLong)
  {
    b(paramLong);
  }
  
  public void c(long paramLong, E paramE)
  {
    int i = this.e;
    if ((i != 0) && (paramLong <= this.c[(i - 1)]))
    {
      b(paramLong, paramE);
      return;
    }
    if ((this.b) && (this.e >= this.c.length)) {
      d();
    }
    i = this.e;
    if (i >= this.c.length)
    {
      int j = e(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = this.c;
      System.arraycopy(localObject, 0, arrayOfLong, 0, localObject.length);
      localObject = this.d;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      this.c = arrayOfLong;
      this.d = arrayOfObject;
    }
    this.c[i] = paramLong;
    this.d[i] = paramE;
    this.e = (i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.LongSparseArray
 * JD-Core Version:    0.7.0.1
 */