package com.tencent.mobileqq.kandian.base.image.imageloader;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class RIJImageOptLinkedBlockingDeque
  extends LinkedBlockingDeque
{
  public RIJImageOptLinkedBlockingDeque(int paramInt)
  {
    super(paramInt);
  }
  
  public Object poll()
  {
    return pollLast();
  }
  
  public Object poll(long paramLong, TimeUnit paramTimeUnit)
  {
    return pollLast(paramLong, paramTimeUnit);
  }
  
  public Object take()
  {
    return takeLast();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptLinkedBlockingDeque
 * JD-Core Version:    0.7.0.1
 */