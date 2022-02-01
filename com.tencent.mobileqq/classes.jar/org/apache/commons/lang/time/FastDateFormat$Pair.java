package org.apache.commons.lang.time;

class FastDateFormat$Pair
{
  private final Object mObj1;
  private final Object mObj2;
  
  public FastDateFormat$Pair(Object paramObject1, Object paramObject2)
  {
    this.mObj1 = paramObject1;
    this.mObj2 = paramObject2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Pair)) {
      return false;
    }
    paramObject = (Pair)paramObject;
    Object localObject = this.mObj1;
    if (localObject == null ? paramObject.mObj1 == null : localObject.equals(paramObject.mObj1))
    {
      localObject = this.mObj2;
      if (localObject == null)
      {
        if (paramObject.mObj2 == null) {
          return true;
        }
      }
      else if (localObject.equals(paramObject.mObj2)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = this.mObj1;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.mObj2;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i + j;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[");
    localStringBuffer.append(this.mObj1);
    localStringBuffer.append(':');
    localStringBuffer.append(this.mObj2);
    localStringBuffer.append(']');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.Pair
 * JD-Core Version:    0.7.0.1
 */