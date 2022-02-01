package com.tribe.async.dispatch;

import com.tribe.async.objectpool.ObjectPool.BasicAllocator;

final class PendingPost$2
  extends ObjectPool.BasicAllocator<PendingPost>
{
  PendingPost$2(Class paramClass)
  {
    super(paramClass);
  }
  
  public PendingPost create()
  {
    return new PendingPost(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.PendingPost.2
 * JD-Core Version:    0.7.0.1
 */