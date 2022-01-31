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
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
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
        if (this.value != null) {
          break;
        }
      } while (paramObject.value == null);
      return false;
    } while (this.value.equals(paramObject.value));
    return false;
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
    int j = (int)(this.intervalInMilliseconds ^ this.intervalInMilliseconds >>> 32);
    if (this.value == null) {}
    for (int i = 0;; i = this.value.hashCode()) {
      return i + (j + 31) * 31;
    }
  }
  
  public String toString()
  {
    return "TimeInterval [intervalInMilliseconds=" + this.intervalInMilliseconds + ", value=" + this.value + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.schedulers.TimeInterval
 * JD-Core Version:    0.7.0.1
 */