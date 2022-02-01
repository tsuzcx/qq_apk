package com.tencent.mtt.supportui.utils.struct;

import java.util.Map;

public class SimpleArrayMap<K, V>
{
  static Object[] b;
  static int c;
  static Object[] d;
  static int e;
  int[] f;
  Object[] g;
  int h;
  
  public SimpleArrayMap()
  {
    this.f = ContainerHelpers.a;
    this.g = ContainerHelpers.c;
    this.h = 0;
  }
  
  public SimpleArrayMap(int paramInt)
  {
    if (paramInt == 0)
    {
      this.f = ContainerHelpers.a;
      this.g = ContainerHelpers.c;
    }
    else
    {
      a(paramInt);
    }
    this.h = 0;
  }
  
  public SimpleArrayMap(SimpleArrayMap paramSimpleArrayMap)
  {
    this();
    if (paramSimpleArrayMap != null) {
      putAll(paramSimpleArrayMap);
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (d != null)
        {
          Object[] arrayOfObject1 = d;
          this.g = arrayOfObject1;
          d = (Object[])arrayOfObject1[0];
          this.f = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          e -= 1;
          return;
        }
      }
      finally {}
    } else if (paramInt == 4) {
      try
      {
        if (b != null)
        {
          Object[] arrayOfObject2 = b;
          this.g = arrayOfObject2;
          b = (Object[])arrayOfObject2[0];
          this.f = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          c -= 1;
          return;
        }
      }
      finally {}
    }
    this.f = new int[paramInt];
    this.g = new Object[paramInt << 1];
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (e < 10)
        {
          paramArrayOfObject[0] = d;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label118;
          d = paramArrayOfObject;
          e += 1;
        }
        return;
      }
      finally {}
    } else if (paramArrayOfInt.length != 4) {}
    for (;;)
    {
      try
      {
        if (c < 10)
        {
          paramArrayOfObject[0] = b;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          b = paramArrayOfObject;
          c += 1;
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
    int j = this.h;
    if (j == 0) {
      return -1;
    }
    int k = ContainerHelpers.a(this.f, j, 0);
    if (k < 0) {
      return k;
    }
    if (this.g[(k << 1)] == null) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.f[i] == 0))
    {
      if (this.g[(i << 1)] == null) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.f[j] == 0))
    {
      if (this.g[(j << 1)] == null) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  int a(Object paramObject)
  {
    int j = this.h * 2;
    Object[] arrayOfObject = this.g;
    if (paramObject == null)
    {
      i = 1;
      while (i < j)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    int i = 1;
    while (i < j)
    {
      if (paramObject.equals(arrayOfObject[i])) {
        return i >> 1;
      }
      i += 2;
    }
    return -1;
  }
  
  int a(Object paramObject, int paramInt)
  {
    int j = this.h;
    if (j == 0) {
      return -1;
    }
    int k = ContainerHelpers.a(this.f, j, paramInt);
    if (k < 0) {
      return k;
    }
    if (paramObject.equals(this.g[(k << 1)])) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.f[i] == paramInt))
    {
      if (paramObject.equals(this.g[(i << 1)])) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.f[j] == paramInt))
    {
      if (paramObject.equals(this.g[(j << 1)])) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public void clear()
  {
    int i = this.h;
    if (i != 0)
    {
      a(this.f, this.g, i);
      this.f = ContainerHelpers.a;
      this.g = ContainerHelpers.c;
      this.h = 0;
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    if (paramObject == null)
    {
      if (a() >= 0) {
        return true;
      }
    }
    else if (a(paramObject, paramObject.hashCode()) >= 0) {
      return true;
    }
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return a(paramObject) >= 0;
  }
  
  public void ensureCapacity(int paramInt)
  {
    int[] arrayOfInt = this.f;
    if (arrayOfInt.length < paramInt)
    {
      Object[] arrayOfObject = this.g;
      a(paramInt);
      paramInt = this.h;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.f, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.g, 0, this.h << 1);
      }
      a(arrayOfInt, arrayOfObject, this.h);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int i;
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.h)
      {
        Object localObject1 = keyAt(i);
        Object localObject2 = valueAt(i);
        Object localObject3 = paramObject.get(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label119;
          }
          if (!paramObject.containsKey(localObject1)) {
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
    return false;
    label119:
    return false;
  }
  
  public V get(Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = a();
    } else {
      i = a(paramObject, paramObject.hashCode());
    }
    if (i >= 0) {
      return this.g[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.f;
    Object[] arrayOfObject = this.g;
    int n = this.h;
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
  
  public boolean isEmpty()
  {
    return this.h <= 0;
  }
  
  public K keyAt(int paramInt)
  {
    return this.g[(paramInt << 1)];
  }
  
  public V put(K paramK, V paramV)
  {
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
    if (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.g;
      localObject = paramK[i];
      paramK[i] = paramV;
      return localObject;
    }
    int k = i ^ 0xFFFFFFFF;
    int m = this.h;
    if (m >= this.f.length)
    {
      i = 4;
      if (m >= 8) {
        i = (m >> 1) + m;
      } else if (m >= 4) {
        i = 8;
      }
      localObject = this.f;
      Object[] arrayOfObject = this.g;
      a(i);
      int[] arrayOfInt = this.f;
      if (arrayOfInt.length > 0)
      {
        System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.g, 0, arrayOfObject.length);
      }
      a((int[])localObject, arrayOfObject, this.h);
    }
    int i = this.h;
    if (k < i)
    {
      localObject = this.f;
      m = k + 1;
      System.arraycopy(localObject, k, localObject, m, i - k);
      localObject = this.g;
      System.arraycopy(localObject, k << 1, localObject, m << 1, this.h - k << 1);
    }
    this.f[k] = j;
    Object localObject = this.g;
    i = k << 1;
    localObject[i] = paramK;
    localObject[(i + 1)] = paramV;
    this.h += 1;
    return null;
  }
  
  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap)
  {
    int j = paramSimpleArrayMap.h;
    ensureCapacity(this.h + j);
    int k = this.h;
    int i = 0;
    if (k == 0)
    {
      if (j > 0)
      {
        System.arraycopy(paramSimpleArrayMap.f, 0, this.f, 0, j);
        System.arraycopy(paramSimpleArrayMap.g, 0, this.g, 0, j << 1);
        this.h = j;
      }
    }
    else {
      while (i < j)
      {
        put(paramSimpleArrayMap.keyAt(i), paramSimpleArrayMap.valueAt(i));
        i += 1;
      }
    }
  }
  
  public V remove(Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = a();
    } else {
      i = a(paramObject, paramObject.hashCode());
    }
    if (i >= 0) {
      return removeAt(i);
    }
    return null;
  }
  
  public V removeAt(int paramInt)
  {
    Object localObject = this.g;
    int j = paramInt << 1;
    V ? = localObject[(j + 1)];
    int k = this.h;
    if (k <= 1)
    {
      a(this.f, (Object[])localObject, k);
      this.f = ContainerHelpers.a;
      this.g = ContainerHelpers.c;
      this.h = 0;
      return ?;
    }
    localObject = this.f;
    int m = localObject.length;
    int i = 8;
    if ((m > 8) && (k < localObject.length / 3))
    {
      if (k > 8) {
        i = k + (k >> 1);
      }
      localObject = this.f;
      Object[] arrayOfObject = this.g;
      a(i);
      this.h -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(localObject, 0, this.f, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.g, 0, j);
      }
      i = this.h;
      if (paramInt < i)
      {
        k = paramInt + 1;
        System.arraycopy(localObject, k, this.f, paramInt, i - paramInt);
        System.arraycopy(arrayOfObject, k << 1, this.g, j, this.h - paramInt << 1);
        return ?;
      }
    }
    else
    {
      this.h -= 1;
      i = this.h;
      if (paramInt < i)
      {
        localObject = this.f;
        k = paramInt + 1;
        System.arraycopy(localObject, k, localObject, paramInt, i - paramInt);
        localObject = this.g;
        System.arraycopy(localObject, k << 1, localObject, j, this.h - paramInt << 1);
      }
      localObject = this.g;
      paramInt = this.h;
      localObject[(paramInt << 1)] = null;
      localObject[((paramInt << 1) + 1)] = null;
    }
    return ?;
  }
  
  public V setValueAt(int paramInt, V paramV)
  {
    paramInt = (paramInt << 1) + 1;
    Object[] arrayOfObject = this.g;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramV;
    return localObject;
  }
  
  public int size()
  {
    return this.h;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.h * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.h)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = keyAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      localStringBuilder.append('=');
      localObject = valueAt(i);
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
  
  public V valueAt(int paramInt)
  {
    return this.g[((paramInt << 1) + 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.SimpleArrayMap
 * JD-Core Version:    0.7.0.1
 */