package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;

class IteratorStream<R>
  extends Stream<R>
{
  public IteratorStream(Iterator<R> paramIterator)
  {
    AssertUtils.checkNotNull(paramIterator);
    attachDataSupplier(new IteratorStream.IteratorDataPusher(paramIterator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.reactive.IteratorStream
 * JD-Core Version:    0.7.0.1
 */