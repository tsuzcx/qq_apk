package rx.schedulers;

public final class Timestamped<T>
{
  private final long timestampMillis;
  private final T value;
  
  public Timestamped(long paramLong, T paramT)
  {
    this.value = paramT;
    this.timestampMillis = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Timestamped)) {
      return false;
    }
    paramObject = (Timestamped)paramObject;
    if (this.timestampMillis != paramObject.timestampMillis) {
      return false;
    }
    Object localObject = this.value;
    if (localObject == null)
    {
      if (paramObject.value != null) {
        return false;
      }
    }
    else if (!localObject.equals(paramObject.value)) {
      return false;
    }
    return true;
  }
  
  public long getTimestampMillis()
  {
    return this.timestampMillis;
  }
  
  public T getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    long l = this.timestampMillis;
    int j = (int)(l ^ l >>> 32);
    Object localObject = this.value;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    return (j + 31) * 31 + i;
  }
  
  public String toString()
  {
    return String.format("Timestamped(timestampMillis = %d, value = %s)", new Object[] { Long.valueOf(this.timestampMillis), this.value.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.schedulers.Timestamped
 * JD-Core Version:    0.7.0.1
 */