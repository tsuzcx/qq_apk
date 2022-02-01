package rx.schedulers;

public class TimeInterval<T>
{
  private final long intervalInMilliseconds;
  private final T value;
  
  public TimeInterval(long paramLong, T paramT)
  {
    this.value = paramT;
    this.intervalInMilliseconds = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (TimeInterval)paramObject;
    if (this.intervalInMilliseconds != paramObject.intervalInMilliseconds) {
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
  
  public long getIntervalInMilliseconds()
  {
    return this.intervalInMilliseconds;
  }
  
  public T getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    long l = this.intervalInMilliseconds;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TimeInterval [intervalInMilliseconds=");
    localStringBuilder.append(this.intervalInMilliseconds);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.schedulers.TimeInterval
 * JD-Core Version:    0.7.0.1
 */