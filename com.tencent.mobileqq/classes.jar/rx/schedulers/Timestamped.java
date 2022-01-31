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
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
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
        if (this.value != null) {
          break;
        }
      } while (paramObject.value == null);
      return false;
    } while (this.value.equals(paramObject.value));
    return false;
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
    int j = (int)(this.timestampMillis ^ this.timestampMillis >>> 32);
    if (this.value == null) {}
    for (int i = 0;; i = this.value.hashCode()) {
      return i + (j + 31) * 31;
    }
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