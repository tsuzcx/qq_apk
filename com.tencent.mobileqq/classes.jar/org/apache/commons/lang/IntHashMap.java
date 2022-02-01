package org.apache.commons.lang;

class IntHashMap
{
  private transient int count;
  private final float loadFactor;
  private transient IntHashMap.Entry[] table;
  private int threshold;
  
  public IntHashMap()
  {
    this(20, 0.75F);
  }
  
  public IntHashMap(int paramInt)
  {
    this(paramInt, 0.75F);
  }
  
  public IntHashMap(int paramInt, float paramFloat)
  {
    if (paramInt >= 0)
    {
      if (paramFloat > 0.0F)
      {
        int i = paramInt;
        if (paramInt == 0) {
          i = 1;
        }
        this.loadFactor = paramFloat;
        this.table = new IntHashMap.Entry[i];
        this.threshold = ((int)(i * paramFloat));
        return;
      }
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("Illegal Load: ");
      localStringBuffer.append(paramFloat);
      throw new IllegalArgumentException(localStringBuffer.toString());
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Illegal Capacity: ");
    localStringBuffer.append(paramInt);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
  
  public void clear()
  {
    int i;
    try
    {
      IntHashMap.Entry[] arrayOfEntry = this.table;
      i = arrayOfEntry.length;
    }
    finally
    {
      break label29;
    }
    this.count = 0;
    return;
    label29:
    for (;;)
    {
      throw localObject;
    }
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      localObject[i] = null;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject != null)
    {
      IntHashMap.Entry[] arrayOfEntry = this.table;
      int j;
      for (int i = arrayOfEntry.length;; i = j)
      {
        j = i - 1;
        if (i <= 0) {
          break;
        }
        for (IntHashMap.Entry localEntry = arrayOfEntry[j]; localEntry != null; localEntry = localEntry.next) {
          if (localEntry.value.equals(paramObject)) {
            return true;
          }
        }
      }
      return false;
    }
    paramObject = new NullPointerException();
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public boolean containsKey(int paramInt)
  {
    Object localObject = this.table;
    for (localObject = localObject[((0x7FFFFFFF & paramInt) % localObject.length)]; localObject != null; localObject = ((IntHashMap.Entry)localObject).next) {
      if (((IntHashMap.Entry)localObject).hash == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return contains(paramObject);
  }
  
  public Object get(int paramInt)
  {
    Object localObject = this.table;
    for (localObject = localObject[((0x7FFFFFFF & paramInt) % localObject.length)]; localObject != null; localObject = ((IntHashMap.Entry)localObject).next) {
      if (((IntHashMap.Entry)localObject).hash == paramInt) {
        return ((IntHashMap.Entry)localObject).value;
      }
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return this.count == 0;
  }
  
  public Object put(int paramInt, Object paramObject)
  {
    Object localObject2 = this.table;
    int j = 0x7FFFFFFF & paramInt;
    int i = j % localObject2.length;
    for (Object localObject1 = localObject2[i]; localObject1 != null; localObject1 = ((IntHashMap.Entry)localObject1).next) {
      if (((IntHashMap.Entry)localObject1).hash == paramInt)
      {
        localObject2 = ((IntHashMap.Entry)localObject1).value;
        ((IntHashMap.Entry)localObject1).value = paramObject;
        return localObject2;
      }
    }
    localObject1 = localObject2;
    if (this.count >= this.threshold)
    {
      rehash();
      localObject1 = this.table;
      i = j % localObject1.length;
    }
    localObject1[i] = new IntHashMap.Entry(paramInt, paramInt, paramObject, localObject1[i]);
    this.count += 1;
    return null;
  }
  
  protected void rehash()
  {
    IntHashMap.Entry[] arrayOfEntry1 = this.table;
    int i = arrayOfEntry1.length;
    int k = i * 2 + 1;
    IntHashMap.Entry[] arrayOfEntry2 = new IntHashMap.Entry[k];
    this.threshold = ((int)(k * this.loadFactor));
    this.table = arrayOfEntry2;
    for (;;)
    {
      int j = i - 1;
      if (i <= 0) {
        break;
      }
      IntHashMap.Entry localEntry;
      for (Object localObject = arrayOfEntry1[j]; localObject != null; localObject = localEntry)
      {
        localEntry = ((IntHashMap.Entry)localObject).next;
        i = (((IntHashMap.Entry)localObject).hash & 0x7FFFFFFF) % k;
        ((IntHashMap.Entry)localObject).next = arrayOfEntry2[i];
        arrayOfEntry2[i] = localObject;
      }
      i = j;
    }
  }
  
  public Object remove(int paramInt)
  {
    IntHashMap.Entry[] arrayOfEntry = this.table;
    int i = (0x7FFFFFFF & paramInt) % arrayOfEntry.length;
    Object localObject1 = arrayOfEntry[i];
    Object localObject2 = null;
    while (localObject1 != null)
    {
      if (((IntHashMap.Entry)localObject1).hash == paramInt)
      {
        if (localObject2 != null) {
          localObject2.next = ((IntHashMap.Entry)localObject1).next;
        } else {
          arrayOfEntry[i] = ((IntHashMap.Entry)localObject1).next;
        }
        this.count -= 1;
        localObject2 = ((IntHashMap.Entry)localObject1).value;
        ((IntHashMap.Entry)localObject1).value = null;
        return localObject2;
      }
      IntHashMap.Entry localEntry = ((IntHashMap.Entry)localObject1).next;
      localObject2 = localObject1;
      localObject1 = localEntry;
    }
    return null;
  }
  
  public int size()
  {
    return this.count;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.IntHashMap
 * JD-Core Version:    0.7.0.1
 */