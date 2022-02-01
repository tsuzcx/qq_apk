package com.tencent.mobileqq.utils.palette;

import android.support.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V>
{
  static int jdField_a_of_type_Int;
  @Nullable
  static Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  static int jdField_b_of_type_Int;
  @Nullable
  static Object[] jdField_b_of_type_ArrayOfJavaLangObject;
  int[] jdField_a_of_type_ArrayOfInt = ContainerHelpers.jdField_a_of_type_ArrayOfInt;
  int jdField_c_of_type_Int = 0;
  Object[] jdField_c_of_type_ArrayOfJavaLangObject = ContainerHelpers.jdField_a_of_type_ArrayOfJavaLangObject;
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = ContainerHelpers.a(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      label9:
      break label9;
    }
    throw new ConcurrentModificationException();
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (jdField_b_of_type_ArrayOfJavaLangObject != null)
        {
          Object[] arrayOfObject1 = jdField_b_of_type_ArrayOfJavaLangObject;
          this.jdField_c_of_type_ArrayOfJavaLangObject = arrayOfObject1;
          jdField_b_of_type_ArrayOfJavaLangObject = (Object[])arrayOfObject1[0];
          this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          jdField_b_of_type_Int -= 1;
          return;
        }
      }
      finally {}
    } else if (paramInt == 4) {
      try
      {
        if (jdField_a_of_type_ArrayOfJavaLangObject != null)
        {
          Object[] arrayOfObject2 = jdField_a_of_type_ArrayOfJavaLangObject;
          this.jdField_c_of_type_ArrayOfJavaLangObject = arrayOfObject2;
          jdField_a_of_type_ArrayOfJavaLangObject = (Object[])arrayOfObject2[0];
          this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          jdField_a_of_type_Int -= 1;
          return;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ArrayOfInt = new int[paramInt];
    this.jdField_c_of_type_ArrayOfJavaLangObject = new Object[paramInt << 1];
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (jdField_b_of_type_Int < 10)
        {
          paramArrayOfObject[0] = jdField_b_of_type_ArrayOfJavaLangObject;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label118;
          jdField_b_of_type_ArrayOfJavaLangObject = paramArrayOfObject;
          jdField_b_of_type_Int += 1;
        }
        return;
      }
      finally {}
    } else if (paramArrayOfInt.length != 4) {}
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Int < 10)
        {
          paramArrayOfObject[0] = jdField_a_of_type_ArrayOfJavaLangObject;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          jdField_a_of_type_ArrayOfJavaLangObject = paramArrayOfObject;
          jdField_a_of_type_Int += 1;
        }
        return;
      }
      finally {}
      return;
      label118:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  int a()
  {
    int j = this.jdField_c_of_type_Int;
    if (j == 0) {
      return -1;
    }
    int k = a(this.jdField_a_of_type_ArrayOfInt, j, 0);
    if (k < 0) {
      return k;
    }
    if (this.jdField_c_of_type_ArrayOfJavaLangObject[(k << 1)] == null) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.jdField_a_of_type_ArrayOfInt[i] == 0))
    {
      if (this.jdField_c_of_type_ArrayOfJavaLangObject[(i << 1)] == null) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.jdField_a_of_type_ArrayOfInt[j] == 0))
    {
      if (this.jdField_c_of_type_ArrayOfJavaLangObject[(j << 1)] == null) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public int a(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    return a(paramObject, paramObject.hashCode());
  }
  
  int a(Object paramObject, int paramInt)
  {
    int j = this.jdField_c_of_type_Int;
    if (j == 0) {
      return -1;
    }
    int k = a(this.jdField_a_of_type_ArrayOfInt, j, paramInt);
    if (k < 0) {
      return k;
    }
    if (paramObject.equals(this.jdField_c_of_type_ArrayOfJavaLangObject[(k << 1)])) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.jdField_a_of_type_ArrayOfInt[i] == paramInt))
    {
      if (paramObject.equals(this.jdField_c_of_type_ArrayOfJavaLangObject[(i << 1)])) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.jdField_a_of_type_ArrayOfInt[j] == paramInt))
    {
      if (paramObject.equals(this.jdField_c_of_type_ArrayOfJavaLangObject[(j << 1)])) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public K a(int paramInt)
  {
    return this.jdField_c_of_type_ArrayOfJavaLangObject[(paramInt << 1)];
  }
  
  @Nullable
  public V a(Object paramObject)
  {
    return a(paramObject, null);
  }
  
  public V a(Object paramObject, V paramV)
  {
    int i = a(paramObject);
    if (i >= 0) {
      paramV = this.jdField_c_of_type_ArrayOfJavaLangObject[((i << 1) + 1)];
    }
    return paramV;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Int <= 0;
  }
  
  public boolean a(@Nullable Object paramObject)
  {
    return a(paramObject) >= 0;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public V b(int paramInt)
  {
    return this.jdField_c_of_type_ArrayOfJavaLangObject[((paramInt << 1) + 1)];
  }
  
  @Nullable
  public V b(K paramK, V paramV)
  {
    int k = this.jdField_c_of_type_Int;
    int j;
    if (paramK == null)
    {
      i = a();
      j = 0;
    }
    else
    {
      j = paramK.hashCode();
      i = a(paramK, j);
    }
    Object localObject;
    if (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.jdField_c_of_type_ArrayOfJavaLangObject;
      localObject = paramK[i];
      paramK[i] = paramV;
      return localObject;
    }
    int m = i ^ 0xFFFFFFFF;
    if (k >= this.jdField_a_of_type_ArrayOfInt.length)
    {
      i = 4;
      if (k >= 8) {
        i = (k >> 1) + k;
      } else if (k >= 4) {
        i = 8;
      }
      localObject = this.jdField_a_of_type_ArrayOfInt;
      Object[] arrayOfObject = this.jdField_c_of_type_ArrayOfJavaLangObject;
      a(i);
      if (k == this.jdField_c_of_type_Int)
      {
        int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        if (arrayOfInt.length > 0)
        {
          System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
          System.arraycopy(arrayOfObject, 0, this.jdField_c_of_type_ArrayOfJavaLangObject, 0, arrayOfObject.length);
        }
        a((int[])localObject, arrayOfObject, k);
      }
      else
      {
        throw new ConcurrentModificationException();
      }
    }
    if (m < k)
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      i = m + 1;
      System.arraycopy(localObject, m, localObject, i, k - m);
      localObject = this.jdField_c_of_type_ArrayOfJavaLangObject;
      System.arraycopy(localObject, m << 1, localObject, i << 1, this.jdField_c_of_type_Int - m << 1);
    }
    int i = this.jdField_c_of_type_Int;
    if (k == i)
    {
      localObject = this.jdField_a_of_type_ArrayOfInt;
      if (m < localObject.length)
      {
        localObject[m] = j;
        localObject = this.jdField_c_of_type_ArrayOfJavaLangObject;
        j = m << 1;
        localObject[j] = paramK;
        localObject[(j + 1)] = paramV;
        this.jdField_c_of_type_Int = (i + 1);
        return null;
      }
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int i;
    if ((paramObject instanceof SimpleArrayMap))
    {
      paramObject = (SimpleArrayMap)paramObject;
      if (b() != paramObject.b()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.jdField_c_of_type_Int)
      {
        localObject1 = a(i);
        localObject2 = b(i);
        localObject3 = paramObject.a(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label223;
          }
          if (!paramObject.a(localObject1)) {
            return false;
          }
        }
        else
        {
          bool = localObject2.equals(localObject3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramObject)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      boolean bool;
      return false;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (b() != paramObject.size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.jdField_c_of_type_Int)
      {
        localObject1 = a(i);
        localObject2 = b(i);
        localObject3 = paramObject.get(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label225;
          }
          if (!paramObject.containsKey(localObject1)) {
            return false;
          }
        }
        else
        {
          bool = localObject2.equals(localObject3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramObject)
    {
      return false;
    }
    return false;
    label223:
    return false;
    label225:
    return false;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    Object[] arrayOfObject = this.jdField_c_of_type_ArrayOfJavaLangObject;
    int n = this.jdField_c_of_type_Int;
    int j = 0;
    int k = 0;
    int i = 1;
    while (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      int m;
      if (localObject == null) {
        m = 0;
      } else {
        m = localObject.hashCode();
      }
      k += (m ^ i1);
      j += 1;
      i += 2;
    }
    return k;
  }
  
  public String toString()
  {
    if (a()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_c_of_type_Int * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.jdField_c_of_type_Int)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = a(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      localStringBuilder.append('=');
      localObject = b(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.SimpleArrayMap
 * JD-Core Version:    0.7.0.1
 */