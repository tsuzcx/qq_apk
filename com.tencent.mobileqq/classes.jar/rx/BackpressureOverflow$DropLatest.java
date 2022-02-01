package rx;

class BackpressureOverflow$DropLatest
  implements BackpressureOverflow.Strategy
{
  static final DropLatest INSTANCE = new DropLatest();
  
  public boolean mayAttemptDrop()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.BackpressureOverflow.DropLatest
 * JD-Core Version:    0.7.0.1
 */