package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;

class IteratorStream$IteratorDataPusher<R>
  extends BaseDataPusher<R>
{
  private final Iterator<R> mIterator;
  
  public IteratorStream$IteratorDataPusher(Iterator<R> paramIterator)
  {
    AssertUtils.checkNotNull(paramIterator);
    this.mIterator = paramIterator;
  }
  
  public void apply(Observer<R> paramObserver)
  {
    super.apply(paramObserver);
    for (;;)
    {
      if ((!this.mIterator.hasNext()) || (isCanceled()))
      {
        paramObserver.onComplete();
        return;
      }
      Object localObject = this.mIterator.next();
      AssertUtils.checkNotNull(localObject);
      paramObserver.onNext(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.reactive.IteratorStream.IteratorDataPusher
 * JD-Core Version:    0.7.0.1
 */