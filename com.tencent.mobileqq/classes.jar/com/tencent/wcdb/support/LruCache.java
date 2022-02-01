package com.tencent.wcdb.support;

import android.annotation.SuppressLint;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LruCache<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public LruCache(int paramInt)
  {
    if (paramInt > 0)
    {
      this.c = paramInt;
      this.a = new LinkedHashMap(0, 0.75F, true);
      return;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private int c(K paramK, V paramV)
  {
    int i = b(paramK, paramV);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Negative size: ");
    localStringBuilder.append(paramK);
    localStringBuilder.append("=");
    localStringBuilder.append(paramV);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public final V a(K paramK)
  {
    if (paramK != null) {
      try
      {
        Object localObject1 = this.a.get(paramK);
        if (localObject1 != null)
        {
          this.g += 1;
          return localObject1;
        }
        this.h += 1;
        localObject1 = c(paramK);
        if (localObject1 == null) {
          return null;
        }
        try
        {
          this.e += 1;
          Object localObject2 = this.a.put(paramK, localObject1);
          if (localObject2 != null) {
            this.a.put(paramK, localObject2);
          } else {
            this.b += c(paramK, localObject1);
          }
          if (localObject2 != null)
          {
            a(false, paramK, localObject1, localObject2);
            return localObject2;
          }
          b(this.c);
          return localObject1;
        }
        finally {}
        throw new NullPointerException("key == null");
      }
      finally {}
    }
  }
  
  public final V a(K paramK, V paramV)
  {
    if ((paramK != null) && (paramV != null)) {
      try
      {
        this.d += 1;
        this.b += c(paramK, paramV);
        Object localObject = this.a.put(paramK, paramV);
        if (localObject != null) {
          this.b -= c(paramK, localObject);
        }
        if (localObject != null) {
          a(false, paramK, localObject, paramV);
        }
        b(this.c);
        return localObject;
      }
      finally {}
    }
    throw new NullPointerException("key == null || value == null");
  }
  
  public final void a()
  {
    b(-1);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      try
      {
        this.c = paramInt;
        b(paramInt);
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  protected void a(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  protected int b(K paramK, V paramV)
  {
    return 1;
  }
  
  public final V b(K paramK)
  {
    if (paramK != null) {
      try
      {
        Object localObject = this.a.remove(paramK);
        if (localObject != null) {
          this.b -= c(paramK, localObject);
        }
        if (localObject != null) {
          a(false, paramK, localObject, null);
        }
        return localObject;
      }
      finally {}
    }
    throw new NullPointerException("key == null");
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.b < 0) || ((this.a.isEmpty()) && (this.b != 0))) {
          break label162;
        }
        if ((this.b <= paramInt) || (this.a.isEmpty())) {
          break;
        }
        if (!this.a.entrySet().iterator().hasNext()) {
          break label212;
        }
        localObject1 = (Map.Entry)this.a.entrySet().iterator().next();
      }
      finally
      {
        for (;;)
        {
          Object localObject1;
          Object localObject4;
          for (;;)
          {
            throw localObject2;
          }
          Object localObject3 = null;
        }
      }
      if (localObject1 == null) {
        return;
      }
      localObject4 = ((Map.Entry)localObject1).getKey();
      localObject1 = ((Map.Entry)localObject1).getValue();
      this.a.remove(localObject4);
      this.b -= c(localObject4, localObject1);
      this.f += 1;
      a(true, localObject4, localObject1, null);
    }
    return;
    label162:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getClass().getName());
    ((StringBuilder)localObject1).append(".sizeOf() is reporting inconsistent results!");
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
  
  protected V c(K paramK)
  {
    return null;
  }
  
  @SuppressLint({"DefaultLocale"})
  public final String toString()
  {
    for (;;)
    {
      try
      {
        i = this.g + this.h;
        if (i != 0)
        {
          i = this.g * 100 / i;
          String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i) });
          return str;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.support.LruCache
 * JD-Core Version:    0.7.0.1
 */