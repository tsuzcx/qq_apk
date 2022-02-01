package io.flutter.embedding.android;

import java.util.concurrent.atomic.AtomicLong;

public class MotionEventTracker$MotionEventId
{
  private static final AtomicLong ID_COUNTER = new AtomicLong(0L);
  private final long id;
  
  private MotionEventTracker$MotionEventId(long paramLong)
  {
    this.id = paramLong;
  }
  
  public static MotionEventId createUnique()
  {
    return from(ID_COUNTER.incrementAndGet());
  }
  
  public static MotionEventId from(long paramLong)
  {
    return new MotionEventId(paramLong);
  }
  
  public long getId()
  {
    return this.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.android.MotionEventTracker.MotionEventId
 * JD-Core Version:    0.7.0.1
 */