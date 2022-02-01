package rx;

class BackpressureOverflow$DropOldest
  implements BackpressureOverflow.Strategy
{
  static final DropOldest INSTANCE = new DropOldest();
  
  public boolean mayAttemptDrop()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.BackpressureOverflow.DropOldest
 * JD-Core Version:    0.7.0.1
 */