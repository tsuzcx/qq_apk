package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;

class IteratorStream<R>
  extends Stream<R>
{
  public IteratorStream(Iterator<R> paramIterator)
  {
    AssertUtils.checkNotNull(paramIterator);
    attachDataSupplier(new IteratorDataPusher(paramIterator));
  }
  
  private static class IteratorDataPusher<R>
    extends BaseDataPusher<R>
  {
    private final Iterator<R> mIterator;
    
    public IteratorDataPusher(Iterator<R> paramIterator)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.reactive.IteratorStream
 * JD-Core Version:    0.7.0.1
 */