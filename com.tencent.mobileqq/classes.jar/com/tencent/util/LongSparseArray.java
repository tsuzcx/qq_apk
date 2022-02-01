package com.tencent.util;

public class LongSparseArray<E>
  implements Cloneable
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = false;
  private long[] jdField_a_of_type_ArrayOfLong;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  
  public LongSparseArray()
  {
    this(10);
  }
  
  public LongSparseArray(int paramInt)
  {
    paramInt = b(paramInt);
    this.jdField_a_of_type_ArrayOfLong = new long[paramInt];
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[paramInt];
    this.jdField_a_of_type_Int = 0;
  }
  
  public static int a(int paramInt)
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
  
  public static int b(int paramInt)
  {
    return a(paramInt * 8) / 8;
  }
  
  private void b()
  {
    int m = this.jdField_a_of_type_Int;
    long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != jdField_a_of_type_JavaLangObject)
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = j;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    return this.jdField_a_of_type_Int;
  }
  
  public long a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    return this.jdField_a_of_type_ArrayOfLong[paramInt];
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
        localLongSparseArray.jdField_a_of_type_ArrayOfLong = ((long[])this.jdField_a_of_type_ArrayOfLong.clone());
        localLongSparseArray.jdField_a_of_type_ArrayOfJavaLangObject = ((Object[])this.jdField_a_of_type_ArrayOfJavaLangObject.clone());
        return localLongSparseArray;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
    }
    return null;
  }
  
  public E a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    return this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt];
  }
  
  public E a(long paramLong)
  {
    return a(paramLong, null);
  }
  
  public E a(long paramLong, E paramE)
  {
    int i = a(this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_Int, paramLong);
    if (i >= 0)
    {
      Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
      if (arrayOfObject[i] == jdField_a_of_type_JavaLangObject) {
        return paramE;
      }
      return arrayOfObject[i];
    }
    return paramE;
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    Object localObject1 = arrayOfObject[paramInt];
    Object localObject2 = jdField_a_of_type_JavaLangObject;
    if (localObject1 != localObject2)
    {
      arrayOfObject[paramInt] = localObject2;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(long paramLong)
  {
    int i = a(this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_Int, paramLong);
    if (i >= 0)
    {
      Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
      Object localObject1 = arrayOfObject[i];
      Object localObject2 = jdField_a_of_type_JavaLangObject;
      if (localObject1 != localObject2)
      {
        arrayOfObject[i] = localObject2;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void a(long paramLong, E paramE)
  {
    int i = a(this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_Int, paramLong);
    if (i >= 0)
    {
      this.jdField_a_of_type_ArrayOfJavaLangObject[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    Object localObject1;
    if (j < this.jdField_a_of_type_Int)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangObject;
      if (localObject1[j] == jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ArrayOfLong[j] = paramLong;
        localObject1[j] = paramE;
        return;
      }
    }
    i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      i = j;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfLong.length)
      {
        b();
        i = a(this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_Int, paramLong) ^ 0xFFFFFFFF;
      }
    }
    j = this.jdField_a_of_type_Int;
    if (j >= this.jdField_a_of_type_ArrayOfLong.length)
    {
      j = b(j + 1);
      localObject1 = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject2 = this.jdField_a_of_type_ArrayOfLong;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.jdField_a_of_type_ArrayOfJavaLangObject;
      System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
      this.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
      this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
    }
    j = this.jdField_a_of_type_Int;
    if (j - i != 0)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfLong;
      int k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j - i);
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangObject;
      System.arraycopy(localObject1, i, localObject1, k, this.jdField_a_of_type_Int - i);
    }
    this.jdField_a_of_type_ArrayOfLong[i] = paramLong;
    this.jdField_a_of_type_ArrayOfJavaLangObject[i] = paramE;
    this.jdField_a_of_type_Int += 1;
  }
  
  public void b(long paramLong)
  {
    a(paramLong);
  }
  
  public void b(long paramLong, E paramE)
  {
    int i = this.jdField_a_of_type_Int;
    if ((i != 0) && (paramLong <= this.jdField_a_of_type_ArrayOfLong[(i - 1)]))
    {
      a(paramLong, paramE);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfLong.length)) {
      b();
    }
    i = this.jdField_a_of_type_Int;
    if (i >= this.jdField_a_of_type_ArrayOfLong.length)
    {
      int j = b(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = this.jdField_a_of_type_ArrayOfLong;
      System.arraycopy(localObject, 0, arrayOfLong, 0, localObject.length);
      localObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      this.jdField_a_of_type_ArrayOfLong = arrayOfLong;
      this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
    }
    this.jdField_a_of_type_ArrayOfLong[i] = paramLong;
    this.jdField_a_of_type_ArrayOfJavaLangObject[i] = paramE;
    this.jdField_a_of_type_Int = (i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.LongSparseArray
 * JD-Core Version:    0.7.0.1
 */