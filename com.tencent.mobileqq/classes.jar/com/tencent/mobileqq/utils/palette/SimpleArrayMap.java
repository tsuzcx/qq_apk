package com.tencent.mobileqq.utils.palette;

import android.support.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V>
{
  @Nullable
  static Object[] a;
  static int b;
  @Nullable
  static Object[] c;
  static int d;
  int[] e = ContainerHelpers.a;
  Object[] f = ContainerHelpers.c;
  int g = 0;
  
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
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (d < 10)
        {
          paramArrayOfObject[0] = c;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label118;
          c = paramArrayOfObject;
          d += 1;
        }
        return;
      }
      finally {}
    } else if (paramArrayOfInt.length != 4) {}
    for (;;)
    {
      try
      {
        if (b < 10)
        {
          paramArrayOfObject[0] = a;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          a = paramArrayOfObject;
          b += 1;
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
  
  private boolean a(Map<?, ?> paramMap)
  {
    if (c() != paramMap.size()) {
      return false;
    }
    int i = 0;
    try
    {
      while (i < this.g)
      {
        Object localObject1 = a(i);
        Object localObject2 = b(i);
        Object localObject3 = paramMap.get(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label98;
          }
          if (!paramMap.containsKey(localObject1)) {
            return false;
          }
        }
        else
        {
          boolean bool = localObject2.equals(localObject3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramMap)
    {
      return false;
    }
    label98:
    return false;
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (c != null)
        {
          Object[] arrayOfObject1 = c;
          this.f = arrayOfObject1;
          c = (Object[])arrayOfObject1[0];
          this.e = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          d -= 1;
          return;
        }
      }
      finally {}
    } else if (paramInt == 4) {
      try
      {
        if (a != null)
        {
          Object[] arrayOfObject2 = a;
          this.f = arrayOfObject2;
          a = (Object[])arrayOfObject2[0];
          this.e = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          b -= 1;
          return;
        }
      }
      finally {}
    }
    this.e = new int[paramInt];
    this.f = new Object[paramInt << 1];
  }
  
  int a()
  {
    int j = this.g;
    if (j == 0) {
      return -1;
    }
    int k = a(this.e, j, 0);
    if (k < 0) {
      return k;
    }
    if (this.f[(k << 1)] == null) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.e[i] == 0))
    {
      if (this.f[(i << 1)] == null) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.e[j] == 0))
    {
      if (this.f[(j << 1)] == null) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  int a(Object paramObject, int paramInt)
  {
    int j = this.g;
    if (j == 0) {
      return -1;
    }
    int k = a(this.e, j, paramInt);
    if (k < 0) {
      return k;
    }
    if (paramObject.equals(this.f[(k << 1)])) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.e[i] == paramInt))
    {
      if (paramObject.equals(this.f[(i << 1)])) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.e[j] == paramInt))
    {
      if (paramObject.equals(this.f[(j << 1)])) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public K a(int paramInt)
  {
    return this.f[(paramInt << 1)];
  }
  
  public V a(Object paramObject, V paramV)
  {
    int i = b(paramObject);
    if (i >= 0) {
      paramV = this.f[((i << 1) + 1)];
    }
    return paramV;
  }
  
  public boolean a(@Nullable Object paramObject)
  {
    return b(paramObject) >= 0;
  }
  
  public int b(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    return a(paramObject, paramObject.hashCode());
  }
  
  public V b(int paramInt)
  {
    return this.f[((paramInt << 1) + 1)];
  }
  
  @Nullable
  public V b(K paramK, V paramV)
  {
    int k = this.g;
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
      paramK = this.f;
      localObject = paramK[i];
      paramK[i] = paramV;
      return localObject;
    }
    int m = i ^ 0xFFFFFFFF;
    if (k >= this.e.length)
    {
      i = 4;
      if (k >= 8) {
        i = (k >> 1) + k;
      } else if (k >= 4) {
        i = 8;
      }
      localObject = this.e;
      Object[] arrayOfObject = this.f;
      c(i);
      if (k == this.g)
      {
        int[] arrayOfInt = this.e;
        if (arrayOfInt.length > 0)
        {
          System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
          System.arraycopy(arrayOfObject, 0, this.f, 0, arrayOfObject.length);
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
      localObject = this.e;
      i = m + 1;
      System.arraycopy(localObject, m, localObject, i, k - m);
      localObject = this.f;
      System.arraycopy(localObject, m << 1, localObject, i << 1, this.g - m << 1);
    }
    int i = this.g;
    if (k == i)
    {
      localObject = this.e;
      if (m < localObject.length)
      {
        localObject[m] = j;
        localObject = this.f;
        j = m << 1;
        localObject[j] = paramK;
        localObject[(j + 1)] = paramV;
        this.g = (i + 1);
        return null;
      }
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean b()
  {
    return this.g <= 0;
  }
  
  public int c()
  {
    return this.g;
  }
  
  @Nullable
  public V c(Object paramObject)
  {
    return a(paramObject, null);
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
      if (c() != paramObject.c()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.g)
      {
        Object localObject1 = a(i);
        Object localObject2 = b(i);
        Object localObject3 = paramObject.c(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label129;
          }
          if (!paramObject.a(localObject1)) {
            return false;
          }
        }
        else
        {
          boolean bool = localObject2.equals(localObject3);
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
    if ((paramObject instanceof Map)) {
      return a((Map)paramObject);
    }
    return false;
    label129:
    return false;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.e;
    Object[] arrayOfObject = this.f;
    int n = this.g;
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
    if (b()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.g * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.g)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.SimpleArrayMap
 * JD-Core Version:    0.7.0.1
 */